package Mathematician.portals;

import Mathematician.WarpPortalsMain;
import Mathematician.warps.SerializedLocation;

public class SerializedWarpPortal {

    private String warpName;
    private SerializedLocation oneCorner;
    private SerializedLocation otherCorner;

    public SerializedWarpPortal(WarpPortal portal){
        this.warpName = portal.getWarpName();
        this.oneCorner = new SerializedLocation(portal.getFirstCorner());
        this.otherCorner = new SerializedLocation(portal.getSecondCorner());
    }

    public WarpPortal toWarpPortal(){
        return new WarpPortal(warpName, oneCorner.toLocation(), otherCorner.toLocation());
    }

    public String serialize(){
        return WarpPortalsMain.GSON.toJson(this);
    }

    public static SerializedWarpPortal deserialize(String input){
        return WarpPortalsMain.GSON.fromJson(input, SerializedWarpPortal.class);
    }
}
