#!/bin/bash

# nie jestem pewien czy dokońca rozumiem o co w tym drugim zadaniu chodzi
# otóż skrypt z zadania pierwszego robił robote i wyświetlał dowolną liczbe prametrów
# poniżej kod taki sam jak w zadaniu pierwszym

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