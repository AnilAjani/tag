package org.improving.tag.items;

import org.improving.tag.Location;
import org.improving.tag.TreasureChest;

import javax.persistence.Converter;

public enum UniqueItems implements Item{
    THE_ONE_RING("A Golden Ring", "The One Ring"),
    SHIELD("For protection, Duh", "A Shield"),
    MAGICAL_WAND("To do magical stuff", "Magical Wand"),
    PLANE_TICKET("How else are you going to fly?", "A plane ticket"),
    FIRE_PROOF_SUIT("When you play with fire", "Fire proof suit"),
    NOTHING("", "");

    private final String description;
    private final String name;

    UniqueItems(String description, String name) {
        this.description = description;
        this.name = name;
    }
    @Override
    public String toString() {
        return name + ": " + description;
    }
    @Override
    public String getName(){
        return name;
    }
}
