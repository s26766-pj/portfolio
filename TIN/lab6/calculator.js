document.addEventListener("DOMContentLoaded", function() {

    var inputFirstDigit = document.querySelector(".input_first_digit");
    var inputSecondDigit = document.querySelector(".input_second_digit");
    var operatorSelect = document.querySelector(".operators");
    var upperOutput = document.getElementById("upper");
    var lowerOutput = document.getElementById("lower");
    var calculateBtn = document.querySelector(".count");

    calculateBtn.addEventListener("click", function() {

        var firstDigit = parseFloat(inputFirstDigit.value);
        var operator = operatorSelect.value;
        var secondDigit = parseFloat(inputSecondDigit.value);
        var result;

        switch (operator) {
            case "+":
                result = firstDigit + secondDigit;
                break;
            case "-":
                result = firstDigit - secondDigit;
                break;
            case "x":
                result = firstDigit * secondDigit;
                break;
            case ":":
                if (secondDigit !== 0) {
                    result = firstDigit / secondDigit;
                } else {
                    alert("Nie można dzielić przez zero!");
                    return;
                }
                break;
            default:
                alert("Nieznane działanie");
                return;
        }

        upperOutput.innerText = firstDigit.toString() + ' ' + operator + ' ' + secondDigit.toString() +  ' =';
        lowerOutput.innerText = result;
    });
});
