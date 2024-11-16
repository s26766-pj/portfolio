console.log("Zadanie 11.1\n")

let auto = {
    year_of_production: null,
    mileage: null,
    starting_price: 99000,
    final_price: null,

    increaseStartingPrice: function () {
        this.starting_price += 1000;
    },

    decreaseFinalPriceRelativeToAge: function () {
        let currentYear = new Date().getFullYear();
        let carAge = currentYear - this.year_of_production;
        this.final_price -= 1000 * carAge;
    },

    decreaseFinalPriceRelativeToMileage: function () {
        let numberOfEveryOneHundredThousandKilometers = Math.floor(this.mileage / 100000);
        this.final_price -= 10000 * numberOfEveryOneHundredThousandKilometers;
    },

    setMileageAndYearOfProduction: function (setMileage, setYearOfProduction) {
        this.mileage = setMileage;
        this.year_of_production = setYearOfProduction;
        this.final_price = this.starting_price;
        this.decreaseFinalPriceRelativeToAge();
        this.decreaseFinalPriceRelativeToMileage();
    },

    toString: function () {
        return `\n\n\t\tRok produkcji: ${this.year_of_production}
        Przebieg: ${this.mileage} km
        Cena wyjściowa: ${this.starting_price} zł
        Cena końcowa: ${this.final_price} zł\n\n`;
    },

};

// Obiekt "auto"
console.log("Auto: " + auto)

// Przykładowe użycie
auto.increaseStartingPrice();
console.log("Nowa cena wyjściowa: " + auto.starting_price + " zł");

auto.setMileageAndYearOfProduction(250000, 2003);
console.log("Auto po aktualizacji danych: " + auto)

console.log("Zadanie 11.2\n")

let expensive_automobiles = [
    { year_of_production: 2010, mileage: 150000, starting_price: 12000, final_price: null },
    { year_of_production: 2015, mileage: 80000, starting_price: 15000, final_price: null },
    { year_of_production: 2020, mileage: 5000, starting_price: 20000, final_price: null }
];

function addExpensiveAutomobileToTheTable(automobileToAdd) {
    if (
        typeof automobileToAdd === 'object' &&
        automobileToAdd !== null &&
        !Array.isArray(automobileToAdd)
    ) {
        if (automobileToAdd.starting_price > 10000) {
            expensive_automobiles.push(automobileToAdd);
            console.log("Dodano obiekt typu auto do tablicy.");
        } else {
            console.log("Odrzucono: Auto nie spełnia warunku cenowego.");
        }
    } else {
        console.log("Błąd: Próba dodania nieprawidłowego elementu do tablicy.");
    }
}

function increaseYearOfProductionForEachAutomobileInTable() {
    expensive_automobiles.forEach(function(auto) {
        auto.year_of_production++;
    });
    console.log("Zwiększono rok wszystkich aut o 1.");
}

const honda = {
    year_of_production: 2011,
    mileage: 140000,
    starting_price: 12000,
    final_price: null
};

const audi = {
    year_of_production: 2009,
    mileage: 270000,
    starting_price: 9000,
    final_price: null
};

const ford = {
    year_of_production: 2007,
    mileage: 250000,
    starting_price: 5000,
    final_price: null
};

const invalidElement = "String";

addExpensiveAutomobileToTheTable(honda);
addExpensiveAutomobileToTheTable(audi);
addExpensiveAutomobileToTheTable(ford);
addExpensiveAutomobileToTheTable(invalidElement);

increaseYearOfProductionForEachAutomobileInTable();
console.log("Tablica po zwiększeniu roku:", expensive_automobiles);

