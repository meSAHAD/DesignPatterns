

interface Shirt {
    void wear();
}

class CasualShirt implements Shirt {
    public void wear() {
        System.out.println("Wearing Casual Shirt.");
    }
}

class FormalShirt implements Shirt {
    public void wear() {
        System.out.println("Wearing Formal Shirt.");
    }
}

abstract class ShirtFactory {
    abstract Shirt createShirt();

    public void orderShirt() {
        Shirt shirt = createShirt();
        shirt.wear();
    }
}

class CasualShirtFactory extends ShirtFactory {
    Shirt createShirt() {
        return new CasualShirt();
    }
}

class FormalShirtFactory extends ShirtFactory {
    Shirt createShirt() {
        return new FormalShirt();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ShirtFactory casualFactory = new CasualShirtFactory();
        casualFactory.orderShirt();

        ShirtFactory formalFactory = new FormalShirtFactory();
        formalFactory.orderShirt();
    }
}
