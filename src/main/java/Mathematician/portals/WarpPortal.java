package Mathematician.portals;

import Mathematician.WarpPortalsMain;
import Mathematician.warps.Warp;
import Mathematician.warps.WarpManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WarpPortal {

    private String warpName;
    private Location oneCorner;
    private Location otherCorner;

    public WarpPortal(String warpName, Location oneCorner, Location otherCorner){
        this.warpName = warpName;
        this.oneCorner = oneCorner;
        this.otherCorner = otherCorner;
    }

    public String getWarpName(){
        return warpName;
    }

    public boolean isInside(Location startingLocation){
        double maxX = Math.max(oneCorner.getX(), otherCorner.getX());
        double maxY = Math.max(oneCorner.getY(), otherCorner.getY());
        double maxZ = Math.max(oneCorner.getZ(), otherCorner.getZ());
        double minX = Math.min(oneCorner.getX(), otherCorner.getX());
        double minY = Math.min(oneCorner.getY(), otherCorner.getY());
        double minZ = Math.min(oneCorner.getZ(), otherCorner.getZ());
        return startingLocation.getX() <= maxX && startingLocation.getX() >= minX
                && startingLocation.getY() <= maxY && startingLocation.getY() >= minY
                && startingLocation.getZ() <= maxZ && startingLocation.getZ() >= minZ;
    }

    public void teleportPlayer(Player player){
        WarpManager.getInstance().teleportToWarp(player,warpName);
    }
}
