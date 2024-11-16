#!/bin/bash


input="name_list.txt"
regex=^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]

while read -r line

do
        echo $line | grep -qE "$regex"

if  [ $? -eq 0 ]; then

        echo "$line jest prawidłowym zapisem imienia i nazwiska."

else

        echo "$line nie jest prawidłowym zapisem imienia i nazwiska."

fi


done < "$input"