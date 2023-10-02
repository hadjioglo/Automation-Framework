package org.example.training;

import org.example.training.strategyPattern.ducks.Duck;
import org.example.training.strategyPattern.ducks.MallardDuck;
import org.example.training.strategyPattern.ducks.ModelDuck;
import org.example.training.strategyPattern.fly.FlyRocketPowered;

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
