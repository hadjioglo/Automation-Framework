package training.strategyPattern.ducks;

import training.strategyPattern.fly.FlyWithWings;
import training.strategyPattern.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyingBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("Looks like Mallard duck");
    }
}
