<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prosty Kalkulator</title>
</head>
<body>
<h2>Kalkulator</h2>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
    <label for="number1">Liczba 1:</label>
    <input type="number" id="number1" name="number1" required>
    <br>
    <label for="number2">Liczba 2:</label>
    <input type="number" id="number2" name="number2" required>
    <br>
    <label for="operation">Działanie:</label>
    <select id="operation" name="operation">
        <option value="add">Dodawanie</option>
        <option value="subtract">Odejmowanie</option>
        <option value="multiply">Mnożenie</option>
        <option value="divide">Dzielenie</option>
    </select>
    <br>
    <button type="submit">Oblicz</button>
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $number1 = $_POST['number1'];
    $number2 = $_POST['number2'];
    $operation = $_POST['operation'];

    switch ($operation) {
        case "add":
            $result = $number1 + $number2;
            echo "Wynik dodawania: " . $result;
            break;
        case "subtract":
            $result = $number1 - $number2;
            echo "Wynik odejmowania: " . $result;
            break;
        case "multiply":
            $result = $number1 * $number2;
            echo "Wynik mnożenia: " . $result;
            break;
        case "divide":
            if ($number2 != 0) {
                $result = $number1 / $number2;
                echo "Wynik dzielenia: " . $result;
            } else {
                echo "Nie można dzielić przez zero!";
            }
            break;
        default:
            echo "Nieprawidłowe działanie!";
    }
}
?>
</body>
</html>
