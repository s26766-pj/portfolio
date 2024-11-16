org 100h

section .data
msg db 'Wprowadz znak: $'
out_msg db 'Wprowadzony znak: $'
nl db 0dh, 0ah, '$'

section .bss
input resb 1

section .text
start:
    ; wyczyszczenie ekranu
    mov ah, 0x00
    mov al, 0x03
    int 0x10
    
    ; wypisanie wiadomości
    mov ah, 0x09
    mov dx, msg
    int 0x21
    
    ; odczytanie znaku
    mov ah, 0x01
    int 0x21
    mov [input], al
    
    ; wypisanie wiadomości z odczytanym znakiem
    mov ah, 0x09
    mov dx, nl
    int 0x21
    
    mov ah, 0x09
    mov dx, out_msg
    int 0x21
    
    mov dl, [input]
    mov ah, 0x02
    int 0x21
    
    ; zakończenie programu
    mov ah, 0x4c
    int 0x21
