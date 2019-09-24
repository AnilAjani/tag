package org.improving.tag.commands;

import org.improving.tag.Game;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class BaseAliasedCommand implements Command {
    private List<String> aliases = new ArrayList<>();

    public BaseAliasedCommand(String...aliases){
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game){
        //for (var a : aliases) { if (input.equalsIgnoreCase))
        // return true}
        //return false;
        var trimmedInput = input.trim();
        return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);
    }
}
