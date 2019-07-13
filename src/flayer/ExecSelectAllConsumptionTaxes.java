package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectConsumptionTaxes;
import fieldformat.ConsumptionTaxes;

public class ExecSelectAllConsumptionTaxes {

	public ArrayList<ConsumptionTaxes> exec() {
		SelectConsumptionTaxes selectConsumptionTaxes = new SelectConsumptionTaxes();
		ArrayList<ConsumptionTaxes> consumptionTaxesList = new ArrayList<ConsumptionTaxes>();

		try {
			consumptionTaxesList = selectConsumptionTaxes.selectAllRecord();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return consumptionTaxesList;
	}
}
