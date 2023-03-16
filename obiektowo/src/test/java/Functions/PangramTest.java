package Functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PangramTest {

    @Test
    void pangram_build() {
        assertTrue(Pangram.getResult("the quick brown fox jumps over the lazy dog"));
        assertTrue(Pangram.getResult("pack my box with five dozen liquor jugs"));
        assertTrue(Pangram.getResult("jackdaws love my big sphinx of quartz"));
    }

}