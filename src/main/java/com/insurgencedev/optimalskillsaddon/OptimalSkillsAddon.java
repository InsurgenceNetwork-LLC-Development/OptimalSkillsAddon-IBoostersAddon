package com.insurgencedev.optimalskillsaddon;

import com.insurgencedev.optimalskillsaddon.listeners.OptimalSkillsEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "OptimalSkillsAddon", version = "1.0.1", author = "InsurgenceDev", description = "OptimalSkills Support")
public class OptimalSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("OptimalSkills")) {
            registerEvent(new OptimalSkillsEventListener());
        }
    }
}
