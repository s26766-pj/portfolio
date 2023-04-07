#!/bin/bash

# funkcja wyświetlająca menu
function menu() {
  echo "Menu wyboru:"
  echo "c - Wyświetl aktualny katalog"
  echo "u - Wyświetl nazwę użytkownika"
  echo "h - Przejdź do katalogu domowego i wyświetl zawartość"
  echo "q - Wyjdź z programu"
}

# funkcja odczytująca wybór użytkownika
function wybor() {
  read -p "Wybierz opcję (c/u/h/q): " option
  echo "$option"
}
