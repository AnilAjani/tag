package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "location")
public class Location {
    @Id
    long id;
    @Column (name = "Name")
    private String name = "";
    @Column (name = "Description")
    private String description = "";
   // private List<String> tags = new ArrayList<>();
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
            //(mappedBy = "origin")
    private List<Exit> exit = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "AdversaryId")
    private Adversary adversary;

    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    @Transient
    private MovementStore lastLocation;

    public Location() {
    }

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
//    public int getAdversaryId() {
//        return AdversaryId;
//    }
//
//    public void setAdversaryId(int adversaryId) {
//        AdversaryId = adversaryId;
//    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<String> getTags() {
//        return tags;
//    }

    public List<Exit> getExit() {
        return exit;
    }
    public void addExit(Exit exit){
        this.getExit().add(exit);
    }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            return this.getName().equals(location.getName());
                   // this.tags.equals(location.getTags());
        }
        return super.equals(obj);
    }
    public TreasureChest getTreasureChest() {
        return treasureChest;
    }
}

