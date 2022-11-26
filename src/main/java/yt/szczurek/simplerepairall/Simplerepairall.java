package yt.szczurek.simplerepairall;

import org.bukkit.plugin.java.JavaPlugin;
import yt.szczurek.simplerepairall.command.RepairAllExecutor;

public final class Simplerepairall extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("repairall").setExecutor(new RepairAllExecutor());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
