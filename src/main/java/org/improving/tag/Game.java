package org.improving.tag;

import org.improving.tag.commands.*;

import java.util.Date;
import java.util.Scanner;

public class Game {
    private BaseEmoteCommand[] commands;
    private Date startTime;
    private Date endTime;

    public Game(){
        commands = new BaseEmoteCommand[] {
                new LookCommand(),
                new DanceCommand(),
                new InventoryCommand(),
                new JumpCommand()};
    }

    public Date getStartTime() {
        return startTime;
    }
    private void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());


        boolean loop = true;
        while (loop) {
            System.out.print("> ");
            String input = scanner.nextLine();
            BaseEmoteCommand validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input);
            }else if (input.trim().equals("exit")) {
                System.out.println("GoodBye.");
                loop = false;
            }
            else {
                System.out.println("Huh? I don't understand.");
                }
        }
        this.setEndTime(new Date());
    }

    private BaseEmoteCommand getValidCommand(String input) {
        BaseEmoteCommand validCommand = null;
        for (BaseEmoteCommand command : commands){
            if (command.isValid(input)){
                validCommand = command;
            }
        }
        return validCommand;
    }

}
