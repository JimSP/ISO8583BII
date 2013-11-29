package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.anotation.Destination;

public class ExchangeMcFeeCollectionExt extends ExchangeMasterTable implements Serializable {

	private static final long serialVersionUID = 3299840067060299596L;

	@Destination(name="V_TRANS_DEST_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_DESTINATION_INSTITUTION_ID_CODE")
	private int transDestInstId;

	@Destination(name="V_TRANS_ORI_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_ORIGINATOR_INSTITUTION_ID_CODE")
	private int transOriInstId;
	
	@Destination(name="V_ACQR_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="ACQUIRING_INSTITUTION_ID_CODE")
	private int acqrInstId;

	@Destination(name="V_FORWARDING_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="FORWARDING_INSTITUTION_ID_CODE")
	private int forwardingInstId;

	@Destination(name="V_CARD_SEQUENCE_NUMBER", posicao = 0, type = "NUMBER", nativo = false, ipmName="CARD_SEQUENCE_NUMBER")
	private int cardSequenceNumber;

	@Destination(name="V_CARD_ISSUER_REFERENCE_DATA", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="CARD_ISSUER_REFERENCE_DATA")
	private String cardIssuerReferenceData;
	
	@Destination(name="V_CURRENCY_CODE_TRANS", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_TRANSACTION")
	private int currencyCodeTrans;
	
	@Destination(name="V_CURRENCY_CODE_RECONCILIATION", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_RECONCILIATION")
	private int currencyCodeReconciliation;
	
	@Destination(name="V_TRANS_LIFE_CYCLE_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_LIFE_CYCLE_ID")
	private long transLifeCiclyeId;
	
	@Destination(name="V_OPERATION", posicao = 0, type = "NUMBER", nativo = false, ipmName="PROCESSING_CODE")
	private int operation;
	
	@Destination(name="V_RECONCILIATION_AMOUNT", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="AMOUNT_RECONCILIATION")
	private String reconciliationAmount;
	
	@Destination(name="V_RECONCILIATION_RATE_CONV", posicao = 0, type = "NUMBER", nativo = false, ipmName="CONVERSION_RATE_RECONCILIATION")
	private double reconciliationRateConv;
	
	@Destination(name="V_RECONCILIATION_RATE_CONV", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODES/AMOUNTS/ORIGINAL")
	private int originalAmountCurrency;
	
	@Destination(name="V_ORIGINAL_AMOUNT_TRANS", posicao = 0, type = "NUMBER", nativo = false, ipmName="AMOUNTS_ORIGINAL")
	private double originalAmountTrans;
	
	@Destination(name="V_ORIGINAL_RECON_CURRENCY", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODES/AMOUNTS/ORIGINAL")
	private int originalReconCurrency;
	
	@Destination(name="V_ORIGINAL_AMOUNT_TRANS", posicao = 0, type = "NUMBER", nativo = false, ipmName="AMOUNTS_ORIGINAL")
	private double originalAmountRecon;
	
	@Destination(name="V_RECEIVING_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="RECEIVING_INSTITUTION_ID_CODE")
	private long receivingInstId;
	
	@Destination(name="V_DATE_ACTION", posicao = 0, type = "NUMBER", nativo = false, ipmName="DATE_ACTION")
	private Integer dateAction;
	
	@Destination(name="V_DATA_RECORD", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="DATA_RECORD")
	private String dataRecord;
	
	@Destination(name="V_GCMS_PRODUCT_IDENT", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="GCMS_PRODUCT_IDENTIFIER")
	private String gcmsProductIdent; 
	
	@Destination(name="V_MESSAGE_REVERSAL_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="MESSAGE_REVERSAL_INDICATOR")
	private String messageReversalInd;     

	@Destination(name="V_MESSAGE_REVERSAL_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="MESSAGE_REVERSAL_INDICATOR")
	private Long origProcDate;
	
	@Destination(name="V_FEE_COLLECTION_CONTROL_NUMBER", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="FEE_COLLECTION_CONTROL_NUMBER")
	private String feeCollectionControNum;

	@Destination(name="V_CURRENCY_EXPOENTS", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="CURRENCY_CODES/AMOUNTS/ORIGINAL")
	private String currencyExponents;
	
	@Destination(name="V_CURRENCY_CODE_ORI_AMOUNT", posicao = 0, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODES/AMOUNTS/ORIGINAL")
	private Long currencyCodeOriAmount;
	
	@Destination(name="V_BUSINESS_ACTIVITY", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="BUSINESS_ACTIVITY")
	private String businessActivity;
	
	@Destination(name="V_SETTLEMENT_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="SETTLEMENT_INDICATOR")
	private String settlementData;
	
	@Destination(name="V_SETTLEMENT_INDICATOR", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="SETTLEMENT_INDICATOR")
	private String settlementIndicator;
	
	@Destination(name="V_ORIGINATING_MESSAGE_FORMAT", posicao = 0, type = "NUMBER", nativo = false, ipmName="ORIGINATING_MESSAGE_FORMAT")
	private Long oriMessageFormat;
	
	@Destination(name="V_FULFILLMENT_DOCUMENT_CODE", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="FULFILLMENT_DOCUMENT_CODE")
	private String fulfillmentDocCode;
	
	@Destination(name="V_MASTERCOM_CONTROL_NUMBER", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="MASTERCOM_CONTROL_NUMBER")
	private String mastercomNumber;
	
	@Destination(name="V_ORI_REASON_RET_REQUEST", posicao = 0, type = "NUMBER", nativo = false, ipmName="ORIGINAL_RETRIEVAL_REASON_FOR_REQUEST")
	private Long oriReasonRetRequest;

	public Integer getTransDestInstId() {
		return transDestInstId;
	}

	public void setTransDestInstId(Integer transDestInstId) {
		this.transDestInstId = transDestInstId;
	}

	public Integer getTransOriInstId() {
		return transOriInstId;
	}

	public void setTransOriInstId(Integer transOriInstId) {
		this.transOriInstId = transOriInstId;
	}

	public Integer getAcqrInstId() {
		return acqrInstId;
	}

	public void setAcqrInstId(Integer acqrInstId) {
		this.acqrInstId = acqrInstId;
	}

	public Integer getForwardingInstId() {
		return forwardingInstId;
	}

	public void setForwardingInstId(Integer forwardingInstId) {
		this.forwardingInstId = forwardingInstId;
	}

	public Integer getCardSequenceNumber() {
		return cardSequenceNumber;
	}

	public void setCardSequenceNumber(Integer cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
	}

	public String getCardIssuerReferenceData() {
		return cardIssuerReferenceData;
	}

	public void setCardIssuerReferenceData(String cardIssuerReferenceData) {
		this.cardIssuerReferenceData = cardIssuerReferenceData;
	}

	public Integer getCurrencyCodeTrans() {
		return currencyCodeTrans;
	}

	public void setCurrencyCodeTrans(Integer currencyCodeTrans) {
		this.currencyCodeTrans = currencyCodeTrans;
	}

	public Integer getCurrencyCodeReconciliation() {
		return currencyCodeReconciliation;
	}

	public void setCurrencyCodeReconciliation(Integer currencyCodeReconciliation) {
		this.currencyCodeReconciliation = currencyCodeReconciliation;
	}

	public Long getTransLifeCiclyeId() {
		return transLifeCiclyeId;
	}

	public void setTransLifeCiclyeId(Long transLifeCiclyeId) {
		this.transLifeCiclyeId = transLifeCiclyeId;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public String getReconciliationAmount() {
		return reconciliationAmount;
	}

	public void setReconciliationAmount(String reconciliationAmount) {
		this.reconciliationAmount = reconciliationAmount;
	}

	public Double getReconciliationRateConv() {
		return reconciliationRateConv;
	}

	public void setReconciliationRateConv(Double reconciliationRateConv) {
		this.reconciliationRateConv = reconciliationRateConv;
	}

	public int getOriginalAmountCurrency() {
		return originalAmountCurrency;
	}

	public void setOriginalAmountCurrency(int originalAmountCurrency) {
		this.originalAmountCurrency = originalAmountCurrency;
	}

	public Double getOriginalAmountTrans() {
		return originalAmountTrans;
	}

	public void setOriginalAmountTrans(Double originalAmountTrans) {
		this.originalAmountTrans = originalAmountTrans;
	}

	public int getOriginalReconCurrency() {
		return originalReconCurrency;
	}

	public void setOriginalReconCurrency(int originalReconCurrency) {
		this.originalReconCurrency = originalReconCurrency;
	}

	public double getOriginalAmountRecon() {
		return originalAmountRecon;
	}

	public void setOriginalAmountRecon(Double originalAmountRecon) {
		this.originalAmountRecon = originalAmountRecon;
	}

	public Long getReceivingInstId() {
		return receivingInstId;
	}

	public void setReceivingInstId(Long receivingInstId) {
		this.receivingInstId = receivingInstId;
	}

	public Integer getDateAction() {
		return dateAction;
	}

	public void setDateAction(Integer dateAction) {
		this.dateAction = dateAction;
	}

	public String getDataRecord() {
		return dataRecord;
	}

	public void setDataRecord(String dataRecord) {
		this.dataRecord = dataRecord;
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

	public Long getOrigProcDate() {
		return origProcDate;
	}

	public void setOrigProcDate(Long origProcDate) {
		this.origProcDate = origProcDate;
	}

	public String getFeeCollectionControNum() {
		return feeCollectionControNum;
	}

	public void setFeeCollectionControNum(String feeCollectionControNum) {
		this.feeCollectionControNum = feeCollectionControNum;
	}

	public String getCurrencyExponents() {
		return currencyExponents;
	}

	public void setCurrencyExponents(String currencyExponents) {
		this.currencyExponents = currencyExponents;
	}

	public Long getCurrencyCodeOriAmount() {
		return currencyCodeOriAmount;
	}

	public void setCurrencyCodeOriAmount(Long currencyCodeOriAmount) {
		this.currencyCodeOriAmount = currencyCodeOriAmount;
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

	public long getOriMessageFormat() {
		return oriMessageFormat;
	}

	public void setOriMessageFormat(Long oriMessageFormat) {
		this.oriMessageFormat = oriMessageFormat;
	}

	public String getFulfillmentDocCode() {
		return fulfillmentDocCode;
	}

	public void setFulfillmentDocCode(String fulfillmentDocCode) {
		this.fulfillmentDocCode = fulfillmentDocCode;
	}

	public String getMastercomNumber() {
		return mastercomNumber;
	}

	public void setMastercomNumber(String mastercomNumber) {
		this.mastercomNumber = mastercomNumber;
	}

	public long getOriReasonRetRequest() {
		return oriReasonRetRequest;
	}

	public void setOriReasonRetRequest(Long oriReasonRetRequest) {
		this.oriReasonRetRequest = oriReasonRetRequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FC");
		builder.append(FormatUtil.LPAD(String.valueOf(transDestInstId), '0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(transOriInstId), '0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(acqrInstId), '0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(forwardingInstId), '0', 11));
		builder.append(FormatUtil.LPAD(String.valueOf(cardSequenceNumber), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(cardIssuerReferenceData == null ? "" : cardIssuerReferenceData), '0', 10));
		builder.append(FormatUtil.LPAD(String.valueOf(currencyCodeTrans), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(currencyCodeReconciliation), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(transLifeCiclyeId), '0', 16));
		builder.append(FormatUtil.LPAD(String.valueOf(operation == 0 ? "D" : "C"), '0', 1));
		builder.append(FormatUtil.LPAD(String.valueOf(reconciliationAmount == null ? "0" : reconciliationAmount), '0', 18));
		builder.append(FormatUtil.LPAD(String.valueOf(reconciliationRateConv).replace(".", ""), '0', 12));
		builder.append(FormatUtil.LPAD(String.valueOf(originalAmountCurrency), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(originalAmountTrans*100).replace(".", ""),'0',12));
		builder.append(FormatUtil.LPAD(String.valueOf(originalReconCurrency), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(originalAmountRecon).replace(".", ""),'0',12));
		builder.append(FormatUtil.LPAD(String.valueOf(receivingInstId), '0', 9));
		builder.append(FormatUtil.LPAD(String.valueOf(dateAction), '0', 6));
		builder.append(FormatUtil.RPAD(String.valueOf(dataRecord  == null ? "" : dataRecord), ' ', 100));
		builder.append(FormatUtil.LPAD(gcmsProductIdent != null ? gcmsProductIdent : "0", '0', 3));
		builder.append(FormatUtil.LPAD(messageReversalInd == null ? "" : messageReversalInd, '0', 1));
		builder.append(FormatUtil.LPAD(String.valueOf(origProcDate == null ? "0" : origProcDate), '0', 6));
		builder.append(FormatUtil.LPAD(String.valueOf(feeCollectionControNum == null ? "" : feeCollectionControNum), '0', 20));
		builder.append(FormatUtil.LPAD(currencyExponents == null ? "" : currencyExponents, '0', 60));
		builder.append(FormatUtil.LPAD(String.valueOf(currencyCodeOriAmount == null ? "" : currencyCodeOriAmount), '0', 6));
		builder.append(FormatUtil.RPAD(businessActivity == null ? "" : businessActivity, ' ', 29));
		builder.append(FormatUtil.RPAD(settlementData == null ? "" : settlementData, ' ', 67));
		builder.append(FormatUtil.RPAD(settlementIndicator == null ? "" : settlementIndicator, ' ', 30));
		builder.append(FormatUtil.LPAD(String.valueOf(oriMessageFormat == null ? "0" : oriMessageFormat), '0', 1));
		builder.append(FormatUtil.RPAD(fulfillmentDocCode == null ? "" : fulfillmentDocCode, ' ', 1));
		builder.append(FormatUtil.RPAD(mastercomNumber == null ? "" : mastercomNumber, ' ', 7));
		builder.append(FormatUtil.LPAD(String.valueOf(oriReasonRetRequest == null ? "" : oriReasonRetRequest), '0', 4));
		return builder.toString();
	}
}
