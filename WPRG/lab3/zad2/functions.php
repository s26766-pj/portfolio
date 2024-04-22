<?php

function factorialRecursive($n) {
    if ($n <= 1) {
        return 1;
    } else {
        return $n * factorialRecursive($n - 1);
    }
}

function factorialIterative($n) {
    $result = 1;
    for ($i = 1; $i <= $n; $i++) {
        $result *= $i;
    }
    return $result;
}

function measureTime($function, $argument) {
    $start = microtime(true);
    $result = $function($argument);
    $end = microtime(true);
    $executionTime = ($end - $start) * 1000;
    return array($result, $executionTime);
}

