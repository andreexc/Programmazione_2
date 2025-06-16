package Data.Controllers;

import Data.GUI.Interfaccia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearController implements EventHandler<ActionEvent> {

    private Interfaccia app;

    public ClearController(Interfaccia app) {
        this.app = app;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        app.setCenter(null);
        app.relocateList();
    }
}
