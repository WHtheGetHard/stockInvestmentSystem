package test;

import flayer.ConfirmStockCompaniesRegistered;

public class TestConfirmStockCompaniesRegistered {
	public static void main(String[] args) {
		ConfirmStockCompaniesRegistered confirmStockCompaniesRegistered = new ConfirmStockCompaniesRegistered();

		// START----------confrim isRegistered(companyName) method ----------START
//		String companyName = ""; // false
//		String companyName = null; // false
//		String companyName = "ABC inc."; // true
//		String companyName = "XYZ inc."; // true
		String companyName = "ABC co."; // false

		System.out.println("already registered : " + confirmStockCompaniesRegistered.isRegistered(companyName));
		// END----------confrim isRegistered(companyName) method ----------END
	}
}
