package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMcPresentmentExt;

public class InsertMcPresentmentExt extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MC_PRESENTMENT_EXT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

/*
	public void execute(ExchangeMcPresentmentExt exchangeMcPresentmentExt)
			throws DaoException {

		try {
			this.call = conn.prepareCall(SQL_SOURCE);
			
			int position = 1;
			this.call.setString(position++,
					exchangeMcPresentmentExt.getInstallment());
			this.call.setLong(position++,
					exchangeMcPresentmentExt.getTransDestInstId());
			this.call.setLong(position++,
					exchangeMcPresentmentExt.getTransOriInstId());
			this.call.setDouble(position++,
					exchangeMcPresentmentExt.getReconciliationAmount());
			this.call.setLong(position++,
					exchangeMcPresentmentExt.getReconciliationRateConv());
			this.call.setString(position++,
					exchangeMcPresentmentExt.getOriginalAmountCurrency());
			this.call.setDouble(position++,
					Double.valueOf(exchangeMcPresentmentExt.getOriginalAmountTrans())/10000.00);
			this.call.setLong(position++,
					exchangeMcPresentmentExt.getOriginalReconCurrency());
			this.call.setDouble(position++,
					Double.valueOf(exchangeMcPresentmentExt.getOriginalAmountRecon())/10000.00);
			this.call.setLong(position++,
					Long.parseLong(exchangeMcPresentmentExt.getLocalDate()));
			this.call.setLong(position++,
					Long.parseLong(exchangeMcPresentmentExt.getLocalTime()));
			this.call.setString(position++,
					exchangeMcPresentmentExt.getBusinessActivity());
			this.call.setLong(position++,
					exchangeMcPresentmentExt.getRiskAprovalCode());
			this.call.setString(position++,
					exchangeMcPresentmentExt.getTransLifeCiclyeId());
			this.call.setString(position++,
					exchangeMcPresentmentExt.getPosDataCode());

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
			this.execute((ExchangeMcPresentmentExt) object);
		*/
	}
}
