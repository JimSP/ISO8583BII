package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMcChargebackExt;

public class InsertExchangeMcChargeBackExt extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MC_CHARGEBACK_EXT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	public InsertExchangeMcChargeBackExt() throws SQLException {
		CLASS_VALUE_OBJECT = "br.com.cafebinario.iso8583.pojo.ExchangeMcFeeCollectionExt";
	}

	/*
	public void execute(ExchangeMcChargebackExt exchangeMcChargebackExt)
			throws DaoException {

		try {
			int position = 1;
			this.call.setString(position++,
					exchangeMcChargebackExt.getInstallment());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getTransDestInstId());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getTransOriInstId());
			this.call.setLong(position++, exchangeMcChargebackExt.getMcc());
			this.call.setString(position++,
					exchangeMcChargebackExt.getCardAceptorName());
			this.call.setString(position++,
					exchangeMcChargebackExt.getCardAceptorZipCode());
			this.call.setString(position++,
					exchangeMcChargebackExt.getCardAceptorReg());
			this.call.setString(position++,
					exchangeMcChargebackExt.getCardAceptorCountry());
			this.call.setString(position++,
					exchangeMcChargebackExt.getGcmsProductIdent());
			this.call.setString(position++,
					exchangeMcChargebackExt.getMessageReversalInd());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getOrigProcDate());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getCurrencyCode());
			this.call.setString(position++,
					exchangeMcChargebackExt.getCurrencyExponent());
			this.call.setString(position++,
					exchangeMcChargebackExt.getBusinessActivity());
			this.call.setString(position++,
					exchangeMcChargebackExt.getSettlementData());
			this.call.setString(position++,
					exchangeMcChargebackExt.getSettlementIndicator());
			this.call.setDouble(position++,
					exchangeMcChargebackExt.getReconciliationAmount());
			this.call.setDouble(position++,
					exchangeMcChargebackExt.getReconciliationRateConv());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getOriginalAmountCurrency());
			this.call.setDouble(position++,
					exchangeMcChargebackExt.getOriginalAmountTrans());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getOriginalReconCurrency());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getOriMessageFormat());
			this.call.setString(position++,
					exchangeMcChargebackExt.getTransLifeCiclyeId());
			this.call.setLong(position++,
					exchangeMcChargebackExt.getOriMessageFormat());
			this.call.setString(position++,
					exchangeMcChargebackExt.getMastercomNumber());
			this.call.setString(position++,
					exchangeMcChargebackExt.getMastercomRetResp());
			this.call.setString(position++,
					exchangeMcChargebackExt.getMastercomChbkDocSup());
			this.call.setString(position++,
					exchangeMcChargebackExt.getExclusionIndicator());
			this.call.setString(position++,
					exchangeMcChargebackExt.getReturnData());
			this.call.setString(position++,
					exchangeMcChargebackExt.getResubmissionData());

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
	}*/

	@Override
	public void execute(Object object, int procCode) throws DaoException, IOException {
		super.execute(object, procCode);
		/*
		if (Iso8583LoaderMessageInfo.loaderSGDB)
			if (procCode == 450)
				this.execute((ExchangeMcChargebackExt) object);
			else if (procCode == 451)
				this.execute((ExchangeMcChargebackExt) object);
			else if (procCode == 453)
				this.execute((ExchangeMcChargebackExt) object);
			else if (procCode == 454)
		*/
	}
}
