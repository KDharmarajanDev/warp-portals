package Mathematician;


import Mathematician.commands.MainCommand;
import Mathematician.listeners.PlayerEnterPortalListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpPortalsMain extends JavaPlugin {

    private final String prefix = ChatColor.BLACK + "[" + ChatColor.RED + "Warp Portals" + ChatColor.BLACK + "]" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD;
    private static WarpPortalsMain instance;

    @Override
    public void onEnable(){
        instance = this;

        //Listener Registration
        this.getServer().getPluginManager().registerEvents(new PlayerEnterPortalListener(),this);

        //Commands Registration
        this.getCommand("warpportal").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable(){

    }

    public static WarpPortalsMain getInstance(){
        return instance;
    }

    public void sendMessageToPlayer(Player player, String message){
        player.sendMessage(prefix + message);
    }

}
