package org.example.training.strategyPattern.ducks;

import org.example.training.strategyPattern.fly.FlyWithWings;
import org.example.training.strategyPattern.quack.Quack;

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
