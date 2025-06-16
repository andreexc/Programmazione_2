package Data.Exceptions;

public class SeasonException extends RuntimeException {
    public SeasonException() {
        super("Errore durante la selezione delle stagioni");
    }
}
