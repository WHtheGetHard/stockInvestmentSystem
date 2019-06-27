package flayer;

import java.sql.SQLException;

import dlayer.SelectBrokerageCommissions;
import fieldformat.BrokerageCommissions;

public class ConfirmBrokerageCommissions {
	public boolean confirmExists(int campanyId, String startDay, String endDay) {
		boolean alreadyRegistered = false;

		SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();

		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();

		try {
			brokerageCommissions = selectBrokerageCommissions.selectFromPrimaryKey(campanyId, startDay, endDay);

			if (brokerageCommissions.getCampanyId() != 0) {
				alreadyRegistered = true;
			} else {
				alreadyRegistered = false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return alreadyRegistered;
	}
}
