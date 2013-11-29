package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMcRetRequest;

public class InsertMcRetRequest extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MC_RET_REQUEST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	private CallableStatement call;
	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	public InsertMcRetRequest(Connection conn) throws SQLException {
		this.call = conn.prepareCall(SQL_SOURCE);
	}

	public void execute(ExchangeMcRetRequest exchangeMcRetRequest)
			throws DaoException {

		try {
			int position = 1;
			this.call.setLong(position++,
					exchangeMcRetRequest.getTransDestInstId());
			this.call.setLong(position++,
					exchangeMcRetRequest.getTransOriInstId());
			this.call.setLong(position++, exchangeMcRetRequest.getMcc());
			this.call.setString(position++,
					exchangeMcRetRequest.getCardAceptorName());
			this.call.setString(position++,
					exchangeMcRetRequest.getCardAceptorZipCode());
			this.call.setString(position++,
					exchangeMcRetRequest.getCardAceptorReg());
			this.call.setString(position++,
					exchangeMcRetRequest.getCardAceptor_country());
			this.call.setString(position++,
					exchangeMcRetRequest.getGcms_productIdent());
			this.call.setString(position++,
					exchangeMcRetRequest.getMessageReversalInd());
			this.call.setLong(position++,
					exchangeMcRetRequest.getOrigProcDate());
			this.call.setLong(position++,
					exchangeMcRetRequest.getCurrencyCode());
			this.call.setString(position++,
					exchangeMcRetRequest.getCurrencyExponent());
			this.call.setString(position++,
					exchangeMcRetRequest.getBusinessActivity());
			this.call.setString(position++,
					exchangeMcRetRequest.getSettlementData());
			this.call.setString(position++,
					exchangeMcRetRequest.getSettlementIndicator());
			this.call.setDouble(position++,
					exchangeMcRetRequest.getReconciliationAmount());
			this.call.setLong(position++,
					exchangeMcRetRequest.getReconciliationRateConv());
			this.call.setDouble(position++,
					exchangeMcRetRequest.getOriginalAmountCurrency());
			this.call.setDouble(position++,
					exchangeMcRetRequest.getOriginalAmount_trans());
			this.call.setLong(position++,
					exchangeMcRetRequest.getOriginalReconCurrency());
			this.call.setDouble(position++,
					exchangeMcRetRequest.getOriginalAmountRecon());
			this.call.setLong(position++,
					exchangeMcRetRequest.getOri_message_format());
			this.call.setString(position++,
					exchangeMcRetRequest.getTransLifeCiclyeId());
			this.call.setLong(position++,
					exchangeMcRetRequest.getMastercom_number());
			this.call.setString(position++,
					exchangeMcRetRequest.getMastercomRetResp());
			this.call.setString(position++,
					exchangeMcRetRequest.getMastercomRetResp());
			this.call.setString(position++,
					exchangeMcRetRequest.getMastercomChbkDoc_sup());
			this.call.setString(position++,
					exchangeMcRetRequest.getExclusionIndicator());
			this.call.setString(position++,
					exchangeMcRetRequest.getReturnData());
			this.call.setString(position++,
					exchangeMcRetRequest.getResubmissionData());

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

	@Override
	public void execute(Object object, int procCode) throws DaoException, IOException {
		super.execute(object, procCode);

		if (Iso8583LoaderMessageInfo.loaderSGDB)
			this.execute((ExchangeMcRetRequest) object);
	}
}
