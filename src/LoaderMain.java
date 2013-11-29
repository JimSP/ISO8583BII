import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.ASCIILineToMessageInfo;
import br.com.cafebinario.iso8583.ConfigInfo;
import br.com.cafebinario.iso8583.Iso8583LoaderMessageInfo;
import br.com.cafebinario.iso8583.Iso8583ParseIPMFile;
import br.com.cafebinario.iso8583.MessageInfo;
import br.com.cafebinario.iso8583.dao.SQL_LOADER_CTL;
import br.com.cafebinario.iso8583.database.DataBase;
import br.com.cafebinario.iso8583.threads.Processador;
import br.com.cafebinario.properties.AppProperties;

public class LoaderMain {

	public static void main(String[] args) {

		Connection connection = null;

		AppProperties.instanceOf().setPathFile("App.Properties");
		AppProperties.instanceOf().load();

		Iso8583ParseIPMFile iso = new Iso8583ParseIPMFile();
		PrintStream outRelat = null;
		PrintStream outFile = null;
		RandomAccessFile in = null;
		PrintStream pagina = null;
		BufferedWriter bufferCTL = null;
		try {
			in = new RandomAccessFile(args[0],"r");
			//in = new FileInputStream(args[0]);

			boolean procASCII = Boolean.parseBoolean(args[args.length - 2]);
			if (procASCII)
				outFile = new PrintStream(args[0] + "_ASCII");

			ConfigInfo config = new ConfigInfo();

			UtilMain.tratarInicio(args, config, outFile, in, outRelat, iso,
					pagina, procASCII);

			// //////////////////////////////////////
			// LOADER
			// /////////////////////////////////////

			// SETAR COMO TRUE PARA GERAR ARQUIVO _PROCESSADO
			boolean activeLoader = Boolean.parseBoolean(args[13]);
			if (activeLoader) {
				if (Iso8583LoaderMessageInfo.loaderSGDB) {
					connection = DataBase.instanceOf().getConnection();
					connection.setAutoCommit(false);
				}

				if (config.isPrintSql()) {
					FileReader asciiReader = null;
					BufferedReader asciiBuffer = null;
					try {
						asciiReader = new FileReader(args[0] + "_ASCII");
						asciiBuffer = new BufferedReader(asciiReader);

						long commitRowsQtd = 0;
						long commitRowsParam = Long.parseLong(AppProperties
								.instanceOf().getProperty("QTD_COMMIT_ROWS"));

						int i = 0;
						while (asciiBuffer.ready()) {
							// long time = System.nanoTime();
							String asciiLine = asciiBuffer.readLine();

							ASCIILineToMessageInfo parserAscii = new ASCIILineToMessageInfo();
							MessageInfo info = parserAscii.parse(asciiLine);
							info.setFileName(args[0]);

							Processador proc = new Processador();
							proc.setInfo(info);
							proc.setConfig(config);
							proc.setConnection(connection);

							if (Iso8583LoaderMessageInfo.loaderSGDB)
								proc.run();
							else
								proc.runNoMultiThread();

							commitRowsQtd++;
							if (commitRowsQtd == commitRowsParam
									&& connection != null) {
								connection.commit();
								commitRowsQtd = 0;
							}
							i++;
						}

						if (connection != null)
							connection.commit();

						//System.out.println("[" + System.currentTimeMillis()
								+ "] ARQUIVO CARREGADO: " + args[0]);

						FileWriter fw = new FileWriter(new File(args[0]
								+ ".CTL"), false);
						bufferCTL = new BufferedWriter(fw);
						bufferCTL.write(SQL_LOADER_CTL.bindParameter(args[0]
								+ "_PROCESSADO", args[0] + "_PROCESSADO.BAD",
								args[0] + "_PROCESSADO.DIS"));

					} catch (FileNotFoundException e) {
						e.printStackTrace();
						if (connection != null)
							connection.rollback();
					} catch (IOException e) {
						e.printStackTrace();
						if (connection != null)
							connection.rollback();
					} finally {
						if (asciiReader != null) {
							try {
								asciiReader.close();
							} catch (IOException e) {
								e.printStackTrace();
								System.out
										.println("["
												+ System.currentTimeMillis()
												+ "] Não foi possivel fechar arquivo ASCII!");
							}

							if (bufferCTL != null) {
								bufferCTL.close();
							}
						}

						if (asciiBuffer != null) {
							try {
								asciiBuffer.close();
							} catch (IOException e) {
								e.printStackTrace();
								System.out
										.println("["
												+ System.currentTimeMillis()
												+ "] Não foi possivel fechar buffer ASCII!");
							}
						}

						if (connection != null) {
							connection.close();
						}
					}
				}
			}

		} catch (Exception e) {
			try {
				if (connection != null)
					if (!connection.isClosed())
						connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//System.out.println("[" + System.currentTimeMillis()
					+ "] Erro durante processamento do arquivo!");
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					//System.out.println("[" + System.currentTimeMillis()
							+ "] Não foi possivel fechar arquivo de entrada!");
					e.printStackTrace();
				}

			if (outFile != null)
				outFile.close();
			if (outRelat != null)
				outRelat.close();
		}
	}
}