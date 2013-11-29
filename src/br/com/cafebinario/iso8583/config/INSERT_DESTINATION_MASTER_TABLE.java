package br.com.cafebinario.iso8583.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class INSERT_DESTINATION_MASTER_TABLE extends Properties {

	private String pathFile;

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static INSERT_DESTINATION_MASTER_TABLE thisInstance = new INSERT_DESTINATION_MASTER_TABLE();

	public static INSERT_DESTINATION_MASTER_TABLE instanceOf() {
		return INSERT_DESTINATION_MASTER_TABLE.thisInstance;
	}

	private INSERT_DESTINATION_MASTER_TABLE() {

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