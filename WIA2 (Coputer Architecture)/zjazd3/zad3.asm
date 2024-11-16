org 100h

; wyświetlenie wiadomości
mov ah, 09h
mov dx, msg
int 21h

; wczytanie ciagu znakow do bufora
mov ah, 0Ah
mov dx, buffer
int 21h

; wyswietlenie nowej linii
mov ah, 02h
mov dl, 0Dh
int 21h
mov dl, 0Ah
int 21h

; wyświetlenie tekstu w nowej linii
mov ah, 9
mov dx, msg_final
int 21h

mov bx, buffer+2	; początek stringa do BX
mov cl, [bx-1]		; długość stringa do CL
add bx, cx		; przesuń się na koniec stringa
mov byte [bx], '$'	; dodaj znak dolara
sub bx, cx		; cofnij się do początku stringa
mov ah, 09h		; inicjacja wyświetlania stringa
mov dx, bx		; skopjuj stringa do DX
int 21h			; wywołaj

; zakonczenie programu
mov ah, 4Ch
int 21h

msg db 'Wpisz ciag znakow: $'
msg_final db 'Oto String = $'
buffer db 255