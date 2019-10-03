package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OpenTheBottle implements Command {
    private InputOutput io;

    public OpenTheBottle(InputOutput io) {
        this.io = io;
    }
    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) {
            return false;
        }return input.trim().equalsIgnoreCase("pop");
    }

    @Override
    public void execute(String input, Game game) {
        int r = new Random().nextInt(10+1);
        if (r < 2){
            System.out.println("Bottle Opened");
        }else {
            System.out.println("Keep Trying");
        }
    }
}
