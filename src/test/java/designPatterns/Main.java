package designPatterns;

import designPatterns.ducks.Duck;
import designPatterns.ducks.MallardDuck;
import designPatterns.ducks.ModelDuck;
import designPatterns.fly.FlyRocketPowered;

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
