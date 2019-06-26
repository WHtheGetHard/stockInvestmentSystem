package test;

import java.sql.SQLException;

import dlayer.InsertCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class TestInsertCapitalGainsTaxes {
	public static void main(String[] args) {
		InsertCapitalGainsTaxes insertCapitalGainsTaxes = new InsertCapitalGainsTaxes();

		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();
		// ------------execInsert()の確認------------
//		capitalGainsTaxes.setTaxRate("0.3");
//		capitalGainsTaxes.setStartDay("2019/06/25");
//		capitalGainsTaxes.setEndDay("2019/06/25");
//
//		capitalGainsTaxes.setTaxRate("0.3");
//		capitalGainsTaxes.setStartDay("2019/06/25");
//		capitalGainsTaxes.setEndDay("2019/06/26");
//
//		capitalGainsTaxes.setTaxRate("0.3");
//		capitalGainsTaxes.setStartDay("2019/06/24");
//		capitalGainsTaxes.setEndDay("2019/06/25");
//
		capitalGainsTaxes.setTaxRate("0.4");
		capitalGainsTaxes.setStartDay("2019/06/25");
		capitalGainsTaxes.setEndDay("2019/06/25");

		try {
			System.out.println(insertCapitalGainsTaxes.execInsert(capitalGainsTaxes));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// ------------execInsert()の確認------------
	}
}
