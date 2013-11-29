package br.com.cafebinario.iso8583.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LAYOUT_XML extends Properties {

	private String pathFile = "LAYOUT_XML";

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694899890352L;

	private static LAYOUT_XML thisInstance = new LAYOUT_XML();

	public static LAYOUT_XML instanceOf() {
		return LAYOUT_XML.thisInstance;
	}

	private LAYOUT_XML() {
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
