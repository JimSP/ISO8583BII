package br.com.cafebinario.iso8583.dao;

public class ResponseDao {

	private boolean sucess;
	private long rowsAffects;
	private String message;

	public boolean isSucess() {
		return sucess;
	}
	
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	
	public long getRowsAffects() {
		return rowsAffects;
	}
	
	public void setRowsAffects(long rowsAffects) {
		this.rowsAffects = rowsAffects;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
