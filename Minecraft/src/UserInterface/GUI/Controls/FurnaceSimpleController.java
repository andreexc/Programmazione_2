package UserInterface.GUI.Controls;

import UserInterface.GUI.BlockPane;
import UserInterface.GUI.FurnacePane;
import data.Blocks.Furnace;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FurnaceSimpleController implements SimpleController {

    private Furnace fornaceLogic;
    private FurnacePane fornaceGUI;

    public FurnaceSimpleController(Furnace fornaceLogic, FurnacePane fornaceGUI) {
        this.fornaceLogic = fornaceLogic;
        this.fornaceGUI = fornaceGUI;
        this.redraw();
    }

    @Override
    public void redraw() {
        this.fornaceGUI.getChildren().clear();

        HBox body = new HBox(new BlockPane(fornaceLogic.get_input()), new Text("-->"), new BlockPane(fornaceLogic.getSmeltedBlock()));
        body.setAlignment(Pos.CENTER);

        fornaceGUI.getChildren().addAll(new Text("Furnace"), body);
        fornaceGUI.setAlignment(Pos.CENTER);
    }
}
