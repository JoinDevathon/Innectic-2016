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

        if (farmBlocks.size() > 0) {
            for (String id : farmBlocks) {
                Location location = new Location(Bukkit.getWorld(DevathonPlugin.instance.getConfig().getString("world")),
                        DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.x"),
                        DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.y"),
                        DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.z"));

                boolean exists = FarmUtils.isValidFarm(location);

                if (exists) {
                    Block baseBlock = location.getBlock();
                    int add = addAmount(baseBlock);
//                Bad code lies ahead!
//                TODO: Look into making this code much better
                    location.setX(location.getX() + 1);

                    Block block = location.getBlock();

                    if (block.getType() == Material.CROPS
                            || block.getType() == Material.CARROT
                            || block.getType() == Material.POTATO) block.setData((byte) add);

                    location.setX(location.getX() - 2);

                    block = location.getBlock();

                    if (block.getType() == Material.CROPS
                            || block.getType() == Material.CARROT
                            || block.getType() == Material.POTATO) block.setData((byte) add);
                    location.setX(location.getX() + 1);
                    location.setZ(location.getZ() + 1);

                    block = location.getBlock();

                    if (block.getType() == Material.CROPS
                            || block.getType() == Material.CARROT
                            || block.getType() == Material.POTATO) block.setData((byte) add);
                    location.setZ(location.getZ() - 2);

                    block = location.getBlock();

                    if (block.getType() == Material.CROPS
                            || block.getType() == Material.CARROT
                            || block.getType() == Material.POTATO) block.setData((byte) add);
                }
            }
        }
    }

    private int addAmount(Block block) {
        if (block.getType() == Material.DIAMOND_BLOCK) {
            return 7;
        } else if (block.getType() == Material.GOLD_BLOCK) {
            return 4;
        } else if (block.getType() == Material.IRON_BLOCK) {
            return 2;
        }

        return 0;
    }
}
