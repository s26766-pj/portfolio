; Napisz program który obliczy wzór: a+b+c
; cel wynik w bx


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

	mov bx, [result]
	add bx, [a]
	add bx, [b]
	add bx, [c]
	mov [result], bx

	mov ah, 02h   ; Funkcja DOS do wyświetlania znaku
    	mov dl, '0' ; Przygotowanie cyfry jedności
   	add dl, bl  ; Dodanie cyfry jedności do '0'
    	int 21h     ; Wyświetlenie cyfry jedności

	jmp koniec

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

a dw 05h
b dw 03h
c dw 01h
result dw 0h

msg1 db "Dane: a = 5, b = 3, c = 1$"
msg2 db "Wynik: a + b + c = $"