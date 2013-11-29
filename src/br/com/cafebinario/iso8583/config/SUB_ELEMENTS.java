package br.com.cafebinario.iso8583.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SUB_ELEMENTS extends Properties {

	private String pathFile = "SUB_ELEMENTS";

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890387L;

	private static SUB_ELEMENTS thisInstance = new SUB_ELEMENTS();

	public static SUB_ELEMENTS instanceOf() {
		return SUB_ELEMENTS.thisInstance;
	}

	private SUB_ELEMENTS() {

	}

	public void load() throws IOException {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(
					pathFile);
			super.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}

