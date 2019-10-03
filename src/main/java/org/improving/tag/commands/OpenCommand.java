package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {
    public OpenCommand(InputOutput io, String... aliases) {
        super(io,"open", "o");
    }
    @Override
    public void execute (String input, Game game) {
        var treasureChest = game.getPlayer().getLocation().getTreasureChest();
        if (treasureChest == TreasureChest.NO_TREASURE)
            io.displayText("Nothing Here!");
        else {
            io.displayText("You open the chest to reveal " + treasureChest.getItem());
            game.getPlayer().getInventory().addItem(treasureChest.getItem());
        }
    }
}
