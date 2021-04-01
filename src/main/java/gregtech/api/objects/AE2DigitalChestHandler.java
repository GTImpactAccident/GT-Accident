package gregtech.api.objects;

import appeng.api.networking.security.BaseActionSource;
import appeng.api.storage.IExternalStorageHandler;
import appeng.api.storage.IMEInventory;
import appeng.api.storage.StorageChannel;
import appeng.me.storage.MEMonitorIInventory;
import appeng.util.inv.IMEAdaptor;
import cpw.mods.fml.common.Optional;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.common.tileentities.storage.GT_MetaTileEntity_DigitalChestBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

@Optional.Interface(iface = "appeng.api.storage.IExternalStorageHandler", modid = "appliedenergistics2", striprefs = true)
public class AE2DigitalChestHandler implements IExternalStorageHandler {

    @Optional.Method(modid = "appliedenergistics2")
    public boolean canHandle(final TileEntity te, final ForgeDirection d, final StorageChannel chan, final BaseActionSource mySrc) {
        return chan == StorageChannel.ITEMS && te instanceof BaseMetaTileEntity && ((BaseMetaTileEntity) te).getMetaTileEntity() instanceof GT_MetaTileEntity_DigitalChestBase;
    }

    @Optional.Method(modid = "appliedenergistics2")
    public IMEInventory getInventory(final TileEntity te, final ForgeDirection d, final StorageChannel chan, final BaseActionSource src) {
        if (chan == StorageChannel.ITEMS) {
            return new MEMonitorIInventory(new IMEAdaptor((GT_MetaTileEntity_DigitalChestBase) (((BaseMetaTileEntity) te).getMetaTileEntity()), src));
        }
        return null;
    }
} 