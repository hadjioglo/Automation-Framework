package designPatterns.fly;

public class FlyWithWings implements FlyingBehavior{
    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
