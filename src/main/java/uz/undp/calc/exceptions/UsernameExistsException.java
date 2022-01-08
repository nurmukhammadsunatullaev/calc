package uz.undp.calc.exceptions;

public class UsernameExistsException extends Exception{
    public UsernameExistsException(String message, Throwable t) {
        super(message, t);
    }

    public UsernameExistsException(String message) {
        super(message);
    }
}
