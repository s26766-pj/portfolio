; cel to uzyskanie wartości HEX:2 (DEC:2) w rejestrze BX

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
    	xor dx, dx		; wyczyść rejestr DX (część dzielnika)
	div word [b]		; podziel zawartość ax przez b
	mov bx, ax		; przenies wynik dzielenia do bx
	add bx, [c]		; dodaj do wyniku wartosc liczby c
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
msg2 db "Wynik: a : b + c = 2,666666666666667 (HEX: 2)$"


