package com.ipartek.formacion.excepciones;

public class PuntoException extends RuntimeException {

	private static final long serialVersionUID = -1801376260047587491L;

	public PuntoException() {
		super();
	}

	public PuntoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PuntoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PuntoException(String message) {
		super(message);
	}

	public PuntoException(Throwable cause) {
		super(cause);
	}

	
}
