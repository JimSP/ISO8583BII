package br.com.cafebinario.iso8583.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IPM_DESTINATION_TABLE  extends Properties {

	private String pathFile;

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static IPM_DESTINATION_TABLE thisInstance = new IPM_DESTINATION_TABLE();

	public static IPM_DESTINATION_TABLE instanceOf() {
		return IPM_DESTINATION_TABLE.thisInstance;
	}

	private IPM_DESTINATION_TABLE() {

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