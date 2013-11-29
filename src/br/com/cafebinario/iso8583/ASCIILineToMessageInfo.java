package br.com.cafebinario.iso8583;

public class ASCIILineToMessageInfo {

	public MessageInfo parse(String line) {
		MessageInfo info = new MessageInfo();
		String[] fields = line.split("[\\[\\]]");
		
		/*for (String string : fields) {
			//System.out.println(string);
		}*/
		
		info.setLENGTH(Integer.parseInt(fields[1]));
		info.setMTI_CODE(Integer.parseInt(fields[3]));
		info.setBITMAP(fields[5]);
		info.setMSG(fields[7]);
		
		return info;
	}

}
