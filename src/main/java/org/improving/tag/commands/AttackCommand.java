package org.improving.tag.commands;

import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
//public class AttackCommand extends BaseAliasedCommand
public class AttackCommand extends BaseAliasedCommand {

    public AttackCommand(InputOutput io, Random random) {
        super(io, "attack", "a");
    }

    @Override
    public void execute(String input, Game game) {
        var treasureChest = game.getPlayer().getLocation().getTreasureChest();
        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("Attack What?");
        } else {
            int random = new Random().nextInt(100 + 1);
            if (random <= 20) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText(adversary.getName() + "'s Remaining HP" + adversary.getHitPoints());
                if (adversary.getHitPoints() <= 0) {
                    game.getPlayer().getLocation().setAdversary(null);
                    io.displayText("Dude is dead");
                    game.getPlayer().getLocation().getTreasureChest();
                    io.displayText("YOU GOT AN ITEM: " + treasureChest.getItem());
                    game.getPlayer().getInventory().addItem(treasureChest.getItem());
                }
            } else {
                io.displayText("Attack Missed");
            }
        }
    }
}