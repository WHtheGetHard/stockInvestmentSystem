package flayer;

import java.sql.SQLException;

import dlayer.SelectConsumptionTaxes;
import fieldformat.ConsumptionTaxes;

public class ConfirmConsumptionTaxes {
	SelectConsumptionTaxes selectConsumptionTaxes = new SelectConsumptionTaxes();

	public boolean confirmExists(String startDay, String endDay) {
		boolean alreadyRegistered = false;

		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		try {
			consumptionTaxes = selectConsumptionTaxes.selectFromPrimaryKey(startDay, endDay);

			if (consumptionTaxes.getTaxRate() != null) {
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

	public boolean confirmOverlap(String day) {
		boolean isOverlaped = false;

		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		try {
			consumptionTaxes = selectConsumptionTaxes.selectFromBetween(day);

			if (consumptionTaxes.getTaxRate() != null) {
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
