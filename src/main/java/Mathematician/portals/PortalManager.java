package Mathematician.portals;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PortalManager {

    private ArrayList<WarpPortal> portals;
    private HashMap<Player, Location[]> positions;
    private static PortalManager instance;

    public PortalManager(){
        portals = new ArrayList<>();
        positions = new HashMap<>();
    }

    public static PortalManager getInstance(){
        if (instance == null){
            instance = new PortalManager();
        }
        return instance;
    }

    public void setPosition(Player player, Location location, int position){
        if (positions.containsKey(player)){
            positions.get(player)[position] = location;
        } else {
            positions.put(player, new Location[]{location, location});
        }
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
    }

    public void teleportPlayer(Player player){
        for (WarpPortal portal : portals){
            if (portal.isInside(player.getLocation())){
                portal.teleportPlayer(player);
                break;
            }
        }
    }
}
