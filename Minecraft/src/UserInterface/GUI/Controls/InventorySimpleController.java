package UserInterface.GUI.Controls;

import UserInterface.CLI.Inventory;
import UserInterface.GUI.InventoryPane;
import data.Interfaces.Block;
import javafx.scene.text.Text;

import java.util.Iterator;

public class InventorySimpleController implements SimpleController {

    private InventoryPane inventoryGUI;
    private Inventory inventoryLogic;

    public InventorySimpleController(Inventory inventoryLogic, InventoryPane inventoryGUI) {
        this.inventoryGUI = inventoryGUI;
        this.inventoryLogic = inventoryLogic;
        redraw();
    }

    @Override
    public void redraw() {
        this.inventoryGUI.getChildren().clear();
        this.inventoryGUI.getChildren().add(new Text("Inventory: " ));

        Iterator<Block> it = inventoryLogic.getIterator();
        while(it.hasNext()) {
            inventoryGUI.add(it.next());
        }
    }
}
