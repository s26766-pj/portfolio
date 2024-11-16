        org 100h ; adres początkowy programu

        mov ah, 2 ; ustaw kod przerwania do wyświetlenia znaku
        mov dl, 41h ; znak 'A'
        int 21h ; wywołaj przerwanie DOS

        mov ah, 2 ; ustaw kod przerwania do wyświetlenia znaku
        mov dl, 67h ; znak 'g'
        int 21h ; wywołaj przerwanie DOS

        mov ah, 4ch ; kod przerwania do zakończenia programu
        int 21h ; wywołaj przerwanie DOS
