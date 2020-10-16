package Mathematician;


import Mathematician.commands.MainCommand;
import Mathematician.listeners.PlayerEnterPortalListener;
import Mathematician.portals.PortalManager;
import Mathematician.warps.WarpManager;
import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpPortalsMain extends JavaPlugin {

    private final String prefix = ChatColor.BLACK + "[" + ChatColor.RED + "Warp Portals" + ChatColor.BLACK + "]" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD;
    private static WarpPortalsMain instance;
    public static final Gson GSON = new Gson();

    @Override
    public void onEnable(){
        instance = this;

        //Listener Registration
        this.getServer().getPluginManager().registerEvents(new PlayerEnterPortalListener(),this);

        //Commands Registration
        this.getCommand("warpportal").setExecutor(new MainCommand());

        // Load from config
        instantiateWarpAndPortalManagers();
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

    public void instantiateWarpAndPortalManagers(){
        this.saveDefaultConfig();
        WarpManager.loadInstanceFromFile();
        PortalManager.loadInstanceFromFile();
        Bukkit.getLogger().info("There are " + PortalManager.getInstance().getPortals().size() + " portals!");
    }
}
