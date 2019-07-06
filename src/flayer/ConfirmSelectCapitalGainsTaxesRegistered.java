package flayer;

import java.sql.SQLException;

import dlayer.SelectCapitalGainsTaxes;

public class ConfirmSelectCapitalGainsTaxesRegistered {
	SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();

	public boolean isDuplicatePrimaryKey(String startDay, String endDay) {
		boolean isDuplicated = false;

		int countNumber = 0;

		try {
			countNumber = selectCapitalGainsTaxes.selectCountFromPrimaryKey(startDay, endDay);
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

	public boolean isOverlap(String startDay, String endDay) {
		boolean isOverlaped = false;

		int countNumber = 0;

		try {
			countNumber = selectCapitalGainsTaxes.selectCountTermOverLap(startDay, endDay);
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
