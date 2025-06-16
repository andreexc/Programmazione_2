package UserInterface.CLI;

import Tools.MapCoordinates;
import UserInterface.GUI.MainGui;
import data.BlockCreator;
import data.Blocks.Furnace;
import data.Blocks.NullBlock;
import data.Exceptions.BlockErrorException;
import data.Exceptions.WrongCoordinatesException;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class MainView {

    private Map Mappa;
    private Furnace Fornace;
    private Inventory Inventario;

    public MainView() {
        this.Mappa = new Map();
        this.Fornace = new Furnace();
        this.Inventario = new Inventory();
    }

    public void display_map() {
        this.Mappa.display_on_out();
    }

    public void display_furnace() {
        this.Fornace.display_on_out();
    }

    public void display_inventory() { this.Inventario.stampaInventario(); }

    public void display_all() {
        this.display_map();
        this.display_furnace();
        this.display_inventory();
        System.out.println();
    }

    /*
    public void move_into_furnace(MapCoordinates c) {
        if (!c.isInbound()) return;

        Block toSmelt = this.Mappa.getBlockCell(c);
        if (this.Mappa.getBlockCell(c) instanceof SmeltableBlock) {
            // faccio un cast perche se entra nell'if allora sono sicuro che sia di tipo SmeltableBlock
            this.Fornace.setInput((SmeltableBlock) toSmelt);
            this.Furnace_to_Inventory();
            this.Mappa.change_cell(c, BlockCreator.AirBlock());
        }
    }
    */

    public void change_cell(MapCoordinates c, Block block) { Mappa.change_cell(c, block); }

    private void rimuovi_cella(MapCoordinates c) {
        try {
            this.Mappa.change_cell(c, BlockCreator.defaultBlock());
        }
        catch (WrongCoordinatesException e) {
            System.out.println("Out of Bounds");
        }
    }

    public void pick_up_block(MapCoordinates c) {
        try {
            Inventario.add_Block(Mappa.gimme_pickable(c));
            this.rimuovi_cella(c);
        }
        catch (BlockErrorException e) {
            System.out.println("Selection is not pickable");
        }
        catch (WrongCoordinatesException e) {
            System.out.println("Out of Bounds");
        }
    }

    public void Inventory_to_Furnace(int index) {
        SmeltableBlock toFurnace = this.Inventario.get_smeltable_item(index);
        this.Fornace.setInput(toFurnace);
    }

    public void Furnace_to_Inventory() {
        Block smeltedBlock = this.Fornace.getSmeltedBlock();
        if (!(smeltedBlock instanceof NullBlock)) { this.Inventario.add_Block(smeltedBlock); }
        // aggiungo all'inventario il blocco appena smeltato (se non è null)
        // ho scelto di far così perche nel check se è smeltable ritorna NullBlock che
        // smeltato diventa NullBlock ma non è pickable quindi faccio un check se posso
        // metterlo nell'inventario o no
    }

    public void toggle_inventory_comparator() { this.Inventario.toggleComparator(); }

    public Furnace getFornace() {
        return Fornace;
    }

    public Inventory getInventario() {
        return Inventario;
    }

    public Map getMap() {
        return Mappa;
    }
}
