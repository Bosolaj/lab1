import java.awt.*;

public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x = 0; // x-coordinate
    private double y = 0; // y-coordinate
    private int dir = 0; // Direction 0-North, 1-East, 2-South, 3-West

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
        if (dir == 0) { // North
            x += getCurrentSpeed();
        }
        else if (dir == 1) { // East
            y += getCurrentSpeed();
        }
        else if (dir == 2) { // South
            x -= getCurrentSpeed();
        }
        else if (dir == 3) { // West
            y -= getCurrentSpeed();
        }
    }
    public void turnLeft() {
        dir = Math.floorMod(dir - 1, 4);
    }

    public void turnRight() {
        dir = Math.floorMod(dir + 1, 4);
    }

    public double getX() {
        return x;
    }
    public double getY() {return y;}
    public int getDir() {return dir;}

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }



}

