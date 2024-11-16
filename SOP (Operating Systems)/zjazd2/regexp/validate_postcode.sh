#!/bin/bash
input="postcode_list.txt"

while read -r line
do
        echo $line | grep -qE '^[0-9]{2}(-[0-9]{3})?$'

if [ $? -eq 0 ]; then

        echo "$line jest kodem pocztowym."
else
        echo "$line nie jest kodem pocztowym."
fi


done < "$input"