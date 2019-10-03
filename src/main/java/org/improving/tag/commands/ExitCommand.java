package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private SaveGameFactory saveFactory;


    public ExitCommand(SaveGameFactory saveFactory, InputOutput io, String... aliases) {
        super(io, "exit");
        this.saveFactory = saveFactory;
    }

    @Override
    public void execute(String input, Game game) throws GameExitException {
        saveFactory.save(game);
        io.displayText("GoodBye.");
        throw new GameExitException();
        }
    }

