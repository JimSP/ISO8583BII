package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.anotation.Destination;
import br.com.cafebinario.iso8583.anotation.DestinationTable;

@DestinationTable(name="ExchangeMasterTable")
public class ExchangeMasterTable extends PojoBase implements Serializable{

	private static final long serialVersionUID = -340747515480792172L;

	@Destination(name="V_BRAND_ID", posicao = 1, type = "NUMBER", nativo = true, ipmName="")
	private int brandId = 3;
	
	@Destination(name="V_PRODUCT_ID", posicao = 2, type = "NUMBER", nativo = true, ipmName="")
	private int productId = 3;
	
	@Destination(name="V_SOURCE", posicao = 3, type = "CHAR", nativo = true, ipmName="")
	private String source = "O";
	
	@Destination(name="V_INSTALLMENT", posicao = 4, type = "VARCHAR2", nativo = false, ipmName="INSTALLMENT_DATA")
	private String installment;
	
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
	
	@Destination(name="V_ACQR_REF_NUMBER", posicao = 10, type = "NUMBER", nativo = false, ipmName="ACQUIRER_REFERENCE_DATA")
	private String acqrRefNumber;
	
	@Destination(name="V_TRANS_CURRENCY", posicao = 11, type = "NUMBER", nativo = false, ipmName="CURRENCY_CODE_TRANSACTION")
	private int transCurrency;
	
	@Destination(name="V_TRANS_AMOUNT", posicao = 12, type = "NUMBER", nativo = false, ipmName="AMOUNT_TRANSACTION")
	private double transAmount;
	
	@Destination(name="V_FEE_CURRENCY", posicao = 13, type = "NUMBER", nativo = false, ipmName="AMOUNTS/TRANSACTION_FEE")
	private String feeRow;
	
	public String getFeeRow() {
		return feeRow;
	}

	public void setFeeRow(String feeRow) {
		this.feeRow = feeRow;
	}

	@Destination(name="V_PROCESS_FILE_ID", posicao = 16, type = "VARCHAR2", nativo = false, ipmName="FILE_ID")
	private String processFileId;
	
	public String getProcessFileId() {
		return processFileId;
	}

	public void setProcessFileId(String processFileId) {
		this.processFileId = processFileId;
	}

	@Destination(name="V_MESSAGE_NUMBER", posicao = 17, type = "NUMBER", nativo = false, ipmName="MESSAGE_NUMBER")
	private int messageNumber;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
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


	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("MT");
		builder.append(FormatUtil.LPAD(String.valueOf(brandId), '0', 2));
		builder.append(FormatUtil.LPAD(String.valueOf(productId), '0', 3));
		builder.append(source);
		builder.append(FormatUtil.RPAD(installment == null ? "" : installment ,' ', 9));
		builder.append(FormatUtil.LPAD(String.valueOf(cardNumber),'0', 19));
		builder.append(FormatUtil.LPAD(String.valueOf(transCode), '0', 4));
		builder.append(FormatUtil.LPAD(String.valueOf(procCode == null ? "0" : procCode), '0', 6));
		builder.append(FormatUtil.LPAD(String.valueOf(reasonCode), '0', 4));
		builder.append(FormatUtil.LPAD(String.valueOf(usageCode), '0', 4));
		builder.append(FormatUtil.LPAD(acqrRefNumber == null ? "0" : acqrRefNumber, '0', 23));
		builder.append(FormatUtil.LPAD(String.valueOf(transCurrency), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(transAmount).replace(".", ""), '0', 18));
		builder.append(FormatUtil.LPAD(String.valueOf(feeRow != null ? feeRow.substring(6, 9) : "0"), '0', 3));
		builder.append(FormatUtil.LPAD(String.valueOf(feeRow != null ? feeRow.subSequence(0, 1) : 0), '0', 1));
		builder.append(FormatUtil.LPAD(String.valueOf(feeRow != null ? feeRow.subSequence(9, 21) : 0), '0', 12));
		builder.append(Iso8583LoaderMessageInfo.FILE_ID);
		builder.append(FormatUtil.LPAD(String.valueOf(messageNumber),'0',18));
		return builder.toString();
	}
}
