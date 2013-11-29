package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ControlFile;
import br.com.cafebinario.iso8583.pojo.ExchangeMcRetRequest;
import br.com.cafebinario.iso8583.pojo.ProcessedFile;

public class InsertControlFile extends DaoBase {
	private InsertProcessedFile processedFile = null;

	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	/*
	 * public void execute(ControlFile controlFile) throws DaoException {
	 * 
	 * try { int position = 1; this.call.setString(position++,
	 * Iso8583LoaderMessageInfo.FILE_ID); this.call.setInt(position++,
	 * controlFile.getTransCode()); this.call.setInt(position++,
	 * controlFile.getUsageCode()); this.call.setInt(position++,
	 * controlFile.getFileAmount()); this.call.setInt(position++,
	 * controlFile.getFileCounts()); this.call.setInt(position++,
	 * controlFile.getMessageNumber());
	 * 
	 * response = new ResponseDao();
	 * response.setSucess(this.call.executeUpdate() > 0 ? true : false);
	 * response.setRowsAffects(this.call.getUpdateCount());
	 * response.setMessage("[" + System.currentTimeMillis() + "][" +
	 * this.getClass().getName() + ".execute][" + "SUCESS" + "]");
	 * 
	 * } catch (Exception e) { response.setMessage("[" +
	 * System.currentTimeMillis() + "][" + this.getClass().getName() +
	 * ".execute][" + "ERROR 10" + "]"); throw new
	 * DaoException("erro ao executar CallableStatement.", e); } finally { try {
	 * this.call.close(); } catch (SQLException e) { response.setMessage("[" +
	 * System.currentTimeMillis() + "][" + this.getClass().getName() +
	 * ".execute][" + "ERROR 100" + "]"); throw new
	 * DaoException("erro ao fechar CallableStatement.", e); } } }
	 */

	@Override
	public void execute(Object object, int procCode) throws DaoException,
			IOException {

		if (procCode == 697) {
			ProcessedFile pf = new ProcessedFile();
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
			pf.setProcDate(formatDate.format(new Date(System
					.currentTimeMillis())));
			pf.setProcTime(formatTime.format(new Date(System
					.currentTimeMillis())));
			processedFile = new InsertProcessedFile();
			pf.setProcessFileId(((ControlFile) object).getProcessFileId());

			processedFile.execute(pf, procCode);
			super.execute(object, procCode);
			/*
			 * if (Iso8583LoaderMessageInfo.loaderSGDB) { this.call = conn
			 * .prepareCall
			 * ("{CALL PKG_EXCHANGE.PRC_CONTROL_FILES(?,?,?,?,?,?)}");
			 * this.execute((ControlFile) object); }
			 */
		} else if (procCode == 696) {
			// Addendum financeiro [novo]
			super.execute(object, procCode);
		} else if (procCode == 695) {
			super.execute(object, procCode);
			/*
			 * if (Iso8583LoaderMessageInfo.loaderSGDB) { this.call = conn
			 * .prepareCall
			 * ("{CALL PKG_EXCHANGE.PRC_CONTROL_FILES_UPDATE(?,?,?,?,?,?)}");
			 * this.execute((ControlFile) object); }
			 */
		} else if (procCode == 685 || procCode == 688) {
			super.execute(object, procCode);
			/*
			 * if (Iso8583LoaderMessageInfo.loaderSGDB) { this.call =
			 * conn//REVER CHAMADA PROCEDURE .prepareCall(
			 * "{CALL PKG_EXCHANGE.PRC_EXCHANGE_MC_ADM(?,?,?,?,?,?,?,?,?,?,?)}"
			 * ); this.execute((ControlFile) object); }
			 */
		} else if (procCode == 603) {
			super.execute(object, procCode);
			/*
			 * if (Iso8583LoaderMessageInfo.loaderSGDB) { this.call = conn
			 * .prepareCall(
			 * "{CALL PKG_EXCHANGE.PRC_MC_RET_REQUEST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
			 * ); this.execute((ExchangeMcRetRequest) object); }
			 */

		}
	}

	/*
	 * public void execute(ExchangeMcRetRequest exchangeMcRetRequest) throws
	 * DaoException {
	 * 
	 * try { int position = 1; this.call.setLong(position++,
	 * exchangeMcRetRequest.getTransDestInstId()); this.call.setLong(position++,
	 * exchangeMcRetRequest.getTransOriInstId()); this.call.setLong(position++,
	 * exchangeMcRetRequest.getMcc()); this.call.setString(position++,
	 * exchangeMcRetRequest.getCardAceptorName());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getCardAceptorZipCode());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getCardAceptorReg());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getCardAceptor_country());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getGcms_productIdent());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getMessageReversalInd());
	 * this.call.setLong(position++, exchangeMcRetRequest.getOrigProcDate());
	 * this.call.setLong(position++, exchangeMcRetRequest.getCurrencyCode());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getCurrencyExponent());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getBusinessActivity());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getSettlementData());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getSettlementIndicator());
	 * this.call.setDouble(position++,
	 * exchangeMcRetRequest.getReconciliationAmount());
	 * this.call.setLong(position++,
	 * exchangeMcRetRequest.getReconciliationRateConv());
	 * this.call.setDouble(position++,
	 * exchangeMcRetRequest.getOriginalAmountCurrency());
	 * this.call.setDouble(position++,
	 * exchangeMcRetRequest.getOriginalAmount_trans());
	 * this.call.setLong(position++,
	 * exchangeMcRetRequest.getOriginalReconCurrency());
	 * this.call.setDouble(position++,
	 * exchangeMcRetRequest.getOriginalAmountRecon());
	 * this.call.setLong(position++,
	 * exchangeMcRetRequest.getOri_message_format());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getTransLifeCiclyeId());
	 * this.call.setLong(position++,
	 * exchangeMcRetRequest.getMastercom_number());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getMastercomRetResp());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getMastercomRetResp());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getMastercomChbkDoc_sup());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getExclusionIndicator());
	 * this.call.setString(position++, exchangeMcRetRequest.getReturnData());
	 * this.call.setString(position++,
	 * exchangeMcRetRequest.getResubmissionData());
	 * 
	 * response = new ResponseDao();
	 * response.setSucess(this.call.executeUpdate() > 0 ? true : false);
	 * response.setRowsAffects(this.call.getUpdateCount());
	 * response.setMessage("[" + System.currentTimeMillis() + "][" +
	 * this.getClass().getName() + ".execute][" + "SUCESS" + "]"); } catch
	 * (Exception e) { response.setMessage("[" + System.currentTimeMillis() +
	 * "][" + this.getClass().getName() + ".execute][" + "ERROR 10" + "]");
	 * throw new DaoException("erro ao executar CallableStatement.", e); }
	 * finally { try { this.call.close(); } catch (SQLException e) {
	 * response.setMessage("[" + System.currentTimeMillis() + "][" +
	 * this.getClass().getName() + ".execute][" + "ERROR 100" + "]"); throw new
	 * DaoException("erro ao fechar CallableStatement.", e); } } }
	 */
}
