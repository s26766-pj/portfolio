; Program pobiera znaki od użytkownika i wypisuje je na ekranie,
; aż do wprowadzenia znaku Q, który kończy program.

org 100h
	
start:

	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wyświetl wiadomość o wprowadzeniu znaku
	mov ah, 09h
	mov dx, msg
	int 21h

	; Pobierz znak od użytkownika
	mov ah, 01h
	int 21h

	jmp porownaj

porownaj:
	cmp al, 'Q'
	jne drukuj
	je koniec

drukuj: 
	; Przesuń znak do schowka
	mov cx, ax
	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wiadomość "Podano znak: "
	mov ah, 09h
	mov dx, result
	int 21h

	; Wyświetl znak
	mov ah, 02h
	mov dl, cl
	int 21h

	jmp start

koniec:
	; Nowa linja
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; Wyjście z programu
	mov ah, 4Ch
	int 21h

msg db "Podaj znak (Uwaga: znak Q konczy program): $"
result db "Podano znak: $"