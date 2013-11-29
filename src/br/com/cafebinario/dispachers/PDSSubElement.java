package br.com.cafebinario.dispachers;

import br.com.cafebinario.iso8583.ITarget;

public class PDSSubElement extends AbstractSubElement implements ITarget {

	@Override
	public String dispacher(String value) {
		return value;
	}

	@Override
	public String[] dispacher(String value, char c) {
		return null;
	}
}
