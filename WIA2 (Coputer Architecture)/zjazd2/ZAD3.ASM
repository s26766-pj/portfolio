org 100h

start:
    mov ah, 02h     ; Ustawianie kursora na początku ekranu
    mov bh, 00h     ; Numer strony kolorów (domyślnie 0)
    mov dh, 00h     ; Numer wiersza
    mov dl, 00h     ; Numer kolumny
    int 10h         ; Wywołanie przerwania systemowego 10h

    mov ah, 06h     ; Czyszczenie ekranu
    mov al, 0       ; Wartość, która zostanie wypisana na ekranie
    mov bh, 07h     ; Kolor tekstu (biały)
    mov cx, 00h     ; Numer wiersza
    mov dx, 184fh   ; Numer kolumny
    int 10h         ; Wywołanie przerwania systemowego 10h

    mov ah, 0ah     ; Wyświetlenie znaku z wprowadzeniem
    mov al, 'A'     ; Znak do wyświetlenia
    mov bh, 00h     ; Numer strony kolorów (domyślnie 0)
    mov cx, 01h     ; Ilość powtórzeń (w tym przypadku tylko jeden znak)
    int 10h         ; Wywołanie przerwania systemowego 10h

    mov ah, 4ch     ; Kod przerwania dla wyjścia z programu
    int 21h         ; Wywołanie przerwania 21h

    ; Zakończenie programu
