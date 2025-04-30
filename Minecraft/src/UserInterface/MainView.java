package UserInterface;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Blocks.Furnace;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;

public class MainView {

    private Map mappa;
    private Furnace fornace;

    public MainView() {
        this.mappa = new Map();
        this.fornace = new Furnace();
    }

    public void display_map() {
        this.mappa.display_on_out();
    }

    public void display_furnace() {
        this.fornace.display_on_out();
    }

    public void move_into_furnace(MapCoordinates c) {
        if (!c.isInbound()) return;

        Block toSmelt = this.mappa.getBlockCell(c);
        if (this.mappa.getBlockCell(c) instanceof SmeltableBlock) {
            // faccio un cast perche se entra nell'if allora sono sicuro che sia di tipo SmeltableBlock
            this.fornace.setInput((SmeltableBlock) toSmelt);
            this.mappa.change_cell(c, BlockCreator.AirBlock());
        }
    }
}
