; cel to uzyskanie wartości HEX:14 (DEC:20) w rejestrze BX

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

	mov ax, [a] 		; wartosc a do ax
	mov bx, [b]		; wartosc b do bx
	add bx, [c]		; dodaj (b + c)
	imul ax, bx		; mnozenie a * (b + c)
	mov bx, ax		; przenies wynik mnozenia do bx
	add [result], bx	; ostateczny wynik jako result

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
msg2 db "Wynik: a * ( b + c ) = 20 (HEX 14)$"