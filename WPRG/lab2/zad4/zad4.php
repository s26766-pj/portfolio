<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wynik Sprawdzenia Czy Liczba Jest Liczbą Pierwszą</title>
</head>
<body>
<h2>Wynik Sprawdzenia Czy Liczba Jest Liczbą Pierwszą</h2>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $number = isset($_POST['number']) ? $_POST['number'] : null;
    if ($number <= 0) {
        echo "Podana liczba musi być dodatnia.";
    } else {
        $iterations = 0;
        $is_prime = true;
        for ($i = 2; $i <= sqrt($number); $i++) {
            $iterations++;
            if ($number % $i == 0) {
                $is_prime = false;
                break;
            }
        }

        if ($is_prime) {
            echo "$number jest liczbą pierwszą.";
        } else {
            echo "$number nie jest liczbą pierwszą.";
        }

        echo "<br>";
        echo "Liczba iteracji: $iterations";
    }
}
?>
</body>
</html>
