package Main;

import UserInterface.GUI.FurnacePane;
import UserInterface.GUI.MainGui;
import UserInterface.GUI.MapPane;
import Tools.MapCoordinates;
import UserInterface.CLI.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {

        MainGui schermata = new MainGui();
        stage.setScene(new Scene(schermata));
        stage.sizeToScene();
        stage.setTitle("Minecraft");
        stage.show();
    }
}
