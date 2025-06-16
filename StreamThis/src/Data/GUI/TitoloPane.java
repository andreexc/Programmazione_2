package Data.GUI;

import Data.Model.Titolo;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TitoloPane extends StackPane {

    private Titolo titolo;

    private Rectangle sfondo;
    private Text riassunto_titolo;

    public TitoloPane(Titolo titolo) {
        this.titolo = titolo;

        this.init_sfondo();
        this.init_riassunto_titolo();
    }

    private void init_sfondo() {
        this.sfondo = new Rectangle(130, 40);
        if (this.titolo.getTipologia().equals("SerieTV")) {
            this.sfondo.setFill(Color.MAGENTA);
        }
        else if (this.titolo.getTipologia().equals("Film")) {
            this.sfondo.setFill(Color.CYAN);
        }
        else if (this.titolo.getTipologia().equals("Anime")) {
            this.sfondo.setFill(Color.SALMON);
        }
        super.getChildren().add(this.sfondo);
    }

    private void init_riassunto_titolo() {
        this.riassunto_titolo = new Text(this.titolo.getNome() + "('" + this.titolo.getAnnoPubblicazione().charAt(2) + this.titolo.getAnnoPubblicazione().charAt(3) + ")");
        super.getChildren().add(this.riassunto_titolo);
    }

    public Titolo getTitolo() {
        return titolo;
    }

}
