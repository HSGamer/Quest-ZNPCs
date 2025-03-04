package me.hsgamer.questznpcs;

import me.pikamug.quests.BukkitQuestsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Quest_ZNPCs extends JavaPlugin {
    @Override
    public void onEnable() {
        BukkitQuestsPlugin questsPlugin = (BukkitQuestsPlugin) Bukkit.getPluginManager().getPlugin("Quests");
        ZnpcsDependency dependency = new ZnpcsDependency();
        ZnpcsListener listener = new ZnpcsListener(questsPlugin, dependency);
        questsPlugin.getDependencies().addNpcDependency(dependency);
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
