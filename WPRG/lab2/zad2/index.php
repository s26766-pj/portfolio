<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formularz rezerwacji hotelu</title>
</head>
<body>
<h2>Formularz rezerwacji hotelu</h2>
<form action="summary.php" method="post">
    <label for="people_count">Liczba osób:</label>
    <select name="people_count" id="people_count">
        <?php for ($i = 1; $i <= 4; $i++) { ?>
            <option value="<?php echo $i; ?>"><?php echo $i; ?></option>
        <?php } ?>
    </select>
    <br>
    <label for="name">Imię:</label>
    <input type="text" name="name" id="name" required><br>
    <label for="surname">Nazwisko:</label>
    <input type="text" name="surname" id="surname" required><br>
    <label for="address">Adres:</label>
    <input type="text" name="address" id="address" required><br>
    <label for="credit_card">Numer karty kredytowej:</label>
    <input type="text" name="credit_card" id="credit_card" required><br>
    <label for="email">E-mail:</label>
    <input type="email" name="email" id="email" required><br>
    <label for="date">Data pobytu:</label>
    <input type="date" name="date" id="date" required><br>
    <label for="arrival_time">Godzina przyjazdu:</label>
    <input type="time" name="arrival_time" id="arrival_time" required><br>
    <input type="checkbox" name="child_bed" id="child_bed">
    <label for="child_bed">Potrzeba dostawienia łóżka dla dziecka</label><br>
    <label for="amenities">Udogodnienia (wciśnij klawisz CTRL by wybrać więcej niż jedno udogodnienie):</label><br>
    <select name="amenities[]" id="amenities" multiple>
        <option value="Klimatyzacja">Klimatyzacja</option>
        <option value="Popielniczka">Popielniczka dla palacza</option>
        <option value="Szampan">Butelka szampana</option>
        <option value="Kwiaty">Bukiet kwiatów</option>
    </select><br>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
