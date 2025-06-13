package es_FX.Data;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class ControllerCircleMove implements EventHandler<ActionEvent> {
    private Circle circle;
    private TextField axis;
    private Slider oft;

    public ControllerCircleMove(Circle crl, TextField ax, Slider oft) {
        this.circle = crl;
        this.axis = ax;
        this.oft = oft;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // System.out.println("HANDLE CHIAMATO");

        switch (axis.getText().toLowerCase()) {
            case "x":
                circle.setTranslateX(circle.getTranslateX() + oft.getValue());
                break;
            case "y":
                circle.setTranslateY(circle.getTranslateY() + oft.getValue());
                break;
            default:
                ;
        }
    }
}
