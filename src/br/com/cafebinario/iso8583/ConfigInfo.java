package br.com.cafebinario.iso8583;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigInfo {

	private String full_path;
	private boolean printName = true;
	private boolean printLength = true;
	private boolean printType = true;
	private boolean printMask = true;
	private boolean printMetaDataLink = true;
	private boolean printData = true;
	private boolean printSubFieldName = true;
	private boolean printSubFieldMetaDataLink = true;
	private boolean printSubFieldTag = true;
	private boolean printSubFieldLength = true;
	private boolean printSubFieldData = true;
	private boolean printMSG = true;
	private boolean printSql = true;
	private String layoutRelativePathFile = "LAYOUT_MASTER";
	private String insertDestinationTable = "INSERT_DESTINATION_MASTER_TABLE";
	private String ipmDestinationTable = "IPM_DESTINATION_TABLE";
	private String ipmPdsElements = "PDS_ELEMENTS";
	private boolean printRelat = true;
	private boolean printPagina = false;
	private int dia;
	private int mes;
	private int ano;
	private String tipoArquivo = "O";
	
	public ConfigInfo(){
		Date date = new Date(System.currentTimeMillis());
		configDate(date);
	}
	
	public ConfigInfo(Date date){
		configDate(date);
	}
	
	private void configDate(Date date){
		SimpleDateFormat formatYYYY = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatMM = new SimpleDateFormat("MM");
		SimpleDateFormat formatDD = new SimpleDateFormat("dd");
		this.ano = Integer.parseInt(formatYYYY.format(date));
		this.mes = Integer.parseInt(formatMM.format(date));
		this.dia = Integer.parseInt(formatDD.format(date));
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isPrintPagina() {
		return printPagina;
	}

	public void setPrintPagina(boolean printPagina) {
		this.printPagina = printPagina;
	}

	public String getFull_path() {
		return full_path;
	}

	public void setFull_path(String full_path) {
		this.full_path = full_path;
	}

	public boolean isPrintName() {
		return printName;
	}

	public void setPrintName(boolean printName) {
		this.printName = printName;
	}

	public boolean isPrintLength() {
		return printLength;
	}

	public void setPrintLength(boolean printLength) {
		this.printLength = printLength;
	}

	public boolean isPrintType() {
		return printType;
	}

	public void setPrintType(boolean printType) {
		this.printType = printType;
	}

	public boolean isPrintMask() {
		return printMask;
	}

	public void setPrintMask(boolean printMask) {
		this.printMask = printMask;
	}

	public boolean isPrintMetaDataLink() {
		return printMetaDataLink;
	}

	public void setPrintMetaDataLink(boolean printMetaDataLink) {
		this.printMetaDataLink = printMetaDataLink;
	}

	public boolean isPrintData() {
		return printData;
	}

	public void setPrintData(boolean printData) {
		this.printData = printData;
	}

	public boolean isPrintSubFieldName() {
		return printSubFieldName;
	}

	public void setPrintSubFieldName(boolean printSubFieldName) {
		this.printSubFieldName = printSubFieldName;
	}

	public boolean isPrintSubFieldMetaDataLink() {
		return printSubFieldMetaDataLink;
	}

	public void setPrintSubFieldMetaDataLink(boolean printSubFieldMetaDataLink) {
		this.printSubFieldMetaDataLink = printSubFieldMetaDataLink;
	}

	public boolean isPrintSubFieldTag() {
		return printSubFieldTag;
	}

	public void setPrintSubFieldTag(boolean printSubFieldTag) {
		this.printSubFieldTag = printSubFieldTag;
	}

	public boolean isPrintSubFieldLength() {
		return printSubFieldLength;
	}

	public void setPrintSubFieldLength(boolean printSubFieldLength) {
		this.printSubFieldLength = printSubFieldLength;
	}

	public boolean isPrintSubFieldData() {
		return printSubFieldData;
	}

	public void setPrintSubFieldData(boolean printSubFieldData) {
		this.printSubFieldData = printSubFieldData;
	}
	
	public boolean isPrintMSG() {
		return printMSG;
	}

	public void setPrintMSG(boolean printMSG) {
		this.printMSG = printMSG;
	}

	public String getLayoutRelativePathFile() {
		return layoutRelativePathFile;
	}

	public void setLayoutRelativePathFile(String layoutRelativePathFile) {
		this.layoutRelativePathFile = layoutRelativePathFile;
	}

	public boolean isPrintSql() {
		return printSql;
	}
	
	public void setPrintSql(boolean printSql) {
		this.printSql = printSql;
	}

	public String getInsertDestinationTable() {
		return insertDestinationTable;
	}

	public void setInsertDestinationTable(String insertDestinationTable) {
		this.insertDestinationTable = insertDestinationTable;
	}

	public String getIpmDestinationTable() {
		return ipmDestinationTable;
	}

	public void setIpmDestinationTable(String ipmDestinationTable) {
		this.ipmDestinationTable = ipmDestinationTable;
	}

	public String getIpmPdsElements() {
		return ipmPdsElements;
	}

	public void setIpmPdsElements(String ipmPdsElements) {
		this.ipmPdsElements = ipmPdsElements;
	}

	public boolean isPrintRelat() {
		return this.printRelat;
	}
	
	public boolean setPrintRelat(boolean printRelat) {
		return this.printRelat = printRelat;
	}

	public String getTipoArquivo() {
		return this.tipoArquivo;
	}
	
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}
}
