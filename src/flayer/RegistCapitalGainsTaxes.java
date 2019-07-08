package flayer;

import java.sql.SQLException;

import dlayer.InsertCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;
import fieldformat.DisplayContentsCapitalGainsTaxes;

public class RegistCapitalGainsTaxes {
	public void execRegistration(DisplayContentsCapitalGainsTaxes displayContentsCapitalGainsTaxes) {
		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();

		capitalGainsTaxes.setTaxRate(displayContentsCapitalGainsTaxes.getCapitalGainsTax());
		capitalGainsTaxes.setStartDay(displayContentsCapitalGainsTaxes.getStartDate());
		capitalGainsTaxes.setEndDay(displayContentsCapitalGainsTaxes.getEndDate());

		InsertCapitalGainsTaxes insertCapitalGainsTaxes = new InsertCapitalGainsTaxes();
		ConfirmCapitalGainsTaxesRegistered confirmCapitalGainsTaxesRegistered = new ConfirmCapitalGainsTaxesRegistered();

		// TODO : confirm term is overlaped
		boolean isOverlaped = confirmCapitalGainsTaxesRegistered.isOverlap(
				displayContentsCapitalGainsTaxes.getStartDate(), displayContentsCapitalGainsTaxes.getEndDate());

		// TODO : if term is overlaped
		if (isOverlaped) {
			// TODO : decide specification
		} else {
			// TODO : else not overlaped, insert to capital_gains_taxes table
			try {
				insertCapitalGainsTaxes.execInsert(capitalGainsTaxes);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


	}
}
