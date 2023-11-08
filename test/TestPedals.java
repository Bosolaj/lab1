
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;

class TestPedals {
    private final Saab95 saab = new Saab95();
    private final Volvo240 volvo = new Volvo240();


    @Test
    public void input_within_interval() {
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(2);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
        saab.gas(-4);
        assertEquals(oldSpeed, saab.getCurrentSpeed());

        volvo.startEngine();
        oldSpeed = volvo.getCurrentSpeed();
        volvo.gas(2);
        assertEquals(oldSpeed, volvo.getCurrentSpeed());
        volvo.gas(-4);
        assertEquals(oldSpeed, volvo.getCurrentSpeed());
    }

    @Test
    public void currentSpeed_within_interval() {
        volvo.startEngine();
        saab.startEngine();
        for (int i = 0; i < 50; i++) {
            volvo.gas(1);
            assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower() && volvo.getCurrentSpeed() >= 0);


            saab.gas(1);
            assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower() && saab.getCurrentSpeed() >= 0);
        }
        for (int i = 0; i < 60; i++) {
            volvo.brake(1);
            assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower() && volvo.getCurrentSpeed() >= 0);


            saab.brake(1);
            assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower() && saab.getCurrentSpeed() >= 0);
        }
    }

    @Test
    public void test_gas_cannot_go_negative() {
        volvo.startEngine();
        saab.startEngine();
        for (int i = 0; i < 20; i++) {
            double volvoSpeed = volvo.getCurrentSpeed();
            volvo.gas(1);
            assertTrue(volvoSpeed <= volvo.getCurrentSpeed());

            double saabSpeed = saab.getCurrentSpeed();
            saab.gas(1);
            assertTrue(saabSpeed <= saab.getCurrentSpeed());
        }
    }
    @Test
    public void test_brake_cannot_go_positive() {
        volvo.startEngine();
        saab.startEngine();
        for (int i = 0; i < 20; i++) {
            volvo.gas(1);
            saab.gas(1);
        }

        for (int i = 0; i < 20; i++) {
            double volvoSpeed = volvo.getCurrentSpeed();
            volvo.brake(1);
            assertTrue(volvoSpeed >= volvo.getCurrentSpeed());

            double saabSpeed = saab.getCurrentSpeed();
            saab.brake(1);
            assertTrue(saabSpeed >= saab.getCurrentSpeed());
        }
    }
}

