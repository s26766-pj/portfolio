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
<?php if ($_POST['people_count'] > 1) { ?>
    <p>Rezerwacja dotyczy więcej niż jednej osoby.</p>
<?php } ?>

<?php
for ($i = 1; $i <= $_POST['people_count']; $i++) {
    ?>
    <h3>Dane osoby nr <?php echo $i; ?></h3>
    <p>Imię: <?php echo $_POST['name' . $i]; ?></p>
    <p>Nazwisko: <?php echo $_POST['surname' . $i]; ?></p>
    <p>Adres: <?php echo $_POST['address' . $i]; ?></p>
    <p>Numer karty kredytowej: <?php echo $_POST['credit_card' . $i]; ?></p>
    <p>E-mail: <?php echo $_POST['email' . $i]; ?></p>
    <p>Data pobytu: <?php echo $_POST['date' . $i]; ?></p>
    <p>Godzina przyjazdu: <?php echo $_POST['arrival_time' . $i]; ?></p>
    <?php if(isset($_POST['child_bed' . $i])) { ?>
        <p>Potrzeba dostawienia łóżka dla dziecka: Tak</p>
    <?php } else { ?>
        <p>Potrzeba dostawienia łóżka dla dziecka: Nie</p>
    <?php } ?>
    <p>Udogodnienia:
        <?php
        if(isset($_POST['amenities' . $i]) && !empty($_POST['amenities' . $i])) {
            echo implode(", ", $_POST['amenities' . $i]);
        } else {
            echo "Brak";
        }
        ?>
    </p>
    <?php
}
?>
</body>
</html>
