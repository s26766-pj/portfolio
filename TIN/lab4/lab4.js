console.log("Zadanie 1.");
function czyTrojkaPitagorejska(a, b, c) {
    const warunek1 = a * a + b * b === c * c;
    const warunek2 = b * b + c * c === a * a;
    const warunek3 = a * a + c * c === b * b;

    console.log("Podano liczby:", a, b, c);

    if (warunek1 || warunek2 || warunek3) {
        console.log("To jest trójka pitagorejska!");
    } else {
        console.log("To nie jest trójka pitagorejska.");
    }
}
// Przykładowe użycie funkcji
czyTrojkaPitagorejska(1, 2, 3);
czyTrojkaPitagorejska(15, 9, 12);

console.log("\nZadanie 2.");
function liczbyPodzielne(a, b, c) {
    if (a > b) {
        console.log("Błąd: a musi być mniejsze lub równe b");
        return;
    }

    const wyniki = [];

    for (let i = a; i <= b; i++) {
        if (i % c === 0) {
            wyniki.push(i);
        }
    }

    console.log(`Liczby podzielne przez ${c} w przedziale od ${a} do ${b}:`);
    console.log(wyniki);
}

// Przykładowe użycie funkcji
liczbyPodzielne(10, 50, 5);
console.log("\nZadanie 3.");
function tabliczka(bok) {
    for (let i = 1; i <= bok; i++) {
        let wiersz = '';
        for (let j = 1; j <= bok; j++) {
            wiersz += (i * j) + ' ';
        }
        console.log(wiersz.trim());
    }
}

// Przykładowe użycie funkcji
tabliczka(3);
console.log("\nZadanie 4.");
function fibonacci(length) {
    let fibArray = [];

    for (let i = 0; i < length; i++) {
        if (i <= 1) {
            fibArray.push(i);
        } else {
            fibArray.push(fibArray[i - 1] + fibArray[i - 2]);
        }
    }
    console.log(`Ciąg Fibonacciego o długości ${length}:`, fibArray);

}

// Przykładowe użycie funkcji
fibonacci(20);
console.log("\nZadanie 5.");
function choinka(wysokosc) {
    for (let i = 1; i <= wysokosc; i++) {
        let gwiazdki = '*'.repeat(i);
        console.log(gwiazdki);
    }
}

// Przykładowe użycie funkcji
choinka(4);
console.log("\nZadanie 6.");
function choinkaNoca(wysokosc) {
    for (let i = 0; i < wysokosc; i++) {
        let spacje = ' '.repeat(2 * i);
        let gwiazdkiPrzed = '*'.repeat(wysokosc - i);
        let gwiazdkiPo = '*'.repeat(wysokosc - i);

        console.log(gwiazdkiPrzed + spacje + gwiazdkiPo);
    }

    let szerokoscPodstawy = 2 * wysokosc;
    let gwiazdkiPodstawa = '*'.repeat(szerokoscPodstawy);
    console.log(gwiazdkiPodstawa);
}

// Przykładowe użycie funkcji
choinkaNoca(6);
console.log("\nZadanie 7.");
function obliczPole(figura, parametry) {
    let pole;

    switch (figura) {
        case 'prostokat':
            if (parametry.length === 2) {
                pole = parametry[0] * parametry[1];
            } else {
                return 'Nieprawidłowa liczba parametrów dla prostokąta';
            }
            break;

        case 'trapez':
            if (parametry.length === 3) {
                pole = ((parametry[0] + parametry[1]) / 2) * parametry[2];
            } else {
                return 'Nieprawidłowa liczba parametrów dla trapezu';
            }
            break;

        case 'rownoleglobok':
            if (parametry.length === 2) {
                pole = parametry[0] * parametry[1];
            } else {
                return 'Nieprawidłowa liczba parametrów dla równoległoboku';
            }
            break;

        case 'trojkat':
            if (parametry.length === 2) {
                pole = (parametry[0] * parametry[1]) / 2;
            } else {
                return 'Nieprawidłowa liczba parametrów dla trójkąta';
            }
            break;

        default:
            return 'Nieznana figura';
    }

    return `${figura}, pole wynosi: ${pole}`;
}

// Przykłady użycia funkcji
console.log(obliczPole('prostokat', [4, 5]));
console.log(obliczPole('trapez', [3, 5, 4]));
console.log(obliczPole('rownoleglobok', [6, 8]));
console.log(obliczPole('trojkat', [4, 6]));
console.log("\nZadanie 8.");
const rectangleArea = (a, b) => a * b;
const trapezoidArea = (a, b, h) => ((a + b) * h) / 2;
const parallelogramArea = (base, height) => base * height;
const triangleArea = (base, height) => (base * height) / 2;
const calculateArea = (figure, params, callback) => {
    return callback(...params);
};
// Zdefinowanie długości boków
const rectangleParams = [4, 6];
const trapezParams = [3, 5, 4];
const parallelogramParams = [7, 3];
const triangleParams = [5, 8];
// Obliczenie pola (callback)
const rectangleAreaResult = calculateArea("rectangle", rectangleParams, rectangleArea);
const trapezArea = calculateArea("trapez", trapezParams, trapezoidArea);
const parallelogramAreaResult = calculateArea("parallelogram", parallelogramParams, parallelogramArea);
const triangleAreaResult = calculateArea("triangle", triangleParams, triangleArea);
// Wydruk wyników
console.log("Pole prostokąta:", rectangleAreaResult);
console.log("Pole trapezu:", trapezArea);
console.log("Pole równoległoboku:", parallelogramAreaResult);
console.log("Pole trójkąta:", triangleAreaResult);
console.log("\nZadanie 9.");
function pascalsTriangle(height) {
    const triangle = [];

    for (let i = 0; i < height; i++) {
        triangle[i] = [];
        triangle[i][0] = 1;

        for (let j = 1; j < i; j++) {
            triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }

        triangle[i][i] = 1;
    }

    for (let i = 0; i < height; i++) {
        let spaces = ' '.repeat(2 * (height - i - 1));
        let numbers = triangle[i].join('   ');
        console.log(spaces + numbers + spaces);
    }
}

// Przykładowe użycie funkcji
pascalsTriangle(5);
console.log("\nZadanie 10.");
function cenzura(niedozwolone, zdanie) {
    const slowa = zdanie.split(' ');

    for (let i = 0; i < slowa.length; i++) {
        if (niedozwolone.some(slowo => slowa[i].toLowerCase().includes(slowo.toLowerCase()))) {
            slowa[i] = '*';
        }
    }

    const ocenzurowaneZdanie = slowa.join(' ');
    console.log(ocenzurowaneZdanie);
}

// Przykładowe użycie funkcji
cenzura(['Ala', 'kot'], 'Ala ma kota i psa');
