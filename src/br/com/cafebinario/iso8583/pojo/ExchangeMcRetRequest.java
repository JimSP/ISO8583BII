package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

public class ExchangeMcRetRequest extends PojoBase implements Serializable {
	
	private static final long serialVersionUID = 1291791357718780163L;

	private long transDestInstId;
	private long transOriInstId;
	private long mcc;
	private String cardAceptorName;
	private String cardAceptorZipCode;
	private String cardAceptorReg;
	private String cardAceptor_country;
	private String gcms_productIdent;
	private String messageReversalInd;
	private long origProcDate;
	private long currencyCode;
	private String currencyExponent;
	private String businessActivity;
	private String settlementData;
	private String settlementIndicator;
	private double reconciliationAmount;
	private long reconciliationRateConv;
	private double originalAmountCurrency;
	private double originalAmount_trans;
	private long originalReconCurrency;
	private double originalAmountRecon;
	private long ori_message_format;
	private String transLifeCiclyeId;
	private long mastercom_number;
	private String mastercomRetResp;
	private String mastercomChbkDoc_sup;
	private String exclusionIndicator;
	private String returnData;
	private String resubmissionData;
	
	public long getTransDestInstId() {
		return transDestInstId;
	}
	
	public void setTransDestInstId(long transDestInstId) {
		this.transDestInstId = transDestInstId;
	}
	
	public long getTransOriInstId() {
		return transOriInstId;
	}
	
	public void setTransOriInstId(long transOriInstId) {
		this.transOriInstId = transOriInstId;
	}
	
	public long getMcc() {
		return mcc;
	}
	
	public void setMcc(long mcc) {
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
	
	public String getCardAceptor_country() {
		return cardAceptor_country;
	}
	
	public void setCardAceptor_country(String cardAceptor_country) {
		this.cardAceptor_country = cardAceptor_country;
	}
	
	public String getGcms_productIdent() {
		return gcms_productIdent;
	}
	
	public void setGcms_productIdent(String gcms_productIdent) {
		this.gcms_productIdent = gcms_productIdent;
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
	
	public void setOrigProcDate(long origProcDate) {
		this.origProcDate = origProcDate;
	}
	
	public long getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(long currencyCode) {
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
	
	public long getReconciliationRateConv() {
		return reconciliationRateConv;
	}
	
	public void setReconciliationRateConv(long reconciliationRateConv) {
		this.reconciliationRateConv = reconciliationRateConv;
	}
	public double getOriginalAmountCurrency() {
		return originalAmountCurrency;
	}
	
	public void setOriginalAmountCurrency(double originalAmountCurrency) {
		this.originalAmountCurrency = originalAmountCurrency;
	}
	
	public double getOriginalAmount_trans() {
		return originalAmount_trans;
	}
	
	public void setOriginalAmount_trans(double originalAmount_trans) {
		this.originalAmount_trans = originalAmount_trans;
	}
	
	public long getOriginalReconCurrency() {
		return originalReconCurrency;
	}
	
	public void setOriginalReconCurrency(long originalReconCurrency) {
		this.originalReconCurrency = originalReconCurrency;
	}
	
	public double getOriginalAmountRecon() {
		return originalAmountRecon;
	}
	
	public void setOriginalAmountRecon(double originalAmountRecon) {
		this.originalAmountRecon = originalAmountRecon;
	}
	
	public long getOri_message_format() {
		return ori_message_format;
	}
	
	public void setOri_message_format(long ori_message_format) {
		this.ori_message_format = ori_message_format;
	}
	
	public String getTransLifeCiclyeId() {
		return transLifeCiclyeId;
	}
	
	public void setTransLifeCiclyeId(String transLifeCiclyeId) {
		this.transLifeCiclyeId = transLifeCiclyeId;
	}
	
	public long getMastercom_number() {
		return mastercom_number;
	}
	
	public void setMastercom_number(long mastercom_number) {
		this.mastercom_number = mastercom_number;
	}
	
	public String getMastercomRetResp() {
		return mastercomRetResp;
	}
	
	public void setMastercomRetResp(String mastercomRetResp) {
		this.mastercomRetResp = mastercomRetResp;
	}
	
	public String getMastercomChbkDoc_sup() {
		return mastercomChbkDoc_sup;
	}
	
	public void setMastercomChbkDoc_sup(String mastercomChbkDoc_sup) {
		this.mastercomChbkDoc_sup = mastercomChbkDoc_sup;
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
		builder.append("RR");
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
		builder.append(cardAceptor_country);
		builder.append(";");
		builder.append(gcms_productIdent);
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
		builder.append(originalAmount_trans);
		builder.append(";");
		builder.append(originalReconCurrency);
		builder.append(";");
		builder.append(originalAmountRecon);
		builder.append(";");
		builder.append(ori_message_format);
		builder.append(";");
		builder.append(transLifeCiclyeId);
		builder.append(";");
		builder.append(mastercom_number);
		builder.append(";");
		builder.append(mastercomRetResp);
		builder.append(";");
		builder.append(mastercomChbkDoc_sup);
		builder.append(";");
		builder.append(exclusionIndicator);
		builder.append(";");
		builder.append(returnData);
		builder.append(";");
		builder.append(resubmissionData);
		return builder.toString();
	}
}
