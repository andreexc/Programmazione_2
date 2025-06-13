package TestingFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class mainn extends Application {
    public static void main(String[] args) { launch(args); }

    private Button primaryButton;
    private TextField textField_counter;
    private int counter; // inizializzato a 0 automagicamente

    @Override
    public void start(Stage stage) throws Exception {

        primaryButton = new Button("Cliccami!");
        textField_counter = new TextField("Hai cliccato 0 volte");
        textField_counter.setEditable(false);

        VBox primaryVBox = new VBox();
        primaryVBox.setSpacing(10);
        primaryVBox.getChildren().addAll(primaryButton, textField_counter);

        BorderPane root = new BorderPane();
        root.setCenter(primaryVBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();

        primaryButton.addEventHandler(ActionEvent.ACTION, new CounterMouseListener());
        scene.addEventHandler(KeyEvent.ANY, new CounterKeyboardListener());

        stage.show();
    }

    private class CounterMouseListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            textField_counter.setText("Hai cliccato " + ++counter + " volte");
            System.out.println(actionEvent.getSource() + " ==> " + actionEvent.getTarget());
        }
    }

    private class CounterKeyboardListener implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent k_event) {
            if (k_event.getCode() == KeyCode.ENTER) { primaryButton.fireEvent(new ActionEvent()); System.out.println(k_event.getSource() + " ==> " + k_event.getTarget()); }
            else if (k_event.getCode() == KeyCode.Q) { System.exit(0); }
        }
    }
}
