package test;

import java.sql.SQLException;

import dlayer.SelectConsumptionTaxes;
import fieldformat.ConsumptionTaxes;

public class TestSelectConsumptionTaxes {
	public static void main(String[] args) {
		SelectConsumptionTaxes selectConsumptionTaxes = new SelectConsumptionTaxes();

		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		// --------------------selectFromPrimaryKey()の確認--------------------
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";
//
//		String startDay = "1999/04/00";
//		String endDay = "2000/03/31";
//
//		String startDay = "1999/04/02";
//		String endDay = "2000/03/31";
//
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/30";
//
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/32";
//
//		String startDay = "";
//		String endDay = "2000/03/30";
//
//		String startDay = "1999/04/01";
//		String endDay = "";
//
//		String startDay = "";
//		String endDay = "";
//
//		String startDay = null;
//		String endDay = "2000/03/30";
//
//		String startDay = "1999/04/01";
//		String endDay = null;
//
//		String startDay = null;
//		String endDay = null;
//
//		try {
//			consumptionTaxes = selectConsumptionTaxes.selectFromPrimaryKey(startDay, endDay);
//
//			System.out.println("tax_rate : " + consumptionTaxes.getTaxRate());
//			System.out.println("start_day : " + consumptionTaxes.getStartDay());
//			System.out.println("end_day : " + consumptionTaxes.getEndDay());
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
		// --------------------selectFromPrimaryKey()の確認--------------------

		// --------------------selectFromBetween()の確認--------------------
//		String day = "1999/04/01";
//		String day = "1999/04/02";
//		String day = "1999/04/00";
//		String day = "2000/03/30";
//		String day = "2000/03/31";
//		String day = "2000/03/32";
//		String day = "";
		String day = null;

		try {
			consumptionTaxes = selectConsumptionTaxes.selectFromBetween(day);

			System.out.println("tax_rate : " + consumptionTaxes.getTaxRate());
			System.out.println("start_day : " + consumptionTaxes.getStartDay());
			System.out.println("end_day : " +consumptionTaxes.getEndDay());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// --------------------selectFromBetween()の確認--------------------
	}
}
