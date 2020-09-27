package Mathematician.portals;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PortalManager {

    private ArrayList<WarpPortal> portals;
    private static PortalManager instance;

    public PortalManager(){
        portals = new ArrayList<>();
    }

    public static PortalManager getInstance(){
        if (instance == null){
            instance = new PortalManager();
        }
        return instance;
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
