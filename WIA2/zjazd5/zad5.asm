; cel to uzyskanie wartości HEX:1 (DEC:1) w rejestrze BX

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

	mov ax, [a]		; wartosc a do bx
	mov bx, [b]		; wartosc b do bx
	add bx, [c]		; dodaj (b + c)
    	xor dx, dx		; wyczyść rejestr dx
	div word bx		; podziel zawartość a przez (b + c)
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
msg2 db "Wynik: a : ( b + c ) = 1.25 (HEX 1)$"


