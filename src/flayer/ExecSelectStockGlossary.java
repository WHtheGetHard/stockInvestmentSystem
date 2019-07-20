package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectStockGlossary;
import fieldformat.StockGlossary;

public class ExecSelectStockGlossary {

	public ArrayList<StockGlossary> execSelectFromsection(String selectedSection) {
		ArrayList<StockGlossary> selectStockGlossaryList
			= new ArrayList<StockGlossary>();

		SelectStockGlossary selectStockGlossary = new SelectStockGlossary();

		int section = Integer.parseInt(selectedSection);

		try {
			selectStockGlossaryList = selectStockGlossary.selectFromSection(section);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return selectStockGlossaryList;
	}
}
