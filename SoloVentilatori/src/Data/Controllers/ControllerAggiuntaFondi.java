package Data.Controllers;

import Data.GUI.StackVentilatore;
import Data.GUI.UserInfo;
import Data.Utente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControllerAggiuntaFondi implements EventHandler<ActionEvent> {

    private Utente user;
    private UserInfo user_info;
    private ArrayList<StackVentilatore> lista_ventilatori;

    public ControllerAggiuntaFondi(Utente user, UserInfo user_info, ArrayList<StackVentilatore> lista_ventilatori) {
        this.user = user;
        this.user_info = user_info;
        this.lista_ventilatori = lista_ventilatori;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.user.AggiungiFondi();
        this.user_info.refresh();
        for (StackVentilatore v : this.lista_ventilatori) {
            v.refresh(this.user.getCapitale());
        }
    }
}
