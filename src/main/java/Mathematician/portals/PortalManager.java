package Mathematician.portals;

import Mathematician.WarpPortalsMain;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PortalManager {

    private ArrayList<WarpPortal> portals;
    private HashMap<Player, Location[]> positions;
    private ArrayList<Player> deletePlayers;
    private static transient PortalManager instance;

    public PortalManager(){
        portals = new ArrayList<>();
        positions = new HashMap<>();
        deletePlayers = new ArrayList<>();
    }

    public static PortalManager getInstance(){
        if (instance == null){
            instance = new PortalManager();
        }
        return instance;
    }

    public static void setInstance(PortalManager manager){
        if (instance != null) {
            instance = manager;
        } else {
            getInstance();
        }
    }

    public void setPosition(Player player, Location location, int position){
        if (positions.containsKey(player)){
            positions.get(player)[position] = location;
        } else {
            positions.put(player, new Location[]{location, location});
        }
    }

    public ArrayList<WarpPortal> getPortals(){
        return portals;
    }

    public void setPortals(ArrayList<WarpPortal> portals){
        this.portals = portals;
    }

    public boolean createPortalFromPlayerData(Player player, String name){
        if (positions.containsKey(player)){
            Location[] locations = positions.get(player);
            addPortal(new WarpPortal(name,locations[0],locations[1]));
            return true;
        }
        return false;
    }

    public void addPortal(WarpPortal portal){
        portals.add(portal);
        saveToFile();
    }

    public void addDeletePlayer(Player player){
        deletePlayers.add(player);
    }

    public void removeDeletePlayer(Player player){
        deletePlayers.remove(player);
    }

    public boolean containsDeletePlayer(Player player){
        return deletePlayers.contains(player);
    }

    public void teleportPlayer(Player player){
        boolean isInsideList = deletePlayers.contains(player);
        for (WarpPortal portal : portals){
            if (portal.isInside(player.getLocation())){
                if (isInsideList){
                    portals.remove(portal);
                    saveToFile();
                    removeDeletePlayer(player);
                    WarpPortalsMain.getInstance().sendMessageToPlayer(player, "Successfully removed portal!");
                } else {
                    portal.teleportPlayer(player);
                }
                break;
            }
        }
    }

    public void saveToFile(){
        FileConfiguration config = WarpPortalsMain.getInstance().getConfig();
        ArrayList<String> serializedPortalList = new ArrayList<>();
        portals.forEach(portal -> serializedPortalList.add(portal.serialize()));
        config.set("portals", serializedPortalList);
        WarpPortalsMain.getInstance().saveConfig();
    }

    public static void loadInstanceFromFile(){
        PortalManager manager = getInstance();
        ArrayList<WarpPortal> portals = new ArrayList<>();
        FileConfiguration config = WarpPortalsMain.getInstance().getConfig();
        List<String> serializedPortals = config.getStringList("portals");
        serializedPortals.forEach(serializedVersion -> portals.add(WarpPortal.deserialize(serializedVersion)));
        manager.setPortals(portals);
    }
}
