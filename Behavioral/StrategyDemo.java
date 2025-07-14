/*
Scenario:
Bangladeshi e-commerce supports multiple payment methods.
Strategy pattern allows changing payment algorithm dynamically.
*/

interface PaymentStrategy {
    void pay(int amount);
}

class BkashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Bkash.");
    }
}

class NagadPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Nagad.");
    }
}

class Checkout {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.setPaymentStrategy(new BkashPayment());
        checkout.pay(500);

        checkout.setPaymentStrategy(new NagadPayment());
        checkout.pay(750);
    }
}
