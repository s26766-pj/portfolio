<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formularz rezerwacji hotelu</title>
</head>
<body>
<h2>Formularz rezerwacji hotelu</h2>
<form action="collect.php" method="post">
    <label for="people_count">Liczba osób:</label>
    <select name="people_count" id="people_count">
        <?php for ($i = 1; $i <= 4; $i++) { ?>
            <option value="<?php echo $i; ?>"><?php echo $i; ?></option>
        <?php } ?>
    </select><br><br>
    <input type="submit" value="Dalej">
</form>
</body>
</html>
