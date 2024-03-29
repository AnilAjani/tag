package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class SaveGameFactory {
    private final FileSystemAdapter fsa;
    private final InputOutput io;

    public SaveGameFactory(FileSystemAdapter fsa, InputOutput io) {
        this.fsa = fsa;
        this.io = io;
    }

    public String save(Game game) {
        var locationName = game.getPlayer().getLocation().getName();
        var inventory = game.getPlayer().getInventory();
        Map<String, String> saveContents = new HashMap<>();
        saveContents.put("location", locationName + "\n");
        saveContents.put("items", inventory + "\n");

        String path = null;
        try {
            path = fsa.saveToFile(saveContents);
            io.displayText("Saved : " + path);
        }catch (IOException ex){
            io.displayText(ex.toString());
        }
        return path;
    }
    public void load(String path, Game g) {
        Map<String, String> saveContents;
        try {
            saveContents = fsa.loadFile(path);
        } catch (IOException e) {
            io.displayText((e.toString()));
            io.displayText("Failed to load file");
            return;
        }

        Location lastKnownLocation  = g.getLocationOf(saveContents.get("location"));
        g.getPlayer().setLocation(lastKnownLocation);


    }

}
