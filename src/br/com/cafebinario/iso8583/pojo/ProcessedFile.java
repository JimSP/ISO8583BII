package br.com.cafebinario.iso8583.pojo;

import java.io.Serializable;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.anotation.Destination;

public class ProcessedFile extends PojoBase implements Serializable{

	private static final long serialVersionUID = -6834760046528688177L;

	@Destination(name="V_PROCESS_FILE_ID", posicao = 1, type = "VARCHAR2", nativo = false, ipmName="FILE_ID")
	protected String processFileId;
	
	@Destination(name="V_PROCESS_FILE_ID", posicao = 1, type = "VARCHAR2", nativo = false, ipmName="FILE_NAME")
	protected String fileName;
	
	protected String procDate;
	protected String procTime;
	protected double sumAmount;
	protected long nroRecords;

	public String getProcessFileId() {
		return processFileId;
	}

	public void setProcessFileId(String processFileId) {
		this.processFileId = processFileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProcDate() {
		return procDate;
	}

	public void setProcDate(String procDate) {
		this.procDate = procDate;
	}

	public String getProcTime() {
		return procTime;
	}

	public void setProcTime(String procTime) {
		this.procTime = procTime;
	}

	public double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(long sumAmount) {
		this.sumAmount = sumAmount;
	}

	public long getNroRecords() {
		return nroRecords;
	}

	public void setNroRecords(long nroRecords) {
		this.nroRecords = nroRecords;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PF");
		builder.append(Iso8583LoaderMessageInfo.FILE_ID);
		builder.append(FormatUtil.RPAD(Iso8583LoaderMessageInfo.FILE_NAME,' ', 30));
		builder.append(procDate);
		builder.append(procTime);
		builder.append(FormatUtil.LPAD(String.valueOf(sumAmount*100).replaceAll(".", ""),'0', 18));
		builder.append(FormatUtil.LPAD(String.valueOf(nroRecords),'0', 18));
		return builder.toString();
	}
}