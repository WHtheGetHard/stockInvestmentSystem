package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectBrokerageCommissions;
import fieldformat.BrokerageCommissions;

public class ExecSelectAllRecordBrokerageCommissions {

	public ArrayList<BrokerageCommissions> exec() {
		SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();
		ArrayList<BrokerageCommissions> brokerageCommissionsList = new ArrayList<BrokerageCommissions>();

		try {
			brokerageCommissionsList = selectBrokerageCommissions.selectAllRecord();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return brokerageCommissionsList;
	}
}
