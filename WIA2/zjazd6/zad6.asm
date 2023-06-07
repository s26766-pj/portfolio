org 100h

start:

	; wyświetlenie wiadomości 1 
	mov ah, 09h
	mov dx, msg1
	int 21h
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; wyświetlenie wiadomości 2
	mov ah, 09h
	mov dx, msg2
	int 21h
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; wyświetlenie wiadomości 3
	mov ah, 09h
	mov dx, msg3
	int 21h
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; wyświetlenie wiadomości 4
	mov ah, 09h
	mov dx, msg4
	int 21h
	mov ah, 02h
	mov dl, 0Dh
	int 21h
	mov dl, 0Ah
	int 21h

	; wyświetlenie wiadomości 5
	mov ah, 09h
	mov dx, msg5
	int 21h

	lea si, [statement] 	; wskaźnik na "5 3 * 1 +$"
	mov cx, 0 		; wyzeruj cx

count_length:

	cmp byte [si], '$' 	; sprawdzenie, czy osiągnięto znak końca łańcucha
	je end_count_length 	; jeśli tak, zakończ obliczanie długości
	inc cx 			; zwiększenie licznika długości
	inc si 			; przesunięcie wskaźnika na kolejny znak
	jmp count_length 	; powtarzanie pętli

end_count_length:
	
	add [len], cl			; zapisz długość łańcucha do len
	mov ch, [i]			; i do ch


	lea si, [statement] 		; wskaźnik na "5 3 * 1 +$"
	dec ch


go_through_length:
	
	inc ch				; i++
	cmp ch, cl			; porownaj i z len
	je end_through_length 		; zakończ pętle

	mov bl, [si]

	; porównaj
	cmp bl, 5Eh
	je exponentiation
	cmp bl, 2Fh
	je division
	cmp bl, 2Dh
	je subtraction
	cmp bl, 2Bh
	je addition
	cmp bl, 2Ah
	je multiplication
	cmp bl, 20h
	je white_space
	cmp bl, 30h	
	je digit
	cmp bl, 31h
	je digit
	cmp bl, 32h
	je digit
	cmp bl, 33h
	je digit
	cmp bl, 34h
	je digit
	cmp bl, 35h
	je digit
	cmp bl, 36h
	je digit
	cmp bl, 37h
	je digit
	cmp bl, 38h
	je digit
	cmp bl, 39h
	je digit

	inc si				; si++
	jmp go_through_length 		; powtarzanie pętli

exponentiation:

	pop bx				; ściągnij ze stosu wartość potęgi
	pop bx				; ściągnij ze stosu, do bx
	mov ax, bx			; powiel do ax
	imul ax, bx 			; mnożenie ax i bx
	push ax				; wynik potęgowania na stos
	inc si				; si++
	jmp go_through_length		; skok

division:

	pop bx				; ściągnij ze stosu, do bx
	pop ax				; ściągnij ze stosu, do ax
    	xor dx, dx			; wyczyść rejestr dx
	div word bx			; podziel zawartość a przez (b + c)
	push ax				; wynik dzielenia na stos
	inc si				; si++
	jmp go_through_length		; skok

subtraction:

	pop bx				; ściągnij ze stosu, do bx
	pop ax				; ściągnij ze stosu, do ax
	sub ax, bx 			; odejmowanie ax i bx
	push ax				; wynik odejmowania na stos
	inc si				; si++
	jmp go_through_length		; skok

addition:

	pop bx				; ściągnij ze stosu, do bx
	pop ax				; ściągnij ze stosu, do ax
	add ax, bx 			; dodawanie ax i bx
	push ax				; wynik dodawania na stos
	inc si				; si++
	jmp go_through_length		; skok

multiplication:
	
	pop bx				; ściągnij ze stosu, do bx
	pop ax				; ściągnij ze stosu, do ax
	imul ax, bx 			; mnożenie ax i bx
	push ax				; wynik mnożenia na stos
	inc si				; si++
	jmp go_through_length		; skok


white_space:

	inc si				; si++
	jmp go_through_length		; skok

digit:
	sub bx, 30h			; zamień z ASCII na liczbę HEX
	push bx				; wrzuć liczbę na stos
	inc si				; si++
	jmp go_through_length		; skok


end_through_length:

	pop ax				; wynik ze stosu do ax

	; z hex na dec
	mov ds, ax
	mov cx, 0Ah
	mov dx, 00h
	div cx

	mov [result10], ax		; zapisz liczbe diesiątek
	mov [result00], dx		; zapisz liczbe jednostek

	; wynik - liczba dziesiątek
	mov ah, 02h	
    	mov dl, '0'	
   	add dl, [result10]
    	int 21h

	; wynik - liczba jednostek
	mov ah, 02h   	
    	mov dl, '0' 	
   	add dl, [result00]  	
    	int 21h	

end: 

	mov ah, 4Ch 			; wywołanie funkcji DOS Exit
    	int 21h				; koniec programu

a dw 05h
b dw 03h
c dw 01h
result00 dw 0h
result10 dw 0h

msg1 db "Wzor: a^2 + 2b + c$"
msg2 db "Dane: a = 5, b = 3, c = 1$"
msg3 db "Infix: 5 ^ 2 + 2 * 3 + 1$"
msg4 db "Postfix: 5 2 ^ 2 3 * + 1 +$"
msg5 db "Wynik = $"
statement db "5 2 ^ 2 3 * + 1 +$"
len dw 0
i dw 0
