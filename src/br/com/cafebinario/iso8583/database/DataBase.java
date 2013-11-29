package br.com.cafebinario.iso8583.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.cafebinario.iso8583.exception.DBException;
import br.com.cafebinario.properties.AppProperties;

public class DataBase {
	private static Logger LOG = Logger.getLogger(DataBase.class);
	private static DataBase thisInstance = new DataBase();

	public static DataBase instanceOf() {
		return DataBase.thisInstance;
	}

	private DataBase() {
	}

	protected AppProperties properties = AppProperties.instanceOf();

	public java.sql.Connection getConnection() throws DBException {
		Connection connection = null;
		try {
			Class.forName(properties.getProperty("DRIVER_DB"));
			connection = DriverManager.getConnection(properties
					.getProperty("STR_CON"));
		} catch (ClassNotFoundException e) {
			LOG.error("Driver BD nao encontrado", e);
			throw new DBException("Banco de Dados nao encontrado", e);
		} catch (SQLException e) {
			LOG.error("Problemas de conexao com banco de dados", e);
			throw new DBException(
					"Problemas ao estabelecer conexao com banco de dados", e);
		}
		return connection;
	}

	public java.sql.Connection getConnection(String strConnName,
			String driverDbName) throws DBException {
		Connection connection = null;
		try {
			Class.forName(properties.getProperty(driverDbName));
			connection = DriverManager.getConnection(properties
					.getProperty(strConnName));
		} catch (ClassNotFoundException e) {
			LOG.error("Driver BD nao encontrado", e);
			throw new DBException("Banco de Dados nao encontrado");
		} catch (SQLException e) {
			LOG.error("Problemas de conexao com banco de dados", e);
			throw new DBException(
					"Problemas ao estabelecer conexao com banco de dados");
		}
		return connection;
	}
}
