package test;

import java.sql.SQLException;

import dlayer.SelectCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class TestSelectCapitalGainsTaxes {
	public static void main(String[] args) {
		SelectCapitalGainsTaxes selectCapitalGainsTaxes = new SelectCapitalGainsTaxes();

		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();

		// ----------------------selectFromPrimaryKey()の確認----------------------
//		String startDay = "2010/04/01";
//		String endDay = "2016/03/31";
//
//		String startDay = "2010/04/02";
//		String endDay = "2016/03/31";
//
//		String startDay = "2010/04/01";
//		String endDay = "2016/03/30";
//
//		String startDay = "";
//		String endDay = "2016/03/31";
//
//		String startDay = "2010/04/01";
//		String endDay = "";
//
//		try {
//			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromPrimaryKey(startDay, endDay);
//
//			System.out.println("tax_rate : " + capitalGainsTaxes.getTaxRate());
//			System.out.println("start_day : " + capitalGainsTaxes.getStartDay());
//			System.out.println("end_day : " + capitalGainsTaxes.getEndDay());
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		// ----------------------selectFromPrimaryKey()の確認----------------------

		// ----------------------selectFromBetween()の確認----------------------
//		String day = "2010/04/01";
//		String day = "2010/04/02";
//		String day = "2010/04/03";
//		String day = "2016/03/30";
//		String day = "2016/03/31";
		String day = "2016/03/32";

		try {
			capitalGainsTaxes = selectCapitalGainsTaxes.selectFromBetween(day);

			System.out.println("tax_rate : " + capitalGainsTaxes.getTaxRate());
			System.out.println("start_day : " + capitalGainsTaxes.getStartDay());
			System.out.println("end_day : " + capitalGainsTaxes.getEndDay());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// ----------------------selectFromBetween()の確認----------------------
	}
}
