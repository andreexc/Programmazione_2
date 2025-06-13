package es_FX;
import es_FX.Data.AliveCircle;
import es_FX.Data.ControllerCircleFollow;
import es_FX.Data.ControllerCircleMove;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Test_FX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Ballin'");

        AliveCircle circle = new AliveCircle();
        circle.setRadius(20);

        TextField textField_move_axis = new TextField();
        textField_move_axis.setPromptText("Asse di Guida");
        Slider slider_offset = new Slider();
        slider_offset.setMin(-500);
        slider_offset.setMax(500);
        TextField slider_value = new TextField();
        slider_value.setEditable(false);
        slider_value.setMaxWidth(40);
        slider_value.setText(Math.round(slider_offset.getValue()) + "");
        slider_offset.valueProperty().addListener((ov, old_val, new_val) -> {slider_value.setText(new_val.intValue() + "");});


        Button btn_move = new Button("Muovi");
        btn_move.addEventHandler(ActionEvent.ACTION, new ControllerCircleMove(circle, textField_move_axis, slider_offset));

        Button btn_follow = new Button("Segui OFF");
        btn_follow.addEventHandler(ActionEvent.ACTION, new ControllerCircleFollow(btn_follow, circle));

        Button btn_reset = new Button("Reset");
        btn_reset.addEventHandler(ActionEvent.ACTION, (e) -> { circle.setTranslateX(0); circle.setTranslateY(0); });

        HBox controls = new HBox();
        controls.getChildren().addAll(btn_move, btn_reset, textField_move_axis, slider_offset, slider_value, btn_follow);
        controls.setSpacing(10);
        controls.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setBottom(controls);
        root.setCenter(circle);
        Scene scene = new Scene(root, 800, 600);
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, (e) -> { circle.handle(e); });

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
