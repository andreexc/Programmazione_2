package UserInterface.GUI;

import data.Interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class InventoryPane extends HBox {

    public InventoryPane(){
        super();
        super.getChildren().add(new Text("Inventory: " ));
    }
    public void add(Block block){
        super.getChildren().add(new BlockPane(block));
    }
}
