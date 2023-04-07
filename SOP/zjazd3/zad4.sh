#!/bin/bash

while true
do
  echo "Menu wyboru:"
  echo "c - Wyświetl aktualny katalog"
  echo "u - Wyświetl nazwę użytkownika"
  echo "h - Przejdź do katalogu domowego i wyświetl zawartość"
  echo "q - Wyjdź z programu"

  read -p "Wybierz opcję (c/u/h/q): " option

  if [ "$option" == "c" ]; then
    pwd
  elif [ "$option" == "u" ]; then
    whoami
  elif [ "$option" == "h" ]; then
    cd ~
    ls
  elif [ "$option" == "q" ]; then
    echo "Koniec programu"
    break
  else
    echo "Błędna opcja. Spróbuj ponownie."
  fi
done
