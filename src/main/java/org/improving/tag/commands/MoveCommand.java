package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class MoveCommand extends BaseAliasedCommand {
    private MovementStore ms;

    public MoveCommand(InputOutput io, MovementStore ms){
        super(io ,"m","mo","move");
        this.ms = ms;
    }
    @Override
    public String getCommandPart(String input){
        var parts = input.split(" ");
       if (parts.length == 1) throw new UnsupportedOperationException();
        return parts[0];
    }

    @Override
    public String getErrorMessage(){
        return "That route is unavailable";
    }
    @Override
    public void childExecute(String input, Game game) {
            input = input.trim();
            var destination = input.substring(input.indexOf(" ")+1);
//            var parts = input.split(" ");
//            var parameters = new ArrayList<String>(Arrays.asList(parts));
//            parameters.remove(0);
//            var destination = String.join(" ", parameters);

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
            if (exit != null) {
                break;
            }
        }
        if (exit == null) throw new UnsupportedOperationException();
//           { io.displayText("This route is unavailable");
//            return;}

        else if (game.getPlayer().getLocation().getAdversary() != null) {
                io.displayText("YOU SHALL NOT PASS");
                return;
        }
        ms.setLastLocation(game.getPlayer().getLocation());
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You're traveling on " + exit.getName() + ".");
    }}

