package test;

import flayer.CurrencyEdit;

public class TestCurrencyEdit {
	public static void main(String[] args) {
		CurrencyEdit currencyEdit = new CurrencyEdit();
		// START----------- comfirm commaEdit(String target) method -----------START
//		String beforeEdit = "1"; //1
//		String beforeEdit = "10"; //10
//		String beforeEdit = "100"; //100
//		String beforeEdit = "1000"; //1,000
//		String beforeEdit = "10000"; //10,000
//		String beforeEdit = "100000"; //100,000
//		String beforeEdit = "1000000"; //1,000,000
		String beforeEdit = "10000000"; //10,000,000





		String afterEdit = currencyEdit.commaEdit(beforeEdit);
		System.out.println(afterEdit);
		// END----------- comfirm commaEdit(String target) method -----------END
	}
}
