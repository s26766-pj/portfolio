org 100h

section .text

start:
  mov ah, 0x00     ; ustawiamy tryb na ustawienie kursora
  mov al, 0x02     ; przenosimy kursor do górnego lewego rogu
  int 0x10

  mov ah, 0x06     ; ustawiamy tryb czyszczenia ekranu
  mov al, 0x00     ; czyscimy caly ekran
  mov bh, 0x07     ; ustawiamy kolor tekstu na bialy
  mov cx, 0x0000   ; ustawiamy punkt startowy czyszczenia
  mov dx, 0x184F   ; ustawiamy punkt koncowy czyszczenia
  int 0x10

  mov ah, 0x02     ; ustawiamy tryb na ustawienie kursora
  mov bh, 0x00     ; ustawiamy strone ekranu
  mov dh, 0x0C     ; ustawiamy wiersz na srodkowy
  mov dl, 0x28     ; ustawiamy kolumne na srodkowa
  int 0x10

  mov ah, 0x09     ; ustawiamy tryb wydruku na drukowanie znaku
  mov al, 0x43     ; drukujemy litere C
  mov bl, 0x07     ; ustawiamy kolor tekstu na bialy
  mov bh, 0x00     ; ustawiamy strone ekranu
  mov cx, 0x0001   ; ustawiamy liczbe powtorzen
  int 0x10

  mov ah, 0x00     ; oczekujemy na dowolny klawisz
  int 0x16

  mov ah, 0x00     ; przechodzimy do trybu powrotu do DOS-u
  int 0x21

section .data

section .bss
