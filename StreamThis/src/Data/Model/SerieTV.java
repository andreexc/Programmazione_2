package Data;

public class SerieTV extends Titolo {

    private int numero_stagioni;

    public SerieTV(String nome, String anno_pubblicazione, String lingua_audio, int prezzo, int numero_stagioni) {
        super(nome, anno_pubblicazione, lingua_audio, prezzo);
        this.numero_stagioni = numero_stagioni;
    }
}
