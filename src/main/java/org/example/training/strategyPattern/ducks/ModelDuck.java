package org.example.training.strategyPattern.ducks;

import org.example.training.strategyPattern.fly.FlyNoWay;
import org.example.training.strategyPattern.quack.Quack;

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
