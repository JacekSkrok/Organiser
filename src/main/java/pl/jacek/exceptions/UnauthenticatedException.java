package pl.jacek.exceptions;

public class UnauthenticatedException extends Exception {

    public UnauthenticatedException(String messege) {
        super(messege);
    }

    public UnauthenticatedException() {
        super("Unauthenicated access ");
    }

}
