org 100h

mov ah, 09h      ; wydrukuj stringa
mov dx, msg      ; adres stringa
int 21h          ; wykonaj
    
mov ah, 02h      ; wydrukuj char
mov dl, 0Ah      ; znak nowej linii
int 21h          ; wykonaj

mov byte [0x0120], '$'
    
mov ah, 09h      ; wydrukuj stringa
mov dx, msg      ; adres stringa
int 21h          ; wykonaj
    
mov ah, 4Ch      ; zakoncz proces
int 21h          ; wykonaj

msg db "WIAWIAAWIAAAAAAWIAWIAAAAAA$", 0Ah, 0Dh