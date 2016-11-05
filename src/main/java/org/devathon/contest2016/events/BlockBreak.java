package org.devathon.contest2016.events;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.devathon.contest2016.DevathonPlugin;

import java.util.Set;

/**
 * Created by Innectic on 11/5/2016.
 */
public class BlockBreak implements Listener {

    // TODO: Come back to this and make it less sad.

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();

        String id = farmExists(block.getX(), block.getY(), block.getZ());

        if (id != "") DevathonPlugin.instance.getConfig().set(id, null);
    }

    private String farmExists(int x, int y, int z) {
        Set<String> farmBlocks = DevathonPlugin.instance.getConfig()
                .getConfigurationSection("farmingBlocks").getKeys(false);
        if (farmBlocks.size() >= 1) {
            for (String id : farmBlocks) {
                if (DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".x") == x
                        && DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".y") == y
                        && DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".z") == z) {
                    return id;
                }
            }
        }
        return "";
    }
}
