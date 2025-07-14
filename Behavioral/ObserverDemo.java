/*
Scenario:
Weather station in Bangladesh notifies devices about temperature changes.
Observers subscribe and get notified on updates.
*/

interface Observer {
    void update(int temperature);
}

class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone display temperature: " + temperature + "°C");
    }
}

class WeatherStation {
    private java.util.List<Observer> observers = new java.util.ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();

        station.addObserver(phoneDisplay);

        station.setTemperature(35);
        station.setTemperature(30);
    }
}
