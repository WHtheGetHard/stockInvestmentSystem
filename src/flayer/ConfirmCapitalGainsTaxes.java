package flayer;

import java.sql.SQLException;

import dlayer.SelectCapitalGainsTaxes;

public class ConfirmCapitalGainsTaxes {
	SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();

	public boolean confirmExists(String startDay, String endDay) {
		boolean alreadyRegistered = false;

		try {
			int primaryKeyDuplicateNumber = selectCapitalGainsTaxes.selectCountFromPrimaryKey(startDay, endDay);

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
			int termOverLapNumber = selectCapitalGainsTaxes.selectCountTermOverLap(startDay, endDay);

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
