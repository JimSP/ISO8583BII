package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.anotation.Destination;

public class ExchangeMcPresentmentExt /*extends ExchangeMasterTable*/ implements Serializable {

	private static final long serialVersionUID = 3168406777571130898L;
		
	@Destination(name="V_FILE_ID", posicao = 16, type = "NUMBER", nativo = false, ipmName="FILE_ID")
	private String controlFileId;
	
	@Destination(name="V_MESSAGE_NUMBER", posicao = 18, type = "NUMBER", nativo = false, ipmName="MESSAGE_NUMBER")
	private int messageNumber;
	
	@Destination(name="V_CARD_NUMBER", posicao = 5, type = "NUMBER", nativo = false, ipmName="PAN")
	private long cardNumber;
	
	@Destination(name="V_TRAN_CODE", posicao = 6, type = "NUMBER", nativo = false, ipmName="MTI")
	private int transCode;
	
	@Destination(name="V_PROC_CODE", posicao = 7, type = "VARCHAR2", nativo = false, ipmName="PROCESSING_CODE")
	private String procCode;
	
	@Destination(name="V_REASON_CODE", posicao = 8, type = "NUMBER", nativo = false, ipmName="MESSAGE_REASON_CODE")
	private int reasonCode;
	
	@Destination(name="V_USAGE_CODE", posicao = 9, type = "NUMBER", nativo = false, ipmName="FUNCTION_CODE")
	private int usageCode;
	
	@Destination(name="V_ACQR_REF_NUMBER", posicao = 10, type = "VARCHAR2", nativo = false, ipmName="ACQUIRER_REFERENCE_DATA")
	private String acqrRefNumber;
	
	@Destination(name="V_TRANS_CURRENCY", posicao = 11, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_TRANSACTION")
	private int transCurrency;
	
	@Destination(name="V_TRANS_AMOUNT", posicao = 12, type = "NUMBER", nativo = false, ipmName="AMOUNT_TRANSACTION")
	private double transAmount;
	
	@Destination(name="V_FEE_CURRENCY", posicao = 13, type = "VARCHAR2", nativo = false, ipmName="AMOUNTS/TRANSACTION_FEE")
	private String feeRow;
	
	@Destination(name="V_BUSINESS_ACTIVITY", posicao = 14, type = "VARCHAR2", nativo = false, ipmName="BUSINESS_ACTIVITY")
	private String businesActivy;
	
	@Destination(name="V_MESSAGE_REVERSAL_INDICATOR", posicao = 15, type = "VARCHAR2", nativo = false, ipmName="MESSAGE_REVERSAL_INDICATOR")
	private String messageReversalIndicator;
	
	public String getBusinesActivy() {
		return businesActivy;
	}

	public void setBusinesActivy(String businesActivy) {
		this.businesActivy = businesActivy;
	}

	public String getFeeRow() {
		return feeRow;
	}

	public void setFeeRow(String feeRow) {
		this.feeRow = feeRow;
	}

	@Destination(name="V_INSTALLMENT", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="INSTALLMENT_DATA")
	private String installment;
	
	@Destination(name="V_TRANS_DEST_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_DESTINATION_INSTITUTION_ID_CODE")
	private long transDestInstId;
	
	@Destination(name="V_TRANS_ORI_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_ORIGINATOR_INSTITUTION_ID_CODE")
	private long transOriInstId;
	
	@Destination(name="V_RECONCILIATION_AMOUNT", posicao = 0, type = "NUMBER", nativo = false, ipmName="AMOUNT_RECONCILIATION")
	private double reconciliationAmount;
	
	@Destination(name="V_RECONCILIATION_RATE_CONV", posicao = 0, type = "NUMBER", nativo = false, ipmName="CONVERSION_RATE_RECONCILIATION")
	private int reconciliationRateConv;
	
	@Destination(name="V_ORIGINAL_AMOUNT_CURRENCY", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="CURRENCY_CODES/AMOUNTS/ORIGINAL")
	private String originalAmountCurrency;
	
	@Destination(name="V_ORIGINAL_AMOUNT_TRANS", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="AMOUNTS_ORIGINAL")
	private String originalAmountTrans;
	
	@Destination(name="V_ORIGINAL_RECON_CURRENCY", posicao = 0, type = "NUMBER", nativo = false, ipmName="ORIGINAL_RECON_CURRENCY")
	private int originalReconCurrency;
	
	@Destination(name="V_ORIGINAL_AMOUNT_RECON", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="ORIGINAL_AMOUNT_RECON")
	private String originalAmountRecon;
	
	@Destination(name="V_LOCAL_DATE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="DATE_AND_TIME_LOCAL_TRANSACTION")
	private String localDate;
	
	@Destination(name="V_LOCAL_TIME", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="DATE_AND_TIME_LOCAL_TRANSACTION")
	private String localTime;
	
	@Destination(name="V_BUSINESS_ACTIVITY", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="BUSINESS_ACTIVITY")
	private String businessActivity;
	
	@Destination(name="V_RISK_APROVAL_CODE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="RISK_MANAGEMENT_APPROVAL_CODE")
	private int riskAprovalCode;
	
	@Destination(name="TRANS_LIFE_CICLYE_ID", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="TRANSACTION_LIFE_CYCLE_ID")
	private String transLifeCiclyeId;
	
	@Destination(name="POS_DATA_CODE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="POINT_OF_SERVICE_DATA_CODE")
	private String posDataCode;

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

	public double getReconciliationAmount() {
		return reconciliationAmount;
	}

	public void setReconciliationAmount(double reconciliationAmount) {
		this.reconciliationAmount = reconciliationAmount;
	}

	public long getReconciliationRateConv() {
		return reconciliationRateConv;
	}

	public void setReconciliationRateConv(int reconciliationRateConv) {
		this.reconciliationRateConv = reconciliationRateConv;
	}

	public String getOriginalAmountCurrency() {
		return originalAmountCurrency;
	}

	public void setOriginalAmountCurrency(String originalAmountCurrency) {
		this.originalAmountCurrency = originalAmountCurrency;
	}

	public String getOriginalAmountTrans() {
		return originalAmountTrans;
	}

	public void setOriginalAmountTrans(String originalAmountTrans) {
		this.originalAmountTrans = originalAmountTrans;
	}

	public long getOriginalReconCurrency() {
		return originalReconCurrency;
	}

	public void setOriginalReconCurrency(int originalReconCurrency) {
		this.originalReconCurrency = originalReconCurrency;
	}

	public String getOriginalAmountRecon() {
		return originalAmountRecon;
	}

	public void setOriginalAmountRecon(String originalAmountRecon) {
		this.originalAmountRecon = originalAmountRecon;
	}

	public String getLocalDate() {
		return localDate;
	}

	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}

	public String getLocalTime() {
		return localTime;
	}

	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public String getBusinessActivity() {
		return businessActivity;
	}

	public void setBusinessActivity(String businessActivity) {
		this.businessActivity = businessActivity;
	}

	public long getRiskAprovalCode() {
		return riskAprovalCode;
	}

	public void setRiskAprovalCode(int riskAprovalCode) {
		this.riskAprovalCode = riskAprovalCode;
	}

	public String getTransLifeCiclyeId() {
		return transLifeCiclyeId;
	}

	public void setTransLifeCiclyeId(String transLifeCiclyeId) {
		this.transLifeCiclyeId = transLifeCiclyeId;
	}

	public String getPosDataCode() {
		return posDataCode;
	}

	public void setPosDataCode(String posDataCode) {
		this.posDataCode = posDataCode;
	}

	public int getTransCode() {
		return transCode;
	}

	public void setTransCode(int transCode) {
		this.transCode = transCode;
	}

	public String getProcCode() {
		return procCode;
	}

	public void setProcCode(String procCode) {
		this.procCode = procCode;
	}

	public int getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}

	public int getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(int usageCode) {
		this.usageCode = usageCode;
	}

	public String getAcqrRefNumber() {
		return acqrRefNumber;
	}

	public void setAcqrRefNumber(String acqrRefNumber) {
		this.acqrRefNumber = acqrRefNumber;
	}

	public int getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(int transCurrency) {
		this.transCurrency = transCurrency;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public String getControlFileId() {
		return controlFileId;
	}

	public void setControlFileId(String controlFileId) {
		this.controlFileId = controlFileId;
	}

	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FP");
		builder.append(installment != null ? FormatUtil.LPAD(installment.substring(0, 2),'0',3) : "000");
		builder.append(installment != null ? FormatUtil.LPAD(installment.substring(2, 5),'0',3) : "000");
		builder.append(FormatUtil.LPAD(String.valueOf(transDestInstId),'0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(transOriInstId),'0', 11));
		builder.append(FormatUtil.LPAD(new BigDecimal(reconciliationAmount*100).toString().replace(".", ""),'0',18));
		builder.append(FormatUtil.LPAD(String.valueOf(reconciliationRateConv),'0',12));
		builder.append(FormatUtil.LPAD(String.valueOf(originalAmountCurrency == null ? "000" : originalAmountCurrency),'0',3).substring(0, 3));
		builder.append(FormatUtil.LPAD(originalAmountTrans == null ? "0" : originalAmountTrans.substring(0,12),'0',18));
		builder.append(FormatUtil.LPAD(String.valueOf(originalReconCurrency),'0',3).substring(0, 3));
		builder.append(FormatUtil.LPAD(originalAmountRecon,'0',12));
		builder.append(FormatUtil.LPAD(localDate,'0',8));
		builder.append(FormatUtil.LPAD(localTime,'0',6));
		builder.append(FormatUtil.RPAD(businesActivy,' ',29));
		builder.append(FormatUtil.LPAD(businesActivy.substring(3, 4),'0',1));
		builder.append(FormatUtil.LPAD(String.valueOf(riskAprovalCode),'0',11));
		builder.append(FormatUtil.RPAD(transLifeCiclyeId,'0',16));
		builder.append(FormatUtil.RPAD(posDataCode,' ',50));
		builder.append(messageReversalIndicator == null ? " " : messageReversalIndicator.substring(0, 1));
		return builder.toString();
	}

	public void setMessageReversalIndicator(String messageReversalIndicator) {
		this.messageReversalIndicator = messageReversalIndicator;
	}

	public String getMessageReversalIndicator() {
		return messageReversalIndicator;
	}
}
