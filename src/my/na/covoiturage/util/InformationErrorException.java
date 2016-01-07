package my.na.covoiturage.util;

import java.util.ArrayList;
import java.util.List;

public class InformationErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public InformationErrorException() {
		// TODO Auto-generated constructor stub
		
	}

	public InformationErrorException(String message) {
		super(message);
		this.msg = message;
		// TODO Auto-generated constructor stub
	}

	public InformationErrorException(Throwable cause) {
		super(cause);
		
	}

	public InformationErrorException(String message, Throwable cause) {
		super(message, cause);
		this.msg = message;
	}

	public InformationErrorException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.msg = message;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}

	

}
