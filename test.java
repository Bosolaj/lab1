import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

    private final Saab95 saab = new Saab95();
    private final Volvo240 volvo = new Volvo240();
    @Test
    void construction() {
        assertEquals(2, saab.getNrDoors());
        assertEquals(4, volvo.getNrDoors());
    }

}