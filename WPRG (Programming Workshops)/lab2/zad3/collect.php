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
    <?php
    $people_count = isset($_POST['people_count']) ? $_POST['people_count'] : 1;
    ?>
    <input type="hidden" name="people_count" value="<?php echo $people_count; ?>">
    <label for="people_count">Liczba osób: <?php echo $people_count; ?></label><br><br>
    <?php
    for ($i = 1; $i <= $people_count; $i++) {
        ?>
        <h3>Osoba <?php echo $i; ?></h3>
        <label for="name<?php echo $i; ?>">Imię:</label>
        <input type="text" name="name<?php echo $i; ?>" id="name<?php echo $i; ?>" required><br>
        <label for="surname<?php echo $i; ?>">Nazwisko:</label>
        <input type="text" name="surname<?php echo $i; ?>" id="surname<?php echo $i; ?>" required><br>
        <label for="address<?php echo $i; ?>">Adres:</label>
        <input type="text" name="address<?php echo $i; ?>" id="address<?php echo $i; ?>" required><br>
        <label for="credit_card<?php echo $i; ?>">Numer karty kredytowej:</label>
        <input type="text" name="credit_card<?php echo $i; ?>" id="credit_card<?php echo $i; ?>" required><br>
        <label for="email<?php echo $i; ?>">E-mail:</label>
        <input type="email" name="email<?php echo $i; ?>" id="email<?php echo $i; ?>" required><br>
        <label for="date<?php echo $i; ?>">Data przybycia:</label>
        <input type="date" name="date<?php echo $i; ?>" id="date<?php echo $i; ?>" required><br>
        <label for="arrival_time<?php echo $i; ?>">Godzina przybycia:</label>
        <input type="time" name="arrival_time<?php echo $i; ?>" id="arrival_time<?php echo $i; ?>" required><br>
        <input type="checkbox" name="child_bed<?php echo $i; ?>" id="child_bed<?php echo $i; ?>">
        <label for="child_bed<?php echo $i; ?>">Potrzeba dostawienia łóżka dla dziecka</label><br>
        <label for="amenities<?php echo $i; ?>">Udogodnienia (wciśnij klawisz CTRL by wybrać więcej niż jedno udogodnienie):</label><br>
        <select name="amenities<?php echo $i; ?>[]" id="amenities<?php echo $i; ?>" multiple>
            <option value="Klimatyzacja">Klimatyzacja</option>
            <option value="Popielniczka">Popielniczka dla palacza</option>
            <option value="Szampan">Butelka szampana</option>
            <option value="Kwiaty">Bukiet kwiatów</option>
        </select><br><br>
        <?php
    }
    ?>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
