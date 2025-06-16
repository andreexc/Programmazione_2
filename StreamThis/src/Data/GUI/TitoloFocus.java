package Data.GUI;

import Data.Controllers.SelettoreSeasonController;
import Data.Model.SerieTV;
import Data.Model.Titolo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Collection;

public class TitoloFocus extends VBox {

    private Titolo titolo;
    private HBox selettore_serie;
    private Button btn_acquista;

    public TitoloFocus(Titolo titolo) {
        super();
        this.titolo = titolo;
        this.display();
        super.setAlignment(Pos.CENTER);
    }

    public void display() {
        Text info = new Text(this.titolo.toString());
        this.selettore_serie = new HBox();
        if (titolo.getTipologia().equals("SerieTV")) {
            // il cast lo faccio perché sono sicuro essendo che la stringa "SerieTV"
            // è hard-coded nel costruttore di SerieTV
            for (int i = 0; i < ((SerieTV) this.titolo).getNumeroStagioni(); i++) {
                Button stagione_x = new Button("S" + (i+1));
                this.selettore_serie.getChildren().add(stagione_x);
                stagione_x.addEventHandler(ActionEvent.ACTION, new SelettoreSeasonController(this, ((SerieTV) this.titolo), stagione_x));
            }
            this.selettore_serie.getChildren().getFirst().setDisable(true); // la prima serie è selezionata di default
            this.selettore_serie.setAlignment(Pos.CENTER);
        }
        this.btn_acquista = new Button("Acquista " + this.titolo.calcolaPrezzoEffettivo() + "€");
        this.btn_acquista.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ErrorWindow dialog = new ErrorWindow("ERRORE: connessione non presente.");
            }
        });
        super.getChildren().addAll(info, this.selettore_serie, this.btn_acquista);
    }

    public HBox getSelettoreSerie() {
        return selettore_serie;
    }

    public void resetSerie() {
        if (this.titolo.getTipologia().equals("SerieTV")) {
            ((SerieTV) this.titolo).resetCounterSerie();
            this.display();
        }
    }

    public Button getAcquistaButton() {
        return this.btn_acquista;
    }
}
