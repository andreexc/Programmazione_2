package Data.Controllers;

import Data.GUI.StackVentilatore;
import Data.GUI.UserInfo;
import Data.Utente;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerVentilatore implements EventHandler<MouseEvent> {

    private Utente user;
    private StackVentilatore stackventilatore;
    private UserInfo user_info;

    public ControllerVentilatore(Utente user, StackVentilatore ventilatore, UserInfo user_info) {
        this.user = user;
        this.stackventilatore = ventilatore;
        this.user_info = user_info;
    }

    // quando viene cliccato un ventilatore
    @Override
    public void handle(MouseEvent mouseEvent) {

        int differenza = stackventilatore.toggleAbbonamento();
        this.user.modificaSpesaMensile(-differenza);
        stackventilatore.refresh(this.user.getCapitale());
        this.user_info.refresh();
    }

    @Override
    public String toString() {
        return this.stackventilatore.toString();
    }
}
