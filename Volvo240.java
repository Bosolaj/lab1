import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void move(){
        if (dir == 0) {
            x += getCurrentSpeed();
        }
        else if (dir == 1) {
            y += getCurrentSpeed();
        }
        else if (dir == 2) {
            x -= getCurrentSpeed();
        }
        else {
            y -= getCurrentSpeed();
        }
    }
    public void turnLeft() {
        dir = (dir - 1) % 4;
    }

    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
