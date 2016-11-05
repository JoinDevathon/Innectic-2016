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

    private Set<String> farmBlocks;

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();

        String id = farmExists(block.getX(), block.getY(), block.getZ());

        if (id != null) {
            try {
                DevathonPlugin.instance.getConfig().set("farmingBlocks." + id, null);
                DevathonPlugin.instance.saveConfig();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private String farmExists(int x, int y, int z) {
        try {
            farmBlocks = DevathonPlugin.instance.getConfig()
                    .getConfigurationSection("farmingBlocks").getKeys(false);

        } catch (NullPointerException e) {

        }

        if (farmBlocks != null) {
            for (String id : farmBlocks) {
                if (DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.x") == x
                        && DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.y") == y
                        && DevathonPlugin.instance.getConfig().getInt("farmingBlocks." + id + ".location.z") == z) {
                    return id;
                }
            }
        }
        return null;
    }
}
