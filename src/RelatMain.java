import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

import br.com.cafebinario.iso8583.ConfigInfo;
import br.com.cafebinario.iso8583.Iso8583ParseIPMFile;
import br.com.cafebinario.properties.AppProperties;


public class RelatMain {

	public static void main(String[] args) {
		AppProperties.instanceOf().setPathFile("App.Properties");
		AppProperties.instanceOf().load();

		Iso8583ParseIPMFile iso = new Iso8583ParseIPMFile();
		PrintStream outRelat = null;
		PrintStream outFile = null;
		PrintStream outPagina = null;
		RandomAccessFile in = null;

		try {
			
			in = new RandomAccessFile(args[0], "r");
			outFile = new PrintStream(args[0] + "_ASCII");

			ConfigInfo config = new ConfigInfo();
			UtilMain.tratarInicio(args, config, outFile, in, outRelat, iso, outPagina, true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
