package org.devathon.contest2016.logic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.util.FarmUtils;

import java.util.Set;

/**
 * Created by Innectic on 11/5/2016.
 */
public class FarmLoop implements Runnable {
    public void run() {
        Set<String> farmBlocks = DevathonPlugin.instance.getConfig()
                .getConfigurationSection("farmingBlocks").getKeys(false);

        for (String id : farmBlocks) {
            Location location = new Location(Bukkit.getWorld(DevathonPlugin.instance.getConfig().getString("world")),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.x"),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.y"),
                    DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.z"));

            boolean exists = FarmUtils.isValidFarm(location);

            if (exists) {
//                Bad code lies ahead!
//                TODO: Look into making this code much better
                location.setY(location.getY() - 1);

                location.setX(location.getX() + 1);
                Location posX = location;

                Block block = posX.getBlock();
                if (block.getType() == Material.CROPS
                        || block.getType() == Material.CARROT
                        || block.getType() == Material.POTATO) block.setData((byte) 7);

                location.setX(location.getX() - 2);
                Location negX = location;

                block = negX.getBlock();

                if (block.getType() == Material.CROPS
                        || block.getType() == Material.CARROT
                        || block.getType() == Material.POTATO) block.setData((byte) 7);
                location.setX(location.getX() + 1);
                location.setZ(location.getZ() + 1);
                Location posZ = location;

                block = posZ.getBlock();

                if (block.getType() == Material.CROPS
                        || block.getType() == Material.CARROT
                        || block.getType() == Material.POTATO) block.setData((byte) 7);
                location.setZ(location.getZ() - 2);
                Location negZ = location;

                block = negZ.getBlock();

                if (block.getType() == Material.CROPS
                        || block.getType() == Material.CARROT
                        || block.getType() == Material.POTATO) block.setData((byte) 7);

            }
        }
    }
}
