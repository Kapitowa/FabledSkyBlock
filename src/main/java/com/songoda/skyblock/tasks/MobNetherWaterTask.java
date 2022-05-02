package com.songoda.skyblock.tasks;

import com.songoda.skyblock.SkyBlock;

public class MobNetherWaterTask  {

    private static MobNetherWaterTask instance;
    private static SkyBlock plugin;

    public MobNetherWaterTask(SkyBlock plug) {
        plugin = plug;
    }

    public static MobNetherWaterTask startTask(SkyBlock plug) {
        plugin = plug;

        return instance;
    }

    public void onDisable() {
    }


}
