package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.portals.PortalManager;
import org.bukkit.entity.Player;

public class CreatePortalCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (args.length > 1) {
            if (PortalManager.getInstance().createPortalFromPlayerData(player,args[1])){
                WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Successfully created portal!");
            } else {
                WarpPortalsMain.getInstance().sendMessageToPlayer(player,"The portal positions are not set! Please set them with /warpportal setposition (p1|p2). " +
                        "The block you are looking at will be chosen.");
            }
            return true;
        }
        return false;
    }

}
