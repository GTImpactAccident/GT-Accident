package gregtech.loaders.preload;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.interfaces.ITexture;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class GT_Loader_MetaTileEntities implements Runnable {
    private static final String aTextWire1 = "wire.";
    private static final String aTextCable1 = "cable.";
    private static final String aTextWire2 = " Wire";
    private static final String aTextCable2 = " Cable";
    private final static String aTextPlate = "PPP";
    private final static String aTextPlateWrench = "PwP";
    private final static String aTextPlateMotor = "PMP";
    private final static String aTextCableHull = "CMC";
    private final static String aTextWireHull = "WMW";
    private final static String aTextWireChest = "WTW";
    private final static String aTextWireCoil = "WCW";
    private final static String aTextMotorWire = "EWE";
    private final static String aTextWirePump = "WPW";
    private final static boolean aBoolConst_0 = false;
    private final static Boolean isNEILoaded = Loader.isModLoaded("NotEnoughItems");

    private static void run1() {
        long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
        long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_ULV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.WroughtIron)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_LV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_MV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_HV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_EV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_IV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_LuV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Chrome)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_ZPM.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Iridium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_UV.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Osmium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_MAX.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Neutronium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_BronzePlatedBricks.get(2L), bits, new Object[]{"PhP", "PBP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Bronze), 'B', new ItemStack(Blocks.brick_block, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_SolidSteel.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_StableTitanium.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Titanium), 'F', OrePrefixes.frameGt.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_HeatProof.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Invar), 'F', OrePrefixes.frameGt.get(Materials.Invar)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_FrostProof.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Aluminium), 'F', OrePrefixes.frameGt.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_CleanStainlessSteel.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'F', OrePrefixes.frameGt.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_RobustTungstenSteel.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'F', OrePrefixes.frameGt.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_RobustHSSG.get(2L), bits, new Object[]{"PhP", "EFE", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.HSSG), 'E', OrePrefixes.plate.get(Materials.Europium), 'F', ItemList.Casing_RobustTungstenSteel});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_MiningOsmiridium.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Osmiridium), 'F', OrePrefixes.frameGt.get(Materials.Osmiridium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Turbine.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Magnalium), 'F', OrePrefixes.frameGt.get(Materials.BlueSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Turbine1.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'F', ItemList.Casing_Turbine});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Turbine2.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Titanium), 'F', ItemList.Casing_Turbine});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Turbine3.get(2L), bits, new Object[]{"PhP", "PFP", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'F', ItemList.Casing_Turbine});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Pipe_Bronze.get(2L), bits, new Object[]{"PIP", "IFI", "PIP", 'P', OrePrefixes.plate.get(Materials.Bronze), 'F', OrePrefixes.frameGt.get(Materials.Bronze), 'I', OrePrefixes.pipeMedium.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Pipe_Steel.get(2L), bits, new Object[]{"PIP", "IFI", "PIP", 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'I', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Pipe_Titanium.get(2L), bits, new Object[]{"PIP", "IFI", "PIP", 'P', OrePrefixes.plate.get(Materials.Titanium), 'F', OrePrefixes.frameGt.get(Materials.Titanium), 'I', OrePrefixes.pipeMedium.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Pipe_TungstenSteel.get(2L), bits, new Object[]{"PIP", "IFI", "PIP", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'F', OrePrefixes.frameGt.get(Materials.TungstenSteel), 'I', OrePrefixes.pipeMedium.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Pipe_Polytetrafluoroethylene.get(2L), bits, new Object[]{"PIP", "IFI", "PIP", 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene), 'F', OrePrefixes.frameGt.get(Materials.Polytetrafluoroethylene), 'I', OrePrefixes.pipeMedium.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Gearbox_Bronze.get(2L), bits, new Object[]{"PhP", "GFG", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Bronze), 'F', OrePrefixes.frameGt.get(Materials.Bronze), 'G', OrePrefixes.gearGt.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Gearbox_Steel.get(2L), bits, new Object[]{"PhP", "GFG", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'G', OrePrefixes.gearGt.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Gearbox_Titanium.get(2L), bits, new Object[]{"PhP", "GFG", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.Titanium), 'G', OrePrefixes.gearGt.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Gearbox_TungstenSteel.get(2L), bits, new Object[]{"PhP", "GFG", aTextPlateWrench, 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.TungstenSteel), 'G', ItemList.Robot_Arm_IV});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Grate.get(2L), bits, new Object[]{"PVP", "PFP", aTextPlateMotor, 'P', new ItemStack(Blocks.iron_bars, 1), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'M', ItemList.Electric_Motor_MV, 'V', OrePrefixes.rotor.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Vent.get(2L), bits, new Object[]{"PPP", "SSS", "MFV", 'P', new ItemStack(Blocks.iron_bars, 1), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'M', ItemList.Electric_Motor_MV, 'V', OrePrefixes.rotor.get(Materials.Steel), 'S', ItemList.Component_Filter});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Assembler.get(2L), bits, new Object[]{"PVP", "PFP", aTextPlateMotor, 'P', OrePrefixes.circuit.get(Materials.Data), 'F', OrePrefixes.frameGt.get(Materials.TungstenSteel), 'M', ItemList.Electric_Motor_IV, 'V', OrePrefixes.circuit.get(Materials.Elite)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebox_Bronze.get(2L), bits, new Object[]{"PSP", "SFS", "PSP", 'P', OrePrefixes.plate.get(Materials.Bronze), 'F', OrePrefixes.frameGt.get(Materials.Bronze), 'S', OrePrefixes.stick.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebox_Steel.get(2L), bits, new Object[]{"PSP", "SFS", "PSP", 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebox_Titanium.get(2L), bits, new Object[]{"PSP", "SFS", "PSP", 'P', OrePrefixes.plate.get(Materials.Titanium), 'F', OrePrefixes.frameGt.get(Materials.Titanium), 'S', OrePrefixes.stick.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebox_TungstenSteel.get(2L), bits, new Object[]{"PSP", "SFS", "PSP", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'F', OrePrefixes.frameGt.get(Materials.TungstenSteel), 'S', OrePrefixes.stick.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_Cupronickel.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.Cupronickel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_Kanthal.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.Kanthal)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_Nichrome.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.Nichrome)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_TungstenSteel.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_HSSG.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_Naquadah.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.Naquadah)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_NaquadahAlloy.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.NaquadahAlloy)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Coil_Superconductor.get(1L), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.wireGt02.get(Materials.Superconductor)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Stripes_A.get(1L), bits, new Object[]{"Y  ", " M ", "  B", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Stripes_B.get(1L), bits, new Object[]{"  Y", " M ", "B  ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_RadioactiveHazard.get(1L), bits, new Object[]{" YB", " M ", "   ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_BioHazard.get(1L), bits, new Object[]{" Y ", " MB", "   ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_ExplosionHazard.get(1L), bits, new Object[]{" Y ", " M ", "  B", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_FireHazard.get(1L), bits, new Object[]{" Y ", " M ", " B ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_AcidHazard.get(1L), bits, new Object[]{" Y ", " M ", "B  ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_MagicHazard.get(1L), bits, new Object[]{" Y ", "BM ", "   ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_FrostHazard.get(1L), bits, new Object[]{"BY ", " M ", "   ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_NoiseHazard.get(1L), bits, new Object[]{"   ", " M ", "BY ", 'M', ItemList.Casing_SolidSteel, 'Y', Dyes.dyeYellow, 'B', Dyes.dyeBlack});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_Stripes_A});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_Stripes_B});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_RadioactiveHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_BioHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_ExplosionHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_FireHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_AcidHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_MagicHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_FrostHazard});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_SolidSteel.get(1L), bits, new Object[]{ItemList.Casing_NoiseHazard});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_Coil_Cupronickel.get(1L), bits, new Object[]{ItemList.Casing_Coil_Cupronickel_Deprecated});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_Coil_Kanthal.get(1L), bits, new Object[]{ItemList.Casing_Coil_Kanthal_Deprecated});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Casing_Coil_Nichrome.get(1L), bits, new Object[]{ItemList.Casing_Coil_Nichrome_Deprecated});

        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebricks.get(1L), bits, new Object[]{"BB", "BB", 'B', ItemList.Firebrick.get(1)});

        ItemList.Hull_ULV.set(new GT_MetaTileEntity_BasicHull(10, "hull.tier.00", "ULV Machine Hull", 0, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_LV.set(new GT_MetaTileEntity_BasicHull(11, "hull.tier.01", "LV Machine Hull", 1, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_MV.set(new GT_MetaTileEntity_BasicHull(12, "hull.tier.02", "MV Machine Hull", 2, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_HV.set(new GT_MetaTileEntity_BasicHull(13, "hull.tier.03", "HV Machine Hull", 3, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_EV.set(new GT_MetaTileEntity_BasicHull(14, "hull.tier.04", "EV Machine Hull", 4, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_IV.set(new GT_MetaTileEntity_BasicHull(15, "hull.tier.05", "IV Machine Hull", 5, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_LuV.set(new GT_MetaTileEntity_BasicHull(16, "hull.tier.06", "LuV Machine Hull", 6, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_ZPM.set(new GT_MetaTileEntity_BasicHull(17, "hull.tier.07", "ZPM Machine Hull", 7, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_UV.set(new GT_MetaTileEntity_BasicHull(18, "hull.tier.08", "UV Machine Hull", 8, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));
        ItemList.Hull_MAX.set(new GT_MetaTileEntity_BasicHull(19, "hull.tier.09", "Max Machine Hull", 9, EnumChatFormatting.RESET + "You just need " + EnumChatFormatting.DARK_PURPLE + "I" + EnumChatFormatting.LIGHT_PURPLE + "m" + EnumChatFormatting.DARK_RED + "a" + EnumChatFormatting.RED + "g" + EnumChatFormatting.YELLOW + "i" + EnumChatFormatting.GREEN + "n" + EnumChatFormatting.AQUA + "a" + EnumChatFormatting.DARK_AQUA + "t" + EnumChatFormatting.BLUE + "i" + EnumChatFormatting.DARK_BLUE + "o" + EnumChatFormatting.DARK_PURPLE + "n" + EnumChatFormatting.RESET + " to use this.").getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hull_ULV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_ULV, 'C', OrePrefixes.cableGt01.get(Materials.Lead), 'H', OrePrefixes.plate.get(Materials.WroughtIron), 'P', OrePrefixes.plate.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_LV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'H', OrePrefixes.plate.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.WroughtIron)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_MV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'H', OrePrefixes.plate.get(Materials.Aluminium), 'P', OrePrefixes.plate.get(Materials.WroughtIron)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_HV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'H', OrePrefixes.plate.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_EV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'H', OrePrefixes.plate.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'H', OrePrefixes.plate.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'H', OrePrefixes.plate.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah), 'H', OrePrefixes.plate.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy), 'H', OrePrefixes.plate.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_MAX.get(1L), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_MAX, 'C', OrePrefixes.wireGt01.get(Materials.Superconductor), 'H', OrePrefixes.plate.get(Materials.Neutronium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});

        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_ULV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_LV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_MV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_HV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_EV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_IV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_LuV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_ZPM.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_UV.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_MAX.get(1L));

        if (GT_Mod.gregtechproxy.mHardMachineCasings) {
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ULV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_ULV, 'C', OrePrefixes.cableGt01.get(Materials.Lead), 'H', OrePrefixes.plate.get(Materials.WroughtIron), 'P', OrePrefixes.plate.get(Materials.Wood)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'H', OrePrefixes.plate.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.WroughtIron)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_MV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'H', OrePrefixes.plate.get(Materials.Aluminium), 'P', OrePrefixes.plate.get(Materials.WroughtIron)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_HV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'H', OrePrefixes.plate.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.Plastic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_EV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'H', OrePrefixes.plate.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Plastic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'H', OrePrefixes.plate.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.Plastic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'H', OrePrefixes.plate.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.Plastic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah), 'H', OrePrefixes.plate.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy), 'H', OrePrefixes.plate.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_MAX.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_MAX, 'C', OrePrefixes.wireGt01.get(Materials.Superconductor), 'H', OrePrefixes.plate.get(Materials.Neutronium), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
        } else {
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ULV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_ULV, 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_MV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_HV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_EV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_MAX.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_MAX, 'C', OrePrefixes.wireGt01.get(Materials.Superconductor)});

        }

        ItemList.Hatch_Dynamo_ULV.set(new GT_MetaTileEntity_Hatch_Dynamo(30, "hatch.dynamo.tier.00", "ULV Dynamo Hatch", 0).getStackForm(1L));
        ItemList.Hatch_Dynamo_LV.set(new GT_MetaTileEntity_Hatch_Dynamo(31, "hatch.dynamo.tier.01", "LV Dynamo Hatch", 1).getStackForm(1L));
        ItemList.Hatch_Dynamo_MV.set(new GT_MetaTileEntity_Hatch_Dynamo(32, "hatch.dynamo.tier.02", "MV Dynamo Hatch", 2).getStackForm(1L));
        ItemList.Hatch_Dynamo_HV.set(new GT_MetaTileEntity_Hatch_Dynamo(33, "hatch.dynamo.tier.03", "HV Dynamo Hatch", 3).getStackForm(1L));
        ItemList.Hatch_Dynamo_EV.set(new GT_MetaTileEntity_Hatch_Dynamo(34, "hatch.dynamo.tier.04", "EV Dynamo Hatch", 4).getStackForm(1L));
        ItemList.Hatch_Dynamo_IV.set(new GT_MetaTileEntity_Hatch_Dynamo(35, "hatch.dynamo.tier.05", "IV Dynamo Hatch", 5).getStackForm(1L));
        ItemList.Hatch_Dynamo_LuV.set(new GT_MetaTileEntity_Hatch_Dynamo(36, "hatch.dynamo.tier.06", "LuV Dynamo Hatch", 6).getStackForm(1L));
        ItemList.Hatch_Dynamo_ZPM.set(new GT_MetaTileEntity_Hatch_Dynamo(37, "hatch.dynamo.tier.07", "ZPM Dynamo Hatch", 7).getStackForm(1L));
        ItemList.Hatch_Dynamo_UV.set(new GT_MetaTileEntity_Hatch_Dynamo(38, "hatch.dynamo.tier.08", "UV Dynamo Hatch", 8).getStackForm(1L));
        ItemList.Hatch_Dynamo_MAX.set(new GT_MetaTileEntity_Hatch_Dynamo(39, "hatch.dynamo.tier.09", "Max Dynamo Hatch", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_ULV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_ULV, 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_LV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_MV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_HV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_EV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_IV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_LuV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_ZPM.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_UV.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_UV, 'C', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Dynamo_MAX.get(1L), bitsd, new Object[]{" MC", 'M', ItemList.Hull_MAX, 'C', OrePrefixes.wireGt01.get(Materials.Superconductor)});

        ItemList.Hatch_Energy_ULV.set(new GT_MetaTileEntity_Hatch_Energy(40, "hatch.energy.tier.00", "ULV Energy Hatch", 0).getStackForm(1L));
        ItemList.Hatch_Energy_LV.set(new GT_MetaTileEntity_Hatch_Energy(41, "hatch.energy.tier.01", "LV Energy Hatch", 1).getStackForm(1L));
        ItemList.Hatch_Energy_MV.set(new GT_MetaTileEntity_Hatch_Energy(42, "hatch.energy.tier.02", "MV Energy Hatch", 2).getStackForm(1L));
        ItemList.Hatch_Energy_HV.set(new GT_MetaTileEntity_Hatch_Energy(43, "hatch.energy.tier.03", "HV Energy Hatch", 3).getStackForm(1L));
        ItemList.Hatch_Energy_EV.set(new GT_MetaTileEntity_Hatch_Energy(44, "hatch.energy.tier.04", "EV Energy Hatch", 4).getStackForm(1L));
        ItemList.Hatch_Energy_IV.set(new GT_MetaTileEntity_Hatch_Energy(45, "hatch.energy.tier.05", "IV Energy Hatch", 5).getStackForm(1L));
        ItemList.Hatch_Energy_LuV.set(new GT_MetaTileEntity_Hatch_Energy(46, "hatch.energy.tier.06", "LuV Energy Hatch", 6).getStackForm(1L));
        ItemList.Hatch_Energy_ZPM.set(new GT_MetaTileEntity_Hatch_Energy(47, "hatch.energy.tier.07", "ZPM Energy Hatch", 7).getStackForm(1L));
        ItemList.Hatch_Energy_UV.set(new GT_MetaTileEntity_Hatch_Energy(48, "hatch.energy.tier.08", "UV Energy Hatch", 8).getStackForm(1L));
        ItemList.Hatch_Energy_MAX.set(new GT_MetaTileEntity_Hatch_Energy(49, "hatch.energy.tier.09", "Max Energy Hatch", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_ULV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_ULV, 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_LV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_MV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_HV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_EV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_IV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_LuV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_ZPM.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_UV.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_UV, 'C', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Energy_MAX.get(1L), bitsd, new Object[]{"CM ", 'M', ItemList.Hull_MAX, 'C', OrePrefixes.wireGt01.get(Materials.Superconductor)});

        ItemList.Hatch_Input_ULV.set(new GT_MetaTileEntity_Hatch_Input(50, "hatch.input.tier.00", "Input Hatch (ULV)", 0).getStackForm(1L));
        ItemList.Hatch_Input_LV.set(new GT_MetaTileEntity_Hatch_Input(51, "hatch.input.tier.01", "Input Hatch (LV)", 1).getStackForm(1L));
        ItemList.Hatch_Input_MV.set(new GT_MetaTileEntity_Hatch_Input(52, "hatch.input.tier.02", "Input Hatch (MV)", 2).getStackForm(1L));
        ItemList.Hatch_Input_HV.set(new GT_MetaTileEntity_Hatch_Input(53, "hatch.input.tier.03", "Input Hatch (HV)", 3).getStackForm(1L));
        ItemList.Hatch_Input_EV.set(new GT_MetaTileEntity_Hatch_Input(54, "hatch.input.tier.04", "Input Hatch (EV)", 4).getStackForm(1L));
        ItemList.Hatch_Input_IV.set(new GT_MetaTileEntity_Hatch_Input(55, "hatch.input.tier.05", "Input Hatch (IV)", 5).getStackForm(1L));
        ItemList.Hatch_Input_LuV.set(new GT_MetaTileEntity_Hatch_Input(56, "hatch.input.tier.06", "Input Hatch (LuV)", 6).getStackForm(1L));
        ItemList.Hatch_Input_ZPM.set(new GT_MetaTileEntity_Hatch_Input(57, "hatch.input.tier.07", "Input Hatch (ZPM)", 7).getStackForm(1L));
        ItemList.Hatch_Input_UV.set(new GT_MetaTileEntity_Hatch_Input(58, "hatch.input.tier.08", "Input Hatch (UV)", 8).getStackForm(1L));
        ItemList.Hatch_Input_MAX.set(new GT_MetaTileEntity_Hatch_Input(59, "hatch.input.tier.09", "Input Hatch (MAX)", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_ULV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_ULV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_LV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_LV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_MV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_MV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_HV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_HV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_EV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_EV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_IV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_IV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_LuV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_LuV, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_ZPM.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_ZPM, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_UV.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_UV, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_MAX.get(1L), bitsd, new Object[]{"G", "M", 'M', ItemList.Hull_MAX, 'G', Ic2Items.reinforcedGlass});

        ItemList.Hatch_Output_ULV.set(new GT_MetaTileEntity_Hatch_Output(60, "hatch.output.tier.00", "Output Hatch (ULV)", 0).getStackForm(1L));
        ItemList.Hatch_Output_LV.set(new GT_MetaTileEntity_Hatch_Output(61, "hatch.output.tier.01", "Output Hatch (LV)", 1).getStackForm(1L));
        ItemList.Hatch_Output_MV.set(new GT_MetaTileEntity_Hatch_Output(62, "hatch.output.tier.02", "Output Hatch (MV)", 2).getStackForm(1L));
        ItemList.Hatch_Output_HV.set(new GT_MetaTileEntity_Hatch_Output(63, "hatch.output.tier.03", "Output Hatch (HV)", 3).getStackForm(1L));
        ItemList.Hatch_Output_EV.set(new GT_MetaTileEntity_Hatch_Output(64, "hatch.output.tier.04", "Output Hatch (EV)", 4).getStackForm(1L));
        ItemList.Hatch_Output_IV.set(new GT_MetaTileEntity_Hatch_Output(65, "hatch.output.tier.05", "Output Hatch (IV)", 5).getStackForm(1L));
        ItemList.Hatch_Output_LuV.set(new GT_MetaTileEntity_Hatch_Output(66, "hatch.output.tier.06", "Output Hatch (LuV)", 6).getStackForm(1L));
        ItemList.Hatch_Output_ZPM.set(new GT_MetaTileEntity_Hatch_Output(67, "hatch.output.tier.07", "Output Hatch (ZPM)", 7).getStackForm(1L));
        ItemList.Hatch_Output_UV.set(new GT_MetaTileEntity_Hatch_Output(68, "hatch.output.tier.08", "Output Hatch (UV)", 8).getStackForm(1L));
        ItemList.Hatch_Output_MAX.set(new GT_MetaTileEntity_Hatch_Output(69, "hatch.output.tier.09", "Output Hatch (MAX)", 9).getStackForm(1L));
        ItemList.Hatch_Output_Creative.set(new GT_MetaTileEntity_Hatch_Output_Creative(137, "hatch.output.tier.100", "Output Hatch (Creative)", 100).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_ULV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_ULV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_LV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_LV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_MV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_MV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_HV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_HV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_EV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_EV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_IV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_IV, 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_LuV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_LuV, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_ZPM.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_ZPM, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_UV.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_UV, 'G', Ic2Items.reinforcedGlass});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_MAX.get(1L), bitsd, new Object[]{"M", "G", 'M', ItemList.Hull_MAX, 'G', Ic2Items.reinforcedGlass});

        ItemList.Hatch_Input_Bus_ULV.set(new GT_MetaTileEntity_Hatch_InputBus(70, "hatch.input_bus.tier.00", "Input Bus (ULV)", 0).getStackForm(1L));
        ItemList.Hatch_Input_Bus_LV.set(new GT_MetaTileEntity_Hatch_InputBus(71, "hatch.input_bus.tier.01", "Input Bus (LV)", 1).getStackForm(1L));
        ItemList.Hatch_Input_Bus_MV.set(new GT_MetaTileEntity_Hatch_InputBus(72, "hatch.input_bus.tier.02", "Input Bus (MV)", 2).getStackForm(1L));
        ItemList.Hatch_Input_Bus_HV.set(new GT_MetaTileEntity_Hatch_InputBus(73, "hatch.input_bus.tier.03", "Input Bus (HV)", 3).getStackForm(1L));
        ItemList.Hatch_Input_Bus_EV.set(new GT_MetaTileEntity_Hatch_InputBus(74, "hatch.input_bus.tier.04", "Input Bus (EV)", 4).getStackForm(1L));
        ItemList.Hatch_Input_Bus_IV.set(new GT_MetaTileEntity_Hatch_InputBus(75, "hatch.input_bus.tier.05", "Input Bus (IV)", 5).getStackForm(1L));
        ItemList.Hatch_Input_Bus_LuV.set(new GT_MetaTileEntity_Hatch_InputBus(76, "hatch.input_bus.tier.06", "Input Bus (LuV)", 6).getStackForm(1L));
        ItemList.Hatch_Input_Bus_ZPM.set(new GT_MetaTileEntity_Hatch_InputBus(77, "hatch.input_bus.tier.07", "Input Bus (ZPM)", 7).getStackForm(1L));
        ItemList.Hatch_Input_Bus_UV.set(new GT_MetaTileEntity_Hatch_InputBus(78, "hatch.input_bus.tier.08", "Input Bus (UV)", 8).getStackForm(1L));
        ItemList.Hatch_Input_Bus_MAX.set(new GT_MetaTileEntity_Hatch_InputBus(79, "hatch.input_bus.tier.09", "Input Bus (MAX)", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_ULV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_ULV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_LV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_LV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_MV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_MV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_HV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_HV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_EV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_EV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_IV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_IV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_LuV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_LuV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_ZPM.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_ZPM, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_UV.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_UV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Input_Bus_MAX.get(1L), bitsd, new Object[]{"C", "M", 'M', ItemList.Hull_MAX, 'C', OreDictNames.craftingChest});

        ItemList.Hatch_Output_Bus_ULV.set(new GT_MetaTileEntity_Hatch_OutputBus(80, "hatch.output_bus.tier.00", "Output Bus (ULV)", 0).getStackForm(1L));
        ItemList.Hatch_Output_Bus_LV.set(new GT_MetaTileEntity_Hatch_OutputBus(81, "hatch.output_bus.tier.01", "Output Bus (LV)", 1).getStackForm(1L));
        ItemList.Hatch_Output_Bus_MV.set(new GT_MetaTileEntity_Hatch_OutputBus(82, "hatch.output_bus.tier.02", "Output Bus (MV)", 2).getStackForm(1L));
        ItemList.Hatch_Output_Bus_HV.set(new GT_MetaTileEntity_Hatch_OutputBus(83, "hatch.output_bus.tier.03", "Output Bus (HV)", 3).getStackForm(1L));
        ItemList.Hatch_Output_Bus_EV.set(new GT_MetaTileEntity_Hatch_OutputBus(84, "hatch.output_bus.tier.04", "Output Bus (EV)", 4).getStackForm(1L));
        ItemList.Hatch_Output_Bus_IV.set(new GT_MetaTileEntity_Hatch_OutputBus(85, "hatch.output_bus.tier.05", "Output Bus (IV)", 5).getStackForm(1L));
        ItemList.Hatch_Output_Bus_LuV.set(new GT_MetaTileEntity_Hatch_OutputBus(86, "hatch.output_bus.tier.06", "Output Bus (LuV)", 6).getStackForm(1L));
        ItemList.Hatch_Output_Bus_ZPM.set(new GT_MetaTileEntity_Hatch_OutputBus(87, "hatch.output_bus.tier.07", "Output Bus (ZPM)", 7).getStackForm(1L));
        ItemList.Hatch_Output_Bus_UV.set(new GT_MetaTileEntity_Hatch_OutputBus(88, "hatch.output_bus.tier.08", "Output Bus (UV)", 8).getStackForm(1L));
        ItemList.Hatch_Output_Bus_MAX.set(new GT_MetaTileEntity_Hatch_OutputBus(89, "hatch.output_bus.tier.09", "Output Bus (MAX)", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_ULV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_ULV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_LV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_LV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_MV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_MV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_HV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_HV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_EV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_EV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_IV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_IV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_LuV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_LuV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_ZPM.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_ZPM, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_UV.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_UV, 'C', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Output_Bus_MAX.get(1L), bitsd, new Object[]{"M", "C", 'M', ItemList.Hull_MAX, 'C', OreDictNames.craftingChest});

        ItemList.Hatch_Maintenance.set(new GT_MetaTileEntity_Hatch_Maintenance(90, "hatch.maintenance", "Maintenance Hatch", 1).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Maintenance.get(1L), bitsd, new Object[]{"dwx", "hMc", "fsr", 'M', ItemList.Hull_LV});

        ItemList.Hatch_AutoMaintenance.set(new GT_MetaTileEntity_Hatch_Maintenance(111, "hatch.maintenance.auto", "Auto Maintenance Hatch", 5, true).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_AutoMaintenance.get(1L), bitsd, new Object[]{"CHC", "AMA", "CHC", 'M', ItemList.Hull_IV, 'H', ItemList.Hatch_Maintenance, 'A', ItemList.Robot_Arm_IV, 'C', OrePrefixes.circuit.get(Materials.Master)});

        ItemList.Hatch_DataAccess_EV.set(new GT_MetaTileEntity_Hatch_DataAccess(131, "hatch.dataaccess", "Data Access Hatch", 4).getStackForm(1L));
        ItemList.Hatch_DataAccess_LuV.set(new GT_MetaTileEntity_Hatch_DataAccess(132, "hatch.dataaccess.adv", "Advanced Data Access Hatch", 6).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_DataAccess_EV.get(1L), bitsd, new Object[]{"COC", "OMO", "COC", 'M', ItemList.Hull_EV, 'O', ItemList.Tool_DataStick, 'C', OrePrefixes.circuit.get(Materials.Elite)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_DataAccess_LuV.get(1L), bitsd, new Object[]{"COC", "OMO", "COC", 'M', ItemList.Hull_LuV, 'O', ItemList.Tool_DataOrb, 'C', OrePrefixes.circuit.get(Materials.Ultimate)});

        ItemList.Hatch_Muffler_LV.set(new GT_MetaTileEntity_Hatch_Muffler(91, "hatch.muffler.tier.01", "Muffler Hatch (LV)", 1).getStackForm(1L));
        ItemList.Hatch_Muffler_MV.set(new GT_MetaTileEntity_Hatch_Muffler(92, "hatch.muffler.tier.02", "Muffler Hatch (MV)", 2).getStackForm(1L));
        ItemList.Hatch_Muffler_HV.set(new GT_MetaTileEntity_Hatch_Muffler(93, "hatch.muffler.tier.03", "Muffler Hatch (HV)", 3).getStackForm(1L));
        ItemList.Hatch_Muffler_EV.set(new GT_MetaTileEntity_Hatch_Muffler(94, "hatch.muffler.tier.04", "Muffler Hatch (EV)", 4).getStackForm(1L));
        ItemList.Hatch_Muffler_IV.set(new GT_MetaTileEntity_Hatch_Muffler(95, "hatch.muffler.tier.05", "Muffler Hatch (IV)", 5).getStackForm(1L));
        ItemList.Hatch_Muffler_LuV.set(new GT_MetaTileEntity_Hatch_Muffler(96, "hatch.muffler.tier.06", "Muffler Hatch (LuV)", 6).getStackForm(1L));
        ItemList.Hatch_Muffler_ZPM.set(new GT_MetaTileEntity_Hatch_Muffler(97, "hatch.muffler.tier.07", "Muffler Hatch (ZPM)", 7).getStackForm(1L));
        ItemList.Hatch_Muffler_UV.set(new GT_MetaTileEntity_Hatch_Muffler(98, "hatch.muffler.tier.08", "Muffler Hatch (UV)", 8).getStackForm(1L));
        ItemList.Hatch_Muffler_MAX.set(new GT_MetaTileEntity_Hatch_Muffler(99, "hatch.muffler.tier.09", "Muffler Hatch (MAX)", 9).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_LV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_LV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_MV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_MV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_HV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_HV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_EV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_EV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_IV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_IV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_LuV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_LuV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_ZPM.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_ZPM, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_UV.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_UV, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hatch_Muffler_MAX.get(1L), bitsd, new Object[]{"M", "P", 'M', ItemList.Hull_MAX, 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
    }

    private static void run4() {
        long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
        long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;
        for (int i = 0; i < GregTech_API.sGeneratedMaterials.length; i++) {
            if (((GregTech_API.sGeneratedMaterials[i] != null) && ((GregTech_API.sGeneratedMaterials[i].mTypes & 0x2) != 0)) || (GregTech_API.sGeneratedMaterials[i] == Materials.Wood)) {
                new GT_MetaPipeEntity_Frame(4096 + i, "GT_Frame_" + GregTech_API.sGeneratedMaterials[i], (GT_LanguageManager.i18nPlaceholder ? "%material" : GregTech_API.sGeneratedMaterials[i].mDefaultLocalName) + " Frame Box", GregTech_API.sGeneratedMaterials[i]);
            }
        }
        boolean bEC = !GT_Mod.gregtechproxy.mHardcoreCables;

        makeWires(Materials.RedAlloy, 2000, 0L, 1L, 1L, gregtech.api.enums.GT_Values.V[0], true, aBoolConst_0);

        makeWires(Materials.Cobalt, 1200, bEC ? 2L : 2L, bEC ? 4L : 4L, 2L, gregtech.api.enums.GT_Values.V[1], true, aBoolConst_0);
        makeWires(Materials.Lead, 1220, bEC ? 2L : 2L, bEC ? 4L : 4L, 2L, gregtech.api.enums.GT_Values.V[1], true, aBoolConst_0);
        makeWires(Materials.Tin, 1240, bEC ? 1L : 1L, bEC ? 2L : 2L, 1L, gregtech.api.enums.GT_Values.V[1], true, aBoolConst_0);
        makeWires(Materials.Zinc, 1260, bEC ? 1L : 1L, bEC ? 2L : 2L, 1L, gregtech.api.enums.GT_Values.V[1], true, aBoolConst_0);
        makeWires(Materials.SolderingAlloy, 1280, bEC ? 1L : 1L, bEC ? 2L : 2L, 1L, gregtech.api.enums.GT_Values.V[1], true, aBoolConst_0);

        makeWires(Materials.Iron, 1300, bEC ? 3L : 4L, bEC ? 6L : 8L, 2L, gregtech.api.enums.GT_Values.V[2], true, aBoolConst_0);
        makeWires(Materials.Nickel, 1320, bEC ? 3L : 5L, bEC ? 6L : 10L, 3L, gregtech.api.enums.GT_Values.V[2], true, aBoolConst_0);
        makeWires(Materials.Cupronickel, 1340, bEC ? 3L : 4L, bEC ? 6L : 8L, 2L, gregtech.api.enums.GT_Values.V[2], true, aBoolConst_0);
        makeWires(Materials.Copper, 1360, bEC ? 2L : 3L, bEC ? 4L : 6L, 1L, gregtech.api.enums.GT_Values.V[2], true, aBoolConst_0);
        makeWires(Materials.AnnealedCopper, 1380, bEC ? 1L : 2L, bEC ? 2L : 4L, 1L, gregtech.api.enums.GT_Values.V[2], true, aBoolConst_0);

        makeWires(Materials.Kanthal, 1400, bEC ? 3L : 8L, bEC ? 6L : 16L, 4L, gregtech.api.enums.GT_Values.V[3], true, aBoolConst_0);
        makeWires(Materials.Gold, 1420, bEC ? 2L : 6L, bEC ? 4L : 12L, 3L, gregtech.api.enums.GT_Values.V[3], true, aBoolConst_0);
        makeWires(Materials.Electrum, 1440, bEC ? 2L : 5L, bEC ? 4L : 10L, 2L, gregtech.api.enums.GT_Values.V[3], true, aBoolConst_0);
        makeWires(Materials.Silver, 1460, bEC ? 1L : 4L, bEC ? 2L : 8L, 1L, gregtech.api.enums.GT_Values.V[3], true, aBoolConst_0);
        makeWires(Materials.BlueAlloy, 1480, bEC ? 1L : 4L, bEC ? 2L : 8L, 2L, gregtech.api.enums.GT_Values.V[3], true, aBoolConst_0);

        makeWires(Materials.Nichrome, 1500, bEC ? 4L : 32L, bEC ? 8L : 64L, 3L, gregtech.api.enums.GT_Values.V[4], true, aBoolConst_0);
        makeWires(Materials.Steel, 1520, bEC ? 2L : 16L, bEC ? 4L : 32L, 2L, gregtech.api.enums.GT_Values.V[4], true, aBoolConst_0);
        makeWires(Materials.BlackSteel, 1540, bEC ? 2L : 14L, bEC ? 4L : 28L, 3L, gregtech.api.enums.GT_Values.V[4], true, aBoolConst_0);
        makeWires(Materials.Titanium, 1560, bEC ? 2L : 12L, bEC ? 4L : 24L, 4L, gregtech.api.enums.GT_Values.V[4], true, aBoolConst_0);
        makeWires(Materials.Aluminium, 1580, bEC ? 1L : 8L, bEC ? 2L : 16L, 1L, gregtech.api.enums.GT_Values.V[4], true, aBoolConst_0);

        makeWires(Materials.Graphene, 1600, bEC ? 1L : 16L, bEC ? 2L : 32L, 1L, gregtech.api.enums.GT_Values.V[5], aBoolConst_0, true);
        makeWires(Materials.Osmium, 1620, bEC ? 2L : 32L, bEC ? 4L : 64L, 4L, gregtech.api.enums.GT_Values.V[5], true, aBoolConst_0);
        makeWires(Materials.Platinum, 1640, bEC ? 1L : 16L, bEC ? 2L : 32L, 2L, gregtech.api.enums.GT_Values.V[5], true, aBoolConst_0);
        makeWires(Materials.TungstenSteel, 1660, bEC ? 2L : 14L, bEC ? 4L : 28L, 3L, gregtech.api.enums.GT_Values.V[5], true, aBoolConst_0);
        makeWires(Materials.Tungsten, 1680, bEC ? 2L : 12L, bEC ? 4L : 24L, 2L, gregtech.api.enums.GT_Values.V[5], true, aBoolConst_0);

        makeWires(Materials.HSSG, 1700, bEC ? 2L : 128L, bEC ? 4L : 256L, 4L, gregtech.api.enums.GT_Values.V[6], true, aBoolConst_0);
        makeWires(Materials.NiobiumTitanium, 1720, bEC ? 2L : 128L, bEC ? 4L : 256L, 4L, gregtech.api.enums.GT_Values.V[6], true, aBoolConst_0);
        makeWires(Materials.VanadiumGallium, 1740, bEC ? 2L : 128L, bEC ? 4L : 256L, 4L, gregtech.api.enums.GT_Values.V[6], true, aBoolConst_0);
        makeWires(Materials.YttriumBariumCuprate, 1760, bEC ? 4L : 256L, bEC ? 8L : 512L, 4L, gregtech.api.enums.GT_Values.V[6], true, aBoolConst_0);

        makeWires(Materials.Naquadah, 1780, bEC ? 2L : 64L, bEC ? 4L : 128L, 2L, gregtech.api.enums.GT_Values.V[7], true, aBoolConst_0);

        makeWires(Materials.NaquadahAlloy, 1800, bEC ? 4L : 64L, bEC ? 8L : 128L, 2L, gregtech.api.enums.GT_Values.V[8], true, aBoolConst_0);
        makeWires(Materials.Duranium, 1820, bEC ? 8L : 64L, bEC ? 16L : 128L, 1L, gregtech.api.enums.GT_Values.V[8], true, aBoolConst_0);

        makeWires(Materials.Superconductor, 2020, 1L, 1L, 4L, gregtech.api.enums.GT_Values.V[9], aBoolConst_0, true);
        if (!GT_Mod.gregtechproxy.mDisableIC2Cables) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("copperCableItem", 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"xP", 'P', OrePrefixes.plate.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("goldCableItem", 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"xP", 'P', OrePrefixes.plate.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ironCableItem", 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"xP", 'P', OrePrefixes.plate.get(Materials.Iron)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("tinCableItem", 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"xP", 'P', OrePrefixes.plate.get(Materials.Tin)});
        }

        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Wood), new GT_MetaPipeEntity_Fluid(5101, "GT_Pipe_Wood_Small", "Small Wooden Fluid Pipe", 0.375F, Materials.Wood, 10, 350, aBoolConst_0).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Wood), new GT_MetaPipeEntity_Fluid(5102, "GT_Pipe_Wood", "Wooden Fluid Pipe", 0.5F, Materials.Wood, 30, 350, aBoolConst_0).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Wood), new GT_MetaPipeEntity_Fluid(5103, "GT_Pipe_Wood_Large", "Large Wooden Fluid Pipe", 0.75F, Materials.Wood, 60, 350, aBoolConst_0).getStackForm(1L));

        generateFluidPipes(Materials.Copper, Materials.Copper.mName, 5110, 60, 1000, true);
        generateFluidPipes(Materials.Bronze, Materials.Bronze.mName, 5120, 120, 2000, true);
        generateFluidPipes(Materials.Steel, Materials.Steel.mName, 5130, 240, 2500, true);
        generateFluidPipes(Materials.StainlessSteel, Materials.StainlessSteel.mName, 5140, 360, 3000, true);
        generateFluidPipes(Materials.Titanium, Materials.Titanium.mName, 5150, 480, 5000, true);
        generateFluidPipes(Materials.TungstenSteel, Materials.TungstenSteel.mName, 5160, 600, 7500, true);
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Ultimate), new GT_MetaPipeEntity_Fluid(5165, "GT_Pipe_HighPressure_Small", "Small High Pressure Fluid Pipe", 0.375F, Materials.Redstone, 4800, 1500, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Ultimate), new GT_MetaPipeEntity_Fluid(5166, "GT_Pipe_HighPressure", "High Pressure Fluid Pipe", 0.5F, Materials.Redstone, 7200, 1500, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Ultimate), new GT_MetaPipeEntity_Fluid(5167, "GT_Pipe_HighPressure_Large", "Large High Pressure Fluid Pipe", 0.75F, Materials.Redstone, 9600, 1500, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Superconductor), new GT_MetaPipeEntity_Fluid(5168, "GT_Pipe_PlasmaContain", "Plasma Containment Pipe", 0.5F, Materials.Glowstone, 240, 100000, true).getStackForm(1L));
        generateFluidPipes(Materials.Plastic, Materials.Plastic.mName, "Plastic", 5170, 360, 350, true);
        generateFluidPipes(Materials.Polytetrafluoroethylene, Materials.Polytetrafluoroethylene.mName, "PTFE", 5175, 480, 600, true);
        generateFluidMultiPipes(Materials.Copper, Materials.Copper.mName, "Copper", 5200, 60, 1000, true);
        generateFluidMultiPipes(Materials.Bronze, Materials.Bronze.mName, "Bronze", 5205, 120, 2000, true);
        generateFluidMultiPipes(Materials.Steel, Materials.Steel.mName, "Steel", 5210, 240, 2500, true);
        generateFluidMultiPipes(Materials.StainlessSteel, Materials.StainlessSteel.mName, "StainlessSteel", 5215, 360, 3000, true);
        generateFluidMultiPipes(Materials.Titanium, Materials.Titanium.mName, "Titanium", 5220, 480, 5000, true);
        generateFluidMultiPipes(Materials.TungstenSteel, Materials.TungstenSteel.mName, "Tungstensteel", 5225, 600, 7500, true);
        generateFluidMultiPipes(Materials.Plastic, Materials.Plastic.mName, "Plastic", 5230, 360, 350, true);
        generateFluidMultiPipes(Materials.Polytetrafluoroethylene, Materials.Polytetrafluoroethylene.mName, "PTFE", 5235, 480, 600, true);

        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.TungstenSteel, 1L), ItemList.Electric_Pump_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Ultimate, 1L), 300, 96);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1L), ItemList.Electric_Pump_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Ultimate, 1L), 400, 148);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L), ItemList.Electric_Pump_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Ultimate, 1L), 600, 256);

        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 1L), bitsd, new Object[]{"WSW", aTextCableHull, "WSW", 'M', OrePrefixes.pipeSmall.get(Materials.Titanium), 'C', OrePrefixes.plate.get(Materials.NeodymiumMagnetic), 'W', OrePrefixes.plate.get(Materials.Plastic), 'S', OrePrefixes.wireGt02.get(Materials.Superconductor)});


        generateItemPipes(Materials.Brass, Materials.Brass.mName, 5602, 1);
        generateItemPipes(Materials.Electrum, Materials.Electrum.mName, 5612, 2);
        generateItemPipes(Materials.Platinum, Materials.Platinum.mName, 5622, 4);
        generateItemPipes(Materials.Osmium, Materials.Osmium.mName, 5632, 8);
        generateItemPipes(Materials.PolyvinylChloride, Materials.PolyvinylChloride.mName, "PVC", 5640, 4);
        generateItemPipes(Materials.WroughtIron, Materials.WroughtIron.mName, 5646, 1);
        generateItemPipes(Materials.Nickel, Materials.Nickel.mName, 5652, 1);
        generateItemPipes(Materials.Cobalt, Materials.Cobalt.mName, 5658, 2);
        generateItemPipes(Materials.Aluminium, Materials.Aluminium.mName, 5664, 2);
    }

    private static void makeWires(Materials aMaterial, int aStartID, long aLossInsulated, long aLoss, long aAmperage, long aVoltage, boolean aInsulatable, boolean aAutoInsulated) {
        String name = GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName;
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt01, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 0, aTextWire1 + aMaterial.mName.toLowerCase() + ".01", "1x " + name + aTextWire2, 0.125F, aMaterial, aLoss, 1L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt02, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 1, aTextWire1 + aMaterial.mName.toLowerCase() + ".02", "2x " + name + aTextWire2, 0.25F, aMaterial, aLoss, 2L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt04, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 2, aTextWire1 + aMaterial.mName.toLowerCase() + ".04", "4x " + name + aTextWire2, 0.375F, aMaterial, aLoss, 4L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt08, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 3, aTextWire1 + aMaterial.mName.toLowerCase() + ".08", "8x " + name + aTextWire2, 0.5F, aMaterial, aLoss, 8L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt12, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 4, aTextWire1 + aMaterial.mName.toLowerCase() + ".12", "12x " + name + aTextWire2, 0.625F, aMaterial, aLoss, 12L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.wireGt16, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 5, aTextWire1 + aMaterial.mName.toLowerCase() + ".16", "16x " + name + aTextWire2, 0.75F, aMaterial, aLoss, 16L * aAmperage, aVoltage, aBoolConst_0, !aAutoInsulated).getStackForm(1L));
        if (aInsulatable) {
            GT_OreDictUnificator.registerOre(OrePrefixes.cableGt01, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 6, aTextCable1 + aMaterial.mName.toLowerCase() + ".01", "1x " + name + aTextCable2, 0.25F, aMaterial, aLossInsulated, 1L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
            GT_OreDictUnificator.registerOre(OrePrefixes.cableGt02, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 7, aTextCable1 + aMaterial.mName.toLowerCase() + ".02", "2x " + name + aTextCable2, 0.375F, aMaterial, aLossInsulated, 2L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
            GT_OreDictUnificator.registerOre(OrePrefixes.cableGt04, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 8, aTextCable1 + aMaterial.mName.toLowerCase() + ".04", "4x " + name + aTextCable2, 0.5F, aMaterial, aLossInsulated, 4L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
            GT_OreDictUnificator.registerOre(OrePrefixes.cableGt08, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 9, aTextCable1 + aMaterial.mName.toLowerCase() + ".08", "8x " + name + aTextCable2, 0.625F, aMaterial, aLossInsulated, 8L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
            GT_OreDictUnificator.registerOre(OrePrefixes.cableGt12, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 10, aTextCable1 + aMaterial.mName.toLowerCase() + ".12", "12x " + name + aTextCable2, 0.75F, aMaterial, aLossInsulated, 12L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
            //GT_OreDictUnificator.registerOre(OrePrefixes.cableGt16, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 11, aTextCable1 + aMaterial.mName.toLowerCase() + ".16", "16x " + name + aTextCable2, 0.875F, aMaterial, aLossInsulated, 16L * aAmperage, aVoltage, true, aBoolConst_0).getStackForm(1L));
        }
    }

    public void run() {
        GT_Log.out.println("GT_Mod: Registering MetaTileEntities.");
        run1();
        run4();
    }

    private static void generateItemPipes(Materials aMaterial, String name, int startID, int baseInvSlots) {
        generateItemPipes(aMaterial, name, GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName, startID, baseInvSlots);
    }

    private static void generateItemPipes(Materials aMaterial, String name, String displayName, int startID, int baseInvSlots) {
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(aMaterial), new GT_MetaPipeEntity_Item(startID, "GT_Pipe_" + name, displayName + " Item Pipe", 0.50F, aMaterial, baseInvSlots, 32768 / baseInvSlots, aBoolConst_0).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(aMaterial), new GT_MetaPipeEntity_Item(startID + 1, "GT_Pipe_" + name + "_Large", "Large " + displayName + " Item Pipe", 0.75F, aMaterial, baseInvSlots * 2, 16384 / baseInvSlots, aBoolConst_0).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(aMaterial), new GT_MetaPipeEntity_Item(startID + 2, "GT_Pipe_" + name + "_Huge", "Huge " + displayName + " Item Pipe", 0.875F, aMaterial, baseInvSlots * 4, 8192 / baseInvSlots, aBoolConst_0).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(aMaterial), new GT_MetaPipeEntity_Item(startID + 3, "GT_Pipe_Restrictive_" + name, "Restrictive " + displayName + " Item Pipe", 0.50F, aMaterial, baseInvSlots, 3276800 / baseInvSlots, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(aMaterial), new GT_MetaPipeEntity_Item(startID + 4, "GT_Pipe_Restrictive_" + name + "_Large", "Large Restrictive " + displayName + " Item Pipe", 0.75F, aMaterial, baseInvSlots * 2, 1638400 / baseInvSlots, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(aMaterial), new GT_MetaPipeEntity_Item(startID + 5, "GT_Pipe_Restrictive_" + name + "_Huge", "Huge Restrictive " + displayName + " Item Pipe", 0.875F, aMaterial, baseInvSlots * 4, 819200 / baseInvSlots, true).getStackForm(1L));

    }

    private static void generateFluidPipes(Materials aMaterial, String name, int startID, int baseCapacity, int heatCapacity, boolean gasProof) {
        generateFluidPipes(aMaterial, name, GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName, startID, baseCapacity, heatCapacity, gasProof);
    }

    private static void generateFluidPipes(Materials aMaterial, String name, String displayName, int startID, int baseCapacity, int heatCapacity, boolean gasProof) {
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID, "GT_Pipe_" + name + "_Tiny", "Tiny " + displayName + " Fluid Pipe", 0.25F, aMaterial, baseCapacity / 6, heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 1, "GT_Pipe_" + name + "_Small", "Small " + displayName + " Fluid Pipe", 0.375F, aMaterial, baseCapacity / 3, heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 2, "GT_Pipe_" + name, displayName + " Fluid Pipe", 0.5F, aMaterial, baseCapacity, heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 3, "GT_Pipe_" + name + "_Large", "Large " + displayName + " Fluid Pipe", 0.75F, aMaterial, baseCapacity * 2, heatCapacity, gasProof).getStackForm(1L));
        if (aMaterial != Materials.WroughtIron) {
            GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 4, "GT_Pipe_" + name + "_Huge", "Huge " + displayName + " Fluid Pipe", 0.875F, aMaterial, baseCapacity * 4, heatCapacity, gasProof).getStackForm(1L));
        }
    }

    private static void generateFluidMultiPipes(Materials aMaterial, String name, String displayName, int startID, int baseCapacity, int heatCapacity, boolean gasProof) {
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeQuadruple.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID, "GT_Pipe_" + name + "_Quadruple", "Quadruple " + displayName + " Fluid Pipe", 0.875F, aMaterial, baseCapacity, heatCapacity, gasProof, 4).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeNonuple.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 1, "GT_Pipe_" + name + "_Nonuple", "Nonuple " + displayName + " Fluid Pipe", 0.875F, aMaterial, baseCapacity / 3, heatCapacity, gasProof, 9).getStackForm(1L));
    }
}
