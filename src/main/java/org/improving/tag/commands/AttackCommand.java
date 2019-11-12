package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
//public class AttackCommand extends BaseAliasedCommand
public class AttackCommand extends BaseAliasedCommand {

    public AttackCommand(InputOutput io) {
        super(io, "attack", "a");

    }

    @Override
    public void childExecute(String input, Game game) {
        var treasureChest = game.getPlayer().getLocation().getTreasureChest();
        var adversary = game.getPlayer().getLocation().getAdversary();
        var player = game.getPlayer().getLocation();
        if (adversary == null) {
            io.displayText("Attack What?");
        } else {
            int random = new Random().nextInt(100 + 1);
            if (random <= 20) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText(adversary.getName() + "'s Remaining HP: " + adversary.getHitPoints());
                if (adversary.getHitPoints() <= 0) {
                    game.getPlayer().getLocation().setAdversary(null);
                    io.displayText(adversary.getName() + " is dead");
                }
                if (adversary == null) {
                    game.getPlayer().getLocation().getTreasureChest();
                    io.displayText("YOU GOT AN ITEM: " + treasureChest.getItem());
                    game.getPlayer().getInventory().addItem(treasureChest.getItem());
                }
            }else {
                io.displayText("Attack Missed");
            }
            if (random > 20 && random < 50){
                game.getPlayer().setDamageTaken(game.getPlayer().getDamageTaken()+5);
                game.getPlayer().setHitPoints(game.getPlayer().getHitPoints()-5);
                io.displayText("You've been hit!");
                io.displayText("Your Health " + game.getPlayer().getHitPoints());
            }

        }
    }
}