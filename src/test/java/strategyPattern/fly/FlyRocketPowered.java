package strategyPattern.fly;

public class FlyRocketPowered implements FlyingBehavior{
    @Override
    public void fly() {
        System.out.println("Fly like a rocket");
    }
}
