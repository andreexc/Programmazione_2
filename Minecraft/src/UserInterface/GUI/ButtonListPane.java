package UserInterface.GUI;

import Tools.MapCoordinates;
import UserInterface.GUI.Controls.MainSimpleController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ButtonListPane extends VBox {

    private TextField cord_X;
    private TextField cord_Y;

    private TextField inventory_slot_index;

    private Button pick_button;
    private Button to_furnace_button;
    private Button from_furnace_button;
    private Button inv_sort_button;

    private MainSimpleController mainController;

    public ButtonListPane(MainSimpleController mainController) {
        super();
        this.mainController = mainController;

        cord_X = new TextField();
        cord_Y = new TextField();
        cord_X.setPromptText("X");
        cord_Y.setPromptText("Y");
        super.getChildren().add(cord_X);
        super.getChildren().add(cord_Y);

        inventory_slot_index = new TextField();
        inventory_slot_index.setPromptText("Inventory Slot");
        super.getChildren().add(inventory_slot_index);

        init_pick_button();
        init_to_furnace_button();
        init_smelt_button();
        init_from_furnace_button();
        init_inv_sort_button();

        super.setSpacing(10);
    }

    private void init_pick_button() {
        this.pick_button = new Button("Pick");
        this.pick_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.pick_up_block(new MapCoordinates(Integer.parseInt(cord_X.getText()), Integer.parseInt(cord_Y.getText())));
            }
        });
        super.getChildren().add(pick_button);
    }

    private void init_to_furnace_button() {
        this.to_furnace_button = new Button("Move To Furnace");
        this.to_furnace_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.move_into_furnace_from_inventory(Integer.parseInt(inventory_slot_index.getText()));
            }
        });
        super.getChildren().add(to_furnace_button);
    }

    private void init_smelt_button() {
        Button smelt_button = new Button("Smelt");
        smelt_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.smelt();
            }
        });
        super.getChildren().add(smelt_button);
    }

    private void init_from_furnace_button() {
        this.from_furnace_button = new Button("Move Back");
        this.from_furnace_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.move_into_inventory_from_furnace();
            }
        });
        super.getChildren().add(from_furnace_button);
    }

    private void init_inv_sort_button() {
        this.inv_sort_button = new Button("Toggle Inventory \n Sorting");
        this.inv_sort_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainController.toggle_inventory_comparator();
            }
        });
        super.getChildren().add(inv_sort_button);
    }

}