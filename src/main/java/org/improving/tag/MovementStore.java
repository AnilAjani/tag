package org.improving.tag;

import org.springframework.stereotype.Component;

@Component
public class MovementStore {
    private Location lastLocation;

    public Location getLastLocation(){
        return lastLocation;
    }
    public void setLastLocation(Location lastLocation){
        this.lastLocation = lastLocation;
    }

}
