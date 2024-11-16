var currentImageIndex = 0;

function openLightbox(index) {
    currentImageIndex = index;
    updateLightboxImage();
    document.getElementById('lightbox').style.display = 'flex';
}

function closeLightbox() {
    document.getElementById('lightbox').style.display = 'none';
}

function changeImage(direction) {
    currentImageIndex += direction;
    updateLightboxImage();
}

function updateLightboxImage() {
    var lightboxImage = document.getElementById('lightbox-image');
    var images = document.querySelectorAll('.gallery .image img');

    if (currentImageIndex < 0) {
        currentImageIndex = images.length - 1;
    } else if (currentImageIndex >= images.length) {
        currentImageIndex = 0;
    }

    lightboxImage.src = images[currentImageIndex].src;
}
