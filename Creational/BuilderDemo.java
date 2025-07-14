/*
Scenario:
A Bangladeshi fast food restaurant builds custom burgers with optional toppings.
Builder pattern separates burger construction from its representation.
Allows flexible creation of complex burgers step-by-step.
*/

class Burger {
    private String bread;
    private String meat;
    private boolean cheese;
    private boolean lettuce;
    private boolean tomato;

    private Burger(Builder builder) {
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }

    public void show() {
        System.out.println("Burger with " + bread + ", " + meat +
                (cheese ? ", Cheese" : "") +
                (lettuce ? ", Lettuce" : "") +
                (tomato ? ", Tomato" : ""));
    }

    public static class Builder {
        private String bread;
        private String meat;
        private boolean cheese;
        private boolean lettuce;
        private boolean tomato;

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder setMeat(String meat) {
            this.meat = meat;
            return this;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addLettuce() {
            this.lettuce = true;
            return this;
        }

        public Builder addTomato() {
            this.tomato = true;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Burger burger = new Burger.Builder()
                .setBread("Sesame")
                .setMeat("Chicken")
                .addCheese()
                .addLettuce()
                .build();
        burger.show();
    }
}
