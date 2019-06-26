package test;

import java.sql.SQLException;

import dlayer.InsertConsumptionTaxes;
import fieldformat.ConsumptionTaxes;

public class TestInsertConsumptionTaxes {
	public static void main(String[] args) {
		InsertConsumptionTaxes insertConsumptionTaxes = new InsertConsumptionTaxes();

		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		// ---------------------execInsert()の確認---------------------
//		consumptionTaxes.setTaxRate("0.5");
//		consumptionTaxes.setStartDay("2016/06/25");
//		consumptionTaxes.setEndDay("2016/06/25");
//
//		consumptionTaxes.setTaxRate("0.5");
//		consumptionTaxes.setStartDay("2016/06/23");
//		consumptionTaxes.setEndDay("2016/06/25");
//
//		consumptionTaxes.setTaxRate("0.5");
//		consumptionTaxes.setStartDay("2016/06/25");
//		consumptionTaxes.setEndDay("2016/06/26");
//
		consumptionTaxes.setTaxRate("0.6");
		consumptionTaxes.setStartDay("2016/06/25");
		consumptionTaxes.setEndDay("2016/06/25");

		try {
			System.out.println(insertConsumptionTaxes.execInsert(consumptionTaxes));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// ---------------------execInsert()の確認---------------------
	}
}
