#!/bin/bash
tablica=(element1 element2 element3)
unset tablica[*]
echo ${tablica[@]}