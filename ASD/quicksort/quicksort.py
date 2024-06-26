#-------------------------------------------------------------------------------
# Name:        Quicksort
# Author:      Kamil Koniak
# Created:     22.04.2024
# Copyright:   (c) PJATK 2024
#-------------------------------------------------------------------------------

import time
import random

def measure_time_and_sort(sort_function, A):
    start_time = time.time()
    sorted_array = sort_function(A, 0, len(A) - 1)
    end_time = time.time()
    elapsed_time = end_time - start_time
    return sorted_array, elapsed_time

def quicksort(A, p, r):
    if (p < r):
        q = partition(A, p, r)
        quicksort(A, p, q - 1)
        quicksort(A, q + 1, r)
    return A

def partition(A, p, r):
    pivot = A[r]
    smaller = p
    for j in range(p, r):
        if (A[j] <= pivot):
            A[smaller], A[j] = A[j], A[smaller]
            smaller += 1
    A[smaller], A[r] = A[r], A[smaller]
    return smaller

def quicksortModified(A, p, r):
    if (p < r):
        q = partitionModified(A, p, r)
        quicksortModified(A, p, q - 1)
        quicksortModified(A, q + 1, r)
    return A

def partitionModified(A, p, r):
    # Zamiana środkowego elementu z ostatnim
    middle_index = (p + r) // 2
    A[middle_index], A[r] = A[r], A[middle_index]

    pivot = A[r]
    smaller = p
    for j in range(p, r):
        if (A[j] <= pivot):
            A[smaller], A[j] = A[j], A[smaller]
            smaller += 1
    A[smaller], A[r] = A[r], A[smaller]
    return smaller

def compare_sort_algorithms(sort_function1, array1, sort_function2, array2):
    sorted_array1, time1 = measure_time_and_sort(sort_function1, array1)
    sorted_array2, time2 = measure_time_and_sort(sort_function2, array2)

    if time1 < time2:
        winner = "quicksort"
        difference = time2 - time1
    elif time2 < time1:
        winner = "quicksortModified"
        difference = time1 - time2
    else:
        winner = "Brak, czasy wykonania są takie same."
        difference = 0

    return winner, difference

# generuje dwie takie same tablice
A = [random.randint(1, 10000) for _ in range(978)]
B = A
print("Len: ", len(A))

winner, time_difference = compare_sort_algorithms(quicksort, A, quicksortModified, B)
print("----------------------------------------------------------------------")
print("Kategoria 1: Sorowanie")
print("Zwycięzca:", winner)
print("Różnica w czasie wykonania:", time_difference, "sekund")
print("----------------------------------------------------------------------")
print("Kategoria 2: Sortowanie posortowanych")
winner, time_difference = compare_sort_algorithms(quicksort, A, quicksortModified, B)
print("Zwycięzca:", winner)
print("Różnica w czasie wykonania:", time_difference, "sekund")
print("----------------------------------------------------------------------")

"""
Len:  978
----------------------------------------------------------------------
Kategoria 1: Sorowanie
Zwycięzca: quicksort
Różnica w czasie wykonania: 0.0010006427764892578 sekund
----------------------------------------------------------------------
Kategoria 2: Sortowanie posortowanych
Zwycięzca: quicksortModified
Różnica w czasie wykonania: 0.030002355575561523 sekund
----------------------------------------------------------------------

WNIOSKI
quicksort:
Bardzo dobrze radzi sobie z sortowaniem tablic do długości (len) 978.
Czas sortowania nieznacznie wydłuża się gdy dużo elementów w tablicy powtarza się.
Słabo radzi sobie z już posortowanymi tablicami.

quicksortModified
Bardzo dobrze radzi z długimi tablicami np. len = 1.000.000
Nie widać znaczącej różnicy w czasie gdy w tablicy mnóstwo elementów powtarza się.
Bezkonkurencyjnie radzi sobie z posortowanymi tablicami.

Która wersja jest lepsza?

quicksortModified wydaje się być lepszym rozwiązaniem,
ponieważ działa zarówno na małych i ogromnych tablicach.
Dużo lepiej radzi sobie w przypadkach gdy tablica jest już posortowana.
"""
