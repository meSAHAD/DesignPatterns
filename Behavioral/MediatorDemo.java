/*
Scenario:
Traders in Dhaka stock exchange communicate through a broker.
Mediator manages message exchange, reducing tight coupling between traders.
*/

class Mediator {
    void send(String message, Trader trader) {
        System.out.println(trader.getName() + " says: " + message);
    }
}

class Trader {
    private String name;
    private Mediator mediator;

    Trader(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        mediator.send(message, this);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        Mediator broker = new Mediator();

        Trader sahad = new Trader("Sahad", broker);
        Trader rafi = new Trader("Rafi", broker);

        sahad.sendMessage("Buying 100 shares of Grameenphone");
        rafi.sendMessage("Selling 50 shares of Robi");
    }
}
