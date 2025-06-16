package Data.GUI;

import Data.Utente;
import javafx.scene.text.Text;

public class UserInfo extends Text {

    private Utente user;

    public UserInfo(Utente user) {
        this.user = user;
        this.refresh();
    }

    public void refresh() {
        super.setText(this.user.toString());
    }
}
