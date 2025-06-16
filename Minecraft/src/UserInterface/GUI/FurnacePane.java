package UserInterface.GUI;

import data.BlockCreator;
import data.Interfaces.Block;
import data.Interfaces.SmeltableBlock;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {

    private BlockPane input;
    private BlockPane output;

    public FurnacePane() {
        super();

        input = new BlockPane(BlockCreator.NullBlock());
        output = new BlockPane(BlockCreator.NullBlock());

        HBox body = new HBox(input, new Text("-->"), output);
        body.setAlignment(Pos.CENTER);

        super.getChildren().addAll(new Text("Furnace"), body);
        super.setAlignment(Pos.CENTER);
    }

    public BlockPane getInput() {
        return input;
    }

    public BlockPane getOutput() {
        return output;
    }

    public void setInput(Block input) {
        this.input = new BlockPane(input);
    }

    public void setOutput(Block output) {
        this.output = new BlockPane(output);
    }
}
