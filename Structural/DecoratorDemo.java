/*
Scenario:
A tea stall in Dhaka offers plain tea, but customers can add milk, sugar, or spices.
Decorator pattern allows adding features dynamically without modifying the base Tea class.
This provides flexible beverage customization.
*/

interface Tea {
    String serve();
}

class PlainTea implements Tea {
    public String serve() {
        return "Plain Tea";
    }
}

class MilkDecorator implements Tea {
    private Tea tea;

    public MilkDecorator(Tea tea) {
        this.tea = tea;
    }

    public String serve() {
        return tea.serve() + " with Milk";
    }
}

class SugarDecorator implements Tea {
    private Tea tea;

    public SugarDecorator(Tea tea) {
        this.tea = tea;
    }

    public String serve() {
        return tea.serve() + " with Sugar";
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Tea tea = new PlainTea();
        tea = new MilkDecorator(tea);
        tea = new SugarDecorator(tea);
        System.out.println(tea.serve());
    }
}
