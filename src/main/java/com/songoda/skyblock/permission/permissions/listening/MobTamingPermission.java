package com.songoda.skyblock.permission.permissions.listening;

import com.songoda.core.compatibility.CompatibleMaterial;
import com.songoda.skyblock.SkyBlock;
import com.songoda.skyblock.message.MessageManager;
import com.songoda.skyblock.permission.ListeningPermission;
import com.songoda.skyblock.permission.PermissionHandler;
import com.songoda.skyblock.permission.PermissionType;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class MobTamingPermission extends ListeningPermission {

    private final SkyBlock plugin;
    private final MessageManager messageManager;

    public MobTamingPermission(SkyBlock plugin) {
        super("MobTaming", CompatibleMaterial.POPPY, PermissionType.GENERIC);
        this.plugin = plugin;
        this.messageManager = plugin.getMessageManager();
    }

    @PermissionHandler
    public void onVehicleDamage(VehicleDamageEvent event) {
        Player player = (Player) event.getAttacker();
        cancelAndMessage(event, player, plugin, messageManager);
    }

    @PermissionHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        Player player = (Player) event.getAttacker();
        cancelAndMessage(event, player, plugin, messageManager);
    }

    @PermissionHandler
    public void onEntityDamageByEntity(EntityTameEvent event) {

        Player player;
        if (event.getOwner() instanceof Player)
            player = (Player)event.getOwner();
        else return;

        cancelAndMessage(event, player, plugin, messageManager);
    }
}

