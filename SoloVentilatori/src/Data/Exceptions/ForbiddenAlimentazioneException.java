package Data.Exceptions;

public class ForbiddenAlimentazioneException extends RuntimeException {
    public ForbiddenAlimentazioneException() {
        super("Ventilatore non esistente.");
    }
}
