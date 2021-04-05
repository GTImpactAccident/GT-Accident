package gregtech.common.items;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.items.GT_MetaGenerated_Item_X32;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.util.*;
import gregtech.common.items.behaviors.Behaviour_Arrow;
import gregtech.common.items.behaviors.Behaviour_ProspectorsBook;
import gregtech.common.items.behaviors.Behaviour_ProspectorsBook_Creative;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class GT_MetaGenerated_Item_02 extends GT_MetaGenerated_Item_X32 {
    public static GT_MetaGenerated_Item_02 INSTANCE;
    private final static String aTextCover = "Usable as Cover";
    private final static String aTextForestry = "Forestry";

    public GT_MetaGenerated_Item_02() {
        super("metaitem.02", OrePrefixes.toolHeadSword, OrePrefixes.toolHeadPickaxe, OrePrefixes.toolHeadShovel, OrePrefixes.toolHeadAxe, OrePrefixes.toolHeadHoe, OrePrefixes.toolHeadHammer, OrePrefixes.toolHeadFile, OrePrefixes.toolHeadSaw, OrePrefixes.toolHeadDrill, OrePrefixes.toolHeadChainsaw, OrePrefixes.toolHeadWrench, OrePrefixes.toolHeadUniversalSpade, OrePrefixes.toolHeadSense, OrePrefixes.toolHeadPlow, OrePrefixes.toolHeadBuzzSaw, OrePrefixes.turbineBlade, OrePrefixes.wireFine, OrePrefixes.gearGtSmall, OrePrefixes.rotor, OrePrefixes.stickLong, OrePrefixes.springSmall, OrePrefixes.spring, OrePrefixes.gemFlawed, OrePrefixes.gemFlawless, OrePrefixes.gemExquisite, OrePrefixes.gearGt);
        INSTANCE = this;

        int tLastID = 0;
        
        ItemList.GelledToluene.set(addItem(tLastID = 10, "Gelled Toluene", "Raw Explosive"));

        ItemList.ProspectorsBook.set(addItem(tLastID = 11, "Miner's Diary", "Tells a story of unknown miner ", new Behaviour_ProspectorsBook()));
        ItemList.ProspectorsBookCreative.set(addItem(tLastID = 12, "Miner's Diary Generator", "", new Behaviour_ProspectorsBook_Creative()));

        ItemList.Dye_Indigo.set(addItem(tLastID = 410, "Indigo Dye", "Blue Dye"));
        for (byte i = 0; i < 16; i = (byte) (i + 1)) {
            ItemList.DYE_ONLY_ITEMS[i].set(addItem(tLastID = 414 + i, Dyes.get(i).mName + " Dye", "", Dyes.get(i).name()));
        }
       

        ItemList.SFMixture.set(addItem(tLastID = 270, "Super Fuel Binder", "Raw Material"));
        ItemList.MSFMixture.set(addItem(tLastID = 271, "Magic Super Fuel Binder", "Raw Material"));

        ItemList.Crop_Drop_Plumbilia.set(addItem(tLastID = 500, "Plumbilia Leaf", "Source of Lead"));
        ItemList.Crop_Drop_Argentia.set(addItem(tLastID = 501, "Argentia Leaf", "Source of Silver"));
        ItemList.Crop_Drop_Indigo.set(addItem(tLastID = 502, "Indigo Blossom", "Used for making Blue Dye"));
        ItemList.Crop_Drop_Ferru.set(addItem(tLastID = 503, "Ferru Leaf", "Source of Iron"));
        ItemList.Crop_Drop_Aurelia.set(addItem(tLastID = 504, "Aurelia Leaf", "Source of Gold"));
        ItemList.Crop_Drop_TeaLeaf.set(addItem(tLastID = 505, "Tea Leaf", "Source of Tea", "cropTea"));

        ItemList.Crop_Drop_OilBerry.set(addItem(tLastID = 510, "Oil Berry", "Oil in Berry form"));
        ItemList.Crop_Drop_BobsYerUncleRanks.set(addItem(tLastID = 511, "Bobs-Yer-Uncle-Berry", "Source of Emeralds"));
        ItemList.Crop_Drop_UUMBerry.set(addItem(tLastID = 512, "UUM Berry", "UUM in Berry form"));
        ItemList.Crop_Drop_UUABerry.set(addItem(tLastID = 513, "UUA Berry", "UUA in Berry form"));

        ItemList.Crop_Drop_MilkWart.set(addItem(tLastID = 520, "Milk Wart", "Source of Milk"));

        ItemList.Crop_Drop_Coppon.set(addItem(tLastID = 530, "Coppon Fiber", "ORANGE WOOOOOOOL!!!"));

        ItemList.Crop_Drop_Tine.set(addItem(tLastID = 540, "Tine Twig", "Source of Tin"));
        setBurnValue(32000 + tLastID, 100);

        ItemList.Crop_Drop_Bauxite.set(addItem(tLastID = 521, "Bauxia Leaf", "Source of Aluminium"));
        ItemList.Crop_Drop_Ilmenite.set(addItem(tLastID = 522, "Titania Leaf", "Source of Titanium"));
        ItemList.Crop_Drop_Pitchblende.set(addItem(tLastID = 523, "Reactoria Leaf", "Source of Uranium"));
        ItemList.Crop_Drop_Uraninite.set(addItem(tLastID = 524, "Uranium Leaf", "Source of Uranite"));
        ItemList.Crop_Drop_Thorium.set(addItem(tLastID = 526, "Thunder Leaf", "Source of Thorium"));
        ItemList.Crop_Drop_Nickel.set(addItem(tLastID = 527, "Nickelback Leaf", "Source of Nickel"));
        ItemList.Crop_Drop_Zinc.set(addItem(tLastID = 528, "Galvania Leaf", "Source of Zinc"));
        ItemList.Crop_Drop_Manganese.set(addItem(tLastID = 529, "Pyrolusium Leaf", "Source of Manganese"));
        ItemList.Crop_Drop_Scheelite.set(addItem(tLastID = 531, "Scheelinium Leaf", "Source of Tungsten"));
        ItemList.Crop_Drop_Platinum.set(addItem(tLastID = 532, "Platina Leaf", "Source of Platinum"));
        ItemList.Crop_Drop_Iridium.set(addItem(tLastID = 533, "Quantaria Leaf", "Source of Iridium"));
        ItemList.Crop_Drop_Osmium.set(addItem(tLastID = 534, "Quantaria Leaf", "Source of Osmium"));
        ItemList.Crop_Drop_Naquadah.set(addItem(tLastID = 535, "Stargatium Leaf", "Source of Naquadah"));

        ItemList.Crop_Drop_Chilly.set(addItem(tLastID = 550, "Chilly Pepper", "It is red and hot", "cropChilipepper", new GT_FoodStat(1, 0.3F, EnumAction.eat, null, false, true, false, Potion.confusion.id, 200, 1, 40)));
        ItemList.Crop_Drop_Lemon.set(addItem(tLastID = 551, "Lemon", "Don't make Lemonade", "cropLemon", new GT_FoodStat(1, 0.3F, EnumAction.eat, null, false, true, false)));
        ItemList.Crop_Drop_Tomato.set(addItem(tLastID = 552, "Tomato", "Solid Ketchup", "cropTomato", new GT_FoodStat(1, 0.2F, EnumAction.eat, null, false, true, false)));
        ItemList.Crop_Drop_MTomato.set(addItem(tLastID = 553, "Max Tomato", "Full Health in one Tomato", "cropTomato", new GT_FoodStat(9, 1.0F, EnumAction.eat, null, false, true, false, Potion.regeneration.id, 100, 100, 100)));
        ItemList.Crop_Drop_Grapes.set(addItem(tLastID = 554, "Grapes", "Source of Wine", "cropGrape", new GT_FoodStat(2, 0.3F, EnumAction.eat, null, false, true, false)));
        ItemList.Crop_Drop_Onion.set(addItem(tLastID = 555, "Onion", "Taking over the whole Taste", "cropOnion", new GT_FoodStat(2, 0.2F, EnumAction.eat, null, false, true, false)));
        ItemList.Crop_Drop_Cucumber.set(addItem(tLastID = 556, "Cucumber", "Not a Sea Cucumber!", "cropCucumber", new GT_FoodStat(1, 0.2F, EnumAction.eat, null, false, true, false)));
        ItemList.Crop_Drop_Rape.set(addItem(tLastID = 557, "Rape", "Time to oil up!"));
        
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 0), new ItemStack(Items.dye, 2, 1));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 1), new ItemStack(Items.dye, 2, 12));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Items.dye, 2, 13));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 3), new ItemStack(Items.dye, 2, 7));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 4), new ItemStack(Items.dye, 2, 1));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 5), new ItemStack(Items.dye, 2, 14));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 6), new ItemStack(Items.dye, 2, 7));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 7), new ItemStack(Items.dye, 2, 9));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.red_flower, 1, 8), new ItemStack(Items.dye, 2, 7));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.yellow_flower, 1, 0), new ItemStack(Items.dye, 2, 11));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.double_plant, 1, 0), new ItemStack(Items.dye, 3, 11));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.double_plant, 1, 1), new ItemStack(Items.dye, 3, 13));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.double_plant, 1, 4), new ItemStack(Items.dye, 3, 1));
        GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.double_plant, 1, 5), new ItemStack(Items.dye, 3, 9));

        GT_ModHandler.addCompressionRecipe(new ItemStack(Blocks.red_flower, 8, 32767), ItemList.IC2_PlantballCompressed.get(1L));
        GT_ModHandler.addCompressionRecipe(new ItemStack(Blocks.yellow_flower, 8, 32767), ItemList.IC2_PlantballCompressed.get(1L));

        GT_ModHandler.addPulverisationRecipe(ItemList.Dye_Cocoa.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cocoa, 1L));
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.reeds, 1), new ItemStack(Items.sugar, 1), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.melon_block, 1, 0), new ItemStack(Items.melon, 8, 0), new ItemStack(Items.melon_seeds, 1), 80, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.pumpkin, 1, 0), new ItemStack(Items.pumpkin_seeds, 4, 0), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.melon, 1, 0), new ItemStack(Items.melon_seeds, 1, 0), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.wheat, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(GT_ModHandler.getIC2Item("crop", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.wool, 1, 32767), new ItemStack(Items.string, 2), new ItemStack(Items.string, 1), 50, false);
        try {
            Object tCrop;
            GT_Utility.getField(tCrop = ic2.api.crops.Crops.instance.getCropList()[13], "mDrop").set(tCrop, ItemList.Crop_Drop_Ferru.get(1L));
            GT_Utility.getField(tCrop = ic2.api.crops.Crops.instance.getCropList()[14], "mDrop").set(tCrop, ItemList.Crop_Drop_Aurelia.get(1L));
        } catch (Throwable e) {
            if (GT_Values.D1) {
                e.printStackTrace(GT_Log.err);
            }
        }
        ItemList.Display_ITS_FREE.set(addItem(tLastID = 766, "ITS FREE", "(or at least almost free)", SubTag.INVISIBLE));
    }

    public boolean onLeftClickEntity(ItemStack aStack, EntityPlayer aPlayer, Entity aEntity) {
        super.onLeftClickEntity(aStack, aPlayer, aEntity);
        return false;
    }

    public boolean hasProjectile(SubTag aProjectileType, ItemStack aStack) {
        int aDamage = aStack.getItemDamage();
        return ((aDamage >= 25000) && (aDamage < 27000)) || (super.hasProjectile(aProjectileType, aStack));
    }

    public EntityArrow getProjectile(SubTag aProjectileType, ItemStack aStack, World aWorld, double aX, double aY, double aZ) {
        return super.getProjectile(aProjectileType, aStack, aWorld, aX, aY, aZ);
    }

    public EntityArrow getProjectile(SubTag aProjectileType, ItemStack aStack, World aWorld, EntityLivingBase aEntity, float aSpeed) {
        return super.getProjectile(aProjectileType, aStack, aWorld, aEntity, aSpeed);
    }

    public boolean isItemStackUsable(ItemStack aStack) {
        int aDamage = aStack.getItemDamage();
        Materials aMaterial = GregTech_API.sGeneratedMaterials[(aDamage % 1000)];
        if ((aDamage >= 25000) && (aDamage < 27000) && (aMaterial != null) && (aMaterial.mEnchantmentTools != null)) {
            Enchantment tEnchant = aMaterial.mEnchantmentTools == Enchantment.fortune ? Enchantment.looting : aMaterial.mEnchantmentTools;
            if (tEnchant.type == EnumEnchantmentType.weapon) {
                NBTTagCompound tNBT = GT_Utility.ItemNBT.getNBT(aStack);
                if (!tNBT.getBoolean("GT.HasBeenUpdated")) {
                    tNBT.setBoolean("GT.HasBeenUpdated", true);
                    GT_Utility.ItemNBT.setNBT(aStack, tNBT);
                    GT_Utility.ItemNBT.addEnchantment(aStack, tEnchant, aMaterial.mEnchantmentToolsLevel);
                }
            }
        }
        return super.isItemStackUsable(aStack);
    }

    public boolean doesShowInCreative(OrePrefixes aPrefix, Materials aMaterial, boolean aDoShowAllItems) {
        return (aDoShowAllItems);
    }

    public ItemStack onDispense(IBlockSource aSource, ItemStack aStack) {
        return super.onDispense(aSource, aStack);
    }

    public final ItemStack getContainerItem(ItemStack aStack) {
        int aDamage = aStack.getItemDamage();
        if (aDamage < 32000) {
            return null;
        }
        return null;
    }
}
