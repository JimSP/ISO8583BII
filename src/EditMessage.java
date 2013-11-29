import br.com.cafebinario.iso8583.ConfigInfo;
import br.com.cafebinario.iso8583.Iso8583ParseIPMFile;
import br.com.cafebinario.iso8583.MessageInfo;


public class EditMessage {
	private static EditMessage editMessage;
	
	Iso8583ParseIPMFile iso = new Iso8583ParseIPMFile();
	
	public static void main(String[] args){
		if(editMessage == null){
			editMessage = new EditMessage();
			editMessage.execute();
		}else{
			//System.out.println("Aguarde o termino da execução...");
		}
	}

	private void execute() {
		ConfigInfo info = new ConfigInfo();
		MessageInfo message = new MessageInfo();
		try {
			iso.processMessage(message, System.out, info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
