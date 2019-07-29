package test;

import dlayer.InsertCapitalGainsTaxes;
import fieldformat.CapitalGainsTaxes;

public class TestInsertCapitalGainsTaxes {
	public static void main(String[] args) {
		// start_day:1999/04/01, end_day:2000/03/31

		InsertCapitalGainsTaxes insertCapitalGainsTaxes = new InsertCapitalGainsTaxes();

		CapitalGainsTaxes capitalGainsTaxes = new CapitalGainsTaxes();

		int insertNumber = 0;

		// START execInsert(capitalGainsTaxes)test START
		// success : insertNumber = 1
//		capitalGainsTaxes.setTaxRate("0.1");
//		capitalGainsTaxes.setStartDay("2009/01/01");
//		capitalGainsTaxes.setEndDay("2009/01/02");

		// generate error when use getConnection method by debug
		// error : insertNumber = 0, capital_gains_taxes isn't updated
//		capitalGainsTaxes.setTaxRate("0.1");
//		capitalGainsTaxes.setStartDay("2009/01/03");
//		capitalGainsTaxes.setEndDay("2009/01/04");

		// generate error when use executeUpdate method by debug
		// error : insertNumber = 0, capital_gains_taxes isn't updated
//		capitalGainsTaxes.setTaxRate("0.1");
//		capitalGainsTaxes.setStartDay("2009/01/05");
//		capitalGainsTaxes.setEndDay("2009/01/06");

		// error : insertNumber = 0, capital_gains_taxes isn't updated
		capitalGainsTaxes.setTaxRate("0.1");
		capitalGainsTaxes.setStartDay("2009/01/01");
		capitalGainsTaxes.setEndDay("2009/01/02");

		insertNumber = insertCapitalGainsTaxes.execInsert(capitalGainsTaxes);

		System.out.println(insertNumber);
		// END execInsert(capitalGainsTaxes)test END
	}
}
