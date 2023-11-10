import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVolvo {
    private final Volvo240 volvo = new Volvo240();

    @Test
    public void input_within_interval() {

        volvo.startEngine();
        double oldSpeed = volvo.getCurrentSpeed();
        volvo.gas(2);
        assertEquals(oldSpeed, volvo.getCurrentSpeed());
        volvo.gas(-4);
        assertEquals(oldSpeed, volvo.getCurrentSpeed());
    }

    @Test
    public void currentSpeed_within_interval() {
        volvo.startEngine();
        for (int i = 0; i < 50; i++) {
            volvo.gas(1);
            assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower() && volvo.getCurrentSpeed() >= 0);

        }
        for (int i = 0; i < 60; i++) {
            volvo.brake(1);
            assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower() && volvo.getCurrentSpeed() >= 0);
        }
    }

    @Test
    public void test_gas_cannot_go_decrease_speed() {
        volvo.startEngine();
        for (int i = 0; i < 20; i++) {
            double volvoSpeed = volvo.getCurrentSpeed();
            volvo.gas(1);
            assertTrue(volvoSpeed <= volvo.getCurrentSpeed());
        }
    }

    @Test
    public void test_brake_cannot_go_increase_speed() {
        volvo.startEngine();
        for (int i = 0; i < 20; i++) {
            volvo.gas(1);
        }

        for (int i = 0; i < 20; i++) {
            double volvoSpeed = volvo.getCurrentSpeed();
            volvo.brake(1);
            assertTrue(volvoSpeed >= volvo.getCurrentSpeed());
        }
    }

    @Test
    void testGetNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    void testGetColors() {
        assertEquals(Color.black, volvo.getColor());
    }
    @Test
    void testGetEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }

    @Test
    void test_move_forwards_then_backwards(){
        volvo.startEngine();
        volvo.incrementSpeed(1);
        volvo.move();
        assertEquals(0.1+100*0.01*1.25*1, volvo.getX());
        volvo.turnLeft(); volvo.turnLeft();
        assertEquals(2, volvo.getDir());
        volvo.move();
        assertEquals(0, volvo.getX());
        volvo.turnLeft(); volvo.turnLeft();
    }


}
