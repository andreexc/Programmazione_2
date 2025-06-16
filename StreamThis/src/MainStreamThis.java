import Data.GUI.Interfaccia;
import Data.Model.Anime;
import Data.Model.Film;
import Data.Model.SerieTV;
import Data.Model.Titolo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainStreamThis extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {

        ArrayList<Titolo> titoli = new ArrayList<>();
        titoli.add(new SerieTV("Boris", "2010", "Italiano", 10.00, 4));
        titoli.add(new Anime("Attack on Titan", "2013", "Giapponese", "Inglese", 10));
        titoli.add(new Film("Parasite", "2019", "Inglese", 20));
        titoli.add(new Anime("Pokemon", "2010", "Inglese", "", 10));
        titoli.add(new Film("The Irishman", "2019", "Inglese", 5));
        titoli.add(new SerieTV("1994", "2019", "Italiano", 10, 3));

        Interfaccia applicazione = new Interfaccia(titoli);
        stage.setScene(new Scene(applicazione, 450, 250));
        stage.sizeToScene();
        stage.setTitle("StreamThis!");
        stage.show();
    }
}
