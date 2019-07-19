package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectStockGlossary;
import fieldformat.StockGlossary;

public class TestSelectStockGlossary {
	// stock_glossary table has a record
	// id:1, section:1, word:株
	// id:2, section:1, word:出資
	// id:3, section:1, word:上場

	public static void main(String[] args) {
		SelectStockGlossary selectStockGlossary = new SelectStockGlossary();

		// START----------- comfirm selectFromPrimaryKey(id) method -----------START
//		int id = 0; // null
//		int id = 1;
//		int id = 2;
//		int id = 4; // null
//
//		StockGlossary stockGlossary = new StockGlossary();
//		try {
//			stockGlossary = selectStockGlossary.selectFromPrimaryKey(id);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		System.out.println(stockGlossary.getWord());
		// END----------- comfirm selectFromPrimaryKey(id) method -----------END


		// START----------- comfirm selectFromSection(section) method -----------START
//		int section = 0; // null
//		int section = 1;
		int section = 2; // null

		ArrayList<StockGlossary> stockGlossaryList = new ArrayList<StockGlossary>();

		try {
			stockGlossaryList = selectStockGlossary.selectFromSection(section);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for (int i = 0; i < stockGlossaryList.size(); i++) {
			System.out.println(stockGlossaryList.get(i).getWord());
		}

		// END----------- comfirm selectFromSection(section) method -----------END
	}
}
