package org.devathon.contest2016.events;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.devathon.contest2016.DevathonPlugin;

/**
 * Created by Innectic on 11/5/2016.
 */
public class BlockPlace implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Block block = e.getBlock();
        int lastID = DevathonPlugin.instance.getConfig().getInt("lastID");

        switch(block.getType()) {
            case DIAMOND_BLOCK:
                try {
                    DevathonPlugin.instance.getConfig().set("farmingBlocks.lastID", (lastID + 1));
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.x",
                            block.getLocation().getBlockX());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.y",
                            block.getLocation().getBlockY());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.z",
                            block.getLocation().getBlockZ());

                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".type", "diamond");
                    DevathonPlugin.instance.saveConfig();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case GOLD_BLOCK:
                try {
                    DevathonPlugin.instance.getConfig().set("farmingBlocks.lastID", (lastID + 1));
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.x",
                            block.getLocation().getBlockX());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.y",
                            block.getLocation().getBlockY());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.z",
                            block.getLocation().getBlockZ());

                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".type", "gold");
                    DevathonPlugin.instance.saveConfig();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case IRON_BLOCK:
                try {
                    DevathonPlugin.instance.getConfig().set("farmingBlocks.lastID", (lastID + 1));
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.x",
                            block.getLocation().getBlockX());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.y",
                            block.getLocation().getBlockY());
                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".location.z",
                            block.getLocation().getBlockZ());

                    DevathonPlugin.instance.getConfig().set("farmingBlocks." + lastID + ".type", "iron");
                    DevathonPlugin.instance.saveConfig();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                break;

            default:
                break;
        }
    }
}
