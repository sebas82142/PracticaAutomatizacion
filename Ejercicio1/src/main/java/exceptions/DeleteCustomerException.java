package exceptions;

public class DeleteCustomerException extends AssertionError {

	public static final String DELETE_CUSTOMER_MESSAGE_ERROR = "Error delete customer";
	
	public DeleteCustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
