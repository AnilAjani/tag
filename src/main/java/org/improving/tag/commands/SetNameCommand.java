package org.improving.tag.commands;

import org.improving.tag.ConsoleInputOutput;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SetNameCommand implements Command {

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false; //if (input.contains("=") == false return false;
        input = input.trim();
        var parts = input.split("=");//var cmd = input.split (regex"=") [0].trim();
        if (parts.length == 1)
            return false;
        return parts[0].equalsIgnoreCase("@set name"); //return cmd.equalsIgnoreCase("@set name")
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var parts = input.split("="); //var name = input.split(regex"=") [1].trim();
        game.getPlayer().setName(parts[1]); //game.getPlayer().setName(name);
        //io.displayText("Your name is now " + game.getPlayer().getName() + ".");
    }
}
