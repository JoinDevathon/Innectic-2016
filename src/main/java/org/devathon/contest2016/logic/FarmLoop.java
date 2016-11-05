package org.devathon.contest2016.logic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.devathon.contest2016.DevathonPlugin;

import java.util.Set;

/**
 * Created by Innectic on 11/5/2016.
 */
public class FarmLoop implements Runnable {
    public void run() {
//        Bukkit.broadcastMessage(DevathonPlugin.instance.getConfig().getString("farmingBlocks.0.location.x"))
        Set<String> farmBlocks = DevathonPlugin.instance.getConfig()
                .getConfigurationSection("farmingBlocks").getKeys(false);

        for (String id : farmBlocks) {
            Location location = new Location(Bukkit.getWorld(DevathonPlugin.instance.getConfig().getString("world")),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.x"),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.y"),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.z"));


        }
    }
}
