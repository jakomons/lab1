import java.awt.*;

public class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double[] position = {0,0};
    private String direction = "n";



    private int getNrDoors(){
        return nrDoors;
    }
    private double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    private Color getColor(){
        return color;
    }

    private void setColor(Color clr){
        color = clr;
    }

    private void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower * 0.1;
    }

    public void incrementSpeed(double amount){

        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void move(){
        switch (direction){
            case "n": position[1]++; break;
            case "e": position[0]++; break;
            case "s": position[1]--; break;
            case "w": position[0]--; break;
        }
    }

    @Override
    public void turnLeft(){
        switch (direction){
            case "n": direction = "w"; break;
            case "w": direction = "s"; break;
            case "s": direction = "e"; break;
            case "e": direction = "n"; break;
        }
    }

    @Override
    public void turnRight(){
        switch (direction){
            case "n": direction = "e"; break;
            case "e": direction = "s"; break;
            case "s": direction = "w"; break;
            case "w": direction = "n"; break;
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);
        }
    }
}
