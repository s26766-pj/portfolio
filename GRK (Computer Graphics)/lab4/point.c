#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

#include <jpeglib.h>
#include <argtable2.h>
#include <string.h>

const char* input_file;
const char* output_file;
const char* filter;
const char* axis;
const char* direction;
double times;
double percent;



/* we will be using this uninitialized pointer later to store raw, uncompressd image */
JSAMPARRAY row_pointers = NULL;


/* dimensions of the image we want to write */
JDIMENSION width;
JDIMENSION height;
int num_components;
int quality = 75;
J_COLOR_SPACE color_space;

void negate() {
    int x, y;
    if (color_space != JCS_RGB)  return;

    for (y = 0; y < height; y++) {
        JSAMPROW row = row_pointers[y];
        for (x = 0; x < width; x++) {
            JSAMPROW ptr = &(row[x * 3]);


            ptr[0] = 255 - ptr[0];
            ptr[1] = 255 - ptr[1];
            ptr[2] = 255 - ptr[2];
        }
    }
}

void contrast() {
    int x, y;


    if (color_space != JCS_RGB) return;

    for (y = 0; y < height; y++) {
        JSAMPROW row = row_pointers[y];
        for (x = 0; x < width; x++) {
            JSAMPROW ptr = &(row[x * 3]);

            for (int c = 0; c < 3; c++) {
                int new_value = times * (ptr[c] - 127) + 127;

                ptr[c] = (new_value < 0) ? 0 : (new_value > 255) ? 255 : new_value;
            }
        }
    }
}

void rotate(const char* direction) {
    int x, y;

    // Sprawdzenie przestrzeni barw
    if (color_space != JCS_RGB) return;

    // Zachowanie starych wskaźników
    JSAMPARRAY old_pointers = row_pointers;
    int old_width = width;
    int old_height = height;

    // Zamiana wymiarów obrazu
    width = old_height;
    height = old_width;

    // Alokacja nowej pamięci dla wierszy
    size_t rowbytes = width * num_components;
    row_pointers = (JSAMPARRAY)malloc(sizeof(JSAMPROW) * height);
    if (!row_pointers) {
        printf("Błąd alokacji pamięci dla row_pointers\n");
        exit(1);
    }

    for (y = 0; y < height; y++) {
        row_pointers[y] = (JSAMPROW)malloc(rowbytes);
        if (!row_pointers[y]) {
            printf("Błąd alokacji pamięci dla row_pointers[%d]\n", y);
            exit(1);
        }
    }

    // Rotacja w zależności od kierunku
    if (strcmp(direction, "right") == 0) {
        // Rotacja w prawo
        for (y = 0; y < height; y++) {
            JSAMPROW new_row = row_pointers[y];
            for (x = 0; x < width; x++) {
                JSAMPROW new_ptr = &(new_row[x * 3]);
                JSAMPROW old_row = old_pointers[old_height - 1 - x];
                JSAMPROW old_ptr = &(old_row[y * 3]);

                new_ptr[0] = old_ptr[0];
                new_ptr[1] = old_ptr[1];
                new_ptr[2] = old_ptr[2];
            }
        }
    }
    else if (strcmp(direction, "left") == 0) {
        // Rotacja w lewo
        for (y = 0; y < height; y++) {
            JSAMPROW new_row = row_pointers[y];
            for (x = 0; x < width; x++) {
                JSAMPROW new_ptr = &(new_row[x * 3]);
                JSAMPROW old_row = old_pointers[x];
                JSAMPROW old_ptr = &(old_row[(old_width - 1 - y) * 3]);

                new_ptr[0] = old_ptr[0];
                new_ptr[1] = old_ptr[1];
                new_ptr[2] = old_ptr[2];
            }
        }
    }
    else {
        printf("Nieznany kierunek rotacji: %s\n", direction);
        exit(1);
    }

    // Zwolnienie starej pamięci
    for (y = 0; y < old_height; y++) {
        free(old_pointers[y]);
    }
    free(old_pointers);
}



void brightness() {
    int x, y;
    double factor = percent / 100.0;

    if (color_space != JCS_RGB) return;

    for (y = 0; y < height; y++) {
        JSAMPROW row = row_pointers[y];
        for (x = 0; x < width; x++) {
            JSAMPROW ptr = &(row[x * 3]);

            for (int c = 0; c < 3; c++) {
                int new_value = ptr[c] + ptr[c] * factor;
                ptr[c] = (new_value < 0) ? 0 : (new_value > 255) ? 255 : new_value;
            }
        }
    }
}

void flip() {
    int x, y;
    if (color_space != JCS_RGB)  return;

    if (strcmp(axis, "y") == 0) {
        printf("flip() - wybrano flip %s:-)\n", axis);
        for (y = 0; y < height; y++) {
            JSAMPROW row = row_pointers[y];
            for (x = 0; x < width / 2; x++) {
                JSAMPROW ptr1 = &(row[x * 3]);
                JSAMPROW ptr2 = &(row[(width - 1 - x) * 3]);

                JSAMPLE tmp;

                tmp = ptr1[0];
                ptr1[0] = ptr2[0];
                ptr2[0] = tmp;

                tmp = ptr1[1];
                ptr1[1] = ptr2[1];
                ptr2[1] = tmp;

                tmp = ptr1[2];
                ptr1[2] = ptr2[2];
                ptr2[2] = tmp;
            }
        }
    }
}

void cleanup() {
    if (row_pointers != NULL) {
        for (int y = 0; y < height; y++) {
            if (row_pointers[y] != NULL) {
                free(row_pointers[y]);
                row_pointers[y] = NULL;
            }
        }
        free(row_pointers);
        row_pointers = NULL;
    }
}


void process_file() {
    if (strcmp(filter, "negate") == 0) {
        printf("Wybrano negate :-)\n");
        negate();
    }
    else if (strcmp(filter, "flip") == 0) {
        printf("Wybrano flip %s :-)\n", axis);
        flip();
    }
    else if (strcmp(filter, "contrast") == 0) {
        printf("Wybrano filtr kontrastu, parametr: %f \n", times);
        contrast();
    }
    else if (strcmp(filter, "brightness") == 0) {
        printf("Zmiana jasnosci o %f \n", percent);
        brightness();
    }
    else if (strcmp(filter, "rotate") == 0) {
        printf("Rotacja. Kierunek: %s \n", direction);
        rotate(direction);
    }
}

void abort_(const char* s, ...)
{
    va_list args;
    va_start(args, s);
    vfprintf(stderr, s, args);
    fprintf(stderr, "\n");
    va_end(args);
    cleanup();
    abort();
}


/**
 * read_jpeg_file Reads from a jpeg file on disk specified by filename and saves into the
 * raw_image buffer in an uncompressed format.
 *
 * \returns positive integer if successful, -1 otherwise
 * \param *filename char string specifying the file name to read from
 *
 */

void read_jpeg_file(const char* filename)
{
    /* these are standard libjpeg structures for reading(decompression) */
    struct jpeg_decompress_struct cinfo;
    struct jpeg_error_mgr jerr;
    /* libjpeg data structure for storing one row, that is, scanline of an image */
    int y;

    FILE* infile = fopen(filename, "rb");

    if (!infile)
    {
        abort_("Error opening input jpeg file %s!\n", filename);
    }
    /* here we set up the standard libjpeg error handler */
    cinfo.err = jpeg_std_error(&jerr);
    jpeg_create_decompress(&cinfo);
    /* this makes the library read from infile */
    jpeg_stdio_src(&cinfo, infile);
    /* reading the image header which contains image information */
    jpeg_read_header(&cinfo, TRUE);


    /* Start decompression jpeg here */
    jpeg_start_decompress(&cinfo);
    width = cinfo.output_width;
    height = cinfo.output_height;
    num_components = cinfo.out_color_components;
    color_space = cinfo.out_color_space;


    /* allocate memory to hold the uncompressed image */
    size_t rowbytes = width * num_components;
    row_pointers = (JSAMPARRAY)malloc(sizeof(j_common_ptr) * height);
    for (y = 0; y < height; y++) {
        row_pointers[y] = (JSAMPROW)malloc(rowbytes);
    }


    /* read one scan line at a time */
    y = 0;
    JSAMPARRAY tmp = row_pointers;
    while (cinfo.output_scanline < cinfo.image_height)
    {
        y = jpeg_read_scanlines(&cinfo, tmp, 1);
        tmp += y;
    }
    /* wrap up decompression, destroy objects, free pointers and close open files */
    jpeg_finish_decompress(&cinfo);
    jpeg_destroy_decompress(&cinfo);
    // free( row_pointer[0] );
    fclose(infile);
    /* yup, we succeeded! */
}




/**
 * write_jpeg_file Writes the raw image data stored in the raw_image buffer
 * to a jpeg image with default compression and smoothing options in the file
 * specified by *filename.
 *
 * \returns positive integer if successful, -1 otherwise
 * \param *filename char string specifying the file name to save to
 *
 */
void write_jpeg_file(const char* filename)
{
    struct jpeg_compress_struct cinfo;
    struct jpeg_error_mgr jerr;
    int y;
    JSAMPARRAY tmp;


    /* this is a pointer to one row of image data */
    FILE* outfile = fopen(filename, "wb");

    if (!outfile) {
        abort_("Error opening output jpeg file %s!\n", filename);
    }
    cinfo.err = jpeg_std_error(&jerr);
    jpeg_create_compress(&cinfo);
    jpeg_stdio_dest(&cinfo, outfile);

    /* Setting the parameters of the output file here */
    cinfo.image_width = width;
    cinfo.image_height = height;
    cinfo.input_components = num_components;
    cinfo.in_color_space = color_space;
    /* default compression parameters, we shouldn't be worried about these */
    jpeg_set_defaults(&cinfo);
    jpeg_set_quality(&cinfo, quality, TRUE);
    /* Now do the compression .. */
    jpeg_start_compress(&cinfo, TRUE);
    /* like reading a file, this time write one row at a time */
    tmp = row_pointers;
    while (cinfo.next_scanline < cinfo.image_height)
    {
        y = jpeg_write_scanlines(&cinfo, tmp, 1);
        tmp += y;
    }
    /* similar to read file, clean up after we're done compressing */
    jpeg_finish_compress(&cinfo);
    jpeg_destroy_compress(&cinfo);
    fclose(outfile);

    /* cleanup heap allocation */
    for (y = 0; y < height; y++) {
        free(row_pointers[y]);
    }
    free(row_pointers);
}




int main(int argc, char** argv) {
    // Opcje
    struct arg_file* input_file_arg = arg_file1("i", "input-file", "<input>", "Input JPEG File");
    struct arg_file* output_file_arg = arg_file1("o", "out-file", "<output>", "Output JPEG File");
    struct arg_str* filter_arg = arg_str1("f", "filter", "<filter>", "Filter");
    struct arg_str* axis_arg = arg_str0("a", "axis", "<axis>", "Axis for flip (x/y)");
    struct arg_str* direction_arg = arg_str0("d", "direction", "<direction>", "Direction for rotation (left/right)");
    struct arg_dbl* times_arg = arg_dbl0("t", "times", "<times>", "Multiplier");
    struct arg_dbl* percent_arg = arg_dbl0("k", "percent", "<percent>", "Percentage brightness change");
    struct arg_lit* help = arg_lit0("h", "help", "print this help and exit");
    struct arg_end* end = arg_end(10); // maksymalna liczba błędów 10

    int nerrors;
    void* argtable[] = { input_file_arg, output_file_arg, filter_arg, axis_arg, direction_arg, times_arg, percent_arg, help, end };

    if (arg_nullcheck(argtable) != 0) {
        fprintf(stderr, "Błąd: Brak wystarczającej pamięci na argumenty.\n");
        return 1;
    }

    // Parsowanie argumentów
    nerrors = arg_parse(argc, argv, argtable);

    // Wyświetlanie pomocy
    if (help->count > 0) {
        printf("Przykład użycia:\n");
        printf("./point.exe -i input.jpeg -o output.jpeg -f rotation -d right\n");
        printf("\n");
        printf("Dostępne filtry: negate, flip, rotation, contrast, brightness\n");
        printf("\n");
        printf("Dostępne opcje:\n");
        arg_print_glossary(stdout, argtable, "  %-25s %s\n");
        arg_freetable(argtable, sizeof(argtable) / sizeof(argtable[0]));
        return 0;
    }

    // Obsługa błędów argumentów
    if (nerrors > 0) {
        arg_print_errors(stderr, end, "point");
        fprintf(stderr, "Użyj -h, aby zobaczyć pomoc.\n");
        arg_freetable(argtable, sizeof(argtable) / sizeof(argtable[0]));
        return 1;
    }

    // Przypisanie wartości argumentów
    input_file = input_file_arg->filename[0];
    output_file = output_file_arg->filename[0];
    filter = filter_arg->sval[0];
    axis = axis_arg->count > 0 ? axis_arg->sval[0] : "y";
    direction = direction_arg->count > 0 ? direction_arg->sval[0] : "right";
    times = times_arg->count > 0 ? times_arg->dval[0] : 1.0;
    percent = percent_arg->count > 0 ? percent_arg->dval[0] : 0.0;

    // Walidacja argumentów
    if (strcmp(direction, "left") != 0 && strcmp(direction, "right") != 0) {
        fprintf(stderr, "Błąd: Nieznany kierunek rotacji '%s'. Dostępne opcje to: 'left' lub 'right'.\n", direction);
        arg_freetable(argtable, sizeof(argtable) / sizeof(argtable[0]));
        return 1;
    }

    if (strcmp(axis, "x") != 0 && strcmp(axis, "y") != 0) {
        fprintf(stderr, "Błąd: Nieznana oś '%s'. Dostępne opcje to: 'x' lub 'y'.\n", axis);
        arg_freetable(argtable, sizeof(argtable) / sizeof(argtable[0]));
        return 1;
    }

    // Wykonanie operacji
    read_jpeg_file(input_file);
    process_file();
    write_jpeg_file(output_file);

    arg_freetable(argtable, sizeof(argtable) / sizeof(argtable[0]));
    return 0;
}
