package Data.Ventilatori;

import Data.Exceptions.ForbiddenAlimentazioneException;

public class VentilatoreParete extends Ventilatore {

    public VentilatoreParete(String marca, String alimentazione) throws ForbiddenAlimentazioneException {
        super(marca);
        this.alimentazione = alimentazione;
        this.costo += 20;  // perché ventilatore a parete
        this.tipologia = "Parete";

        if (this.alimentazione.equalsIgnoreCase("meccanica")) {
            this.costo *= 1;
        }
        else if (this.alimentazione.equalsIgnoreCase("presa")) {
            this.costo *= 2;
        }
        else if (this.alimentazione.equalsIgnoreCase("batteria")) {
            this.costo *= 3;
        }
        else {
            throw new ForbiddenAlimentazioneException();
        }
    }
}
