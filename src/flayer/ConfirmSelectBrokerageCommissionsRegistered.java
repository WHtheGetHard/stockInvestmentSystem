package flayer;

import java.sql.SQLException;

import dlayer.SelectBrokerageCommissions;

public class ConfirmSelectBrokerageCommissionsRegistered {
	SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();

	public boolean isDuplicatePrimaryKey(int companyId, String startDay, String endDay) {
		boolean isDuplicated = false;

		int countNumber = 0;

		try {
			countNumber = selectBrokerageCommissions.selectCountFromPrimaryKey(companyId, startDay, endDay);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (countNumber == 1) {
			isDuplicated = true;
		} else {
			isDuplicated = false;
		}

		return isDuplicated;
	}

	public boolean isOverlap(int companyId, String startDay, String endDay) {
		boolean isOverlaped = false;

		int countNumber = 0;

		try {
			countNumber = selectBrokerageCommissions.selectCountTermOverlapFromPrimaryKey(companyId, startDay, endDay);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (countNumber == 1) {
			isOverlaped = true;
		} else {
			isOverlaped = false;
		}

		return isOverlaped;
	}
}
