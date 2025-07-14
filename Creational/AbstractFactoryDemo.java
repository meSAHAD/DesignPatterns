/*
Scenario:
A Bangladeshi vehicle factory produces different vehicle families: Cars and Bikes.
Each family has variants like Sedan and SUV for Cars, and Sports and Cruiser for Bikes.
Abstract Factory encapsulates creation of related objects without specifying classes.
*/

interface Car {
    void drive();
}

interface Bike {
    void ride();
}

// Car implementations
class SedanCar implements Car {
    public void drive() {
        System.out.println("Driving Sedan Car.");
    }
}

class SUVCar implements Car {
    public void drive() {
        System.out.println("Driving SUV Car.");
    }
}

// Bike implementations
class SportsBike implements Bike {
    public void ride() {
        System.out.println("Riding Sports Bike.");
    }
}

class CruiserBike implements Bike {
    public void ride() {
        System.out.println("Riding Cruiser Bike.");
    }
}

// Abstract Factory
interface VehicleFactory {
    Car createCar();

    Bike createBike();
}

// Concrete factories
class CityVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new SedanCar();
    }

    public Bike createBike() {
        return new CruiserBike();
    }
}

class OffroadVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new SUVCar();
    }

    public Bike createBike() {
        return new SportsBike();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory cityFactory = new CityVehicleFactory();
        Car cityCar = cityFactory.createCar();
        Bike cityBike = cityFactory.createBike();
        cityCar.drive();
        cityBike.ride();

        VehicleFactory offroadFactory = new OffroadVehicleFactory();
        Car offroadCar = offroadFactory.createCar();
        Bike offroadBike = offroadFactory.createBike();
        offroadCar.drive();
        offroadBike.ride();
    }
}
