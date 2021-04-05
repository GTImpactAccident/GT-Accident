package gregtech.api.enums;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ICondition;
import gregtech.api.interfaces.IMaterialHandler;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.interfaces.ISubTagContainer;
import gregtech.api.objects.ItemData;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import java.util.*;

import static gregtech.api.enums.GT_Values.*;

public enum OrePrefixes {
    oreSmall("Small Ores", "Small ", " Ore", true, true, false, false, false, true, false, false, false, true, MaterialsValues.NULL, -1, 64, 67), // Prefix of Railcraft.
    ore("Ores", "", " Ore", true, true, false, false, false, true, false, false, false, true, MaterialsValues.NULL, -1, 64, 68), // Regular Ore Prefix. Ore -> Material is a Oneway Operation! Introduced by Eloraam
    crushedCentrifuged("Centrifuged Ores", "Centrifuged ", " Ore", true, true, false, false, false, false, false, true, false, true, MaterialsValues.CRUSHED_CENTRIFUGE, -1, 64, 7),
    crushedPurified("Purified Ores", "Purified ", " Ore", true, true, false, false, false, false, false, true, false, true, MaterialsValues.CRUSHED_PURE, -1, 64, 6),
    crushed("Crushed Ores", "Crushed ", " Ore", true, true, false, false, false, false, false, true, false, true, MaterialsValues.CRUSHED, -1, 64, 5),
    ingot("Ingots", "", " Ingots", true, true, false, false, false, false, false, true, false, false, MaterialsValues.INGOT, M, 16, 11), // A regular Ingot. Introduced by Eloraam
    gemFlawed("Flawed Gemstones", "Flawed ", "", true, true, true, false, false, false, true, true, false, false, MaterialsValues.GEM_FAWED, M / 2, 64, 60), // A regular Gem worth two small Dusts. Introduced by TerraFirmaCraft
    gemFlawless("Flawless Gemstones", "Flawless ", "", true, true, true, false, false, false, true, true, false, false, MaterialsValues.GEM_FLAWLESS, M * 2, 32, 61), // A regular Gem worth two Dusts. Introduced by TerraFirmaCraft
    gemExquisite("Exquisite Gemstones", "Exquisite ", "", true, true, true, false, false, false, true, true, false, false, MaterialsValues.GEM_EXQUISITE, M * 4, 16, 62), // A regular Gem worth four Dusts. Introduced by TerraFirmaCraft
    gem("Gemstones", "", "", true, true, true, false, false, false, true, true, false, false, MaterialsValues.GEM, M, 64, 8), // A regular Gem worth one Dust. Introduced by Eloraam
    dustImpure("Impure Dusts", "Impure Pile of ", " Dust", true, true, false, false, false, false, false, true, false, true, MaterialsValues.DUST_IMPURE, M, 64, 3), // Dust with impurities. 1 Unit of Main Material and 1/9 - 1/4 Unit of secondary Material
    dustPure("Purified Dusts", "Purified Pile of ", " Dust", true, true, false, false, false, false, false, true, false, true, MaterialsValues.DUST_PURE, M, 64, 4),
    dust("Dusts", "", " Dusts", true, true, false, false, false, false, false, true, false, false, MaterialsValues.DUST, M, 16, 2), // Pure Dust worth of one Ingot or Gem. Introduced by Alblaka.
    plateDense("Dense Plates", "Dense ", " Plate", true, true, false, false, false, false, true, true, false, false, MaterialsValues.PLATE_DENSE, M * 9, 8, 22), // 9 Plates combined in one Item.
    plate("Plates", "", " Plates", true, true, false, false, false, false, true, true, false, false, MaterialsValues.PLATE, M, 8, 17), // Regular Plate made of one Ingot/Dust. Introduced by Calclavia
    foil("Foils", "", " Foil", true, true, false, false, false, false, true, true, false, false, MaterialsValues.FOIL, M / 4, 64, 29), // Foil made of 1/4 Ingot/Dust.
    stickLong("Long Sticks/Rods", "Long ", " Rod", true, true, false, false, false, false, true, true, false, false, MaterialsValues.ROD_LONG, M, 64, 54), // Stick made of an Ingot.
    stick("Sticks/Rods", "", " Rod", true, true, false, false, false, false, true, true, false, false, MaterialsValues.ROD, M / 2, 64, 23), // Stick made of half an Ingot. Introduced by Eloraam
    bolt("Bolts", "", " Bolt", true, true, false, false, false, false, true, true, false, false, MaterialsValues.BOLT, M / 8, 64, 26), // consisting out of 1/8 Ingot or 1/4 Stick.
    screw("Screws", "", " Screw", true, true, false, false, false, false, true, true, false, false, MaterialsValues.SCREW, M / 9, 64, 27), // consisting out of a Bolt.
    ring("Rings", "", " Ring", true, true, false, false, false, false, true, true, false, false, MaterialsValues.RING, M / 4, 64, 28), // consisting out of 1/2 Stick.
    springSmall("Small Springs", "Small ", " Spring", true, true, false, false, false, false, true, true, false, false, MaterialsValues.SPRING_SMALL, M / 4, 64, 55), // consisting out of 1 Fine Wire.
    spring("Springs", "", " Spring", true, true, false, false, false, false, true, true, false, false, MaterialsValues.SPRING, M, 64, 56), // consisting out of 2 Sticks.
    wireFine("Fine Wires", "Fine ", " Wire", true, true, false, false, false, false, true, true, false, false, MaterialsValues.WIRE_FINE, M / 8, 64, 51), // consisting out of 1/8 Ingot or 1/4 Wire.
    rotor("Rotors", "", " Rotor", true, true, false, false, false, false, true, true, false, false, MaterialsValues.ROTOR, M * 4 + M / 4, 16, 53), // consisting out of 4 Plates, 1 Ring and 1 Screw.
    gearGtSmall("Small Gears", "Small ", " Gear", true, true, false, false, false, false, true, true, false, false, MaterialsValues.GEAR_SMALL, M, 64, 52),
    gearGt("Gears", "", " Gear", true, true, false, false, false, false, true, true, false, false, MaterialsValues.GEAR, M * 4, 16, 63), // Introduced by me because BuildCraft has ruined the gear Prefix...
    lens("Lenses", "", " Lens", true, true, false, false, false, false, true, true, false, false, MaterialsValues.LENS, (M * 3) / 4, 64, 24), // 3/4 of a Plate or Gem used to shape a Lense. Normally only used on Transparent Materials.
    cell("Cells", "", " Cell", true, true, true, true, false, false, true, true, false, false, MaterialsValues.CELL, M, 64, 30), // Regular Gas/Fluid Cell. Introduced by Calclavia
    bucket("Buckets", "", " Bucket", true, true, true, true, false, false, true, false, false, false, MaterialsValues.BUCKET, M, 16, -1), // A vanilla Iron Bucket filled with the Material.
    crystal("Crystals", "", " Crystal", false, true, false, false, false, false, true, false, false, false, MaterialsValues.CRYSTAL, M, 64, -1),
    toolHeadSword("Sword Blades", "", " Sword Blade", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 2, 16, 32), // consisting out of 2 Ingots.
    toolHeadPickaxe("Pickaxe Heads", "", " Pickaxe Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 3, 16, 33), // consisting out of 3 Ingots.
    toolHeadShovel("Shovel Heads", "", " Shovel Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M, 16, 34), // consisting out of 1 Ingots.
    toolHeadUniversalSpade("Universal Spade Heads", "", " Universal Spade Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M, 16, 43), // consisting out of 1 Ingots.
    toolHeadAxe("Axe Heads", "", " Axe Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 3, 16, 35), // consisting out of 3 Ingots.
    toolHeadHoe("Hoe Heads", "", " Hoe Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 2, 16, 36), // consisting out of 2 Ingots.
    toolHeadSense("Sense Blades", "", " Sense Blade", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 3, 16, 44), // consisting out of 3 Ingots.
    toolHeadFile("File Heads", "", " File Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 2, 16, 38), // consisting out of 2 Ingots.
    toolHeadHammer("Hammer Heads", "", " Hammer Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 6, 16, 37), // consisting out of 6 Ingots.
    toolHeadPlow("Plow Heads", "", " Plow Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 4, 16, 45), // consisting out of 4 Ingots.
    toolHeadSaw("Saw Blades", "", " Saw Blade", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 2, 16, 39), // consisting out of 2 Ingots.
    toolHeadBuzzSaw("Buzzsaw Blades", "", " Buzzsaw Blade", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 4, 16, 48), // consisting out of 4 Ingots.
    toolHeadScrewdriver("Screwdriver Tips", "", " Screwdriver Tip", true, true, false, false, false, false, true, false, false, false, MaterialsValues.TOOL_HEAD, M, 16, 47), // consisting out of 1 Ingots.
    toolHeadDrill("Drill Tips", "", " Drill Tip", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 4, 16, 40), // consisting out of 4 Ingots.
    toolHeadChainsaw("Chainsaw Tips", "", " Chainsaw Tip", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 2, 16, 41), // consisting out of 2 Ingots.
    toolHeadWrench("Wrench Tips", "", " Wrench Tip", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD, M * 4, 16, 42), // consisting out of 4 Ingots.
    turbineBlade("Turbine Blades", "", " Turbine Blade", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_TURBINE, M * 6, 64, 100), // consisting out of 6 Ingots.
    toolSword("Swords", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M * 2, 1, -1), // vanilly Sword
    toolPickaxe("Pickaxes", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M * 3, 1, -1), // vanilly Pickaxe
    toolShovel("Shovels", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M, 1, -1), // vanilly Shovel
    toolAxe("Axes", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M * 3, 1, -1), // vanilly Axe
    toolHoe("Hoes", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M * 2, 1, -1), // vanilly Hoe
    toolShears("Shears", "", "", false, true, false, false, false, false, true, false, true, false, MaterialsValues.TOOL_HEAD, M * 2, 1, -1), // vanilly Shears
    compressed("Compressed Materials", "Compressed ", "", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 2, 64, -1), // Compressed Material, worth 1 Unit. Introduced by Galacticraft
    block("Storage Blocks", "Block of ", "", true, true, false, false, false, true, true, false, false, false, MaterialsValues.BLOCK, M * 9, 64, 71), // Storage Block consisting out of 9 Ingots/Gems/Dusts. Introduced by CovertJaguar
    crafting("Crafting Ingredients", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Special Prefix used mainly for the Crafting Handler.
    log("Logs", "", "", false, false, false, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix used for Logs. Usually as "logWood". Introduced by Eloraam
    slab("Slabs", "", "", false, false, false, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix used for Slabs. Usually as "slabWood" or "slabStone". Introduced by SirSengir
    plank("Planks", "", "", false, false, false, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix for Planks. Usually "plankWood". Introduced by Eloraam
    treeSapling("Saplings", "", "", false, false, true, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix for Saplings.
    treeLeaves("Leaves", "", "", false, false, true, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix for Leaves.
    stoneCobble("Cobblestones", "", "", false, false, true, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Cobblestone Prefix for all Cobblestones.
    stone("Stones", "", "", false, true, true, false, true, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Prefix to determine which kind of Rock this is.
    cobblestone("Cobblestones", "", "", false, true, true, false, false, true, false, false, false, false, MaterialsValues.NULL, -1, 64, -1),
    item_("Items", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // IGNORE
    item("Items", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Random Item. Introduced by Alblaka
    dye("Dyes", "", "", false, false, true, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Used for the 16 dyes. Introduced by Eloraam
    frameGt("Frame Boxes", "", "", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 2, 64, 83),
    pipeTiny("Tiny Pipes", "Tiny ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M / 2, 64, 78),
    pipeSmall("Small Pipes", "Small ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M, 64, 79),
    pipeMedium("Medium Pipes", "Medium ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 3, 64, 80),
    pipeLarge("Large pipes", "Large ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 6, 64, 81),
    pipeHuge("Huge Pipes", "Huge ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 12, 64, 82),
    pipeQuadruple("Quadruple Pipes", "Quadruple ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M *12, 64, 84),
    pipeNonuple("Nonuple Pipes", "Nonuple ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 9, 64, 85),
    pipeRestrictiveTiny("Tiny Restrictive Pipes", "Tiny Restrictive ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M / 2, 64, 78),
    pipeRestrictiveSmall("Small Restrictive Pipes", "Small Restrictive ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M, 64, 79),
    pipeRestrictiveMedium("Medium Restrictive Pipes", "Medium Restrictive ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 3, 64, 80),
    pipeRestrictiveLarge("Large Restrictive Pipes", "Large Restrictive ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 6, 64, 81),
    pipeRestrictiveHuge("Huge Restrictive Pipes", "Huge Restrictive ", " Pipe", true, true, false, false, true, false, true, false, false, false, MaterialsValues.NULL, M * 12, 64, 82),
    pipe("Pipes", "", " Pipe", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, 77),
    wireGt16("16x Wires", "16x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 8, 64, -1),
    wireGt12("12x Wires", "12x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 6, 64, -1),
    wireGt08("8x Wires", "8x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 4, 64, -1),
    wireGt04("4x Wires", "4x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 2, 64, -1),
    wireGt02("2x Wires", "2x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M, 64, -1),
    wireGt01("1x Wires", "1x ", " Wire", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M / 2, 64, -1),
    cableGt12("12x Cables", "12x ", " Cable", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 6, 64, -1),
    cableGt08("8x Cables", "8x ", " Cable", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 4, 64, -1),
    cableGt04("4x Cables", "4x ", " Cable", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M * 2, 64, -1),
    cableGt02("2x Cables", "2x ", " Cable", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M, 64, -1),
    cableGt01("1x Cables", "1x ", " Cable", true, true, false, false, false, false, true, false, false, false, MaterialsValues.NULL, M / 2, 64, -1),

    /* Electric Components.
     *
	 * usual Materials for this are:
	 * Primitive (Tier 1)
	 * Basic (Tier 2) as used by UE as well : IC2 Circuit and RE-Battery
	 * Good (Tier 3)
	 * Advanced (Tier 4) as used by UE as well : Advanced Circuit, Advanced Battery and Lithium Battery
	 * Data (Tier 5) : Data Storage Circuit
	 * Elite (Tier 6) as used by UE as well : Energy Crystal and Data Control Circuit
	 * Master (Tier 7) : Energy Flow Circuit and Lapotron Crystal
	 * Ultimate (Tier 8) : Data Orb and Lapotronic Energy Orb
	 * Infinite (Cheaty)
	 */
    circuit("Circuits", "", "", true, true, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Introduced by Calclavia
    wood("Woods", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Introduced by Eloraam
    wire("Wires", "", "", false, false, false, false, true, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1),
    sheetDouble("2x Sheets", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1),
    sheet("Sheets", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1),
    food("Foods", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1),
    gear("Gears", "", "", false, false, false, false, false, false, false, false, false, false, MaterialsValues.NULL, -1, 64, -1), // Introduced by SirSengir
    toolHeadMallet("Mallet Heads", "", " Mallet Head", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HEAD_MALLET, M * 6, 16, 127), // Reverse Head consisting out of 6 Ingots.
	handleMallet("Mallet Handle", "", " Handle", true, true, false, false, false, false, true, true, false, false, MaterialsValues.TOOL_HAND_MALLET, M / 2, 64, 126); // Reverse Stick made of half an Ingot. Introduced by Eloraam
	
    public static volatile int VERSION = 509;
    static {

        block.ignoreMaterials(Materials.Ice, Materials.Snow, Materials.Concrete, Materials.Glass, Materials.Glowstone, Materials.DarkIron, Materials.Marble, Materials.Quartz, Materials.CertusQuartz, Materials.Limestone);
        ingot.ignoreMaterials(Materials.Brick, Materials.NetherBrick);

        for (OrePrefixes tPrefix1 : values())
            if (tPrefix1.name().startsWith("ore")) for (OrePrefixes tPrefix2 : values())
                if (tPrefix2.name().startsWith("ore")) tPrefix1.addFamiliarPrefix(tPrefix2);
        for (OrePrefixes tPrefix1 : values())
            if (tPrefix1.name().startsWith("pipe")) for (OrePrefixes tPrefix2 : values())
                if (tPrefix2.name().startsWith("pipe")) tPrefix1.addFamiliarPrefix(tPrefix2);
        for (OrePrefixes tPrefix1 : values())
            if (tPrefix1.name().startsWith("wireGt")) for (OrePrefixes tPrefix2 : values())
                if (tPrefix2.name().startsWith("wireGt")) tPrefix1.addFamiliarPrefix(tPrefix2);
        for (OrePrefixes tPrefix1 : values())
            if (tPrefix1.name().startsWith("cableGt")) for (OrePrefixes tPrefix2 : values())
                if (tPrefix2.name().startsWith("cableGt")) tPrefix1.addFamiliarPrefix(tPrefix2);
                
        toolHeadFile.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        toolHeadSaw.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        toolHeadDrill.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        toolHeadChainsaw.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        toolHeadWrench.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        toolHeadBuzzSaw.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));
        turbineBlade.mCondition = new ICondition.And<>(new ICondition.Not<>(SubTag.NO_SMASHING), new ICondition.Not<>(SubTag.BOUNCY));

        rotor.mCondition = new ICondition.Nor<>(SubTag.CRYSTAL, SubTag.STONE, SubTag.BOUNCY);

        spring.mCondition = new ICondition.Or<>(SubTag.STRETCHY, SubTag.BOUNCY, new ICondition.Not<>(SubTag.NO_SMASHING));
        springSmall.mCondition = new ICondition.Or<>(SubTag.STRETCHY, SubTag.BOUNCY, new ICondition.Not<>(SubTag.NO_SMASHING));

        gemFlawed.mCondition = new ICondition.And<>(SubTag.TRANSPARENT, SubTag.CRYSTAL, new ICondition.Not<>(SubTag.QUARTZ), new ICondition.Not<>(SubTag.PEARL), new ICondition.Not<>(SubTag.MAGICAL));
        gemFlawless.mCondition = new ICondition.And<>(SubTag.TRANSPARENT, SubTag.CRYSTAL, new ICondition.Not<>(SubTag.QUARTZ), new ICondition.Not<>(SubTag.PEARL), new ICondition.Not<>(SubTag.MAGICAL));
        gemExquisite.mCondition = new ICondition.And<>(SubTag.TRANSPARENT, SubTag.CRYSTAL, new ICondition.Not<>(SubTag.QUARTZ), new ICondition.Not<>(SubTag.PEARL), new ICondition.Not<>(SubTag.MAGICAL));

        lens.mCondition = new ICondition.Or<>(SubTag.MAGICAL, new ICondition.And<>(SubTag.TRANSPARENT, SubTag.HAS_COLOR));
        plateDense.mCondition = new ICondition.Not<>(SubTag.NO_SMASHING);

        wireFine.mCondition = SubTag.METAL;

    }

    public final ArrayList<ItemStack> mPrefixedItems = new ArrayList<>();
    public final short mTextureIndex;
    public final String mRegularLocalName, mLocalizedMaterialPre, mLocalizedMaterialPost;
    public final boolean mIsUsedForOreProcessing, mIsEnchantable, mIsUnificatable, mIsMaterialBased, mIsSelfReferencing, mIsContainer, mDontUnificateActively, mIsUsedForBlocks, mAllowNormalRecycling, mGenerateDefaultItem;
    public final Collection<OrePrefixes> mFamiliarPrefixes = new HashSet<>();
    /**
     * Used to determine the amount of Material this Prefix contains.
     * Multiply or Divide GregTech_API.MATERIAL_UNIT to get the Amounts in comparision to one Ingot.
     * 0 = Null
     * Negative = Undefined Amount
     */
    public final long mMaterialAmount;
    public final Collection<Materials> mDisabledItems = new HashSet<>(), mNotGeneratedItems = new HashSet<>(), mIgnoredMaterials = new HashSet<>(), mGeneratedItems = new HashSet<>();
    private final ArrayList<IOreRecipeRegistrator> mOreProcessing = new ArrayList<>();
    public ItemStack mContainerItem = null;
    public ICondition<ISubTagContainer> mCondition = null;
    public byte mDefaultStackSize;
    public MaterialStack mSecondaryMaterial = null;
    public OrePrefixes mPrefixInto = this;
    public float mHeatDamage = 0.0F; // Negative for Frost Damage
    public static List<OrePrefixes> mPreventableComponents = new LinkedList<>(Arrays.asList(OrePrefixes.gem, OrePrefixes.plate, OrePrefixes.plateDense, OrePrefixes.stick, OrePrefixes.bolt, OrePrefixes.screw, OrePrefixes.ring, OrePrefixes.foil, OrePrefixes.toolHeadSword, OrePrefixes.toolHeadPickaxe, OrePrefixes.toolHeadShovel, OrePrefixes.toolHeadAxe, OrePrefixes.toolHeadHoe, OrePrefixes.toolHeadHammer, OrePrefixes.toolHeadFile, OrePrefixes.toolHeadSaw, OrePrefixes.toolHeadDrill, OrePrefixes.toolHeadChainsaw, OrePrefixes.toolHeadWrench, OrePrefixes.toolHeadUniversalSpade, OrePrefixes.toolHeadSense, OrePrefixes.toolHeadPlow, OrePrefixes.toolHeadBuzzSaw, OrePrefixes.turbineBlade, OrePrefixes.wireFine, OrePrefixes.gearGtSmall, OrePrefixes.rotor, OrePrefixes.stickLong, OrePrefixes.springSmall, OrePrefixes.spring, OrePrefixes.gemFlawed, OrePrefixes.gemFlawless, OrePrefixes.gemExquisite, OrePrefixes.gearGt));
    public MaterialsValues materialsValues;
    /**
     * Yes this Value can be changed to add Bits for the MetaGenerated-Item-Check.
     */
    OrePrefixes(String aRegularLocalName, String aLocalizedMaterialPre, String aLocalizedMaterialPost, boolean aIsUnificatable, boolean aIsMaterialBased, boolean aIsSelfReferencing, boolean aIsContainer, boolean aDontUnificateActively, boolean aIsUsedForBlocks, boolean aAllowNormalRecycling, boolean aGenerateDefaultItem, boolean aIsEnchantable, boolean aIsUsedForOreProcessing, MaterialsValues materialsValues, long aMaterialAmount, int aDefaultStackSize, int aTextureindex) {
        mIsUnificatable = aIsUnificatable;
        mIsMaterialBased = aIsMaterialBased;
        mIsSelfReferencing = aIsSelfReferencing;
        mIsContainer = aIsContainer;
        mDontUnificateActively = aDontUnificateActively;
        mIsUsedForBlocks = aIsUsedForBlocks;
        mAllowNormalRecycling = aAllowNormalRecycling;
        mGenerateDefaultItem = aGenerateDefaultItem;
        mIsEnchantable = aIsEnchantable;
        mIsUsedForOreProcessing = aIsUsedForOreProcessing;
        mMaterialAmount = aMaterialAmount;
        mRegularLocalName = aRegularLocalName;
        mLocalizedMaterialPre = aLocalizedMaterialPre;
        mLocalizedMaterialPost = aLocalizedMaterialPost;
        mDefaultStackSize = (byte) aDefaultStackSize;
        mTextureIndex = (short) aTextureindex;
        this.materialsValues = materialsValues;
    }

    public static void initMaterialComponents() {
        boolean enablePerItemSettings = GregTech_API.sMaterialComponents.get("general", "enablePerItemSettings", false);
        
        for (Materials aMaterial : Materials.values()) {
            if (aMaterial.mMetaItemSubID > 0) {
                if (!aMaterial.materialsValues.contains(MaterialsValues.PURE_CRUSHED)) {
                    crushedPurified.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.CRUSHED)) {
                    crushed.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.DUST_PURE)) {
                    dustPure.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.DUST_IMPURE)) {
                    dustImpure.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.DUST)) {
                    dust.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.GEM)) {
                    gem.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.INGOT)) {
                    ingot.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.PLATE)) {
                    plate.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.FOIL)) {
                    foil.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.CELL)) {
                    cell.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.TOOL_TURBINE)) {
                    turbineBlade.mDisabledItems.add(aMaterial);
                }
                if (!aMaterial.materialsValues.contains(MaterialsValues.TOOL_HEAD)) {
                    toolHeadSword.mDisabledItems.add(aMaterial);
                    toolHeadPickaxe.mDisabledItems.add(aMaterial);
                    toolHeadShovel.mDisabledItems.add(aMaterial);
                    toolHeadUniversalSpade.mDisabledItems.add(aMaterial);
                    toolHeadAxe.mDisabledItems.add(aMaterial);
                    toolHeadHoe.mDisabledItems.add(aMaterial);
                    toolHeadSense.mDisabledItems.add(aMaterial);
                    toolHeadFile.mDisabledItems.add(aMaterial);
                    toolHeadHammer.mDisabledItems.add(aMaterial);
                    toolHeadPlow.mDisabledItems.add(aMaterial);
                    toolHeadSaw.mDisabledItems.add(aMaterial);
                    toolHeadBuzzSaw.mDisabledItems.add(aMaterial);
                    toolHeadScrewdriver.mDisabledItems.add(aMaterial);
                    toolHeadDrill.mDisabledItems.add(aMaterial);
                    toolHeadChainsaw.mDisabledItems.add(aMaterial);
                    toolHeadWrench.mDisabledItems.add(aMaterial);
                    toolSword.mDisabledItems.add(aMaterial);
                    toolPickaxe.mDisabledItems.add(aMaterial);
                    toolShovel.mDisabledItems.add(aMaterial);
                    toolAxe.mDisabledItems.add(aMaterial);
                    toolHoe.mDisabledItems.add(aMaterial);
                    toolShears.mDisabledItems.add(aMaterial);
                }
            }
        }
        for (IMaterialHandler aRegistrator : Materials.mMaterialHandlers) {
            aRegistrator.onComponentInit();
        }
        for (Materials aMaterial : Materials.values()) {
            if (aMaterial.mMetaItemSubID > 0) {
                for (IMaterialHandler aRegistrator : Materials.mMaterialHandlers) {
                    aRegistrator.onComponentIteration(aMaterial);
                }
                if (enablePerItemSettings) {
                    StringBuilder aConfigPathSB = new StringBuilder();
                    aConfigPathSB.append("materialcomponents.").append(aMaterial.mConfigSection).append(".").append(aMaterial.mName);
                    String aConfigPath = aConfigPathSB.toString();
                    for (OrePrefixes aPrefix : mPreventableComponents) {
                        boolean aEnableComponent = GregTech_API.sMaterialComponents.get(aConfigPath, aPrefix.toString(), !aPrefix.mDisabledItems.contains(aMaterial));
                        if (!aEnableComponent) { //Disable component if false and is not already in disabled list
                            aPrefix.disableComponent(aMaterial);
                        } else { //Enable component if true and is not already in enabled list
                            aPrefix.enableComponent(aMaterial);
                        }
                    }
                    aConfigPathSB.setLength(0);
                }
            }
        }
    }

    public void enableComponent(Materials aMaterial) {
        this.mDisabledItems.remove(aMaterial);
    }

    public void disableComponent(Materials aMaterial) {
        if (!this.mDisabledItems.contains(aMaterial)) this.mDisabledItems.add(aMaterial);
    }

    public static OrePrefixes getOrePrefix(String aOre) {
        return null;
    }

    public static String stripPrefix(String aOre) {
        for (OrePrefixes tPrefix : values()) {
            if (aOre.startsWith(tPrefix.toString())) {
                return aOre.replaceFirst(tPrefix.toString(), "");
            }
        }
        return aOre;
    }

    public static String replacePrefix(String aOre, OrePrefixes aPrefix) {
        for (OrePrefixes tPrefix : values()) {
            if (aOre.startsWith(tPrefix.toString())) {
                return aOre.replaceFirst(tPrefix.toString(), aPrefix.toString());
            }
        }
        return "";
    }

    public static OrePrefixes getPrefix(String aPrefixName, OrePrefixes aReplacement) {
        Object tObject = GT_Utility.getFieldContent(OrePrefixes.class, aPrefixName, false, false);
        if (tObject instanceof OrePrefixes) return (OrePrefixes) tObject;
        return aReplacement;
    }

    public static Materials getMaterial(String aOre) {
        return Materials.get(stripPrefix(aOre));
    }

    public static Materials getMaterial(String aOre, OrePrefixes aPrefix) {
        return Materials.get(aOre.replaceFirst(aPrefix.toString(), ""));
    }

    public static Materials getRealMaterial(String aOre, OrePrefixes aPrefix) {
        return Materials.getRealMaterial(aOre.replaceFirst(aPrefix.toString(), ""));
    }

    public static boolean isInstanceOf(String aName, OrePrefixes aPrefix) {
        return aName != null && aName.startsWith(aPrefix.toString());
    }

    public boolean add(ItemStack aStack) {
        if (aStack == null) return false;
        if (!contains(aStack)) mPrefixedItems.add(aStack);
        while (mPrefixedItems.contains(null)) mPrefixedItems.remove(null);
        return true;
    }

    public boolean contains(ItemStack aStack) {
        if (aStack == null) return false;
        for (ItemStack tStack : mPrefixedItems)
            if (GT_Utility.areStacksEqual(aStack, tStack, !tStack.hasTagCompound())) return true;
        return false;
    }

    public boolean doGenerateItem(Materials aMaterial) {
        return aMaterial != null && aMaterial != Materials._NULL && (aMaterial.materialsValues.contains(materialsValues) || mGeneratedItems.contains(aMaterial)) && !mNotGeneratedItems.contains(aMaterial) && !mDisabledItems.contains(aMaterial) && (mCondition == null || mCondition.isTrue(aMaterial));
    }

    public boolean ignoreMaterials(Materials... aMaterials) {
        for (Materials tMaterial : aMaterials) if (tMaterial != null) mIgnoredMaterials.add(tMaterial);
        return true;
    }

    public boolean isIgnored(Materials aMaterial) {
        if (aMaterial != null && (!aMaterial.mUnificatable || aMaterial != aMaterial.mMaterialInto)) return true;
        return mIgnoredMaterials.contains(aMaterial);
    }

    public void addFamiliarPrefix(OrePrefixes aPrefix) {
        if (aPrefix == null || mFamiliarPrefixes.contains(aPrefix) || aPrefix == this) return;
        mFamiliarPrefixes.add(aPrefix);
    }

    public boolean add(IOreRecipeRegistrator aRegistrator) {
        if (aRegistrator == null) return false;
        return mOreProcessing.add(aRegistrator);
    }

    public void processOre(Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial != null && (aMaterial != Materials._NULL || mIsSelfReferencing || !mIsMaterialBased) && GT_Utility.isStackValid(aStack)) {
            //if (Materials.mPreventableComponents.contains(this) && !this.mDynamicItems.contains(aMaterial)) return;
            for (IOreRecipeRegistrator tRegistrator : mOreProcessing) {
                if (D2) GT_Log.ore.println("Processing '" + aOreDictName + "' with the Prefix '" + name() + "' and the Material '" + aMaterial.mName + "' at " + GT_Utility.getClassName(tRegistrator));
                tRegistrator.registerOre(this, aMaterial, aOreDictName, aModName, GT_Utility.copyAmount(1, aStack));
            }
        }
    }

    public Object get(Object aMaterial) {
        if (aMaterial instanceof Materials) return new ItemData(this, (Materials) aMaterial);
        return name() + aMaterial;
    }

    public String getDefaultLocalNameForItem(Materials aMaterial) {
    	return aMaterial.getDefaultLocalizedNameForItem(getDefaultLocalNameFormatForItem(aMaterial));
    }

    @SuppressWarnings("incomplete-switch")
    public String getDefaultLocalNameFormatForItem(Materials aMaterial) {
        // Certain Materials have slightly different Localizations.
        switch (aMaterial.mName) {
            case "Glass":
            case "BorosilicateGlass":
                if (name().startsWith("gem")) return mLocalizedMaterialPre + "%material" + " Crystal";
                if (name().startsWith("plate")) return mLocalizedMaterialPre + "%material" + " Pane";
                if (name().startsWith("ingot")) return mLocalizedMaterialPre + "%material" + " Bar";
                if (name().startsWith("nugget")) return mLocalizedMaterialPre + "%material" + " Chip";
                break;
            case "Wheat":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Flour";
                break;
            case "Ice":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Crushed Ice";
                break;
            case "Wood":
            case "WoodSealed":
                if (name().startsWith("bolt")) return "Short " + "%material" + " Stick";
                if (name().startsWith("stick")) return mLocalizedMaterialPre + "%material" + " Stick";
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "%material" + " Pulp";
                if (name().startsWith("nugget")) return mLocalizedMaterialPre + "%material" + " Chip";
                if (name().startsWith("plate")) return mLocalizedMaterialPre + "%material" + " Plank";
                break;
            case "Plastic":
            case "Rubber":
            case "Polyethylene":
            case "Epoxid":
            case "EpoxidFiberReinforced":
            case "Polydimethylsiloxane":
            case "Silicone":
            case "Polysiloxane":
            case "Polycaprolactam":
            case "Polytetrafluoroethylene":
            case "PolyvinylChloride":
            case "Polystyrene":
            case "StyreneButadieneRubber":
            case "RawRubber":
            case "RawStyreneButadieneRubber":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "%material" + " Pulp";
                if (name().startsWith("plate")) return mLocalizedMaterialPre + "%material" + " Sheet";
                if (name().startsWith("ingot")) return mLocalizedMaterialPre + "%material" + " Bar";
                if (name().startsWith("nugget")) return mLocalizedMaterialPre + "%material" + " Chip";
                if (name().startsWith("foil")) return "Thin " + "%material" + " Sheet";
                break;
            case "FierySteel":
                if (mIsContainer) return mLocalizedMaterialPre + "Fiery Blood" + mLocalizedMaterialPost;
                break;
            case "Steeleaf":
                if (name().startsWith("ingot")) return mLocalizedMaterialPre + "%material";
                break;
            case "Bone":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Bone Meal";
                break;
            case "Blaze":
            case "Milk":
            case "Cocoa":
            case "Chocolate":
            case "Coffee":
            case "Chili":
            case "Cheese":
            case "Snow":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "%material" + " Powder";
                break;
            case "Paper":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Chad";
                switch (this) {
                    case plate: return "Sheet of Paper";
                }
                break;
            case "MeatRaw":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Mince Meat";
                break;
            case "MeatCooked":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "Cooked Mince Meat";
                break;
            case "Ash":
            case "DarkAsh":
            case "Gunpowder":
            case "Sugar":
            case "Salt":
            case "RockSalt":
            case "VolcanicAsh":
            case "RareEarth":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "%material";
                break;
            case "Vermiculite":
            case "Bentonite":
            case "Kaolinite":
            case "Talc":
            case "BasalticMineralSand":
            case "GraniticMineralSand":
            case "GlauconiteSand":
            case "CassiteriteSand":
            case "GarnetSand":
            case "QuartzSand":
            case "Pitchblende":
            case "FullersEarth":
                if (name().startsWith("dust")) return mLocalizedMaterialPre + "%material";
                switch (this) {
                    case crushedCentrifuged:
                    case crushedPurified:
                        return mLocalizedMaterialPre + "%material";
                    case crushed:
                        return "Ground " + "%material";
                }
                break;
        }
        // Use Standard Localization
        return mLocalizedMaterialPre + "%material" + mLocalizedMaterialPost;
    }
}
