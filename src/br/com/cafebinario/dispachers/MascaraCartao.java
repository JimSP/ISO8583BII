package br.com.cafebinario.dispachers;

import java.util.List;

import br.com.cafebinario.iso8583.ITarget;

public class MascaraCartao implements ITarget{

	@Override
	public String dispacher(String value) {
		
		if(value == null){
			return null;
		}
		
		int length = value.length();
		
		if(length == 13){
			return "XXXX" + value.substring(4, 9) + "XXXX";
		}else if(length == 14){
			return "XXXX" + value.substring(4, 10) + "XXXX";
		}else if(length == 15){
			return "XXXXX" + value.substring(5, 10) + "XXXXX";
		}else if(length == 16){
			return "XXXXX" + value.substring(5, 11) + "XXXXX";
		}else if(length == 17){
			return "XXXXXX" + value.substring(6, 11) + "XXXXXX";
		}else if(length == 18){
			return "XXXXXX" + value.substring(6, 12) + "XXXXXX";
		}else if(length == 19){
			return "XXXXXXX" + value.substring(7, 12) + "XXXXXXX";
		}else{
			return "XXXXXXX" + value.substring(7, 12) + "XXXXXXX";
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
