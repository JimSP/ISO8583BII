package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.anotation.Destination;

public class ExchangeMcAdm extends PojoBase implements Serializable{
	
	private static final long serialVersionUID = 7953031828894668928L;

	@Destination(name="V_MCC", posicao = 1, type = "NUMBER", nativo = false, ipmName="CARD_ACCEPTOR_BUSINESS_CODE_(MCC)")
	private String mcc;
	
	@Destination(name="V_TRANS_DEST_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_DESTINATION_INSTITUTION_ID_CODE")
	private long transDestInstId;

	@Destination(name="V_TRANS_DEST_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECEIVING_INSTITUTION_ID_CODE")
	private long transRecIntId;

	@Destination(name="V_CURRENCY_CODE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="CURRENCY_EXPONENTS")
	private String currencyCode;

	@Destination(name="V_SETTLEMENT_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="SETTLEMENT_INDICATOR")
	private String settlementIndicator;
	
	@Destination(name="V_CURRENCY_CODE_TRANSACTION", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_TRANSACTION")
	private long transCurrency;

	@Destination(name="V_CURRENCY_CODE_RECONCILIATION", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_RECONCILIATION")
	private long currencyCodeReconciliation;

	@Destination(name="V_RECONCILED_FILE", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED_FILE")
	private long reconciledFile;
	
	@Destination(name="V_MEMBER_ACTIVITY", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED/MEMBER_ACTIVITY")
	private long fileCounts;

	@Destination(name="V_BUSINESS_ACTIVITY", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="RECONCILED/BUSINESS_ACTIVITY")
	private String recBusAct;

	@Destination(name="V_SETTLEMENT_ACTIVITY", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="RECONCILED/SETTLEMENT_ACTIVITY")
	private String recSetAct;
	
	@Destination(name="V_CARD_PROGRAM_IDENTIFIER", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="RECONCILED/CARD_PROGRAM_IDENTIFIER")
	private String recCardProg;
	
	@Destination(name="V_TRANSACTION_FUNCTION_GROUP_CODE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="RECONCILED/TRANSACTION_FUNCTION_GROUP_CODE")
	private String recTransFuncGroup;
	
	@Destination(name="V_ACQUIRERS_BIN", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED/ACQUIRERS_BIN")
	private long recAcqBin;
	
	@Destination(name="V_ACCOUNT_RANGE", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED/ACCOUNT_RANGE")
	private long recAccountRange;
	
	@Destination(name="V_ACCOUNT_RANGE", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED/ACCOUNT_RANGE")
	private long recTransFunc;
	
	@Destination(name="V_PROCESSING_CODE", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECONCILED/PROCESSING_CODE")
	private long recProcCode;
	
	@Destination(name="V_MEMBER_RECONCILIATION_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="MEMBER_RECONCILIATION_INDICATOR")
	private String recMemberInd;
	
	@Destination(name="V_REVERSAL", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="ORIGINAL/REVERSAL/TOTALS_INDICATOR")
	private String oriRevTotalIndicator;
	
	@Destination(name="V_TRANSACTION_AMOUNT_DEBIT", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="DEBITS/TRANSACTION_AMOUNT_IN_TRANSACTION_CURRENCY")
	private String transAmountDebit;
	
	@Destination(name="V_TRANSACTION_AMOUNT_CREDIT", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="CREDITS/TRANSACTION_AMOUNT_IN_TRANSACTION_CURRENCY")
	private String transAmountCredit;

	public String getMcc() {
		return mcc;
	}
	
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	
	public long getTransDestInstId() {
		return transDestInstId;
	}
	
	public void setTransDestInstId(long transDestInstId) {
		this.transDestInstId = transDestInstId;
	}
	
	public long getTransRecIntId() {
		return transRecIntId;
	}
	
	public void setTransRecIntId(long transRecIntId) {
		this.transRecIntId = transRecIntId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public String getSettlementIndicator() {
		return settlementIndicator;
	}
	
	public void setSettlementIndicator(String settlementIndicator) {
		this.settlementIndicator = settlementIndicator;
	}
	
	public long getTransCurrency() {
		return transCurrency;
	}
	
	public void setTransCurrency(long transCurrency) {
		this.transCurrency = transCurrency;
	}
	
	public long getCurrencyCodeReconciliation() {
		return currencyCodeReconciliation;
	}
	
	public void setCurrencyCodeReconciliation(long currencyCodeReconciliation) {
		this.currencyCodeReconciliation = currencyCodeReconciliation;
	}
	
	public long getReconciledFile() {
		return reconciledFile;
	}
	
	public void setReconciledFile(long reconciledFile) {
		this.reconciledFile = reconciledFile;
	}
	public long getFileCounts() {
		return fileCounts;
	}
	
	public void setFileCounts(long fileCounts) {
		this.fileCounts = fileCounts;
	}
	
	public String getRecBusAct() {
		return recBusAct;
	}
	
	public void setRecBusAct(String recBusAct) {
		this.recBusAct = recBusAct;
	}
	
	public String getRecSetAct() {
		return recSetAct;
	}
	
	public void setRecSetAct(String recSetAct) {
		this.recSetAct = recSetAct;
	}
	
	public String getRecCardProg() {
		return recCardProg;
	}
	
	public void setRecCardProg(String recCardProg) {
		this.recCardProg = recCardProg;
	}
	
	public String getRecTransFuncGroup() {
		return recTransFuncGroup;
	}
	
	public void setRecTransFuncGroup(String recTransFuncGroup) {
		this.recTransFuncGroup = recTransFuncGroup;
	}
	
	public long getRecAcqBin() {
		return recAcqBin;
	}
	
	public void setRecAcqBin(long recAcqBin) {
		this.recAcqBin = recAcqBin;
	}
	
	public long getRecAccountRange() {
		return recAccountRange;
	}
	
	public void setRecAccountRange(long recAccountRange) {
		this.recAccountRange = recAccountRange;
	}
	public long getRecTransFunc() {
		return recTransFunc;
	}
	
	public void setRecTransFunc(long recTransFunc) {
		this.recTransFunc = recTransFunc;
	}
	
	public long getRecProcCode() {
		return recProcCode;
	}
	
	public void setRecProcCode(long recProcCode) {
		this.recProcCode = recProcCode;
	}
	
	public String getRecMemberInd() {
		return recMemberInd;
	}
	
	public void setRecMemberInd(String recMemberInd) {
		this.recMemberInd = recMemberInd;
	}
	
	public String getOriRevTotalIndicator() {
		return oriRevTotalIndicator;
	}
	
	public void setOriRevTotalIndicator(String oriRevTotalIndicator) {
		this.oriRevTotalIndicator = oriRevTotalIndicator;
	}
	
	public String getTransAmountDebit() {
		return transAmountDebit;
	}
	
	public void setTransAmountDebit(String transAmountDebit) {
		this.transAmountDebit = transAmountDebit;
	}
	
	public String getTransAmountCredit() {
		return transAmountCredit;
	}
	
	public void setTransAmountCredit(String transAmountCredit) {
		this.transAmountCredit = transAmountCredit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MA");
		builder.append(mcc);
		builder.append(FormatUtil.LPAD(String.valueOf(transDestInstId), '0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(transRecIntId), '0', 11));
		builder.append(FormatUtil.LPAD(currencyCode, '0', 3));
		builder.append(settlementIndicator);
		builder.append(transCurrency);
		builder.append(currencyCodeReconciliation);
		builder.append(reconciledFile);
		builder.append(fileCounts);
		builder.append(recBusAct);
		builder.append(recSetAct);
		builder.append(recCardProg);
		builder.append(recTransFuncGroup);
		builder.append(recAcqBin);
		builder.append(recAccountRange);
		builder.append(recTransFunc);
		builder.append(recProcCode);
		builder.append(recMemberInd);
		builder.append(oriRevTotalIndicator);
		builder.append(FormatUtil.LPAD(String.valueOf(transAmountDebit), '0', 18));
		builder.append(FormatUtil.LPAD(String.valueOf(transAmountCredit), '0', 18));
		return builder.toString();
	}
}
