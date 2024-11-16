package org.carrental;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestExampleTest {

    private UnitTestExample unitTestExample = new UnitTestExample();

    public static Stream<Arguments> provideTwoIntegers() {
        return Stream.of(Arguments.of(1,2),
                Arguments.of(5,6),
                Arguments.of(10,11));
    }


    @Test
    void shouldCorrectlyAddTwoIntegers(){
        int result = unitTestExample.add(1, 1);

        assertEquals(2, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,5})
    void shouldCorrectlyAddTwoIntegers(int a){
        int result = unitTestExample.add(1, a);

        assertEquals(a + 1, result);
    }


    @ParameterizedTest
    @MethodSource(value = "provideTwoIntegers")
    void shouldCorrectlyAddTwoIntegers(int a, int b) {
        int result = unitTestExample.add(a, b);

        assertEquals(a+b, result);
    }

}