package Mathematician.listeners;

import Mathematician.portals.PortalManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PlayerEnterPortalListener implements Listener {

    @EventHandler
    public void onEnterPortal(PlayerPortalEvent event){
        PortalManager.getInstance().teleportPlayer(event.getPlayer());
        event.setCanCreatePortal(false);
        event.setCancelled(true);
    }

}
