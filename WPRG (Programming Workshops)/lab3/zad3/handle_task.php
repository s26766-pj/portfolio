<?php

function handle_directory($path, $directory_name, $operation = "read") {
    // Sprawdzenie czy ścieżka kończy się znakiem "/"
    if (substr($path, -1) !== '/') {
        $path .= '/';
    }

    // Sprawdzenie czy podany katalog istnieje
    if (!is_dir($path)) {
        return ["Podana ścieżka nie istnieje."];
    }

    switch ($operation) {
        case "read":
            $contents = scandir($path . $directory_name);
            return $contents ? $contents : ["Katalog jest pusty."];
        case "delete":
            // Sprawdzenie czy katalog istnieje
            if (!is_dir($path . $directory_name)) {
                return ["Podany katalog nie istnieje."];
            }
            // Sprawdzenie czy katalog jest pusty
            if (count(scandir($path . $directory_name)) > 2) {
                return ["Nie można usunąć katalogu, ponieważ nie jest pusty."];
            }
            // Usunięcie katalogu
            if (rmdir($path . $directory_name)) {
                return ["Katalog został pomyślnie usunięty."];
            } else {
                return ["Wystąpił błąd podczas usuwania katalogu."];
            }
        case "create":
            // Stworzenie katalogu
            if (mkdir($path . $directory_name)) {
                return ["Katalog został pomyślnie utworzony."];
            } else {
                return ["Wystąpił błąd podczas tworzenia katalogu."];
            }
        default:
            return ["Nieprawidłowa operacja."];
    }
}

// Przetworzenie danych z formularza
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $path = $_POST["directory_path"];
    $directory_name = $_POST["directory_name"];
    $operation = isset($_POST["operation"]) ? $_POST["operation"] : "read";

    // Wywołanie funkcji
    $result = handle_directory($path, $directory_name, $operation);
    foreach ($result as $item) {
        echo $item . '<br>';
    }


}
