package cn.nyatu.SakiMugi.StrongRose;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.plugin.java.JavaPlugin;

/** 允许在下界砖和红色下界砖上种植凋零玫瑰 */
public final class StrongRose extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("StrongRose enabled.");
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        if (event.getMaterial() != Material.WITHER_ROSE) return;
        Material support = event.getBlock().getRelative(0, -1, 0).getType();
        if (support == Material.NETHER_BRICKS || support == Material.RED_NETHER_BRICKS) {
            event.setBuildable(true);
        }
    }
}
