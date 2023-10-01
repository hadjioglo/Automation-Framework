package training.strategyPattern.ducks;

import training.strategyPattern.fly.FlyNoWay;
import training.strategyPattern.quack.Quack;

public class ModelDuck extends Duck{
    public ModelDuck(){
        flyingBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck");
    }
}
