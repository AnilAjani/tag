package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SwitchToCommand implements Command {
    private InputOutput io;

    public SwitchToCommand (InputOutput io){
        this.io = io; //set in BaseEmoteCommand
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false; // if no input
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1)
            return false; // one word sting returns false
        return parts[0].equalsIgnoreCase("switch"); // index 0 of the string has to contain the word "switch"
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(7); // switch + space = 7 substring characters
        io.displayText("You switch " + destination + "."); // destination is user input

    }
}
