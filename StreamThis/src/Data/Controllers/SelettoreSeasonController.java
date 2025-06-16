package Data.Controllers;

import Data.GUI.Interfaccia;
import Data.GUI.TitoloFocus;
import Data.Model.SerieTV;
import Data.Model.Titolo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SelettoreSeasonController implements EventHandler<ActionEvent> {

    private TitoloFocus focus_titolo;
    private SerieTV serie;
    private Button btn_stagione;

    public SelettoreSeasonController(TitoloFocus focus_titolo, SerieTV serie, Button btn_stagione) {
        this.focus_titolo = focus_titolo;
        this.serie = serie;
        this.btn_stagione = btn_stagione;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button acquista_btn = focus_titolo.getAcquistaButton();
        this.serie.aggiungiSerie();
        acquista_btn.setText("Acquista " + serie.calcolaPrezzoEffettivo() + "€");
        btn_stagione.setDisable(true);
    }
}
