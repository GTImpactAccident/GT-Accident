package gregtech.api.items;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Arrays;

import static gregtech.api.enums.GT_Values.W;

public class GT_Spray_Ice_Item extends GT_Tool_Item {
    public GT_Spray_Ice_Item(String aUnlocalized, String aEnglish, int aMaxDamage, int aEntityDamage) {
        super(aUnlocalized, aEnglish, "Very effective against Slimes", aMaxDamage, aEntityDamage, true);

        for (Object tName : Arrays.asList(OrePrefixes.bucket.get(Materials.Water), OrePrefixes.cell.get(Materials.Water))) {
            GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.ice, 1, 0), new Object[]{new ItemStack(this, 1, W), tName});
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float hitX, float hitY, float hitZ) {
        super.onItemUseFirst(aStack, aPlayer, aWorld, aX, aY, aZ, aSide, hitX, hitY, hitZ);
        if (aWorld.isRemote) {
            return false;
        }
        aX += ForgeDirection.getOrientation(aSide).offsetX;
        aY += ForgeDirection.getOrientation(aSide).offsetY;
        aZ += ForgeDirection.getOrientation(aSide).offsetZ;
        Block aBlock = aWorld.getBlock(aX, aY, aZ);
        if (aBlock == null) return false;
        byte aMeta = (byte) aWorld.getBlockMetadata(aX, aY, aZ);

        if (aBlock == Blocks.water || aBlock == Blocks.flowing_water) {
            if (aMeta == 0 && GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                GT_Utility.sendSoundToPlayers(aWorld, GregTech_API.sSoundList.get(102), 1.0F, -1, aX, aY, aZ);
                aWorld.setBlock(aX, aY, aZ, Blocks.ice, 0, 3);
                return true;
            }
            return false;
        }

        if (aBlock == Blocks.lava || aBlock == Blocks.flowing_lava) {
            if (aMeta == 0 && GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                GT_Utility.sendSoundToPlayers(aWorld, GregTech_API.sSoundList.get(102), 1.0F, -1, aX, aY, aZ);
                aWorld.setBlock(aX, aY, aZ, Blocks.obsidian, 0, 3);
                return true;
            }
            return false;
        }
        return false;
    }
}