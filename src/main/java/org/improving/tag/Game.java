package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Command[] commands; //linked via BaseEmoteCommand
    private Date startTime;
    private Date endTime;
    private InputOutput io;
    private Player p;
    private Location startingLocation;

    public Game(Command[] commands, InputOutput io){
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
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
        this.setStartTime(new Date());


        boolean loop = true;
        while (loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input, this);
            }else if (input.trim().equalsIgnoreCase("exit")) {
                io.displayText("GoodBye.");
                loop = false;
            }
            else {
                io.displayText("Huh? I don't understand.");
                }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        Command validCommand = null;
        for (Command command : commands){
            if (command.isValid(input, this)){
                validCommand = command;
            }
        }
        return validCommand;
    }

    private Location buildWorld(){
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
        td.setName("The Desert");

        var ta = new Location();
        ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");

        var tvm = new Location();
        tvm.setName("The Velvet Moose");

        var tap = new Location();
        tap.setName("The Airport");

        var tict = new Location();
        tict.setName("The Ice Cream Truck");

        var mount = new Location();
        mount.setName("The Mountains");

        var tr = new Location();
        tr.setName("The Reef");

        var mall = new Location();
        mall.setName("The Mall");

        var mtd = new Location();
        mtd.setName("Mount Doom");

        var tvd = new Location();
        tvd.setName("The Volcano of Doom");

        //exits from the deathly hallows
        tdh.getExit().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExit().add(new Exit("The Deathly Brownie",td,"tdb", "deathly","brownie"));

        //exits from the desert
        td.getExit().add(new Exit("The Dock", tap, "dock", "the dock"));
        td.getExit().add(new Exit("Camel Path",ta,"cp", "camel", "path"));
        td.getExit().add(new Exit("Rocky Road",tict, "rock", "rocky", "road", "rr"));

       //exits from the mac and cheese shop
        tmcs.getExit().add(new Exit("Highway 121", ta,  "hwy 121", "h121", "121"));
        tmcs.getExit().add(new Exit("Paradise Rd",tr, "paradise", "rd", "pr"));
        tmcs.getExit().add(new Exit("Highway 21", tvd, "hwy 21", "h21", "21"));

        //exit from the velvet moose
        tvm.getExit().add(new Exit("The Pudding Slide", tap, "pudding", "slide", "pudding slide", "ps"));
        tvm.getExit().add(new Exit("The Front Door", ta, "front door", "front", "door"));

        //exit from the ice cream truck
        tict.getExit().add(new Exit("Magic Portal",mtd, "magic", "portal", "mp"));

        //exit from airport
        tap.getExit().add(new Exit("Flight 121", mount, "flight", "f121", "121"));
        tap.getExit().add(new Exit("Flight to the Mall", mall, "mall", "to the mall"));

        //exit from the mountains
        mount.getExit().add(new Exit("The Lava Flow", tvd, "lava", "flow", "lf"));
        mount.getExit().add(new Exit("The Narrow Trail",mtd, "narrow trail", "nt"));
        mount.getExit().add(new Exit("The Plane", ta, "plane", "tp"));
        mount.getExit().add(new Exit("Bike Trail", tr, "bike", "bt"));

        //exit from the amazon
        ta.getExit().add(new Exit("Amaz-ing Moose", tvm, "amazing", "amaz-ing", "moose", "am"));

        //exit from the reef
        tr.getExit().add(new Exit("The Scenic Route", tvm, "scenic", "route", "scenic route", "sr"));
        tr.getExit().add(new Exit("The city walk", mall, "walk", "city walk", "city"));

        //exit from the mall
        mall.getExit().add(new Exit("Path to Doom", mtd, "path", "to doom", "pd"));
        mall.getExit().add(new Exit("An Escalator of Doom", tvd, "escalator", "ed" ));

        //exits from mount doom
        mtd.getExit().add(new Exit("Jump into lava", tvd, "jump", "lava"));
        mtd.getExit().add(new Exit("The Cab", mall, "cab"));

        return tdh;
    }


}
