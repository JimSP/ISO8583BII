package br.com.cafebinario.iso8583.exception;

public class ParseException extends Exception{

	private static final long serialVersionUID = 2309653739690346376L;

	public ParseException(String message, Exception e) {
		super(message, e);
	}
}
