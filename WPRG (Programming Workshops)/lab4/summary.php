<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Podsumowanie rezerwacji</title>
</head>
<body>
<h2>Podsumowanie rezerwacji</h2>
<p>Liczba osób: <?php echo $_POST['people_count']; ?></p>
<p>Imię: <?php echo $_POST['name']; ?></p>
<p>Nazwisko: <?php echo $_POST['surname']; ?></p>
<p>Adres: <?php echo $_POST['address']; ?></p>
<p>Numer karty kredytowej: <?php echo $_POST['credit_card']; ?></p>
<p>E-mail: <?php echo $_POST['email']; ?></p>
<p>Data pobytu: <?php echo $_POST['date']; ?></p>
<p>Godzina przyjazdu: <?php echo $_POST['arrival_time']; ?></p>
<?php if(isset($_POST['child_bed'])) { ?>
    <p>Potrzeba dostawienia łóżka dla dziecka: Tak</p>
<?php } else { ?>
    <p>Potrzeba dostawienia łóżka dla dziecka: Nie</p>
<?php } ?>
<p>Udogodnienia:
    <?php
    if(!empty($_POST['amenities'])) {
        echo implode(", ", $_POST['amenities']);
    } else {
        echo "Brak";
    }
    ?>
</p>

<?php
setcookie("people_count", $_POST['people_count'], time() + (86400 * 30), "/");
setcookie("name", $_POST['name'], time() + (86400 * 30), "/");
setcookie("surname", $_POST['surname'], time() + (86400 * 30), "/");
setcookie("address", $_POST['address'], time() + (86400 * 30), "/");
setcookie("credit_card", $_POST['credit_card'], time() + (86400 * 30), "/");
setcookie("email", $_POST['email'], time() + (86400 * 30), "/");
setcookie("date", $_POST['date'], time() + (86400 * 30), "/");
setcookie("arrival_time", $_POST['arrival_time'], time() + (86400 * 30), "/");
if(isset($_POST['child_bed'])) {
    setcookie("child_bed", "Tak", time() + (86400 * 30), "/");
} else {
    setcookie("child_bed", "Nie", time() + (86400 * 30), "/");
}
if(!empty($_POST['amenities'])) {
    setcookie("amenities", implode(", ", $_POST['amenities']), time() + (86400 * 30), "/");
} else {
    setcookie("amenities", "Brak", time() + (86400 * 30), "/");
}
echo "<p style='color: green;'>Ciasteczka zostały pomyślnie utworzone!</p>";
?>
</body>
</html>
