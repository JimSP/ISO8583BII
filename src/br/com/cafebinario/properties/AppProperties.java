package br.com.cafebinario.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.cafebinario.properties.AppProperties;

public class AppProperties extends Properties {

	private String pathFile = "App.properties";

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	private static final long serialVersionUID = 4408418694809890352L;

	private static AppProperties thisInstance = new AppProperties();

	public static AppProperties instanceOf() {
		return AppProperties.thisInstance;
	}

	private AppProperties() {

	}

	public void load() {
		//System.out.println("carregar arquivo de propriedades");
		try {
			//System.out.println("pathFile=" + pathFile);
			InputStream in = getClass().getClassLoader().getResourceAsStream(pathFile);
			super.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			//System.out.println("arquivo de propriedades nao encontrado. pathFile=" + pathFile);
			e.printStackTrace();
		} catch (IOException e) {
			//System.out.println("erro ao ler arquivo de propriedades. pathFile="+  pathFile);
		}
	}
}
