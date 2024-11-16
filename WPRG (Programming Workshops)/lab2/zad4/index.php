<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sprawdź liczbę pierwszą</title>
</head>
<body>
<h2>Sprawdź liczbę pierwszą</h2>
<form action="" method="post">
    <label for="number">Wprowadź liczbę:</label>
    <input type="text" name="number" id="number" required>
    <input type="submit" value="Sprawdź">
</form>

<?php
function isPrime($number)
{
    if ($number <= 1) {
        return false;
    }
    if ($number <= 3) {
        return true;
    }
    if ($number % 2 == 0 || $number % 3 == 0) {
        return false;
    }
    $i = 5;
    $iterations = 0;
    while ($i * $i <= $number) {
        if ($number % $i == 0 || $number % ($i + 2) == 0) {
            return false;
        }
        $i += 6;
        $iterations++;
    }
    return $iterations;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $number = isset($_POST['number']) ? intval($_POST['number']) : 0;

    if ($number > 0) {
        $iterations = isPrime($number);
        if ($iterations !== false) {
            echo "<p>Liczba $number jest liczbą pierwszą.</p>";
            echo "<p>Liczba iteracji pętli: $iterations</p>";
        } else {
            echo "<p>Liczba $number nie jest liczbą pierwszą.</p>";
            echo "<p>Liczba iteracji pętli: 0</p>";
        }
    } else {
        echo "<p>Proszę wprowadzić liczbę całkowitą dodatnią.</p>";
    }
}
?>

</body>
</html>
