package Data.Exceptions;

public class NonCompletableQuestException extends RuntimeException {
    public NonCompletableQuestException(String message) {
        super(message);
    }
}
