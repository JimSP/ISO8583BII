import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

import br.com.cafebinario.iso8583.ConfigInfo;
import br.com.cafebinario.iso8583.Iso8583ParseIPMFile;
import br.com.cafebinario.iso8583.config.FORMAT;
import br.com.cafebinario.iso8583.config.INSERT_DESTINATION_MASTER_TABLE;
import br.com.cafebinario.iso8583.config.IPM_DESTINATION_TABLE;
import br.com.cafebinario.iso8583.config.LAYOUT_MASTER;
import br.com.cafebinario.iso8583.config.PDS_ELEMETS;
import br.com.cafebinario.iso8583.config.SUB_ELEMENTS;

public class UtilMain {

	public static void tratarInicio(String[] args, ConfigInfo config,
			PrintStream outFile, RandomAccessFile in, PrintStream outRelat,
			Iso8583ParseIPMFile iso, PrintStream outPagina, boolean procASCII)
			throws Exception {
		if (args.length < 1) {
			System.out
					.println("["
							+ System.currentTimeMillis()
							+ "] o arquivo de origem deve ser informado como parametro...");
			System.exit(-1);
		}

		try {
			config.setPrintName(Boolean.parseBoolean(args[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintLength(Boolean.parseBoolean(args[2]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintType(Boolean.parseBoolean(args[3]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintMask(Boolean.parseBoolean(args[4]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintMetaDataLink(Boolean.parseBoolean(args[5]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintData(Boolean.parseBoolean(args[6]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintSubFieldName(Boolean.parseBoolean(args[7]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintSubFieldMetaDataLink(Boolean.parseBoolean(args[8]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintSubFieldTag(Boolean.parseBoolean(args[9]));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			config.setPrintSubFieldLength(Boolean.parseBoolean(args[10]));
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE SubFieldLength "
					+ config.isPrintSubFieldLength());
			e.printStackTrace();
		}

		try {
			config.setPrintSubFieldData(Boolean.parseBoolean(args[11]));
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE PrintSubFieldData "
					+ config.isPrintSubFieldData());
			e.printStackTrace();
		}

		try {
			config.setPrintMSG(Boolean.parseBoolean(args[12]));
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE PrintMSG "
					+ config.isPrintMSG());
			e.printStackTrace();
		}

		try {
			config.setPrintSql(Boolean.parseBoolean(args[13]));
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE PrintSQL "
					+ config.isPrintSql());
			e.printStackTrace();
		}

		try {
			if (args[14] != null) {
				if (!"".equals(args[14])) {
					config.setLayoutRelativePathFile(args[14]);
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE LayoutRelativePathFile"
					+ config.getLayoutRelativePathFile());
			e.printStackTrace();
		}

		try {
			if (args[15] != null) {
				if (!"".equals(args[15])) {
					config.setInsertDestinationTable(args[15]);
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE INSERT DESTINATION TABLE"
					+ config.getLayoutRelativePathFile());
			e.printStackTrace();
		}

		try {
			if (args[16] != null) {
				if (!"".equals(args[16])) {
					config.setIpmDestinationTable(args[16]);
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE IPM DESTINATION TABLE"
					+ config.getLayoutRelativePathFile());
			e.printStackTrace();
		}

		try {
			if (args[17] != null) {
				if (!"".equals(args[17])) {
					config.setPrintRelat(Boolean.parseBoolean(args[17]));
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE PRINT RELAT "
					+ config.isPrintRelat());
			e.printStackTrace();
		}

		try {
			if (args[18] != null) {
				if (!"".equals(args[18])) {
					config.setPrintPagina(Boolean.parseBoolean(args[18]));
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE PRINT PAG "
					+ config.isPrintPagina());
			e.printStackTrace();
		}

		try {
			if (args[19] != null) {
				if (!"".equals(args[19])) {
					config.setDia(Integer.parseInt(args[19]));
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE DIA " + config.getDia());
			e.printStackTrace();
		}

		try {
			if (args[20] != null) {
				if (!"".equals(args[20])) {
					config.setMes(Integer.parseInt(args[20]));
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE MES " + config.getMes());
			e.printStackTrace();
		}

		try {
			if (args[21] != null) {
				if (!"".equals(args[21])) {
					config.setAno(Integer.parseInt(args[21]));
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE ANO " + config.getAno());
			e.printStackTrace();
		}
		
		try {
			if (args != null) {
				if (!"".equals(args[args.length - 1])) {
					config.setTipoArquivo(args[args.length - 1]);
				}
			}
		} catch (Exception e) {
			//System.out.println("VALOR PADRAO DE ANO " + config.getAno());
			e.printStackTrace();
		}

		LAYOUT_MASTER.instanceOf().setPathFile(
				config.getLayoutRelativePathFile());
		LAYOUT_MASTER.instanceOf().load();

		SUB_ELEMENTS.instanceOf().setPathFile("SUB_ELEMENTS");
		SUB_ELEMENTS.instanceOf().load();

		FORMAT.instanceOf().setPathFile("FORMAT");
		FORMAT.instanceOf().load();

		INSERT_DESTINATION_MASTER_TABLE.instanceOf().setPathFile(
				config.getInsertDestinationTable());
		INSERT_DESTINATION_MASTER_TABLE.instanceOf().load();

		IPM_DESTINATION_TABLE.instanceOf().setPathFile(
				config.getIpmDestinationTable());
		IPM_DESTINATION_TABLE.instanceOf().load();

		PDS_ELEMETS.instanceOf().setPathFile(config.getIpmPdsElements());
		PDS_ELEMETS.instanceOf().load();

		config.setFull_path(args[0]);

		if (config.isPrintRelat()) {
			outRelat = new PrintStream(args[0] + "_RELAT");
			iso.setOutRelat(outRelat);
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Relatorio: " + args[0] + "_RELAT");
		}

		if (config.isPrintPagina()) {
			outPagina = new PrintStream(args[0] + "_PAG");
			
			iso.setOutPagina(outPagina);
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Relatorio: " + args[0] + "_PAG");
		}

		iso.setDate(config.getDia(), config.getMes(), config.getAno());
		iso.setIn(in);
		iso.setOutFile(outFile);
		iso.processFile(config);

		if (config.isPrintMSG()) {
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Mensagens: " + args[0] + "_ASCII");
		}
	}
}