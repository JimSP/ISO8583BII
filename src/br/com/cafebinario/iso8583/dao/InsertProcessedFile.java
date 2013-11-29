package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ProcessedFile;

public class InsertProcessedFile extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_PROCESSED_FILES(?,?,?,?,?,?)}";

	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	/*
	public void execute(ProcessedFile processedFile) throws DaoException {

		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");

		Date dateTime = new Date(System.currentTimeMillis());
		int currentDate = Integer.parseInt(formatDate.format(dateTime));
		int currentTime = Integer.parseInt(formatTime.format(dateTime));

		try {
			this.call = conn.prepareCall(SQL_SOURCE);
			int position = 1;
			this.call.setString(position++, Iso8583LoaderMessageInfo.FILE_ID);
			this.call.setString(position++, processedFile.getFileName());
			this.call.setInt(position++, currentDate);
			this.call.setInt(position++, currentTime);
			this.call.setDouble(position++, processedFile.getSumAmount());
			this.call.setLong(position++, processedFile.getNroRecords());

			response = new ResponseDao();
			response.setSucess(this.call.executeUpdate() > 0 ? true : false);
			response.setRowsAffects(this.call.getUpdateCount());
			response.setMessage("[" + System.currentTimeMillis() + "]["
					+ this.getClass().getName() + ".execute][" + "SUCESS" + "]");
		} catch (Exception e) {
			response.setMessage("[" + System.currentTimeMillis() + "]["
					+ this.getClass().getName() + ".execute][" + "ERROR 10"
					+ "]");
			throw new DaoException("erro ao executar CallableStatement.", e);
		} finally {
			try {
				this.call.close();
			} catch (SQLException e) {
				response.setMessage("[" + System.currentTimeMillis() + "]["
						+ this.getClass().getName() + ".execute]["
						+ "ERROR 100" + "]");
				throw new DaoException("erro ao fechar CallableStatement.", e);
			}
		}
	}
	*/

	@Override
	public void execute(Object object, int procCode) throws DaoException, IOException {
		super.execute(object, procCode);
		/*
		if (Iso8583LoaderMessageInfo.loaderSGDB)
			this.execute((ProcessedFile) object);
		*/
	}
}
