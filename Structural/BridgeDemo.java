/*
Scenario:
A Bangladeshi TV remote controls multiple TV brands (Walton, Samsung).
Using Bridge, Remote abstraction is decoupled from concrete TV implementations.
This enables independent extension of remotes and TV brands.
*/

interface TV {
    void on();

    void off();
}

class WaltonTV implements TV {
    public void on() {
        System.out.println("Walton TV ON");
    }

    public void off() {
        System.out.println("Walton TV OFF");
    }
}

class SamsungTV implements TV {
    public void on() {
        System.out.println("Samsung TV ON");
    }

    public void off() {
        System.out.println("Samsung TV OFF");
    }
}

abstract class Remote {
    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    abstract void pressPowerButton();
}

class BasicRemote extends Remote {
    public BasicRemote(TV tv) {
        super(tv);
    }

    public void pressPowerButton() {
        tv.on();
        tv.off();
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        TV samsung = new SamsungTV();
        Remote remote = new BasicRemote(samsung);
        remote.pressPowerButton();
    }
}
