package UserInterface.GUI;

import Tools.BlockComparator;
import data.Interfaces.Block;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class BlockPane extends StackPane {

    private Block block;
    private Rectangle sfondo;
    private Text testo;

    public BlockPane(Block block) {
        super();
        this.block = block;
        initialize();
    }

    public void initialize() {
        this.sfondo = new Rectangle(Data.DIM_SQUARE, Data.DIM_SQUARE);
        this.sfondo.setFill(this.get_color_from_block());
        this.sfondo.setStroke(Data.BLOCK_BORDER);

        this.testo = new Text("" + block.display());
        this.testo.setFont(Font.font(Data.FONT_NAME, Data.FONT_WEIGHT, Data.FONT_SIZE));
        this.testo.setFill(Data.FONT_FILL);
        this.testo.setStroke(Data.FONT_BORDER);

        super.getChildren().addAll(this.sfondo,  this.testo);
        super.setAlignment(Pos.CENTER);

        Tooltip info_box = new Tooltip(this.block.toString());
        Tooltip.install(this.testo, info_box);
    }

    public void change_block(Block new_block) {
        this.block = new_block;
        initialize();
    }

    private Color get_color_from_block() {
        return switch (BlockComparator.get_value_of_block(this.block)) {
            case 0 -> Color.BLACK;
            case 1 -> Color.WHITE;
            case 2 -> Color.AQUA;
            case 3 -> Color.GREEN;
            case 4 -> Color.BEIGE;
            case 5 -> Color.AZURE;
            case 6 -> Color.DARKGRAY;
            case 7 -> Color.SILVER;
            default -> Color.RED;
        };
    }

}
