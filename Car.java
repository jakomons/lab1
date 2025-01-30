import java.awt.*;

public class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x;
    protected double y;
    protected int direction;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
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
        return enginePower * 0.1;
    }

    public void incrementSpeed(double amount){

        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    private void position(){
        private double[] pos= new double
        return
    }

    @Override
    public void move(){
        double radians = Math.toRadians(direction);
        x += Math.cos(radians) * currentSpeed;
        y += Math.sin(radians) * currentSpeed;
    }

    @Override
    public void turnLeft(){
        direction += (direction - 90 + 360) % 360;
    }

    @Override
    public void turnRight(){
        direction += (direction + 90) % 360;
    }


    public void gas(double amount){
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);
        }
    }
    public static void main(){
        Car car = new Car(2, Color.black, 120, "VolvoV70");
        car.incrementSpeed(0.8);
        car.turnLeft();
        car.move();
        car.move();
        car.turnRight();
        car.move();
        System.out.println(car.getCurrentSpeed());
        System.out.println();
    }


}
