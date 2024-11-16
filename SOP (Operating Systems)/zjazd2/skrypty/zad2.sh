#!/bin/bash

if [ -e SOP_display.sh ]; then
  ./SOP_display.sh
elif [ $# -eq 1 ]; then
  if [ -e "$1" ]; then
    ./"$1"
  else
    echo "Plik $1 nie istnieje."
  fi
else
  echo "Błąd: Brak pliku SOP_display.sh oraz brak parametru."
fi