package br.com.cafebinario.iso8583.threads;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import ValueObjectFactory.DaoFactory;
import br.com.cafebinario.iso8583.ConfigInfo;
import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.Iso8583ParseException;
import br.com.cafebinario.iso8583.MessageInfo;
import br.com.cafebinario.iso8583.dao.DaoBase;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.exception.ParseException;

public class Processador extends Thread {

	private MessageInfo info;
	private ConfigInfo config;
	private Connection connection;

	public void run() {
		
		runNoMultiThread();
		try {
			sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void runNoMultiThread() {
		Iso8583LoaderMessageInfo loader = new Iso8583LoaderMessageInfo();

		DaoBase dao = DaoFactory.instanceOf().getDao(info.getMTI_CODE());
		try {
			loader.processMessage(info, config);
			loader.loaderDataBase(dao);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Iso8583ParseException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ConfigInfo getConfig() {
		return config;
	}

	public void setConfig(ConfigInfo config) {
		this.config = config;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setInfo(MessageInfo info) {
		this.info = info;
	}

	public MessageInfo getInfo() {
		return info;
	}
}
