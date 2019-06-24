package flayer;

import java.sql.SQLException;

import dlayer.SelectStockCompanies;

public class ConfirmStockCompanies {
	SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

	public boolean confirmExists(String companyName) {
		boolean alreadyRegistered = false;

		try {
			int resultSetNumber = selectStockCompanies.selecFromCompanyName(companyName).size();

			if (resultSetNumber > 0) {
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
}
