package br.com.cafebinario.iso8583.pojo;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.anotation.Destination;
import br.com.cafebinario.iso8583.anotation.DestinationTable;

@DestinationTable(name="EXCHANGE_MC_FINAN_ADDENDUM")
public class ExchangeMcFinanAddendum {
	
	@Destination(name="V_TRANS_CODE", posicao = 0, type = "NUMBER", nativo = false, ipmName="MTI")
	private int transCode;
	
	@Destination(name="V_USAGE_CODE", posicao = 0, type = "NUMBER", nativo = false, ipmName="FUNCTION_CODE")
	private Integer usage_code;
	
	@Destination(name="V_FORWARDING_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="FORWARDING_INSTITUTION_ID_CODE")
	private Integer forwarding_inst_id;
	
	@Destination(name="V_ORI_MESSAGE_FORMART", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="ORIGINATING_MESSAGE_FORMAT")
	private String ori_message_format;
	
	@Destination(name="V_TRANS_DESCRIPTION", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="TRANSACTION_DESCRIPTION")
	private String trans_description;
	
	@Destination(name="V_FORM_DESCRIPTION", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="FREE-FORM_DESCRIPTION")
	private String form_description;
	
	@Destination(name="V_TRANS_LIFE_CICLE_ID", posicao = 0, type = "VARCHAR2", nativo = false, ipmName="TRANSACTION_LIFE_CYCLE_ID")
	private String trans_life_ciclye_id;
	
	@Destination(name="V_MESSAGE_NUMBER", posicao = 0, type = "NUMBER", nativo = false, ipmName="MESSAGE_NUMBER")
	private Integer message_number;
	
	@Destination(name="V_TRANS_DEST_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_DESTINATION_INSTITUTION_ID_CODE")
	private Integer trans_dest_inst_i;
	
	@Destination(name="V_TRANS_ORI_INST_ID", posicao = 0, type = "NUMBER", nativo = false, ipmName="TRANSACTION_ORIGINATOR_INSTITUTION_ID_CODE")
	private Integer trans_ori_inst_id;

	public int getTransCode() {
		return transCode;
	}

	public void setTransCode(int transCode) {
		this.transCode = transCode;
	}

	public Integer getUsage_code() {
		return usage_code;
	}

	public void setUsage_code(Integer usage_code) {
		this.usage_code = usage_code;
	}

	public Integer getForwarding_inst_id() {
		return forwarding_inst_id;
	}

	public void setForwarding_inst_id(Integer forwarding_inst_id) {
		this.forwarding_inst_id = forwarding_inst_id;
	}

	public String getOri_message_format() {
		return ori_message_format;
	}

	public void setOri_message_format(String ori_message_format) {
		this.ori_message_format = ori_message_format;
	}

	public String getTrans_description() {
		return trans_description;
	}

	public void setTrans_description(String trans_description) {
		this.trans_description = trans_description;
	}

	public String getForm_description() {
		return form_description;
	}

	public void setForm_description(String form_description) {
		this.form_description = form_description;
	}

	public String getTrans_life_ciclye_id() {
		return trans_life_ciclye_id;
	}

	public void setTrans_life_ciclye_id(String trans_life_ciclye_id) {
		this.trans_life_ciclye_id = trans_life_ciclye_id;
	}

	public Integer getMessage_number() {
		return message_number;
	}

	public void setMessage_number(Integer message_number) {
		this.message_number = message_number;
	}

	public Integer getTrans_dest_inst_i() {
		return trans_dest_inst_i;
	}

	public void setTrans_dest_inst_i(Integer trans_dest_inst_i) {
		this.trans_dest_inst_i = trans_dest_inst_i;
	}

	public Integer getTrans_ori_inst_id() {
		return trans_ori_inst_id;
	}

	public void setTrans_ori_inst_id(Integer trans_ori_inst_id) {
		this.trans_ori_inst_id = trans_ori_inst_id;
	}

	public String toString() {
		return "FA"
				+ FormatUtil.LPAD(String.valueOf(transCode), FormatUtil.ZERO, 4)
				+ FormatUtil.LPAD(String.valueOf(usage_code), FormatUtil.ZERO, 4)
				+ FormatUtil.LPAD(String.valueOf(forwarding_inst_id == null ? 0 : forwarding_inst_id), FormatUtil.ZERO, 11)
				+ FormatUtil.LPAD(String.valueOf(ori_message_format == null ? 0 : ori_message_format), FormatUtil.ZERO, 1)
				+ FormatUtil.LPAD(String.valueOf(trans_description == null ? 0 : trans_description), FormatUtil.ZERO, 16)
				+ FormatUtil.LPAD(String.valueOf(form_description == null ? 0 : form_description), FormatUtil.ZERO, 55)
				+ FormatUtil.RPAD(String.valueOf(trans_life_ciclye_id == null ? "" : trans_life_ciclye_id), FormatUtil.SPACE, 16)
				+ FormatUtil.LPAD(String.valueOf(message_number == null ? 0 : message_number), FormatUtil.ZERO, 18)
				+ FormatUtil.LPAD(String.valueOf(trans_dest_inst_i == null ? 0 : trans_dest_inst_i), FormatUtil.ZERO, 11)
				+ FormatUtil.LPAD(String.valueOf(trans_ori_inst_id == null ? 0 : trans_ori_inst_id), FormatUtil.ZERO, 11);
	}
}
