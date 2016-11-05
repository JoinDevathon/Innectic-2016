package org.devathon.contest2016.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.devathon.contest2016.DevathonPlugin;

/**
 * Created by Innectic on 11/5/2016.
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (DevathonPlugin.instance.getConfig().getString("world") == ""
                || DevathonPlugin.instance.getConfig().getString("world") == null) {
            DevathonPlugin.instance.getConfig().set("world", e.getPlayer().getLocation().getWorld().getName());
        }
    }
}
