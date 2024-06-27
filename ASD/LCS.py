def lcs(X, Y):
    m = len(X)
    n = len(Y)
    
    # Tworzymy macierz dp o wymiarach (m+1)x(n+1) zainicjalizowaną zerami
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Wypełniamy macierz dp
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if X[i - 1] == Y[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    # Odczytujemy najdłuższy wspólny podciąg z macierzy dp
    index = dp[m][n]
    lcs_str = [""] * index

    # Startujemy od dp[m][n] i poruszamy się wstecz
    i = m
    j = n
    while i > 0 and j > 0:
        if X[i - 1] == Y[j - 1]:
            lcs_str[index - 1] = X[i - 1]
            i -= 1
            j -= 1
            index -= 1
        elif dp[i - 1][j] >= dp[i][j - 1]:
            i -= 1
        else:
            j -= 1

    return ''.join(lcs_str)

# Przykład użycia
X = "BDCABA"
Y = "ABCBDAB"
result = lcs(X, Y)
print("Najdłuższy wspólny podciąg to:", result)
