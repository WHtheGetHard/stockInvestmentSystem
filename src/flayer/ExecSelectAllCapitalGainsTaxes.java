package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class ExecSelectAllCapitalGainsTaxes {

	public ArrayList<CapitalGainsTaxes> exec() {
		SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();
		ArrayList<CapitalGainsTaxes> capitalGainsTaxesList = new ArrayList<CapitalGainsTaxes>();

		try {
			capitalGainsTaxesList = selectCapitalGainsTaxes.selectAllRecord();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return capitalGainsTaxesList;
	}
}
