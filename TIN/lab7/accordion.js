document.addEventListener('DOMContentLoaded', function() {
    var accordionHeaders = document.querySelectorAll('.accordion-header');

    accordionHeaders.forEach(function(header) {
        header.addEventListener('click', function() {
            var content = this.nextElementSibling;

            if (content.style.display === 'block') {
                content.style.display = 'none';
            } else {
                // Zamykamy wszystkie sekcje przed otwarciem nowej
                closeAllSections();
                content.style.display = 'block';
            }
        });
    });

    function closeAllSections() {
        var allContents = document.querySelectorAll('.accordion-content');
        allContents.forEach(function(content) {
            content.style.display = 'none';
        });
    }
});
