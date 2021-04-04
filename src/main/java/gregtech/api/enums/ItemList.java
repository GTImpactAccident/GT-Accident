package gregtech.api.enums;

import gregtech.api.interfaces.IItemContainer;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import static gregtech.api.enums.GT_Values.W;

/**
 * Class containing all non-OreDict Items of GregTech.
 */
public enum ItemList implements IItemContainer {
    Display_ITS_FREE,
    Display_Fluid,
    TE_Slag,
    TE_Slag_Rich,
    TE_Rockwool,
    TE_Hardened_Glass,
    FR_Lemon,
    FR_Mulch,
    FR_Fertilizer,
    FR_Compost,
    FR_Silk,
    FR_Wax,
    FR_RefractoryWax,
    FR_WaxCapsule,
    FR_RefractoryCapsule,
    FR_Stick,
    FR_Casing_Impregnated,
    FR_Casing_Sturdy,
    FR_Casing_Hardened,
    FR_Bee_Drone,
    FR_Bee_Princess,
    FR_Bee_Queen,
    FR_Tree_Sapling,
    FR_Butterfly,
    FR_Larvae,
    FR_Serum,
    FR_Caterpillar,
    FR_PollenFertile,
    TF_LiveRoot,
    TF_Vial_FieryBlood,
    TF_Vial_FieryTears,
    RC_ShuntingWire,
    RC_ShuntingWireFrame,
    RC_Rail_Reinforced,
    RC_Rail_Electric,
    RC_Rail_Standard,
    RC_Rail_Wooden,
    RC_Rail_Adv,
    RC_Rail_HS,
    RC_Tie_Wood,
    RC_Tie_Stone,
    RC_Bed_Wood,
    RC_Bed_Stone,
    RC_Rebar,
    IC2_Item_Casing_Tin,
    IC2_Item_Casing_Copper,
    IC2_Item_Casing_Iron,
    IC2_Item_Casing_Steel,
    IC2_Item_Casing_Lead,
    IC2_Item_Casing_Bronze,
    IC2_Item_Casing_Gold,
    IC2_Spray_WeedEx,
    IC2_Scrap,
    IC2_Scrapbox,
    IC2_Fertilizer,
    IC2_Mixed_Metal_Ingot,
    IC2_Hops,
    IC2_Resin,
    IC2_Plantball,
    IC2_PlantballCompressed,
    IC2_CoffeeBeans,
    IC2_CoffeePowder,
    IC2_Crop_Seeds,
    IC2_Grin_Powder,
    IC2_Energium_Dust,
    IC2_Compressed_Coal_Ball,
    IC2_Compressed_Coal_Chunk,
    IC2_Fuel_Rod_Empty,
    IC2_Fuel_Can_Empty,
    IC2_Fuel_Can_Filled,
    IC2_Food_Can_Empty,
    IC2_Food_Can_Filled,
    IC2_Food_Can_Spoiled,
    IC2_ShaftIron,
    IC2_ShaftSteel,
    IC2_Industrial_Diamond,
    IC2_ForgeHammer,
    IC2_WireCutter,
    IC2_SuBattery,
    IC2_ReBattery,
    IC2_AdvBattery,
    IC2_EnergyCrystal,
    IC2_LapotronCrystal,
    Arrow_Head_Glass_Emtpy,
    Arrow_Head_Glass_Poison,
    Arrow_Head_Glass_Poison_Long,
    Arrow_Head_Glass_Poison_Strong,
    Arrow_Head_Glass_Slowness,
    Arrow_Head_Glass_Slowness_Long,
    Arrow_Head_Glass_Weakness,
    Arrow_Head_Glass_Weakness_Long,
    Arrow_Head_Glass_Holy_Water,
    Arrow_Wooden_Glass_Emtpy,
    Arrow_Wooden_Glass_Poison,
    Arrow_Wooden_Glass_Poison_Long,
    Arrow_Wooden_Glass_Poison_Strong,
    Arrow_Wooden_Glass_Slowness,
    Arrow_Wooden_Glass_Slowness_Long,
    Arrow_Wooden_Glass_Weakness,
    Arrow_Wooden_Glass_Weakness_Long,
    Arrow_Wooden_Glass_Holy_Water,
    Arrow_Plastic_Glass_Emtpy,
    Arrow_Plastic_Glass_Poison,
    Arrow_Plastic_Glass_Poison_Long,
    Arrow_Plastic_Glass_Poison_Strong,
    Arrow_Plastic_Glass_Slowness,
    Arrow_Plastic_Glass_Slowness_Long,
    Arrow_Plastic_Glass_Weakness,
    Arrow_Plastic_Glass_Weakness_Long,
    Arrow_Plastic_Glass_Holy_Water,
    Shape_Empty,
    Shape_Mold_Bottle,
    Shape_Mold_Plate,
    Shape_Mold_Ingot,
    Shape_Mold_Casing,
    Shape_Mold_Gear,
    Shape_Mold_Gear_Small,
    Shape_Mold_Credit,
    Shape_Mold_Nugget,
    Shape_Mold_Block,
    Shape_Mold_Ball,
    Shape_Mold_Bun,
    Shape_Mold_Bread,
    Shape_Mold_Baguette,
    Shape_Mold_Cylinder,
    Shape_Mold_Anvil,
    Shape_Mold_Arrow,
    Shape_Mold_Name,
    Shape_Slicer_Flat,
    Shape_Slicer_Stripes,
    Shape_Extruder_Bottle,
    Shape_Extruder_Plate,
    Shape_Extruder_Cell,
    Shape_Extruder_Ring,
    Shape_Extruder_Rod,
    Shape_Extruder_Bolt,
    Shape_Extruder_Ingot,
    Shape_Extruder_Wire,
    Shape_Extruder_Casing,
    Shape_Extruder_Pipe_Tiny,
    Shape_Extruder_Pipe_Small,
    Shape_Extruder_Pipe_Medium,
    Shape_Extruder_Pipe_Large,
    Shape_Extruder_Pipe_Huge,
    Shape_Extruder_Block,
    Shape_Extruder_Sword,
    Shape_Extruder_Pickaxe,
    Shape_Extruder_Shovel,
    Shape_Extruder_Axe,
    Shape_Extruder_Hoe,
    Shape_Extruder_Hammer,
    Shape_Extruder_File,
    Shape_Extruder_Saw,
    Shape_Extruder_Gear,
    Shape_Extruder_Gear_Small,
    Crate_Empty,
    Credit_Copper,
    Credit_Iron,
    Credit_Silver,
    Credit_Gold,
    Credit_Platinum,
    Credit_Osmium,
    Credit_Greg_Copper,
    Credit_Greg_Cupronickel,
    Credit_Greg_Silver,
    Credit_Greg_Gold,
    Credit_Greg_Platinum,
    Credit_Greg_Osmium,
    Credit_Greg_Naquadah,
    Credit_Greg_Neutronium,
    Coin_Gold_Ancient,
    Coin_Doge,
    Coin_Chocolate,
    Cell_Universal_Fluid,
    Cell_Empty,
    Cell_Water,
    Cell_Lava,
    Cell_Air,
    Large_Fluid_Cell_Steel,
    Large_Fluid_Cell_TungstenSteel,
    ThermosCan_Empty,
    ThermosCan_Dark_Coffee,
    ThermosCan_Dark_Cafe_au_lait,
    ThermosCan_Coffee,
    ThermosCan_Cafe_au_lait,
    ThermosCan_Lait_au_cafe,
    ThermosCan_Dark_Chocolate_Milk,
    ThermosCan_Chocolate_Milk,
    ThermosCan_Tea,
    ThermosCan_Sweet_Tea,
    ThermosCan_Ice_Tea,
    Food_Potato_On_Stick,
    Food_Potato_On_Stick_Roasted,
    Food_Fries,
    Food_ChiliChips,
    Food_PotatoChips,
    Food_Baked_Potato,
    Food_Poisonous_Potato,
    Food_Cheese,
    Food_Chum,
    Food_Chum_On_Stick,
    Food_Dough,
    Food_Dough_Sugar,
    Food_Dough_Chocolate,
    Food_Raw_Cookie,
    Food_Flat_Dough,
    Food_Burger_Veggie,
    Food_Burger_Cheese,
    Food_Burger_Meat,
    Food_Burger_Chum,
    Food_Sandwich_Veggie,
    Food_Sandwich_Cheese,
    Food_Sandwich_Bacon,
    Food_Sandwich_Steak,
    Food_Large_Sandwich_Veggie,
    Food_Large_Sandwich_Cheese,
    Food_Large_Sandwich_Bacon,
    Food_Large_Sandwich_Steak,
    Food_Sliced_Lemon,
    Food_Sliced_Tomato,
    Food_Sliced_Onion,
    Food_Sliced_Cucumber,
    Food_Sliced_Cheese,
    Food_Sliced_Bread,
    Food_Sliced_Bun,
    Food_Sliced_Baguette,
    Food_Sliced_Breads,
    Food_Sliced_Buns,
    Food_Sliced_Baguettes,
    Food_Packaged_Fries,
    Food_Packaged_PotatoChips,
    Food_Packaged_ChiliChips,
    Food_Raw_Potato,
    Food_Raw_Fries,
    Food_Raw_PotatoChips,
    Food_Raw_Bread,
    Food_Raw_Bun,
    Food_Raw_Baguette,
    Food_Raw_Cake,
    Food_Raw_Pizza_Veggie,
    Food_Raw_Pizza_Cheese,
    Food_Raw_Pizza_Meat,
    Food_Baked_Bread,
    Food_Baked_Bun,
    Food_Baked_Baguette,
    Food_Baked_Cake,
    Food_Baked_Pizza_Veggie,
    Food_Baked_Pizza_Cheese,
    Food_Baked_Pizza_Meat,
    Crop_Drop_Argentia,
    Crop_Drop_Plumbilia,
    Crop_Drop_Indigo,
    Crop_Drop_Ferru,
    Crop_Drop_Aurelia,
    Crop_Drop_OilBerry,
    Crop_Drop_MilkWart,
    Crop_Drop_BobsYerUncleRanks,
    Crop_Drop_Coppon,
    Crop_Drop_Tine,
    Crop_Drop_Chilly,
    Crop_Drop_Lemon,
    Crop_Drop_Onion,
    Crop_Drop_Tomato,
    Crop_Drop_MTomato,
    Crop_Drop_Grapes,
    Crop_Drop_TeaLeaf,
    Crop_Drop_Cucumber,
    Crop_Drop_Rape,
    Schematic,
    Schematic_Crafting,
    Schematic_1by1,
    Schematic_2by2,
    Schematic_3by3,
    Schematic_Dust,
    Circuit_Integrated,
    Circuit_Board_Basic,
    Circuit_Board_Advanced,
    Circuit_Board_Elite,
    Circuit_Parts_Advanced,
    Circuit_Parts_Wiring_Basic,
    Circuit_Parts_Wiring_Advanced,
    Circuit_Parts_Wiring_Elite,
    Circuit_Parts_Crystal_Chip_Elite,
    Circuit_Parts_Crystal_Chip_Master,
    Circuit_Primitive,
    Circuit_Basic,
    Circuit_Good,
    Circuit_Advanced,
    Circuit_Data,
    Circuit_Elite,
    Circuit_Master,
    Circuit_Ultimate,
    Rotor_LV, Rotor_MV, Rotor_HV, Rotor_EV, Rotor_IV, Rotor_LuV, Rotor_ZPM, Rotor_UV,
    Electric_Motor_LV, Electric_Motor_MV, Electric_Motor_HV, Electric_Motor_EV, Electric_Motor_IV, Electric_Motor_LuV, Electric_Motor_ZPM, Electric_Motor_UV,
    Electric_Pump_LV, Electric_Pump_MV, Electric_Pump_HV, Electric_Pump_EV, Electric_Pump_IV, Electric_Pump_LuV, Electric_Pump_ZPM, Electric_Pump_UV,
    Conveyor_Module_LV, Conveyor_Module_MV, Conveyor_Module_HV, Conveyor_Module_EV, Conveyor_Module_IV, Conveyor_Module_LuV, Conveyor_Module_ZPM, Conveyor_Module_UV,
    Electric_Piston_LV, Electric_Piston_MV, Electric_Piston_HV, Electric_Piston_EV, Electric_Piston_IV, Electric_Piston_LuV, Electric_Piston_ZPM, Electric_Piston_UV,
    Field_Generator_LV, Field_Generator_MV, Field_Generator_HV, Field_Generator_EV, Field_Generator_IV, Field_Generator_LuV, Field_Generator_ZPM, Field_Generator_UV,
    Robot_Arm_LV, Robot_Arm_MV, Robot_Arm_HV, Robot_Arm_EV, Robot_Arm_IV, Robot_Arm_LuV, Robot_Arm_ZPM, Robot_Arm_UV,
    Emitter_LV, Emitter_MV, Emitter_HV, Emitter_EV, Emitter_IV, Emitter_LuV, Emitter_ZPM, Emitter_UV,
    Sensor_LV, Sensor_MV, Sensor_HV, Sensor_EV, Sensor_IV, Sensor_LuV, Sensor_ZPM, Sensor_UV,
    Battery_Hull_LV, Battery_Hull_MV, Battery_Hull_HV,
    Battery_SU_LV_SulfuricAcid,
    Battery_SU_LV_Mercury,
    Battery_SU_MV_SulfuricAcid,
    Battery_SU_MV_Mercury,
    Battery_SU_HV_SulfuricAcid,
    Battery_SU_HV_Mercury,
    Battery_RE_ULV_Tantalum,
    Battery_RE_LV_Cadmium,
    Battery_RE_LV_Lithium,
    Battery_RE_LV_Sodium,
    Battery_RE_MV_Cadmium,
    Battery_RE_MV_Lithium,
    Battery_RE_MV_Sodium,
    Battery_RE_HV_Cadmium,
    Battery_RE_HV_Lithium,
    Battery_RE_HV_Sodium,
    ZPM,
    Fuel_Can_Plastic_Empty,
    Fuel_Can_Plastic_Filled,
    Upgrade_Battery,
    Upgrade_Overclocker,
    Upgrade_Muffler,
    Upgrade_SteamEngine,
    Upgrade_Lock,
    Cover_Controller,
    Cover_ActivityDetector,
    Cover_FluidDetector,
    Cover_ItemDetector,
    Cover_EnergyDetector,
    Cover_Drain,
    Cover_Shutter,
    Cover_Crafting,
    Cover_Screen,
    Cover_SolarPanel,
    Cover_SolarPanel_8V,
    Cover_SolarPanel_LV,
    Cover_SolarPanel_MV,
    Cover_SolarPanel_HV,
    Cover_SolarPanel_EV,
    Cover_SolarPanel_IV,
    Cover_SolarPanel_LuV,
    Cover_SolarPanel_ZPM,
    Cover_SolarPanel_UV,
    Cover_CreativeWaterLoader,
    Ingot_IridiumAlloy,
    Plank_Oak,
    Plank_Spruce,
    Plank_Birch,
    Plank_Jungle,
    Plank_Acacia,
    Plank_DarkOak,
    Plank_Larch,
    Plank_Teak,
    Plank_Acacia_Green,
    Plank_Lime,
    Plank_Chestnut,
    Plank_Wenge,
    Plank_Baobab,
    Plank_Sequoia,
    Plank_Kapok,
    Plank_Ebony,
    Plank_Mahagony,
    Plank_Balsa,
    Plank_Willow,
    Plank_Walnut,
    Plank_Greenheart,
    Plank_Cherry,
    Plank_Mahoe,
    Plank_Poplar,
    Plank_Palm,
    Plank_Papaya,
    Plank_Pine,
    Plank_Plum,
    Plank_Maple,
    Plank_Citrus,
    Dye_Indigo,
    Dye_SquidInk,
    Dye_Bonemeal,
    Dye_Cocoa,
    Duct_Tape,
    Book_Written_00,
    Book_Written_01,
    Book_Written_02,
    Book_Written_03,
    Paper_Printed_Pages,
    Paper_Magic_Empty,
    Paper_Magic_Page,
    Paper_Magic_Pages,
    Paper_Punch_Card_Empty,
    Paper_Punch_Card_Encoded,
    McGuffium_239,
    NC_SensorCard,
    NC_SensorKit,
    Tool_Matches,
    Tool_MatchBox_Used,
    Tool_MatchBox_Full,
    Tool_Lighter_Invar_Empty,
    Tool_Lighter_Invar_Used,
    Tool_Lighter_Invar_Full,
    Tool_Lighter_Platinum_Empty,
    Tool_Lighter_Platinum_Used,
    Tool_Lighter_Platinum_Full,
    Tool_Cheat,
    Tool_Scanner,
    Tool_DataOrb,
    Tool_DataStick,
    Tool_Sonictron,
    Tool_Sword_Bronze,
    Tool_Pickaxe_Bronze,
    Tool_Shovel_Bronze,
    Tool_Axe_Bronze,
    Tool_Hoe_Bronze,
    Tool_Sword_Steel,
    Tool_Pickaxe_Steel,
    Tool_Shovel_Steel,
    Tool_Axe_Steel,
    Tool_Hoe_Steel,

    Spray_Empty, Spray_Bug, Spray_Ice, Spray_Hardener, Spray_CFoam, Spray_Pepper, Spray_Hydration,
    Color_00, Color_01, Color_02, Color_03, Color_04, Color_05, Color_06, Color_07, Color_08, Color_09, Color_10, Color_11, Color_12, Color_13, Color_14, Color_15,
    Spray_Color_00, Spray_Color_01, Spray_Color_02, Spray_Color_03, Spray_Color_04, Spray_Color_05, Spray_Color_06, Spray_Color_07, Spray_Color_08, Spray_Color_09, Spray_Color_10, Spray_Color_11, Spray_Color_12, Spray_Color_13, Spray_Color_14, Spray_Color_15,
    Spray_Color_Used_00, Spray_Color_Used_01, Spray_Color_Used_02, Spray_Color_Used_03, Spray_Color_Used_04, Spray_Color_Used_05, Spray_Color_Used_06, Spray_Color_Used_07, Spray_Color_Used_08, Spray_Color_Used_09, Spray_Color_Used_10, Spray_Color_Used_11, Spray_Color_Used_12, Spray_Color_Used_13, Spray_Color_Used_14, Spray_Color_Used_15,

    Armor_Cheat,
    Armor_Cloaking,
    Armor_Lamp,
    Armor_LithiumPack,
    Armor_LapotronicPack,
    Armor_ForceField,
    Energy_LapotronicOrb,
    Reactor_NeutronReflector,
    Component_Turbine_Bronze,
    Component_Turbine_Steel,
    Component_Turbine_Magnalium,
    Component_Turbine_TungstenSteel,
    Component_Turbine_Carbon,
    Component_LavaFilter,
    Component_Sawblade_Diamond,
    Component_Grinder_Diamond,
    Component_Grinder_Tungsten,
    Component_Filter,
    Component_Minecart_Wheels_Iron,
    Component_Minecart_Wheels_Steel,

    Casing_ULV, Casing_LV, Casing_MV, Casing_HV, Casing_EV, Casing_IV, Casing_LuV, Casing_ZPM, Casing_UV, Casing_MAX, Casing_BronzePlatedBricks, Casing_HeatProof, Casing_Coil_Cupronickel_Deprecated, Casing_Coil_Kanthal_Deprecated, Casing_Coil_Nichrome_Deprecated, Casing_Coil_Superconductor,
    Casing_SolidSteel, Casing_FrostProof, Casing_Gearbox_Bronze, Casing_Gearbox_Steel, Casing_Gearbox_Titanium, Casing_Gearbox_TungstenSteel, Casing_Processor, Casing_DataDrive, Casing_ContainmentField, Casing_Assembler, Casing_Pump, Casing_Motor, Casing_Pipe_Bronze, Casing_Pipe_Steel, Casing_Pipe_Titanium, Casing_Pipe_TungstenSteel, Casing_Pipe_Polytetrafluoroethylene,
    Casing_Stripes_A, Casing_Stripes_B, Casing_RadioactiveHazard, Casing_BioHazard, Casing_ExplosionHazard, Casing_FireHazard, Casing_AcidHazard, Casing_MagicHazard, Casing_FrostHazard, Casing_NoiseHazard, Casing_Grate, Casing_Vent, Casing_RadiationProof, Casing_Firebox_Bronze, Casing_Firebox_Steel, Casing_Firebox_TungstenSteel, Casing_Chemically_Inert,
    Casing_MiningOsmiridium, Casing_RobustTungstenSteel, Casing_CleanStainlessSteel, Casing_StableTitanium, Casing_Firebox_Titanium, Casing_RobustHSSG,
    Hull_ULV, Hull_LV, Hull_MV, Hull_HV, Hull_EV, Hull_IV, Hull_LuV, Hull_ZPM, Hull_UV, Hull_MAX,
    CompressedFireclay, Firebrick, Casing_Firebricks,

    Hatch_Dynamo_ULV, Hatch_Dynamo_LV, Hatch_Dynamo_MV, Hatch_Dynamo_HV, Hatch_Dynamo_EV, Hatch_Dynamo_IV, Hatch_Dynamo_LuV, Hatch_Dynamo_ZPM, Hatch_Dynamo_UV, Hatch_Dynamo_MAX,
    Hatch_Energy_ULV, Hatch_Energy_LV, Hatch_Energy_MV, Hatch_Energy_HV, Hatch_Energy_EV, Hatch_Energy_IV, Hatch_Energy_LuV, Hatch_Energy_ZPM, Hatch_Energy_UV, Hatch_Energy_MAX,
    Hatch_Input_ULV, Hatch_Input_LV, Hatch_Input_MV, Hatch_Input_HV, Hatch_Input_EV, Hatch_Input_IV, Hatch_Input_LuV, Hatch_Input_ZPM, Hatch_Input_UV, Hatch_Input_MAX,
    Hatch_Input_Bus_ULV, Hatch_Input_Bus_LV, Hatch_Input_Bus_MV, Hatch_Input_Bus_HV, Hatch_Input_Bus_EV, Hatch_Input_Bus_IV, Hatch_Input_Bus_LuV, Hatch_Input_Bus_ZPM, Hatch_Input_Bus_UV, Hatch_Input_Bus_MAX,
    Hatch_Output_ULV, Hatch_Output_LV, Hatch_Output_MV, Hatch_Output_HV, Hatch_Output_EV, Hatch_Output_IV, Hatch_Output_LuV, Hatch_Output_ZPM, Hatch_Output_UV, Hatch_Output_MAX, Hatch_Output_Creative,
    Hatch_Output_Bus_ULV, Hatch_Output_Bus_LV, Hatch_Output_Bus_MV, Hatch_Output_Bus_HV, Hatch_Output_Bus_EV, Hatch_Output_Bus_IV, Hatch_Output_Bus_LuV, Hatch_Output_Bus_ZPM, Hatch_Output_Bus_UV, Hatch_Output_Bus_MAX,
    Hatch_Muffler_LV, Hatch_Muffler_MV, Hatch_Muffler_HV, Hatch_Muffler_EV, Hatch_Muffler_IV, Hatch_Muffler_LuV, Hatch_Muffler_ZPM, Hatch_Muffler_UV, Hatch_Muffler_MAX,
    Hatch_Maintenance, Hatch_DataAccess_EV, Hatch_DataAccess_LuV,
    Circuit_Integrated_Good,
    Neutron_Reflector,
    Reactor_Coolant_He_1, Reactor_Coolant_He_3, Reactor_Coolant_He_6, Reactor_Coolant_NaK_1, Reactor_Coolant_NaK_3, Reactor_Coolant_NaK_6,
    ThoriumCell_1, ThoriumCell_2, ThoriumCell_4,
    Casing_Fusion_Coil, Casing_Fusion, Casing_Fusion2,
    Generator_Plasma_IV, Generator_Plasma_LuV, Generator_Plasma_ZPMV,
    Depleted_Thorium_1, Depleted_Thorium_2, Depleted_Thorium_4,
    Processing_Array,  Advanced_Processing_Array, Distillation_Tower, Energy_LapotronicOrb2,
    Energy_Module, Energy_Cluster,
    ZPM2,

    NULL, Cover_RedstoneTransmitterExternal, Cover_RedstoneTransmitterInternal, Cover_RedstoneReceiverExternal, Cover_RedstoneReceiverInternal,
    Ingot_Heavy1, Ingot_Heavy2, Ingot_Heavy3,
    Cover_NeedsMaintainance, Casing_Turbine, Casing_Turbine1, Casing_Turbine2, Casing_Turbine3, Casing_EngineIntake,
    Casing_Coil_Cupronickel, Casing_Coil_Kanthal, Casing_Coil_Nichrome, Casing_Coil_TungstenSteel, Casing_Coil_HSSG, Casing_Coil_Naquadah, Casing_Coil_NaquadahAlloy,
    Cover_PlayerDetector,
    Block_BronzePlate, Block_IridiumTungstensteel, Block_Plascrete, Block_Plascrete_Window, Block_TungstenSteelReinforced,
    Honeycomb, Block_BrittleCharcoal, Crop_Drop_UUMBerry, Crop_Drop_UUABerry, Empty_Board_Basic, Empty_Board_Elite,
    Crop_Drop_Bauxite, Crop_Drop_Ilmenite, Crop_Drop_Pitchblende, Crop_Drop_Uraninite, Crop_Drop_Thorium, Crop_Drop_Nickel, Crop_Drop_Zinc, Crop_Drop_Manganese, Crop_Drop_Scheelite, Crop_Drop_Platinum, Crop_Drop_Iridium, Crop_Drop_Osmium, Crop_Drop_Naquadah, Uraniumcell_1, Uraniumcell_2, Uraniumcell_4, Moxcell_1, Moxcell_2, Moxcell_4,
    Block_Powderbarrel, GelledToluene,
    FluidRegulator_LV, FluidRegulator_MV, FluidRegulator_HV, FluidRegulator_EV, FluidRegulator_IV, FluidRegulator_LuV, FluidRegulator_ZPM, FluidRegulator_UV, FluidFilter, CuringOven, Machine_Multi_Assemblyline, Machine_Multi_DieselEngine, QuantumEye, QuantumStar, Gravistar, Block_MSSFUEL, SFMixture, MSFMixture, Depleted_Naquadah_1, Depleted_Naquadah_2, Depleted_Naquadah_4, NaquadahCell_1, NaquadahCell_2, NaquadahCell_4, Hatch_AutoMaintenance,
    Circuit_Board_Coated, Circuit_Board_Phenolic, Circuit_Board_Epoxy, Circuit_Board_Fiberglass, Circuit_Board_Multifiberglass, Circuit_Board_Wetware, Circuit_Board_Plastic,
    Circuit_Parts_Resistor, Circuit_Parts_ResistorSMD, Circuit_Parts_Glass_Tube, Circuit_Parts_Vacuum_Tube, Circuit_Parts_Coil, Circuit_Parts_Diode, Circuit_Parts_DiodeSMD, Circuit_Parts_Transistor, Circuit_Parts_TransistorSMD, Circuit_Parts_Capacitor, Circuit_Parts_CapacitorSMD, Circuit_Parts_GlassFiber, Circuit_Parts_PetriDish,
    Circuit_Silicon_Ingot, Circuit_Silicon_Ingot2, Circuit_Silicon_Ingot3, Circuit_Silicon_Wafer, Circuit_Silicon_Wafer2, Circuit_Silicon_Wafer3, Circuit_Wafer_ILC, Circuit_Chip_ILC, Circuit_Wafer_Ram, Circuit_Chip_Ram,
    Circuit_Wafer_NAND, Circuit_Chip_NAND, Circuit_Wafer_NOR, Circuit_Chip_NOR, Circuit_Wafer_CPU, Circuit_Chip_CPU, Circuit_Wafer_SoC, Circuit_Chip_SoC, Circuit_Wafer_SoC2, Circuit_Chip_SoC2, Circuit_Wafer_PIC, Circuit_Chip_PIC,
    Circuit_Wafer_HPIC, Circuit_Chip_HPIC, Circuit_Wafer_NanoCPU, Circuit_Chip_NanoCPU, Circuit_Wafer_QuantumCPU, Circuit_Chip_QuantumCPU,
    Circuit_Chip_CrystalCPU, Circuit_Chip_CrystalSoC, Circuit_Chip_NeuroCPU, Circuit_Chip_Stemcell,
    Circuit_Microprocessor, Circuit_Processor, Circuit_Computer, Circuit_Nanoprocessor, Circuit_Nanocomputer, Circuit_Elitenanocomputer, Circuit_Quantumprocessor, Circuit_Quantumcomputer, Circuit_Masterquantumcomputer, 
    Circuit_Quantummainframe, Circuit_Crystalprocessor, Circuit_Crystalcomputer, Circuit_Ultimatecrystalcomputer, Circuit_Crystalmainframe, Circuit_Neuroprocessor, Circuit_Wetwarecomputer, Circuit_Wetwaresupercomputer, Circuit_Wetwaremainframe, Circuit_Parts_RawCrystalChip,

    VOLUMETRIC_FLASK,
    Solvent_Spray, Solvent_Spray_Used, ProspectorsBook, ProspectorsBookCreative, FluidFilterItem, SimpleFluidFilterItem, PrimitiveFluidFilterItem, ItemWaterProofUpgrade, Casing_Filter_ULV, Casing_Filter_LV, Casing_Filter_MV, Casing_Filter_HV, Casing_Filter_EV, Casing_Filter_IV,
    Tool_DataReader_MV, Tool_DataReader_EV, Tool_CD, Machine_Debug_LagCreator;

    public static final ItemList[]
            DYE_ONLY_ITEMS = {Color_00, Color_01, Color_02, Color_03, Color_04, Color_05, Color_06, Color_07, Color_08, Color_09, Color_10, Color_11, Color_12, Color_13, Color_14, Color_15},
            SPRAY_CAN_DYES = {Spray_Color_00, Spray_Color_01, Spray_Color_02, Spray_Color_03, Spray_Color_04, Spray_Color_05, Spray_Color_06, Spray_Color_07, Spray_Color_08, Spray_Color_09, Spray_Color_10, Spray_Color_11, Spray_Color_12, Spray_Color_13, Spray_Color_14, Spray_Color_15},
            SPRAY_CAN_DYES_USED = {Spray_Color_Used_00, Spray_Color_Used_01, Spray_Color_Used_02, Spray_Color_Used_03, Spray_Color_Used_04, Spray_Color_Used_05, Spray_Color_Used_06, Spray_Color_Used_07, Spray_Color_Used_08, Spray_Color_Used_09, Spray_Color_Used_10, Spray_Color_Used_11, Spray_Color_Used_12, Spray_Color_Used_13, Spray_Color_Used_14, Spray_Color_Used_15},
            MACHINE_HULLS = {Hull_ULV, Hull_LV, Hull_MV, Hull_HV, Hull_EV, Hull_IV, Hull_LuV, Hull_ZPM, Hull_UV, Hull_MAX},
            HATCHES_DYNAMO = {Hatch_Dynamo_ULV, Hatch_Dynamo_LV, Hatch_Dynamo_MV, Hatch_Dynamo_HV, Hatch_Dynamo_EV, Hatch_Dynamo_IV, Hatch_Dynamo_LuV, Hatch_Dynamo_ZPM, Hatch_Dynamo_UV, Hatch_Dynamo_MAX},
            HATCHES_ENERGY = {Hatch_Energy_ULV, Hatch_Energy_LV, Hatch_Energy_MV, Hatch_Energy_HV, Hatch_Energy_EV, Hatch_Energy_IV, Hatch_Energy_LuV, Hatch_Energy_ZPM, Hatch_Energy_UV, Hatch_Energy_MAX},
            HATCHES_INPUT = {Hatch_Input_ULV, Hatch_Input_LV, Hatch_Input_MV, Hatch_Input_HV, Hatch_Input_EV, Hatch_Input_IV, Hatch_Input_LuV, Hatch_Input_ZPM, Hatch_Input_UV, Hatch_Input_MAX},
            HATCHES_INPUT_BUS = {Hatch_Input_Bus_ULV, Hatch_Input_Bus_LV, Hatch_Input_Bus_MV, Hatch_Input_Bus_HV, Hatch_Input_Bus_EV, Hatch_Input_Bus_IV, Hatch_Input_Bus_LuV, Hatch_Input_Bus_ZPM, Hatch_Input_Bus_UV, Hatch_Input_Bus_MAX},
            HATCHES_OUTPUT = {Hatch_Output_ULV, Hatch_Output_LV, Hatch_Output_MV, Hatch_Output_HV, Hatch_Output_EV, Hatch_Output_IV, Hatch_Output_LuV, Hatch_Output_ZPM, Hatch_Output_UV, Hatch_Output_MAX, Hatch_Output_Creative},
            HATCHES_OUTPUT_BUS = {Hatch_Output_Bus_ULV, Hatch_Output_Bus_LV, Hatch_Output_Bus_MV, Hatch_Output_Bus_HV, Hatch_Output_Bus_EV, Hatch_Output_Bus_IV, Hatch_Output_Bus_LuV, Hatch_Output_Bus_ZPM, Hatch_Output_Bus_UV, Hatch_Output_Bus_MAX},
            HATCHES_MUFFLER = {Hatch_Muffler_LV, Hatch_Muffler_LV, Hatch_Muffler_MV, Hatch_Muffler_HV, Hatch_Muffler_EV, Hatch_Muffler_IV, Hatch_Muffler_LuV, Hatch_Muffler_ZPM, Hatch_Muffler_UV, Hatch_Muffler_MAX};

    public static Fluid sOilExtraHeavy, sEpichlorhydrin, sDrillingFluid, sNitricAcid, sBlueVitriol, sNickelSulfate, sToluene, sNitrationMixture, sRocketFuel, sHydricSulfur, sIndiumConcentrate, sLeadZincSolution;
    private ItemStack mStack;
    private boolean mHasNotBeenSet = true;

    @Override
    public IItemContainer set(Item aItem) {
        mHasNotBeenSet = false;
        if (aItem == null) return this;
        ItemStack aStack = new ItemStack(aItem, 1, 0);
        mStack = GT_Utility.copyAmount(1, aStack);
        return this;
    }

    @Override
    public IItemContainer set(ItemStack aStack) {
        mHasNotBeenSet = false;
        mStack = GT_Utility.copyAmount(1, aStack);
        return this;
    }

    @Override
    public Item getItem() {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return null;
        return mStack.getItem();
    }

    @Override
    public Block getBlock() {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        return GT_Utility.getBlockFromItem(getItem());
    }

    @Override
    public final boolean hasBeenSet() {
        return !mHasNotBeenSet;
    }

    @Override
    public boolean isStackEqual(Object aStack) {
        return isStackEqual(aStack, false, false);
    }

    @Override
    public boolean isStackEqual(Object aStack, boolean aWildcard, boolean aIgnoreNBT) {
        if (GT_Utility.isStackInvalid(aStack)) return false;
        return GT_Utility.areUnificationsEqual((ItemStack) aStack, aWildcard ? getWildcard(1) : get(1), aIgnoreNBT);
    }

    @Override
    public ItemStack get(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return GT_Utility.copyAmount(aAmount, aReplacements);
        return GT_Utility.copyAmount(aAmount, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getWildcard(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return GT_Utility.copyAmount(aAmount, aReplacements);
        return GT_Utility.copyAmountAndMetaData(aAmount, W, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getUndamaged(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return GT_Utility.copyAmount(aAmount, aReplacements);
        return GT_Utility.copyAmountAndMetaData(aAmount, 0, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getAlmostBroken(long aAmount, Object... aReplacements) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return GT_Utility.copyAmount(aAmount, aReplacements);
        return GT_Utility.copyAmountAndMetaData(aAmount, mStack.getMaxDamage() - 1, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public ItemStack getWithName(long aAmount, String aDisplayName, Object... aReplacements) {
        ItemStack rStack = get(1, aReplacements);
        if (GT_Utility.isStackInvalid(rStack)) return null;
        rStack.setStackDisplayName(aDisplayName);
        return GT_Utility.copyAmount(aAmount, rStack);
    }

    @Override
    public ItemStack getWithCharge(long aAmount, int aEnergy, Object... aReplacements) {
        ItemStack rStack = get(1, aReplacements);
        if (GT_Utility.isStackInvalid(rStack)) return null;
        GT_ModHandler.chargeElectricItem(rStack, aEnergy, Integer.MAX_VALUE, true, false);
        return GT_Utility.copyAmount(aAmount, rStack);
    }

    @Override
    public ItemStack getWithDamage(long aAmount, long aMetaValue, Object... aReplacements) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (GT_Utility.isStackInvalid(mStack)) return GT_Utility.copyAmount(aAmount, aReplacements);
        return GT_Utility.copyAmountAndMetaData(aAmount, aMetaValue, GT_OreDictUnificator.get(mStack));
    }

    @Override
    public IItemContainer registerOre(Object... aOreNames) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        for (Object tOreName : aOreNames) GT_OreDictUnificator.registerOre(tOreName, get(1));
        return this;
    }

    @Override
    public IItemContainer registerWildcardAsOre(Object... aOreNames) {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        for (Object tOreName : aOreNames) GT_OreDictUnificator.registerOre(tOreName, getWildcard(1));
        return this;
    }
}