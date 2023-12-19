console.log("Zadanie 12\n")
class Grade {
    constructor(course, value) {
        this.course = course;
        this.value = value;
    }
}

class Student {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = [];
        this.averageGrade = 0;
    }

    hello() {
        return `Witaj, ${this.firstName} ${this.lastName}! Twoja średnia ocen wynosi: ${this.averageGrade}`;
    }

    set setGrade(x) {
        if (x instanceof Grade) {
            this.grades.push(x);
            this.calculateGradeAverage()
        } else {
            console.log("Błąd!");
        }
    }

    calculateGradeAverage() {
        if (this.grades.length === 0) {
            this.averageGrade = 0;
            return;
        }

        let sum = 0;
        this.grades.forEach(grade => {
            sum += grade.value;
        });

        this.averageGrade = sum / this.grades.length;
    }

    get getGrades() {
        if (this.grades.length === 0) {
            return "Brak ocen.";
        }

        let result = "";
        this.grades.forEach(grade => {
            result += `Przedmiot: ${grade.course} - ocena ${grade.value}. `;
        });

        return result.trim();
    }
}

const s = new Student("Jan", "Kowalski");
console.log("\nFunkcja hello:\n")
console.log(s.hello());

s.setGrade = new Grade("WIA", 4);
s.setGrade = new Grade('TIN', 3);
s.setGrade = new Grade('POJ', 2);

console.log("\nFunkcja getGrades:\n")
console.log(s.getGrades);
console.log("\nFunkcja hello po dodaniu ocen:\n")
console.log(s.hello());
