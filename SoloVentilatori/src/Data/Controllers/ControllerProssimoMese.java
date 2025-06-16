package Data.Controllers;

import Data.Exceptions.NotEnoughFundsException;
import Data.GUI.NotEnoughFundsWindow;
import Data.GUI.StackVentilatore;
import Data.GUI.UserInfo;
import Data.Utente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControllerProssimoMese implements EventHandler<ActionEvent> {

    private Utente user;
    private ArrayList<StackVentilatore> lista_ventilatori;
    private UserInfo userInfo;

    public ControllerProssimoMese(Utente user, ArrayList<StackVentilatore> lista_ventilatori, UserInfo userInfo) {
        this.user = user;
        this.lista_ventilatori = lista_ventilatori;
        this.userInfo = userInfo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            if (user.getSpesaMensile() > user.getCapitale()) {
                throw new NotEnoughFundsException("Not enough funds");
            }

            this.user.prossimoMese();
            this.userInfo.refresh();
            for(StackVentilatore v : this.lista_ventilatori) {
                v.refresh(this.user.getCapitale());
            }
        }
        catch (NotEnoughFundsException e) {
            NotEnoughFundsWindow nefwd = new NotEnoughFundsWindow(lista_ventilatori, user, userInfo);
        }
    }
}
