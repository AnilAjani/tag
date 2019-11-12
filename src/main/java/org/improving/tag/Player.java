package org.improving.tag;

import java.util.BitSet;

public class Player {
    private String name;
    private int hitPoints;
    private Location location;
    private Inventory inventory = new Inventory();
    private int DamageTaken;
    private int AttackDamage;


    public Player (String name){
        this.name = name;
        this.hitPoints = 100;
        this.DamageTaken = 0;
        this.AttackDamage = 10;

    }

    public Player(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public String getName() {

        return name;
    }
    public void setName(String name){

        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {

        this.hitPoints = hitPoints;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public int getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.AttackDamage = AttackDamage;
    }

    public int getDamageTaken() {
        return DamageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        DamageTaken = damageTaken;
    }
}

