package org.improving.tag.items;

import java.util.Comparator;

public class ItemCompare implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        //0 means things are equal
        //1 means item 1 is greater than item 2
        //-1 means item 1 is less than item 2
        return item1.getName().compareTo(item2.getName());
    }
}
