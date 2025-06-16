package Data.GUI;

import Data.Comparators.CostoComparator;
import Data.Comparators.TypeComparator;
import Data.Controllers.ControllerAggiuntaFondi;
import Data.Controllers.ControllerProssimoMese;
import Data.Controllers.ControllerVentilatore;
import Data.Utente;
import Data.Ventilatori.VentilatoreParete;
import Data.Ventilatori.VentilatorePiantana;
import Data.Ventilatori.VentilatoreSoffitto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class MainApplicazione extends BorderPane {

    private Button prx_mese;
    private Button aggiungi_fondi;
    private Button Ordina_tipologia;
    private Button Ordina_costo;
    private UserInfo user_info;

    private ArrayList<StackVentilatore> lista_ventilatori;

    private Utente user;

    public MainApplicazione() {

        this.init_user();
        this.init_ventilatori();
        this.init_bottoni();
        this.init_controllers();
    }

    private void init_bottoni() {
        this.prx_mese = new Button("Prox Mese");
        this.aggiungi_fondi = new Button("+100 Fondi");
        this.Ordina_tipologia = new Button("Ordina Tipologia");
        this.Ordina_costo = new Button("Ordina Costo");

        this.aggiungi_fondi.addEventHandler(ActionEvent.ACTION, new ControllerAggiuntaFondi(this.user, this.user_info, lista_ventilatori));
        this.prx_mese.addEventHandler(ActionEvent.ACTION, new ControllerProssimoMese(this.user, this.lista_ventilatori, this.user_info));
        this.Ordina_tipologia.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lista_ventilatori.sort(new TypeComparator());
                updateVentilatori();
            }
        });
        this.Ordina_costo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lista_ventilatori.sort(new CostoComparator());
                updateVentilatori();
            }
        });

        VBox controlli_left = new VBox();
        controlli_left.getChildren().addAll(this.prx_mese, this.aggiungi_fondi);

        VBox controlli_right = new VBox();
        controlli_right.getChildren().addAll(this.Ordina_tipologia, this.Ordina_costo);

        super.setLeft(controlli_left);
        super.setRight(controlli_right);
    }

    private void updateVentilatori() {
        ((VBox) super.getCenter()).getChildren().clear();
        for (StackVentilatore v : lista_ventilatori) {
            ((VBox) super.getCenter()).getChildren().add(v);
        }
    }

    private void init_ventilatori() {
        lista_ventilatori = new ArrayList<StackVentilatore>();

        lista_ventilatori.add(new StackVentilatore(new VentilatorePiantana("Ariete", "Batteria"), this.user.getCapitale()));
        lista_ventilatori.add(new StackVentilatore(new VentilatoreParete("Bosch", "Presa"), this.user.getCapitale()));
        lista_ventilatori.add(new StackVentilatore(new VentilatoreParete("Bosch", "Meccanica"), this.user.getCapitale()));
        lista_ventilatori.add(new StackVentilatore(new VentilatoreSoffitto("Bosch", "Batteria"), this.user.getCapitale()));
        lista_ventilatori.add(new StackVentilatore(new VentilatoreSoffitto("Parkside", "Presa"), this.user.getCapitale()));

        VBox ventilatori = new VBox();
        ventilatori.setSpacing(1);
        for (StackVentilatore v : lista_ventilatori) {
            ventilatori.getChildren().add(v);
        }
        super.setCenter(ventilatori);
    }

    private void init_user() {
        this.user = new Utente();
        this.user_info = new UserInfo(user);
        super.setTop(user_info);
    }

    private void init_controllers() {
        for (StackVentilatore v : lista_ventilatori) {
            v.getStato().addEventHandler(MouseEvent.MOUSE_CLICKED, new ControllerVentilatore(user, v, user_info));
        }
    }
}
