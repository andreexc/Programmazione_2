package UserInterface;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Blocks.Furnace;
import data.Blocks.NullBlock;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;
import data.Inventory;

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

    private void rimuovi_cella(MapCoordinates c) {
        this.Mappa.change_cell(c, BlockCreator.AirBlock());
    }

    public void pick_up_block(MapCoordinates c) {
        if (Mappa.is_pickable(c)) { Inventario.add_Block(Mappa.gimme_pickable(c)); }
        this.rimuovi_cella(c);
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

    public void toggle_inventory_comparator() {}


}
