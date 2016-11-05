package org.devathon.contest2016.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by Innectic on 11/5/2016.
 */
public class BlockPlace implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        switch(e.getBlock().getType()) {
            case DIAMOND_BLOCK:
                break;

            case GOLD_BLOCK:
                break;

            case IRON_BLOCK:
                break;

            default:
                break;
        }
    }
}
