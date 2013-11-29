package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMasterTable;
import br.com.cafebinario.iso8583.pojo.ExchangeMcFeeCollectionExt;

public class InsertMcFeeCollectExt extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MC_FEE_COLLECTION_EXT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	/*
	public void execute(ExchangeMcFeeCollectionExt exchangeMcFeeCollectionExt)
			throws DaoException {

		try {
			this.call = conn.prepareCall(SQL_SOURCE);
			int position = 1;
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getTransDestInstId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getTransOriInstId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getAcqrInstId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getForwardingInstId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getCardSequenceNumber());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getCardIssuerReferenceData());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getCurrencyCodeTrans());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getCurrencyCodeReconciliation());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getTransLifeCiclyeId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOperation());
			this.call.setDouble(position++,
					Double.valueOf(exchangeMcFeeCollectionExt.getReconciliationAmount())/10000);
			this.call.setDouble(position++,
					exchangeMcFeeCollectionExt.getReconciliationRateConv());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOriginalAmountCurrency());
			this.call.setDouble(position++,
					exchangeMcFeeCollectionExt.getOriginalAmountTrans());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOriginalReconCurrency());
			this.call.setDouble(position++,
					exchangeMcFeeCollectionExt.getOriginalAmountRecon());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getReceivingInstId());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getDateAction());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getDataRecord());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getGcmsProductIdent());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getMessageReversalInd());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOrigProcDate());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getFeeCollectionControNum());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getCurrencyExponents());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getCurrencyCodeOriAmount());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getBusinessActivity());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getSettlementData());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getSettlementIndicator());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOriMessageFormat());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getFulfillmentDocCode());
			this.call.setString(position++,
					exchangeMcFeeCollectionExt.getMastercomNumber());
			this.call.setLong(position++,
					exchangeMcFeeCollectionExt.getOriReasonRetRequest());

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

		if (procCode == 700 || procCode == 780 || procCode == 782 || procCode == 783 || procCode == 790){
			ExchangeMasterTable mt = new ExchangeMasterTable();
			mt.setAcqrRefNumber(((ExchangeMasterTable)object).getAcqrRefNumber());
			mt.setBrandId(((ExchangeMasterTable)object).getBrandId());
			mt.setCardNumber(((ExchangeMasterTable)object).getCardNumber());
			mt.setFeeRow(((ExchangeMasterTable)object).getFeeRow());
			mt.setInstallment(((ExchangeMasterTable)object).getInstallment());
			mt.setMessageNumber(((ExchangeMasterTable)object).getMessageNumber());
			mt.setProcCode(((ExchangeMasterTable)object).getProcCode());
			mt.setProcessFileId(((ExchangeMasterTable)object).getProcessFileId());
			mt.setProductId(((ExchangeMasterTable)object).getProductId());
			mt.setReasonCode(((ExchangeMasterTable)object).getReasonCode());
			mt.setSource(((ExchangeMasterTable)object).getSource());
			mt.setTransAmount(((ExchangeMasterTable)object).getTransAmount());
			mt.setTransCode(1740);
			mt.setTransCurrency(((ExchangeMasterTable)object).getTransCurrency());
			mt.setUsageCode(((ExchangeMasterTable)object).getUsageCode());
			
			super.execute(mt, procCode);
			super.execute(object, procCode);
		}
	}
}
