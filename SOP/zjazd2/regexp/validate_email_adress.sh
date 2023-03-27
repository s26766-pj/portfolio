#!/bin/bash


input="email_list.txt"

regex="^(([-a-zA-Z0-9\!#\$%\&\'*+/=?^_\`{\|}~]+|(\"([][,:;<>\&@a-zA-Z0-9\!#\$%\&\'*+/=?^_\`{\|}~-]|(\>

while read -r line
do
        echo $line | grep -qE "$regex"

if [ $? -eq 0 ]; then
        echo "$line jest prawidłowym adresem poczty elektronicznej."
else
        echo "$line nie jest prawidłowym adresem poczty elektronicznej."
fi


done < "$input"