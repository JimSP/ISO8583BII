package br.com.am53.cafebinario.util;

public class FormatUtil {

	public static final char SPACE = ' ';
	public static final char ZERO = '0';

	public static String LPAD(String input, char padding, int length) {

		if (input == null) {
			input = new String();
		}

		if (input.length() >= length) {
			return input;
		} else {
			StringBuffer result = new StringBuffer();
			int numChars = length - input.length();
			for (int i = 0; i < numChars; i++) {
				result.append(padding);
			}
			result.append(input);

			return result.toString();
		}
	}

	public static String RPAD(String input, char padding, int length) {

		if (input == null) {
			input = new String();
		}

		if (input.length() >= length) {
			return input;
		} else {
			StringBuffer result = new StringBuffer(input);
			int numChars = length - input.length();
			for (int i = 0; i < numChars; i++) {
				result.append(padding);
			}

			return result.toString();
		}
	}
}
