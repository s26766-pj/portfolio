#!/bin/bash

# załaduj funkcje z pliku funkcje.f
source funkcje.f

# główna pętla programu
while true
do
  menu
  option=$(wybor)

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
