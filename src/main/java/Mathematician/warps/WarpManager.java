package Mathematician.warps;

import Mathematician.WarpPortalsMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;

public class WarpManager {

    private HashMap<String, Warp> warpMap;
    private static transient WarpManager instance;

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
        saveToFile();
    }

    public boolean removeWarp(String name){
        boolean returnStatement = warpMap.remove(name) != null;
        saveToFile();
        return returnStatement;
    }

    public Set<String> getWarpNames(){
        return warpMap.keySet();
    }

    public void setWarpMap(HashMap<String, Warp> warpMap){
        this.warpMap = warpMap;
    }

    public void teleportToWarp(Player player, String warpName){
        Warp warp = getWarp(warpName);
        if (warp != null){
            player.teleport(warp.getLocation());
        } else {
            WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Warp does not exist!");
        }
    }

    public void saveToFile(){
        FileConfiguration config = WarpPortalsMain.getInstance().getConfig();
        warpMap.forEach((name, warp)-> config.set("warps." + name, warp.serialize()));
        WarpPortalsMain.getInstance().saveConfig();
    }

    public static void loadInstanceFromFile(){
        WarpManager manager = getInstance();
        HashMap<String, Warp> warps = new HashMap<>();
        FileConfiguration config = WarpPortalsMain.getInstance().getConfig();
        if(config.getConfigurationSection("warps") != null) {
            Set<String> warpNames = config.getConfigurationSection("warps").getKeys(false);
            for(String warpName : warpNames) {
                Warp warp = Warp.deserialize(config.getString("warps." + warpName));
                warps.put(warpName, warp);
            }
        }
        manager.setWarpMap(warps);
    }
}
