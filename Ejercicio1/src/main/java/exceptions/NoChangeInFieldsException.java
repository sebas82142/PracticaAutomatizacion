package exceptions;

public class NoChangeInFieldsException extends AssertionError {

	public static final String NO_CHANGE_FIELDS_MESSAGE_ERROR = "Error fields was no modify";
	
	public NoChangeInFieldsException(String message, Throwable cause) {
        super(message, cause);
    }

}
