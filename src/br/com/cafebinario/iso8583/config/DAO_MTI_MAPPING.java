package br.com.cafebinario.iso8583.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAO_MTI_MAPPING extends Properties {
	private String pathFile;

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static DAO_MTI_MAPPING thisInstance = new DAO_MTI_MAPPING();

	public static DAO_MTI_MAPPING instanceOf() {
		return DAO_MTI_MAPPING.thisInstance;
	}

	private DAO_MTI_MAPPING() {

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
