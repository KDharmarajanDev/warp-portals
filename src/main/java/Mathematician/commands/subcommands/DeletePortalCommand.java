package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.portals.PortalManager;
import org.bukkit.entity.Player;

public class DeletePortalCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (PortalManager.getInstance().containsDeletePlayer(player)){
            WarpPortalsMain.getInstance().sendMessageToPlayer(player, "You are no longer going to delete a portal!");
            PortalManager.getInstance().removeDeletePlayer(player);
        } else {
            WarpPortalsMain.getInstance().sendMessageToPlayer(player, "Walk into the portal you wish to remove!");
            PortalManager.getInstance().addDeletePlayer(player);
        }
        return true;
    }

}