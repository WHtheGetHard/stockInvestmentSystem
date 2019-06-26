package test;

import java.sql.SQLException;

import dlayer.InsertStockCompanies;
import fieldformat.StockCompanies;

public class TestInsertStockCompanies {
	public static void main(String[] args) {
		InsertStockCompanies insertStockCompanies = new InsertStockCompanies();

		StockCompanies stockCompanies = new StockCompanies();
		// -----------------------execInsert()の確認-----------------------
		stockCompanies.setComapnyName("HY");

		try {
			System.out.println(insertStockCompanies.execInsert(stockCompanies));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// -----------------------execInsert()の確認-----------------------
	}
}
