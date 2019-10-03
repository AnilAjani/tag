package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

@Component
public class BackCommand extends BaseAliasedCommand {
    private MovementStore ms;

    public BackCommand(InputOutput io, MovementStore ms, String... aliases) {
        super(io, "back", "b");
        this.ms = ms;
    }
    @Override
    public void execute (String input, Game game){
        Location lastLocation = ms.getLastLocation();
        game.getPlayer().setLocation(lastLocation);
        io.displayText("You've been moved back to " + lastLocation.getName());


    }


}
