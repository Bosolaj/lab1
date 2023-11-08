import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

    private final Saab95 saab = new Saab95();
    private final Volvo240 volvo = new Volvo240();
    @Test
    void construction() {
        assertEquals(2, saab.getNrDoors());
        assertEquals(4, volvo.getNrDoors());
        assertEquals(Color.black, volvo.getColor());
        assertEquals(Color.red, saab.getColor());
        assertEquals(100, volvo.getEnginePower());
        assertEquals(125, saab.getEnginePower());
    }

    @Test
    void movement(){
        volvo.startEngine();
        volvo.incrementSpeed(1);
        assertEquals(0.1+100*0.01*1.25*1, volvo.getCurrentSpeed());
        volvo.move();
        assertEquals(0.1+100*0.01*1.25*1, volvo.getX());
        volvo.turnLeft(); volvo.turnLeft();
        assertEquals(2, volvo.getDir());
        volvo.move();
        assertEquals(0, volvo.getX());

        saab.startEngine();
        saab.incrementSpeed(1);
        assertEquals(0.1+125*1*0.01*1, saab.getCurrentSpeed());
        saab.move();
        assertEquals(0.1+125*1*0.01*1, saab.getX());
        saab.turnLeft(); saab.turnLeft(); saab.move();
        assertEquals(0, saab.getX());
        saab.turnLeft(); saab.turnLeft();
        saab.stopEngine();
        saab.startEngine();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        saab.move();
        assertEquals(0.1+125*1*0.01*1.3, saab.getX());


    }

}