; Program przyjmuje od użytkownika jeden znak i drukuje informację zwrotną,
; czy wprowadzony znak to wielka litera, mała litera czy inny znak.

org 100h

start:
	; Wyświetl wiadomość o wprowadzeniu znaku
	mov ah, 09h
	mov dx, msg
	int 21h

	; Pobierz znak od użytkownika
	mov ah, 01h
	int 21h

	; Porównaj znak z kodami ASCII dla wielkich i małych liter
	cmp al, 41h
	jb not_a_letter
	cmp al, 5Ah
	jbe uppercase
	cmp al, 61h
	jb not_a_letter
	cmp al, 7Ah
	jbe lowercase
	jmp not_a_letter

uppercase:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	; Wyświetl informację o wielkiej literze
	mov ah, 09h
	mov dx, upper_msg
	int 21h
	jmp end

lowercase:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	; Wyświetl informację o małej literze
	mov ah, 09h
	mov dx, lower_msg
	int 21h
	jmp end

not_a_letter:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	; Wyświetl informację o błędzie
	mov ah, 09h
	mov dx, error_msg
	int 21h

end:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	; Wyjście z programu
	mov ah, 4Ch
	int 21h

msg db 0ah, "Podaj jeden znak: $"
upper_msg db "Oto rezultat: wielka litera$", 0
lower_msg db "Oto rezultat: mala litera$", 0
error_msg db "Error: to nie jest litera$", 0