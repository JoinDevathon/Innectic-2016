package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.events.BlockBreak;
import org.devathon.contest2016.events.BlockPlace;
import org.devathon.contest2016.events.PlayerJoin;
import org.devathon.contest2016.logic.FarmLoop;

import java.io.File;

public class DevathonPlugin extends JavaPlugin {

    public static DevathonPlugin instance;

    private FarmLoop farmLoop;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        registerEvents();

        farmLoop = new FarmLoop();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, farmLoop, 0L, 20L);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new BlockPlace(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new PlayerJoin(), this);
    }

    private void loadConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }

            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) saveDefaultConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

