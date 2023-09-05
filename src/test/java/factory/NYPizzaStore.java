package factory;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Style Sauce and Cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Style Sauce and Cheese Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Style Sauce and Cheese Pizza");
        }
        return pizza;
    }
}
