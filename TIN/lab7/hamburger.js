document.getElementById('hamburger-btn').addEventListener('click', function() {
    var nav = document.querySelector('nav');
    if (nav.style.display === '' || nav.style.display === 'none') {
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});

window.addEventListener('resize', function() {
    var nav = document.querySelector('nav');
    var windowWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    if (windowWidth > 600) {
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});

window.addEventListener('load', function() {
    var nav = document.querySelector('nav');
    var windowWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    if (windowWidth > 600) {
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});
