import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    final String modelName; // The car model name
    private double[] position = {0,0}; //position of the car, [0] is x and [1] is y
    private String direction = "n";

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelname;
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public String getDirection(){
        return direction;
    }

    public double[] getPosition(){
        return position;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void move(){
        switch(direction){
            case "n": position[1]=position[1]+currentSpeed; break;
            case "e": position[0]=position[0]+currentSpeed; break;
            case "w": position[0]=position[0]-currentSpeed; break;
            case "s": position[1]=position[1]-currentSpeed; break;
        }
    }

    @Override
    public void turnLeft(){
        switch(this.direction){
            case "n": direction="w"; break;
            case "w": direction="s"; break;
            case "s": direction="e"; break;
            case "e": direction="n"; break;
        }
    }

    @Override
    public void turnRight(){
        switch(direction){
            case "n": direction="e"; break;
            case "e": direction="s"; break;
            case "s": direction="w"; break;
            case "w": direction="n"; break;
        }
    }

    public void gas(double amount){
        if(amount>0 && amount<1){
            incrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("Oustide gas interval, must be between 0 and 1");
        }
    }

    public void brake(double amount){
        if(amount>0 && amount<1){
            decrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("Oustide gas interval, must be between 0 and 1");
        }
    }

}

