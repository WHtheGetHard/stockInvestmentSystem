package flayer;

import java.sql.SQLException;

import dlayer.SelectConsumptionTaxes;

public class ConfirmConsumptionTaxesRegistered {
	SelectConsumptionTaxes selectConsumptionTaxes = new SelectConsumptionTaxes();

	public boolean isDuplicatePrimaryKey(String startDay, String endDay) {
		boolean isDuplicated = false;

		int countNumber = 0;

		try {
			countNumber = selectConsumptionTaxes.selectCountFromPrimaryKey(startDay, endDay);
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
			countNumber = selectConsumptionTaxes.selectCountTermOverLap(startDay, endDay);
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
