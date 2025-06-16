package Data.Model;

import Data.Exceptions.SeasonException;

public class SerieTV extends Titolo {

    private int numero_stagioni;
    private int stagioni_selezionate;

    public SerieTV(String nome, String anno_pubblicazione, String lingua_audio, double prezzo, int numero_stagioni) {
        super(nome, anno_pubblicazione, lingua_audio, prezzo);
        this.numero_stagioni = numero_stagioni;
        this.tipologia = "SerieTV";
        this.stagioni_selezionate = 1;
    }

    @Override
    public double calcolaPrezzoEffettivo() {
        double prezzo_base = this.prezzo;
        System.out.println("Prezzo base: " + prezzo_base);
        prezzo_base = prezzo_base*this.stagioni_selezionate;
        if (Integer.parseInt(this.anno_pubblicazione) < 2015) {
            prezzo_base -= (prezzo_base * 0.1);  // -10%
        }
        if (stagioni_selezionate == this.numero_stagioni) {
            prezzo_base = prezzo_base - (prezzo_base/2); // 50% di sconto
        }
        else if (stagioni_selezionate < this.numero_stagioni && stagioni_selezionate >= 1) {
            prezzo_base = prezzo_base - (prezzo_base/4); // 25% di sconto
        }
        else {
            throw new SeasonException();
        }
        return prezzo_base;
    }

    public int getNumeroStagioni() {
        return numero_stagioni;
    }

    public void aggiungiSerie() {
        this.stagioni_selezionate++;
    }

    public void resetCounterSerie() {
        this.stagioni_selezionate = 1;
    }
}
