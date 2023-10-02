package org.example.training.strategyPattern.quack;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack ");
    }
}
