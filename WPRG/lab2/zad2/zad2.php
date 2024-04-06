<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formularz Rezerwacji Hotelowej</title>
</head>
<body>
<h2>Formularz Rezerwacji Hotelowej</h2>
<form action="process_reservation.php" method="post">
    <label for="number_of_guests">Liczba osób:</label>
    <select id="number_of_guests" name="number_of_guests" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <br>

    <!-- Formularz dla danych każdej osoby -->
    <div id="guests_info">
        <?php
        // Pobranie liczby osób
        $number_of_guests = isset($_POST['number_of_guests']) ? $_POST['number_of_guests'] : 1;

        // Wygenerowanie formularza dla każdej osoby
        for ($i = 1; $i <= $number_of_guests; $i++) {
            echo '<div class="guest">';
            echo '<h3>Dane osoby ' . $i . '</h3>';
            echo '<label for="guest_first_name_' . $i . '">Imię:</label>';
            echo '<input type="text" id="guest_first_name_' . $i . '" name="guest_first_name[]" required>';
            echo '<br>';
            echo '<label for="guest_last_name_' . $i . '">Nazwisko:</label>';
            echo '<input type="text" id="guest_last_name_' . $i . '" name="guest_last_name[]" required>';
            echo '<br>';
            echo '</div>';
        }
        ?>
    </div>

    <br>
    <button type="submit">Zarezerwuj</button>
</form>
</body>
</html>
