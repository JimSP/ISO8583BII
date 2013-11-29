package br.com.cafebinario.iso8583.pojo;

import br.com.cafebinario.iso8583.anotation.Destination;

public class EntryPoint extends PojoBase{
	
	private static final String STRING_OBJECT = "EntryPoint [brandId=%s, productId=%s, source=%s, transCode=%s, procCode=%s, fileId=%s, messageNumber=%s, fileName=%s, procDateTime=%s]";

	@Destination(name="V_BRAND_ID", posicao = 1, type = "NUMBER", nativo = true, ipmName="")
	private long brandId = 3;
	
	@Destination(name="V_PRODUCT_ID", posicao = 2, type = "NUMBER", nativo = true, ipmName="")
	private long productId = 3;

	@Destination(name="V_SOURCE", posicao = 3, type = "CHAR", nativo = true, ipmName="")
	private String source = "O";
	
	@Destination(name="V_TRAN_CODE", posicao = 4, type = "NUMBER", nativo = true, ipmName="MTI")
	private long transCode;
	
	@Destination(name="V_PROC_CODE", posicao = 5, type = "NUMBER", nativo = false, ipmName="FUNCTION_CODE")
	private long procCode;
	
	@Destination(name="V_CONTROL_FILE_ID", posicao = 6, type = "VARCHAR2", nativo = false, ipmName="FILE_ID")
	private String fileId;
	
	@Destination(name="V_MESSAGE_NUMBER", posicao = 7, type = "NUMBER", nativo = false, ipmName="MESSAGE_NUMBER")
	private long messageNumber;

	@Destination(name="V_FILE_NAME", posicao = 8, type = "VARCHAR2", nativo = true, ipmName="FILE_NAME")
	private String fileName;
	
	@Destination(name="V_PROC_DATE_TIME", posicao = 9, type = "NUMBER", nativo = false, ipmName="DATE_AND_TIME_LOCAL_TRANSACTION")
	private long procDateTime;

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public long getTransCode() {
		return transCode;
	}

	public void setTransCode(long transCode) {
		this.transCode = transCode;
	}

	public long getProcCode() {
		return procCode;
	}

	public void setProcCode(long procCode) {
		this.procCode = procCode;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public long getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(long messageNumber) {
		this.messageNumber = messageNumber;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getProcDateTime() {
		return procDateTime;
	}

	public void setProcDateTime(long procDateTime) {
		this.procDateTime = procDateTime;
	}
	
	@Override
	public String toString() {
		return String
				.format(STRING_OBJECT,
						brandId, productId, source, transCode, procCode,
						fileId, messageNumber, fileName, procDateTime);
	}
}
