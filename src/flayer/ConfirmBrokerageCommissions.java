package flayer;

import java.sql.SQLException;

import dlayer.SelectBrokerageCommissions;

public class ConfirmBrokerageCommissions {
	SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();

	public boolean confirmExists(int campanyId, String startDay, String endDay) {
		boolean alreadyRegistered = false;

		try {
			int primaryKeyDuplicateNumber = selectBrokerageCommissions.selectCountFromPrimaryKey(campanyId, startDay, endDay);

			if (primaryKeyDuplicateNumber > 0) {
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

	public boolean confirmOverlap(int campanyId, String startDay, String endDay) {
		boolean isOverlaped = false;

		try {
			int termOverLapNumber = selectBrokerageCommissions.selectCountTermOverLap(campanyId, startDay, endDay);

			if (termOverLapNumber > 0) {
				isOverlaped = true;
			} else {
				isOverlaped = false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return isOverlaped;
	}
}
