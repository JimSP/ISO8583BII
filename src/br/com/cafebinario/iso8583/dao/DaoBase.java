package br.com.cafebinario.iso8583.dao;

import java.io.FileWriter;
import java.io.IOException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;

public abstract class DaoBase {
	public String CLASS_VALUE_OBJECT;
	public abstract ResponseDao getResponse();
	public void execute(Object object, int procCode) throws DaoException, IOException{
		FileWriter writer = new FileWriter(Iso8583LoaderMessageInfo.FULL_FILE_NAME + "_PROCESSADO", true);
		writer.write(object.toString() + "\r\n");
		writer.close();
	}
}
