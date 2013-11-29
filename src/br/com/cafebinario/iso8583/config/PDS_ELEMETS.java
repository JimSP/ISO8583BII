package br.com.cafebinario.iso8583.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PDS_ELEMETS extends Properties {

	private String pathFile;

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static PDS_ELEMETS thisInstance = new PDS_ELEMETS();

	public static PDS_ELEMETS instanceOf() {
		return PDS_ELEMETS.thisInstance;
	}

	private PDS_ELEMETS() {

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
