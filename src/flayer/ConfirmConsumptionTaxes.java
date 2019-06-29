package flayer;

import java.sql.SQLException;

import dlayer.SelectConsumptionTaxes;

public class ConfirmConsumptionTaxes {
	SelectConsumptionTaxes selectConsumptionTaxes = new SelectConsumptionTaxes();

	public boolean confirmExists(String startDay, String endDay) {
		boolean alreadyRegistered = false;

		try {
			int primaryKeyDuplicateNumber = selectConsumptionTaxes.selectCountFromPrimaryKey(startDay, endDay);

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

	public boolean confirmOverlap(String startDay, String endDay) {
		boolean isOverlaped = false;

		try {
			int termOverLapNumber = selectConsumptionTaxes.selectCountTermOverLap(startDay, endDay);

			if (termOverLapNumber > 0) {
				isOverlaped = true;
			} else {
				isOverlaped = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isOverlaped;
	}
}
