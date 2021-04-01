package gregtech.common.items.behaviors;

import gregtech.api.items.GT_MetaBase_Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class Behaviour_UB
        extends Behaviour_None {

    public List<String> getAdditionalToolTips(GT_MetaBase_Item aItem, List<String> aList, ItemStack aStack) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            aList.add(getV(" SOON") + getV("SOON "));
        }
        return aList;
    }

    public static String getV(String from) {
        long time = System.currentTimeMillis() / 1000;
        char value = from.charAt((int) (time % from.length()));
        time = System.currentTimeMillis() / 1000;
        if ((int) (time % 2) == 0) {
            return EnumChatFormatting.DARK_GRAY.toString() + value;
        }
        return EnumChatFormatting.GRAY.toString() + value;

    }
}
