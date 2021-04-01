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

    public static List<Materials> oreList = new ArrayList<Materials>();
    public static List<Integer[]> oreStats = new ArrayList<Integer[]>();
    public static int oreReg = -1;
    public static int assReg = -1;
    public ConcurrentHashMap<String, Achievement> achievementList;
    public ConcurrentHashMap<String, Boolean> issuedAchievements;
    public int adjX = 5;
    public int adjY = 9;

    public GT_Achievements() {
        this.achievementList = new ConcurrentHashMap<>();
        this.issuedAchievements = new ConcurrentHashMap<>();
        int oreList_sS = oreList.size();
        for (int i = 0; i < oreList_sS; i++) {
            if (oreList.get(i) != null) {
                if (GT_Values.D1 && this.achievementList.get(oreList.get(i).mName) == null) {
                    GT_Log.out.println("achievement." + oreList.get(i).mName + "=Find " + oreList.get(i).mName + " Ore");

                    StringBuilder dimensions = new StringBuilder();
                    boolean isFirst = true;
                    if (oreStats.get(i)[3] == 1) {
                        dimensions.append("Overworld");
                        isFirst = false;
                    }
                    if (oreStats.get(i)[4] == 1) {
                        if (!isFirst) dimensions.append("/");
                        dimensions.append("Nether");
                        isFirst = false;
                    }
                    if (oreStats.get(i)[5] == 1) {
                        if (!isFirst) dimensions.append("/");
                        dimensions.append("End");
                        isFirst = false;
                    }
                    GT_Log.out.println("achievement." + oreList.get(i).mName + ".desc=Height: " + (oreStats.get(i)[0]) + "-" + (oreStats.get(i)[1]) + ", Chance: " + (oreStats.get(i)[2]) + ", " + dimensions.toString());
                }
                registerOreAchievement(oreList.get(i));
            }
        }

        for (GT_Recipe recipe : GT_Recipe.GT_Recipe_Map.sAssemblylineVisualRecipes.mRecipeList)
            registerAssAchievement(recipe);

        if (GT_Mod.gregtechproxy.mAchievements) {
            AchievementPage.registerAchievementPage(new AchievementPage("GregTech 5", this.achievementList.values().toArray(
                    new Achievement[this.achievementList.size()])));
            MinecraftForge.EVENT_BUS.register(this);
            FMLCommonHandler.instance().bus().register(this);
        }
    }

    public static void registerOre(Materials aMaterial, int min, int max, int chance, boolean overworld, boolean nether, boolean end) {
        if (aMaterial != Materials._NULL) {
            oreList.add(aMaterial);
        }
        oreStats.add(new Integer[]{min, max, chance, overworld ? 1 : 0, nether ? 1 : 0, end ? 1 : 0});
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
            return registerAchievement(recipe.getOutput(0).getUnlocalizedName(), -(11 + assReg % 5), ((assReg) / 5) - 8, recipe.getOutput(0)
                    , AchievementList.openInventory, false);
        }
        return null;
    }

    public void issueAchievement(EntityPlayer entityplayer, String textId) {
        if (entityplayer == null || !GT_Mod.gregtechproxy.mAchievements) {
            return;
        }
//		if (this.achievementList.containsKey(textId)) {
//			if(this.issuedAchievements.containsKey((entityplayer.getDisplayName()+textId))){
//			return;
//			}else{
//			this.issuedAchievements.put((entityplayer.getDisplayName()+textId), true);
        entityplayer.triggerAchievement(this.achievementList.get(textId));
//			}
//		}
    }

    public Achievement getAchievement(String textId) {
        if (this.achievementList.containsKey(textId)) {
            return this.achievementList.get(textId);
        }
        return null;
    }

    public void issueAchivementHatch(EntityPlayer player, ItemStack stack) {
        if (player == null || stack == null) {
            return;
        }
        ItemData data = GT_OreDictUnificator.getItemData(stack);

        if ((data != null) && (data.mPrefix == OrePrefixes.ingot)) {
            if (data.mMaterial.mMaterial == Materials.Aluminium) {
                issueAchievement(player, "gtaluminium");
            } else if (data.mMaterial.mMaterial == Materials.Titanium) {
                issueAchievement(player, "titan");
            } else if (data.mMaterial.mMaterial == Materials.BlueSteel) {
                issueAchievement(player, "complexalloys");
            } else if (data.mMaterial.mMaterial == Materials.Tungsten) {
                issueAchievement(player, "tungsten");
            } else if (data.mMaterial.mMaterial == Materials.Osmium) {
                issueAchievement(player, "osmium");
            } else if (data.mMaterial.mMaterial == Materials.TungstenSteel) {
                issueAchievement(player, "tungstensteel");
            } else if (data.mMaterial.mMaterial == Materials.HSSG) {
                issueAchievement(player, "hssg");
            } else if (data.mMaterial.mMaterial == Materials.Naquadah) {
                issueAchievement(player, "stargatematerial");
            } else if (data.mMaterial.mMaterial == Materials.NaquadahAlloy) {
                issueAchievement(player, "alienmetallurgy");
            } else if (data.mMaterial.mMaterial == Materials.Naquadria) {
                issueAchievement(player, "finalpreparations");
            }
        }
        if (stack.getUnlocalizedName().equals("ic2.itemPartIndustrialDiamond")) {
            issueAchievement(player, "artificaldia");
            issueAchievement(player, "buildCoalDiamond");

        }
    }

    public void issueAchivementHatchFluid(EntityPlayer player, FluidStack fluid) {
        if (player == null || fluid == null) {
            return;
        }
        if (fluid.getFluid().getUnlocalizedName().equals("fluid.plasma.helium")) {
            issueAchievement(player, "fusion");
        } else if (fluid.getFluid().getUnlocalizedName().equals("fluid.molten.europium")) {
            issueAchievement(player, "advancing");
        } else if (fluid.getFluid().getUnlocalizedName().equals("fluid.molten.naquadah")) {
            issueAchievement(player, "stargateliquid");
        } else if (fluid.getFluid().getUnlocalizedName().equals("fluid.molten.americium")) {
            issueAchievement(player, "tothelimit");
        } else if (fluid.getFluid().getUnlocalizedName().equals("fluid.molten.neutronium")) {
            issueAchievement(player, "denseaspossible");
        } else if (fluid.getFluid().getUnlocalizedName().equals("fluid.plasma.nitrogen")) {
            issueAchievement(player, "higherefficency");
        }
    }

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event) {
        EntityPlayer player = event.player;
        ItemStack stack = event.crafting;
        if (player == null || stack == null) {
            return;
        }
        if (stack.getItem() == Items.paper) {
            player.inventory.addItemStackToInventory(new ItemStack(Blocks.stone_slab, 2));
        }
        ItemData data = GT_OreDictUnificator.getItemData(stack);
        if (data != null) {
            if (data.mPrefix == OrePrefixes.dust && data.mMaterial.mMaterial == Materials.Bronze) {
                issueAchievement(player, "bronze");
//            } else if (data.mPrefix == OrePrefixes.circuit && data.mMaterial.mMaterial == Materials.Advanced) {
//                issueAchievement(player, "stepforward");
            }
        }
        if (stack.getUnlocalizedName().startsWith("gt.metaitem.")) {
            if (stack.getUnlocalizedName().equals("gt.metaitem.01.2300")) {
                issueAchievement(player, "bronze");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32700")) {
                issueAchievement(player, "smallparts");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32702")) {
                issueAchievement(player, "bettercircuits");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.23354")) {
                issueAchievement(player, "magneticiron");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32600")) {
                issueAchievement(player, "lvmotor");
                issueAchievement(player, "buildCable");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32610")) {
                issueAchievement(player, "pumpcover");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32630")) {
                issueAchievement(player, "transport");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32650")) {
                issueAchievement(player, "complexmachines");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32670")) {
                issueAchievement(player, "hightech");
            }
        } else if (stack.getUnlocalizedName().equals("ic2.blockCrop")) {
            issueAchievement(player, "crops");
        } else if (stack.getUnlocalizedName().equals("ic2.itemPartCircuit")) {
            issueAchievement(player, "gtbasiccircuit");
        } else if (stack.getUnlocalizedName().equals("ic2.itemPartCircuitAdv")) {
            issueAchievement(player, "stepforward");
        } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.")) {
            if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.arcfurnace.tier.")) {
                issueAchievement(player, "recycling");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.disassembler.tier.")) {
                issueAchievement(player, "repair");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.boiler.solar")) {
                issueAchievement(player, "simplyeco");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.boiler.bronze")) {
                issueAchievement(player, "firststeam");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.boiler.steel")) {
                issueAchievement(player, "highpressure");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.bronzemachine.macerator")) {
                issueAchievement(player, "macerator");
                issueAchievement(player, "buildMacerator");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.bronzemachine.alloysmelter")) {
                issueAchievement(player, "alloysmelter");
                issueAchievement(player, "buildElecFurnace");
                if (stack.getUnlocalizedName().equals("gt.blockmachines.bronzemachine.alloysmelter.tier.3")) {
                    issueAchievement(player, "buildIndFurnace");
                }
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.bronzemachine.extractor")) {
                issueAchievement(player, "extract");
                issueAchievement(player, "buildCompressor");
                issueAchievement(player, "buildExtractor");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.automation.superbuffer.tier.")) {
                issueAchievement(player, "superbuffer");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.quantum.tank.tier.")) {
                issueAchievement(player, "whereistheocean");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.quantum.chest.tier.")) {
                issueAchievement(player, "newstorage");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.hammer.tier.")) {
                issueAchievement(player, "cheapermac");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.automation.chestbuffer.tier.")) {
                issueAchievement(player, "buffer");
                issueAchievement(player, "buildBatBox");
                if (stack.getUnlocalizedName().startsWith("gt.blockmachines.automation.chestbuffer.tier.3")) {
                    issueAchievement(player, "buildMFE");
                }
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicgenerator.steamturbine.tier.")) {
                issueAchievement(player, "steampower");
                issueAchievement(player, "buildGenerator");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.basicmachine.pump.tier.03")) {
                issueAchievement(player, "slurp");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.assembler.tier.")) {
                issueAchievement(player, "avengers");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.blastfurnace")) {
                issueAchievement(player, "ebf");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.batterybuffer.")) {
                issueAchievement(player, "batterys");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.hatch.energy.tier.02")) {
                issueAchievement(player, "upgradeebf");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.multifurnace")) {
                issueAchievement(player, "highpowersmelt");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.hatch.energy.tier.01")) {
                issueAchievement(player, "energyhatch");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.processingarray")) {
                issueAchievement(player, "factory");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.basicgenerator.magicenergyconverter.tier.01")) {
                issueAchievement(player, "magic");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.basicgenerator.magicenergyabsorber.tier.03")) {
                issueAchievement(player, "highmage");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.amplifab.tier.")) {
                issueAchievement(player, "amplifier");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.massfab.tier.")) {
                issueAchievement(player, "universal");
                issueAchievement(player, "buildMassFab");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicgenerator.naquadah.tier.")) {
                issueAchievement(player, "alienpower");
            } else if (stack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.replicator.tier.")) {
                issueAchievement(player, "replication");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.basicgenerator.plasmagenerator.tier.07")) {
                issueAchievement(player, "fullefficiency");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.largeturbine")) {
                issueAchievement(player, "muchsteam");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.largehpturbine")) {
                issueAchievement(player, "efficientsteam");
            } else if (stack.getUnlocalizedName().equals("gt.blockmachines.multimachine.cleanroom")) {
                issueAchievement(player, "gtcleanroom");
            }
        } else if (stack.getUnlocalizedName().equals("gt.neutronreflector")) {
            issueAchievement(player, "reflect");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.1")) {
            issueAchievement(player, "upgrade");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.2")) {
            issueAchievement(player, "upgrade2");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.3")) {
            issueAchievement(player, "upgrade3");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.4")) {
            issueAchievement(player, "upgrade4");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.5")) {
            issueAchievement(player, "upgrade5");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings5.6")) {
            issueAchievement(player, "over9000");
        } else if (stack.getUnlocalizedName().equals("gt.blockcasings.15")) {
            issueAchievement(player, "conducting");
        }
    }

    @SubscribeEvent
    public void onSmelting(ItemSmeltedEvent event) {
        EntityPlayer player = event.player;
        ItemStack stack = event.smelting;
        if (player == null || stack == null) {
            return;
        }
        if (stack.getItem() == Items.bread) {
            event.player.triggerAchievement(AchievementList.makeBread);
        }
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        EntityPlayer player = event.entityPlayer;
        ItemStack stack = event.item.getEntityItem();
        if (player == null || stack == null) {
            return;
        }
        ItemData data = GT_OreDictUnificator.getItemData(stack);
        if (data != null && data.mPrefix != null) {
            if (data.mPrefix == OrePrefixes.dust) {
                if (data.mMaterial.mMaterial == Materials.Lutetium) {
                    issueAchievement(player, "newmetal");
                }
                if (data.mMaterial.mMaterial != Materials.Gunpowder) {
                    issueAchievement(player, "cleandust");
                }
            } else if (data.mPrefix.name().startsWith("ore")) {
                int data_getAllMaterialStacks_sS = data.getAllMaterialStacks().size();
                for (int i = 0; i < data_getAllMaterialStacks_sS; i++) {
                    issueAchievement(player, data.getAllMaterialStacks().get(i).mMaterial.mName);
                    if (data.getAllMaterialStacks().get(i).mMaterial == Materials.Iron) {
                        issueAchievement(player, "iron");
                    }
                    if (data.getAllMaterialStacks().get(i).mMaterial == Materials.Copper || data.getAllMaterialStacks().get(i).mMaterial == Materials.Tin) {
                        issueAchievement(event.entityPlayer, "mineOre");
                    }

                }
            } else if (data.mPrefix == OrePrefixes.crushed) {
                issueAchievement(player, "crushed");
            } else if (data.mPrefix == OrePrefixes.crushedPurified) {
                issueAchievement(player, "washing");
            } else if (data.mPrefix == OrePrefixes.crushedCentrifuged) {
                issueAchievement(player, "spinit");
            } else if (data.mMaterial.mMaterial == Materials.Steel) {
                if (data.mPrefix == OrePrefixes.ingot && stack.stackSize == stack.getMaxStackSize()) {
                    issueAchievement(player, "steel");
                } else if (data.mPrefix == OrePrefixes.nugget && Loader.isModLoaded("Thaumcraft") && ThaumcraftApiHelper.isResearchComplete(player.getDisplayName(), "GT_IRON_TO_STEEL")) {
                    issueAchievement(player, "steel");
                }
//            } else if (data.mPrefix == OrePrefixes.circuit && data.mMaterial.mMaterial == Materials.Advanced) {
//                issueAchievement(player, "stepforward");
            }
        }
//        System.out.println(stack.getUnlocalizedName());
        if (stack.getUnlocalizedName().startsWith("gt.metaitem.")) {
            if (stack.getUnlocalizedName().equals("gt.metaitem.02.32500")) {
                issueAchievement(player, "havestlead");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32501")) {
                issueAchievement(player, "havestsilver");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32503")) {
                issueAchievement(player, "havestiron");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32504")) {
                issueAchievement(player, "havestgold");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32530")) {
                issueAchievement(player, "havestcopper");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32540")) {
                issueAchievement(player, "havesttin");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32510")) {
                issueAchievement(player, "havestoil");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.02.32511")) {
                issueAchievement(player, "havestemeralds");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32082")) {
                issueAchievement(player, "energyflow");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32702")) {
                issueAchievement(player, "bettercircuits");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32707")) {
                issueAchievement(player, "datasaving");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32597")) {
                issueAchievement(player, "orbs");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32599")) {
                issueAchievement(player, "thatspower");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32598")) {
                issueAchievement(player, "luck");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32749")) {
                issueAchievement(player, "closeit");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32730")) {
                issueAchievement(player, "manipulation");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32729")) {
                issueAchievement(player, "filterregulate");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32605")) {
                issueAchievement(player, "whatnow");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32736")) {
                issueAchievement(player, "zpmage");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32737")) {
                issueAchievement(player, "uvage");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32030")) {
                issueAchievement(player, "gtmonosilicon");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32036")) {
                issueAchievement(player, "gtlogicwafer");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32701")) {
                issueAchievement(player, "gtlogiccircuit");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32085")) {
                issueAchievement(player, "gtquantumprocessor");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32089")) {
                issueAchievement(player, "gtcrystalprocessor");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32092")) {
                issueAchievement(player, "gtwetware");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.03.32095")) {
                issueAchievement(player, "gtwetmain");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32736")) {
                issueAchievement(player, "zpmage");
            } else if (stack.getUnlocalizedName().equals("gt.metaitem.01.32737")) {
                issueAchievement(player, "uvage");
            }
        } else if (stack.getUnlocalizedName().equals("gt.Thoriumcell")) {
            issueAchievement(player, "newfuel");
        } else if ((stack.getItem() == Ic2Items.quantumBodyarmor.getItem()) || (stack.getItem() == Ic2Items.quantumBoots.getItem()) ||
                (stack.getItem() == Ic2Items.quantumHelmet.getItem()) || (stack.getItem() == Ic2Items.quantumLeggings.getItem())) {
            issueAchievement(player, "buildQArmor");
        } else if (stack.getUnlocalizedName().equals("ic2.itemPartCircuitAdv")) {
            issueAchievement(player, "stepforward");
        }
        if (player.capabilities.isCreativeMode && stack.getUnlocalizedName().equals("gt.metaitem.01.32761")) {//Debug Scanner pickup shows all assline recipes.
            for (GT_Recipe recipe : GT_Recipe.GT_Recipe_Map.sAssemblylineVisualRecipes.mRecipeList) {
                issueAchievement(player, recipe.getOutput(0).getUnlocalizedName());
                recipe.mHidden = false;
            }
        }
        for (GT_Recipe recipe : GT_Recipe.GT_Recipe_Map.sAssemblylineVisualRecipes.mRecipeList) {
            if (recipe.getOutput(0).getUnlocalizedName().equals(stack.getUnlocalizedName())) {
                issueAchievement(player, recipe.getOutput(0).getUnlocalizedName());
                recipe.mHidden = false;
            }
        }
    }
}
