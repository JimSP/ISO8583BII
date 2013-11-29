package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.anotation.Destination;
import br.com.cafebinario.iso8583.anotation.DestinationTable;

@DestinationTable(name="ControlFile")
public class ControlFile /*extends ProcessedFile*/ implements Serializable{
	
	private static final long serialVersionUID = 2489899237012224835L;

	@Destination(name="V_PROCESS_FILE_ID", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="FILE_ID")
	private String processFileId;
	
	@Destination(name="V_PROCESS_FILE_NAME", posicao = 1, type = "VARCHAR2", nativo = false, ipmName="FILE_NAME")
	protected String fileName;
	
	@Destination(name="V_TRAN_CODE", posicao = 2, type = "NUMBER", nativo = false, ipmName="MTI")
	private int transCode;
	
	@Destination(name="V_USAGE_CODE", posicao = 3, type = "NUMBER", nativo = false, ipmName="FUNCTION_CODE")
	private int usageCode;
	
	@Destination(name="V_FILE_TYPE", posicao = 4, type = "NUMBER", nativo = false, ipmName="FILE_TYPE")
	private int fileType;
	
	@Destination(name="V_FILE_REFERENCE_DATE", posicao = 5, type = "NUMBER", nativo = false, ipmName="REFERENCE_DATE")
	private int fileReferenceDate;
	
	@Destination(name="V_PROCESSOR_ID", posicao = 6, type = "NUMBER", nativo = false, ipmName="PROCESSOR_ID")
	private int processorId;
	
	@Destination(name="V_FILE_SEQUENCE_NUMBER", posicao = 7, type = "NUMBER", nativo = false, ipmName="SEQUENCE_NUMBER")
	private int fileSequenceNumber;
	
	@Destination(name="V_FILE_AMOUNT", posicao = 8, type = "NUMBER", nativo = false, ipmName="")
	private int fileAmount;
	
	@Destination(name="V_FILE_COUNTS", posicao = 9, type = "NUMBER", nativo = false, ipmName="")
	private int fileCounts;
	
	@Destination(name="V_MESSAGE_NUMBER", posicao = 10, type = "NUMBER", nativo = false, ipmName="MESSAGE_NUMBER")
	private int messageNumber;

	public String getProcessFileId() {
		return processFileId;
	}

	public void setProcessFileId(String processFileId) {
		Iso8583LoaderMessageInfo.FILE_ID = processFileId;
		this.processFileId = processFileId;
	}

	public int getTransCode() {
		return transCode;
	}

	public void setTransCode(int transCode) {
		this.transCode = transCode;
	}

	public int getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(int usageCode) {
		this.usageCode = usageCode;
	}

	public long getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public long getFileReferenceDate() {
		return fileReferenceDate;
	}

	public void setFileReferenceDate(int fileReferenceDate) {
		this.fileReferenceDate = fileReferenceDate;
	}

	public long getProcessorId() {
		return processorId;
	}

	public void setProcessorId(int processorId) {
		this.processorId = processorId;
	}

	public long getFileSequenceNumber() {
		return fileSequenceNumber;
	}

	public void setFileSequenceNumber(int fileSequenceNumber) {
		this.fileSequenceNumber = fileSequenceNumber;
	}

	public int getFileAmount() {
		return fileAmount;
	}

	public void setFileAmount(int fileAmount) {
		this.fileAmount = fileAmount;
	}

	public int getFileCounts() {
		return fileCounts;
	}

	public void setFileCounts(int fileCounts) {
		this.fileCounts = fileCounts;
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
		builder.append("CF");
		builder.append(Iso8583LoaderMessageInfo.FILE_ID);
		builder.append(transCode);
		builder.append(usageCode);
		builder.append(Iso8583LoaderMessageInfo.FILE_ID.substring(0, 3));
		builder.append(Iso8583LoaderMessageInfo.FILE_ID.substring(3, 9));
		builder.append(Iso8583LoaderMessageInfo.FILE_ID.substring(9, 21));
		builder.append(Iso8583LoaderMessageInfo.FILE_ID.substring(21, 25));
		builder.append(FormatUtil.LPAD(String.valueOf(fileAmount*100).replaceAll(".", ""),'0',18));
		builder.append(FormatUtil.LPAD(String.valueOf(fileCounts),'0',12));
		builder.append(FormatUtil.LPAD(String.valueOf(messageNumber),'0',18));
		return builder.toString();
	}
}