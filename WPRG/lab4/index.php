<?php

/* Pytanie: dlaczego nie może uzyskać wspomnianego dostępu?
*
* W moim rozwiązaniu jest flaga "$is_logged_in".
* Jeżeli użytkownik poda dobre dane do logowania (admin, pass), to flaga "$is_logged_in" zmienia się na true.
* Jeżeli flaga "$is_logged_in" jest na true to wtedy otwiera się dostęp do formularza rejestracji do hotelu (zostaje wczytany).
*/

session_start();

$is_logged_in = isset($_SESSION['username']);
$logged_in_user = isset($_COOKIE['logged_in_user']) ? $_COOKIE['logged_in_user'] : null;
$access_denied_message = "Dostęp do formularza rezerwacji hotelu możliwy po zalogowaniu.";

if (isset($_POST['logout'])) {
    session_unset();
    session_destroy();
    setcookie("logged_in_user", "", time() - 3600, "/");
    $is_logged_in = false;
}

if (isset($_POST['login']) && isset($_POST['username']) && isset($_POST['password'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];
    if ($username === 'admin' && $password === 'pass') {
        $_SESSION['username'] = $username;
        setcookie("logged_in_user", $username, time() + (86400 * 30), "/");
        $is_logged_in = true;
        header("Refresh:0");
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Strona logowania</title>
</head>
<body>

<?php if ($is_logged_in) { ?>

    <form action="index.php" method="post">
        <input type="hidden" name="logout" value="true">
        <input type="submit" value="Wyloguj się">
    </form>
    <h2 style="color: darkolivegreen">Witaj, <?php echo $logged_in_user; ?>!</h2>
    <form id="deleteCookiesForm" action="index.php" method="post">
        <input type="hidden" name="delete_cookies" value="true">
        <input type="submit" value="Wyczyść formularz">
    </form>
    <h2>Formularz rezerwacji hotelu</h2>
    <form action="summary.php" method="post">
        <label for="people_count">Liczba osób:</label>
        <select name="people_count" id="people_count">
            <?php for ($i = 1; $i <= 4; $i++) { ?>
                <option value="<?php echo $i; ?>" <?php if(isset($_COOKIE['people_count']) && $_COOKIE['people_count'] == $i) echo 'selected'; ?>><?php echo $i; ?></option>
            <?php } ?>
        </select>
        <br>
        <label for="name">Imię:</label>
        <input type="text" name="name" id="name" value="<?php echo isset($_COOKIE['name']) ? $_COOKIE['name'] : ''; ?>" required><br>
        <label for="surname">Nazwisko:</label>
        <input type="text" name="surname" id="surname" value="<?php echo isset($_COOKIE['surname']) ? $_COOKIE['surname'] : ''; ?>" required><br>
        <label for="address">Adres:</label>
        <input type="text" name="address" id="address" value="<?php echo isset($_COOKIE['address']) ? $_COOKIE['address'] : ''; ?>" required><br>
        <label for="credit_card">Numer karty kredytowej:</label>
        <input type="text" name="credit_card" id="credit_card" value="<?php echo isset($_COOKIE['credit_card']) ? $_COOKIE['credit_card'] : ''; ?>" required><br>
        <label for="email">E-mail:</label>
        <input type="email" name="email" id="email" value="<?php echo isset($_COOKIE['email']) ? $_COOKIE['email'] : ''; ?>" required><br>
        <label for="date">Data pobytu:</label>
        <input type="date" name="date" id="date" value="<?php echo isset($_COOKIE['date']) ? $_COOKIE['date'] : ''; ?>" required><br>
        <label for="arrival_time">Godzina przyjazdu:</label>
        <input type="time" name="arrival_time" id="arrival_time" value="<?php echo isset($_COOKIE['arrival_time']) ? $_COOKIE['arrival_time'] : ''; ?>" required><br>
        <input type="checkbox" name="child_bed" id="child_bed" <?php if(isset($_COOKIE['child_bed']) && $_COOKIE['child_bed'] == 'Tak') echo 'checked'; ?>>
        <label for="child_bed">Potrzeba dostawienia łóżka dla dziecka</label><br>
        <label for="amenities">Udogodnienia (wciśnij klawisz CTRL by wybrać więcej niż jedno udogodnienie):</label><br>
        <select name="amenities[]" id="amenities" multiple>
            <option value="Klimatyzacja" <?php if(isset($_COOKIE['amenities']) && strpos($_COOKIE['amenities'], 'Klimatyzacja') !== false) echo 'selected'; ?>>Klimatyzacja</option>
            <option value="Popielniczka" <?php if(isset($_COOKIE['amenities']) && strpos($_COOKIE['amenities'], 'Popielniczka') !== false) echo 'selected'; ?>>Popielniczka dla palacza</option>
            <option value="Szampan" <?php if(isset($_COOKIE['amenities']) && strpos($_COOKIE['amenities'], 'Szampan') !== false) echo 'selected'; ?>>Butelka szampana</option>
            <option value="Kwiaty" <?php if(isset($_COOKIE['amenities']) && strpos($_COOKIE['amenities'], 'Kwiaty') !== false) echo 'selected'; ?>>Bukiet kwiatów</option>
        </select><br>
        <input type="submit" value="Wyślij">
    </form>
    <?php
    if (isset($_POST['delete_cookies']) && $_POST['delete_cookies'] == 'true') {
        // Usuń ciasteczka
        setcookie("people_count", "", time() - 3600, "/");
        setcookie("name", "", time() - 3600, "/");
        setcookie("surname", "", time() - 3600, "/");
        setcookie("address", "", time() - 3600, "/");
        setcookie("credit_card", "", time() - 3600, "/");
        setcookie("email", "", time() - 3600, "/");
        setcookie("date", "", time() - 3600, "/");
        setcookie("arrival_time", "", time() - 3600, "/");
        setcookie("child_bed", "", time() - 3600, "/");
        setcookie("amenities", "", time() - 3600, "/");
        header("Location: index.php");
        exit;
    }
    ?>
<?php } else { ?>
    <h2 style="color: crimson"><?php echo $access_denied_message; ?></h2>
    <h2>Logowanie</h2>
    <form action="index.php" method="post">
        <label for="username">Login:</label>
        <input type="text" name="username" id="username" required><br>
        <label for="password">Hasło:</label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" name="login" value="Zaloguj">
    </form>
    <p>Podpowiedź: login to admin, hasło to pass</p>

<?php } ?>

</body>
</html>