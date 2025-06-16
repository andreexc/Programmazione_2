package Data;

public abstract class Titolo {

    private String nome;
    private String anno_pubblicazione;
    private String lingua_audio;
    private int prezzo;

    public Titolo(String nome, String anno_pubblicazione, String lingua_audio, int prezzo) {
        this.nome = nome;
        this.anno_pubblicazione = anno_pubblicazione;
        this.lingua_audio = lingua_audio;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getAnnoPubblicazione() {
        return anno_pubblicazione;
    }

    public String getLinguaAudio() {
        return lingua_audio;
    }

    public int getPrezzo() {
        return prezzo;
    }

    protected abstract void calcolaPrezzoEffettivo();
}
