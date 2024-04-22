<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Obliczanie silni</title>
</head>
<body>
<h1>Obliczanie silni</h1>
<form method="post">
    <label for="number">Podaj liczbę dla obliczenia silni (0-170):</label>
    <input type="number" id="number" name="number" min="0" max="170" required>
    <button type="submit">Oblicz</button>
</form>
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $number = (int)$_POST["number"];
    require_once 'functions.php';

    list($resultRecursive, $timeRecursive) = measureTime("factorialRecursive", $number);
    list($resultIterative, $timeIterative) = measureTime("factorialIterative", $number);

    echo "<h2>Wyniki dla liczby $number</h2>";
    echo "<table border='1'>";
    echo "<tr><th>Metoda</th><th>Wynik</th><th>Czas wykonania (ms)</th></tr>";
    echo "<tr><td>Rekurencyjna</td><td>$resultRecursive</td><td>$timeRecursive</td></tr>";
    echo "<tr><td>Iteracyjna</td><td>$resultIterative</td><td>$timeIterative</td></tr>";
    echo "</table>";

    if ($timeRecursive < $timeIterative) {
        echo "<p>Funkcja rekurencyjna działała szybciej o " . ($timeIterative - $timeRecursive) . " ms</p>";
    } elseif ($timeIterative < $timeRecursive) {
        echo "<p>Funkcja iteracyjna działała szybciej o " . ($timeRecursive - $timeIterative) . " ms</p>";
    } else {
        echo "<p>Czas wykonania obu funkcji był identyczny</p>";
    }
}
?>
</body>
</html>
