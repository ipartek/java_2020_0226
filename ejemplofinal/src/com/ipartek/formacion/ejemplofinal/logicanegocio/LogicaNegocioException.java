package com.ipartek.formacion.ejemplofinal.logicanegocio;

public class LogicaNegocioException extends RuntimeException {

	private static final long serialVersionUID = -6177389577332893172L;

	public LogicaNegocioException() {
		super();
	}

	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicaNegocioException(String message) {
		super(message);
	}

	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}

	
}
