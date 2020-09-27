package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.warps.WarpManager;
import org.bukkit.entity.Player;

public class ListWarpsCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        WarpPortalsMain.getInstance().sendMessageToPlayer(player, String.join(",", WarpManager.getInstance().getWarpNames()) + ".");
        return true;
    }

}
