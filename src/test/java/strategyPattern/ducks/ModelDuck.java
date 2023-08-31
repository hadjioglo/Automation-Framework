package strategyPattern.ducks;

import strategyPattern.fly.FlyNoWay;
import strategyPattern.quack.Quack;

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
