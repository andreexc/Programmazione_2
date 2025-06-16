package Data.Controllers;

import Data.Comparators.NomeComparator;
import Data.GUI.TitoloPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdinaController implements EventHandler<ActionEvent> {

    Comparator<TitoloPane> comparatore;
    ArrayList<TitoloPane> lista_titoli;

    public OrdinaController(ArrayList<TitoloPane> lista_titoli) {
        this.comparatore = new NomeComparator();
        this.lista_titoli = lista_titoli;
    }

    public void setComparatore(Comparator<TitoloPane> comparatore) {
        this.comparatore = comparatore;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Collections.sort(this.lista_titoli, this.comparatore);
    }
}
