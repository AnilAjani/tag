package org.improving.tag;

//import org.improving.tag.DataBase.ExitDOA;
//import org.improving.tag.DataBase.LocationDOA;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {

    //private List<Exit> exitList = new ArrayList<>();
    private List<Location> locationList = new ArrayList<>();
    private LocationRepo locationRepo;
    private ExitRepo exitRepo;
    //public LocationDOA locationDOA;
    //public ExitDOA exitDOA;



    public WorldBuilder(LocationRepo locationRepo, ExitRepo exitRepo) {
        //this.locationDOA = locationDOA;
        this.locationRepo = locationRepo;
        this.exitRepo = exitRepo;

    }
    @Transactional
    public Location buildWorld() {
        try {
            List<Location> locations = locationRepo.findAllByName();
            List<Exit> exit = exitRepo.findAllByName();
//            for (Location location : locations) {
//                List<Exit> exits = exitRepo.findAllByName((int) location.getId());
//                exits.forEach(exit -> {
//                    Location destination = locations.stream().
//                            filter(l -> l.getId() == exitRep())
//                            .findFirst().orElseThrow();
//                    exit.setDestination(destination);
//                    location.addExit(exit);
//                });
           // }
            locationList = locations;
            return locationList.get(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
           // return buildHardCodedWorld();
        }

//    private Location buildHardCodedWorld() {
//        var tdh = new Location();
//        tdh.setName("The Deathly Hallows");
//        tdh.setTreasureChest(new TreasureChest(UniqueItems.MAGICAL_WAND, "Forbidden Treasure"));
//        this.locationList.add(tdh);
//
//        var td = new Location();
//        td.setName("The Desert");
//        this.locationList.add(td);
//
//        var ta = new Location();
//        ta.setName("The Amazon");
//        ta.setAdversary(new Adversary("Bad Guy"));
//        ta.setTreasureChest(new TreasureChest(UniqueItems.SHIELD, "Random Wooden Chest"));
//        this.locationList.add(ta);
//
//        var tmcs = new Location();
//        tmcs.setName("The Mac & Cheese Shop");
//        tmcs.setAdversary(new Adversary("Macaroni Man"));
//        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING, "Kraft Box"));
//        this.locationList.add(tmcs);
//
//        var tvm = new Location();
//        tvm.setName("The Velvet Moose");
//        this.locationList.add(tvm);
//
//        var tap = new Location();
//        tap.setName("The Airport");
//        tap.setTreasureChest(new TreasureChest(UniqueItems.PLANE_TICKET, "Ticket Counter"));
//        this.locationList.add(tap);
//
//        var tict = new Location();
//        tict.setName("The Ice Cream Truck");
//        tict.setAdversary(new Adversary("Ice cream man"));
//        this.locationList.add(tict);
//
//        var mount = new Location();
//        mount.setName("The Mountains");
//        this.locationList.add(mount);
//
//        var tr = new Location();
//        tr.setName("The Reef");
//        this.locationList.add(tr);
//
//        var mall = new Location();
//        mall.setName("The Mall");
//        mall.setAdversary(new Adversary("Mall security"));
//        this.locationList.add(mall);
//
//        var mtd = new Location();
//        mtd.setName("Mount Doom");
//        mtd.setAdversary(new Adversary("Doomsday"));
//        mtd.setTreasureChest(new TreasureChest(UniqueItems.FIRE_PROOF_SUIT, "Doom box"));
//        this.locationList.add(mtd);
//
//        var tvd = new Location();
//        tvd.setName("The Volcano of Doom");
//        this.locationList.add(tvd);
//
//        //exits from the deathly hallows
//        tdh.getExit().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
//        tdh.getExit().add(new Exit("The Deathly Brownie", td, "tdb", "deathly", "brownie"));
//
//        //exits from the desert
//        td.getExit().add(new Exit("The Dock", tap, "dock", "the dock"));
//        td.getExit().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
//        td.getExit().add(new Exit("Rocky Road", tict, "rock", "rocky", "road", "rr"));
//
//        //exits from the mac and cheese shop
//        tmcs.getExit().add(new Exit("Highway 121", ta, "hwy 121", "h121", "121"));
//        tmcs.getExit().add(new Exit("Paradise Rd", tr, "paradise", "rd", "pr"));
//        tmcs.getExit().add(new Exit("Highway 21", tvd, "hwy 21", "h21", "21"));
//
//        //exit from the velvet moose
//        tvm.getExit().add(new Exit("The Pudding Slide", tap, "pudding", "slide", "pudding slide", "ps"));
//        tvm.getExit().add(new Exit("The Front Door", ta, "front door", "front", "door"));
//
//        //exit from the ice cream truck
//        tict.getExit().add(new Exit("Magic Portal", mtd, "magic", "portal", "mp"));
//
//        //exit from airport
//        tap.getExit().add(new Exit("Flight 121", mount, "flight", "f121", "121"));
//        tap.getExit().add(new Exit("Flight to the Mall", mall, "mall", "to the mall"));
//
//        //exit from the mountains
//        mount.getExit().add(new Exit("The Lava Flow", tvd, "lava", "flow", "lf"));
//        mount.getExit().add(new Exit("The Narrow Trail", mtd, "narrow trail", "nt"));
//        mount.getExit().add(new Exit("The Plane", ta, "plane", "tp"));
//        mount.getExit().add(new Exit("Bike Trail", tr, "bike", "bt"));
//
//        //exit from the amazon
//        ta.getExit().add(new Exit("Amaz-ing Moose", tvm, "amazing", "amaz-ing", "moose", "am"));
//
//        //exit from the reef
//        tr.getExit().add(new Exit("The Scenic Route", tvm, "scenic", "route", "scenic route", "sr"));
//        tr.getExit().add(new Exit("The city walk", mall, "walk", "city walk", "city"));
//
//        //exit from the mall
//        mall.getExit().add(new Exit("Path to Doom", mtd, "path", "to doom", "pd"));
//        mall.getExit().add(new Exit("An Escalator of Doom", tvd, "escalator", "ed"));
//
//        //exits from mount doom
//        mtd.getExit().add(new Exit("Jump into lava", tvd, "jump", "lava"));
//        mtd.getExit().add(new Exit("The Cab", mall, "cab"));
//
//        return tdh;
//    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationList() {
        return locationList;
    }
}

