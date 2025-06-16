import Data.Exceptions.ForbiddenAlimentazioneException;
import Data.GUI.MainApplicazione;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainVentilatori extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {

        try {
            MainApplicazione interfaccia =  new MainApplicazione();

            stage.setTitle("Solo Ventilatori");
            stage.setScene(new Scene(interfaccia));
            stage.sizeToScene();
            stage.show();
        }
        catch (ForbiddenAlimentazioneException f) {
            System.out.println("Impossibile inizializzare i ventilatori");
            System.exit(1);
        }

    }
}