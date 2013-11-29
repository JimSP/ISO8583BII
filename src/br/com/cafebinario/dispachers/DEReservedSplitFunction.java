package br.com.cafebinario.dispachers;

import java.util.ArrayList;
import java.util.List;

import br.com.cafebinario.iso8583.ITarget;

public class DEReservedSplitFunction implements ITarget {

	@Override
	public String dispacher(String value) {
		return value;
	}

	@Override
	public List<String[]> dispacher(String value, String tag) {
		
		value = value.replace('\\', '=');
		
		String[] values = value.split("[=]");
		List<String[]> list = new ArrayList<String[]>(values.length);
		for (String field : values) {
			list.add(new String[]{"","","",field});
		}
		return list;
	}
	
	@Override
	public String[] dispacher(String value, char c) {
		return null;
	}

}
