package br.com.cafebinario.iso8583;

public class MessageInfo {
	
	private String fileName;
	private int LENGTH;
	private int MTI_CODE;
	private int FUNCTION_CODE;

	private String BITMAP;
	private String MSG;

	public int getLENGTH() {
		return LENGTH;
	}

	public void setLENGTH(int lENGTH) {
		LENGTH = lENGTH;
	}

	public int getMTI_CODE() {
		return MTI_CODE;
	}

	public void setMTI_CODE(int mTI_CODE) {
		MTI_CODE = mTI_CODE;
	}
	
	public int getFUNCTION_CODE() {
		return FUNCTION_CODE;
	}

	public void setFUNCTION_CODE(int fUNCTION_CODE) {
		FUNCTION_CODE = fUNCTION_CODE;
	}

	public String getBITMAP() {
		return BITMAP;
	}

	public void setBITMAP(String bITMAP) {
		BITMAP = bITMAP;
	}

	public String getMSG() {
		return MSG;
	}

	public void setMSG(String mSG) {
		MSG = mSG;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
}
