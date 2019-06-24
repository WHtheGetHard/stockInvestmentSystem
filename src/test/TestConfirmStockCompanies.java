package test;

import flayer.ConfirmStockCompanies;

public class TestConfirmStockCompanies {
	public static void main(String[] args) {
		ConfirmStockCompanies confirmStockCompanies = new ConfirmStockCompanies();


		// ------------------------confirmExists()の確認------------------------
//		String companyName = "楽天";
//		String companyName = "野村";
//		String companyName = "";
//		String companyName = "大塚";
//		String companyName = null;
		String companyName = "重複";

		System.out.println("登録済みの会社か　:" + confirmStockCompanies.confirmExists(companyName));


		// ------------------------confirmExists()の確認------------------------
	}
}
