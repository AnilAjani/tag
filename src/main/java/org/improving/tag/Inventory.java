package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemCompare;
import org.improving.tag.items.UniqueItems;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

   public Inventory(){
        items.add(UniqueItems.THE_ONE_RING);
        //items.add(UniqueItems.BLUE_SHELL);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void addItem(Item item){
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You've got some stuff";
        items.sort(new ItemCompare());
        for(Item item : items){
            displayString+= "\n" + item;
        }
        return displayString;
    }
}

