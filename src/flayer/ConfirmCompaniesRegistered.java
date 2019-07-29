package flayer;

import java.sql.SQLException;

import dlayer.SelectCompanies;

public class ConfirmCompaniesRegistered {
	SelectCompanies selectCompanies = new SelectCompanies();

	public boolean isRegistered(String name) {
		boolean isRegistered = false;

		int countNumber = 0;

		try {
			countNumber = selectCompanies.selectCountName(name);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (countNumber == 0) {
			isRegistered = false;
		} else {
			isRegistered = true;
		}

		return isRegistered;
	}
}
