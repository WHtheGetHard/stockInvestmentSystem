package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectStockCompanies;
import fieldformat.StockCompanies;

public class TestSelectStockCompanies {
	public static void main(String[] args) {
		SelectStockCompanies selectStockCompanies = new SelectStockCompanies();
		try {
			//-----------------selectFromIdメソッドの確認-----------------
//			StockCompanies stockCompanies = new StockCompanies();

//			 int id = 1;
//			 int id = 2;
//			 int id = 3;
//			 char id = '1';
//			char id = '１';
//			stockCompanies = selectStockCompanies.selectFromId(id);
//
//			System.out.println("id : " + stockCompanies.getId());
//			System.out.println("company_name : " + stockCompanies.getComapnyName());

			//-----------------selectFromIdメソッドの確認-----------------


			//-----------------selecFromCompanyNameメソッドの確認-----------------
			ArrayList<StockCompanies> stockCompanies = new ArrayList<StockCompanies>();
//			String companyName = "楽天";
//			String companyName = "野村";
//			String companyName = "";
//			String companyName = "大塚";
//			String companyName = null;
//			String companyName = "重複";
//
//			stockCompanies = selectStockCompanies.selecFromCompanyName(companyName);
//
//			int stockCompaniesNumber = stockCompanies.size();
//
//			for (int i = 0; i < stockCompaniesNumber; i++) {
//				System.out.println("id : " + stockCompanies.get(i).getId());
//				System.out.println("company_name : " + stockCompanies.get(i).getComapnyName());
//			}
//			//-----------------selecFromCompanyNameメソッドの確認-----------------



			// --------------------selectCountFromCompanyNameメソッドの確認--------------------

//			String companyName = "楽天";
//			String companyName = "野村";
//			String companyName = "";
//			String companyName = "大塚";
//			String companyName = null;
			String companyName = "重複";

			int count = selectStockCompanies.selectCountFromCompanyName(companyName);

			System.out.println(count);


			// --------------------selectCountFromCompanyNameメソッドの確認--------------------
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
