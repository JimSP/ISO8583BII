package br.com.cafebinario.iso8583.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LAYOUT_MASTER extends Properties {

	private String pathFile = "LAYOUT_MASTER";

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static LAYOUT_MASTER thisInstance = new LAYOUT_MASTER();

	public static LAYOUT_MASTER instanceOf() {
		return LAYOUT_MASTER.thisInstance;
	}

	private LAYOUT_MASTER() {
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
