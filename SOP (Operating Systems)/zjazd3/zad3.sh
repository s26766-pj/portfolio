#!/bin/bash

if [ -e "$1" ]; then
  echo "W bierzacym katalogu jest plik $1"
else
  echo "W bierzacym katalogu nie ma pliku $1"
fi