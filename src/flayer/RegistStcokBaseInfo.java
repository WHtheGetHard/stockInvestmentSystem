package flayer;

import java.sql.SQLException;

import dlayer.InsertCompanies;
import dlayer.InsertStcokBaseInfo;
import dlayer.SelectCompanies;
import fieldformat.Companies;
import fieldformat.CompanyStockBaseInfo;
import fieldformat.StockBaseInfo;

public class RegistStcokBaseInfo {
	public void execRegistration(CompanyStockBaseInfo companyStockBaseInfo) {
		Companies companies = new Companies();
		StockBaseInfo stockBaseInfo = new StockBaseInfo();

		companies.setName(companyStockBaseInfo.getCompanyName());

		stockBaseInfo.setSecuritiesCode(companyStockBaseInfo.getSecuritiesCode());
		stockBaseInfo.setMarket(companyStockBaseInfo.getMarket());

		InsertCompanies insertCompanies = new InsertCompanies();
		int insertNumberCompanies = 0;

		try {
			insertNumberCompanies = insertCompanies.execInsertOnlyName(companies.getName());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		if (insertNumberCompanies != 0) {
			SelectCompanies selectCompanies = new SelectCompanies();

			try {
				companies = selectCompanies.selectFromName(companies.getName());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else {
			return;
		}

		if (companies != null) {
			InsertStcokBaseInfo insertStcokBaseInfo = new InsertStcokBaseInfo();
			int insertNumberStockBaseInfo = 0;

			stockBaseInfo.setId(companies.getId());

			try {
				insertNumberStockBaseInfo = insertStcokBaseInfo.execInsert(stockBaseInfo);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else {
			return;
		}

	}
}
