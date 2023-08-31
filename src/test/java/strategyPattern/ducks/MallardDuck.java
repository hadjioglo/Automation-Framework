package strategyPattern.ducks;

import strategyPattern.fly.FlyWithWings;
import strategyPattern.quack.Quack;

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
