package br.com.cafebinario.iso8583;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ValueObjectFactory.ValueObjectFactory;
import br.com.cafebinario.iso8583.anotation.Destination;
import br.com.cafebinario.iso8583.config.LAYOUT_MASTER;
import br.com.cafebinario.iso8583.config.PDS_ELEMETS;
import br.com.cafebinario.iso8583.dao.DaoBase;
import br.com.cafebinario.iso8583.exception.DaoException;
import br.com.cafebinario.iso8583.exception.ParseException;
import br.com.cafebinario.iso8583.pojo.ExchangeMcFeeCollectionExt;
import br.com.cafebinario.iso8583.pojo.ExchangeMcPresentmentExt;

public class Iso8583LoaderMessageInfo {

	public static String FILE_NAME = "";
	public static String FULL_FILE_NAME = "";

	public static volatile String FILE_ID = "";
	public static volatile boolean loaderSGDB = false;

	private double original_amount;
	private String proc_code;
	private int function_code = 0;
	private Object object = null;

	public int getFunction_Code() {
		return function_code;
	}

	public void setFunction_Code(int function_code) {
		this.function_code = function_code;
	}

	public synchronized void loaderDataBase(DaoBase dao) throws DaoException,
			ParseException, IOException {

		if (dao == null) {
			return;
		}

		try {
			dao.execute(object, function_code);
			function_code = 0;
		} catch (IllegalArgumentException e) {
			throw new ParseException("erro ao executar "
					+ this.getClass().getName(), e);
		} catch (SecurityException e) {
			throw new ParseException("erro ao executar "
					+ this.getClass().getName(), e);
		}
	}

	public void processMessage(MessageInfo message, ConfigInfo info)
			throws Iso8583ParseException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			ClassNotFoundException, DaoException, ParseException {

		long pan = 0; // DE 2
		String date = ""; // DE 12
		String time = ""; // DE 12
		double reconcilitionAmount = 0.0;// DE 5
		int reconcilitionRateConv = 0; // DE 9
		String posDataCode = ""; // DE 22
		String originalAmountReconciliation = "0";// DE 53

		ExchangeMcPresentmentExt firstPres = null;
		ExchangeMcFeeCollectionExt feeCollect = null;
		
		if (message.getMTI_CODE() == 1240) {
			object = new ExchangeMcPresentmentExt();
			firstPres = (ExchangeMcPresentmentExt) object;
		}
		
		if (message.getMTI_CODE() == 1740) {
			object = new ExchangeMcFeeCollectionExt();
			feeCollect = (ExchangeMcFeeCollectionExt) object;
		}

		String desComPDS = LAYOUT_MASTER.instanceOf().getProperty("DE_PDS");

		String[] DeMapPds = desComPDS.split("[,]");

		int index = 2;
		int length = 0;
		int start = 0;

		String name = "";
		String lengthField = "";
		String type = "";
		// String mask = "";
		// String meta_data_link = "";
		String value = "";

		// String definitionMTI =
		// IPM_DESTINATION_TABLE.instanceOf().getProperty(
		// "MTI");
		// String MTIvalue = INSERT_DESTINATION_MASTER_TABLE.instanceOf()
		// .getProperty(definitionMTI.split(",")[0]);

		int lengthFlag = 0;
		while (index <= message.getBITMAP().length()) {
			char bit = message.getBITMAP().charAt(index - 1);

			if (bit == '1') {

				name = "";
				type = "";
				length = 0;
				// mask = "";
				// meta_data_link = "";

				String definiction = LAYOUT_MASTER.instanceOf().getProperty(
						String.valueOf(index));

				if ("".equals(definiction)) {
					throw new Iso8583ParseException("DE " + index
							+ " não encontrado no arquivo "
							+ info.getLayoutRelativePathFile() + ".");
				}

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
						}
					} /*
					 * else if (j == 3) { mask = estrutura[j]; } if (j == 4) {
					 * meta_data_link = estrutura[j]; }
					 */
					j++;
				}

				length = lengthFlag == 0 ? Integer.parseInt(lengthField)
						: Integer.parseInt(message.getMSG().substring(start,
								start + lengthFlag));

				/*
				 * int A = start + lengthFlag; int B = start + lengthFlag +
				 * length; int Delta = B - A;
				 * 
				 * 
				 * if(message.getMSG().length() < B){
				 * //System.out.println("	message.getMSG().length-" + start);
				 * //System.out.println("	start-" + start);
				 * //System.out.println("	lengthFlag-" + lengthFlag);
				 * //System.out.println("	length-" + length);
				 * 
				 * //System.out.println("	A-" + A); //System.out.println("	B-" + B);
				 * //System.out.println("	Delta-" + Delta);
				 * //System.out.println(message.getMSG()); }
				 */

				value = message.getMSG().substring(start + lengthFlag,
						start + lengthFlag + length);

				if (index == 2) {
					pan = Long.parseLong(value);
				}else if (index == 3){
					proc_code = value;
				}else if(index == 4){
					original_amount = Double.parseDouble(value) / 100.0000;
				}else if (index == 5) {
					reconcilitionAmount = Double.parseDouble(value) / 100.0000;
				} else if (index == 9) {
					reconcilitionRateConv = Integer.parseInt(value);
				} else if (index == 12) {
					date = value.substring(1, 6);
					time = value.substring(6, 12);
				} else if (index == 22) {
					posDataCode = value;
				} else if (index == 24) {
					function_code = Integer.parseInt(value);
					if (message.getMTI_CODE() == 1240) {
						firstPres.setCardNumber(pan);
						firstPres.setLocalDate(date);
						firstPres.setLocalTime(time);
						firstPres.setReconciliationAmount(reconcilitionAmount);
						firstPres
								.setReconciliationRateConv(reconcilitionRateConv);
						firstPres
								.setOriginalAmountRecon(originalAmountReconciliation);
						firstPres.setPosDataCode(posDataCode);
						// ((ExchangeMasterTable)object).setCardNumber(pan);
						// ((ExchangeMasterTable)object).setTransAmount(transAmount);
					}else if(message.getMTI_CODE() == 1740){
						feeCollect.setCardNumber(pan);
						feeCollect.setTransAmount(original_amount);
						feeCollect.setProcCode(proc_code);
						feeCollect.setReconciliationAmount(originalAmountReconciliation);
					} else {
						object = new ValueObjectFactory()
								.makeValueObject(getClassName(
										message.getMTI_CODE(), function_code));
					}
				}/*
				 * else if(index == 30){ originalAmountReconciliation =
				 * Double.parseDouble(value)/100.0000; }
				 */
				// PROBLEMA AQUI...
				Field[] fields = null;
				if (object != null)
					fields = object.getClass().getDeclaredFields();

				Destination destination = null;
				if (fields != null)
					for (Field field : fields) {
						destination = getDestination(field);

						if (field.getName().toUpperCase().equals("TRANSCODE"))
							setValueObject(destination, object, field,
									String.valueOf(message.getMTI_CODE()));

						if (field.getName().toUpperCase().equals("FILENAME")) {
							String fileName = message.getFileName()
									.substring(
											message.getFileName().lastIndexOf(
													'\\') == -1 ? message
													.getFileName().lastIndexOf(
															'/') + 1 : message
													.getFileName().lastIndexOf(
															'\\') + 1);
							setValueObject(destination, object, field, fileName);
							FILE_NAME = fileName;
							FULL_FILE_NAME = message.getFileName();
						}

						if (destination != null) {
							if (!destination.nativo()) {
								boolean notSetting = false;
								for (String de : DeMapPds) {
									if (index == Integer.parseInt(de)) {
										notSetting = true;
										break;
									}
								}

								if (!notSetting
										&& name.equals(destination.ipmName()))
									setValueObject(destination, object, field,
											value);

								for (String de : DeMapPds) {
									if (Integer.parseInt(de) == index) {
										String TAG = "";
										String LENGTH = "";
										String DATA = "";
										int current = 0;
										while (current < value.length()) {

											TAG = value.substring(current,
													current + 4);
											LENGTH = value.substring(
													current + 4, current + 7);
											DATA = value
													.substring(
															current + 7,
															current
																	+ 7
																	+ Integer
																			.parseInt(LENGTH));
											String PDSDesciptor = LAYOUT_MASTER
													.instanceOf().getProperty(
															TAG);

											if ("".equals(PDSDesciptor)) {
												throw new Iso8583ParseException(
														"PDS "
																+ TAG
																+ " não encontrado no arquivo "
																+ info.getLayoutRelativePathFile()
																+ ".");
											}

											String[] pdsElements = PDSDesciptor
													.split(",");

											String indexSubElementValue = PDS_ELEMETS
													.instanceOf().getProperty(
															pdsElements[0]);

											if (indexSubElementValue != null) {
												if (pdsElements[0]
														.equals(destination
																.ipmName()))
													setValueObject(destination,
															object, field, DATA);
											}
											current += Integer.parseInt(LENGTH) + 7;
										}
									}
								}
							}
						}
					}

				start = length
						+ (lengthFlag == 0 ? start + lengthFlag : start
								+ message.getMSG()
										.substring(start, start + lengthFlag)
										.length());
			}
			index++;
		}
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	private Destination getDestination(Field field) {
		return field.getAnnotation(Destination.class);
	}

	private void setValueObject(Destination destination, Object object,
			Field field, String value) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Method[] metodos = object.getClass().getMethods();

		for (Method method : metodos) {
			if (method.getName().equals(
					"set" + field.getName().substring(0, 1).toUpperCase()
							+ field.getName().substring(1))) {
				method.invoke(object, parse(destination.type(), value));
				break;
			}
		}
	}

	private String getClassName(int MTI, int function_code) {
		if (MTI == 1644) {
			if (function_code == 696) {
				return "br.com.cafebinario.iso8583.pojo.ExchangeMcFinanAddendum";
			}
			if (function_code == 697 || function_code == 695 || function_code == 693)
				return "br.com.cafebinario.iso8583.pojo.ControlFile";
			else if (function_code == 685 || function_code == 688)
				return "br.com.cafebinario.iso8583.pojo.ExchangeMcAdm";
			else if (function_code == 603)
				return "br.com.cafebinario.iso8583.pojo.ExchangeMcRetRequest";
		} else if (MTI == 1740) {
			return "br.com.cafebinario.iso8583.pojo.ExchangeMcFeeCollectionExt";
		} else if (MTI == 1442) {
			if (function_code == 450 || function_code == 451
					|| function_code == 453 || function_code == 454)
				return "br.com.cafebinario.iso8583.pojo.ExchangeMcChargebackExt";
		} else if (MTI == 1240) {
			return "br.com.cafebinario.iso8583.pojo.ExchangeMcPresentmentExt";
		}

		return null;
	}

	private Object parse(String type, String value) {
		Object back = null;
		try {
			if (value == null) {
				if ("NUMBER".equals(type)) {
					return 0;
				} else {
					return "";
				}
			}

			if ("NUMBER".equals(type)) {

				if (value.length() > 9) {
					back = Long.parseLong(value);
				} else {
					back = Integer.parseInt(value);
				}

			} else {
				back = value;
			}
		} catch (Exception e) {
			//System.out.println("type=" + type  + " value=" + value);
			e.printStackTrace();
		}

		return back;

	}
}
