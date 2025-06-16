package Data;

public class Anime extends Titolo {

    private boolean hasSottotitoli;
    private String lingua_sottotitoli;

    public Anime(String nome, String anno_pubblicazione, String lingua_audio, String lingua_sottotitoli, int prezzo) {
        super(nome, anno_pubblicazione, lingua_audio, prezzo);
        this.lingua_sottotitoli = lingua_sottotitoli;

        if (lingua_sottotitoli.isEmpty()) { hasSottotitoli = false; }
        else                              { hasSottotitoli = true;  }
    }

    public String getLingua_sottotitoli() {
        return lingua_sottotitoli;
    }
}
