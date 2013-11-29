package ValueObjectFactory;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cafebinario.iso8583.dao.DaoBase;
import br.com.cafebinario.iso8583.dao.InsertControlFile;
import br.com.cafebinario.iso8583.dao.InsertExchangeMasterTable;
import br.com.cafebinario.iso8583.dao.InsertExchangeMcChargeBackExt;
import br.com.cafebinario.iso8583.dao.InsertMcFeeCollectExt;

public class DaoFactory {
	private static DaoFactory thisInstance = new DaoFactory();
	public static DaoFactory instanceOf(){
		return DaoFactory.thisInstance;
	}
	
	public DaoBase getDao(int MTI_CODE) {
		try {
			if(MTI_CODE == 1644)
				return new InsertControlFile();
			else if(MTI_CODE == 1240)
				return new InsertExchangeMasterTable();
			else if(MTI_CODE == 1442)
				return new InsertExchangeMcChargeBackExt();
			else if(MTI_CODE == 1740)
				return new InsertMcFeeCollectExt();
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
