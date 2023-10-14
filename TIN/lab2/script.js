document.addEventListener("DOMContentLoaded", function () {
    const assignmentLink = document.querySelector(".navigation li:nth-child(2)");
    const hiddenLinks = document.querySelectorAll(".navigation li:not(:first-child):not(:nth-child(2))");

    let hideTimeout;

    assignmentLink.addEventListener("mouseover", function () {
        // Po najechaniu na link "Assignment", pokaż ukryte linki
        hiddenLinks.forEach((link) => {
            link.style.display = "block";
        });

        // Jeśli kursor znajduje się na jednym z ukrytych linków, anuluj ukrywanie po 2 sekundach
        hiddenLinks.forEach((link) => {
            link.addEventListener("mouseover", function () {
                clearTimeout(hideTimeout);
            });

            link.addEventListener("mouseout", function () {
                hideTimeout = setTimeout(() => {
                    hiddenLinks.forEach((hiddenLink) => {
                        hiddenLink.style.display = "none";
                    });
                }, 5000);
            });
        });

        // Po 2 sekundach ukryj ukryte linki, jeśli kursor nie jest na nich
        hideTimeout = setTimeout(() => {
            hiddenLinks.forEach((link) => {
                link.style.display = "none";
            });
        }, 3000);
    });

// Pobierz element formularza
    const ratingForm = document.getElementById("rating-form");

// Pobierz element div z napisem "Thank You!"
    const thankYouMessage = document.querySelector(".thank-you");

// Dodaj obsługę zdarzenia submit do formularza
    ratingForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Zatrzymaj domyślną akcję przekierowania
        thankYouMessage.style.display = "block"; // Wyświetl napis "Thank You!"
    });

});




