package training.commandPattern;

public class Stereo {

    public void on() {
        System.out.println("Stereo is on");
    }

    public void setCD() {
        System.out.println("CD is set");
    }

    public void setVolume(int volume) {
        System.out.println("Volume is set to " + volume);
    }

    public void off() {
        System.out.println("Stereo is off");
    }
}
