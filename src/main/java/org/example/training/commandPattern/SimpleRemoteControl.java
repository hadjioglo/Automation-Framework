package org.example.training.commandPattern;

public class SimpleRemoteControl {
    CommandInterface slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(CommandInterface commandInterface) {
        slot = commandInterface;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
