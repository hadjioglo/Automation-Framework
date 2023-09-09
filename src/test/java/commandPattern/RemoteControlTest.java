package commandPattern;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl(); //waitress is invoker
        Light light = new Light("Living Room");
        LightOnCommand lightOn = new LightOnCommand(light); //client who creates the order

        remote.setCommand(lightOn); // waitress (invoker) invokes the order to cooker (receiver)
        remote.buttonWasPressed();

        System.out.println("------------------------");

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand openGarageDoor = new GarageDoorOpenCommand(garageDoor);

        //remote slot didn't care what command object it had, as long as it implemented the Command interface.
        remote.setCommand(openGarageDoor);
        remote.buttonWasPressed();


        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }
}
