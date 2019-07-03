package test;

import java.sql.SQLException;

import dlayer.SelectStockCompanies;
import fieldformat.StockCompanies;

public class TestSelectStockCompanies {
	public static void main(String[] args) {
		// stock_companies table has two records that value are like bellow
		// id:9 company_name:ABC inc.
		// id:10 company_name:XYZ inc.


		SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

		StockCompanies stockCompanies = new StockCompanies();


		// START----------confrim selectFromId(int id) method ----------START

//		int id = 8; // null
//		int id = 9; // get record
//		int id = 10; // get record
//		int id = 11; // null
//
//		try {
//			stockCompanies = selectStockCompanies.selectFromId(id);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("id : " + stockCompanies.getId());
//		System.out.println("company_name : " + stockCompanies.getComapnyName());

		// END----------confrim selectFromId(int id) method ----------END


		// START----------confrim selectCountFromCompanyName(String companyName) method ----------START
//		String companyName = ""; // 0
//		String companyName = null; // 0
//		String companyName = "ABC inc."; // 1
//		String companyName = "XYZ inc."; // 1
		String companyName = "ABC co."; // 0

		try {
			System.out.println("record number is : " + selectStockCompanies.selectCountFromCompanyName(companyName));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// END----------confrim selectCountFromCompanyName(String companyName) method ----------END
	}
}
