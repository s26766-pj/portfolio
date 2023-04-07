#!/bin/bash

# pobierz nazwę bieżącego skryptu
script_name=$(basename "$BASH_SOURCE")
# Tworzenie pustej tablicy
array=()

echo "a) program nazywa się: $script_name"
echo "b) kolejno wartości argumentów:"

for param in "$@"
do
  array+=("$param")
done

# Wyświetlanie elementów tablicy z numerem porządkowym
for i in "${!array[@]}"
do
  echo "param$((i+1)): ${array[i]}"
done

echo "c) parametry: $*"
echo "d) liczba parametrów: $#"
echo "e) PID: $$"