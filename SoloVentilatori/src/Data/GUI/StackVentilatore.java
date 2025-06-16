package Data.GUI;

import Data.Ventilatori.Ventilatore;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class StackVentilatore extends StackPane {

    private HBox casella;
    private Ventilatore ventilatore;
    private Circle Stato;

    public StackVentilatore(Ventilatore ventilatore, int capitale_iniziale) {
        this.ventilatore = ventilatore;
        this.casella = new HBox();
        this.Stato = new Circle();
        this.Stato.setRadius(25);
        this.Stato.setStrokeWidth(5);

        this.refresh(capitale_iniziale);
        this.casella.getChildren().addAll(this.Stato, new Text(ventilatore.toString()));
        super.getChildren().add(this.casella);
    }

    public void refresh(int capitale_utente) {
        if (this.ventilatore.getCosto() > capitale_utente) { this.Stato.setStroke(AssociazioniColori.BordFondiInsufficenti); }
        else                                               { this.Stato.setStroke(AssociazioniColori.BordFondoSufficenti); }
        if (this.ventilatore.isAbbonato()) { this.Stato.setFill(AssociazioniColori.Abbonato); }
        else                               { this.Stato.setFill(AssociazioniColori.NonAbbonato); }
    }

    public Circle getStato() {
        return this.Stato;
    }

    public Ventilatore getVentilatore() {
        return this.ventilatore;
    }

    @Override
    public String toString() {
        return this.ventilatore.toString();
    }

    public int toggleAbbonamento() {

        int costo =  this.ventilatore.getCosto();
        if (this.ventilatore.isAbbonato()) {
            this.ventilatore.DisAbbona();
        }
        else {
            this.ventilatore.Abbona();
            costo *= -1;
        }
        return costo;
    }
}
