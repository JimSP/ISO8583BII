package br.com.cafebinario.iso8583;

public class SumaryField {
	private String elementTag;
	private long qtd;
	private double value;

	public String getElementTag() {
		return elementTag;
	}

	public void setElementTag(String elementTag) {
		this.elementTag = elementTag;
	}

	public long getQtd() {
		return qtd;
	}

	public void add(double value) {
		this.qtd++;
		this.value += value;
	}
	
	public double getTotalValue(){
		return this.value;
	}
}
