#!/bin/bash

echo "Liczba parametrów = " $#

if [ $# -gt 1 ]; then

        echo "Podano więcej niż jeden parametr."

elif [ $# -eq 1 ]; then

        echo "Podano tylko jeden parametr: $1"

else

        echo "Nie podano żadnych parametrów."

fi