package test;

import flayer.ConfirmConsumptionTaxes;

public class TestConfirmConsumptionTaxes {
	public static void main(String[] args) {
		ConfirmConsumptionTaxes confirmConsumptionTaxes = new ConfirmConsumptionTaxes();

		// -------------confirmExists()の確認-------------
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		String startDay = "1999/04/01";
		String endDay = "2000/03/32";

		System.out.println("既に登録済み　: " + confirmConsumptionTaxes.confirmExists(startDay, endDay));
		// -------------confirmExists()の確認-------------

		// -------------confirmOverlap()の確認-------------
//		String day = "1999/04/02";

		String day = "1999/04/01";

		System.out.println("期間の重複：" + confirmConsumptionTaxes.confirmOverlap(day));
		// -------------confirmOverlap()の確認-------------
	}
}
