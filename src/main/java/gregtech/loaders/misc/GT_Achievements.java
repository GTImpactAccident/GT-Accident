package gregtech.loaders.misc;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import ic2.core.Ic2Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fluids.FluidStack;
import thaumcraft.api.ThaumcraftApiHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GT_Achievements {

    public static List<Materials> oreList = new ArrayList<>();
    public static List<Integer[]> oreStats = new ArrayList<>();
    public static int oreReg = -1;
    public static int assReg = -1;
    public ConcurrentHashMap<String, Achievement> achievementList;
    public ConcurrentHashMap<String, Boolean> issuedAchievements;
    public int adjX = 5;
    public int adjY = 9;

    public GT_Achievements() {
        this.achievementList = new ConcurrentHashMap<>();
        this.issuedAchievements = new ConcurrentHashMap<>();

        if (GT_Mod.gregtechproxy.mAchievements) {
            AchievementPage.registerAchievementPage(new AchievementPage("GregTech 5", this.achievementList.values().toArray(new Achievement[this.achievementList.size()])));
            MinecraftForge.EVENT_BUS.register(this);
            FMLCommonHandler.instance().bus().register(this);
        }
    }

    public Achievement registerAchievement(String textId, int x, int y, ItemStack icon, Achievement requirement, boolean special) {
        if (!GT_Mod.gregtechproxy.mAchievements) {
            return null;
        }
        Achievement achievement = new Achievement(textId, textId, this.adjX + x, this.adjY + y, icon, requirement);
        if (special) {
            achievement.setSpecial();
        }
        achievement.registerStat();
        if (GT_Values.D2) {
            GT_Log.out.println("achievement." + textId + "=");
            GT_Log.out.println("achievement." + textId + ".desc=");
        }
        this.achievementList.put(textId, achievement);
        return achievement;
    }

    public Achievement registerAchievement(String textId, int x, int y, ItemStack icon, String requirement, boolean special) {
        if (!GT_Mod.gregtechproxy.mAchievements) {
            return null;
        }
        Achievement achievement = new Achievement(textId, textId, this.adjX + x, this.adjY + y, icon, getAchievement(requirement));
        if (special) {
            achievement.setSpecial();
        }
        achievement.registerStat();
        if (GT_Values.D2) {
            GT_Log.out.println("achievement." + textId + "=");
            GT_Log.out.println("achievement." + textId + ".desc=");
        }
        this.achievementList.put(textId, achievement);
        return achievement;
    }

    public Achievement registerOreAchievement(Materials aMaterial) {
        if (this.achievementList.get(aMaterial.mName) == null) {
            oreReg++;
            return registerAchievement(aMaterial.mName, -(6 + oreReg % 5), ((oreReg) / 5) - 8, new ItemStack(GregTech_API.sBlockOres1, 1,
                    aMaterial.mMetaItemSubID), AchievementList.openInventory, false);
        }
        return null;
    }

    public Achievement registerAssAchievement(GT_Recipe recipe) {
        if (this.achievementList.get(recipe.getOutput(0).getUnlocalizedName()) == null) {
            assReg++;
            return registerAchievement(recipe.getOutput(0).getUnlocalizedName(),
                    -(11 + assReg % 5), ((assReg) / 5) - 8, recipe.getOutput(0), AchievementList.openInventory, false);
        }
        return null;
    }

    public void issueAchievement(EntityPlayer entityplayer, String textId) {
        if (entityplayer == null || !GT_Mod.gregtechproxy.mAchievements) {
            return;
        }
        entityplayer.triggerAchievement(this.achievementList.get(textId));
    }

    public Achievement getAchievement(String textId) {
        if (this.achievementList.containsKey(textId)) {
            return this.achievementList.get(textId);
        }
        return null;
    }

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event) {
        EntityPlayer player = event.player;
        ItemStack stack = event.crafting;
        if (player == null || stack == null) {
            return;
        }
        //
    }

    @SubscribeEvent
    public void onSmelting(ItemSmeltedEvent event) {
        EntityPlayer player = event.player;
        ItemStack stack = event.smelting;
        if (player == null || stack == null) {
            return;
        }
        //
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        EntityPlayer player = event.entityPlayer;
        ItemStack stack = event.item.getEntityItem();
        if (player == null || stack == null) {
            return;
        }
        //
    }
}
