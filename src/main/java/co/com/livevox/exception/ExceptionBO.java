package co.com.livevox.exception;

/**
 * Manage exceptions in the business layer
 * @author Fabian Andres Lopez Galindez
 * @version 1.0
 * @since  Feb 11, 2019
 */

public class ExceptionBO extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private String code;
	
	public ExceptionBO(String message, String code){		
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	

}
