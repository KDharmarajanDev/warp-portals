package Mathematician.warps;

import org.bukkit.Location;

public class Warp {

    private Location location;

    public Warp(Location location) {
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

}
