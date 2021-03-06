package gregtech.api.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

/**
 * NEVER INCLUDE THIS FILE IN YOUR MOD!!!
 * <p/>
 * Main GUI-Container-Class which basically contains the Code needed to prevent crashes from improperly Coded Items.
 */
public class GT_GUIContainer extends GuiContainer {

    public boolean mCrashed = false;

    public ResourceLocation mGUIbackground;

    public String mGUIbackgroundPath;

    public GT_GUIContainer(Container aContainer, String aGUIbackground) {
        super(aContainer);
        mGUIbackground = new ResourceLocation(mGUIbackgroundPath = aGUIbackground);
    }

    public int getLeft() {
        return guiLeft;
    }

    public int getTop() {
        return guiTop;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        mc.renderEngine.bindTexture(mGUIbackground);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        try {
            super.drawScreen(par1, par2, par3);
        } catch (Throwable e) {
            try {
                Tessellator.instance.draw();
            } catch (Throwable ignored) {
            }
        }
    }

    public boolean isTheMouseOverSlot(Slot aSlot, int aMouseX, int aMouseY) {
        return aMouseX >= aSlot.xDisplayPosition && aMouseX <= aSlot.xDisplayPosition + 16 && aMouseY >= aSlot.yDisplayPosition && aMouseY <= aSlot.yDisplayPosition + 16;
    }
}
