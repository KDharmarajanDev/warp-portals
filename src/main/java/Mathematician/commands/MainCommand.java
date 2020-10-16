package Mathematician.commands;

import Mathematician.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("warpportal")) {
            if(sender instanceof Player && sender.hasPermission("warpportal.warpportal")) {
                Player player = (Player) sender;
                if(args.length > 0){
                    if(args[0].equalsIgnoreCase("setwarp")){
                        return new SetWarpCommand().onSubCommand(player,args);
                    } else if(args[0].equalsIgnoreCase("deletewarp") || args[0].equalsIgnoreCase("delwarp")){
                        return new DeleteWarp().onSubCommand(player, args);
                    } else if(args[0].equalsIgnoreCase("listwarps")){
                        return new ListWarpsCommand().onSubCommand(player, args);
                    } else if(args[0].equalsIgnoreCase("warp")){
                        return new GoToWarpCommand().onSubCommand(player, args);
                    } else if(args[0].equalsIgnoreCase("createportal")){
                        return new CreatePortalCommand().onSubCommand(player,args);
                    } else if(args[0].equalsIgnoreCase("setposition")){
                        return new SetPositionCommand().onSubCommand(player,args);
                    } else if(args[0].equalsIgnoreCase("deleteportal")){
                        return new DeletePortalCommand().onSubCommand(player,args);
                    }
                }
            }
        }
        return false;
    }

}
