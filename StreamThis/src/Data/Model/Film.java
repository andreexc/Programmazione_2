package Data.Model;

public class Film extends Titolo {

    public Film(String titolo, String anno_pubblicazione, String lingua_audio, double prezzo) {
        super(titolo, anno_pubblicazione, lingua_audio, prezzo);
        this.tipologia = "Film";
    }
}
