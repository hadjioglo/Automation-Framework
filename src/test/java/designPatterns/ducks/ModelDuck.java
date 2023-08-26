package designPatterns.ducks;

import designPatterns.fly.FlyNoWay;
import designPatterns.quack.Quack;

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
