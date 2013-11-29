package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMasterTable;
import br.com.cafebinario.iso8583.pojo.ExchangeMcFeeCollectionExt;
import br.com.cafebinario.iso8583.pojo.ExchangeMcPresentmentExt;

public class InsertExchangeMasterTable extends DaoBase {

	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MASTER_TABLE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	/*
	 * public void execute(ExchangeMasterTable exchangeMasterTable) throws
	 * DaoException {
	 * 
	 * try { this.call = conn.prepareCall(SQL_SOURCE); int position = 1;
	 * this.call.setInt(position++, exchangeMasterTable.getBrandId());
	 * this.call.setInt(position++, exchangeMasterTable.getProductId());
	 * this.call.setString(position++, exchangeMasterTable.getSource());
	 * this.call.setString(position++, exchangeMasterTable.getInstallment());
	 * this.call.setLong(position++, exchangeMasterTable.getCardNumber());
	 * this.call.setInt(position++, exchangeMasterTable.getTransCode());
	 * this.call.setInt(position++, exchangeMasterTable.getUsageCode());
	 * this.call.setInt(position++, exchangeMasterTable.getReasonCode());
	 * this.call.setString(position++, exchangeMasterTable.getProcCode());
	 * this.call.setString(position++, exchangeMasterTable.getAcqrRefNumber());
	 * this.call .setInt(position++, exchangeMasterTable.getTransCurrency());
	 * this.call.setDouble(position++, exchangeMasterTable.getTransAmount());
	 * this.call.setString(position++, exchangeMasterTable.getFeeRow());
	 * this.call.setString(position++, Iso8583LoaderMessageInfo.FILE_ID);
	 * this.call .setInt(position++, exchangeMasterTable.getMessageNumber());
	 * 
	 * response = new ResponseDao();
	 * response.setSucess(this.call.executeUpdate() > 0 ? true : false);
	 * response.setRowsAffects(this.call.getUpdateCount());
	 * 
	 * response.setMessage("[" + System.currentTimeMillis() + "][" +
	 * this.getClass().getName() + ".execute][" + "SUCESS" + "]"); } catch
	 * (Exception e) { response.setMessage("[" + System.currentTimeMillis() +
	 * "][" + this.getClass().getName() + ".execute][" + "ERROR 10" + "]");
	 * throw new DaoException("erro ao executar CallableStatement.", e); }
	 * finally { try { this.call.close(); } catch (SQLException e) {
	 * response.setMessage("[" + System.currentTimeMillis() + "][" +
	 * this.getClass().getName() + ".execute][" + "ERROR 100" + "]"); throw new
	 * DaoException("erro ao fechar CallableStatement.", e); } try {
	 * Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace();
	 * } } }
	 */

	@Override
	public void execute(Object object, int procCode) throws DaoException,
			IOException {

		if ("br.com.cafebinario.iso8583.pojo.ExchangeMcPresentmentExt"
				.equals(object.getClass().getName())) {
			InsertMcPresentmentExt insertMcPresentmentExt = new InsertMcPresentmentExt();
			ExchangeMcPresentmentExt firstPresentation = (ExchangeMcPresentmentExt) object;
			ExchangeMasterTable masterTable = new ExchangeMasterTable();
			masterTable.setAcqrRefNumber(firstPresentation.getAcqrRefNumber());
			masterTable.setCardNumber(firstPresentation.getCardNumber());
			masterTable.setFeeRow(firstPresentation.getFeeRow());
			masterTable.setInstallment(firstPresentation.getInstallment());
			masterTable.setMessageNumber(firstPresentation.getMessageNumber());
			masterTable.setProcCode(firstPresentation.getProcCode());
			masterTable.setReasonCode(firstPresentation.getReasonCode());
			masterTable.setTransAmount(firstPresentation.getTransAmount());
			masterTable.setTransCode(firstPresentation.getTransCode());
			masterTable.setTransCurrency(firstPresentation.getTransCurrency());
			masterTable.setUsageCode(firstPresentation.getUsageCode());

			super.execute(masterTable, procCode);
			insertMcPresentmentExt.execute(object, procCode);

			/*
			 * if (Iso8583LoaderMessageInfo.loaderSGDB) { if (procCode == 200) {
			 * this.execute(masterTable);
			 * insertMcPresentmentExt.execute(firstPresentation); } else if
			 * (procCode == 205) this.execute(masterTable); else if (procCode ==
			 * 282) this.execute(masterTable); }
			 */
		} /*
		 * else { try { InsertMcFeeCollectExt insertFee = new
		 * InsertMcFeeCollectExt(conn); ExchangeMcFeeCollectionExt fee =
		 * (ExchangeMcFeeCollectionExt) object; ExchangeMasterTable masterTable
		 * = new ExchangeMasterTable();
		 * 
		 * masterTable.setAcqrRefNumber(fee .getAcqrRefNumber());
		 * masterTable.setCardNumber(fee.getCardNumber());
		 * masterTable.setFeeRow(fee.getFeeRow());
		 * masterTable.setInstallment(fee.getInstallment());
		 * masterTable.setMessageNumber(fee .getMessageNumber());
		 * masterTable.setProcCode(fee.getProcCode());
		 * masterTable.setReasonCode(fee.getReasonCode());
		 * masterTable.setTransAmount(fee.getTransAmount());
		 * masterTable.setTransCode(fee.getTransCode());
		 * masterTable.setTransCurrency(fee .getTransCurrency());
		 * masterTable.setUsageCode(fee.getUsageCode());
		 * 
		 * super.execute(masterTable, procCode);
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); throw new
		 * DaoException(this.getClass().getName() + ".execute (Object " + object
		 * + ", int " + procCode + ")", e); } }
		 */
	}
}
