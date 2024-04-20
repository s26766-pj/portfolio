<?php
if(isset($_GET['birthdate'])) {
    $birthdate = $_GET['birthdate'];

    function dayOfWeek($date) {
        $days = array('Niedziela', 'Poniedziałek', 'Wtorek', 'Środa', 'Czwartek', 'Piątek', 'Sobota');
        $dayOfWeek = date('w', strtotime($date));
        return $days[$dayOfWeek];
    }

    function calculateAge($date) {
        $now = new DateTime();
        $birthdate = new DateTime($date);
        return $birthdate->diff($now)->y;
    }

    function daysUntilNextBirthday($date) {
        $now = new DateTime();
        $birthdate = new DateTime($date);

        $year = $now->format('Y');
        $month = $birthdate->format('m');
        $day = $birthdate->format('d');

        $nextBirthdate = new DateTime();
        $nextBirthdate->setDate($year, $month, $day);
        if ($nextBirthdate < $now) {
            $nextBirthdate->modify('+1 year');
        }
        $diff = $nextBirthdate->diff($now);
        return $diff->days;
    }

    $dayOfWeek = dayOfWeek($birthdate);
    $age = calculateAge($birthdate);
    $daysUntilNextBirthday = daysUntilNextBirthday($birthdate);
    $ageIfBirthdayToday = $age + 1;

    echo "Urodziłeś/aś się w dniu: $dayOfWeek<br>";
    if ($daysUntilNextBirthday == 0) {
        echo "Masz $ageIfBirthdayToday lat<br>";
        echo "Masz dziś urodziny!";
    } else {
        echo "Masz $age lat<br>";
        echo "Do Twoich następnych urodzin pozostało: $daysUntilNextBirthday dni";
    }
}
?>
