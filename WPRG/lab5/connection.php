<?php

$user = 'root';
$pass = '';
$dbName = 'testdb';

$db = new mysqli('localhost', $user, $pass, $dbName);

if ($db->connect_error) {
    die("Nie udało się nawiązać połączenia z bazą danych: " . $db->connect_error);
}

echo "Połączono z bazą danych<br>";

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['title']) && isset($_POST['category'])) {
    $title = $_POST['title'];
    $category = $_POST['category'];
    $insertQuery = "INSERT INTO film (tytuł, kategoria) VALUES (?, ?)";
    $stmt = $db->prepare($insertQuery);
    $stmt->bind_param('ss', $title, $category);

    if ($stmt->execute()) {
        echo "Dodanie danych powiodło się<br>";
    } else {
        echo "Wystąpił błąd przy dodawaniu danych: " . $stmt->error . "<br>";
    }

    $stmt->close();
}

?>

<!DOCTYPE html>
<html>
<head>
    <title>Dodaj film</title>
</head>
<body>

<h2>Dodaj nowy film</h2>
<form method="post" action="">
    <label for="title">Tytuł:</label><br>
    <input type="text" id="title" name="title" required><br><br>
    <label for="category">Kategoria:</label><br>
    <input type="text" id="category" name="category" required><br><br>
    <input type="submit" value="Dodaj">
</form>

<?php

$selectQuery = "SELECT id, tytuł FROM film";
$result = $db->query($selectQuery);

if ($result && $result->num_rows > 0) {
    echo '<h3>Wybierz film do wyświetlenia (mysqli_fetch_row)</h3>';
    echo '<form method="post" action="">';
    echo '<select name="film_id">';
    
    while ($row = $result->fetch_row()) {
        echo '<option value="' . $row[0] . '">' . $row[1] . '</option>';
    }

    echo '</select>';
    echo '<input type="submit" value="Wyświetl">';
    echo '</form>';
}

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['film_id'])) {
    $filmId = $_POST['film_id'];
    $selectQuery = "SELECT id, tytuł, kategoria FROM film WHERE id = ?";
    $stmt = $db->prepare($selectQuery);
    $stmt->bind_param('i', $filmId);
    $stmt->execute();
    $stmt->bind_result($id, $title, $category);

    if ($stmt->fetch()) {
        echo "<h3>Szczegóły filmu:</h3>";
        echo "<table border='5'><tr><th>ID</th><th>Tytuł</th><th>Kategoria</th></tr>";
        echo "<tr><td>$id</td><td>$title</td><td>$category</td></tr>";
        echo "</table>";
    } else {
        echo "Nie znaleziono szczegółów na temat wybranego filmu.<br>";
    }

    $stmt->close();
}

$selectAllQuery = "SELECT id, tytuł, kategoria FROM film";
$result = $db->query($selectAllQuery);

if ($result) {
    $numRows = $result->num_rows;
    
    
    echo "<h3>Wyświetla wszystkie filmy (mysqli_fetch_array):</h3>";
    echo "<table border='5'><tr><th>ID</th><th>Tytuł</th><th>Kategoria</th></tr>";
    while ($row = $result->fetch_array(MYSQLI_ASSOC)) {
        echo "<tr><td>{$row['id']}</td><td>{$row['tytuł']}</td><td>{$row['kategoria']}</td></tr>";
    }
    echo "</table>";
	echo "<h3>Liczba wierszy (mysqli_num_rows): " . $numRows . "</h3>";
} else {
    echo "Błąd przy pobieraniu rekordów: " . $db->error . "<br>";
}

$result->close();
$db->close();

?>

</body>
</html>
