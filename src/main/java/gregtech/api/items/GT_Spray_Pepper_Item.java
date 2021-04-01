package gregtech.api.items;

import gregtech.api.util.GT_LanguageManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class GT_Spray_Pepper_Item extends GT_Tool_Item {
    public GT_Spray_Pepper_Item(String aUnlocalized, String aEnglish, int aMaxDamage, int aEntityDamage) {
        super(aUnlocalized, aEnglish, "To defend yourself against Bears", aMaxDamage, aEntityDamage, true);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addAdditionalToolTips(List aList, ItemStack aStack, EntityPlayer aPlayer) {
        aList.add(GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".tooltip_1", "especially Pedobears, Care Bears,"));
        aList.add(GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".tooltip_2", "Confession Bears, Bear Grylls"));
        aList.add(GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".tooltip_3", "And ofcourse Man-Bear-Pig"));
    }

    @Override
    public boolean onItemUseFirst(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float hitX, float hitY, float hitZ) {
        super.onItemUseFirst(aStack, aPlayer, aWorld, aX, aY, aZ, aSide, hitX, hitY, hitZ);
        if (aWorld.isRemote) {
            return false;
        }
        Block aBlock = aWorld.getBlock(aX, aY, aZ);
        if (aBlock == null) return false;
        return false;
    }
}