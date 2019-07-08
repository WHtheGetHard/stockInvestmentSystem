package test;

import fieldformat.DisplayContentsCapitalGainsTaxes;
import flayer.RegistCapitalGainsTaxes;

public class TestRegistCapitalGainsTaxes {
	public static void main(String[] args) {
		// capital_gains_taxes table has a record
		// tax_rate:0.1, start_day:1999/04/01, end_day:2000/03/31

		RegistCapitalGainsTaxes registCapitalGainsTaxes = new RegistCapitalGainsTaxes();
		DisplayContentsCapitalGainsTaxes displayContentsCapitalGainsTaxes = new DisplayContentsCapitalGainsTaxes();

		// START----------- comfirm execRegistration(displayContentsCapitalGainsTaxes) method -----------START
		// can register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.2");
//		displayContentsCapitalGainsTaxes.setStartDate("2002/04/01");
//		displayContentsCapitalGainsTaxes.setEndDate("2003/04/01");

		// can't register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.3");
//		displayContentsCapitalGainsTaxes.setStartDate("1998/04/01");
//		displayContentsCapitalGainsTaxes.setEndDate("1999/04/01");

		// can't register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.4");
//		displayContentsCapitalGainsTaxes.setStartDate("1998/04/01");
//		displayContentsCapitalGainsTaxes.setEndDate("1999/04/02");

		// can't register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.5");
//		displayContentsCapitalGainsTaxes.setStartDate("2000/03/30");
//		displayContentsCapitalGainsTaxes.setEndDate("2001/03/31");

		// can't register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.6");
//		displayContentsCapitalGainsTaxes.setStartDate("2000/03/31");
//		displayContentsCapitalGainsTaxes.setEndDate("2001/03/31");

		// can't register
//		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.7");
//		displayContentsCapitalGainsTaxes.setStartDate("1999/06/01");
//		displayContentsCapitalGainsTaxes.setEndDate("1999/06/30");

		// can register
		displayContentsCapitalGainsTaxes.setCapitalGainsTax("0.8");
		displayContentsCapitalGainsTaxes.setStartDate("1998/04/01");
		displayContentsCapitalGainsTaxes.setEndDate("1999/03/31");

		registCapitalGainsTaxes.execRegistration(displayContentsCapitalGainsTaxes);
		// END----------- comfirm execRegistration(displayContentsCapitalGainsTaxes) method -----------END
	}
}
