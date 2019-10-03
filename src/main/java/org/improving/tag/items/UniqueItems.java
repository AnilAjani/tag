package org.improving.tag.items;

import org.improving.tag.Location;
import org.improving.tag.TreasureChest;

public enum UniqueItems implements Item{
    THE_ONE_RING("A Golden Ring", "The One Ring"),
    BLUE_SHELL("Blue Yoshi Shell", "Blue Shell"),
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
