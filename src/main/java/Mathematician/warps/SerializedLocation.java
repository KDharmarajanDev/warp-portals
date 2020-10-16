package Mathematician.warps;

import Mathematician.WarpPortalsMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SerializedLocation {

    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private String worldName;

    public SerializedLocation(Location location){
        x =  location.getX();
        y = location.getY();
        z = location.getZ();
        yaw = location.getYaw();
        pitch = location.getPitch();
        worldName = location.getWorld().getName();
    }

    public static SerializedLocation deserialize(String input){
        return WarpPortalsMain.GSON.fromJson(input, SerializedLocation.class);
    }

    public Location toLocation(){
        World world = Bukkit.getWorld(worldName);
        Location location = new Location(world, x, y, z, yaw, pitch);
        return location;
    }

    public String serialize(){
        return WarpPortalsMain.GSON.toJson(this);
    }

}
