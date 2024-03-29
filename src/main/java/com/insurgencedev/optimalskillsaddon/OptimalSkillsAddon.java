package com.insurgencedev.optimalskillsaddon;

import com.insurgencedev.optimalskillsaddon.listeners.OptimalSkillsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "OptimalSkillsAddon", version = "1.0.3", author = "InsurgenceDev", description = "OptimalSkills Support")
public class OptimalSkillsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("OptimalSkills")) {
            registerEvent(new OptimalSkillsEventListener());
        }
    }
}
