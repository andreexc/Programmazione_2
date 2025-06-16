package Data.Controllers;

import Data.GUI.Interfaccia;
import Data.GUI.TitoloPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SetFocusController implements EventHandler<MouseEvent> {

    private TitoloPane titolo;
    private Interfaccia app;

    public SetFocusController(TitoloPane titolo, Interfaccia app) {
        this.titolo = titolo;
        this.app = app;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        app.setFocus(titolo.getTitolo());
    }
}
