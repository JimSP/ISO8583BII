package br.com.cafebinario.iso8583.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.pojo.ExchangeMcAdm;

public class InsertMcAdm extends DaoBase {
	private static final String SQL_SOURCE = "{CALL PKG_EXCHANGE.PRC_MC_ADM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	private CallableStatement call;
	private ResponseDao response = null;

	public ResponseDao getResponse() {
		return response;
	}

	public InsertMcAdm(Connection conn) throws SQLException {
		this.call = conn.prepareCall(SQL_SOURCE);
	}

	public void execute(ExchangeMcAdm exchangeMCAdm) throws DaoException {

		try {
			int position = 1;
			this.call.setString(position++, exchangeMCAdm.getMcc());
			this.call.setLong(position++, exchangeMCAdm.getTransDestInstId());
			this.call.setLong(position++, exchangeMCAdm.getTransRecIntId());
			this.call.setString(position++, exchangeMCAdm.getCurrencyCode());
			this.call.setString(position++,
					exchangeMCAdm.getSettlementIndicator());
			this.call.setLong(position++, exchangeMCAdm.getTransCurrency());
			this.call.setLong(position++,
					exchangeMCAdm.getCurrencyCodeReconciliation());
			this.call.setLong(position++, exchangeMCAdm.getReconciledFile());
			this.call.setLong(position++, exchangeMCAdm.getFileCounts());
			this.call.setString(position++, exchangeMCAdm.getRecBusAct());
			this.call.setString(position++, exchangeMCAdm.getRecCardProg());
			this.call.setString(position++,
					exchangeMCAdm.getRecTransFuncGroup());
			this.call.setLong(position++, exchangeMCAdm.getRecAcqBin());
			this.call.setLong(position++, exchangeMCAdm.getRecAccountRange());
			this.call.setLong(position++, exchangeMCAdm.getRecTransFunc());
			this.call.setLong(position++, exchangeMCAdm.getRecProcCode());
			this.call.setString(position++, exchangeMCAdm.getRecMemberInd());
			this.call.setString(position++,
					exchangeMCAdm.getOriRevTotalIndicator());
			this.call
					.setString(position++, exchangeMCAdm.getTransAmountDebit());
			this.call.setString(position++,
					exchangeMCAdm.getTransAmountCredit());

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
			this.execute((ExchangeMcAdm) object);
	}
}
