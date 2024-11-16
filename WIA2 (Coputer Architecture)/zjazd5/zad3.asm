; cel to uzyskanie wartości HEX:0E (DEC:14) w rejestrze BX

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
	mov cx, 2		; wartosc 2 do cx
	imul ax, cx		; mnozenie a * 2
	mov bx, ax		; wynik mnozenia do bx

	mov ax, [b] 		; wartosc a do ax
	imul ax, cx		; mnozenie b * 2
	add bx, ax		; wynik mnozenia dodaje do bx

	mov ax, [c] 		; wartosc c do ax
	imul ax, cx		; mnozenie c * 2
	sub bx, ax		; wynik mnozenia odejmuje od bx

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
msg2 db "Wynik: 2a + 2b - 2c = 14 (HEX: 0E)$"


