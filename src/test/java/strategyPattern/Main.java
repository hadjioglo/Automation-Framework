package strategyPattern;

import strategyPattern.ducks.Duck;
import strategyPattern.ducks.MallardDuck;
import strategyPattern.ducks.ModelDuck;
import strategyPattern.fly.FlyRocketPowered;

public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        System.out.println("----------------------------------");

        Duck modelDuck1 = new ModelDuck();
        modelDuck1.performFly();
        modelDuck1.setFlyingBehavior(new FlyRocketPowered());
        modelDuck1.performFly();
    }
}
