package strategyPattern.ducks;

import strategyPattern.fly.FlyingBehavior;
import strategyPattern.quack.QuackBehavior;

public abstract class Duck {

    QuackBehavior quackBehavior;
    FlyingBehavior flyingBehavior;

    //vary
    public void swim() {
        System.out.println("Swimming duck");
    }

    //stays the same
    public void display() {
        System.out.println("Display duck");
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyingBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void setFlyingBehavior(FlyingBehavior fb) {
        flyingBehavior = fb;
    }
}
