package Data.GUI;

import Data.Comparators.CostoComparator;
import Data.Utente;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class NotEnoughFundsWindow extends Stage {

    public NotEnoughFundsWindow(ArrayList<StackVentilatore> lista_ventilatori, Utente user, UserInfo userInfo) {
        Text messaggio = new Text("Capitale Insufficente. \n Verrà rimosso l'abbonamento al ventilatore più costoso");
        Button btn_ok = new Button("Ok");
        btn_ok.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            super.hide();
            ArrayList<StackVentilatore> abbonati = new  ArrayList<>();
            for (StackVentilatore v : lista_ventilatori) {
                if (v.getVentilatore().isAbbonato()) {
                    abbonati.add(v);
                }
            }
            StackVentilatore piu_costoso = Collections.min(abbonati, new CostoComparator());
            piu_costoso.getVentilatore().DisAbbona();
            piu_costoso.refresh(user.getCapitale());

            user.modificaSpesaMensile(piu_costoso.getVentilatore().getCosto()*-1);
            userInfo.refresh();
            super.close();
        });

        VBox body = new VBox();
        body.getChildren().addAll(messaggio, btn_ok);
        body.setSpacing(5);
        body.setAlignment(Pos.CENTER);
        super.setScene(new Scene(body));
        super.sizeToScene();
        super.setResizable(false);
        super.show();
    }
}
