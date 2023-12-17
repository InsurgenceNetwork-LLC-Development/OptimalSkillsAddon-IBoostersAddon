package com.insurgencedev.optimalskillsaddon;

import com.insurgencedev.optimalskillsaddon.listeners.OptimalSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "OptimalSkillsAddon", version = "1.0.0", author = "InsurgenceDev", description = "OptimalSkills Support")
public class OptimalSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new OptimalSkillsEventListener());
    }
}
