package org.improving.tag;

import org.improving.tag.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name = "";
    private String description = "";
    private List<String> tags = new ArrayList<>();
    private List<Exit> exit = new ArrayList<>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    private MovementStore lastLocation;

    public MovementStore getMovementStore(){
        return lastLocation;
    }
    public void setMovementStore (MovementStore lastLocation){
        this.lastLocation = lastLocation;
    }
    public Adversary getAdversary() {
        return adversary;
    }
    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExit() {
        return exit;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }
    public Item openTreasureChest() {
        if (TreasureChest.NO_TREASURE.equals(treasureChest)){
            throw new UnsupportedOperationException();
        }
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }
    @Override
    public boolean equals (Object obj){
        if (obj instanceof Location){
            Location location = (Location) obj;
            return this.getName().equals(location.getName()) &&
                    this.tags.equals(location.getTags());
        }
        return super.equals(obj);
    }
    public TreasureChest getTreasureChest() {
        return treasureChest;
    }
}

