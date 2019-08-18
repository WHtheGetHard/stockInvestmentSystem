package flayer;


import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectCompanies;
import dlayer.SelectStcokBaseInfo;
import fieldformat.Companies;
import fieldformat.CompanyStockBaseInfo;
import fieldformat.StockBaseInfo;

public class ExecSearchCompanyInfo {
	public ArrayList<CompanyStockBaseInfo> searchFromName(String companyName) {
		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();

		SelectCompanies selectCompanies = new SelectCompanies();
		ArrayList<Companies> companiesList = new ArrayList<Companies>();
		try {
			companiesList = selectCompanies.selectFromAmbiguous(companyName);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (companiesList.size() > 0) {

			for (int i = 0; i < companiesList.size(); i++) {
				SelectStcokBaseInfo selectStcokBaseInfo = new SelectStcokBaseInfo();
				StockBaseInfo stockBaseInfo = new StockBaseInfo();

				try {
					stockBaseInfo = selectStcokBaseInfo.selectFromId(companiesList.get(i).getId());
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
				companyStockBaseInfo.setCompanyName(companiesList.get(i).getName());
				companyStockBaseInfo.setSecuritiesCode(stockBaseInfo.getSecuritiesCode());
				companyStockBaseInfo.setMarket(stockBaseInfo.getMarket());

			companyStockBaseInfoList.add(companyStockBaseInfo);
			}


		}



		return companyStockBaseInfoList;
	}

	public CompanyStockBaseInfo searchFromSecuritiesCode(String securitiesCode) {
		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

		SelectStcokBaseInfo selectStcokBaseInfo = new SelectStcokBaseInfo();
		StockBaseInfo stockBaseInfo = new StockBaseInfo();

		try {
			stockBaseInfo = selectStcokBaseInfo.selectFromSecuritiesCode(securitiesCode);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (stockBaseInfo != null) {
			SelectCompanies selectCompanies = new SelectCompanies();
			Companies companies = new Companies();

			try {
				companies = selectCompanies.selectFromId(stockBaseInfo.getId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			if (companies != null) {
				companyStockBaseInfo.setCompanyName(companies.getName());
				companyStockBaseInfo.setSecuritiesCode(stockBaseInfo.getSecuritiesCode());
				companyStockBaseInfo.setMarket(stockBaseInfo.getMarket());
			}
		}

		return companyStockBaseInfo;
	}

	public ArrayList<CompanyStockBaseInfo> searchFromMarket(String market) {
		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();

		SelectStcokBaseInfo selectStcokBaseInfo = new SelectStcokBaseInfo();
		ArrayList<StockBaseInfo> stockBaseInfoList = new ArrayList<StockBaseInfo>();

		try {
			stockBaseInfoList = selectStcokBaseInfo.selectFromMarket(market);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (stockBaseInfoList.size() > 0) {
			for (int i = 0; i < stockBaseInfoList.size(); i++) {
				SelectCompanies selectCompanies = new SelectCompanies();

				Companies companies = new Companies();

				try {
					companies = selectCompanies.selectFromId(stockBaseInfoList.get(i).getId());
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				if (companies != null) {
					CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

					companyStockBaseInfo.setCompanyName(companies.getName());
					companyStockBaseInfo.setSecuritiesCode(stockBaseInfoList.get(i).getSecuritiesCode());
					companyStockBaseInfo.setMarket(stockBaseInfoList.get(i).getMarket());

					companyStockBaseInfoList.add(companyStockBaseInfo);
				}
			}
		}

		return companyStockBaseInfoList;
	}
}
