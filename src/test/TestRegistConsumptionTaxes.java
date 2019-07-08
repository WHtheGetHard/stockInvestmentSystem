package test;

import fieldformat.DisplayContentsConsumptionTaxes;
import flayer.RegistConsumptionTaxes;

public class TestRegistConsumptionTaxes {
	public static void main(String[] args) {
		// consumption_taxes table has a record
		// tax_rate:0.3, start_day:1999/04/01, end_day:2000/03/31

		RegistConsumptionTaxes registConsumptionTaxes = new RegistConsumptionTaxes();
		DisplayContentsConsumptionTaxes displayContentsConsumptionTaxes = new DisplayContentsConsumptionTaxes();

		// START----------- comfirm execRegistration(displayContentsConsumptionTaxes) method -----------START
		// can register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.4");
//		displayContentsConsumptionTaxes.setStartDate("2001/04/01");
//		displayContentsConsumptionTaxes.setEndDate("2002/03/31");

		// can't register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.5");
//		displayContentsConsumptionTaxes.setStartDate("1998/04/01");
//		displayContentsConsumptionTaxes.setEndDate("1999/04/01");

		// can't register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.6");
//		displayContentsConsumptionTaxes.setStartDate("1998/04/01");
//		displayContentsConsumptionTaxes.setEndDate("1999/04/02");

		// can't register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.7");
//		displayContentsConsumptionTaxes.setStartDate("1999/06/01");
//		displayContentsConsumptionTaxes.setEndDate("1999/06/30");

		// can't register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.8");
//		displayContentsConsumptionTaxes.setStartDate("2000/03/30");
//		displayContentsConsumptionTaxes.setEndDate("2001/03/31");

		// can't register
//		displayContentsConsumptionTaxes.setComsumptionTax("0.9");
//		displayContentsConsumptionTaxes.setStartDate("2000/03/31");
//		displayContentsConsumptionTaxes.setEndDate("2001/03/31");

		// can register
		displayContentsConsumptionTaxes.setComsumptionTax("0.1");
		displayContentsConsumptionTaxes.setStartDate("1998/04/01");
		displayContentsConsumptionTaxes.setEndDate("1999/03/31");

		registConsumptionTaxes.execRegistration(displayContentsConsumptionTaxes);
		// END----------- comfirm execRegistration(displayContentsConsumptionTaxes) method -----------END
	}
}
