package flayer;

import java.sql.SQLException;

import dlayer.SelectCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class ConfirmCapitalGainsTaxes {
	SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();

	public boolean confirmExists(String startDay, String endDay) {
		boolean alreadyRegistered = false;

		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();
		try {
			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromPrimaryKey(startDay, endDay);

			if (capitalGainsTaxes.getTaxRate() != null) {
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

		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();
		try {
			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromBetween(day);

			if (capitalGainsTaxes.getTaxRate() != null) {
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
