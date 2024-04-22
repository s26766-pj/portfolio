<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Obsługa zadania</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<?php
$default_path = $_SERVER['DOCUMENT_ROOT'];
?>
<form id="taskForm">
    <label for="directory_path">Ścieżka:</label>
    <input type="text" id="directory_path" name="directory_path" value="<?php echo $default_path; ?>" size="50" required><br><br>

    <label for="directory_name">Nazwa katalogu:</label>
    <input type="text" id="directory_name" name="directory_name"><br><br>

    <label for="operation">Operacja:</label>
    <select id="operation" name="operation">
        <option value="read">Odczyt</option>
        <option value="delete">Usunięcie</option>
        <option value="create">Stworzenie</option>
    </select><input type="submit" id="refreshButton" value="Wykonaj operację">


</form>

<div id="result"></div>

<script>
    $(document).ready(function() {
        $("#refreshButton").click(function(event) {
            event.preventDefault();
            $.ajax({
                type: "POST",
                url: "handle_task.php",
                data: $("#taskForm").serialize(),
                success: function(response) {
                    $("#result").html(response);
                }
            });
        });
    });
</script>
</body>
</html>
