package es_FX.Data;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControllerCircleFollow implements EventHandler<ActionEvent> {

    private Button btn_follow;
    private Boolean on;
    private AliveCircle crl;

    public ControllerCircleFollow(Button btn_follow, AliveCircle crl) {
        this.btn_follow = btn_follow;
        this.crl = crl;
        this.on = false;
    }

    public Boolean isFollowEnable() {
        return this.on;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.on) {
            btn_follow.setText("SEGUI OFF");
            crl.stopFollow();
        }
        else {
            btn_follow.setText("SEGUI ON");
            crl.startFollow();
        }
        this.on = !this.on;

    }
}
