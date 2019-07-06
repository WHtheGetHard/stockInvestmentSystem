package test;

import flayer.ConfirmSelectBrokerageCommissionsRegistered;

public class TestConfirmSelectBrokerageCommissionsRegistered {
	public static void main(String[] args) {
		ConfirmSelectBrokerageCommissionsRegistered confirmSelectBrokerageCommissionsRegistered = new ConfirmSelectBrokerageCommissionsRegistered();
		// START----------- comfirm isDuplicatePrimaryKey(companyId, startDay, endDay) method -----------START
		// true
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 11;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// false
//		int companyId = 9;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 8;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// false
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/04/01";

		// false
//		int companyId = 0;
//		String startDay = "";
//		String endDay = "";

		// false
//		int companyId = 0;
//		String startDay = null;
//		String endDay = null;

//		System.out.println("is duplicated : " + confirmSelectBrokerageCommissionsRegistered.isDuplicatePrimaryKey(companyId, startDay, endDay));
		// END----------- comfirm isDuplicatePrimaryKey(companyId, startDay, endDay) method -----------END

		// START----------- comfirm isOverlap(companyId, startDay, endDay) method -----------START
		// true
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 9;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// false
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/03/31";

		// true
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/04/01";

		// true
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/04/02";

		// true
//		int companyId = 10;
//		String startDay = "2000/06/01";
//		String endDay = "2000/12/01";

		// true
//		int companyId = 10;
//		String startDay = "2001/03/30";
//		String endDay = "2002/03/31";

		// true
//		int companyId = 10;
//		String startDay = "2001/03/31";
//		String endDay = "2002/03/31";

		// false
//		int companyId = 10;
//		String startDay = "2001/04/01";
//		String endDay = "2002/03/31";

		// true
		int companyId = 10;
		String startDay = "2000/03/31";
		String endDay = "2001/04/01";

		System.out.println("is overlaped : " + confirmSelectBrokerageCommissionsRegistered.isOverlap(companyId, startDay, endDay));
		// END----------- comfirm isOverlap(companyId, startDay, endDay) method -----------END
	}
}
