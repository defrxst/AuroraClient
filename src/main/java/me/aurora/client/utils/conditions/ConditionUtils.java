package me.aurora.client.utils.conditions;

import me.aurora.client.utils.string.StringUtils;
import net.minecraft.scoreboard.ScoreObjective;

import static me.aurora.client.Aurora.mc;

/**
 * @author Gabagooooooooooool
 * @version 2.0
 * @brief Condition Utilities
 */
public class ConditionUtils {
    public static boolean inGame() { return (mc.thePlayer != null && mc.theWorld != null); }

    public static boolean inSkyblock() {
        if (!inGame()) return false;
        ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
        return scoreboardObj != null && (StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("SKYBLOCK") || StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("SKIBLOCK"));
    }

    public static boolean inCoalMine() {
        if (!inGame()) return false;
        ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(5);
        return scoreboardObj != null && (StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Coal Mine") || StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Coal Mine"));
    }

    public static boolean inVoidSepulture() {
        if (!inGame()) return false;
        ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(5);
        return scoreboardObj != null && (StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Void Sepulture") || StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Void Sepulture"));
    }

    public static boolean inDragonsNest() {
        if (!inGame()) return false;
        ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(5);
        return scoreboardObj != null && (StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Dragon's Nest") || StringUtils.removeFormatting(scoreboardObj.getDisplayName()).contains("Dragon's Nest"));
    }
}
