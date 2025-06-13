package data.Exceptions;

public class WrongCoordinatesException extends RuntimeException {
    public WrongCoordinatesException() {
        super("Wrong Coordinates");
    }
}
