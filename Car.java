import java.awt.*;

public class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name
    private double x = 0;
    private double y = 0;
    private int dir = 0;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
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
    public void brake(double amount){
        //decrementSpeed(amount);
    }
}

