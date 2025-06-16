package UserInterface.GUI;

import UserInterface.GUI.Controls.MainSimpleController;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {

    private MapPane mappa;
    private InventoryPane inventario;
    private FurnacePane fornace;
    private ButtonListPane bottoni;

    private MainSimpleController mainController;

    public MainGui(MainSimpleController mainController) {
        super();

        this.mappa = new MapPane();
        this.inventario = new InventoryPane();
        this.fornace = new FurnacePane();
        this.bottoni = new ButtonListPane(mainController);

        this.mainController = mainController;

        super.setCenter(mappa);
        super.setBottom(inventario);
        super.setLeft(bottoni);
        super.setRight(fornace);
    }
}
