package UserInterface.GUI;

import Tools.MapCoordinates;
import data.BlockCreator;
import data.Blocks.SandBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ButtonListPane extends VBox {

    private Button btn;
    private MainGui Mg;

    private Button pick_button;
    private Button to_furnace_button;
    private Button from_furnace_button;
    private Button inv_sort_button;

    public ButtonListPane(MainGui Mg) {
        super();
        Random rand = new Random();
        this.Mg = Mg;
        btn = new Button("Bottone");
        btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((MapPane) Mg.getCenter()).setCell(new MapCoordinates(rand.nextInt(MapCoordinates.ROWS), rand.nextInt(MapCoordinates.COLS)), BlockCreator.getRandomBlock());
            }
        });
        // super.getChildren().add(btn);

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
                System.out.println("Pick Button");
            }
        });
        super.getChildren().add(pick_button);
    }

    private void init_to_furnace_button() {
        this.to_furnace_button = new Button("Move To Furnace");
        this.to_furnace_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("To Furnace Button");
            }
        });
        super.getChildren().add(to_furnace_button);
    }

    private void init_smelt_button() {
        Button smelt_button = new Button("Smelt");
        smelt_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Smelt Button");
            }
        });
        super.getChildren().add(smelt_button);
    }

    private void init_from_furnace_button() {
        this.from_furnace_button = new Button("Move Back");
        this.from_furnace_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("From Furnace Button");
            }
        });
        super.getChildren().add(from_furnace_button);
    }

    private void init_inv_sort_button() {
        this.inv_sort_button = new Button("Toggle Inventory \n Sorting");
        this.inv_sort_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Inv Sort Button");
            }
        });
        super.getChildren().add(inv_sort_button);
    }

}