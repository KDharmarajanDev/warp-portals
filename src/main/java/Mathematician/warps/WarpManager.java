package Mathematician.warps;

import Mathematician.WarpPortalsMain;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;

public class WarpManager {

    private HashMap<String, Warp> warpMap;
    private static WarpManager instance;

    public WarpManager(){
        warpMap = new HashMap<>();
    }

    public static WarpManager getInstance(){
        if (instance == null){
            instance = new WarpManager();
        }
        return instance;
    }

    public Warp getWarp(String name){
        return warpMap.get(name);
    }

    public void addWarp(String name, Warp warp){
        warpMap.put(name,warp);
    }

    public boolean removeWarp(String name){
        return warpMap.remove(name) != null;
    }

    public Set<String> getWarpNames(){
        return warpMap.keySet();
    }

    public void teleportToWarp(Player player, String warpName){
        Warp warp = getWarp(warpName);
        if (warp != null){
            player.teleport(warp.getLocation());
        } else {
            WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Warp does not exist!");
        }
    }
}
