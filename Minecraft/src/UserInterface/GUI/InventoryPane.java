package UserInterface.GUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class InventoryPane extends HBox {
    Text i;
    HBox inventory;

    public InventoryPane(){
        super();
        addText();
        inventory = new HBox();
        super.getChildren().add(inventory);
    }
    public void addText(){
        i = new Text("Inventory: " );
        StackPane sp = new StackPane();
        Rectangle r = new Rectangle(Data.DIM_SQUARE,Data.DIM_SQUARE);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.TRANSPARENT);
        sp.getChildren().add(r);
        sp.getChildren().add(i);
        super.getChildren().add(sp);
    }
}
