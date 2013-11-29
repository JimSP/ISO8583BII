package br.com.cafebinario.iso8583;

public class Iso8583ParseException extends Exception {
	
	private static final long serialVersionUID = 6528579765616868956L;

	public Iso8583ParseException(String msg, Throwable t){
		super(msg, t);
	}
	
	public Iso8583ParseException(String msg){
		super(msg);
	}
}
