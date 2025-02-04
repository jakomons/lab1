
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class carTest{

    car Car = new car(20,120.0,60.0,Color.red,"Nissan"){};

    @Test
    void TestConstructor() {
        assertEquals(Color.red, Car.getColor());
        assertEquals(20, Car.getNrDoors());
    }

    @Test
    void TestMove() {
        Car.turnLeft();
        assertEquals("w", Car.getDirection());
        Car.turnRight();
        assertEquals("n", Car.getDirection());
        Car.move();
        assertEquals(new double[]{0.0, 60.0}[1], Car.getPosition()[1]);
        Car.turnLeft();
        Car.move();
        assertEquals(new double[]{-60.0, 60.0}[0], Car.getPosition()[0]);
    }

    @Test
    void TestInterval() {
        Car.gas(0.5);
        assertEquals(60.6, Car.getCurrentSpeed());
        Car.brake(0.5);
        assertEquals(60, Car.getCurrentSpeed());
        for(int i = 0; i < 10000; i++)
        {
            Car.gas(0.5);
        }
        assertEquals(120, Car.getCurrentSpeed());
    }
    
    @Test
    void TestIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Car.brake(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> Car.gas(2));
        Assert.assertThrows(IllegalArgumentException.class, () -> Car.brake(-0.5));
    }
}

