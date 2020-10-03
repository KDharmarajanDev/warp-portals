package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.portals.PortalManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SetPositionCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (args.length > 1) {
            if(args[1].equalsIgnoreCase("p1")){
                Location location = getLookingAtLocation(player);
                if (location != null){
                    PortalManager.getInstance().setPosition(player, location, 0);
                    WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Successfully set position 1!");
                } else {
                    WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Unable to detect block you are looking at!");
                }
            } else if(args[1].equalsIgnoreCase("p2")){
                Location location = getLookingAtLocation(player);
                if (location != null){
                    PortalManager.getInstance().setPosition(player, location, 1);
                    WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Successfully set position 2!");
                } else {
                    WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Unable to detect block you are looking at!");
                }
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    public Location getLookingAtLocation(Player player){
        Block block = player.getLastTwoTargetBlocks(null,6).get(1);
        if(block != null){
            return block.getLocation();
        }
        return null;
    }

}
