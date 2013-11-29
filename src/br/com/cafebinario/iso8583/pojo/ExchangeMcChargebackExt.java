package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

public class ExchangeMcChargebackExt extends ExchangeMasterTable implements Serializable {

	private static final long serialVersionUID = -1212842152079764035L;

	private String installment;
	private int transDestInstId;
	private int transOriInstId;
	private int mcc;
	private String cardAceptorName;
	private String cardAceptorZipCode;
	private String cardAceptorReg;
	private String cardAceptorCountry;
	private String gcmsProductIdent;
	private String messageReversalInd;
	private int origProcDate;
	private int currencyCode;
	private String currencyExponent;
	private String businessActivity;
	private String settlementData;
	private String settlementIndicator;
	private double reconciliationAmount;
	private double reconciliationRateConv;
	private int originalAmountCurrency;
	private double originalAmountTrans;
	private int originalReconCurrency;
	private double originalAmountRecon;
	private int oriMessageFormat;
	private String transLifeCiclyeId;
	private String mastercomNumber;
	private String mastercomRetResp;
	private String mastercomChbkDocSup;
	private String exclusionIndicator;
	private String returnData;
	private String resubmissionData;

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public long getTransDestInstId() {
		return transDestInstId;
	}

	public void setTransDestInstId(int transDestInstId) {
		this.transDestInstId = transDestInstId;
	}

	public long getTransOriInstId() {
		return transOriInstId;
	}

	public void setTransOriInstId(int transOriInstId) {
		this.transOriInstId = transOriInstId;
	}

	public long getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public String getCardAceptorName() {
		return cardAceptorName;
	}

	public void setCardAceptorName(String cardAceptorName) {
		this.cardAceptorName = cardAceptorName;
	}

	public String getCardAceptorZipCode() {
		return cardAceptorZipCode;
	}

	public void setCardAceptorZipCode(String cardAceptorZipCode) {
		this.cardAceptorZipCode = cardAceptorZipCode;
	}

	public String getCardAceptorReg() {
		return cardAceptorReg;
	}

	public void setCardAceptorReg(String cardAceptorReg) {
		this.cardAceptorReg = cardAceptorReg;
	}

	public String getCardAceptorCountry() {
		return cardAceptorCountry;
	}

	public void setCardAceptorCountry(String cardAceptorCountry) {
		this.cardAceptorCountry = cardAceptorCountry;
	}

	public String getGcmsProductIdent() {
		return gcmsProductIdent;
	}

	public void setGcmsProductIdent(String gcmsProductIdent) {
		this.gcmsProductIdent = gcmsProductIdent;
	}

	public String getMessageReversalInd() {
		return messageReversalInd;
	}

	public void setMessageReversalInd(String messageReversalInd) {
		this.messageReversalInd = messageReversalInd;
	}

	public long getOrigProcDate() {
		return origProcDate;
	}

	public void setOrigProcDate(int origProcDate) {
		this.origProcDate = origProcDate;
	}

	public long getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(int currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyExponent() {
		return currencyExponent;
	}

	public void setCurrencyExponent(String currencyExponent) {
		this.currencyExponent = currencyExponent;
	}

	public String getBusinessActivity() {
		return businessActivity;
	}

	public void setBusinessActivity(String businessActivity) {
		this.businessActivity = businessActivity;
	}

	public String getSettlementData() {
		return settlementData;
	}

	public void setSettlementData(String settlementData) {
		this.settlementData = settlementData;
	}

	public String getSettlementIndicator() {
		return settlementIndicator;
	}

	public void setSettlementIndicator(String settlementIndicator) {
		this.settlementIndicator = settlementIndicator;
	}

	public double getReconciliationAmount() {
		return reconciliationAmount;
	}

	public void setReconciliationAmount(double reconciliationAmount) {
		this.reconciliationAmount = reconciliationAmount;
	}

	public double getReconciliationRateConv() {
		return reconciliationRateConv;
	}

	public void setReconciliationRateConv(double reconciliationRateConv) {
		this.reconciliationRateConv = reconciliationRateConv;
	}

	public long getOriginalAmountCurrency() {
		return originalAmountCurrency;
	}

	public void setOriginalAmountCurrency(int originalAmountCurrency) {
		this.originalAmountCurrency = originalAmountCurrency;
	}

	public double getOriginalAmountTrans() {
		return originalAmountTrans;
	}

	public void setOriginalAmountTrans(double originalAmountTrans) {
		this.originalAmountTrans = originalAmountTrans;
	}

	public long getOriginalReconCurrency() {
		return originalReconCurrency;
	}

	public void setOriginalReconCurrency(int originalReconCurrency) {
		this.originalReconCurrency = originalReconCurrency;
	}

	public double getOriginalAmountRecon() {
		return originalAmountRecon;
	}

	public void setOriginalAmountRecon(double originalAmountRecon) {
		this.originalAmountRecon = originalAmountRecon;
	}

	public long getOriMessageFormat() {
		return oriMessageFormat;
	}

	public void setOriMessageFormat(int oriMessageFormat) {
		this.oriMessageFormat = oriMessageFormat;
	}

	public String getTransLifeCiclyeId() {
		return transLifeCiclyeId;
	}

	public void setTransLifeCiclyeId(String transLifeCiclyeId) {
		this.transLifeCiclyeId = transLifeCiclyeId;
	}

	public String getMastercomNumber() {
		return mastercomNumber;
	}

	public void setMastercomNumber(String mastercomNumber) {
		this.mastercomNumber = mastercomNumber;
	}

	public String getMastercomRetResp() {
		return mastercomRetResp;
	}

	public void setMastercomRetResp(String mastercomRetResp) {
		this.mastercomRetResp = mastercomRetResp;
	}

	public String getMastercomChbkDocSup() {
		return mastercomChbkDocSup;
	}

	public void setMastercomChbkDocSup(String mastercomChbkDocSup) {
		this.mastercomChbkDocSup = mastercomChbkDocSup;
	}

	public String getExclusionIndicator() {
		return exclusionIndicator;
	}

	public void setExclusionIndicator(String exclusionIndicator) {
		this.exclusionIndicator = exclusionIndicator;
	}

	public String getReturnData() {
		return returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	public String getResubmissionData() {
		return resubmissionData;
	}

	public void setResubmissionData(String resubmissionData) {
		this.resubmissionData = resubmissionData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CB");
		builder.append(";");
		builder.append(installment);
		builder.append(";");
		builder.append(transDestInstId);
		builder.append(";");
		builder.append(transOriInstId);
		builder.append(";");
		builder.append(mcc);
		builder.append(";");
		builder.append(cardAceptorName);
		builder.append(";");
		builder.append(cardAceptorZipCode);
		builder.append(";");
		builder.append(cardAceptorReg);
		builder.append(";");
		builder.append(cardAceptorCountry);
		builder.append(";");
		builder.append(gcmsProductIdent);
		builder.append(";");
		builder.append(messageReversalInd);
		builder.append(";");
		builder.append(origProcDate);
		builder.append(";");
		builder.append(currencyCode);
		builder.append(";");
		builder.append(currencyExponent);
		builder.append(";");
		builder.append(businessActivity);
		builder.append(";");
		builder.append(settlementData);
		builder.append(";");
		builder.append(settlementIndicator);
		builder.append(";");
		builder.append(reconciliationAmount);
		builder.append(";");
		builder.append(reconciliationRateConv);
		builder.append(";");
		builder.append(originalAmountCurrency);
		builder.append(";");
		builder.append(originalAmountTrans);
		builder.append(";");
		builder.append(originalReconCurrency);
		builder.append(";");
		builder.append(originalAmountRecon);
		builder.append(";");
		builder.append(oriMessageFormat);
		builder.append(";");
		builder.append(transLifeCiclyeId);
		builder.append(";");
		builder.append(mastercomNumber);
		builder.append(";");
		builder.append(mastercomRetResp);
		builder.append(";");
		builder.append(mastercomChbkDocSup);
		builder.append(";");
		builder.append(exclusionIndicator);
		builder.append(";");
		builder.append(returnData);
		builder.append(";");
		builder.append(resubmissionData);
		return builder.toString();
	}
}
