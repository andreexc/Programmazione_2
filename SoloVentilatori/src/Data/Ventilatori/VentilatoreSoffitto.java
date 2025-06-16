package Data.Ventilatori;

import Data.Exceptions.ForbiddenAlimentazioneException;

public class VentilatoreSoffitto extends Ventilatore {

    public VentilatoreSoffitto(String marca, String alimentazione) throws ForbiddenAlimentazioneException {
        super(marca);
        this.alimentazione = alimentazione;
        this.costo += 2;  // perché ventilatore a soffitto
        this.tipologia = "Soffitto";

        if (this.alimentazione.equalsIgnoreCase("presa")) {
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
