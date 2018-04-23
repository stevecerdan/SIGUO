package gob.osinergmin.sibad.service.exception;

public class NpsException extends Exception {
	
    private static final long serialVersionUID = 1L;

    public NpsException(String message, Exception exception) {
    	super(message, exception);
    }

    public NpsException(Exception exception) {
    	super(exception);
    }

    public NpsException(String message) {
    	super(message);
    }

}
