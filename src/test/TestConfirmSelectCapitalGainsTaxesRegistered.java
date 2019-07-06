package test;

import flayer.ConfirmSelectCapitalGainsTaxesRegistered;

public class TestConfirmSelectCapitalGainsTaxesRegistered {
	public static void main(String[] args) {
		ConfirmSelectCapitalGainsTaxesRegistered confirmSelectCapitalGainsTaxesRegistered = new ConfirmSelectCapitalGainsTaxesRegistered();

		// START----------- comfirm isDuplicatePrimaryKey(startDay, endDay) method -----------START
		// true
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		// false
//		String startDay = "1999/04/02";
//		String endDay = "2000/03/31";

		// false
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/30";

		// false
//		String startDay = "";
//		String endDay = "2000/03/31";

		// false
//		String startDay = "1999/04/01";
//		String endDay = "";

		// false
//		String startDay = "";
//		String endDay = "";

		// false
//		String startDay = null;
//		String endDay = null;

//		System.out.println("is duplicated : " + confirmSelectCapitalGainsTaxesRegistered.isDuplicatePrimaryKey(startDay, endDay));

		// END----------- comfirm isDuplicatePrimaryKey(startDay, endDay) method -----------END

		// START----------- comfirm isOverlap(startDay, endDay) method -----------START
		// true
//		String startDay = "1999/04/01";
//		String endDay = "2000/03/31";

		// false
//		String startDay = "1998/04/01";
//		String endDay = "1999/03/31";

		// true
//		String startDay = "1999/01/01";
//		String endDay = "1999/04/01";

		// true
//		String startDay = "1999/01/01";
//		String endDay = "1999/04/02";

		// true
//		String startDay = "1999/05/01";
//		String endDay = "1999/06/01";

		// true
//		String startDay = "2000/03/30";
//		String endDay = "2000/06/01";

		// true
//		String startDay = "2000/03/31";
//		String endDay = "2000/06/01";

		// false
//		String startDay = "2000/04/01";
//		String endDay = "2000/06/01";

		// true
//		String startDay = "1999/03/30";
//		String endDay = "2000/04/01";

		// true
//		String startDay = "1999/03/31";
//		String endDay = "2000/04/02";

//		System.out.println("is overlaped : " + confirmSelectCapitalGainsTaxesRegistered.isOverlap(startDay, endDay));
		// END----------- comfirm isOverlap(startDay, endDay) method -----------END

	}
}
