package gregtech.api.enums;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.interfaces.IColorModulationContainer;
import gregtech.api.interfaces.IMaterialHandler;
import gregtech.api.interfaces.ISubTagContainer;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.loaders.materialprocessing.ProcessingConfig;
import gregtech.loaders.materialprocessing.ProcessingModSupport;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.awt.*;
import java.util.*;
import java.util.List;

import static gregtech.api.enums.GT_Values.M;

public class Materials implements IColorModulationContainer, ISubTagContainer {
    private static Materials[] MATERIALS_ARRAY = new Materials[]{};
    private static final Map<String, Materials> MATERIALS_MAP = new LinkedHashMap<>();
    public static final List<IMaterialHandler> mMaterialHandlers = new ArrayList<>();

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public static Collection<Materials> VALUES = new LinkedHashSet<>();
    
    public static Materials _NULL, Empty, Hydrogen, Helium, Lithium, Beryllium, Boron, Carbon, Nitrogen, Oxygen,
            Fluorine, Neon, Sodium, Magnesium, Aluminium, Silicon
            ;

    //todo рефакторинг этого дерьма
	public static Materials Americium,Antimony,Argon,Arsenic,Barium,Bismuth,Caesium,Calcium,Cadmium,Cerium,Chlorine,Chrome,Cobalt,Copper,Deuterium,Dysprosium,
	Erbium,Europium,Gadolinium,Gallium,Gold,Holmium,Helium_3,Indium,Iridium,Iron,Lanthanum,Lead,Lutetium,Magic,Manganese,Mercury,Molybdenum,Neodymium,Neutronium,
	Nickel,Niobium,Osmium,Palladium,Phosphorus,Platinum,Plutonium,Plutonium241,Potassium,Praseodymium,Promethium,Radon,Rubidium,Samarium,Scandium,Silver,Strontium,Sulfur,
	Tantalum,Tellurium,Terbium,Thorium,Thulium,Tin,Titanium,Tritium,Tungsten,Uranium,Uranium235,Vanadium,Ytterbium,Yttrium,Zinc,Organic,AnyBronze,AnyCopper,AnyIron,AnyRubber,AnySyntheticRubber,Crystal,
	Quartz,Metal,Unknown,Cobblestone,BrickNether,TarPitch,Serpentine,Flux,OsmiumTetroxide,RubberTreeSap,AquaRegia,SolutionBlueVitriol,SolutionNickelSulfate,Signalum,Lumium,PhasedIron,PhasedGold,Endium,
	Prismarine,GraveyardDirt,Terrasteel,Teslatite,Fluix,Manasteel,Tennantite,DarkThaumium,Alfium,Ryu,Mutation,Aquamarine,Ender,ElvenElementium,EnrichedCopper,DiamondCopper,SodiumPeroxide,IridiumSodiumOxide,
	PlatinumGroupSludge,Fairy,Ludicrite,Pokefennium,Draconium,DraconiumAwakened,PurpleAlloy,InfusedTeslatite,Adamantium,Adamite,Adluorite,Agate,Alduorite,Amber,Ammonium,Amordrine,Andesite,Angmallen,Ardite,
	Aredrite,Atlarus,Bitumen,Black,Blizz,Blueschist,Bluestone,	Bloodstone,Blutonium,Carmot,Celenegil,CertusQuartz,Ceruclase,Citrine,CobaltHexahydrate,ConstructionFoam,Chert,Chimerite,Coral,CrudeOil,
	Chrysocolla,CrystalFlux,Cyanite,Dacite,DarkIron,DarkStone,Demonite,Desh,Desichalkos,Dilithium,Draconic,Drulloy,Duranium,Eclogite,ElectrumFlux,Emery,EnderiumBase,Energized,Epidote,Eximite,FierySteel,
	Firestone,Fluorite,FoolsRuby,Force,Forcicium,Forcillium,Gabbro,Glowstone,Gneiss,Graphite,Graphene,Greenschist,Greenstone,Greywacke,Haderoth,Hematite,Hepatizon,	HSLA,Ignatius,Infernal,Infuscolium,
	InfusedGold,InfusedAir,InfusedFire,InfusedEarth,InfusedWater,InfusedEntropy,InfusedOrder,InfusedVis,InfusedDull,Inolashite,Invisium,Jade,Jasper,Kalendrite,Komatiite,Lava,Lemurite,Limestone,
	Lodestone,Luminite,Magma,Mawsitsit,Mercassium,MeteoricIron,MeteoricSteel,Meteorite,Meutoite,Migmatite,Mimichite,Moonstone,Naquadah,NaquadahAlloy,NaquadahEnriched,Naquadria,Nether,NetherBrick,
	NetherQuartz,NetherStar,Nikolite,ObsidianFlux,Oilsands,Onyx,Orichalcum,Osmonium,Oureclase,Painite,Peanutwood,Petroleum,Pewter,Phoenixite,Prometheum,Quartzite,Randomite,Rhyolite,Rubracium,Sand,
	Sanguinite,Siltstone,Spinel,Starconium,Sugilite,Sunstone,Tar,Tartarite,Tapazite,Thyrium,Tourmaline,Tritanium,Turquoise,UUAmplifier,UUMatter,Void,Voidstone,Vulcanite,Vyroxeres,Wimalite,Yellorite,
	Yellorium,Zectium,Primitive,Basic,Good,Advanced,Data,Elite,Master,Ultimate,Superconductor,Infinite,Antimatter,BioFuel,Biomass,CharcoalByproducts,Cheese,Chili,Chocolate,Cluster,CoalFuel,Cocoa,Coffee,
	Creosote,Ethanol,FermentedBiomass,FishOil,Fuel,Glue,Gunpowder,FryingOilHot,Honey,Leather,LimePure,Lubricant,McGuffium239,MeatRaw,MeatCooked,Milk,Mud,Oil,Paper,Peat,Quantum,RareEarth,Red,Reinforced,
	SeedOil,SeedOilHemp,SeedOilLin,Stone,TNT,Unstable,Unstableingot,Vinegar,Wheat,WoodGas,WoodTar,WoodVinegar,AluminiumBrass,Osmiridium,Sunnarium,Endstone,Netherrack,SoulSand,Methane,CarbonDioxide,
	NobleGases,Air,LiquidAir,Almandine,Andradite,AnnealedCopper,Asbestos,Ash,BandedIron,BatteryAlloy,BlueTopaz,Bone,Brass,Bronze,BrownLimonite,Calcite,Cassiterite,CassiteriteSand,Chalcopyrite,Charcoal,
	Chromite,ChromiumDioxide,Cinnabar,Water,Clay,Coal,Cobaltite,Cooperite,Cupronickel,DarkAsh,DeepIron,Diamond,Electrum,Emerald,FreshWater,Galena,Garnierite,Glyceryl,GreenSapphire,Grossular,HolyWater,Ice,
	Ilmenite,Rutile,Bauxite,Titaniumtetrachloride,Magnesiumchloride,Invar,IronCompressed,Kanthal,Lazurite,Magnalium,Magnesite,Magnetite,Molybdenite,Nichrome,NiobiumNitride,NiobiumTitanium,NitroCarbon,
	NitrogenDioxide,Obsidian,Phosphate,PigIron,Plastic,Epoxid,Polydimethylsiloxane,Silicone,Polycaprolactam,Polytetrafluoroethylene,Powellite,Pumice,Pyrite,Pyrolusite,Pyrope,RockSalt,Rubber,RawRubber,Ruby,
	Salt,Saltpeter,SaltWater,Sapphire,Scheelite,SiliconDioxide,Snow,Sodalite,SodiumPersulfate,SodiumSulfide,HydricSulfide,OilHeavy,OilMedium,OilLight,NatruralGas,SulfuricGas,Gas,SulfuricNaphtha,SulfuricLightFuel,
	SulfuricHeavyFuel,Naphtha,LightFuel,HeavyFuel,LPG,Chlorobenzene,DilutedHydrochloricAcid,Pyrochlore,GrowthMediumRaw,GrowthMediumSterilized,FerriteMixture,NickelZincFerrite,Massicot,ArsenicTrioxide,
	CobaltOxide,Zincite,AntimonyTrioxide,CupricOxide,Ferrosilite,Magnesia,Quicklime,Potash,SodaAsh,Brick,Fireclay,BioDiesel,NitrationMixture,Glycerol,SodiumBisulfate,PolyphenyleneSulfide,Dichlorobenzene,
	Polystyrene,Styrene,Isoprene,Tetranitromethane,Ethenone,Ethane,Propane,Butane,Butene,Butadiene,RawStyreneButadieneRubber,StyreneButadieneRubber,Toluene,Epichlorohydrin,PolyvinylChloride,VinylChloride,
	SulfurDioxide,SulfurTrioxide,NitricAcid,Dimethylhydrazine,Chloramine,Dimethylamine,DinitrogenTetroxide,NitricOxide,Ammonia,Dimethyldichlorosilane,Chloromethane,PhosphorousPentoxide,Tetrafluoroethylene,
	HydrofluoricAcid,Chloroform,BisphenolA,AceticAcid,CalciumAcetateSolution,Acetone,Methanol,CarbonMonoxide,MetalMixture,Ethylene,Propene,VinylAcetate,PolyvinylAcetate,MethylAcetate,AllylChloride,
	HydrochloricAcid,HypochlorousAcid,SodiumHydroxide,Benzene,Phenol,Cumene,PhosphoricAcid,SolderingAlloy,GalliumArsenide,IndiumGalliumPhosphide,Spessartine,Sphalerite,StainlessSteel,Steel,Stibnite,SulfuricAcid,
	Tanzanite,Tetrahedrite,TinAlloy,Topaz,Tungstate,Ultimet,Uraninite,Uvarovite,VanadiumGallium,Wood,WroughtIron,Wulfenite,YellowLimonite,YttriumBariumCuprate,WoodSealed,LiveRoot,IronWood,Glass,BorosilicateGlass,
	Perlite,Borax,Lignite,Olivine,Opal,Amethyst,Redstone,Lapis,Blaze,EnderPearl,EnderEye,Flint,Diatomite,VolcanicAsh,Niter,Pyrotheum,HydratedCoal,Apatite,Alumite,Manyullyn,ShadowIron,ShadowSteel,Steeleaf,Knightmetal,
	SterlingSilver,RoseGold,BlackBronze,BismuthBronze,BlackSteel,RedSteel,BlueSteel,DamascusSteel,TungstenSteel,NitroCoalFuel,NitroFuel,AstralSilver,Midasium,Mithril,BlueAlloy,RedAlloy,CobaltBrass,TricalciumPhosphate,
	Basalt,GarnetRed,GarnetYellow,Marble,Sugar,Thaumium,Vinteum,Vis,Redrock,PotassiumFeldspar,Biotite,GraniteBlack,GraniteRed,Chrysotile,Realgar,VanadiumMagnetite,BasalticMineralSand,GraniticMineralSand,
	GarnetSand,QuartzSand,Bastnasite,Pentlandite,Spodumene,Pollucite,Tantalite,Lepidolite,Glauconite,GlauconiteSand,Vermiculite,Bentonite,FullersEarth,Pitchblende,Monazite,Malachite,Mirabilite,Mica,Trona,Barite,Gypsum,Alunite,Dolomite,
	Wollastonite,Zeolite,Kyanite,Kaolinite,Talc,Soapstone,Concrete,IronMagnetic,SteelMagnetic,NeodymiumMagnetic,TungstenCarbide,VanadiumSteel,HSSG,HSSE,HSSS,DilutedSulfuricAcid,EpoxidFiberReinforced,NitrousOxide,AntiKnock,GasolineRegular,
	GasolinePremium,RedstoneAlloy,Soularium,ConductiveIron,ElectricalSteel,EnergeticAlloy,VibrantAlloy,PulsatingIron,Enderium,DarkSteel,EndSteel,DirtyWater,DirtyWater2,

	//Deprecated
	IridiumAndSodiumOxide,Palygorskite,Adamantine,Ashes,DarkAshes,Abyssal,Adamant,AluminumBrass,Aluminum,NaturalAluminum,NaturalAluminium,Americum,Beryl,BlackGranite,CalciumCarbonate,
	CrackedLightFuel,CrackedHeavyFuel,CreosoteOil,Chromium,Diesel,Enderpearl,Endereye,EyeOfEnder,Eyeofender,Flour,Meat,Garnet,Granite,Goethite,Kalium,Lapislazuli,LapisLazuli,
	Monazit,Natrium,Mythril,NitroDiesel,Naquadriah,Obby,Peridot,Phosphorite,Quarried,Quicksilver,QuickSilver,RedRock,RefinedIron,RedGranite,Sheldonite,Soulsand,Titan,Uran,
	Wolframite,Wolframium,Wolfram,Phosphor;
    

    
    /**
     * This is the Default Material returned in case no Material has been found or a NullPointer has been inserted at a location where it shouldn't happen.
     */
    public static void genMaterials() {
        _NULL = new Materials(-1, new Color(255, 255, 255, 0), "NULL", true, Dyes._NULL, Element._NULL, MaterialsValues.NULL);
        Empty = new Materials(0, new Color(255, 255, 255, 255), "Empty", true, Dyes._NULL, Element._NULL, MaterialsValues.NOT_MATERIAL);
        Hydrogen = new Materials(1, new Color(0, 0, 255, 240), "Hydrogen", true, Dyes.dyeBlue, Element.H2, MaterialsValues.CELL, MaterialsValues.GAS).setFuel(FuelType.Gas, 4);
        Helium = new Materials(2, new Color(245, 245, 0, 240), "Helium", true, Dyes.dyeYellow, Element.He, MaterialsValues.CELL, MaterialsValues.GAS);
        Lithium = new Materials(3, new Color(97, 80, 102, 255), "Lithium", false, Dyes.dyeLightBlue, Element.Li, MaterialsValues.DUST);
        Beryllium = new Materials(4, new Color(100, 180, 100, 240), "Beryllium", false, Dyes.dyeGreen, Element.Be, MaterialsValues.DUST, MaterialsValues.DUST_IMPURE, MaterialsValues.DUST_PURE);
        Boron = new Materials(5, new Color(147, 187, 147, 240), "Boron", false, Dyes.dyeWhite, Element.B, MaterialsValues.DUST);
        Carbon = new Materials(6, new Color(20, 20, 20, 240), "Carbon", false, Dyes.dyeBlack, Element.C, MaterialsValues.DUST);
        Nitrogen = new Materials(7, new Color(0, 150, 200, 240), "Nitrogen", true, Dyes.dyeCyan, Element.N2, MaterialsValues.CELL, MaterialsValues.GAS);
        Oxygen = new Materials(8, new Color(0, 100, 200, 240), "Oxygen", true, Dyes.dyeWhite, Element.O2, MaterialsValues.CELL, MaterialsValues.GAS);
        Fluorine = new Materials(9, new Color(56, 187, 181, 240), "Fluorine", true, Dyes.dyeGreen, Element.F2, MaterialsValues.CELL, MaterialsValues.GAS);
        Neon = new Materials(10, new Color(220, 186, 105, 240), "Neon", true, Dyes.dyeGreen, Element.Ne, MaterialsValues.CELL, MaterialsValues.GAS);
        Sodium = new Materials(11, new Color(36, 64, 238, 240), "Sodium", true, Dyes.dyeGreen, Element.Na, MaterialsValues.DUST);
        Magnesium = new Materials(12, new Color(255, 200, 200, 240), "Magnesium", false, Dyes.dyePink, Element.Mg, MaterialsValues.DUST);
        Aluminium = new Materials(13, new Color(128, 200, 240, 240), "Aluminium", false, Dyes.dyeLightBlue, Element.Al, MaterialsValues.DUST).setTool(1.0f, 5, 10);
        Silicon = new Materials(14, new Color(73, 73, 95, 240), "Silicon", false, Dyes.dyeBlack, Element.Si, MaterialsValues.DUST);

		//todo НАХУЙ ЭТО УБРАТЬ
		//region Direct Elements
		Americium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 3, 200, 200, 200, 0, "Americium", "Americium", 0, 0, 1449, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Am);
		Antimony = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 2, 220, 220, 240, 0, "Antimony", "Antimony", 0, 0, 903, 0, false, false, 2, 1, 1, Dyes.dyeLightGray, Element.Sb);
		Argon = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 0, 255, 0, 240, "Argon", "Argon", 0, 0, 83, 0, false, true, 5, 1, 1, Dyes.dyeGreen, Element.Ar);
		Arsenic = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 2, 255, 255, 255, 0, "Arsenic", "Arsenic", 0, 0, 1090, 0, false, false, 3, 1, 1, Dyes.dyeOrange, Element.As);
		Barium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Barium", "Barium", 0, 0, 1000, 0, false, false, 1, 1, 1, Dyes._NULL, Element.Ba);
		Bismuth = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 64, 1, 100, 160, 160, 0, "Bismuth", "Bismuth", 0, 0, 544, 0, false, false, 2, 1, 1, Dyes.dyeCyan, Element.Bi);
		Caesium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Caesium", "Caesium", 0, 0, 301, 0, false, false, 4, 1, 1, Dyes._NULL, Element.Cs);
		Calcium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 245, 245, 0, "Calcium", "Calcium", 0, 0, 1115, 0, false, false, 4, 1, 1, Dyes.dyePink, Element.Ca);
		Cadmium = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 2, 50, 50, 60, 0, "Cadmium", "Cadmium", 0, 0, 594, 0, false, false, 3, 1, 1, Dyes.dyeGray, Element.Cd);
		Cerium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Cerium", "Cerium", 0, 0, 1068, 1068, true, false, 4, 1, 1, Dyes._NULL, Element.Ce);
		Chlorine = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 255, 255, 255, 0, "Chlorine", "Chlorine", 0, 0, 171, 0, false, false, 2, 1, 1, Dyes.dyeCyan, Element.Cl2);
		Chrome = new Materials(-1, TextureSet.SET_SHINY, 11.0F, 256, 3, 255, 230, 230, 0, "Chrome", "Chrome", 0, 0, 2180, 1700, true, false, 5, 1, 1, Dyes.dyePink, Element.Cr);
		Cobalt = new Materials(-1, TextureSet.SET_METALLIC, 8.0F, 512, 3, 80, 80, 250, 0, "Cobalt", "Cobalt", 0, 0, 1768, 0, false, false, 3, 1, 1, Dyes.dyeBlue, Element.Co);
		Copper = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 1,  255, 100, 0, 0, "Copper", "Copper", 0, 0, 1357, 0, false, false, 3, 1, 1, Dyes.dyeOrange, Element.Cu);
		Deuterium = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 255, 255, 0, 240, "Deuterium", "Deuterium", 0, 0, 14, 0, false, true, 10, 1, 1, Dyes.dyeYellow, Element.D);
		Dysprosium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Dysprosium", "Dysprosium", 0, 0, 1680, 1680, true, false, 4, 1, 1, Dyes._NULL, Element.Dy);
		Erbium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Erbium", "Erbium", 0, 0, 1802, 1802, true, false, 4, 1, 1, Dyes._NULL, Element.Er);
		Europium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Europium", "Europium", 0, 0, 1099, 1099, true, false, 4, 1, 1, Dyes._NULL, Element.Eu);
		Gadolinium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Gadolinium", "Gadolinium", 0, 0, 1585, 1585, true, false, 4, 1, 1, Dyes._NULL, Element.Gd);
		Gallium = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 64, 2, 220, 220, 255, 0, "Gallium", "Gallium", 0, 0, 302, 0, false, false, 5, 1, 1, Dyes.dyeLightGray, Element.Ga);
		Gold = new Materials(-1, TextureSet.SET_SHINY, 12.0F, 64, 2, 255, 255, 30, 0, "Gold", "Gold", 0, 0, 1337, 0, false, false, 4, 1, 1, Dyes.dyeYellow, Element.Au);
		Holmium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Holmium", "Holmium", 0, 0, 1734, 1734, true, false, 4, 1, 1, Dyes._NULL, Element.Ho);
		Helium_3 = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 255, 255, 0, 240, "Helium_3", "Helium-3", 0, 0, 1, 0, false, true, 10, 1, 1, Dyes.dyeYellow, Element.He_3);
		Indium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 64, 0, 128, 0, "Indium", "Indium", 0, 0, 429, 0, false, false, 4, 1, 1, Dyes.dyeGray, Element.In);
		Iridium = new Materials(-1, TextureSet.SET_DULL, 6.0F, 2560, 3, 240, 240, 245, 0, "Iridium", "Iridium", 0, 0, 2719, 2719, true, false, 10, 1, 1, Dyes.dyeWhite, Element.Ir);
		Iron = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 256, 2, 200, 200, 200, 0, "Iron", "Iron", 0, 0, 1811, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Fe);
		Lanthanum = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Lanthanum", "Lanthanum", 0, 0, 1193, 1193, true, false, 4, 1, 1, Dyes._NULL, Element.La);
		Lead = new Materials(-1, TextureSet.SET_DULL, 8.0F, 64, 1, 140, 100, 140, 0, "Lead", "Lead", 0, 0, 600, 0, false, false, 3, 1, 1, Dyes.dyePurple, Element.Pb);
		Lutetium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Lutetium", "Lutetium", 0, 0, 1925, 1925, true, false, 4, 1, 1, Dyes._NULL, Element.Lu);
		Magic = new Materials(-1, TextureSet.SET_SHINY, 8.0F, 5120, 5, 100, 0, 200, 0, "Magic", "Magic", 5, 32, 5000, 0, false, false, 7, 1, 1, Dyes.dyePurple, Element._NULL);
		Manganese = new Materials(-1, TextureSet.SET_DULL, 7.0F, 512, 2, 250, 250, 250, 0, "Manganese", "Manganese", 0, 0, 1519, 0, false, false, 3, 1, 1, Dyes.dyeWhite, Element.Mn);
		Mercury = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 255, 220, 220, 0, "Mercury", "Mercury", 5, 32, 234, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Hg);
		Molybdenum = new Materials(-1, TextureSet.SET_SHINY, 7.0F, 512, 2, 180, 180, 220, 0, "Molybdenum", "Molybdenum", 0, 0, 2896, 0, false, false, 1, 1, 1, Dyes.dyeBlue, Element.Mo);
		Neodymium = new Materials(-1, TextureSet.SET_METALLIC, 7.0F, 512, 2, 100, 100, 100, 0, "Neodymium", "Neodymium", 0, 0, 1297, 1297, true, false, 4, 1, 1, Dyes._NULL, Element.Nd);
		Neutronium = new Materials(-1, TextureSet.SET_DULL, 24.0F, 655360, 6, 250, 250, 250, 0, "Neutronium", "Neutronium", 0, 0, 10000, 0, false, false, 20, 1, 1, Dyes.dyeWhite,  Element._NULL);
		Nickel = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 64, 2, 200, 200, 250, 0, "Nickel", "Nickel", 0, 0, 1728, 0, false, false, 4, 1, 1, Dyes.dyeLightBlue, Element.Ni);
		Niobium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 190, 180, 200, 0, "Niobium", "Niobium", 0, 0, 2750, 2750, true, false, 5, 1, 1, Dyes._NULL, Element.Nb);
		Osmium = new Materials(-1, TextureSet.SET_METALLIC, 16.0F, 1280, 4, 50, 50, 255, 0, "Osmium", "Osmium", 0, 0, 3306, 3306, true, false, 10, 1, 1, Dyes.dyeBlue, Element.Os);
		Palladium = new Materials(-1, TextureSet.SET_SHINY, 8.0F, 512, 2, 128, 128, 128, 0, "Palladium", "Palladium", 0, 0, 1828, 1828, true, false, 4, 1, 1, Dyes.dyeGray, Element.Pd);
		Phosphorus = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 2, 255, 255, 0, 0, "Phosphorus", "Phosphorus", 0, 0, 317, 0, false, false, 2, 1, 1, Dyes.dyeYellow, Element.P);
		Platinum = new Materials(-1, TextureSet.SET_SHINY, 12.0F, 64, 2, 255, 255, 200, 0, "Platinum", "Platinum", 0, 0, 2041, 0, false, false, 6, 1, 1, Dyes.dyeOrange, Element.Pt);
		Plutonium = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 512, 3, 240, 50, 50, 0, "Plutonium", "Plutonium 239", 0, 0, 912, 0, false, false, 6, 1, 1, Dyes.dyeLime, Element.Pu);
		Plutonium241 = new Materials(-1, TextureSet.SET_SHINY, 6.0F, 512, 3, 250, 70, 70, 0, "Plutonium241", "Plutonium 241", 0, 0, 912, 0, false, false, 6, 1, 1, Dyes.dyeLime, Element.Pu_241);
		Potassium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 1, 250, 250, 250, 0, "Potassium", "Potassium", 0, 0, 336, 0, false, false, 2, 1, 1, Dyes.dyeWhite, Element.K);
		Praseodymium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Praseodymium", "Praseodymium", 0, 0, 1208, 1208, true, false, 4, 1, 1, Dyes._NULL, Element.Pr);
		Promethium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Promethium", "Promethium", 0, 0, 1315, 1315, true, false, 4, 1, 1, Dyes._NULL, Element.Pm);
		Radon = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 255, 0, 255, 240, "Radon", "Radon", 0, 0, 202, 0, false, true, 5, 1, 1, Dyes.dyePurple, Element.Rn);
		Rubidium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 240, 30, 30, 0, "Rubidium", "Rubidium", 0, 0, 312, 0, false, false, 4, 1, 1, Dyes.dyeRed, Element.Rb);
		Samarium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Samarium", "Samarium", 0, 0, 1345, 1345, true, false, 4, 1, 1, Dyes._NULL, Element.Sm);
		Scandium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Scandium", "Scandium", 0, 0, 1814, 1814, true, false, 2, 1, 1, Dyes.dyeYellow, Element.Sc);
		Silver = new Materials(-1, TextureSet.SET_SHINY, 10.0F, 64, 2, 220, 220, 255, 0, "Silver", "Silver", 0, 0, 1234, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Ag);
		Sodium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 0, 0, 150, 0, "Sodium", "Sodium", 0, 0, 370, 0, false, false, 1, 1, 1, Dyes.dyeBlue, Element.Na);
		Strontium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 200, 200, 200, 0, "Strontium", "Strontium", 0, 0, 1050, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, Element.Sr);
		Sulfur = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 2, 200, 200, 0, 0, "Sulfur", "Sulfur", 0, 0, 388, 0, false, false, 2, 1, 1, Dyes.dyeYellow, Element.S);
		Tantalum = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Tantalum", "Tantalum", 0, 0, 3290, 0, false, false, 4, 1, 1, Dyes._NULL, Element.Ta);
		Tellurium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Tellurium", "Tellurium", 0, 0, 722, 0, false, false, 4, 1, 1, Dyes.dyeGray, Element.Te);
		Terbium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Terbium", "Terbium", 0, 0, 1629, 1629, true, false, 4, 1, 1, Dyes._NULL, Element.Tb);
		Thorium = new Materials(-1, TextureSet.SET_SHINY, 6.0F, 512, 2, 0, 30, 0, 0, "Thorium", "Thorium", 0, 0, 2115, 0, false, false, 4, 1, 1, Dyes.dyeBlack, Element.Th);
		Thulium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 255, 255, 0, "Thulium", "Thulium", 0, 0, 1818, 1818, true, false, 4, 1, 1, Dyes._NULL, Element.Tm);
		Tin = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, 220, 220, 220, 0, "Tin", "Tin", 0, 0, 505, 505, false, false, 3, 1, 1, Dyes.dyeWhite, Element.Sn);
		Titanium = new Materials(-1, TextureSet.SET_METALLIC, 7.0F, 1600, 3, 220, 160, 240, 0, "Titanium", "Titanium", 0, 0, 1941, 1940, true, false, 5, 1, 1, Dyes.dyePurple, Element.Ti);
		Tritium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 255, 0, 0, 240, "Tritium", "Tritium", 0, 0, 14, 0, false, true, 10, 1, 1, Dyes.dyeRed, Element.T);
		Tungsten = new Materials(-1, TextureSet.SET_METALLIC, 7.0F, 2560, 3, 50, 50, 50, 0, "Tungsten", "Tungsten", 0, 0, 3695, 3000, true, false, 4, 1, 1, Dyes.dyeBlack, Element.W);
		Uranium = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 512, 3, 50, 240, 50, 0, "Uranium", "Uranium 238", 0, 0, 1405, 0, false, false, 4, 1, 1, Dyes.dyeGreen, Element.U);
		Uranium235 = new Materials(-1, TextureSet.SET_SHINY, 6.0F, 512, 3, 70, 250, 70, 0, "Uranium235", "Uranium 235", 0, 0, 1405, 0, false, false, 4, 1, 1, Dyes.dyeGreen, Element.U_235);
		Vanadium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 50, 50, 50, 0, "Vanadium", "Vanadium", 0, 0, 2183, 2183, true, false, 2, 1, 1, Dyes.dyeBlack, Element.V);
		Ytterbium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2,  255, 255, 255, 0, "Ytterbium", "Ytterbium", 0, 0, 1097, 1097, true, false, 4, 1, 1, Dyes._NULL, Element.Yb);
		Yttrium = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, 220, 250, 220, 0, "Yttrium", "Yttrium", 0, 0, 1799, 1799, true, false, 4, 1, 1, Dyes._NULL, Element.Y);
		Zinc = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 1, 250, 240, 240, 0, "Zinc", "Zinc", 0, 0, 692, 0, false, false, 2, 1, 1, Dyes.dyeWhite, Element.Zn);

		/**
		 * The "Random Material" ones.
		 */
		Organic = new Materials(-1, TextureSet.SET_LEAF, 1.0F, 0, 1, false, "Organic", "Organic");
		AnyBronze = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyBronze", "AnyBronze");
		AnyCopper = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyCopper", "AnyCopper");
		AnyIron = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyIron", "AnyIron");
		AnyRubber = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyRubber", "AnyRubber");
		AnySyntheticRubber = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnySyntheticRubber", "AnySyntheticRubber");
		Crystal = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "Crystal", "Crystal");
		Quartz = new Materials(-1, TextureSet.SET_QUARTZ, 1.0F, 0, 2, false, "Quartz", "Quartz");
		Metal = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, false, "Metal", "Metal");
		Unknown = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 2, false, "Unknown", "Unknown");
		Cobblestone = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, false, "Cobblestone", "Cobblestone");
		BrickNether = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, false, "BrickNether", "BrickNether");

		/**
		 * The "I don't care" Section, everything I don't want to do anything with right now, is right here. Just to make the Material Finder shut up about them.
		 * But I do see potential uses in some of these Materials.
		 */
		Serpentine = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Serpentine", "Serpentine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Flux = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Flux", "Flux", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		//RedstoneAlloy = new Materials(-1, TextureSet.SET_NONE, 	1.0F, 0, 2, 1, 255, 255, 255, 0, "RedstoneAlloy", "Redstone Alloy", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		OsmiumTetroxide = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "OsmiumTetroxide", "Osmium Tetroxide", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		RubberTreeSap = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "RubberTreeSap", "Rubber Tree Sap", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		AquaRegia = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "AquaRegia", "Aqua Regia", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		SolutionBlueVitriol = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "SolutionBlueVitriol", "Blue Vitriol Solution", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		SolutionNickelSulfate = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "SolutionNickelSulfate", "Nickel Sulfate Solution", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Signalum = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Signalum", "Signalum", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Lumium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Lumium", "Lumium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		PhasedIron = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "PhasedIron", "Phased Iron", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		PhasedGold = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "PhasedGold", "Phased Gold", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Endium = new Materials(770, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2, 165, 220, 250, 0, "Endium", "Endium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Prismarine = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 4, 255, 255, 255, 0, "Prismarine", "Prismarine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		GraveyardDirt = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "GraveyardDirt", "Graveyard Dirt", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Terrasteel = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Terrasteel", "Terrasteel", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Teslatite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 60, 180, 200, 0, "Teslatite", "Teslatite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Fluix = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 4, 255, 255, 255, 0, "Fluix", "Fluix", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Manasteel = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Manasteel", "Manasteel", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Tennantite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Tennantite", "Tennantite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		DarkThaumium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "DarkThaumium", "Dark Thaumium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Alfium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Alfium", "Alfium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Ryu = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Ryu", "Ryu", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Mutation = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Mutation", "Mutation", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Aquamarine = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 4, 255, 255, 255, 0, "Aquamarine", "Aquamarine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Ender = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Ender", "Ender", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		ElvenElementium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "ElvenElementium", "Elven Elementium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		EnrichedCopper = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "EnrichedCopper", "Enriched Copper", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		DiamondCopper = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "DiamondCopper", "Diamond Copper", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		SodiumPeroxide = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "SodiumPeroxide", "Sodium Peroxide", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		IridiumSodiumOxide = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "IridiumSodiumOxide", "Iridium Sodium Oxide", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		PlatinumGroupSludge = new Materials(241, TextureSet.SET_POWDER, 1.0F, 0, 2, 1, 0, 30, 0, 0, "PlatinumGroupSludge", "Platinum Group Sludge", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Fairy = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Fairy", "Fairy", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Ludicrite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Ludicrite", "Ludicrite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Pokefennium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Pokefennium", "Pokefennium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Draconium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Draconium", "Draconium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		DraconiumAwakened = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "DraconiumAwakened", "Awakened Draconium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		PurpleAlloy = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 100, 180, 255, 0, "PurpleAlloy", "Purple Alloy", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		InfusedTeslatite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 100, 180, 255, 0, "InfusedTeslatite", "Infused Teslatite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);

		/**
		 * Unknown Material Components. Dead End Section.
		 */
		Adamantium = new Materials(319, TextureSet.SET_SHINY, 10.0F, 5120, 5, 1 | 2 | 64 | 128, 255, 255, 255, 0, "Adamantium", "Adamantium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Adamite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 3, 1, 255, 255, 255, 0, "Adamite", "Adamite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Adluorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 8, 255, 255, 255, 0, "Adluorite", "Adluorite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Agate = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Agate", "Agate", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Alduorite = new Materials(485, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 16, 159, 180, 180, 0, "Alduorite", "Alduorite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Amber = new Materials(514, TextureSet.SET_RUBY, 4.0F, 128, 2, 1 | 4 | 8 | 64, 255, 128, 0, 127, "Amber", "Amber", 5, 3, -1, 0, false, true, 1, 1, 1, Dyes.dyeOrange);
		Ammonium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Ammonium", "Ammonium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Amordrine = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 2, 1 | 2 | 8 | 16 | 64, 255, 255, 255, 0, "Amordrine", "Amordrine", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Andesite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Andesite", "Andesite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Angmallen = new Materials(958, TextureSet.SET_METALLIC, 10.0F, 128, 2, 1 | 2 | 8 | 16 | 64, 215, 225, 138, 0, "Angmallen", "Angmallen", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Ardite = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 2, 1 | 2 | 8 | 64, 255, 0, 0, 0, "Ardite", "Ardite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Aredrite = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 2, 1 | 2 | 64, 255, 0, 0, 0, "Aredrite", "Aredrite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Atlarus = new Materials(965, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 8 | 64, 255, 255, 255, 0, "Atlarus", "Atlarus", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Bitumen = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 8, 255, 255, 255, 0, "Bitumen", "Bitumen", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Black = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 0, 0, 0, 0, "Black", "Black", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlack);
		Blizz = new Materials(851, TextureSet.SET_SHINY, 1.0F, 0, 2, 1, 220, 233, 255, 0, "Blizz", "Blizz", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Blueschist = new Materials(852, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Blueschist", "Blueschist", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeLightBlue);
		Bluestone = new Materials(-1/*813*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Bluestone", "Bluestone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue);
		Bloodstone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Bloodstone", "Bloodstone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed);
		Blutonium = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2 | 8, 0, 0, 255, 0, "Blutonium", "Blutonium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue);
		Carmot = new Materials(962, TextureSet.SET_METALLIC, 16.0F, 128, 1, 1 | 2 | 8 | 64, 217, 205, 140, 0, "Carmot", "Carmot", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Celenegil = new Materials(964, TextureSet.SET_METALLIC, 10.0F, 4096, 2, 1 | 2 | 8 | 16 | 64, 148, 204, 72, 0, "Celenegil", "Celenegil", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		CertusQuartz = new Materials(516, TextureSet.SET_QUARTZ, 5.0F, 32, 1, 1 | 4 | 8 | 64, 210, 210, 230, 0, "CertusQuartz", "Certus Quartz", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeLightGray);
		Ceruclase = new Materials(952, TextureSet.SET_METALLIC, 6.0F, 1280, 2, 1 | 2 | 8, 140, 189, 208, 0, "Ceruclase", "Ceruclase", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Citrine = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Citrine", "Citrine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		CobaltHexahydrate = new Materials(-1/*853*/, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 16, 80, 80, 250, 0, "CobaltHexahydrate", "Cobalt Hexahydrate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue);
		ConstructionFoam = new Materials(854, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 16, 128, 128, 128, 0, "ConstructionFoam", "Construction Foam", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		Chert = new Materials(857, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Chert", "Chert", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
		Chimerite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Chimerite", "Chimerite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Coral = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 128, 255, 0, "Coral", "Coral", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		CrudeOil = new Materials(-1/*858*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 10, 10, 10, 0, "CrudeOil", "Crude Oil", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Chrysocolla = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Chrysocolla", "Chrysocolla", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		CrystalFlux = new Materials(-1, TextureSet.SET_QUARTZ, 1.0F, 0, 3, 1 | 4, 100, 50, 100, 0, "CrystalFlux", "Flux Crystal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Cyanite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Cyanite", "Cyanite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan);
		Dacite = new Materials(859, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Dacite", "Dacite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeLightGray);
		DarkIron = new Materials(342, TextureSet.SET_DULL, 7.0F, 384, 3, 1 | 2 | 64, 55, 40, 60, 0, "DarkIron", "Dark Iron", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyePurple);
		DarkStone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "DarkStone", "Dark Stone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlack);
		Demonite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Demonite", "Demonite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed);
		Desh = new Materials(884, TextureSet.SET_DULL, 1.0F, 1280, 3, 1 | 2 | 8 | 64 | 128, 40, 40, 40, 0, "Desh", "Desh", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Desichalkos = new Materials(-1, TextureSet.SET_NONE, 6.0F, 1280, 3, 1 | 2 | 8 | 16 | 64, 255, 255, 255, 0, "Desichalkos", "Desichalkos", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Dilithium = new Materials(515, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 16, 255, 250, 250, 127, "Dilithium", "Dilithium", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeWhite);
		Draconic = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Draconic", "Draconic", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		Drulloy = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 16, 255, 255, 255, 0, "Drulloy", "Drulloy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		Duranium = new Materials(328, TextureSet.SET_METALLIC, 16.0F, 5120, 5, 1 | 2 | 64, 255, 255, 255, 0, "Duranium", "Duranium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Eclogite = new Materials(860, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Eclogite", "Eclogite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		ElectrumFlux = new Materials(320, TextureSet.SET_SHINY, 3.0F, 256, 3, 1 | 2 | 128, 255, 255, 120, 0, "ElectrumFlux", "Fluxed Electrum", 0, 0, 9000, 9000, true, false, 1, 1, 1, Dyes.dyeYellow);
		Emery = new Materials(-1/*861*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Emery", "Emery", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		EnderiumBase = new Materials(381, TextureSet.SET_DULL, 3.0F, 256, 3, 1 | 2 | 128, 72, 119, 153, 0, "EnderiumBase", "Enderium Base", 0, 0, 3600, 3600, true, false, 1, 1, 1, Dyes.dyeGreen);
		Energized = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "Energized", "Energized", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Epidote = new Materials(862, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Epidote", "Epidote", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
		Eximite = new Materials(959, TextureSet.SET_METALLIC, 5.0F, 2560, 3, 1 | 2 | 8 | 64, 124, 90, 150, 0, "Eximite", "Eximite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		FierySteel = new Materials(346, TextureSet.SET_FIERY, 8.0F, 256, 3, 1 | 2 | 16 | 64 | 128, 64, 0, 0, 0, "FierySteel", "Fiery Steel", 5, 2048, 1811, 1000, true, false, 1, 1, 1, Dyes.dyeRed);
		Firestone = new Materials(347, TextureSet.SET_QUARTZ, 6.0F, 1280, 3, 1 | 4 | 8 | 64, 200, 20, 0, 0, "Firestone", "Firestone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed);
		Fluorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Fluorite", "Fluorite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
		FoolsRuby = new Materials(512, TextureSet.SET_RUBY, 1.0F, 0, 2, 1 | 4 | 8, 255, 100, 100, 127, "FoolsRuby", "Ruby", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeRed);
		Force = new Materials(521, TextureSet.SET_DIAMOND, 10.0F, 128, 3, 1 | 2 | 4 | 8 | 64 | 128, 255, 255, 0, 0, "Force", "Force", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Forcicium = new Materials(-1/*518*/, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 16, 50, 50, 70, 0, "Forcicium", "Forcicium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
		Forcillium = new Materials(-1/*519*/, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 16, 50, 50, 70, 0, "Forcillium", "Forcillium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
		Gabbro = new Materials(863, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Gabbro", "Gabbro", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
		Glowstone = new Materials(811, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 16, 255, 255, 0, 0, "Glowstone", "Glowstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Gneiss = new Materials(864, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Gneiss", "Gneiss", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
		Graphite = new Materials(865, TextureSet.SET_DULL, 5.0F, 32, 2, 1 | 8 | 16 | 64, 128, 128, 128, 0, "Graphite", "Graphite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGray);
		Graphene = new Materials(819, TextureSet.SET_DULL, 6.0F, 32, 1, 1 | 64, 128, 128, 128, 0, "Graphene", "Graphene", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGray);
		Greenschist = new Materials(866, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Greenschist", "Green Schist", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
		Greenstone = new Materials(-1/*867*/, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Greenstone", "Greenstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
		Greywacke = new Materials(868, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Greywacke", "Greywacke", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		Haderoth = new Materials(963, TextureSet.SET_METALLIC, 10.0F, 3200, 3, 1 | 2 | 8 | 16 | 64, 119, 52, 30, 0, "Haderoth", "Haderoth", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Hematite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Hematite", "Hematite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Hepatizon = new Materials(957, TextureSet.SET_METALLIC, 12.0F, 128, 2, 1 | 2 | 8 | 16 | 64, 117, 94, 117, 0, "Hepatizon", "Hepatizon", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		HSLA = new Materials(322, TextureSet.SET_METALLIC, 6.0F, 500, 2, 1 | 2 | 64 | 128, 128, 128, 128, 0, "HSLA", "HSLA Steel", 0, 0, 1811, 1000, true, false, 3, 1, 1, Dyes._NULL);
		Ignatius = new Materials(950, TextureSet.SET_METALLIC, 12.0F, 512, 2, 1 | 2 | 16, 255, 169, 83, 0, "Ignatius", "Ignatius", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Infernal = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 255, 255, 255, 0, "Infernal", "Infernal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Infuscolium = new Materials(490, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 8 | 16 | 64, 146, 33, 86, 0, "Infuscolium", "Infuscolium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		InfusedGold = new Materials(-1/*323*/, TextureSet.SET_SHINY, 12.0F, 64, 3, 1 | 2 | 8 | 64 | 128, 255, 200, 60, 0, "InfusedGold", "Infused Gold", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		InfusedAir = new Materials(540, TextureSet.SET_SHARDS, 8.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 255, 255, 0, 0, "InfusedAir", "Aer", 5, 160, -1, 0, false, true, 3, 1, 1, Dyes.dyeYellow);
		InfusedFire = new Materials(541, TextureSet.SET_SHARDS, 8.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 255, 0, 0, 0, "InfusedFire", "Ignis", 5, 320, -1, 0, false, true, 3, 1, 1, Dyes.dyeRed);
		InfusedEarth = new Materials(542, TextureSet.SET_SHARDS, 8.0F, 256, 3, 1 | 4 | 8 | 64 | 128, 0, 255, 0, 0, "InfusedEarth", "Terra", 5, 160, -1, 0, false, true, 3, 1, 1, Dyes.dyeGreen);
		InfusedWater = new Materials(543, TextureSet.SET_SHARDS, 8.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 0, 0, 255, 0, "InfusedWater", "Aqua", 5, 160, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlue);
		InfusedEntropy = new Materials(544, TextureSet.SET_SHARDS, 32.0F, 64, 4, 1 | 4 | 8 | 64 | 128, 62, 62, 62, 0, "InfusedEntropy", "Perditio", 5, 320, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlack);
		InfusedOrder = new Materials(545, TextureSet.SET_SHARDS, 8.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 252, 252, 252, 0, "InfusedOrder", "Ordo", 5, 240, -1, 0, false, true, 3, 1, 1, Dyes.dyeWhite);
		InfusedVis = new Materials(-1, TextureSet.SET_SHARDS, 8.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 255, 0, 255, 0, "InfusedVis", "Auram", 5, 240, -1, 0, false, true, 3, 1, 1, Dyes.dyePurple);
		InfusedDull = new Materials(-1, TextureSet.SET_SHARDS, 32.0F, 64, 3, 1 | 4 | 8 | 64 | 128, 100, 100, 100, 0, "InfusedDull", "Vacuus", 5, 160, -1, 0, false, true, 3, 1, 1, Dyes.dyeLightGray);
		Inolashite = new Materials(954, TextureSet.SET_NONE, 8.0F, 2304, 3, 1 | 2 | 8 | 16 | 64, 148, 216, 187, 0, "Inolashite", "Inolashite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Invisium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Invisium", "Invisium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Jade = new Materials(-1/*537*/, TextureSet.SET_SHINY, 1.0F, 0, 2, 1, 0, 100, 0, 0, "Jade", "Jade", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyeGreen);
		Jasper = new Materials(511, TextureSet.SET_EMERALD, 1.0F, 0, 2, 1 | 4, 200, 80, 80, 100, "Jasper", "Jasper", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeRed);
		Kalendrite = new Materials(953, TextureSet.SET_METALLIC, 5.0F, 2560, 3, 1 | 2 | 16, 170, 91, 189, 0, "Kalendrite", "Kalendrite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Komatiite = new Materials(869, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Komatiite", "Komatiite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Lava = new Materials(700, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 64, 0, 0, "Lava", "Lava", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		Lemurite = new Materials(486, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 16, 219, 219, 219, 0, "Lemurite", "Lemurite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Limestone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Limestone", "Limestone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Lodestone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Lodestone", "Lodestone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Luminite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Luminite", "Luminite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
		Magma = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 64, 0, 0, "Magma", "Magma", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		Mawsitsit = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Mawsitsit", "Mawsitsit", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Mercassium = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 1, 1 | 2 | 64, 255, 255, 255, 0, "Mercassium", "Mercassium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		MeteoricIron = new Materials(340, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 8 | 64, 100, 50, 80, 0, "MeteoricIron", "Meteoric Iron", 0, 0, 1811, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		MeteoricSteel = new Materials(341, TextureSet.SET_METALLIC, 6.0F, 768, 2, 1 | 2 | 64, 50, 25, 40, 0, "MeteoricSteel", "Meteoric Steel", 0, 0, 1811, 1000, true, false, 1, 1, 1, Dyes.dyeGray);
		Meteorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 80, 35, 60, 0, "Meteorite", "Meteorite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple);
		Meutoite = new Materials(487, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8 | 16, 95, 82, 105, 0, "Meutoite", "Meutoite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Migmatite = new Materials(872, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Migmatite", "Migmatite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Mimichite = new Materials(-1, TextureSet.SET_GEM_VERTICAL, 1.0F, 0, 1, 1 | 4, 255, 255, 255, 0, "Mimichite", "Mimichite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Moonstone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 8, 255, 255, 255, 0, "Moonstone", "Moonstone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
		Naquadah = new Materials(324, TextureSet.SET_METALLIC, 6.0F, 1280, 4, 1 | 2 | 8 | 16 | 64, 50, 50, 50, 0, "Naquadah", "Naquadah", 0, 0, 5400, 5400, true, false, 10, 1, 1, Dyes.dyeBlack);
		NaquadahAlloy = new Materials(325, TextureSet.SET_METALLIC, 8.0F, 5120, 5, 1 | 2 | 64 | 128, 40, 40, 40, 0, "NaquadahAlloy", "Naquadah Alloy", 0, 0, 7200, 7200, true, false, 10, 1, 1, Dyes.dyeBlack);
		NaquadahEnriched = new Materials(326, TextureSet.SET_METALLIC, 6.0F, 1280, 4, 1 | 2 | 8 | 16 | 64, 50, 50, 50, 0, "NaquadahEnriched", "Enriched Naquadah", 0, 0, 4500, 4500, true, false, 15, 1, 1, Dyes.dyeBlack);
		Naquadria = new Materials(327, TextureSet.SET_SHINY, 1.0F, 512, 4, 1 | 2 | 8 | 16 | 64, 30, 30, 30, 0, "Naquadria", "Naquadria", 0, 0, 9000, 9000, true, false, 20, 1, 1, Dyes.dyeBlack);
		Nether = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Nether", "Nether", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		NetherBrick = new Materials(814, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 100, 0, 0, 0, "NetherBrick", "Nether Brick", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		NetherQuartz = new Materials(522, TextureSet.SET_QUARTZ, 1.0F, 32, 1, 1 | 4 | 8 | 64, 230, 210, 210, 0, "NetherQuartz", "Nether Quartz", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite);
		NetherStar = new Materials(506, TextureSet.SET_NETHERSTAR, 1.0F, 5120, 4, 1 | 4 | 64, 255, 255, 255, 0, "NetherStar", "Nether Star", 5, 50000, -1, 0, false, false, 15, 1, 1, Dyes.dyeWhite);
		Nikolite = new Materials(812, TextureSet.SET_SHINY, 1.0F, 0, 1, 1, 60, 180, 200, 0, "Nikolite", "Nikolite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan);
		ObsidianFlux = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 80, 50, 100, 0, "ObsidianFlux", "Fluxed Obsidian", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple);
		Oilsands = new Materials(878, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 8, 10, 10, 10, 0, "Oilsands", "Oilsands", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Onyx = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Onyx", "Onyx", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Orichalcum = new Materials(966, TextureSet.SET_METALLIC, 4.5F, 3456, 3, 1 | 2 | 8 | 64, 84, 122, 56, 0, "Orichalcum", "Orichalcum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Osmonium = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 1, 1 | 2 | 64, 255, 255, 255, 0, "Osmonium", "Osmonium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue);
		Oureclase = new Materials(961, TextureSet.SET_METALLIC, 6.0F, 1920, 3, 1 | 2 | 8 | 64, 183, 98, 21, 0, "Oureclase", "Oureclase", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Painite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Painite", "Painite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Peanutwood = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Peanutwood", "Peanut Wood", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Petroleum = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Petroleum", "Petroleum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Pewter = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Pewter", "Pewter", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Phoenixite = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 1, 1 | 2 | 64, 255, 255, 255, 0, "Phoenixite", "Phoenixite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Prometheum = new Materials(960, TextureSet.SET_METALLIC, 8.0F, 512, 1, 1 | 2 | 8 | 64, 90, 129, 86, 0, "Prometheum", "Prometheum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Quartzite = new Materials(523, TextureSet.SET_QUARTZ, 1.0F, 0, 1, 1 | 4 | 8, 210, 230, 210, 0, "Quartzite", "Quartzite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
		Randomite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Randomite", "Randomite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Rhyolite = new Materials(875, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Rhyolite", "Rhyolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Rubracium = new Materials(488, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8 | 16, 151, 45, 45, 0, "Rubracium", "Rubracium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Sand = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Sand", "Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Sanguinite = new Materials(955, TextureSet.SET_METALLIC, 3.0F, 4480, 4, 1 | 2 | 8, 185, 0, 0, 0, "Sanguinite", "Sanguinite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Siltstone = new Materials(876, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Siltstone", "Siltstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Spinel = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Spinel", "Spinel", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Starconium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 2, 255, 255, 255, 0, "Starconium", "Starconium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Sugilite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Sugilite", "Sugilite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Sunstone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 8, 255, 255, 255, 0, "Sunstone", "Sunstone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Tar = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 10, 10, 10, 0, "Tar", "Tar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Tartarite = new Materials(956, TextureSet.SET_METALLIC, 20.0F, 7680, 5, 1 | 2 | 8 | 16, 255, 118, 60, 0, "Tartarite", "Tartarite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Tapazite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Tapazite", "Tapazite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
		Thyrium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 2, 255, 255, 255, 0, "Thyrium", "Thyrium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Tourmaline = new Materials(-1, TextureSet.SET_RUBY, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Tourmaline", "Tourmaline", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		Tritanium = new Materials(329, TextureSet.SET_METALLIC, 20.0F, 10240, 6, 1 | 2 | 64, 255, 255, 255, 0, "Tritanium", "Tritanium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
		Turquoise = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Turquoise", "Turquoise", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
		UUAmplifier = new Materials(721, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 96, 0, 128, 0, "UUAmplifier", "UU-Amplifier", 0, 0, -1, 0, false, false, 10, 1, 1, Dyes.dyePink);
		UUMatter = new Materials(703, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 128, 0, 196, 0, "UUMatter", "UU-Matter", 0, 0, -1, 0, false, false, 10, 1, 1, Dyes.dyePink);
		Void = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 200, "Void", "Void", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes._NULL);
		Voidstone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 200, "Voidstone", "Voidstone", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes._NULL);
		Vulcanite = new Materials(489, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 8 | 16 | 64, 255, 132, 72, 0, "Vulcanite", "Vulcanite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Vyroxeres = new Materials(951, TextureSet.SET_METALLIC, 9.0F, 768, 3, 1 | 2 | 8 | 64, 85, 224, 1, 0, "Vyroxeres", "Vyroxeres", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
		Wimalite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 8, 255, 255, 255, 0, "Wimalite", "Wimalite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Yellorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 8, 255, 255, 255, 0, "Yellorite", "Yellorite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Yellorium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Yellorium", "Yellorium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
		Zectium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 2, 255, 255, 255, 0, "Zectium", "Zectium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlack);

		/**
		 * Circuitry, Batteries and other Technical things
		 */
		Primitive = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Primitive", "Primitive", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Basic = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Basic", "Basic", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Good = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Good", "Good", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Advanced = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Advanced", "Advanced", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Data = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Data", "Data", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Elite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Elite", "Elite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Master = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Master", "Master", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Ultimate = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Ultimate", "Ultimate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Superconductor = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Superconductor", "Superconductor", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		Infinite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Infinite", "Infinite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);

		/**
		 * Not possible to determine exact Components
		 */
		Antimatter = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Antimatter", "Antimatter", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
		BioFuel = new Materials(705, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 128, 0, 0, "BioFuel", "Biofuel", 0, 6, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		Biomass = new Materials(704, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 255, 0, 0, "Biomass", "Biomass", 3, 8, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
		Cheese = new Materials(894, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 255, 255, 0, 0, "Cheese", "Cheese", 0, 0, 320, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Chili = new Materials(895, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 200, 0, 0, 0, "Chili", "Chili", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		Chocolate = new Materials(886, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 190, 95, 0, 0, "Chocolate", "Chocolate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Cluster = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 127, "Cluster", "Cluster", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeWhite);
		CoalFuel = new Materials(710, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 50, 50, 70, 0, "CoalFuel", "Coalfuel", 0, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Cocoa = new Materials(887, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 190, 95, 0, 0, "Cocoa", "Cocoa", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Coffee = new Materials(888, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 150, 75, 0, 0, "Coffee", "Coffee", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Creosote = new Materials(712, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 128, 64, 0, 0, "Creosote", "Creosote", 3, 8, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Ethanol = new Materials(706, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 128, 0, 0, "Ethanol", "Ethanol", 0, 148, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		FishOil = new Materials(711, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 196, 0, 0, "FishOil", "Fish Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Fuel = new Materials(708, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "Fuel", "Diesel", 0, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Glue = new Materials(726, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 196, 0, 0, "Glue", "Glue", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		Gunpowder = new Materials(800, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 128, 128, 128, 0, "Gunpowder", "Gunpowder", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		FryingOilHot = new Materials(727, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 196, 0, 0, "FryingOilHot", "Hot Frying Oil", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		Honey = new Materials(725, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 210, 200, 0, 0, "Honey", "Honey", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Leather = new Materials(-1, TextureSet.SET_ROUGH, 1.0F, 0, 0, 1, 150, 150, 80, 127, "Leather", "Leather", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		LimePure = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "LimePure", "Pure Lime", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
		Lubricant = new Materials(724, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 196, 0, 0, "Lubricant", "Lubricant", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
		McGuffium239 = new Materials(999, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 50, 150, 0, "McGuffium239", "Mc Guffium 239", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
		MeatRaw = new Materials(892, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 255, 100, 100, 0, "MeatRaw", "Raw Meat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
		MeatCooked = new Materials(893, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 150, 60, 20, 0, "MeatCooked", "Cooked Meat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
		Milk = new Materials(885, TextureSet.SET_FINE, 1.0F, 0, 0, 1 | 16, 254, 254, 254, 0, "Milk", "Milk", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
		Mud = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Mud", "Mud", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Oil = new Materials(707, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "Oil", "Oil", 3, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Paper = new Materials(879, TextureSet.SET_PAPER, 1.0F, 0, 0, 1, 250, 250, 250, 0, "Paper", "Paper", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
		Peat = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Peat", "Peat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
		Quantum = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Quantum", "Quantum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
		RareEarth = new Materials(891, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 128, 128, 100, 0, "RareEarth", "Rare Earth", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		Red = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 0, 0, 0, "Red", "Red", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		Reinforced = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Reinforced", "Reinforced", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
		SeedOil = new Materials(713, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOil", "Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
		SeedOilHemp = new Materials(722, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOilHemp", "Hemp Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
		SeedOilLin = new Materials(723, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOilLin", "Lin Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
		Stone = new Materials(299, TextureSet.SET_ROUGH, 4.0F, 32, 1, 1 | 64 | 128, 205, 205, 205, 0, "Stone", "Stone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		TNT = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "TNT", "TNT", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
		Unstable = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 4, 0, 255, 255, 255, 127, "Unstable", "Unstable", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeWhite);
		Unstableingot = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 4, 0, 255, 255, 255, 127, "Unstableingot", "Unstable", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeWhite);
		Wheat = new Materials(881, TextureSet.SET_POWDER, 1.0F, 0, 0, 1, 255, 255, 196, 0, "Wheat", "Wheat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);

		/**
		 * TODO: This
		 */
		AluminiumBrass = new Materials(-1, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 64, 255, 255, 255, 0, "AluminiumBrass", "Aluminium Brass", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		Osmiridium = new Materials(317, TextureSet.SET_METALLIC, 7.0F, 1600, 3, 1 | 2 | 64 | 128, 100, 100, 255, 0, "Osmiridium", "Osmiridium", 0, 0, 3333, 2500, true, false, 1, 1, 1, Dyes.dyeLightBlue);
		Sunnarium = new Materials(318, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 2 | 64 | 128, 255, 255, 0, 0, "Sunnarium", "Sunnarium", 0, 0, 4200, 4200, true, false, 1, 1, 1, Dyes.dyeYellow);
		Endstone = new Materials(808, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Endstone", "Endstone", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeYellow);
		Netherrack = new Materials(807, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 200, 0, 0, 0, "Netherrack", "Netherrack", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeRed);
		SoulSand = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 255, 255, 255, 0, "Soulsand", "Soulsand", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeBrown);

		/**
		 * First Degree Compounds
		 */
		Methane = new Materials(715, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "Methane", "Methane", 1, 104, -1, 0, false, false, 3, 1, 1, Dyes.dyeMagenta, 1, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 4)));
		CarbonDioxide = new Materials(497, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "CarbonDioxide", "Carbon Dioxide", 0, 0, 25, 1, false, true, 1, 1, 1, Dyes.dyeLightBlue, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 2))).setHasCorrespondingGas(true);
		NobleGases = new Materials(496, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "NobleGases", "Noble Gases", 0, 0, 4, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(CarbonDioxide, 21), new MaterialStack(Helium, 9), new MaterialStack(Methane, 3), new MaterialStack(Deuterium, 1))).setHasCorrespondingFluid(true).setLiquidTemperature(79);
		Air = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "Air", "Air", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 0, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1), new MaterialStack(NobleGases, 1)));
		LiquidAir = new Materials(495, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "LiquidAir", "Liquid Air", 0, 0, 4, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1), new MaterialStack(NobleGases, 1))).setHasCorrespondingFluid(true).setLiquidTemperature(79);
		Almandine = new Materials(820, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 255, 0, 0, 0, "Almandine", "Almandine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Iron, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		Andradite = new Materials(821, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 150, 120, 0, 0, "Andradite", "Andradite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Iron, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		AnnealedCopper = new Materials(345, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2 | 128, 255, 120, 20, 0, "AnnealedCopper", "Annealed Copper", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1)));
		Asbestos = new Materials(946, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 230, 230, 230, 0, "Asbestos", "Asbestos", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Mg3Si2O5(OH)4
		Ash = new Materials(815, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 150, 150, 150, 0, "Ash", "Ashes", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
		BandedIron = new Materials(917, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 145, 90, 90, 0, "BandedIron", "Banded Iron", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Oxygen, 3)));
		BatteryAlloy = new Materials(315, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 156, 124, 160, 0, "BatteryAlloy", "Battery Alloy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Lead, 4), new MaterialStack(Antimony, 1)));
		BlueTopaz = new Materials(513, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 3, 1 | 4 | 8 | 64, 0, 0, 255, 127, "BlueTopaz", "Blue Topaz", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)));
		Bone = new Materials(806, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Bone", "Bone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Calcium, 1)));
		Brass = new Materials(301, TextureSet.SET_METALLIC, 7.0F, 96, 1, 1 | 2 | 64 | 128, 255, 180, 0, 0, "Brass", "Brass", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)));
		Bronze = new Materials(300, TextureSet.SET_METALLIC, 6.0F, 192, 2, 1 | 2 | 64 | 128, 255, 128, 0, 0, "Bronze", "Bronze", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Copper, 3)));
		BrownLimonite = new Materials(930, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "BrownLimonite", "Brown Limonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH)
		Calcite = new Materials(823, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 250, 230, 220, 0, "Calcite", "Calcite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
		Cassiterite = new Materials(824, TextureSet.SET_METALLIC, 1.0F, 0, 1, 8, 220, 220, 220, 0, "Cassiterite", "Cassiterite", 0, 0, -1, 0, false, false, 4, 3, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
		CassiteriteSand = new Materials(937, TextureSet.SET_SAND, 1.0F, 0, 1, 8, 220, 220, 220, 0, "CassiteriteSand", "Cassiterite Sand", 0, 0, -1, 0, false, false, 4, 3, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
		Chalcopyrite = new Materials(855, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 160, 120, 40, 0, "Chalcopyrite", "Chalcopyrite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
		//Chalk = new Materials(856, TextureSet.SET_FINE, 			  1.0F, 0, 2, 1, 250, 250, 250, 0, "Chalk", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
		Charcoal = new Materials(536, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 4, 100, 70, 70, 0, "Charcoal", "Charcoal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
		Chromite = new Materials(825, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 35, 20, 15, 0, "Chromite", "Chromite", 0, 0, 1700, 1700, true, false, 6, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Chrome, 2), new MaterialStack(Oxygen, 4)));
		ChromiumDioxide = new Materials(361, TextureSet.SET_DULL, 11.0F, 256, 3, 1 | 2, 230, 200, 200, 0, "ChromiumDioxide", "Chromium Dioxide", 0, 0, 650, 650, false, false, 5, 3, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Oxygen, 2)));
		Cinnabar = new Materials(826, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 150, 0, 0, 0, "Cinnabar", "Cinnabar", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Mercury, 1), new MaterialStack(Sulfur, 1)));
		Water = new Materials(701, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 0, 255, 0, "Water", "Water", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
		Clay = new Materials(805, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 200, 200, 220, 0, "Clay", "Clay", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2), new MaterialStack(Water, 6)));
		Coal = new Materials(535, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 4 | 8, 70, 70, 70, 0, "Coal", "Coal", 0, 0, -1, 0, false, false, 2, 2, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
		Cobaltite = new Materials(827, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 80, 80, 250, 0, "Cobaltite", "Cobaltite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Cobalt, 1), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 1)));
		Cooperite = new Materials(828, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 255, 255, 200, 0, "Cooperite", "Sheldonite", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Platinum, 3), new MaterialStack(Nickel, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Palladium, 1)));
		Cupronickel = new Materials(310, TextureSet.SET_METALLIC, 6.0F, 64, 1, 1 | 2 | 64, 227, 150, 128, 0, "Cupronickel", "Cupronickel", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Nickel, 1)));
		DarkAsh = new Materials(816, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 50, 50, 50, 0, "DarkAsh", "Dark Ashes", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyeGray);
		DeepIron = new Materials(829, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 8 | 64, 150, 140, 140, 0, "DeepIron", "Deep Iron", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyePink, 2, Arrays.asList(new MaterialStack(Materials.Iron, 1)));
		Diamond = new Materials(500, TextureSet.SET_DIAMOND, 8.0F, 1280, 3, 1 | 4 | 8 | 64 | 128, 200, 255, 255, 127, "Diamond", "Diamond", 0, 0, -1, 0, false, true, 5, 64, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
		Electrum = new Materials(303, TextureSet.SET_SHINY, 12.0F, 64, 2, 1 | 2 | 64 | 128, 255, 255, 100, 0, "Electrum", "Electrum", 0, 0, -1, 0, false, false, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Gold, 1)));
		Emerald = new Materials(501, TextureSet.SET_EMERALD, 7.0F, 256, 2, 1 | 4 | 8 | 64, 80, 255, 80, 127, "Emerald", "Emerald", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Beryllium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 6), new MaterialStack(Oxygen, 18)));
		FreshWater = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 0, 255, 0, "FreshWater", "Fresh Water", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
		Galena = new Materials(830, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 100, 60, 100, 0, "Galena", "Galena", 0, 0, -1, 0, false, false, 4, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Lead, 3), new MaterialStack(Silver, 3), new MaterialStack(Sulfur, 2)));
		Garnierite = new Materials(906, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 50, 200, 70, 0, "Garnierite", "Garnierite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(Oxygen, 1)));
		Glyceryl = new Materials(714, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 0, 150, 150, 0, "Glyceryl", "Glyceryl Trinitrate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 5), new MaterialStack(Nitrogen, 3), new MaterialStack(Oxygen, 9)));
		GreenSapphire = new Materials(504, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 2, 1 | 4 | 8 | 64, 100, 200, 130, 127, "GreenSapphire", "Green Sapphire", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
		Grossular = new Materials(831, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "Grossular", "Grossular", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		HolyWater = new Materials(729, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 0, 255, 0, "HolyWater", "Holy Water", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
		Ice = new Materials(702, TextureSet.SET_SHINY, 1.0F, 0, 0, 1 | 16, 200, 200, 255, 0, "Ice", "Ice", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
		Ilmenite = new Materials(918, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 70, 55, 50, 0, "Ilmenite", "Ilmenite", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyePurple, 0, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 3)));
		Rutile = new Materials(375, TextureSet.SET_GEM_HORIZONTAL, 1.0F, 0, 2, 1, 212, 13, 92, 0, "Rutile", "Rutile", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 2)));
		Bauxite = new Materials(822, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "Bauxite", "Bauxite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Rutile, 2), new MaterialStack(Aluminium, 16), new MaterialStack(Hydrogen, 10), new MaterialStack(Oxygen, 11)));
		Titaniumtetrachloride = new Materials(376, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 212, 13, 92, 0, "Titaniumtetrachloride", "Titaniumtetrachloride", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Chlorine, 4)));
		Magnesiumchloride = new Materials(377, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 16, 212, 13, 92, 0, "Magnesiumchloride", "Magnesiumchloride", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Chlorine, 2)));
		Invar = new Materials(302, TextureSet.SET_METALLIC, 6.0F, 256, 2, 1 | 2 | 64 | 128, 180, 180, 120, 0, "Invar", "Invar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Nickel, 1)));
		IronCompressed = new Materials(-1, TextureSet.SET_METALLIC, 7.0F, 96, 1, 1 | 2 | 64 | 128, 128, 128, 128, 0, "IronCompressed", "Compressed Iron", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Iron, 1)));
		Kanthal = new Materials(312, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 64, 194, 210, 223, 0, "Kanthal", "Kanthal", 0, 0, 1800, 1800, true, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Chrome, 1)));
		Lazurite = new Materials(524, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 100, 120, 255, 0, "Lazurite", "Lazurite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Aluminium, 6), new MaterialStack(Silicon, 6), new MaterialStack(Calcium, 8), new MaterialStack(Sodium, 8)));
		Magnalium = new Materials(313, TextureSet.SET_DULL, 6.0F, 256, 2, 1 | 2 | 64 | 128, 200, 190, 255, 0, "Magnalium", "Magnalium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Aluminium, 2)));
		Magnesite = new Materials(908, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 250, 250, 180, 0, "Magnesite", "Magnesite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
		Magnetite = new Materials(870, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 30, 30, 30, 0, "Magnetite", "Magnetite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Oxygen, 4)));
		Molybdenite = new Materials(942, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 25, 25, 25, 0, "Molybdenite", "Molybdenite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Molybdenum, 1), new MaterialStack(Sulfur, 2))); // MoS2 (also source of Re)
		Nichrome = new Materials(311, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 64, 205, 206, 246, 0, "Nichrome", "Nichrome", 0, 0, 2700, 2700, true, false, 1, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Nickel, 4), new MaterialStack(Chrome, 1)));
		NiobiumNitride = new Materials(359, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2, 29, 41, 29, 0, "NiobiumNitride", "Niobium Nitride", 0, 0, 2573, 2573, true, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Niobium, 1), new MaterialStack(Nitrogen, 1))); // Anti-Reflective Material
		NiobiumTitanium = new Materials(360, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2, 29, 29, 41, 0, "NiobiumTitanium", "Niobium-Titanium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Niobium, 1), new MaterialStack(Titanium, 1)));
		NitroCarbon = new Materials(716, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 0, 75, 100, 0, "NitroCarbon", "Nitro-Carbon", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Carbon, 1)));
		NitrogenDioxide = new Materials(717, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 100, 175, 255, 0, "NitrogenDioxide", "Nitrogen Dioxide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 2)));
		Obsidian = new Materials(804, TextureSet.SET_DULL, 1.0F, 0, 3, 1, 80, 50, 100, 0, "Obsidian", "Obsidian", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Iron, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 8)));
		Phosphate = new Materials(833, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8 | 16, 255, 255, 0, 0, "Phosphate", "Phosphate", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Phosphorus, 1), new MaterialStack(Oxygen, 4)));
		PigIron = new Materials(307, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 64, 200, 180, 180, 0, "PigIron", "Pig Iron", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyePink, 2, Arrays.asList(new MaterialStack(Iron, 1)));
		Plastic = new Materials(874, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 64 | 128, 200, 200, 200, 0, "Plastic", "Polyethylene", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2)));
		Epoxid = new Materials(470, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 64 | 128, 200, 140, 20, 0, "Epoxid", "Epoxy Resin", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 1)));
		Silicone = new Materials(471, TextureSet.SET_DULL, 3.0F, 128, 1, 1 | 2 | 64 | 128, 220, 220, 220, 0, "Silicone", "Silicone Rubber", 0, 0, 900, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1), new MaterialStack(Silicon, 1)));
		Polycaprolactam = new Materials(472, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 64 | 128, 50, 50, 50, 0, "Polycaprolactam", "Polycaprolactam", 0, 0, 500, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 11), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 1)));
		Polytetrafluoroethylene = new Materials(473, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 64 | 128, 100, 100, 100, 0, "Polytetrafluoroethylene", "Polytetrafluoroethylene", 0, 0, 1400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Fluorine, 4)));
		Powellite = new Materials(883, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 255, 255, 0, 0, "Powellite", "Powellite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
		Pumice = new Materials(926, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 230, 185, 185, 0, "Pumice", "Pumice", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Stone, 1)));
		Pyrite = new Materials(834, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 150, 120, 40, 0, "Pyrite", "Pyrite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
		Pyrolusite = new Materials(943, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 150, 150, 170, 0, "Pyrolusite", "Pyrolusite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Oxygen, 2)));
		Pyrope = new Materials(835, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 120, 50, 100, 0, "Pyrope", "Pyrope", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		RockSalt = new Materials(944, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 240, 200, 200, 0, "RockSalt", "Rock Salt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Chlorine, 1)));
		Rubber = new Materials(880, TextureSet.SET_SHINY, 1.5F, 32, 0, 1 | 2 | 64 | 128, 0, 0, 0, 0, "Rubber", "Rubber", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)));
		RawRubber = new Materials(896, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 204, 199, 137, 0, "RawRubber", "Raw Rubber", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)));
		Ruby = new Materials(502, TextureSet.SET_RUBY, 7.0F, 256, 2, 1 | 4 | 8 | 64, 255, 100, 100, 127, "Ruby", "Ruby", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
		Salt = new Materials(817, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 250, 250, 250, 0, "Salt", "Salt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Chlorine, 1)));
		Saltpeter = new Materials(836, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 230, 230, 230, 0, "Saltpeter", "Saltpeter", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)));
		Sapphire = new Materials(503, TextureSet.SET_GEM_VERTICAL, 7.0F, 256, 2, 1 | 4 | 8 | 64, 100, 100, 200, 127, "Sapphire", "Sapphire", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
		Scheelite = new Materials(910, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 200, 140, 20, 0, "Scheelite", "Scheelite", 0, 0, 2500, 2500, false, false, 4, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Calcium, 2), new MaterialStack(Oxygen, 4)));
		SiliconDioxide = new Materials(837, TextureSet.SET_QUARTZ, 1.0F, 0, 1, 1 | 16, 200, 200, 200, 0, "SiliconDioxide", "Silicon Dioxide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 1, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 2)));
		Snow = new Materials(728, TextureSet.SET_FINE, 1.0F, 0, 0, 1 | 16, 250, 250, 250, 0, "Snow", "Snow", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
		Sodalite = new Materials(525, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 20, 20, 255, 0, "Sodalite", "Sodalite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Sodium, 4), new MaterialStack(Chlorine, 1)));
		SodiumPersulfate = new Materials(718, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 255, 255, 0, "SodiumPersulfate", "Sodium Persulfate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 2), new MaterialStack(Oxygen, 8)));
		SodiumSulfide = new Materials(719, TextureSet.SET_FLUID, 1.0F, 0, 2, 1, 255, 230, 128, 0, "SodiumSulfide", "Sodium Sulfide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1)));
		HydricSulfide = new Materials(460, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 255, 255, 0, "HydricSulfide", "Hydrogen Sulfide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1)));

		OilHeavy = new Materials(730, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilHeavy", "Heavy Oil", 3, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		OilMedium = new Materials(731, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilMedium", "Raw Oil", 3, 24, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		OilLight = new Materials(732, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilLight", "Light Oil", 3, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);

		NatruralGas = new Materials(733, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "NatruralGas", "Natural Gas", 1, 15, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
		SulfuricGas = new Materials(734, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "SulfuricGas", "Sulfuric Gas", 1, 20, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
		Gas = new Materials(735, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "Gas", "Refinery Gas", 1, 128, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite).setCanBeCracked(true);
		SulfuricNaphtha = new Materials(736, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricNaphtha", "Sulfuric Naphtha", 1, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		SulfuricLightFuel = new Materials(737, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricLightFuel", "Sulfuric Light Fuel", 0, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		SulfuricHeavyFuel = new Materials(738, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricHeavyFuel", "Sulfuric Heavy Fuel", 3, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
		Naphtha = new Materials(739, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "Naphtha", "Naphtha", 1, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow).setCanBeCracked(true);
		LightFuel = new Materials(740, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "LightFuel", "Light Fuel", 0, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow).setCanBeCracked(true);
		HeavyFuel = new Materials(741, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "HeavyFuel", "Heavy Fuel", 3, 192, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack).setCanBeCracked(true);
		LPG = new Materials(742, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "LPG", "LPG", 1, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
		
		SolderingAlloy = new Materials(314, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 220, 220, 230, 0, "SolderingAlloy", "Soldering Alloy", 0, 0, 400, 400, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Tin, 9), new MaterialStack(Antimony, 1)));
		GalliumArsenide = new Materials(980, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 160, 160, 160, 0, "GalliumArsenide", "Gallium Arsenide", 0, 0, -1, 1200, true, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Arsenic, 1), new MaterialStack(Gallium, 1)));
		IndiumGalliumPhosphide = new Materials(981, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 160, 140, 190, 0, "IndiumGalliumPhosphide", "Indium Gallium Phosphide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 2, Arrays.asList(new MaterialStack(Indium, 1), new MaterialStack(Gallium, 1), new MaterialStack(Phosphorus, 1)));
		Spessartine = new Materials(838, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 255, 100, 100, 0, "Spessartine", "Spessartine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Manganese, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		Sphalerite = new Materials(839, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 255, 255, 255, 0, "Sphalerite", "Sphalerite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Sulfur, 1)));
		StainlessSteel = new Materials(306, TextureSet.SET_SHINY, 7.0F, 480, 2, 1 | 2 | 64 | 128, 200, 200, 220, 0, "StainlessSteel", "Stainless Steel", 0, 0, -1, 1700, true, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Iron, 6), new MaterialStack(Chrome, 1), new MaterialStack(Manganese, 1), new MaterialStack(Nickel, 1)));
		Steel = new Materials(305, TextureSet.SET_METALLIC, 6.0F, 512, 2, 1 | 2 | 64 | 128, 128, 128, 128, 0, "Steel", "Steel", 0, 0, 1811, 1000, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 50), new MaterialStack(Carbon, 1)));
		Stibnite = new Materials(945, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 70, 70, 70, 0, "Stibnite", "Stibnite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Antimony, 2), new MaterialStack(Sulfur, 3)));
		SulfuricAcid = new Materials(720, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 128, 0, 0, "SulfuricAcid", "Sulfuric Acid", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
		Tanzanite = new Materials(508, TextureSet.SET_GEM_VERTICAL, 7.0F, 256, 2, 1 | 4 | 8 | 64, 64, 0, 200, 127, "Tanzanite", "Tanzanite", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Calcium, 2), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 13)));
		Tetrahedrite = new Materials(840, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 200, 32, 0, 0, "Tetrahedrite", "Tetrahedrite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Copper, 3), new MaterialStack(Antimony, 1), new MaterialStack(Sulfur, 3), new MaterialStack(Iron, 1))); //Cu3SbS3 + x(Fe, Zn)6Sb2S9
		TinAlloy = new Materials(363, TextureSet.SET_METALLIC, 6.5F, 96, 2, 1 | 2 | 64 | 128, 200, 200, 200, 0, "TinAlloy", "Tin Alloy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Iron, 1)));
		Topaz = new Materials(507, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 3, 1 | 4 | 8 | 64, 255, 128, 0, 127, "Topaz", "Topaz", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)));
		Tungstate = new Materials(841, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 55, 50, 35, 0, "Tungstate", "Tungstate", 0, 0, 2500, 2500, true, false, 4, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Lithium, 2), new MaterialStack(Oxygen, 4)));
		Ultimet = new Materials(344, TextureSet.SET_SHINY, 9.0F, 2048, 4, 1 | 2 | 64 | 128, 180, 180, 230, 0, "Ultimet", "Ultimet", 0, 0, 2700, 2700, true, false, 1, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Cobalt, 5), new MaterialStack(Chrome, 2), new MaterialStack(Nickel, 1), new MaterialStack(Molybdenum, 1))); // 54% Cobalt, 26% Chromium, 9% Nickel, 5% Molybdenum, 3% Iron, 2% Tungsten, 0.8% Manganese, 0.3% Silicon, 0.08% Nitrogen and 0.06% Carbon
		Uraninite = new Materials(922, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 35, 35, 35, 0, "Uraninite", "Uraninite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime, 2, Arrays.asList(new MaterialStack(Uranium, 1), new MaterialStack(Oxygen, 2)));
		Uvarovite = new Materials(842, TextureSet.SET_DIAMOND, 1.0F, 0, 2, 1, 180, 255, 180, 0, "Uvarovite", "Uvarovite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Chrome, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
		VanadiumGallium = new Materials(357, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2, 128, 128, 140, 0, "VanadiumGallium", "Vanadium-Gallium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Vanadium, 3), new MaterialStack(Gallium, 1)));
		Wood = new Materials(809, TextureSet.SET_WOOD, 2.0F, 16, 0, 1 | 2 | 64 | 128, 100, 50, 0, 0, "Wood", "Wood", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 1), new MaterialStack(Hydrogen, 1)));
		WroughtIron = new Materials(304, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 64 | 128, 200, 180, 180, 0, "WroughtIron", "Wrought Iron", 0, 0, 1811, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, 2, Arrays.asList(new MaterialStack(Iron, 1)));
		Wulfenite = new Materials(882, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 255, 128, 0, 0, "Wulfenite", "Wulfenite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Lead, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
		YellowLimonite = new Materials(931, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 200, 200, 0, 0, "YellowLimonite", "Yellow Limonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH) + a bit Ni and Co
		YttriumBariumCuprate = new Materials(358, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2, 80, 64, 70, 0, "YttriumBariumCuprate", "Yttrium Barium Cuprate", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGray, 0, Arrays.asList(new MaterialStack(Yttrium, 1), new MaterialStack(Barium, 2), new MaterialStack(Copper, 3), new MaterialStack(Oxygen, 7)));

		/**
		 * Second Degree Compounds
		 */
		WoodSealed = new Materials(889, TextureSet.SET_WOOD, 3.0F, 24, 0, 1 | 2 | 64 | 128, 80, 40, 0, 0, "WoodSealed", "Sealed Wood", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 0, Arrays.asList(new MaterialStack(Wood, 1)));
		LiveRoot = new Materials(832, TextureSet.SET_WOOD, 1.0F, 0, 1, 1, 220, 200, 0, 0, "LiveRoot", "Liveroot", 5, 16, -1, 0, false, false, 2, 4, 3, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Wood, 3), new MaterialStack(Magic, 1)));
		IronWood = new Materials(338, TextureSet.SET_WOOD, 6.0F, 384, 2, 1 | 2 | 64 | 128, 150, 140, 110, 0, "IronWood", "Ironwood", 5, 8, -1, 0, false, false, 2, 19, 18, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Iron, 9), new MaterialStack(LiveRoot, 9), new MaterialStack(Gold, 1)));
		Glass = new Materials(890, TextureSet.SET_GLASS, 1.0F, 4, 0, 1 | 4, 250, 250, 250, 220, "Glass", "Glass", 0, 0, 1500, 0, false, true, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
		Perlite = new Materials(925, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 30, 20, 30, 0, "Perlite", "Perlite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Obsidian, 2), new MaterialStack(Water, 1)));
		Borax = new Materials(941, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Borax", "Borax", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Boron, 4), new MaterialStack(Oxygen, 7), new MaterialStack(Water, 10)));
		Lignite = new Materials(538, TextureSet.SET_LIGNITE, 1.0F, 0, 0, 1 | 4 | 8, 100, 70, 70, 0, "Lignite", "Lignite Coal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 3), new MaterialStack(Water, 1)));
		Olivine = new Materials(505, TextureSet.SET_RUBY, 7.0F, 256, 2, 1 | 4 | 8 | 64, 150, 255, 150, 127, "Olivine", "Olivine", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeLime, 1, Arrays.asList(new MaterialStack(Magnesium, 2), new MaterialStack(Iron, 1), new MaterialStack(SiliconDioxide, 2)));
		Opal = new Materials(510, TextureSet.SET_OPAL, 7.0F, 256, 2, 1 | 4 | 8 | 64, 0, 0, 255, 0, "Opal", "Opal", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
		Amethyst = new Materials(509, TextureSet.SET_FLINT, 7.0F, 256, 3, 1 | 4 | 8 | 64, 210, 50, 210, 127, "Amethyst", "Amethyst", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Iron, 1)));
		Redstone = new Materials(810, TextureSet.SET_ROUGH, 1.0F, 0, 2, 1 | 8, 200, 0, 0, 0, "Redstone", "Redstone", 0, 0, 500, 0, false, false, 3, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Pyrite, 5), new MaterialStack(Ruby, 1), new MaterialStack(Mercury, 3)));
		Lapis = new Materials(526, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 70, 70, 220, 0, "Lapis", "Lapis", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(Lazurite, 12), new MaterialStack(Sodalite, 2), new MaterialStack(Pyrite, 1), new MaterialStack(Calcite, 1)));
		Blaze = new Materials(801, TextureSet.SET_POWDER, 2.0F, 16, 1, 1 | 2 | 64 | 128, 255, 200, 0, 0, "Blaze", "Blaze", 0, 0, 6400, 0, false, false, 2, 3, 2, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(DarkAsh, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Magic, 1)));
		EnderPearl = new Materials(532, TextureSet.SET_SHINY, 1.0F, 16, 1, 1 | 4, 108, 220, 200, 0, "EnderPearl", "Enderpearl", 0, 0, -1, 0, false, false, 1, 16, 10, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Beryllium, 1), new MaterialStack(Potassium, 4), new MaterialStack(Nitrogen, 5), new MaterialStack(Magic, 6)));
		EnderEye = new Materials(533, TextureSet.SET_SHINY, 1.0F, 16, 1, 1 | 4, 160, 250, 230, 0, "EnderEye", "Endereye", 5, 10, -1, 0, false, false, 1, 2, 1, Dyes.dyeGreen, 2, Arrays.asList(new MaterialStack(EnderPearl, 1), new MaterialStack(Blaze, 1)));
		Flint = new Materials(802, TextureSet.SET_FLINT, 2.5F, 64, 1, 1 | 64, 0, 32, 64, 0, "Flint", "Flint", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
		Diatomite = new Materials(948, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 225, 225, 225, 0, "Diatomite", "Diatomite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Flint, 8), new MaterialStack(BandedIron, 1), new MaterialStack(Sapphire, 1)));
		VolcanicAsh = new Materials(940, TextureSet.SET_FLINT, 1.0F, 0, 0, 1, 60, 50, 50, 0, "VolcanicAsh", "Volcanic Ashes", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Flint, 6), new MaterialStack(Iron, 1), new MaterialStack(Magnesium, 1)));
		Niter = new Materials(531, TextureSet.SET_FLINT, 1.0F, 0, 1, 1 | 4, 255, 200, 200, 0, "Niter", "Niter", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 2, Arrays.asList(new MaterialStack(Saltpeter, 1)));
		Pyrotheum = new Materials(843, TextureSet.SET_FIERY, 1.0F, 0, 1, 1, 255, 128, 0, 0, "Pyrotheum", "Pyrotheum", 2, 62, -1, 0, false, false, 2, 3, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Coal, 1), new MaterialStack(Redstone, 1), new MaterialStack(Blaze, 1)));
		HydratedCoal = new Materials(818, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 70, 70, 100, 0, "HydratedCoal", "Hydrated Coal", 0, 0, -1, 0, false, false, 1, 9, 8, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Coal, 8), new MaterialStack(Water, 1)));
		Apatite = new Materials(530, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8, 200, 200, 255, 0, "Apatite", "Apatite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Calcium, 5), new MaterialStack(Phosphate, 3), new MaterialStack(Chlorine, 1)));
		Alumite = new Materials(-1, TextureSet.SET_METALLIC, 1.5F, 64, 0, 1 | 2 | 64, 255, 255, 255, 0, "Alumite", "Alumite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 2, Arrays.asList(new MaterialStack(Aluminium, 5), new MaterialStack(Iron, 2), new MaterialStack(Obsidian, 2)));
		Manyullyn = new Materials(-1, TextureSet.SET_METALLIC, 1.5F, 64, 0, 1 | 2 | 64, 255, 255, 255, 0, "Manyullyn", "Manyullyn", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Cobalt, 1), new MaterialStack(Aredrite, 1)));
		ShadowIron = new Materials(336, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 8 | 64, 120, 120, 120, 0, "ShadowIron", "Shadowiron", 0, 0, -1, 0, false, false, 3, 4, 3, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Materials.Iron, 3), new MaterialStack(Materials.Magic, 1)));
		ShadowSteel = new Materials(337, TextureSet.SET_METALLIC, 6.0F, 768, 2, 1 | 2 | 64, 90, 90, 90, 0, "ShadowSteel", "Shadowsteel", 0, 0, -1, 1700, true, false, 4, 4, 3, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Materials.Steel, 3), new MaterialStack(Materials.Magic, 1)));
		Steeleaf = new Materials(339, TextureSet.SET_LEAF, 8.0F, 768, 3, 1 | 2 | 64 | 128, 50, 127, 50, 0, "Steeleaf", "Steeleaf", 5, 24, -1, 0, false, false, 4, 1, 1, Dyes.dyeGreen, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Magic, 1)));
		Knightmetal = new Materials(362, TextureSet.SET_METALLIC, 8.0F, 1024, 3, 1 | 2 | 64 | 128, 210, 240, 200, 0, "Knightmetal", "Knightmetal", 5, 24, -1, 0, false, false, 4, 1, 1, Dyes.dyeLime, 2, Arrays.asList(new MaterialStack(Steel, 2), new MaterialStack(Magic, 1)));
		SterlingSilver = new Materials(350, TextureSet.SET_SHINY, 13.0F, 128, 2, 1 | 2 | 64 | 128, 250, 220, 225, 0, "SterlingSilver", "Sterling Silver", 0, 0, -1, 1700, true, false, 4, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Silver, 4)));
		RoseGold = new Materials(351, TextureSet.SET_SHINY, 14.0F, 128, 2, 1 | 2 | 64 | 128, 255, 230, 30, 0, "RoseGold", "Rose Gold", 0, 0, -1, 1600, true, false, 4, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Gold, 4)));
		BlackBronze = new Materials(352, TextureSet.SET_DULL, 12.0F, 256, 2, 1 | 2 | 64 | 128, 100, 50, 125, 0, "BlackBronze", "Black Bronze", 0, 0, -1, 2000, true, false, 4, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Gold, 1), new MaterialStack(Silver, 1), new MaterialStack(Copper, 3)));
		BismuthBronze = new Materials(353, TextureSet.SET_DULL, 8.0F, 256, 2, 1 | 2 | 64 | 128, 100, 125, 125, 0, "BismuthBronze", "Bismuth Bronze", 0, 0, -1, 1100, true, false, 4, 1, 1, Dyes.dyeCyan, 2, Arrays.asList(new MaterialStack(Bismuth, 1), new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)));
		BlackSteel = new Materials(334, TextureSet.SET_METALLIC, 6.5F, 768, 2, 1 | 2 | 64, 100, 100, 100, 0, "BlackSteel", "Black Steel", 0, 0, -1, 1200, true, false, 4, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(BlackBronze, 1), new MaterialStack(Steel, 3)));
		RedSteel = new Materials(348, TextureSet.SET_METALLIC, 7.0F, 896, 2, 1 | 2 | 64, 140, 100, 100, 0, "RedSteel", "Red Steel", 0, 0, -1, 1300, true, false, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(SterlingSilver, 1), new MaterialStack(BismuthBronze, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
		BlueSteel = new Materials(349, TextureSet.SET_METALLIC, 7.5F, 1024, 2, 1 | 2 | 64, 100, 100, 140, 0, "BlueSteel", "Blue Steel", 0, 0, -1, 1400, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(RoseGold, 1), new MaterialStack(Brass, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
		DamascusSteel = new Materials(335, TextureSet.SET_METALLIC, 8.0F, 1280, 2, 1 | 2 | 64, 110, 110, 110, 0, "DamascusSteel", "Damascus Steel", 0, 0, 2000, 1500, true, false, 4, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Steel, 1)));
		TungstenSteel = new Materials(316, TextureSet.SET_METALLIC, 8.0F, 2560, 4, 1 | 2 | 64 | 128, 100, 100, 160, 0, "TungstenSteel", "Tungstensteel", 0, 0, -1, 3000, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Tungsten, 1)));
		NitroCoalFuel = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 50, 70, 50, 0, "NitroCoalFuel", "Nitro-Coalfuel", 0, 48, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Glyceryl, 1), new MaterialStack(CoalFuel, 4)));
		NitroFuel = new Materials(709, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 200, 255, 0, 0, "NitroFuel", "Cetane-Boosted Diesel", 0, 512, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
		AstralSilver = new Materials(333, TextureSet.SET_SHINY, 10.0F, 64, 2, 1 | 2 | 8 | 64, 230, 230, 255, 0, "AstralSilver", "Astral Silver", 0, 0, -1, 0, false, false, 4, 3, 2, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Materials.Silver, 2), new MaterialStack(Materials.Magic, 1)));
		Midasium = new Materials(332, TextureSet.SET_SHINY, 12.0F, 64, 2, 1 | 2 | 8 | 64, 255, 200, 40, 0, "Midasium", "Midasium", 0, 0, -1, 0, false, false, 4, 3, 2, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Materials.Gold, 2), new MaterialStack(Materials.Magic, 1)));
		Mithril = new Materials(331, TextureSet.SET_SHINY, 14.0F, 64, 3, 1 | 2 | 64, 255, 255, 210, 0, "Mithril", "Mithril", 0, 0, -1, 0, false, false, 4, 3, 2, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Materials.Platinum, 2), new MaterialStack(Materials.Magic, 1)));
		BlueAlloy = new Materials(309, TextureSet.SET_DULL, 1.0F, 0, 0, 1 | 2, 100, 180, 255, 0, "BlueAlloy", "Blue Alloy", 0, 0, -1, 0, false, false, 3, 5, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Nikolite, 4)));
		RedAlloy = new Materials(308, TextureSet.SET_DULL, 1.0F, 0, 0, 1 | 2, 200, 0, 0, 0, "RedAlloy", "Red Alloy", 0, 0, -1, 0, false, false, 3, 5, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Redstone, 4)));
		CobaltBrass = new Materials(343, TextureSet.SET_METALLIC, 8.0F, 256, 2, 1 | 2 | 64 | 128, 180, 180, 160, 0, "CobaltBrass", "Cobalt Brass", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Brass, 7), new MaterialStack(Aluminium, 1), new MaterialStack(Cobalt, 1)));
		TricalciumPhosphate = new Materials(534, TextureSet.SET_FLINT, 1.0F, 0, 2, 1 | 4 | 8 | 16, 255, 255, 0, 0, "TricalciumPhosphate", "Tricalcium Phosphate", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Phosphate, 2)));
		Basalt = new Materials(844, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 30, 20, 20, 0, "Basalt", "Basalt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Olivine, 1), new MaterialStack(Calcite, 3), new MaterialStack(Flint, 8), new MaterialStack(DarkAsh, 4)));
		GarnetRed = new Materials(527, TextureSet.SET_RUBY, 7.0F, 128, 2, 1 | 4 | 8 | 64, 200, 80, 80, 127, "GarnetRed", "Red Garnet", 0, 0, -1, 0, false, true, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Pyrope, 3), new MaterialStack(Almandine, 5), new MaterialStack(Spessartine, 8)));
		GarnetYellow = new Materials(528, TextureSet.SET_RUBY, 7.0F, 128, 2, 1 | 4 | 8 | 64, 200, 200, 80, 127, "GarnetYellow", "Yellow Garnet", 0, 0, -1, 0, false, true, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Andradite, 5), new MaterialStack(Grossular, 8), new MaterialStack(Uvarovite, 3)));
		Marble = new Materials(845, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 200, 200, 200, 0, "Marble", "Marble", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Calcite, 7)));
		Sugar = new Materials(803, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Sugar", "Sugar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Carbon, 12), new MaterialStack(Water, 11)));
		Thaumium = new Materials(330, TextureSet.SET_METALLIC, 12.0F, 256, 3, 1 | 2 | 64 | 128, 150, 100, 200, 0, "Thaumium", "Thaumium", 0, 0, -1, 0, false, false, 5, 2, 1, Dyes.dyePurple, 0, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Magic, 1)));
		Vinteum = new Materials(529, TextureSet.SET_EMERALD, 10.0F, 128, 3, 1 | 4 | 8 | 64, 100, 200, 255, 0, "Vinteum", "Vinteum", 5, 32, -1, 0, false, false, 4, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Magic, 1)));
		Vis = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, 0, 128, 0, 255, 0, "Vis", "Vis", 5, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Magic, 1)));
		Redrock = new Materials(846, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 255, 80, 50, 0, "Redrock", "Redrock", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Calcite, 2), new MaterialStack(Flint, 1), new MaterialStack(Clay, 1)));
		PotassiumFeldspar = new Materials(847, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 120, 40, 40, 0, "PotassiumFeldspar", "Potassium Feldspar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 8)));
		Biotite = new Materials(848, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1, 20, 30, 20, 0, "Biotite", "Biotite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 3), new MaterialStack(Aluminium, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 10)));
		GraniteBlack = new Materials(849, TextureSet.SET_ROUGH, 4.0F, 64, 3, 1 | 64 | 128, 10, 10, 10, 0, "GraniteBlack", "Black Granite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Biotite, 1)));
		GraniteRed = new Materials(850, TextureSet.SET_ROUGH, 4.0F, 64, 3, 1 | 64 | 128, 255, 0, 128, 0, "GraniteRed", "Red Granite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeMagenta, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(PotassiumFeldspar, 1), new MaterialStack(Oxygen, 3)));
		Chrysotile = new Materials(912, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 110, 140, 110, 0, "Chrysotile", "Chrysotile", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Asbestos, 1)));
		Realgar = new Materials(913, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 140, 100, 100, 0, "Realgar", "Realgar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Arsenic, 4), new MaterialStack(Sulfur, 4)));
		VanadiumMagnetite = new Materials(923, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 35, 35, 60, 0, "VanadiumMagnetite", "Vanadium Magnetite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Vanadium, 1)));
		BasalticMineralSand = new Materials(935, TextureSet.SET_SAND, 1.0F, 0, 1, 1, 40, 50, 40, 0, "BasalticMineralSand", "Basaltic Mineral Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Basalt, 1)));
		GraniticMineralSand = new Materials(936, TextureSet.SET_SAND, 1.0F, 0, 1, 1, 40, 60, 60, 0, "GraniticMineralSand", "Granitic Mineral Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(GraniteBlack, 1)));
		GarnetSand = new Materials(938, TextureSet.SET_SAND, 1.0F, 0, 1, 1, 200, 100, 0, 0, "GarnetSand", "Garnet Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(GarnetRed, 1), new MaterialStack(GarnetYellow, 1)));
		QuartzSand = new Materials(939, TextureSet.SET_SAND, 1.0F, 0, 1, 1, 200, 200, 200, 0, "QuartzSand", "Quartz Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(CertusQuartz, 1), new MaterialStack(Quartzite, 1)));
		Bastnasite = new Materials(905, TextureSet.SET_FINE, 1.0F, 0, 2, 1 | 8, 200, 110, 45, 0, "Bastnasite", "Bastnasite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Cerium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Fluorine, 1), new MaterialStack(Oxygen, 3))); // (Ce, La, Y)CO3F
		Pentlandite = new Materials(909, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 165, 150, 5, 0, "Pentlandite", "Pentlandite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Nickel, 9), new MaterialStack(Sulfur, 8))); // (Fe, Ni)9S8
		Spodumene = new Materials(920, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 190, 170, 170, 0, "Spodumene", "Spodumene", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 6))); // LiAl(SiO3)2
		Pollucite = new Materials(919, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 240, 210, 210, 0, "Pollucite", "Pollucite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Caesium, 2), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 4), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 12))); // (Cs, Na)2Al2Si4O12 2H2O (also a source of Rb)
		Tantalite = new Materials(921, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 145, 80, 40, 0, "Tantalite", "Tantalite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Tantalum, 2), new MaterialStack(Oxygen, 6))); // (Fe, Mn)Ta2O6 (also source of Nb)
		Lepidolite = new Materials(907, TextureSet.SET_FINE, 1.0F, 0, 2, 1 | 8, 240, 50, 140, 0, "Lepidolite", "Lepidolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Lithium, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // K(Li, Al, Rb)3(Al, Si)4O10(F, OH)2
		Glauconite = new Materials(933, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 130, 180, 60, 0, "Glauconite", "Glauconite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K, Na)(Fe3+, Al, Mg)2(Si, Al)4O10(OH)2
		GlauconiteSand = new Materials(949, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 130, 180, 60, 0, "GlauconiteSand", "Glauconite Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K, Na)(Fe3+, Al, Mg)2(Si, Al)4O10(OH)2
		Vermiculite = new Materials(932, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1, 200, 180, 15, 0, "Vermiculite", "Vermiculite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 12))); // (Mg+2, Fe+2, Fe+3)3 [(AlSi)4O10] (OH)2 4H2O)
		Bentonite = new Materials(927, TextureSet.SET_ROUGH, 1.0F, 0, 2, 1 | 8, 245, 215, 210, 0, "Bentonite", "Bentonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Magnesium, 6), new MaterialStack(Silicon, 12), new MaterialStack(Hydrogen, 6), new MaterialStack(Water, 5), new MaterialStack(Oxygen, 36))); // (Na, Ca)0.33(Al, Mg)2(Si4O10)(OH)2 nH2O
		FullersEarth = new Materials(928, TextureSet.SET_FINE, 1.0F, 0, 2, 1, 160, 160, 120, 0, "FullersEarth", "Fullers Earth", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 11))); // (Mg, Al)2Si4O10(OH) 4(H2O)
		Pitchblende = new Materials(873, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 200, 210, 0, 0, "Pitchblende", "Pitchblende", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Uraninite, 3), new MaterialStack(Thorium, 1), new MaterialStack(Lead, 1)));
		Monazite = new Materials(520, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8, 50, 70, 50, 0, "Monazite", "Monazite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(RareEarth, 1), new MaterialStack(Phosphate, 1))); // Wikipedia: (Ce, La, Nd, Th, Sm, Gd)PO4 Monazite also smelt-extract to Helium, it is brown like the rare earth Item Monazite sand deposits are inevitably of the monazite-(Ce) composition. Typically, the lanthanides in such monazites contain about 45ִ8% cerium, about 24% lanthanum, about 17% neodymium, about 5% praseodymium, and minor quantities of samarium, gadolinium, and yttrium. Europium concentrations tend to be low, about 0.05% Thorium content of monazite is variable and sometimes can be up to 20ֳ0%
		Malachite = new Materials(871, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 5, 95, 5, 0, "Malachite", "Malachite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Copper, 2), new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 5))); // Cu2CO3(OH)2
		Mirabilite = new Materials(900, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 240, 250, 210, 0, "Mirabilite", "Mirabilite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 10), new MaterialStack(Oxygen, 4))); // Na2SO4 10H2O
		Mica = new Materials(901, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 195, 195, 205, 0, "Mica", "Mica", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // KAl2(AlSi3O10)(F, OH)2
		Trona = new Materials(903, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1, 135, 135, 95, 0, "Trona", "Trona", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 3), new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 6))); // Na3(CO3)(HCO3) 2H2O
		Barite = new Materials(904, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 230, 235, 255, 0, "Barite", "Barite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Barium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
		Gypsum = new Materials(934, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 230, 230, 250, 0, "Gypsum", "Gypsum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 4))); // CaSO4 2H2O
		Alunite = new Materials(911, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1, 225, 180, 65, 0, "Alunite", "Alunite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 14))); // KAl3(SO4)2(OH)6
		Dolomite = new Materials(914, TextureSet.SET_FLINT, 1.0F, 0, 1, 1, 225, 205, 205, 0, "Dolomite", "Dolomite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 2), new MaterialStack(Oxygen, 6))); // CaMg(CO3)2
		Wollastonite = new Materials(915, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 240, 240, 240, 0, "Wollastonite", "Wollastonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 3))); // CaSiO3
		Zeolite = new Materials(916, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 240, 230, 230, 0, "Zeolite", "Zeolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Calcium, 4), new MaterialStack(Silicon, 27), new MaterialStack(Aluminium, 9), new MaterialStack(Water, 28), new MaterialStack(Oxygen, 72))); // NaCa4(Si27Al9)O72 28(H2O)
		Kyanite = new Materials(924, TextureSet.SET_FLINT, 1.0F, 0, 2, 1, 110, 110, 250, 0, "Kyanite", "Kyanite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 5))); // Al2SiO5
		Kaolinite = new Materials(929, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 245, 235, 235, 0, "Kaolinite", "Kaolinite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Al2Si2O5(OH)4
		Talc = new Materials(902, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 90, 180, 90, 0, "Talc", "Talc", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
		Soapstone = new Materials(877, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 95, 145, 95, 0, "Soapstone", "Soapstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
		Concrete = new Materials(947, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 100, 100, 100, 0, "Concrete", "Concrete", 0, 0, 300, 0, false, false, 0, 1, 1, Dyes.dyeGray, 0, Arrays.asList(new MaterialStack(Stone, 1)));
		IronMagnetic = new Materials(354, TextureSet.SET_MAGNETIC, 6.0F, 256, 2, 1 | 2 | 64 | 128, 200, 200, 200, 0, "IronMagnetic", "Magnetic Iron", 0, 0, -1, 0, false, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 1)));
		SteelMagnetic = new Materials(355, TextureSet.SET_MAGNETIC, 6.0F, 512, 2, 1 | 2 | 64 | 128, 128, 128, 128, 0, "SteelMagnetic", "Magnetic Steel", 0, 0, 1000, 1000, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Steel, 1)));
		NeodymiumMagnetic = new Materials(356, TextureSet.SET_MAGNETIC, 7.0F, 512, 2, 1 | 2 | 64 | 128, 100, 100, 100, 0, "NeodymiumMagnetic", "Magnetic Neodymium", 0, 0, 1297, 1297, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Neodymium, 1)));
		TungstenCarbide = new Materials(370, TextureSet.SET_METALLIC, 14.0F, 1280, 4, 1 | 2 | 64 | 128, 51, 0, 102, 0, "TungstenCarbide", "Tungstencarbide", 0, 0, 2460, 2460, true, false, 4, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Carbon, 1)));
		VanadiumSteel = new Materials(371, TextureSet.SET_METALLIC, 3.0F, 1920, 3, 1 | 2 | 64 | 128, 192, 192, 192, 0, "VanadiumSteel", "Vanadiumsteel", 0, 0, 1453, 1453, true, false, 4, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Vanadium, 1), new MaterialStack(Chrome, 1), new MaterialStack(Steel, 7)));
		HSSG = new Materials(372, TextureSet.SET_METALLIC, 10.0F, 4000, 3, 1 | 2 | 64 | 128, 153, 153, 0, 0, "HSSG", "HSS-G", 0, 0, 4500, 4500, true, false, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(TungstenSteel, 5), new MaterialStack(Chrome, 1), new MaterialStack(Molybdenum, 2), new MaterialStack(Vanadium, 1)));
		HSSE = new Materials(373, TextureSet.SET_METALLIC, 10.0F, 5120, 4, 1 | 2 | 64 | 128, 51, 102, 0, 0, "HSSE", "HSS-E", 0, 0, 5400, 5400, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Cobalt, 1), new MaterialStack(Manganese, 1), new MaterialStack(Silicon, 1)));
		HSSS = new Materials(374, TextureSet.SET_METALLIC, 14.0F, 3000, 4, 1 | 2 | 64 | 128, 102, 0, 51, 0, "HSSS", "HSS-S", 0, 0, 5400, 5400, true, false, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Iridium, 2), new MaterialStack(Osmium, 1)));
		EpoxidFiberReinforced = new Materials(610, TextureSet.SET_DULL, 3.0F, 64, 1, 1 | 2 | 64 | 128, 160, 112, 16, 0, "EpoxidFiberReinforced", "Fiber-Reinforced Epoxy Resin", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Epoxid, 1)));

		/**
		 * Materials Ender IO
		 */
		RedstoneAlloy = new Materials(379, TextureSet.SET_METALLIC, 3.0F, 128, 2, 1 | 2 | 128, 181, 51, 51, 0, "RedstoneAlloy", "Redstone Alloy", 0, 0, 671, 1000, true, false, 1, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Redstone, 1), new MaterialStack(Silicon, 1), new MaterialStack(Coal, 1)));
		Soularium = new Materials(380, TextureSet.SET_METALLIC, 3.0F, 256, 2, 1 | 2 | 128, 65, 46, 29, 0, "Soularium", "Soularium", 0, 0, 800, 1000, true, false, 3, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(SoulSand, 1), new MaterialStack(Gold, 1), new MaterialStack(Ash, 1)));
		ConductiveIron = new Materials(369, TextureSet.SET_METALLIC, 3.0F, 256, 3, 1 | 2 | 128, 217, 178, 171, 0, "ConductiveIron", "Conductive Iron", 0, 0, -1, 1200, true, false, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(RedstoneAlloy, 1), new MaterialStack(Iron, 1), new MaterialStack(Silver, 1)));
		ElectricalSteel = new Materials(368, TextureSet.SET_METALLIC, 3.0F, 256, 2, 1 | 2 | 128, 185, 185, 185, 0, "ElectricalSteel", "Electrical Steel", 0, 0, 1811, 1000, true, false, 4, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Coal, 1), new MaterialStack(Silicon, 1)));
		EnergeticAlloy = new Materials(366, TextureSet.SET_METALLIC, 3.0F, 256, 3, 1 | 2 | 128, 255, 170, 81, 0, "EnergeticAlloy", "Energetic Alloy", 0, 0, -1, 2200, true, false, 3, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(ConductiveIron, 1), new MaterialStack(Gold, 1), new MaterialStack(BlackSteel, 1)));
		VibrantAlloy = new Materials(367, TextureSet.SET_METALLIC, 3.0F, 256, 4, 1 | 2 | 128, 157, 188, 53, 0, "VibrantAlloy", "Vibrant Alloy", 0, 0, 3300, 3300, true, false, 4, 1, 1, Dyes.dyeLime, 2, Arrays.asList(new MaterialStack(EnergeticAlloy, 1), new MaterialStack(EnderEye, 1), new MaterialStack(Chrome, 1)));
		PulsatingIron = new Materials(378, TextureSet.SET_METALLIC, 3.0F, 256, 3, 1 | 2 | 128, 128, 246, 155, 0, "PulsatingIron", "Pulsating Iron", 0, 0, -1, 1800, true, false, 4, 1, 1, Dyes.dyeLime, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(EnderPearl, 1), new MaterialStack(RedstoneAlloy, 1)));
		Enderium = new Materials(321, TextureSet.SET_DULL, 3.0F, 256, 3, 1 | 2 | 128, 89, 145, 135, 0, "Enderium", "Enderium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGreen, 2, Arrays.asList(new MaterialStack(EnderiumBase, 2), new MaterialStack(Thaumium, 1), new MaterialStack(EnderPearl, 1)));
		DarkSteel = new Materials(364, TextureSet.SET_METALLIC, 8.0F, 512, 3, 1 | 2 | 64 | 128, 80, 70, 80, 0, "DarkSteel", "Dark Steel", 0, 0, -1, 1800, true, false, 3, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(ElectricalSteel, 1), new MaterialStack(Coal, 1), new MaterialStack(Obsidian, 1)));
		EndSteel = new Materials(401, TextureSet.SET_METALLIC, 3.0F, 256, 4, 1 | 2 | 128, 223, 217, 165, 0, "EndSteel", "End Steel", 0, 0, 940, 3600, true, false, 3, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(DarkSteel, 1), new MaterialStack(Tungsten, 1), new MaterialStack(Endstone, 1)));
		//endregion
	}
	
    public final short[] mRGBa = new short[]{255, 255, 255, 0}, mMoltenRGBa = new short[]{255, 255, 255, 0};
    public TextureSet mIconSet;
    public int mMetaItemSubID;
    public boolean mUnificatable;
    public Materials mMaterialInto;
    public List<MaterialStack> mMaterialList = new ArrayList<>();
    public List<Materials> mOreByProducts = new ArrayList<>(), mOreReRegistrations = new ArrayList<>();
    public ArrayList<ItemStack> mMaterialItems = new ArrayList<>();
    public Collection<SubTag> mSubTags = new LinkedHashSet<>();
    public Enchantment mEnchantmentTools = null, mEnchantmentArmors = null;
    public byte mEnchantmentToolsLevel = 0, mEnchantmentArmorsLevel = 0;
    public boolean mBlastFurnaceRequired = false, mTransparent = false;
    public float mToolSpeed = 1.0F, mHeatDamage = 0.0F;
    public String mChemicalFormula = "?", mName = "null", mDefaultLocalName = "null", mCustomID = "null", mConfigSection = "null", mLocalizedName = "null";
    public Dyes mColor = Dyes._NULL;
    public short mMeltingPoint = 0, mBlastFurnaceTemp = 0, mGasTemp = 0;
    public int mTypes = 0;
    public int mDurability = 16, mFuelPower = 0, mExtraData = 0, mOreValue = 0, mOreMultiplier = 1, mByProductMultiplier = 1, mSmeltingMultiplier = 1;
    public int mDensityMultiplier = 1, mDensityDivider = 1;
    public long mDensity = M;
    public Element mElement = null;
    public Materials mDirectSmelting = this, mOreReplacement = this, mMacerateInto = this, mSmeltInto = this, mArcSmeltInto = this, mHandleMaterial = this;
    public byte mToolQuality = 0;
    public boolean mHasParentMod = true, mHasGas = false, mCustomOre = false;
    public Fluid mSolid = null, mFluid = null, mGas = null, mPlasma = null;
    public ArrayList<MaterialsValues> materialsValues = new ArrayList<>();
    public FuelType mFuelType = FuelType.NONE;

    private boolean hasCorrespondingFluid = false, hasCorrespondingGas = false, canBeCracked = false;
    private Fluid hydroCrackedFluid = null, steamCrackedFluid = null;
    
    /**
     * This Fluid is used as standard Unit for Molten Materials. 1296 is a Molten Block, that means 144 is one Material Unit worth of fluid.
     */
    public Fluid mStandardMoltenFluid = null;

    static {
		genMaterials();
    }
    
    public static void init() {
        new ProcessingConfig();
        if (!GT_Mod.gregtechproxy.mEnableAllMaterials) new ProcessingModSupport();
        for (IMaterialHandler aRegistrator : mMaterialHandlers) {
            aRegistrator.onMaterialsInit(); //This is where addon mods can add/manipulate materials
        }
        initMaterialProperties(); //No more material addition or manipulation should be done past this point!
        MATERIALS_ARRAY = MATERIALS_MAP.values().toArray(new Materials[MATERIALS_MAP.size()]); //Generate standard object array. This is a lot faster to loop over.
        VALUES = Arrays.asList(MATERIALS_ARRAY);
        if (!GT_Mod.gregtechproxy.mEnableAllComponents) OrePrefixes.initMaterialComponents();
        for (Materials aMaterial : MATERIALS_ARRAY) {
            if (aMaterial.mMetaItemSubID >= 0) {
                if (aMaterial.mMetaItemSubID < 1000) {
                    if (aMaterial.mHasParentMod) {
                        if (GregTech_API.sGeneratedMaterials[aMaterial.mMetaItemSubID] == null) {
                            GregTech_API.sGeneratedMaterials[aMaterial.mMetaItemSubID] = aMaterial;
                        } else throw new IllegalArgumentException("The Material Index " + aMaterial.mMetaItemSubID + " for " + aMaterial.mName + " is already used!");
                    }
                } else throw new IllegalArgumentException("The Material Index " + aMaterial.mMetaItemSubID + " for " + aMaterial.mName + " is/over the maximum of 1000");
            }
        }
    }

    public static void initMaterialProperties() {
        GT_Mod.gregtechproxy.mChangeHarvestLevels = GregTech_API.sMaterialProperties.get("harvestlevel", "ActivateHarvestLevelChange", false);
        GT_Mod.gregtechproxy.mMaxHarvestLevel = Math.min(15, GregTech_API.sMaterialProperties.get("harvestlevel", "MaxHarvestLevel",7));
        GT_Mod.gregtechproxy.mGraniteHavestLevel = GregTech_API.sMaterialProperties.get("harvestlevel", "GraniteHarvestLevel", 3);
        StringBuilder aConfigPathSB = new StringBuilder();
        for (Materials aMaterial : MATERIALS_MAP.values()) { /** The only place where MATERIALS_MAP should be used to loop over all materials. **/
            if (aMaterial != null && aMaterial != Materials._NULL && aMaterial != Materials.Empty) {
                aConfigPathSB.append("materials.").append(aMaterial.mConfigSection).append(".").append(aMaterial.mCustomOre ? aMaterial.mCustomID : aMaterial.mName);
                String aConfigPath = aConfigPathSB.toString();
                aMaterial.mMetaItemSubID = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialID", aMaterial.mCustomOre ? -1 : aMaterial.mMetaItemSubID);
                aMaterial.mDefaultLocalName = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialName", aMaterial.mCustomOre ? "CustomOre" + aMaterial.mCustomID : aMaterial.mDefaultLocalName);
                aMaterial.mMeltingPoint = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "MeltingPoint", aMaterial.mMeltingPoint);
                aMaterial.mBlastFurnaceRequired = GregTech_API.sMaterialProperties.get(aConfigPath, "BlastFurnaceRequired", aMaterial.mBlastFurnaceRequired);
                aMaterial.mBlastFurnaceTemp = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "BlastFurnaceTemp", aMaterial.mBlastFurnaceTemp);
                if (GT_Mod.gregtechproxy.mTEMachineRecipes && aMaterial.mBlastFurnaceRequired && aMaterial.mBlastFurnaceTemp < 1500) GT_ModHandler.ThermalExpansion.addSmelterBlastOre(aMaterial);
                aMaterial.mFuelPower = GregTech_API.sMaterialProperties.get(aConfigPath, "FuelPower", aMaterial.mFuelPower);
                aMaterial.mOreValue = GregTech_API.sMaterialProperties.get(aConfigPath, "OreValue", aMaterial.mOreValue);
                aMaterial.mDensityMultiplier = GregTech_API.sMaterialProperties.get(aConfigPath, "DensityMultiplier", aMaterial.mDensityMultiplier);
                aMaterial.mDensityDivider = GregTech_API.sMaterialProperties.get(aConfigPath, "DensityDivider", aMaterial.mDensityDivider);
                aMaterial.mDensity = (long) GregTech_API.sMaterialProperties.get(aConfigPath, "Density", (M * aMaterial.mDensityMultiplier) / aMaterial.mDensityDivider);
                aMaterial.mDurability = GregTech_API.sMaterialProperties.get(aConfigPath, "ToolDurability", aMaterial.mDurability);
                aMaterial.mToolSpeed = (float) GregTech_API.sMaterialProperties.get(aConfigPath, "ToolSpeed", aMaterial.mToolSpeed);
                aMaterial.mToolQuality = (byte) GregTech_API.sMaterialProperties.get(aConfigPath, "ToolQuality", aMaterial.mToolQuality);
                //aMaterial.mIconSet = TextureSet.valueOf(GregTech_API.sMaterialProperties.get(aConfigPath.toString(), "IconSet", aMaterial.mIconSet.mSetName));
                aMaterial.mTransparent = GregTech_API.sMaterialProperties.get(aConfigPath, "Transparent", aMaterial.mTransparent);
                String aColor = GregTech_API.sMaterialProperties.get(aConfigPath, "DyeColor", aMaterial.mColor == Dyes._NULL ? "None" : aMaterial.mColor.toString());
                aMaterial.mColor = aColor.equals("None") ? Dyes._NULL : Dyes.get(aColor);
                String[] aRGBA = GregTech_API.sMaterialProperties.get(aConfigPath, "MatRGBA", String.valueOf(aMaterial.mRGBa[0] + "," + aMaterial.mRGBa[1] + "," + aMaterial.mRGBa[2] + "," + aMaterial.mRGBa[3] + ",")).split(",");
                aMaterial.mRGBa[0] = Short.parseShort(aRGBA[0]);
                aMaterial.mRGBa[1] = Short.parseShort(aRGBA[1]);
                aMaterial.mRGBa[2] = Short.parseShort(aRGBA[2]);
                aMaterial.mRGBa[3] = Short.parseShort(aRGBA[3]);
                aMaterial.mTypes = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialTypes", aMaterial.mCustomOre ? 1|2|4|8|16|32|64|128 : aMaterial.mTypes);
                aMaterial.mUnificatable = GregTech_API.sMaterialProperties.get(aConfigPath, "Unificatable", aMaterial.mUnificatable);
                aMaterial.mChemicalFormula = GregTech_API.sMaterialProperties.get(aConfigPath, "ChemicalFormula", aMaterial.mChemicalFormula);
                aMaterial.mGasTemp = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "GasTemp", aMaterial.mGasTemp);
                aMaterial.setOreMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreMultiplier", aMaterial.mOreMultiplier));
                aMaterial.setSmeltingMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreSmeltingMultiplier", aMaterial.mSmeltingMultiplier));
                aMaterial.setByProductMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreByProductMultiplier", aMaterial.mByProductMultiplier));
                aMaterial.setHeatDamage((float) GregTech_API.sMaterialProperties.get(aConfigPath, "HeatDamage", aMaterial.mHeatDamage));
                aMaterial.mSmeltInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mSmeltInto.mName));
                if (aMaterial.mSmeltInto == null) {
                	GT_Log.err.print("GregTech failed to load the property MaterialSmeltInto of Material:" + aMaterial.mName);
                	aMaterial.mSmeltInto = Materials._NULL;
                }
                aMaterial.mMacerateInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialMacerateInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mMacerateInto.mName));
                if (aMaterial.mMacerateInto == null) {
                	GT_Log.err.print("GregTech failed to load the property MaterialMacerateInto of Material:" + aMaterial.mName);
                	aMaterial.mMacerateInto = Materials._NULL;
                }
                aMaterial.mArcSmeltInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialArcSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mArcSmeltInto.mName));
                if (aMaterial.mArcSmeltInto == null) {
                	GT_Log.err.print("GregTech failed to load the property MaterialArcSmeltInto of Material:" + aMaterial.mName);
                	aMaterial.mArcSmeltInto = Materials._NULL;
                }
                aMaterial.mDirectSmelting = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialDirectSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mDirectSmelting.mName));
                if (aMaterial.mDirectSmelting == null) {
                	GT_Log.err.print("GregTech failed to load the property MaterialDirectSmeltInto of Material:" + aMaterial.mName);
                	aMaterial.mDirectSmelting = Materials._NULL;
                }
                aMaterial.mHasParentMod = GregTech_API.sMaterialProperties.get(aConfigPath, "HasParentMod", aMaterial.mHasParentMod);
                if (aMaterial.mHasGas = GregTech_API.sMaterialProperties.get(aConfigPath, "AddGas", aMaterial.mHasGas)) GT_Mod.gregtechproxy.addFluid(aMaterial.mName.toLowerCase(), aMaterial.mDefaultLocalName, aMaterial, 2, aMaterial.mGasTemp);
                aMaterial.mEnchantmentToolsLevel = (byte) GregTech_API.sMaterialProperties.get(aConfigPath, "EnchantmentLevel", aMaterial.mEnchantmentToolsLevel);
                String aEnchantmentName = GregTech_API.sMaterialProperties.get(aConfigPath, "Enchantment", aMaterial.mEnchantmentTools != null ? aMaterial.mEnchantmentTools.getName() : "");
                if (aMaterial.mEnchantmentTools != null && !aEnchantmentName.equals(aMaterial.mEnchantmentTools.getName())) {
                    for (int i = 0; i < Enchantment.enchantmentsList.length; i++) {
                        if (aEnchantmentName.equals(Enchantment.enchantmentsList[i].getName())) aMaterial.mEnchantmentTools = Enchantment.enchantmentsList[i];
                    }
                }
                /**
                 * Converts the pre-defined list of SubTags from a material into a list of SubTag names for setting/getting to/from the config.
                 * It is then converted to a String[] and finally to a singular String for insertion into the config
                 * If the config string is different from the default, we then want to clear the Materials SubTags and insert new ones from the config string.
                 */
                List<String> aSubTags = new ArrayList<>();
                for (SubTag aTag : aMaterial.mSubTags) aSubTags.add(aTag.mName);
                String aDefaultTagString = "," + aSubTags.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigTagString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListSubTags", aDefaultTagString);
                if (!aConfigTagString.equals(aDefaultTagString)) {
                    aMaterial.mSubTags.clear();
                    if (aConfigTagString.length() > 0) {
                        aSubTags = new ArrayList<>(Arrays.asList(aConfigTagString.split(",")));
                        for (String aTagString : aSubTags) {
                            SubTag aTag = SubTag.sSubTags.get(aTagString);
                            if (aTag != null) aMaterial.mSubTags.add(aTag);
                        }
                    }
                }
                /** Same principal as SubTags **/
                List<String> aOreByProducts = new ArrayList<>();
                for (Materials aMat : aMaterial.mOreByProducts) aOreByProducts.add(aMat.mName);
                String aDefaultMatByProString = "," + aOreByProducts.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigMatByProString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListMaterialByProducts", aDefaultMatByProString);
                if (!aConfigMatByProString.equals(aDefaultMatByProString)) {
                    aMaterial.mOreByProducts.clear();
                    if (aConfigMatByProString.length() > 0) {
                        aOreByProducts = new ArrayList<>(Arrays.asList(aConfigMatByProString.split(",")));
                        for (String aMaterialString : aOreByProducts) {
                            Materials aMat = MATERIALS_MAP.get(aMaterialString);
                            if (aMat != null) aMaterial.mOreByProducts.add(aMat);
                        }
                    }
                }
                /** Same principal as SubTags **/
                List<String> aOreReRegistrations = new ArrayList<>();
                for (Materials aMat : aMaterial.mOreReRegistrations) aOreReRegistrations.add(aMat.mName);
                String aDefaultMatReRegString = "," + aOreReRegistrations.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigMatMatReRegString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListMaterialReRegistrations", aDefaultMatReRegString);
                if (!aConfigMatMatReRegString.equals(aDefaultMatReRegString)) {
                    aMaterial.mOreReRegistrations.clear();
                    if (aConfigMatMatReRegString.length() > 0) {
                        aOreReRegistrations = new ArrayList<>(Arrays.asList(aConfigMatMatReRegString.split(",")));
                        for (String aMaterialString : aOreReRegistrations) {
                            Materials aMat = MATERIALS_MAP.get(aMaterialString);
                            if (aMat != null) aMaterial.mOreReRegistrations.add(aMat);
                        }
                    }
                }
                /** Moved the harvest level changes from GT_Mod to have less things iterating over MATERIALS_ARRAY **/
                if (GT_Mod.gregtechproxy.mChangeHarvestLevels && aMaterial.mToolQuality > 0 && aMaterial.mMetaItemSubID < GT_Mod.gregtechproxy.mHarvestLevel.length && aMaterial.mMetaItemSubID >= 0) {
                    GT_Mod.gregtechproxy.mHarvestLevel[aMaterial.mMetaItemSubID] = GregTech_API.sMaterialProperties.get(aConfigPath, "HarvestLevel", aMaterial.mToolQuality);
                }
                /** Moved from GT_Proxy? (Not sure)**/
                aMaterial.mHandleMaterial = (aMaterial == Desh ? aMaterial.mHandleMaterial : aMaterial == Diamond || aMaterial == Thaumium ? Wood : aMaterial.contains(SubTag.BURNING) ? Blaze : aMaterial.contains(SubTag.MAGICAL) && aMaterial.contains(SubTag.CRYSTAL) && aMaterial.getMass() > Element.Tc.getMass() * 2 ? TungstenSteel : aMaterial.getMass() > Element.Tc.getMass() ? Steel : Wood);
            }
            aConfigPathSB.setLength(0);
        }
    }

    public Materials(int aMetaItemSubID, String aName) {
        mMetaItemSubID = aMetaItemSubID;
        mDefaultLocalName = aName;
        mName = aName;
        mIconSet = TextureSet.MATERIALS;
        MATERIALS_MAP.put(mName, this);
        mCustomOre = false;
        mConfigSection = "ore";
        mUnificatable = true;
        mMaterialInto = this;
        mToolQuality = 0;
        mDurability = 0;
        mToolSpeed = 0;
    }
	
	
	/**
	 * @see #setTool(Materials aMaterialInto, float aToolSpeed, int aDurability, int aToolQuality)
	 */
    public Materials setTool(float aToolSpeed, int aDurability, int aToolQuality) {
        mToolSpeed = aToolSpeed;
        mDurability = aDurability;
        mToolQuality = (byte) aToolQuality;
        return this;
    }
	
	/**
	 * @param aMaterialInto Type of Fuel
	 * @param aToolSpeed Speed of tool
	 * @param aDurability aDurability of tool
	 * @param aToolQuality
	 * @return Materials
	 */
	public Materials setTool(Materials aMaterialInto, float aToolSpeed, int aDurability, int aToolQuality) {
		aMaterialInto.mToolSpeed = aToolSpeed;
		aMaterialInto.mDurability = aDurability;
		aMaterialInto.mToolQuality = (byte) aToolQuality;
		return aMaterialInto;
	}
    
    /**
     * @see #setFuel(Materials aMaterialInto, FuelType aFuelType, int aFuelPower)
     */
    public Materials setFuel(FuelType aFuelType, int aFuelPower) {
        mFuelPower = aFuelPower; // aFuelPower * 1000
        mFuelType = aFuelType;
        return this;
    }
    
    /**
     * @param aMaterialInto - Materials refactor
     * @param aFuelType  - Type of Fuel
     * @param aFuelPower - kW/h (including * 1000)
     * @return Materials
     */
    public Materials setFuel(Materials aMaterialInto, FuelType aFuelType, int aFuelPower) {
        aMaterialInto.mFuelPower = aFuelPower; // aFuelPower * 1000
        aMaterialInto.mFuelType = aFuelType;
        return aMaterialInto;
    }
	
	//todo удалить после рефакторинга
	public Materials(int aMetaItemSubID, TextureSet aIconSet, float x1, int x2, int x3, int r, int g, int b, int a, String aName, String aDefaultLocalName, int x4, int x5, int x6, int aMeltingPoint, boolean asdasdasdm, boolean aTransparent, int qq, int qwe, int qee, Dyes aColor, Element aElement, MaterialsValues... materialsValues) {
		this(aMetaItemSubID, new Color(r, g, b, a), aName, 0, aTransparent, aColor, aElement);
	}
	//todo удалить после рефакторинга
	public Materials(int aMetaItemSubID, TextureSet aIconSet, float xx, int x1, int x2, boolean aTransparent, String aName, String aDefaultLocalName) {
		this(aMetaItemSubID, aName);
	}
	//todo удалить после рефакторинга
	public Materials(int aMetaItemSubID, TextureSet aIconSet, float x1, int x2, int x3, int x9, int r, int g, int b, int a, String aName, String aDefaultLocalName, int x4, int x5, int x6, int aMeltingPoint, boolean asdasdasdm, boolean aTransparent, int qq, int qwe, int qee, Dyes aColor) {
		this(aMetaItemSubID, new Color(r, g, b, a), aName, aTransparent, aColor);
	}
	//todo удалить после рефакторинга
	public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList) {
		this(aMetaItemSubID, new Color(aR, aG, aB, aA), aName, aTransparent, aColor);
	}

    public Materials(Materials aMaterialInto, boolean aReRegisterIntoThis) {
        mUnificatable = false;
        mDefaultLocalName = aMaterialInto.mDefaultLocalName;
        mName = aMaterialInto.mName;
        mMaterialInto = aMaterialInto.mMaterialInto;
        if (aReRegisterIntoThis) mMaterialInto.mOreReRegistrations.add(this);
        mChemicalFormula = aMaterialInto.mChemicalFormula;
        mMetaItemSubID = -1;
        mIconSet = TextureSet.SET_NONE;
    }
    
    public Materials(int aMetaItemSubID, Color color, String aName, boolean aTransparent, Dyes aColor, MaterialsValues... materialsValues) {
        this(aMetaItemSubID, color, aName, 0, aTransparent, aColor, null, materialsValues);
    }
    
    public Materials(int aMetaItemSubID, Color color, String aName, int aMeltingPoint, boolean aTransparent, Dyes aColor, Element aElement, MaterialsValues... materialsValues) {
        this(aMetaItemSubID, aName);
        mMeltingPoint = (short) aMeltingPoint;
        mTransparent = aTransparent;
        mColor = aColor;
        mRGBa[0] = mMoltenRGBa[0] = (short)  color.getRed();
        mRGBa[1] = mMoltenRGBa[1] = (short) color.getGreen();
        mRGBa[2] = mMoltenRGBa[2] = (short) color.getBlue();
        mRGBa[3] = mMoltenRGBa[3] = (short) color.getAlpha();
        if (mColor != null) add(SubTag.HAS_COLOR);
        if (mTransparent) add(SubTag.TRANSPARENT);
        if (this.materialsValues.contains(MaterialsValues.INGOT)) {
        	add(SubTag.SMELTING_TO_FLUID);
		}
        
        mElement = aElement;
        if (aElement != null) mElement.mLinkedMaterials.add(this); //todo del
        if (aElement == Element._NULL || aElement == null) {
            mChemicalFormula = "Empty";
        } else {
            mChemicalFormula = aElement.toString();
            mChemicalFormula = mChemicalFormula.replaceAll("_", "-");
        }
        this.materialsValues.addAll(Arrays.asList(materialsValues));
    }
    
    public Materials(int aMetaItemSubID, Color rgba, String aName, boolean aTransparent, Dyes aColor, Element aElement, MaterialsValues... materialsValues) {
        this(aMetaItemSubID, rgba, aName, 0, aTransparent, aColor, aElement, materialsValues);
    }
    
    
    public Materials(int aMetaItemSubID, Color rgba, String aName, boolean aTransparent, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList, MaterialsValues... materialsValues) {
        this(aMetaItemSubID, rgba, aName, 0, aTransparent, aColor, aExtraData, aMaterialList, materialsValues);
    }
    
    public Materials(int aMetaItemSubID, Color rgba, String aName, int aMeltingPoint, boolean aTransparent, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList, MaterialsValues... materialsValues) {
        this(aMetaItemSubID, rgba, aName, aMeltingPoint, aTransparent, aColor, null, materialsValues);
        mExtraData = aExtraData;
        mMaterialList.addAll(aMaterialList);
        mChemicalFormula = "";
        for (MaterialStack tMaterial : mMaterialList) mChemicalFormula += tMaterial.toString();
        mChemicalFormula = mChemicalFormula.replaceAll("_", "-");

        int tAmountOfComponents = 0, tMeltingPoint = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmountOfComponents += tMaterial.mAmount;
            if (tMaterial.mMaterial.mMeltingPoint > 0)
                tMeltingPoint += tMaterial.mMaterial.mMeltingPoint * tMaterial.mAmount;
        }

        if (mMeltingPoint < 0) mMeltingPoint = (short) (tMeltingPoint / tAmountOfComponents);
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public String name() {
        return mName;
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public static Materials valueOf(String aMaterialName) {
        return getMaterialsMap().get(aMaterialName);
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    public static Materials[] values() {
        return MATERIALS_ARRAY;
    }

    /**
     * This should only be used for getting a Material by its name as a String. Do not loop over this map, use values().
     */
    public static Map<String, Materials> getMaterialsMap() {
        return MATERIALS_MAP;
    }

    public static Materials get(String aMaterialName) {
        Materials aMaterial = getMaterialsMap().get(aMaterialName);
        if (aMaterial != null) return aMaterial;
        return Materials._NULL;
    }

    public static Materials getRealMaterial(String aMaterialName) {
        return get(aMaterialName).mMaterialInto;
    }

    public boolean isRadioactive() {
        if (mElement != null) return mElement.mHalfLifeSeconds >= 0;
        for (MaterialStack tMaterial : mMaterialList) if (tMaterial.mMaterial.isRadioactive()) return true;
        return false;
    }

    public long getProtons() {
        if (mElement != null) return mElement.getProtons();
        if (mMaterialList.size() <= 0) return Element.Tc.getProtons();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getProtons();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getNeutrons() {
        if (mElement != null) return mElement.getNeutrons();
        if (mMaterialList.size() <= 0) return Element.Tc.getNeutrons();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getNeutrons();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getMass() {
        if (mElement != null) return mElement.getMass();
        if (mMaterialList.size() <= 0) return Element.Tc.getMass();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getMass();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getDensity() {
        return mDensity;
    }

    public String getToolTip() {
        return getToolTip(1, false);
    }

    public String getToolTip(boolean aShowQuestionMarks) {
        return getToolTip(1, aShowQuestionMarks);
    }

    public String getToolTip(long aMultiplier) {
        return getToolTip(aMultiplier, false);
    }

    public String getToolTip(long aMultiplier, boolean aShowQuestionMarks) {
	
		mChemicalFormula = mChemicalFormula.replaceAll("0", "₀");
		mChemicalFormula = mChemicalFormula.replaceAll("1", "₁");
		mChemicalFormula = mChemicalFormula.replaceAll("2", "₂");
		mChemicalFormula = mChemicalFormula.replaceAll("3", "₃");
		mChemicalFormula = mChemicalFormula.replaceAll("4", "₄");
		mChemicalFormula = mChemicalFormula.replaceAll("5", "₅");
		mChemicalFormula = mChemicalFormula.replaceAll("6", "₆");
		mChemicalFormula = mChemicalFormula.replaceAll("7", "₇");
		mChemicalFormula = mChemicalFormula.replaceAll("8", "₈");
		mChemicalFormula = mChemicalFormula.replaceAll("9", "₉");
		
        if (!aShowQuestionMarks && mChemicalFormula.equals("?")) return "";
        if (aMultiplier >= M * 2 && !mMaterialList.isEmpty()) {
            return ((mElement != null || (mMaterialList.size() < 2 && mMaterialList.get(0).mAmount == 1)) ? mChemicalFormula : "(" + mChemicalFormula + ")") + aMultiplier;
        }
        return mChemicalFormula;
    }
    
    /**
     * Adds a Class implementing IMaterialRegistrator to the master list
     */
    public static boolean add(IMaterialHandler aRegistrator) {
        if (aRegistrator == null) return false;
        return mMaterialHandlers.add(aRegistrator);
    }

    /**
     * Adds an ItemStack to this Material.
     */
    public Materials add(ItemStack aStack) {
        if (aStack != null && !contains(aStack)) mMaterialItems.add(aStack);
        return this;
    }

    /**
     * This is used to determine if any of the ItemStacks belongs to this Material.
     */
    public boolean contains(ItemStack... aStacks) {
        if (aStacks == null || aStacks.length <= 0) return false;
        for (ItemStack tStack : mMaterialItems)
            for (ItemStack aStack : aStacks)
                if (GT_Utility.areStacksEqual(aStack, tStack, !tStack.hasTagCompound())) return true;
        return false;
    }

    /**
     * This is used to determine if an ItemStack belongs to this Material.
     */
    public boolean remove(ItemStack aStack) {
        if (aStack == null) return false;
        boolean temp = false;
        int mMaterialItems_sS=mMaterialItems.size();
        for (int i = 0; i < mMaterialItems_sS; i++)
            if (GT_Utility.areStacksEqual(aStack, mMaterialItems.get(i))) {
                mMaterialItems.remove(i--);
                temp = true;
            }
        return temp;
    }

    /**
     * Adds a SubTag to this Material
     */
    @Override
    public ISubTagContainer add(SubTag... aTags) {
        if (aTags != null) for (SubTag aTag : aTags)
            if (aTag != null && !contains(aTag)) {
                aTag.addContainerToList(this);
                mSubTags.add(aTag);
            }
        return this;
    }

    /**
     * If this Material has this exact SubTag
     */
    @Override
    public boolean contains(SubTag aTag) {
        return mSubTags.contains(aTag);
    }

    /**
     * Removes a SubTag from this Material
     */
    @Override
    public boolean remove(SubTag aTag) {
        return mSubTags.remove(aTag);
    }

    /**
     * Sets the Heat Damage for this Material (negative = frost)
     */
    public Materials setHeatDamage(float aHeatDamage) {
        mHeatDamage = aHeatDamage;
        return this;
    }

    /**
     * Adds a Material to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     */
    public Materials addOreByProduct(Materials aMaterial) {
        if (!mOreByProducts.contains(aMaterial.mMaterialInto)) mOreByProducts.add(aMaterial.mMaterialInto);
        return this;
    }

    /**
     * Adds multiple Materials to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     */
    public Materials addOreByProducts(Materials... aMaterials) {
        for (Materials tMaterial : aMaterials) if (tMaterial != null) addOreByProduct(tMaterial);
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Main Material.
     * Lapis Ore for example gives about 6 drops.
     */
    public Materials setOreMultiplier(int aOreMultiplier) {
        if (aOreMultiplier > 0) mOreMultiplier = aOreMultiplier;
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Byproduct Material.
     */
    public Materials setByProductMultiplier(int aByProductMultiplier) {
        if (aByProductMultiplier > 0) mByProductMultiplier = aByProductMultiplier;
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Main Material.
     * Lapis Ore for example gives about 6 drops.
     */
    public Materials setSmeltingMultiplier(int aSmeltingMultiplier) {
        if (aSmeltingMultiplier > 0) mSmeltingMultiplier = aSmeltingMultiplier;
        return this;
    }

    /**
     * This Ore should be smolten directly into an Ingot of this Material instead of an Ingot of itself.
     */
    public Materials setDirectSmelting(Materials aMaterial) {
        if (aMaterial != null) mDirectSmelting = aMaterial.mMaterialInto.mDirectSmelting;
        return this;
    }

    /**
     * This Material should be the Main Material this Ore gets ground into.
     * Example, Chromite giving Chrome or Tungstate giving Tungsten.
     */
    public Materials setOreReplacement(Materials aMaterial) {
        if (aMaterial != null) mOreReplacement = aMaterial.mMaterialInto.mOreReplacement;
        return this;
    }

    /**
     * This Material smelts always into an instance of aMaterial. Used for Magnets.
     */
    public Materials setSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mSmeltInto = aMaterial.mMaterialInto.mSmeltInto;
        return this;
    }

    /**
     * This Material arc smelts always into an instance of aMaterial. Used for Wrought Iron.
     */
    public Materials setArcSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mArcSmeltInto = aMaterial.mMaterialInto.mArcSmeltInto;
        return this;
    }

    /**
     * This Material macerates always into an instance of aMaterial.
     */
    public Materials setMaceratingInto(Materials aMaterial) {
        if (aMaterial != null) mMacerateInto = aMaterial.mMaterialInto.mMacerateInto;
        return this;
    }

    public Materials setEnchantmentForTools(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentTools = aEnchantment;
        mEnchantmentToolsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    public Materials setEnchantmentForArmors(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentArmors = aEnchantment;
        mEnchantmentArmorsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    public FluidStack getSolid(long aAmount) {
        if (mSolid == null) return null;
        return new GT_FluidStack(mSolid, (int) aAmount);
    }

    public FluidStack getFluid(long aAmount) {
        if (mFluid == null) return null;
        return new GT_FluidStack(mFluid, (int) aAmount);
    }

    public FluidStack getGas(long aAmount) {
        if (mGas == null) return null;
        return new GT_FluidStack(mGas, (int) aAmount);
    }

    public FluidStack getPlasma(long aAmount) {
        if (mPlasma == null) return null;
        return new GT_FluidStack(mPlasma, (int) aAmount);
    }

    public FluidStack getMolten(long aAmount) {
        if (mStandardMoltenFluid == null) return null;
        return new GT_FluidStack(mStandardMoltenFluid, (int) aAmount);
    }

    public String getDefaultLocalizedNameForItem(String aFormat) {
    	return String.format(aFormat.replace("%s", "%temp").replace("%material", "%s"), this.mDefaultLocalName).replace("%temp", "%s");
    }

    public String getLocalizedNameForItem(String aFormat) {
    	return String.format(aFormat.replace("%s", "%temp").replace("%material", "%s"), this.mLocalizedName).replace("%temp", "%s");
    }

    public static String getLocalizedNameForItem(String aFormat, int aMaterialID) {
    	if (aMaterialID >= 0 && aMaterialID < 1000) {
    		Materials aMaterial = GregTech_API.sGeneratedMaterials[aMaterialID];
    		if (aMaterial != null)
    			return aMaterial.getLocalizedNameForItem(aFormat);
    	}
    	return aFormat;
    }

    @Override
    public short[] getRGBA() {
        return mRGBa;
    }

    @Override
    public String toString() {
        return this.mName;
    }

    public static volatile int VERSION = 509;
    
    public static Collection<Materials> getAll(){
    	return MATERIALS_MAP.values();
    }
    
	public boolean hasCorrespondingFluid() {
		if (materialsValues.contains(MaterialsValues.FLUID)) {
			hasCorrespondingFluid = true;
		}
		return hasCorrespondingFluid;
	}

	public Materials setHasCorrespondingFluid(boolean hasCorrespondingFluid) {
		this.hasCorrespondingFluid = hasCorrespondingFluid;
		return this;
	}

	public boolean hasCorrespondingGas() {
    	if (materialsValues.contains(MaterialsValues.GAS)) {
    		hasCorrespondingGas = true;
		}
		return hasCorrespondingGas;
	}

	public Materials setHasCorrespondingGas(boolean hasCorrespondingGas) {
		this.hasCorrespondingGas = hasCorrespondingGas;
		return this;
	}

	public boolean canBeCracked() {
		return canBeCracked;
	}
	
	public Materials setCanBeCracked(boolean canBeCracked) {
		this.canBeCracked = canBeCracked;
		return this;
	}
	
	public int getLiquidTemperature() {
		return mMeltingPoint == 0 ? 295 : mMeltingPoint;
	}

	public Materials setLiquidTemperature(int liquidTemperature) {
		this.mMeltingPoint = (short) liquidTemperature;
		return this;
	}

	public Materials setHydroCrackedFluid(Fluid hydroCrackedFluid) {
		this.hydroCrackedFluid = hydroCrackedFluid;
		return this;
	}
	
	public FluidStack getHydroCracked(int amount) {
		if (hydroCrackedFluid == null) {
			return null;
		}
		return new FluidStack(hydroCrackedFluid, amount);
	}
	
	public Materials setSteamCrackedFluid(Fluid steamCrackedFluid) {
		this.steamCrackedFluid = steamCrackedFluid;
		return this;
	}
	
	public FluidStack getSteamCracked(int amount) {
		if (hydroCrackedFluid == null) {
			return null;
		}
		return new FluidStack(steamCrackedFluid, amount);
	}
	
	public int getGasTemperature() {
		return mGasTemp == 0 ? 295 : mMeltingPoint;
	}

	public Materials setGasTemperature(int gasTemperature) {
		this.mGasTemp = (short) gasTemperature;
		return this;
	}
	
	public ItemStack getCells(int amount) {
		return this.equals(Empty) ? ItemList.Cell_Empty.get(amount) : GT_OreDictUnificator.get(OrePrefixes.cell, this, amount);
	}
	
	public ItemStack getDust(int amount){
		return GT_OreDictUnificator.get(OrePrefixes.dust, this, amount);
	}
	
	public ItemStack getGems(int amount){
		return GT_OreDictUnificator.get(OrePrefixes.gem, this, amount);
	}
	
    public ItemStack getIngots(int amount){
    	return GT_OreDictUnificator.get(OrePrefixes.ingot, this, amount);
    }

    public ItemStack getBlocks(int amount){
    	return GT_OreDictUnificator.get(OrePrefixes.block, this, amount);
    }
    
    public ItemStack getPlates(int amount){
    	return GT_OreDictUnificator.get(OrePrefixes.plate, this, amount);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Materials && mMetaItemSubID == ((Materials)o).mMetaItemSubID;
    }

    @Override
    public int hashCode() {
        return mMetaItemSubID*31;
    }
}
