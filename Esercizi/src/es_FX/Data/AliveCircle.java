package es_FX.Data;

import es_FX.Behavior.Behavior;
import es_FX.Behavior.DoFollow;
import es_FX.Behavior.NoFollow;
import javafx.scene.shape.Circle;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AliveCircle extends Circle {

    Behavior behavior;

    public AliveCircle() {
        super();
        this.behavior = new NoFollow();
    }

    public void handle(MouseEvent e) {
        behavior.handle(e);
    }

    void stopFollow() { this.behavior = new NoFollow(); }
    void startFollow() { this.behavior = new DoFollow(this); }
}
