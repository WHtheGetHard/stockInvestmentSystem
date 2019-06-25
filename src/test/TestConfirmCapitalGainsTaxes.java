package test;

import flayer.ConfirmCapitalGainsTaxes;

public class TestConfirmCapitalGainsTaxes {
	public static void main(String[] args) {
		ConfirmCapitalGainsTaxes confirmCapitalGainsTaxes = new ConfirmCapitalGainsTaxes();

		// ----------------confirmExists()の確認----------------
//		String startDay = "2010/04/01";
//		String endDay = "2016/03/31";

		String startDay = "2010/04/01";
		String endDay = "2016/03/32";
//
		System.out.println("既に登録済み：" + confirmCapitalGainsTaxes.confirmExists(startDay, endDay));
		// ----------------confirmExists()の確認----------------

		// ----------------confirmOverlap()の確認----------------
//		String day = "2010/04/02";
		String day = "2010/04/01";

		System.out.println("期間の重複あり：" + confirmCapitalGainsTaxes.confirmOverlap(day));
		// ----------------confirmOverlap()の確認----------------
	}
}
