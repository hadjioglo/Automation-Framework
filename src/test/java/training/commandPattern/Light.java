package training.commandPattern;

public class Light {

    String place;

    public Light(String place) {
        this.place = place;
    }

    public void on() {
        System.out.println("Light is ON in " + place);
    }

    public void off() {
        System.out.println("Light is OFF in " + place);
    }
}
