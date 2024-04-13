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
</body>
</html>
