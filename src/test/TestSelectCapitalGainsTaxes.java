package test;

import dlayer.SelectCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class TestSelectCapitalGainsTaxes {
	public static void main(String[] args) {
		// capital_gains_taxes table has a record
		// tax_rate:0.1, start_day:1999/04/01, end_day:2000/03/31


		SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();
		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();


		// START----------- comfirm selectFromPrimaryKey(String startDay, String endDay) method -----------START
		// tax_rate is 0.1
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		// tax_rate is null
//		String startDay = "1999/04/02";
//		String endDay = "2000/03/31";

		// tax_rate is null
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/30";

		// tax_rate is null
//		String startDay = "";
//		String endDay = "2000/03/31";

		// tax_rate is null
//		String startDay = "1999/04/01";
//		String endDay = "";

		// tax_rate is null
//		String startDay = "";
//		String endDay = "";

		// tax_rate is null
//		String startDay = null;
//		String endDay = null;

//		try {
//			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromPrimaryKey(startDay, endDay);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("tax_rate : " + capitalGainsTaxes.getTaxRate());

		// END----------- comfirm selectFromPrimaryKey(String startDay, String endDay) method -----------END


		// START----------- confirm selectFromBetween(String day) method -----------START
//		String day = "1999/04/01"; // 0.1
//		String day = "1999/04/02"; // 0.1
//		String day = "1999/03/31"; // null
//		String day = "2000/03/30"; // 0.1
//		String day = "2000/03/31"; // 0.1
//		String day = "2000/04/01"; // null
//		String day = "1999/06/30"; // 0.1
//		String day = ""; // null
//		String day = null; // null

//		try {
//			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromBetween(day);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("tax_rate : " + capitalGainsTaxes.getTaxRate());

		// END----------- confirm selectFromBetween(String day) method -----------END


		// START----------- confirm selectCountFromPrimaryKey(String startDay, String endDay) method -----------START
		// Record Number is 1
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		// Record Number is 0
//		String startDay = "1999/04/02";
//		String endDay = "2000/03/31";

		// Record Number is 0
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/30";

		// Record Number is 0
//		String startDay = "";
//		String endDay = "2000/03/31";

		// Record Number is 0
//		String startDay = "1999/04/01";
//		String endDay = "";

		// Record Number is 0
//		String startDay = "";
//		String endDay = "";

		// Record Number is 0
//		String startDay = null;
//		String endDay = null;

//		try {
//			System.out.println("Record Number : " + selectCapitalGainsTaxes.selectCountFromPrimaryKey(startDay, endDay));
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		// END----------- confirm selectCountFromPrimaryKey(String startDay, String endDay) method -----------END


		// START----------- confirm selectCountTermOverLap(String startDay, String endDay) method -----------START
		// Record Number is 1
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		// Record Number is 0
//		String startDay = "1998/04/01";
//		String endDay = "1999/03/31";

		// Record Number is 1
//		String startDay = "1999/01/01";
//		String endDay = "1999/04/01";

		// Record Number is 1
//		String startDay = "1999/01/01";
//		String endDay = "1999/04/02";

		// Record Number is 1
//		String startDay = "1999/05/01";
//		String endDay = "1999/06/01";

		// Record Number is 1
//		String startDay = "2000/03/30";
//		String endDay = "2000/06/01";

		// Record Number is 1
//		String startDay = "2000/03/31";
//		String endDay = "2000/06/01";

		// Record Number is 0
//		String startDay = "2000/04/01";
//		String endDay = "2000/06/01";

		// Record Number is 1
//		String startDay = "1999/03/30";
//		String endDay = "2000/04/01";

		// Record Number is 1
//		String startDay = "1999/03/31";
//		String endDay = "2000/04/02";

//		try {
//			System.out.println("Record Number : " + selectCapitalGainsTaxes.selectCountTermOverLap(startDay, endDay));
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		// END----------- confirm selectCountTermOverLap(String startDay, String endDay) method -----------END
	}
}
