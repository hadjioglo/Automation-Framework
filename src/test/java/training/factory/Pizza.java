package training.factory;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("cutting pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza into official PizzaStore box");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "made pizza";
    }
}
