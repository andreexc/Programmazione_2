package Data.Controllers;

import Data.Utente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerFondi implements EventHandler<ActionEvent> {

    private Utente user;

    public ControllerFondi(Utente user) {
        this.user = user;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
