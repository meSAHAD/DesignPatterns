/*
Scenario:
A Bangladeshi kitchen follows a fixed recipe process: prepare, cook, serve.
Template method defines the skeleton, subclasses provide specifics.
*/

abstract class Recipe {
    public final void prepareDish() {
        prepareIngredients();
        cook();
        serve();
    }

    abstract void prepareIngredients();

    abstract void cook();

    void serve() {
        System.out.println("Dish served on plate.");
    }
}

class BiriyaniRecipe extends Recipe {
    void prepareIngredients() {
        System.out.println("Cut meat, wash rice.");
    }

    void cook() {
        System.out.println("Cook biriyani with spices.");
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Recipe recipe = new BiriyaniRecipe();
        recipe.prepareDish();
    }
}
