package Data.GUI;

import Data.Comparators.AnnoComparator;
import Data.Comparators.NomeComparator;
import Data.Comparators.TipoComparator;
import Data.Controllers.ClearController;
import Data.Controllers.OrdinaController;
import Data.Controllers.SetFocusController;
import Data.Model.Titolo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class Interfaccia extends BorderPane {

    private ArrayList<TitoloPane> lista_titoli;

    private int start;
    private int end;

    private HBox top_border;

    public Interfaccia(ArrayList<Titolo> lista_titoli_raw) {
        super();

        this.start = 0;
        this.end = 3;

        this.init_titoli(lista_titoli_raw);
        this.init_top(this.lista_titoli, this.start, this.end);
        this.init_left();
        this.init_right();
    }

    private void init_left() {
        Button btn_clear = new Button("Clear");
        btn_clear.addEventHandler(ActionEvent.ACTION, new ClearController(this));
        super.setLeft(btn_clear);
    }

    private void init_right() {
        VBox bottoni = new VBox();
        bottoni.setSpacing(10);
        bottoni.getChildren().add(new Text("Ordina per:"));

        Button btn_ordina_nome = new Button("Nome");
        Button btn_ordina_anno = new Button("Anno");
        Button btn_ordina_tipo = new Button("Tipo");

        OrdinaController ord_ctrl = new OrdinaController(this.lista_titoli);
        btn_ordina_nome.addEventHandler(ActionEvent.ACTION, e -> {
            ord_ctrl.setComparatore(new NomeComparator());
            ord_ctrl.handle(new ActionEvent());
            System.out.println(lista_titoli);
            this.init_top(this.lista_titoli, this.start, this.end);
        });
        btn_ordina_anno.addEventHandler(ActionEvent.ACTION, e -> {
            ord_ctrl.setComparatore(new AnnoComparator());
            ord_ctrl.handle(new ActionEvent());
            System.out.println(lista_titoli);
            this.init_top(this.lista_titoli, this.start, this.end);
        });
        btn_ordina_tipo.addEventHandler(ActionEvent.ACTION, e -> {
            ord_ctrl.setComparatore(new TipoComparator());
            ord_ctrl.handle(new ActionEvent());
            this.init_top(this.lista_titoli, this.start, this.end);
        });

        bottoni.getChildren().addAll(btn_ordina_nome, btn_ordina_anno, btn_ordina_tipo);
        super.setRight(bottoni);
    }

    private void init_titoli(ArrayList<Titolo> lista_titoli_raw) {
        this.lista_titoli = new ArrayList<>();
        for (Titolo titolo : lista_titoli_raw) {
            TitoloPane cella = new TitoloPane(titolo);
            cella.addEventHandler(MouseEvent.MOUSE_CLICKED, new SetFocusController(cella, this));
            lista_titoli.add(cella);
        }
    }

    private void init_top(ArrayList<TitoloPane> lista_titoli, int start, int end) {
        this.lista_titoli = lista_titoli;

        this.top_border = new HBox();

        Button ShiftLeft = new Button("<");
        Button ShiftRight = new Button(">");

        // se modificassi il valore di start ed end dentro la lambda avrei un errore
        // in quanto sarebbero effectively final quindi delego la modifica alla classe
        // che possiede quell'attributo
        ShiftLeft.addEventHandler(ActionEvent.ACTION, e -> {
            shift_left();
        });
        ShiftRight.addEventHandler(ActionEvent.ACTION, e -> {
            shift_right();
        });

        this.top_border.getChildren().addAll(ShiftLeft, this.init_lista_titoli(start, end), ShiftRight);
        super.setTop(this.top_border);
    }

    private void shift_right() {
        if (this.lista_titoli.size() < this.end+1) {
            ErrorWindow err_dialog = new ErrorWindow("Lista Conclusa");
        }
        else {
            this.start = this.start + 1;
            this.end = this.end + 1;
            redraw();
        }
    }

    private void shift_left() {
        if (this.start-1 < 0) {
            ErrorWindow err_dialog = new ErrorWindow("Lista già all'Inizio");
        }
        else {
            this.start = this.start - 1;
            this.end = this.end - 1;
            redraw();
        }
    }

    private void redraw() {
        this.top_border.getChildren().set(1, this.init_lista_titoli(this.start, this.end));
    }

    private HBox init_lista_titoli(int start, int end) {
        int counter = 0;
        HBox titoli = new HBox();
        for (int i = start; i < end && counter < 3; i++, counter++) {
            titoli.getChildren().add(this.lista_titoli.get(i));
        }
        return titoli;
    }

    public void setFocus(Titolo titoli) {
        if (super.getCenter() != null) {
            if (((TitoloFocus) super.getCenter()).getSelettoreSerie() != null) {
                ((TitoloFocus) super.getCenter()).resetSerie();
            }
        }
        super.setCenter(new TitoloFocus(titoli));
    }

    public void relocateList() {
        this.start = 0;
        this.end = 3;
        redraw();
    }
}
