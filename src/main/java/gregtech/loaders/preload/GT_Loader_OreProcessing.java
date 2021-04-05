package gregtech.loaders.preload;

import gregtech.loaders.oreprocessing.ProcessingToolHead;

public class GT_Loader_OreProcessing implements Runnable {

    public void run() {
        new ProcessingToolHead();
    }
}
