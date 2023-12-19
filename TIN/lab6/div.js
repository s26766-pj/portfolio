function addDiv() {
    var container = document.querySelector('.table-container');
    var newDiv = document.createElement("div");
    newDiv.className = "my-div";
    newDiv.innerText = "Div " + (document.querySelectorAll('.my-div').length + 1);
    container.appendChild(newDiv);
}

function removeDiv() {
    var divs = document.querySelectorAll('.my-div');
    if (divs.length > 0) {
        var removedDiv = divs[0];
        removedDiv.parentNode.removeChild(removedDiv);
    }
}

function changeColor() {
    var div3 = document.querySelectorAll('.my-div')[2];
    if (div3) {
        div3.style.backgroundColor = getRandomColor();
    }
}

function changeText() {
    var divs = document.querySelectorAll('.my-div');
    for (var i = 0; i < divs.length; i++) {
        divs[i].innerText = "Nowy tekst";
    }
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}