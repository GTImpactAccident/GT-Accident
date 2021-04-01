package gregtech.loaders.preload;

import codechicken.nei.api.API;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.items.GT_Generic_Item;
import gregtech.api.metatileentity.BaseMetaPipeEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.*;
import net.minecraft.item.Item;

public class GT_Loader_Item_Block_And_Fluid implements Runnable {

    public void run() {

        GT_Log.out.println("GT_Mod: Register Items.");

        new GT_IntegratedCircuit_Item();
        new GT_MetaGenerated_Item_01();
        new GT_MetaGenerated_Item_02();
        new GT_MetaGenerated_Item_03();
        new GT_MetaGenerated_Tool_01();
        new GT_FluidDisplayItem();

        ItemList.VOLUMETRIC_FLASK.set(new GT_VolumetricFlask("Volumetric_Flask", "Volumetric flask", 1000));

        Item tItem = (Item) GT_Utility.callConstructor("gregtech.common.items.GT_SensorCard_Item", 0, null, false, new Object[]{"sensorcard", "GregTech Sensor Card"});
        ItemList.NC_SensorCard.set(tItem == null ? new GT_Generic_Item("sensorcard", "GregTech Sensor Card", "Nuclear Control not installed", false) : tItem);

        GT_Log.out.println("GT_Mod: Register TileEntities.");
        BaseMetaTileEntity tBaseMetaTileEntity = GregTech_API.constructBaseMetaTileEntity();

        GT_Log.out.println("GT_Mod: Testing BaseMetaTileEntity.");
        if (tBaseMetaTileEntity == null) {
            GT_Log.out.println("GT_Mod: Fatal Error ocurred while initializing TileEntities, crashing Minecraft.");
            throw new RuntimeException("");
        }
        GT_Log.out.println("GT_Mod: Registering the BaseMetaTileEntity.");
        GameRegistry.registerTileEntity(tBaseMetaTileEntity.getClass(), "BaseMetaTileEntity");
        FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", tBaseMetaTileEntity.getClass().getName());

        GT_Log.out.println("GT_Mod: Registering the BaseMetaPipeEntity.");
        GameRegistry.registerTileEntity(BaseMetaPipeEntity.class, "BaseMetaPipeEntity");
        FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", BaseMetaPipeEntity.class.getName());

        if (!GT_Values.D1) {
            try {
                Class.forName("codechicken.nei.api.API");
                GT_Log.out.println("GT_Mod: Hiding certain Items from NEI.");
                API.hideItem(ItemList.Display_Fluid.getWildcard(1L));
            } catch (Throwable e) {
                if (GT_Values.D1) {
                    e.printStackTrace(GT_Log.err);
                }
            }
        }

        GregTech_API.registerMachineBlock(GT_Utility.getBlockFromStack(GT_ModHandler.getIC2Item("reinforcedGlass", 0)), 0);
    }
}
