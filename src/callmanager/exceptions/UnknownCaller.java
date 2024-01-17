package callmanager.exceptions;

public class UnknownCaller extends RuntimeException {
    public UnknownCaller(String message) {
        super(message);
    }
}
