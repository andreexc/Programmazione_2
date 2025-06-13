package UserInterface.GUI;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Exceptions.WrongCoordinatesException;
import data.Interfaces.Block;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class MapPane extends GridPane {

    public MapPane(){
        super();
        initialise_air();
    }

    // LE RIGHE E COLONNE IN GRIDPANE SONO INVERTITE
    public void initialise_air() {
        for (int i = 0; i < MapCoordinates.ROWS; i++) {
            for (int j = 0; j < MapCoordinates.COLS; j++) {
                super.add(new BlockPane(BlockCreator.defaultBlock()), j, i);
            }
        }
    }

    private static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public BlockPane get_block_at_coord(MapCoordinates c) throws WrongCoordinatesException {
        if (!c.isInbound()) { throw new WrongCoordinatesException(); }

        return (BlockPane) getElementAt(this, c.getX(), c.getY());
    }

    public void setCell(MapCoordinates c, Block b) throws WrongCoordinatesException {
        if (!c.isInbound()) { throw new WrongCoordinatesException(); }

        BlockPane toChange = get_block_at_coord(c);
        if (toChange == null) {
            super.add(new BlockPane(b), c.getY(), c.getX());
        }
        else {
            toChange.change_block(b);
        }
    }

}
