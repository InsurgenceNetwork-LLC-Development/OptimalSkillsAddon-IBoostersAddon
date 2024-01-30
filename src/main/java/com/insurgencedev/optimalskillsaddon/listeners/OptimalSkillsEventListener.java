package com.insurgencedev.optimalskillsaddon.listeners;

import gg.optimalgames.skills.api.events.SkillExperienceGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

public final class OptimalSkillsEventListener implements Listener {

    @EventHandler
    private void onGain(SkillExperienceGainEvent event) {
        final String TYPE = "Skills";
        final String NAMESPACE = "OPTIMAL_SKILLS";
        final double[] totalMulti = {0};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getSkillProfile().getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        if (totalMulti[0] > 0) {
            event.setExperience(Math.round(calculateAmount(event.getExperience(), totalMulti[0])));
        }
    }

    private double calculateAmount(double amount, double multi) {
        return amount * (multi < 1 ? 1 + multi : multi);
    }
}
