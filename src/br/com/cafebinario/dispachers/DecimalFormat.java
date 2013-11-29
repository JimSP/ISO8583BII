package br.com.cafebinario.dispachers;

import java.util.List;

import br.com.cafebinario.iso8583.ITarget;

public class DecimalFormat implements ITarget {

	@Override
	public String dispacher(String value) {
		try{
			return String.format("%.2f", Double.parseDouble(value)/100.00).replace(',', '.');
		}catch(Exception e){
			return value;
		}
	}

	@Override
	public List<String[]> dispacher(String value, String tag) {
		return null;
	}

	@Override
	public String[] dispacher(String value, char c) {
		return null;
	}

}
