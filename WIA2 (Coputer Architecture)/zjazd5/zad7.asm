; cel to uzyskanie wartości HEX:14 (DEC:32) w zmiennej result

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
	mov bx, [a]		; wartosc a do bx
	imul ax, bx		; mnozenie (a * a)
	mov bx, ax		; przenies wynik mnozenia do bx
	mov ax, [b]		; b do ax
	mov cx, 2		; wartosc dwa do cx
	imul ax, cx		; mnozenie (2 * b)
	add ax, bx		; dodawanie (a^2 + 2 * b)
	add ax, [c]		; dodawanie (a^2 + 2 * b + c)
	add [result], ax	; ostateczny wynik jako result

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
msg2 db "Wynik: a^2 + 2 * b + c = 32 (HEX: 20)$"