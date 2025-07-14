/*
Scenario:
An online Dhaka-based e-commerce platform processes orders through Inventory, Payment, and Shipping.
Facade provides a simplified interface hiding subsystem complexities.
This streamlines client interactions.
*/

class Inventory {
    public void checkStock() {
        System.out.println("Inventory checked.");
    }
}

class Payment {
    public void processPayment() {
        System.out.println("Payment processed.");
    }
}

class Shipping {
    public void shipProduct() {
        System.out.println("Product shipped.");
    }
}

class OrderFacade {
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();
    private Shipping shipping = new Shipping();

    public void placeOrder() {
        inventory.checkStock();
        payment.processPayment();
        shipping.shipProduct();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder();
    }
}
