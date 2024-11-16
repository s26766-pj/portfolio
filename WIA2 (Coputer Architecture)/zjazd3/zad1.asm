org 100h

; wyświetlenie wiadomości
mov ah, 09h
mov dx, msg
int 21h

; wczytanie ciagu znakow do bufora
mov ah, 0Ah
mov dx, buffer
int 21h

; pobranie trzeciego znaku
mov si, buffer
add si, 4 ; przesunięcie wskaznika na trzeci znak
mov al, [si]
mov [char], al ; zapisanie trzeciego znaku w zmiennej char

; wyswietlenie trzeciego znaku w nowej linii
mov ah, 02h
mov dl, 0Dh
int 21h
mov dl, 0Ah
int 21h

; pobranie dlugosci wprowadzonego ciągu znakow
mov ah, 2Ah
mov dx, buffer
int 21h
mov cl, [buffer+2]

; wyświetlenie tekstu w nowej linii
mov ah, 9
mov dx, msg_final
int 21h

; wyświetlenie trzeciego znaku w nowej linii
mov ah, 2
mov dl, [char]
int 21h


; zakonczenie programu
mov ah, 4Ch
int 21h

msg db 'Wpisz ciag znakow: $'
msg_final db 'Oto trzeci znak z ciagu: $'
buffer db 255
char db 0