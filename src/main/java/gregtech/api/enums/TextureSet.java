package gregtech.api.enums;

import gregtech.api.interfaces.IIconContainer;

public class TextureSet {
    public static final TextureSet
            SET_NONE = new TextureSet("NONE"),
            SET_DULL = new TextureSet("DULL"),
            SET_RUBY = new TextureSet("RUBY"),
            SET_OPAL = new TextureSet("OPAL"),
            SET_LEAF = new TextureSet("LEAF"),
            SET_WOOD = new TextureSet("WOOD"),
            SET_SAND = new TextureSet("SAND"),
            SET_FINE = new TextureSet("FINE"),
            SET_FIERY = new TextureSet("FIERY"),
            SET_FLUID = new TextureSet("FLUID"),
            SET_ROUGH = new TextureSet("ROUGH"),
            SET_PAPER = new TextureSet("PAPER"),
            SET_GLASS = new TextureSet("GLASS"),
            SET_FLINT = new TextureSet("FLINT"),
            SET_LAPIS = new TextureSet("LAPIS"),
            SET_SHINY = new TextureSet("SHINY"),
            SET_SHARDS = new TextureSet("SHARDS"),
            SET_POWDER = new TextureSet("POWDER"),
            SET_QUARTZ = new TextureSet("QUARTZ"),
            SET_EMERALD = new TextureSet("EMERALD"),
            SET_DIAMOND = new TextureSet("DIAMOND"),
            SET_LIGNITE = new TextureSet("LIGNITE"),
            SET_MAGNETIC = new TextureSet("MAGNETIC"),
            SET_METALLIC = new TextureSet("METALLIC"),
            SET_NETHERSTAR = new TextureSet("NETHERSTAR"),
            SET_GEM_VERTICAL = new TextureSet("GEM_VERTICAL"),
            SET_GEM_HORIZONTAL = new TextureSet("GEM_HORIZONTAL");
    
    
    public static final TextureSet MATERIALS = new TextureSet("MATERIALS");
    /**
     * For the Indices of OrePrefixes you need to look into the OrePrefix Enum.
     */
    public static final short
            INDEX_wire = 69, INDEX_foil = 70, INDEX_block1 = 71, INDEX_block2 = 72, INDEX_block3 = 73, INDEX_block4 = 74, INDEX_block5 = 75, INDEX_block6 = 76;

    public final IIconContainer[] mTextures = new IIconContainer[128];
    public final String mSetName;
    private final static String aTextMatIconDir = "materialicons/";
    private final static String aTextVoidDir = "/void";

    public TextureSet(String aSetName) {
        mSetName = aSetName;
        mTextures[0] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/dustTiny");
        mTextures[1] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/dustSmall");
        mTextures[2] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/dust");
        mTextures[3] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/dustImpure");
        mTextures[4] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/dustPure");
        mTextures[5] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crushed");
        mTextures[6] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crushedPurified");
        mTextures[7] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crushedCentrifuged");
        mTextures[8] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gem");
        mTextures[9] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/nugget");
        mTextures[10] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[11] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingot");
        mTextures[12] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingotHot");
        mTextures[13] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingotDouble");
        mTextures[14] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingotTriple");
        mTextures[15] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingotQuadruple");
        mTextures[16] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ingotQuintuple");
        mTextures[17] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plate");
        mTextures[18] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plateDouble");
        mTextures[19] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plateTriple");
        mTextures[20] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plateQuadruple");
        mTextures[21] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plateQuintuple");
        mTextures[22] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/plateDense");
        mTextures[23] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/stick");
        mTextures[24] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/lens");
        mTextures[25] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/round");
        mTextures[26] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/bolt");
        mTextures[27] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/screw");
        mTextures[28] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/ring");
        mTextures[29] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/foil");
        mTextures[30] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/cell");
        mTextures[31] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/cellPlasma");
        mTextures[32] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadSword");
        mTextures[33] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadPickaxe");
        mTextures[34] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadShovel");
        mTextures[35] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadAxe");
        mTextures[36] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadHoe");
        mTextures[37] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadHammer");
        mTextures[38] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadFile");
        mTextures[39] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadSaw");
        mTextures[40] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadDrill");
        mTextures[41] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadChainsaw");
        mTextures[42] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadWrench");
        mTextures[43] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadUniversalSpade");
        mTextures[44] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadSense");
        mTextures[45] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadPlow");
        mTextures[46] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadArrow");
        mTextures[47] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadScrewdriver");
        mTextures[48] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadBuzzSaw");
        mTextures[49] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadSoldering");
        mTextures[50] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[51] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/wireFine");
        mTextures[52] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gearGtSmall");
        mTextures[53] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/rotor");
        mTextures[54] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/stickLong");
        mTextures[55] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/springSmall");
        mTextures[56] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/spring");
        mTextures[57] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/arrowGtWood");
        mTextures[58] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/arrowGtPlastic");
        mTextures[59] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gemChipped");
        mTextures[60] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gemFlawed");
        mTextures[61] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gemFlawless");
        mTextures[62] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gemExquisite");
        mTextures[63] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/gearGt");
        mTextures[64] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[65] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[66] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[67] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/oreSmall");
        mTextures[68] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/ore");
        mTextures[69] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/wire");
        mTextures[70] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/foil");
        mTextures[71] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block1");
        mTextures[72] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block2");
        mTextures[73] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block3");
        mTextures[74] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block4");
        mTextures[75] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block5");
        mTextures[76] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/block6");
        mTextures[77] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeSide");
        mTextures[78] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeTiny");
        mTextures[79] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeSmall");
        mTextures[80] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeMedium");
        mTextures[81] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeLarge");
        mTextures[82] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeHuge");
        mTextures[83] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/frameGt");
        mTextures[84] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeQuadruple");
        mTextures[85] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + "/pipeNonuple");
        mTextures[86] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[87] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[88] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[89] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[90] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[91] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[92] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[93] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[94] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[95] = new Textures.BlockIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[96] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crateGtDust");
        mTextures[97] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crateGtIngot");
        mTextures[98] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crateGtGem");
        mTextures[99] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/crateGtPlate");
        mTextures[100] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/turbineBlade");
        mTextures[101] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[102] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[103] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[104] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[105] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[106] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[107] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[108] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[109] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[110] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[111] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[112] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[113] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[114] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[115] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[116] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[117] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[118] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[119] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[120] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[121] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[122] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[123] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[124] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[125] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + aTextVoidDir);
        mTextures[126] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/handleMallet");
        mTextures[127] = new Textures.ItemIcons.CustomIcon(aTextMatIconDir + mSetName + "/toolHeadMallet");
    }
}