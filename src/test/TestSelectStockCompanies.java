package test;

import java.sql.SQLException;

import dlayer.SelectStockCompanies;
import fieldformat.StockCompanies;

public class TestSelectStockCompanies {
	public static void main(String[] args) {
		SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

		StockCompanies stockCompanies = new StockCompanies();

//		int id = 1;
//		int id = 2;
//		int id = 3;
//		char id = '1';
		char id = '１';

		try {
			stockCompanies = selectStockCompanies.selectFromId(id);

			System.out.println("id : " + stockCompanies.getId());
			System.out.println("company_name : " + stockCompanies.getComapnyName());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
