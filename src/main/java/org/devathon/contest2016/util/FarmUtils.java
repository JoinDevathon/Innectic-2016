package org.devathon.contest2016.util;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * Created by Innectic on 11/5/2016.
 */
public class FarmUtils {

    public static boolean isValidFarm(Location location) {
        Block  block = location.getBlock();

        if (block.getType() == Material.DIAMOND_BLOCK
                || block.getType() == Material.GOLD_BLOCK
                || block.getType() == Material.IRON_BLOCK) {
            location.setY(location.getY() + 1);
            block = location.getBlock();
            if (block.getType() == Material.CHEST
                    || block.getType() == Material.TRAPPED_CHEST) return true;
        }
        return true;
    }
}
