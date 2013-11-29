package br.com.cafebinario.dispachers;

import java.util.ArrayList;
import java.util.List;

import br.com.cafebinario.iso8583.config.SUB_ELEMENTS;

public abstract class AbstractSubElement {
	
	//ElementoA,0-3#ElementoB,3-6#ElementoD,6-18,ElementoE,18-21#ElementoF,21-33
	public List<String[]> dispacher(String value, String tag) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		String pattern = SUB_ELEMENTS.instanceOf().getProperty(tag);
		String[] elements = pattern.split("[;]");
		
		for (String elementPattern : elements) {
			String[] itens = elementPattern.split("[,-]");
			result.add(itens);
		}
		
		return result;
	}

}
