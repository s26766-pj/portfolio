#include <stdlib.h>
#include <stdio.h>
#include <stdarg.h>
#include <png.h>
#include <cmath>
#include <queue>

#define OUT_FILE "initials.png"
#define WIDTH 600
#define HEIGHT 600
#define COLOR_TYPE PNG_COLOR_TYPE_RGB
#define BIT_DEPTH 8

void abort_(const char *s, ...) {
    va_list args;
    va_start(args, s);
    vfprintf(stderr, s, args);
    fprintf(stderr, "\n");
    va_end(args);
    abort();
}

struct Color {
    png_byte r;
    png_byte g;
    png_byte b;
};

const Color RED = {255, 0, 0};
const Color GREEN = {0, 255, 0};
const Color BLUE = {0, 0, 255};
const Color YELLOW = {255, 255, 0};
const Color CYAN = {0, 255, 255};
const Color MAGENTA = {255, 0, 255};
const Color BLACK = {0, 0, 0};
const Color WHITE = {255, 255, 255};

int width, height;
png_byte color_type;
png_byte bit_depth;
png_structp png_ptr;
png_infop info_ptr;
png_bytep *row_pointers;

int last_x = 0;
int last_y = 0;

void create_png_file() {
    width = WIDTH;
    height = HEIGHT;
    bit_depth = BIT_DEPTH;
    color_type = COLOR_TYPE;

    row_pointers = (png_bytep*) malloc(sizeof(png_bytep) * height);
    for (int y = 0; y < height; y++) {
        row_pointers[y] = (png_byte*) malloc(width * 3);
    }
}

void write_png_file(const char* file_name) {
    FILE *fp = fopen(file_name, "wb");
    if (!fp) abort_("[write_png_file] File %s could not be opened for writing", file_name);

    png_ptr = png_create_write_struct(PNG_LIBPNG_VER_STRING, NULL, NULL, NULL);
    if (!png_ptr) abort_("[write_png_file] png_create_write_struct failed");

    info_ptr = png_create_info_struct(png_ptr);
    if (!info_ptr) abort_("[write_png_file] png_create_info_struct failed");

    if (setjmp(png_jmpbuf(png_ptr))) abort_("[write_png_file] Error during init_io");

    png_init_io(png_ptr, fp);

    if (setjmp(png_jmpbuf(png_ptr))) abort_("[write_png_file] Error during writing header");

    png_set_IHDR(png_ptr, info_ptr, width, height,
                 bit_depth, color_type, PNG_INTERLACE_NONE,
                 PNG_COMPRESSION_TYPE_BASE, PNG_FILTER_TYPE_BASE);

    png_write_info(png_ptr, info_ptr);

    if (setjmp(png_jmpbuf(png_ptr))) abort_("[write_png_file] Error during writing bytes");

    png_write_image(png_ptr, row_pointers);

    if (setjmp(png_jmpbuf(png_ptr))) abort_("[write_png_file] Error during end of write");

    png_write_end(png_ptr, NULL);

    for (int y = 0; y < height; y++) free(row_pointers[y]);
    free(row_pointers);

    fclose(fp);
}

void fillShape(int startX, int startY, Color fillColor, Color borderColor) {
    std::queue<std::pair<int, int>> pixelQueue;
    pixelQueue.push({startX, startY});

    while (!pixelQueue.empty()) {
        int x = pixelQueue.front().first;
        int y = pixelQueue.front().second;
        pixelQueue.pop();

        // Sprawdzamy czy piksel jest w granicach obrazu
        if (x < 0 || x >= width || y < 0 || y >= height) {
            continue;
        }

        // Pobieramy kolor aktualnego piksela
        png_byte* row = row_pointers[y];
        png_byte* ptr = &(row[x * 3]);

        Color currentColor = {ptr[0], ptr[1], ptr[2]};

        // Jeśli piksel jest już wypełniony kolorem lub jest krawędzią, pomijamy go
        if (currentColor.r == fillColor.r && currentColor.g == fillColor.g && currentColor.b == fillColor.b) {
            continue;
        }
        if (currentColor.r == borderColor.r && currentColor.g == borderColor.g && currentColor.b == borderColor.b) {
            continue;
        }

        // Wypełniamy piksel kolorem
        ptr[0] = fillColor.r;
        ptr[1] = fillColor.g;
        ptr[2] = fillColor.b;

        // Dodajemy sąsiednie piksele do kolejki
        pixelQueue.push({x + 1, y});
        pixelQueue.push({x - 1, y});
        pixelQueue.push({x, y + 1});
        pixelQueue.push({x, y - 1});
    }
}

void writePixel(int x, int y, Color color, int thickness = 1) {
    if (thickness < 1) {
        thickness = 1;
    }
    for (int dy = -thickness / 2; dy <= thickness / 2; dy++) {
        for (int dx = -thickness / 2; dx <= thickness / 2; dx++) {
            int new_x = x + dx;
            int new_y = y + dy;
            if (new_x >= 0 && new_x < width && new_y >= 0 && new_y < height) {
                png_byte* row = row_pointers[new_y];
                png_byte* ptr = &(row[new_x * 3]);
                ptr[0] = color.r;
                ptr[1] = color.g;
                ptr[2] = color.b;
            }
        }
    }
}

void drawLine(int x1, int y1, int x2, int y2, Color color, int thickness = 1) {
    int dx = abs(x2 - x1);  // Odległość w osi x
    int dy = abs(y2 - y1);  // Odległość w osi y
    int sx = (x1 < x2) ? 1 : -1; // Krok w osi x
    int sy = (y1 < y2) ? 1 : -1; // Krok w osi y
    int err = dx - dy;
    while (true) {
        writePixel(x1, y1, color, thickness);
        if (x1 == x2 && y1 == y2) {
            break;
        }

        int e2 = 2 * err;
        if (e2 > -dy) {
            err -= dy;
            x1 += sx;
        }
        if (e2 < dx) {
            err += dx;
            y1 += sy;
        }
    }
}

void drawRelativeLine(int dx, int dy, Color color, int thickness = 1) {
    int new_x = last_x + dx; // Obliczamy nowe współrzędne x
    int new_y = last_y + dy; // Obliczamy nowe współrzędne y

    // Rysujemy linię od ostatniego punktu do nowego punktu
    drawLine(last_x, last_y, new_x, new_y, color, thickness);

    // Aktualizujemy ostatnie współrzędne
    last_x = new_x;
    last_y = new_y;
}


void drawCircle(int cx, int cy, int radius, Color color, bool fill) {
    int x = radius;
    int y = 0;
    int decisionOver2 = 1 - x;  // Decyzja Bresenhama dla okręgu

    while (y <= x) {
        if (fill) {
            // Rysujemy poziome linie między przeciwnymi punktami
            for (int i = cx - x; i <= cx + x; i++) {
                writePixel(i, cy + y, color);
                writePixel(i, cy - y, color);
            }
            for (int i = cx - y; i <= cx + y; i++) {
                writePixel(i, cy + x, color);
                writePixel(i, cy - x, color);
            }
        } else {
            // Rysujemy tylko piksele na obwodzie okręgu
            writePixel(cx + x, cy + y, color); // 1. ćwiartka
            writePixel(cx + y, cy + x, color); // 2. ćwiartka
            writePixel(cx - y, cy + x, color); // 3. ćwiartka
            writePixel(cx - x, cy + y, color); // 4. ćwiartka
            writePixel(cx - x, cy - y, color); // 5. ćwiartka
            writePixel(cx - y, cy - x, color); // 6. ćwiartka
            writePixel(cx + y, cy - x, color); // 7. ćwiartka
            writePixel(cx + x, cy - y, color); // 8. ćwiartka
        }

        y++;
        if (decisionOver2 <= 0) {
            decisionOver2 += 2 * y + 1;  // Zwiększamy y
        } else {
            x--;
            decisionOver2 += 2 * (y - x) + 1;  // Zwiększamy y i zmniejszamy x
        }
    }
}

void process_file() {
    for (int y = 0; y < height; y++) {
        png_byte *row = row_pointers[y];
        for (int x = 0; x < width; x++) {
            row[x * 3] = MAGENTA.r;
            row[x * 3 + 1] = MAGENTA.g;
            row[x * 3 + 2] = MAGENTA.b;
        }
    }

    drawCircle(300, 300, 280, GREEN, true);
    drawCircle(300, 300, 280, BLACK, false);

    last_x = 100;
    last_y = 400;
    int stroke = 3;

    drawLine(100, 175, 100, 400, BLACK, stroke);
    drawRelativeLine(20, 0, BLACK, stroke);
    drawRelativeLine(0, -90, BLACK, stroke);
    drawRelativeLine(20, -20, BLACK, stroke);
    drawRelativeLine(70, 110, BLACK, stroke);
    drawRelativeLine(20, 0, BLACK, stroke);
    drawRelativeLine(-80, -120, BLACK, stroke);
    drawRelativeLine(100, -110, BLACK, stroke);
    drawRelativeLine(-20, 0, BLACK, stroke);
    drawRelativeLine(-110, 110, BLACK, stroke);
    drawRelativeLine(0, -105, BLACK, stroke);
    drawRelativeLine(-20, 0, BLACK, stroke);

    fillShape(110, 180, YELLOW, BLACK);

    last_x = 350;
    last_y = 400;
    drawLine(350, 175, 350, 400, BLACK, stroke);
    drawRelativeLine(20, 0, BLACK, stroke);
    drawRelativeLine(0, -90, BLACK, stroke);
    drawRelativeLine(20, -20, BLACK, stroke);
    drawRelativeLine(70, 110, BLACK, stroke);
    drawRelativeLine(20, 0, BLACK, stroke);
    drawRelativeLine(-80, -120, BLACK, stroke);
    drawRelativeLine(100, -110, BLACK, stroke);
    drawRelativeLine(-20, 0, BLACK, stroke);
    drawRelativeLine(-110, 110, BLACK, stroke);
    drawRelativeLine(0, -105, BLACK, stroke);
    drawRelativeLine(-20, 0, BLACK, stroke);

    fillShape(360, 180, CYAN, BLACK);

}

int main(int argc, char **argv) {
    create_png_file();
    process_file();
    write_png_file(OUT_FILE);
    return 0;
}
