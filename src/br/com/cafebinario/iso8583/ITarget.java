package br.com.cafebinario.iso8583;

import java.util.List;

public interface ITarget {
	String dispacher(String value);
	List<String[]> dispacher(String value, String tag);
	String[] dispacher(String value, char c);
}
