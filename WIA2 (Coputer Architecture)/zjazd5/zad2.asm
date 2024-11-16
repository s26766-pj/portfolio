; cel to uzyskanie wartości HEX:10 (DEC:16) w rejestrze BX

org 100h
	
start:

	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wyświetl wiadomość
	mov ah, 09h
	mov dx, msg1
	int 21h

	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wyświetl wiadomość
	mov ah, 09h
	mov dx, msg2
	int 21h

	mov ax, [a] ; a do ax
	mov cx, [b] ; b do cx
	imul ax, cx ; mnozenie a i b
	add bx, ax  ; wynik mnozenia do bx
	add bx, [c] ; wynik plus c

	jmp stop

stop:

	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wyjście z programu
	mov ah, 4Ch
	int 21h


a dw 05h
b dw 03h
c dw 01h
result dw 0h

msg1 db "Dane: a = 5, b = 3, c = 1$"
msg2 db "Wynik: a * b + c = 16 (HEX: 10)$"


