package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class MoveCommand implements Command {
    private InputOutput io;

    public MoveCommand (InputOutput io){

        this.io = io;
    }
    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1)
            return false;
        return parts[0].equalsIgnoreCase("move");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(5);

        Exit exit = null;
        for (var e : game.getPlayer().getLocation().getExit()){
            if (e.getName().equalsIgnoreCase(destination)){
                exit = e;
            }else {
                for (var a : e.getAliases()){
                    if (a.equalsIgnoreCase(destination)){
                        exit = e;
                        break;
                    }
                }
            }
            if (exit != null) break;
        }
        if (exit == null){
            io.displayText("This route is unavailable");
            return;
        }
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You're traveling on " + exit.getName() + ".");
    }
}
