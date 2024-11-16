#!/bin/bash

count=$(ls -1 | wc -l)

if [ "$count" -gt 5 ]
then
    echo "W bieżącym katalogu jest więcej niż 5 plików."
fi