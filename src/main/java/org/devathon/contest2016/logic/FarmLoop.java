package org.devathon.contest2016.logic;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.devathon.contest2016.DevathonPlugin;

import java.util.Set;

/**
 * Created by Innectic on 11/5/2016.
 */
public class FarmLoop implements Runnable {

    public void run() {
        Set<String> farmBlocks = DevathonPlugin.instance.getConfig()
                .getConfigurationSection("farmingBlocks").getKeys(false);
        if (farmBlocks.size() != 1) {
            for (String id : farmBlocks) {

            }
        }
    }

    public boolean isFarmBlock(Location location) {
        Block block = location.getBlock();

        if (block.getType() == Material.DIAMOND_BLOCK ||
                block.getType() == Material.IRON_BLOCK||
                block.getType() == Material.GOLD_BLOCK) {
            location.setY(location.getY() + 1);
            block = location.getBlock();
            if (block.getType() == Material.CHEST) return true;
        }

        return false;
    }
}
