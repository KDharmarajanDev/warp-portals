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

    public String serialize(){
        return new SerializedLocation(location).serialize();
    }

    public static Warp deserialize(String input){
        return new Warp(SerializedLocation.deserialize(input).toLocation());
    }

}
