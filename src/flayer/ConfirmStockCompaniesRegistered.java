package flayer;

import java.sql.SQLException;

import dlayer.SelectStockCompanies;

public class ConfirmStockCompaniesRegistered {
	SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

	public boolean isRegistered(String companyName) {
		boolean isRegistered = false;

		int countNumber = 0;
		try {
			countNumber = selectStockCompanies.selectCountFromCompanyName(companyName);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (countNumber == 1) {
			isRegistered = true;
		} else {
			isRegistered = false;
		}

		return isRegistered;
	}
}
