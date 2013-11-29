package br.com.cafebinario.iso8583.exception;

public class DaoException extends Exception{

	private static final long serialVersionUID = 4453044204443239630L;

	public DaoException(String message, Exception e) {
		super(message, e);
	}

}
