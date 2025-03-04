package me.hsgamer.questznpcs;

import io.github.gonalez.znpcs.npc.event.NPCInteractEvent;
import me.pikamug.quests.BukkitQuestsPlugin;
import me.pikamug.quests.dependencies.npc.BukkitNpcDependency;
import me.pikamug.quests.listeners.BukkitNpcListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.util.UUID;

public class ZnpcsListener extends BukkitNpcListener {
    public ZnpcsListener(BukkitQuestsPlugin plugin, BukkitNpcDependency npcDependency) {
        super(plugin, npcDependency);
    }

    @EventHandler
    public void onNPCInteract(final NPCInteractEvent event) {
        Player player = event.getPlayer();
        UUID npcUUID = event.getNpc() != null ? event.getNpc().getUUID() : null;

        if (event.isLeftClick()) {
            onNpcInteract(player, npcUUID, ClickType.LEFT);
        } else if (event.isRightClick()) {
            onNpcInteract(player, npcUUID, ClickType.RIGHT);
        }
    }
}
