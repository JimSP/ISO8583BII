package br.com.cafebinario.iso8583.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FORMAT extends Properties {

	private String pathFile;

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static FORMAT thisInstance = new FORMAT();

	public static FORMAT instanceOf() {
		return FORMAT.thisInstance;
	}

	private FORMAT() {

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
