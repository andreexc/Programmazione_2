package Data.Ventilatori;

import Data.Exceptions.ForbiddenAlimentazioneException;

public class VentilatorePiantana extends Ventilatore {

    public VentilatorePiantana(String marca, String alimentazione) throws ForbiddenAlimentazioneException {
        super(marca);
        this.alimentazione = alimentazione;
        this.costo += 10;  // perché ventilatore a piantana
        this.tipologia = "Piantana";

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
