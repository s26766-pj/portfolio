; Program przyjmuje od użytkownika jeden znak i drukuje odpowiedni znak na ekranie
; Jesli znak jest wiekszy niz '_' (5Fh), to drukuje '>', jesli mniejszy to '<', a jesli rowny to '=='

org 100h

start:
	; Wyświetl wiadomość o wprowadzeniu znaku
	mov ah, 09h
	mov dx, msg
	int 21h
	mov ah, 01h
	int 21h

	; Porównaj znak z '_'
	cmp al, 5Fh
	jg greater_than
	jl less_than
	je equal_to

greater_than:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	mov ah, 09h
	mov dx, cmp_msg
	int 21h
	jmp end

less_than:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	mov ah, 09h
	mov dx, lt_msg
	int 21h
	jmp end

equal_to:
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h
	mov ah, 09h
	mov dx, eq_msg
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
cmp_msg db "Oto rezultat: >$", 0
eq_msg db "Oto rezultat: ==$", 0
lt_msg db "Oto rezultat: <$", 0