package Data.Model;

import java.text.ParseException;

public abstract class Titolo {

    protected String nome;
    protected String anno_pubblicazione;
    protected String lingua_audio;
    protected double prezzo;
    protected String tipologia;

    public Titolo(String nome, String anno_pubblicazione, String lingua_audio, double prezzo) {
        this.nome = nome;
        this.anno_pubblicazione = anno_pubblicazione;
        this.lingua_audio = lingua_audio;
        this.prezzo = prezzo;

        try {
            int try_parse = Integer.parseInt(anno_pubblicazione);
        }
        catch (NumberFormatException e) {
            System.err.println(anno_pubblicazione + " is not an integer");
            System.exit(1);
        }
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

    public double getPrezzo() {
        return prezzo;
    }

    public String getTipologia() {
        return tipologia;
    }

    @Override
    public String toString() {
        return "Titolo: " + this.getNome() + "\nAnno: " + this.getAnnoPubblicazione() + "\nLingua: " + this.getLinguaAudio() + "\nPrezzo Base: " + this.getPrezzo();
    }

    public double calcolaPrezzoEffettivo() {
        if (Integer.parseInt(this.anno_pubblicazione) < 2015) {
            return this.getPrezzo() - (this.getPrezzo() * 0.1);  // -10%
        }
        return this.getPrezzo();
    }
}
