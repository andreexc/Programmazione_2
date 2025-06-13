package UserInterface.GUI;

import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {

    private MapPane mappa;
    private InventoryPane inventario;
    private FurnacePane fornace;
    private ButtonListPane bottoni;

    public MainGui() {
        super();

        this.mappa = new MapPane();
        this.inventario = new InventoryPane();
        this.fornace = new FurnacePane();
        this.bottoni = new ButtonListPane(this);

        super.setCenter(mappa);
        super.setBottom(inventario);
        super.setLeft(bottoni);
        super.setRight(fornace);
    }
}
