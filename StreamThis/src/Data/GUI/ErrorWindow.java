package Data.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ErrorWindow extends Stage {

    public ErrorWindow(String message) {
        super();
        this.init_window(this, message);
    }

    private void init_window(Stage stage, String message) {
        VBox body = new VBox();
        Text messaggio = new Text(message);
        Button ok_btn = new Button("OK");
        ok_btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        body.setAlignment(Pos.CENTER);
        body.getChildren().addAll(messaggio, ok_btn);
        super.setScene(new Scene(body));
        super.setResizable(false);
        super.sizeToScene();
        super.show();
    }
}
