package Main;

import UserInterface.CLI.Inventory;
import UserInterface.CLI.MainView;
import UserInterface.GUI.Controls.FurnaceSimpleController;
import UserInterface.GUI.Controls.InventorySimpleController;
import UserInterface.GUI.Controls.MainSimpleController;
import UserInterface.GUI.Controls.SimpleController;
import UserInterface.GUI.FurnacePane;
import UserInterface.GUI.InventoryPane;
import UserInterface.GUI.MainGui;
import UserInterface.GUI.MapPane;
import Tools.MapCoordinates;
import UserInterface.CLI.Map;
import data.Blocks.Furnace;
import data.Blocks.IronSwordBlock;
import data.Blocks.RawIronBlock;
import data.Blocks.SandBlock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {

        MainSimpleController mc = new MainSimpleController(new MainView());
        MainGui layout = mc.getMainGui();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}
