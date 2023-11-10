import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestSaab {
    public final Saab95 saab = new Saab95();


    @Test
    public void input_within_interval() {
        saab.startEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(2);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
        saab.gas(-4);
        assertEquals(oldSpeed, saab.getCurrentSpeed());
    }

    @Test
    public void currentSpeed_within_interval() {
        saab.startEngine();
        for (int i = 0; i < 50; i++) {
            saab.gas(1);
            assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower() && saab.getCurrentSpeed() >= 0);
        }
        for (int i = 0; i < 60; i++) {
            saab.brake(1);
            assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower() && saab.getCurrentSpeed() >= 0);
        }
    }

    @Test
    public void test_gas_cannot_go_decrease_speed() {
        saab.startEngine();
        for (int i = 0; i < 20; i++) {
            double saabSpeed = saab.getCurrentSpeed();
            saab.gas(1);
            assertTrue(saabSpeed <= saab.getCurrentSpeed());
        }
    }
    @Test
    public void test_brake_cannot_go_increase_speed() {
        saab.startEngine();
        for (int i = 0; i < 20; i++) {
            saab.gas(1);
        }

        for (int i = 0; i < 20; i++) {
            double saabSpeed = saab.getCurrentSpeed();
            saab.brake(1);
            assertTrue(saabSpeed >= saab.getCurrentSpeed());
        }
    }
    @Test
    void testGetDoors() {
        assertEquals(2, saab.getNrDoors());
    }
    @Test
    void testGetColor(){
        assertEquals(Color.red, saab.getColor());
    }
    @Test
    void testGetEnginePower(){
        assertEquals(125, saab.getEnginePower());
    }

    @Test
    void test_move_forwards_then_backwards() {

        saab.startEngine();
        saab.incrementSpeed(1);
        saab.move();
        assertEquals(0.1+125*1*0.01*1, saab.getX());
        saab.turnLeft(); saab.turnLeft(); saab.move();
        assertEquals(0, saab.getX());
        saab.turnLeft(); saab.turnLeft();
    }

    @Test
    void testTurboMovement(){
        saab.startEngine();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        saab.move();
        assertEquals(0.1+125*1*0.01*1.3, saab.getX());
    }
}
