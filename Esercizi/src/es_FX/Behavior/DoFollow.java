package es_FX.Behavior;

import es_FX.Data.AliveCircle;
import javafx.scene.input.MouseEvent;

public class DoFollow extends Behavior {
    AliveCircle circle;

    public DoFollow(AliveCircle circle) { this.circle = circle; }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_MOVED) {
            circle.setTranslateX(mouseEvent.getSceneX() - circle.getScene().getWidth() / 2);
            circle.setTranslateY(mouseEvent.getSceneY() - circle.getScene().getHeight() / 2);
            //System.out.println("BEHAVING");
        }
    }
}
