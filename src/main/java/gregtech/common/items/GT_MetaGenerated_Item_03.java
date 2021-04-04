package gregtech.common.items;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.items.GT_MetaGenerated_Item_X32;

public class GT_MetaGenerated_Item_03
        extends GT_MetaGenerated_Item_X32 {
    public static GT_MetaGenerated_Item_03 INSTANCE;

    public GT_MetaGenerated_Item_03() {
        super("metaitem.03");
        INSTANCE = this;
        int tLastID = 0;
        Object[] o = new Object[0];

        ItemList.Circuit_Board_Wetware.set(addItem(tLastID = 6, "Wetware Lifesupport Circuit Board", "The Board that keeps life", o));
        ItemList.Circuit_Board_Plastic.set(addItem(tLastID = 7, "Plastic Circuit Board", "A Good Board", o));
        ItemList.Circuit_Parts_ResistorSMD.set(addItem(tLastID = 11, "SMD Resistor", "Electronic Component", o));
        ItemList.Circuit_Parts_Glass_Tube.set(addItem(tLastID = 12, "Glass Tube", "", o));
        ItemList.Circuit_Parts_Coil.set(addItem(tLastID = 14, "Small Coil", "Basic Electronic Component", o));
        ItemList.Circuit_Parts_DiodeSMD.set(addItem(tLastID = 16, "SMD Diode", "Electronic Component", o));
        ItemList.Circuit_Parts_TransistorSMD.set(addItem(tLastID = 18, "SMD Transistor", "Electronic Component", o));
        ItemList.Circuit_Parts_CapacitorSMD.set(addItem(tLastID = 20, "SMD Capacitor", "Electronic Component", o));
        ItemList.Circuit_Parts_PetriDish.set(addItem(tLastID = 22, "Petri Dish", "For cultivating cells", o));
        ItemList.PrimitiveFluidFilterItem.set(addItem(tLastID = 23, "Primitive Fluid Filter", "Used to filter water", o));
        ItemList.SimpleFluidFilterItem.set(addItem(tLastID = 24, "Simple Fluid Filter", "Used to filter water", o));
        ItemList.FluidFilterItem.set(addItem(tLastID = 25, "Fluid Filter", "Used to filter water", o));

        ItemList.Circuit_Silicon_Ingot.set(addItem(tLastID = 30, "Monocrystalline Silicon Boule", "Raw Circuit", o));
        ItemList.Circuit_Silicon_Ingot2.set(addItem(tLastID = 31, "Glowstone doped Monocrystalline Silicon Boule", "Raw Circuit", o));
        ItemList.Circuit_Silicon_Ingot3.set(addItem(tLastID = 32, "Naquadah doped Monocrystalline Silicon Boule", "Raw Circuit", o));

        ItemList.Circuit_Silicon_Wafer.set(addItem(tLastID = 33, "Wafer", "Raw Circuit", o));
        ItemList.Circuit_Silicon_Wafer2.set(addItem(tLastID = 34, "Glowstone doped Wafer", "Raw Circuit", o));
        ItemList.Circuit_Silicon_Wafer3.set(addItem(tLastID = 35, "Naquadah doped Wafer", "Raw Circuit", o));

        ItemList.Circuit_Wafer_ILC.set(addItem(tLastID = 36, "Integrated Logic Circuit (Wafer)", "Raw Circuit", o));
        ItemList.Circuit_Chip_ILC.set(addItem(tLastID = 37, "Integrated Logic Circuit", "Integrated Circuit", o));

        ItemList.Circuit_Wafer_Ram.set(addItem(tLastID = 38, "Random Access Memory Chip (Wafer)", "Raw Circuit", o));
        ItemList.Circuit_Chip_Ram.set(addItem(tLastID = 39, "Random Access Memory Chip", "Integrated Circuit", o));

        ItemList.Circuit_Wafer_NAND.set(addItem(tLastID = 40, "NAND Memory Chip (Wafer)", "Raw Circuit", o));
        ItemList.Circuit_Chip_NAND.set(addItem(tLastID = 41, "NAND Memory Chip", "Integrated Circuit", o));

        ItemList.Circuit_Wafer_NOR.set(addItem(tLastID = 42, "NOR Memory Chip (Wafer)", "Raw Circuit", o));
        ItemList.Circuit_Chip_NOR.set(addItem(tLastID = 43, "NOR Memory Chip", "Integrated Circuit", o));

        ItemList.Circuit_Wafer_CPU.set(addItem(tLastID = 44, "Central Processing Unit (Wafer)", "Raw Circuit", o));
        ItemList.Circuit_Chip_CPU.set(addItem(tLastID = 45, "Central Processing Unit", "Integrated Circuit", o));

        ItemList.Circuit_Wafer_SoC.set(addItem(tLastID = 46, "SoC Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_SoC.set(addItem(tLastID = 47, "SoC", "System on a Chip", o));

        ItemList.Circuit_Wafer_SoC2.set(addItem(tLastID = 48, "ASoC Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_SoC2.set(addItem(tLastID = 49, "ASoC", "Advanced System on a Chip", o));

        ItemList.Circuit_Wafer_PIC.set(addItem(tLastID = 50, "PIC Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_PIC.set(addItem(tLastID = 51, "Power IC", "Power Circuit", o));

        ItemList.Circuit_Wafer_HPIC.set(addItem(tLastID = 52, "HPIC Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_HPIC.set(addItem(tLastID = 53, "High Power IC", "High Power Circuit", o));

        ItemList.Circuit_Wafer_NanoCPU.set(addItem(tLastID = 54, "NanoCPU Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_NanoCPU.set(addItem(tLastID = 55, "Nanocomponent Central Processing Unit", "Power Circuit", o));

        ItemList.Circuit_Wafer_QuantumCPU.set(addItem(tLastID = 56, "QBit Wafer", "Raw Circuit", o));
        ItemList.Circuit_Chip_QuantumCPU.set(addItem(tLastID = 57, "QBit Processing Unit", "Quantum CPU", o));

        /*
         * Engraved Crystal Chip
         * Engraved Lapotron Chip
         * Crystal CPU
         * SoCrystal
         * stem cells (disassemble eggs)
         */
        ItemList.Circuit_Parts_RawCrystalChip.set(addItem(tLastID = 69, "Raw Crystal Chip", "Raw Crystal Processor", o));
        ItemList.Circuit_Chip_CrystalCPU.set(addItem(tLastID = 70, "Crystal Processing Unit", "Crystal CPU", o)); //Crystal chip elite part
        ItemList.Circuit_Chip_CrystalSoC.set(addItem(tLastID = 71, "Crystal SoC", "Crystal System on a Chip", o));
        ItemList.Circuit_Chip_NeuroCPU.set(addItem(tLastID = 72, "Neuro Processing Unit", "Neuro CPU", o));
        ItemList.Circuit_Chip_Stemcell.set(addItem(tLastID = 73, "Stemcells", "Raw Intiligence (Disassembled Eggs)", o));

        //Vacuum Tube				Item01
        //Basic Circuit				IC2
        //Good Circuit				Item01

        //Integrated Logic Circuit  Item01 
        ItemList.Circuit_Integrated_Good.set(addItem(tLastID = 79, "Good Integrated Circuit", "Good Circuit", OrePrefixes.circuit.get(Materials.Good), SubTag.NO_UNIFICATION));
        //Good Integrated Circuit   Item01
        //Advanced Circuit			IC2

        ItemList.Circuit_Microprocessor.set(addItem(tLastID = 78, "Microprocessor", "A Basic Circuit", OrePrefixes.circuit.get(Materials.Basic), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Processor.set(addItem(tLastID = 80, "Integrated Processor", "A Good Circuit", OrePrefixes.circuit.get(Materials.Good), SubTag.NO_UNIFICATION));
//        ItemList.Circuit_Computer.set(addItem(tLastID = 81, "Processor Assembly", "Advanced Circuit",  new Object[]{OrePrefixes.circuit.get(Materials.Advanced), SubTag.NO_UNIFICATION}));
        //Workstation				Item01 Datacircuit
        //Mainframe					Item01 DataProcessor

        ItemList.Circuit_Nanoprocessor.set(addItem(tLastID = 82, "Nanoprocessor", "An Advanced Circuit", OrePrefixes.circuit.get(Materials.Advanced), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Nanocomputer.set(addItem(tLastID = 83, "Nanoprocessor Assembly", "An Extreme Circuit", OrePrefixes.circuit.get(Materials.Data), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Elitenanocomputer.set(addItem(tLastID = 84, "Elite Nanocomputer", "An Elite Circuit", OrePrefixes.circuit.get(Materials.Elite), SubTag.NO_UNIFICATION));
        //Nanoprocessor Mainframe  	Item01 Energy Flow Circuit

        ItemList.Circuit_Quantumprocessor.set(addItem(tLastID = 85, "Quantumprocessor", "An Extreme Circuit", OrePrefixes.circuit.get(Materials.Data), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Quantumcomputer.set(addItem(tLastID = 86, "Quantumprocessor Assembly", "An Elite Circuit", OrePrefixes.circuit.get(Materials.Elite), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Masterquantumcomputer.set(addItem(tLastID = 87, "Master Quantumcomputer", "A Master Circuit", OrePrefixes.circuit.get(Materials.Master), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Quantummainframe.set(addItem(tLastID = 88, "Quantumprocessor Mainframe", "An Ultimate Circuit", OrePrefixes.circuit.get(Materials.Ultimate), SubTag.NO_UNIFICATION));

        ItemList.Circuit_Crystalprocessor.set(addItem(tLastID = 89, "Crystalprocessor", "An Elite Circuit", OrePrefixes.circuit.get(Materials.Elite), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Crystalcomputer.set(addItem(tLastID = 96, "Crystalprocessor Assembly", "A Master Circuit", OrePrefixes.circuit.get(Materials.Master), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Ultimatecrystalcomputer.set(addItem(tLastID = 90, "Ultimate Crystalcomputer", "An Ultimate Circuit", OrePrefixes.circuit.get(Materials.Ultimate), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Crystalmainframe.set(addItem(tLastID = 91, "Crystalprocessor Mainframe", "A Super Circuit", OrePrefixes.circuit.get(Materials.Superconductor), SubTag.NO_UNIFICATION));

        ItemList.Circuit_Neuroprocessor.set(addItem(tLastID = 92, "Wetwareprocessor", "A Master Circuit", OrePrefixes.circuit.get(Materials.Master), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Wetwarecomputer.set(addItem(tLastID = 93, "Wetwareprocessor Assembly", "An Ultimate Circuit", OrePrefixes.circuit.get(Materials.Ultimate), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Wetwaresupercomputer.set(addItem(tLastID = 94, "Wetware Supercomputer", "A Super Circuit", OrePrefixes.circuit.get(Materials.Superconductor), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Wetwaremainframe.set(addItem(tLastID = 95, "Wetware Mainframe", "An Infinite Circuit", OrePrefixes.circuit.get(Materials.Infinite), SubTag.NO_UNIFICATION));
        ItemList.Circuit_Ultimate.set(ItemList.Circuit_Ultimatecrystalcomputer.get(1L));//maybe should be removed
    }

    public boolean doesShowInCreative(OrePrefixes aPrefix, Materials aMaterial, boolean aDoShowAllItems) {
        return aDoShowAllItems;
    }
}
