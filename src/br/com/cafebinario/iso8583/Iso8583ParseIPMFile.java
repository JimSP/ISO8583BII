package br.com.cafebinario.iso8583;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import br.com.am53.cafebinario.util.FormatUtil;
import br.com.cafebinario.iso8583.config.LAYOUT_MASTER;
import br.com.cafebinario.properties.AppProperties;

public class Iso8583ParseIPMFile {

	private int N = 1;
	private int NP;
	private int LOTE;

	public static int PAGINADOR = 1;
	public static int _1740;
	public static int _1644_603_S;
	public static int _1644_603_4;

	public static int _1442_CB_S_986;
	public static int _1442_CB_S_XXX;

	public static int _1442_CB_4_986;
	public static int _1442_CB_4_XXX;

	public static int _1442_CBA_4_986;
	public static int _1442_CBA_S_XXX;

	public static int _1442_CBA_4_XXX;
	public static int _1442_CBA_S_986;

	public static int _1240_MMM;
	public static int _1240_200;

	public static int _1442_CB_S;
	public static int _1442_CB_4;

	public static int _1442_CBA_S;
	public static int _1442_CBA_4;

	private static Hashtable<String, Integer> CONTEXT_PAG = new Hashtable<String, Integer>();

	private static final int CAPACICITY = Integer.parseInt(AppProperties
			.instanceOf().getProperty("CAPACITY"));
	private StringBuffer sb = new StringBuffer(CAPACICITY);
	private PrintStream outRelat = null;
	private PrintStream outFile = null;
	private RandomAccessFile in = null;
	private PrintStream outPagina = null;
	private String template = "";
	private GregorianCalendar gc = new GregorianCalendar();
	private int dia;
	private int mes;
	private int ano;
	private String tipoArquivo;
	private String aux = "";

	private List<String> DE_TAGS_MESSAEGE = new ArrayList<String>();
	private List<String> PDS_TAGS_MESSAGE = new ArrayList<String>();
	private Hashtable<String, String> memory = new Hashtable<String, String>();
	private Hashtable<String, List<String[]>> memorySubElements = new Hashtable<String, List<String[]>>();
	private Hashtable<String, SumaryField> memorySumary = new Hashtable<String, SumaryField>();
	private Hashtable<String, String> auxMemory = new Hashtable<String, String>();

	private String DE50;
	private String PDS0158;

	public List<String> getDE_TAGS_MESSAEGE() {
		return DE_TAGS_MESSAEGE;
	}

	public void setDE_TAGS_MESSAEGE(List<String> dE_TAGS_MESSAEGE) {
		DE_TAGS_MESSAEGE = dE_TAGS_MESSAEGE;
	}

	public List<String> getPDS_TAGS_MESSAGE() {
		return PDS_TAGS_MESSAGE;
	}

	public void setPDS_TAGS_MESSAGE(List<String> pDS_TAGS_MESSAGE) {
		PDS_TAGS_MESSAGE = pDS_TAGS_MESSAGE;
	}

	public void setOutPagina(PrintStream outPagina) {
		this.outPagina = outPagina;
	}

	public PrintStream getOutPagina() {
		return outPagina;
	}

	public Hashtable<String, String> getMemory() {
		return memory;
	}

	public void setMemory(Hashtable<String, String> memory) {
		this.memory = memory;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public PrintStream getOutRelat() {
		return outRelat;
	}

	public void setOutRelat(PrintStream outRelat) {
		this.outRelat = outRelat;
	}

	public PrintStream getOutFile() {
		return outFile;
	}

	public void setOutFile(PrintStream outFile) {
		this.outFile = outFile;
	}

	public RandomAccessFile getIn() {
		return in;
	}

	public void setIn(RandomAccessFile in) {
		this.in = in;
	}

	public String ebcdicToAscii(byte[] buffer) {
		String str = new String(buffer, Charset.forName(LAYOUT_MASTER
				.instanceOf().getProperty("Encolding")));
		return str;
	}

	public void setDate(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public void processFile(ConfigInfo info) throws Exception {

		long beginProcessFile = System.currentTimeMillis();
		long endProcessFile = 0;
		long beginProcessMessage = 0;
		long endProcessMessage = 0;
		long beginPrintRelat = 0;
		long endPrintRelat = 0;
		long beginSummaryTags = 0;
		long endSummaryTags = 0;

		tipoArquivo = info.getTipoArquivo();

		//System.out.println("[" + beginProcessFile + "] lendo arquivo...");

		long totalLength = 0;
		boolean markMessage = false;
		try {
			int offset = 0;
			int lengthMessage = -1;
			if (info.isPrintRelat())
				outRelat.println("####################################");
			while (lengthMessage != 0) {

				byte[] buffer = new byte[3 + (markMessage ? 0 : 1)];
				offset = in.read(buffer);

				lengthMessage = byteToLength(buffer);
				buffer = new byte[4];
				offset = in.read(buffer, 0, 4);

				String MTI = ebcdicToAscii(buffer);

				buffer = new byte[16];
				offset = in.read(buffer);
				String bitmap = new BigInteger(1, buffer).toString(2);
				if (lengthMessage > 20) {
					buffer = new byte[lengthMessage - 20];
					offset = in.read(buffer);
					totalLength += offset;
					String MSG = ebcdicToAscii(buffer);

					MSG = MSG.replace(',', '.');
					if (info.isPrintMSG()) {
						outFile.println("["
								+ lengthMessage
								+ "]["
								+ MTI
								+ "]["
								+ bitmap
								+ "]["
								+ MSG.replace('\n', '@').replace('\r', '@')
										.replace('[', '|').replace(']', '|')
								+ "]");
					}

					if (info.isPrintRelat()) {
						outRelat.println("MESSAGE TYPE INDICATOR=" + MTI);
					}

					int lastIndex = info.getFull_path().lastIndexOf("\\");
					lastIndex = lastIndex == -1 ? info.getFull_path()
							.lastIndexOf("/") : lastIndex;
					String fileName = lastIndex == -1 ? info.getFull_path()
							: info.getFull_path().substring(lastIndex + 1);
					MessageInfo message = new MessageInfo();
					message.setLENGTH(lengthMessage);
					message.setBITMAP(bitmap);
					message.setMSG(MSG);
					message.setMTI_CODE(Integer.parseInt(MTI));
					message.setFileName(fileName);

					beginProcessMessage = System.currentTimeMillis();
					processMessage(message, outRelat, info);
					endProcessMessage = System.currentTimeMillis();

					if (info.isPrintPagina()) {
						beginPrintRelat = System.currentTimeMillis();
						printPag(message, info);

						if (Integer.parseInt(AppProperties.instanceOf()
								.getProperty("WRITE_FILE")) == NP++) {
							outPagina.printf("%s", sb.toString());
							sb = new StringBuffer(CAPACICITY);
							System.gc();
							//System.out.println("[" + System.currentTimeMillis()
									+ "]Lote " + LOTE++ + " gravado.");
							NP = 0;
						}

						endPrintRelat = System.currentTimeMillis();

						Enumeration<String> keys = auxMemory.keys();

						beginSummaryTags = System.currentTimeMillis();
						while (keys.hasMoreElements()) {
							String key = keys.nextElement();
							double value = Double.valueOf(auxMemory.get(key));

							SumaryField summary = memorySumary.get(key);
							if (summary != null) {
								if (message.getFUNCTION_CODE() == 200) {
									summary.add(value / 100);
								} else if (message.getFUNCTION_CODE() == 400) {
									summary.add((value * -1 / 100));
								}
							} else {
								summary = new SumaryField();
								summary.setElementTag(key);
								if (message.getFUNCTION_CODE() == 200) {
									summary.add(value / 100);
								} else if (message.getFUNCTION_CODE() == 400) {
									summary.add((value * -1) / 100);
								}
								memorySumary.put(key, summary);
							}
						}
					}
					endSummaryTags = System.currentTimeMillis();
					auxMemory.clear();
					PDS_TAGS_MESSAGE.clear();
					DE_TAGS_MESSAEGE.clear();

					/*******************************************
					 * //System.out.println("#########################"); //
					 * /tempos de execução para medir performancing
					 * //System.out.println("DProcessMessage=" +
					 * (endProcessMessage - beginProcessMessage));
					 * //System.out.println("DPrintRelat=" + (endPrintRelat -
					 * beginPrintRelat)); //System.out.println("DSummaryTags=" +
					 * (endSummaryTags - beginSummaryTags));
					 * //System.out.println("#########################");
					 *******************************************/
				}

				if (info.isPrintRelat())
					outRelat.println("####################################");

				if ("US-ASCII".equals(LAYOUT_MASTER.instanceOf().getProperty(
						"Encolding"))) {
					buffer = new byte[1];
					offset = in.read(buffer);
				}
				totalLength += offset;
				N++;
			}

			if (info.isPrintPagina()) {
				outPagina.printf("%s", sb.toString());
				System.gc();
				//System.out.println("[" + System.currentTimeMillis() + "]Lote "
						+ LOTE++ + " gravado.");
				NP = 0;

				imprimeT464();
				imprimimeSummaryTemplates();
			}

			in.close();

		} catch (FileNotFoundException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Arquivo nao encontrado!");
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Problemas ao ler o arquivo!");
			e.printStackTrace();
			throw e;
		}

		endProcessFile = System.currentTimeMillis();
		//System.out.println("[" + endProcessFile
				+ "] Arquivo processado com sucesso!");
	}
	
	public String readMessage(InputStream in){
		
		
		return null;
	}

	public void processMessage(MessageInfo message, PrintStream out,
			ConfigInfo info) throws Exception {
		memory.clear();
		memorySubElements.clear();
		memorySumary.clear();
		auxMemory.clear();

		memory.put("MTI", String.valueOf(message.getMTI_CODE()));
		memory.put("LENGTH", String.valueOf(message.getLENGTH()));
		memory.put("BITMAP", message.getBITMAP());

		String desComPDS = LAYOUT_MASTER.instanceOf().getProperty("DE_PDS");

		String[] DeMapPds = desComPDS.split("[,]");

		int index = 2;
		int length = 0;
		int start = 0;

		String name = "";
		String lengthField = "";
		String type = "";
		String mask = "";
		String meta_data_link = "";
		String value = "";
		String summary_tag = "";

		if (info.isPrintRelat())
			out.println("====================================");
		int lengthFlag = 0;
		try {
			while (index <= message.getBITMAP().length()) {
				char bit = message.getBITMAP().charAt(index - 1);

				if (bit == '1') {
					name = "";
					type = "";
					length = 0;
					mask = "";
					meta_data_link = "";
					summary_tag = "";

					if (info.isPrintRelat())
						out.println("DE " + index);

					String definiction = LAYOUT_MASTER.instanceOf()
							.getProperty(String.valueOf(index));

					if ("".equals(definiction)) {
						throw new Iso8583ParseException("DE " + index
								+ " não encontrado no arquivo "
								+ info.getLayoutRelativePathFile() + ".");
					}

					if (definiction == null) {
						System.out
								.println("DE " + index + " not definition...");
					} else {
						String[] estrutura = definiction.split("[,]");

						int j = 0;
						while (j < estrutura.length) {
							if (j == 0) {
								name = estrutura[j];
							} else if (j == 1) {
								lengthField = estrutura[j];
							} else if (j == 2) {
								type = estrutura[j];
								if ("LVAR".equals(type)) {
									lengthFlag = 1;
								} else if ("LLVAR".equals(type)) {
									lengthFlag = 2;
								} else if ("LLLVAR".equals(type)) {
									lengthFlag = 3;
								} else if ("N".equals(type)) {
									lengthFlag = 0;
								} else if ("Date".equals(type)) {
									lengthFlag = 0;
								} else if ("AN".equals(type)) {
									lengthFlag = 0;
								} else {
									lengthFlag = 0;
									if (info.isPrintRelat())
										out.println("DATA TYPE NOT RECOGNITION");
								}
							} else if (j == 3) {
								mask = estrutura[j];
							} else if (j == 4) {
								meta_data_link = estrutura[j];
							} else if (j == 5) {
								summary_tag = estrutura[j];
							}
							j++;
						}

						length = lengthFlag == 0 ? Integer
								.parseInt(lengthField) : Integer
								.parseInt(message.getMSG().substring(start,
										start + lengthFlag));

						value = message.getMSG().substring(start + lengthFlag,
								start + lengthFlag + length);

						if (index == 2) {
							memory.put("BIN", value.substring(0, 6));
						}

						if (index == 24) {
							message.setFUNCTION_CODE(Integer.valueOf(value));
						}

						if (index == 50) {
							DE50 = value;
						}

						DE_TAGS_MESSAEGE.add("DE" + String.valueOf(index));

						if (info.isPrintRelat())
							if (info.isPrintName()) {
								out.println("FIELD NAME=" + name);
							}

						if (info.isPrintRelat())
							if (info.isPrintType()) {
								out.println("FIELD TYPE=" + type);
							}

						if (info.isPrintRelat())
							if (info.isPrintLength()) {
								out.println("FIELD LENGTH=" + length);
							}

						if (info.isPrintRelat())
							if (info.isPrintMask()) {
								out.println("FIELD MASK=" + mask);
							}

						if (info.isPrintRelat())
							if (info.isPrintMetaDataLink()) {
								out.println("META_DATA_LINK=" + meta_data_link);
							}

						if (!"".equals(meta_data_link)) {
							value = dispacherEvent(value, meta_data_link);
							List<String[]> elements = dispacherEvent(value,
									String.valueOf(index), meta_data_link);

							if (elements != null) {
								memorySubElements.put(
										"DE" + String.valueOf(index), elements);

								int s = 1;
								for (String[] element : elements) {
									if (element.length >= 4)
										if ("Y".equals(element[3])) {
											String subDeValue = value
													.substring(
															Integer.parseInt(element[1]),
															Integer.parseInt(element[2]));

											auxMemory.put("SF" + s + "_DE"
													+ String.valueOf(index),
													subDeValue);
										}
									s++;
								}
							}
						}

						memory.put("DE" + String.valueOf(index), value);

						if ("Y".equals(summary_tag)) {
							auxMemory.put("DE" + String.valueOf(index), value);
						}

						if (info.isPrintRelat()) {
							if (info.isPrintData()) {
								out.println("FIELD VALUE=" + value);
							}
						}

						for (String de : DeMapPds) {
							if (Integer.parseInt(de) == index) {
								if (info.isPrintRelat())
									out.println("-------------------------------------");
								String TAG = "";
								String LENGTH = "";
								String DATA = "";
								int current = 0;
								int elementIndex = 1;
								while (current < value.length()) {

									TAG = value.substring(current, current + 4);
									LENGTH = value.substring(current + 4,
											current + 7);
									DATA = value.substring(current + 7, current
											+ 7 + Integer.parseInt(LENGTH));
									String PDSDesciptor = LAYOUT_MASTER
											.instanceOf().getProperty(TAG);

									if ("0158".equals(TAG)) {
										PDS0158 = DATA;
									}

									memory.put("PDS" + String.valueOf(TAG),
											DATA);
									PDS_TAGS_MESSAGE.add(TAG);

									if ("".equals(PDSDesciptor)) {
										throw new Iso8583ParseException(
												"PDS "
														+ TAG
														+ " não encontrado no arquivo "
														+ info.getLayoutRelativePathFile()
														+ ".");
									}

									String[] PDSStruct = PDSDesciptor
											.split("[,]");

									if (info.isPrintRelat()) {
										if (info.isPrintSubFieldName()) {
											out.println("SUB-FIELD NAME="
													+ PDSStruct[0]);
										}
									}

									boolean summary = false;
									if (PDSStruct.length >= 5) {
										if ("Y".equals(PDSStruct[4])) {
											auxMemory.put("PDS" + TAG, DATA);
											summary = true;
										}
									}

									if (PDSStruct.length >= 4) {
										if (!"".equals(PDSStruct[3])) {
											List<String[]> elememts = dispacherEvent(
													DATA, TAG, PDSStruct[3]);

											if (elememts != null)
												memorySubElements.put(TAG,
														elememts);

											int s = 1;
											for (String[] subElement : elememts) {
												if (subElement.length >= 4
														&& !summary) {
													if ("Y".equals(subElement[3])) {
														String subElementValue = DATA
																.substring(
																		Integer.parseInt(subElement[1]),
																		Integer.parseInt(subElement[2]));
														auxMemory
																.put("SF"
																		+ String.valueOf(s)
																		+ "_PDS"
																		+ TAG,
																		subElementValue);
													}
												}
												s++;
											}
										}
									}

									if (info.isPrintRelat())
										if (info.isPrintSubFieldMetaDataLink()) {
											if (PDSStruct.length >= 4) {
												out.println("SUB-FIELD META_LINK="
														+ PDSStruct[3]);
											}
										}

									if (info.isPrintRelat())
										if (info.isPrintSubFieldTag()) {
											out.println("TAG=" + TAG);
										}

									if (info.isPrintRelat())
										if (info.isPrintSubFieldLength()) {
											out.println("LENGTH=" + LENGTH);
										}

									if (info.isPrintRelat())
										if (info.isPrintSubFieldData()) {
											out.println("DATA=" + DATA);
										}

									current += Integer.parseInt(LENGTH) + 7;
									if (info.isPrintRelat())
										out.println("------------------------------------");

									elementIndex++;
								}
							}
						}

						start = length
								+ (lengthFlag == 0 ? start + lengthFlag : start
										+ message
												.getMSG()
												.substring(start,
														start + lengthFlag)
												.length());
						if (info.isPrintRelat())
							out.println("====================================");
					}
				}
				index++;
			}
		} catch (Exception ex) {
			//System.out.println("MESSAGE NUMBER=" + N);
			//System.out.println("DE=" + index);
			//System.out.println("message.getMSG()=" + message.getMSG());
			//System.out.println("substring(" + (start + lengthFlag) + ","
					+ (start + lengthFlag + length) + ")");
			//System.out.println("length=" + length);
			//System.out.println("value=" + value);
			ex.printStackTrace();
			throw ex;
		}
	}

	private void imprimeT464() {

	}

	private void imprimimeSummaryTemplates() throws IOException {
		/* TOTALIZADOR DE RELATORIOS */

		// aux = "SUM";
		// CONTEXT_PAG.put(aux, 1);

		String path = AppProperties.instanceOf().getProperty("RELAT_PATH")
				+ tipoArquivo + "_";
		String templateSummaryMessage = "";
		if (_1740 > 0) {
			aux = path + "1740";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1740");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1740), "${SM_1740,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1644_603_S > 0) {
			aux = path + "1644_603_S";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1644_603_S");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1644_603_S), "${SM_1644_603_S,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1644_603_4 > 0) {
			aux = path + "1644_603_4";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1644_603_4");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1644_603_4), "${SM_1644_603_4,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1442_CB_S > 0) {
			aux = path + "1442_CB_S";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1442_CB_S");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1442_CB_S), "${SM_1442_CB_S,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1442_CB_4 > 0) {
			aux = path + "1442_CB_4";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1442_CB_4");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1442_CB_4), "${SM_1442_CB_4,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1442_CBA_S > 0) {
			aux = path + "1442_CBA_S";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1442_CBA_S");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1442_CBA_S), "${SM_1442_CBA_S,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1442_CBA_4 > 0) {
			aux = path + "1442_CBA_4";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1442_CBA_4");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1442_CBA_4), "${SM_1442_CBA_4,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1240_MMM > 0) {
			aux = path + "1240_MMM";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1240_MMM");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1240_MMM), "${SM_1240_MMM,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		if (_1240_200 > 0) {
			aux = path + "1240_200";
			Integer paginaAnt = CONTEXT_PAG.remove(aux);
			CONTEXT_PAG.put(aux, paginaAnt.intValue() + 1);

			templateSummaryMessage = readTemplate(path + "SM_1240_200");
			templateSummaryMessage = imprimir(templateSummaryMessage,
					String.valueOf(_1240_200), "${SM_1240_200,");
			templateSummaryMessage = imprimirContextoSummaryMessage(templateSummaryMessage);
			templateSummaryMessage = limparTagsVazias(templateSummaryMessage);
			outPagina.printf("%s", templateSummaryMessage);
		}

		/*----------------------------*/
	}

	private String imprimirContextoSummaryMessage(String templateSummaryMessage) {
		templateSummaryMessage = imprimePagina(templateSummaryMessage);

		templateSummaryMessage = imprimir(templateSummaryMessage,
				String.valueOf(gc.get(Calendar.DAY_OF_YEAR)), "${JULIAN_DATE,");
		templateSummaryMessage = imprimir(templateSummaryMessage,
				FormatUtil.LPAD(String.valueOf(ano), '0', 2), "${ANO,");
		templateSummaryMessage = imprimir(templateSummaryMessage,
				FormatUtil.LPAD(String.valueOf(mes), '0', 2), "${MES,");
		templateSummaryMessage = imprimir(templateSummaryMessage,
				FormatUtil.LPAD(String.valueOf(dia), '0', 2), "${DIA,");
		return templateSummaryMessage;
	}

	private int byteToLength(byte[] buffer) {
		if ("US-ASCII".equals(LAYOUT_MASTER.instanceOf().getProperty(
				"Encolding"))) {
			return Integer.parseInt(new String(buffer));
		} else {
			int rt = Integer.parseInt(new BigInteger(1, buffer).toString(10));
			return rt;
			/*
			if (buffer[0] == 0 && buffer[1] == 0 && buffer[2] == 2
					&& buffer[3] == 21) {
				return 549;
			} else {
				int rt = Integer.parseInt(new BigInteger(1, buffer).toString(10));
				return rt;
			}
			*/
		}
	}

	public int toInt(byte[] bytes) {
		int ret = 0;
		for (int i = 0; i < bytes.length; i++) {
			ret <<= 8;
			ret |= bytes[i] & 0xFF;
		}
		return ret;
	}

	private int byteToLengthTest(byte[] length) {
		return Integer.parseInt(new BigInteger(Coder
				.EBCDICToASCII(new BigInteger(length).toByteArray()))
				.toString(10));
	}

	private void printPag(MessageInfo message, ConfigInfo info)
			throws IOException {

		long beginReadTemplate = System.currentTimeMillis();
		long endReadTemplate = 0;
		long beginCreatePaginaDE = 0;
		long endCreatePaginaDE = 0;
		long beginCreatePaginaPDS = 0;
		long endCreatePaginaPDS = 0;
		long beginCreatePaginaConntext = 0;
		long endCreatePaginaConntext = 0;
		long beginLimpaTags = 0;
		long endLimpaTags = 0;
		long beginAppend = 0;
		long endAppend = 0;

		aux = AppProperties.instanceOf().getProperty("RELAT_PATH")
				+ tipoArquivo + "_";
		String pathRelat = aux;
		if (message.getMTI_CODE() == 1240) {
			if (message.getFUNCTION_CODE() == 200) {
				_1240_200++;
				aux += "1240_200";

			} else if (message.getFUNCTION_CODE() == 205
					|| message.getFUNCTION_CODE() == 282) {
				_1240_MMM++;
				aux += "1240_MMM";
			}
		} else if (message.getMTI_CODE() == 1442) {
			if (message.getFUNCTION_CODE() == 451
					|| message.getFUNCTION_CODE() == 454) {
				if (PDS0158 != null)
					if (PDS0158.length() > 4)
						if ("4".equals(PDS0158.substring(3, 4))) {
							if ("986".equals(DE50)) {
								_1442_CBA_4_986++;
							} else {
								_1442_CBA_4_XXX++;
							}

							_1442_CBA_4++;
							aux += "1442_CBA_4";

						} else {
							if ("986".equals(DE50)) {
								_1442_CBA_S_986++;
							} else {
								_1442_CBA_S_XXX++;
							}

							_1442_CBA_S++;
							aux += "1442_CBA_S";
						}
			} else if (message.getFUNCTION_CODE() == 450
					|| message.getFUNCTION_CODE() == 453) {
				if (PDS0158 != null)
					if (PDS0158.length() > 4)
						if ("4".equals(PDS0158.substring(3, 4))) {
							if ("986".equals(DE50)) {
								_1442_CB_4_986++;
							} else {
								_1442_CB_4_XXX++;
							}

							_1442_CB_4++;
							aux += "1442_CB_4";
						} else {

							if ("986".equals(DE50)) {
								_1442_CB_S_986++;
							} else {
								_1442_CB_S_XXX++;
							}

							_1442_CB_S++;
							aux += "1442_CB_S";
						}
			}
		} else if (message.getMTI_CODE() == 1644) {
			if (message.getFUNCTION_CODE() == 603)
				if ("4".equals(PDS0158.substring(3, 4))) {
					_1644_603_4++;
					aux += "1644_603_4";
				} else {
					_1644_603_S++;
					aux += "1644_603_S";
				}

		} else if (message.getMTI_CODE() == 1740) {
			_1740++;
			aux += "1740";
		}

		if (pathRelat.equals(aux)) {
			return;
		}

		if (CONTEXT_PAG.containsKey(aux)) {
			Integer countPage = CONTEXT_PAG.remove(aux);
			countPage = countPage.intValue() + 1;
			CONTEXT_PAG.put(aux, countPage);
		} else {
			CONTEXT_PAG.put(aux, 1);
		}

		String templatePath = aux;
		String pagina = readTemplate(templatePath);
		endReadTemplate = System.currentTimeMillis();

		beginCreatePaginaDE = System.currentTimeMillis();
		int index = 2;
		while (index <= 128) {

			String value = memory.get("DE" + String.valueOf(index));
			pagina = imprimir(pagina, value != null ? value : "", "${DE"
					+ index + ",");

			List<String[]> elements = memorySubElements.get("DE"
					+ String.valueOf(index));
			int s = 1;

			if (elements != null && value != null)
				for (String[] element : elements) {
					if (index != 43) {
						try {
							pagina = imprimir(pagina, value.substring(
									Integer.parseInt(element[1]),
									Integer.parseInt(element[2])), "${SF" + s
									+ "_DE" + String.valueOf(index) + ",");
						} catch (Exception e) {
							pagina = imprimir(pagina, "", "${SF" + s + "_DE"
									+ String.valueOf(index) + ",");
						}
						s++;
					} else {
						try {
							pagina = imprimir(pagina, element[3], "${SF" + s
									+ "_DE" + String.valueOf(index) + ",");
						} catch (Exception e) {
							pagina = imprimir(pagina, "", "${SF" + s + "_DE"
									+ String.valueOf(index) + ",");
						}
						s++;
					}
				}

			index++;
		}

		endCreatePaginaDE = System.currentTimeMillis();
		beginCreatePaginaPDS = System.currentTimeMillis();
		for (String TAG : PDS_TAGS_MESSAGE) {
			String value = memory.get("PDS" + TAG);
			pagina = imprimir(pagina, TAG, "${PDS" + TAG + "_TAG,");
			pagina = imprimir(pagina, value != null ? value : "", "${PDS" + TAG
					+ ",");

			List<String[]> elements = memorySubElements.get(TAG);

			if (elements != null && value != null) {
				int s = 1;
				for (String[] element : elements) {
					try {
						String subFieldValue = value.substring(
								Integer.parseInt(element[1]),
								Integer.parseInt(element[2]));
						pagina = imprimir(pagina, subFieldValue, "${SF"
								+ String.valueOf(s) + "_PDS" + TAG + ",");
					} catch (Exception e) {
						pagina = imprimir(pagina, "",
								"${SF" + String.valueOf(s) + "_PDS" + TAG + ",");
					}
					s++;
				}
			}
		}
		endCreatePaginaPDS = System.currentTimeMillis();

		beginCreatePaginaConntext = System.currentTimeMillis();
		pagina = imprimir(pagina, message.getFileName(), "${FILE_NAME,");
		pagina = imprimir(pagina, templatePath, "${TEMPLATE,");
		pagina = imprimir(pagina, String.valueOf(message.getLENGTH()),
				"${LENGTH,");
		pagina = imprimir(pagina, message.getBITMAP(), "${BITMAP,");
		pagina = imprimir(pagina, String.valueOf(message.getMTI_CODE()),
				"${MTI,");
		pagina = imprimir(pagina, memory.get("BIN"), "${BIN,");

		pagina = imprimePagina(pagina);

		pagina = imprimir(pagina, String.valueOf(gc.get(Calendar.DAY_OF_YEAR)),
				"${JULIAN_DATE,");
		pagina = imprimir(pagina, FormatUtil.LPAD(String.valueOf(ano), '0', 2),
				"${ANO,");
		pagina = imprimir(pagina, FormatUtil.LPAD(String.valueOf(mes), '0', 2),
				"${MES,");
		pagina = imprimir(pagina, FormatUtil.LPAD(String.valueOf(dia), '0', 2),
				"${DIA,");

		endCreatePaginaConntext = System.currentTimeMillis();

		beginLimpaTags = System.currentTimeMillis();
		pagina = limparTagsVazias(pagina);
		endLimpaTags = System.currentTimeMillis();

		beginAppend = System.currentTimeMillis();
		sb.append(pagina);
		endAppend = System.currentTimeMillis();

		/*******************************************
		 * //System.out.println("----------------------------------------------");
		 * //System.out.println("printPag.ReadTemplate=" + (endReadTemplate -
		 * beginReadTemplate)); //System.out.println("printPag.CreatePaginaDE=" +
		 * (endCreatePaginaDE - beginCreatePaginaDE));
		 * //System.out.println("printPag.CreatePaginaPDS=" + (endCreatePaginaPDS
		 * - beginCreatePaginaPDS));
		 * //System.out.println("printPag.CreatePaginaConntext=" +
		 * (endCreatePaginaConntext - beginCreatePaginaConntext));
		 * //System.out.println("printPag.LimpaTags=" + (endLimpaTags -
		 * beginLimpaTags)); //System.out.println("printPag.Append=" + (endAppend
		 * - beginAppend));
		 * //System.out.println("----------------------------------------------");
		 *******************************************/
	}

	private Integer getPAGINADORFromContex() {
		return CONTEXT_PAG.get(aux);
	}

	private Integer getAndSumPAGINADORFromContex() {
		Integer pag = CONTEXT_PAG.remove(aux);
		pag = pag.intValue() + 1;
		CONTEXT_PAG.put(aux, pag);
		return pag;
	}

	private String imprimePagina(String pagina) {
		pagina = imprimir(pagina, String.valueOf(getPAGINADORFromContex()),
				"${PAGINA,");

		int i = 1;
		String paxAux = "";
		while (true) {
			if (pagina.contains("${PAGINA_" + i + ",")) {
				paxAux = imprimir(pagina,
						String.valueOf(getAndSumPAGINADORFromContex()),
						"${PAGINA_" + i + ",");
				pagina = paxAux;
				i++;
			} else {
				break;
			}
		}
		return pagina;
	}

	private String limparTagsVazias(String pagina) {
		int beginTag = 0;
		int charPosition = 0;
		try {
			while (true) {
				beginTag = pagina.indexOf("${");

				if (beginTag == -1) {
					break;
				}

				while (charPosition <= beginTag) {
					charPosition = pagina.indexOf(",");
				}

				pagina = imprimir(pagina, "",
						pagina.substring(beginTag, charPosition + 1));
				charPosition = 0;
			}
		} catch (Exception e) {
			//System.out.println(e);
		}

		return pagina;
	}

	private String readTemplate(String templatePath) throws IOException {
		FileReader reader = new FileReader(templatePath);
		BufferedReader buffer = new java.io.BufferedReader(reader);

		template = "";
		while (buffer.ready()) {
			template += buffer.readLine() + "\r\n";
		}

		reader.close();
		buffer.close();

		return template;
	}

	private String imprimir(String pagina, String value, String tag) {
		int indexOfBegin = pagina.indexOf(tag) + tag.length();//

		if (tag.length() - 1 == indexOfBegin) {
			return pagina;
		}

		int n = 1;
		String auxIndexEnd = "";
		char charN = '0';
		while (true) {

			charN = pagina.substring(indexOfBegin, indexOfBegin + n).charAt(
					n - 1);
			if ('}' == charN) {
				break;
			}
			auxIndexEnd += charN;
			n++;
		}

		int lengthC = Integer.parseInt(auxIndexEnd);
		if (lengthC - value.length() < 0) {
			lengthC = value.length();
		}
		String spaces = new String(new char[lengthC - value.length()]);
		spaces = spaces.replace('\0', ' ');

		pagina = pagina.replace(tag + auxIndexEnd + "}", String.valueOf(value)
				+ spaces);

		return pagina;
	}

	private String dispacherEvent(String value, String meta_data_link) {
		try {
			ITarget target = (ITarget) Class.forName(meta_data_link)
					.getConstructor(new Class[0]).newInstance(new Object[0]);
			return target.dispacher(value);
		} catch (IllegalArgumentException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (SecurityException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (InstantiationException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (IllegalAccessException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (InvocationTargetException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (NoSuchMethodException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		} catch (ClassNotFoundException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return value;
		}
	}

	private String[] dispacherEvent(String value, String meta_data_link, char c) {
		try {
			ITarget target = (ITarget) Class.forName(meta_data_link)
					.getConstructor(new Class[0]).newInstance(new Object[0]);
			return target.dispacher(value, c);
		} catch (IllegalArgumentException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		}
	}

	private List<String[]> dispacherEvent(String value, String tag,
			String meta_data_link) {
		try {
			ITarget target = (ITarget) Class.forName(meta_data_link)
					.getConstructor(new Class[0]).newInstance(new Object[0]);
			return target.dispacher(value, tag);
		} catch (IllegalArgumentException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro ao invocar alvo META_DATA_LINK");
			e.printStackTrace();
			return null;
		}
	}
}
