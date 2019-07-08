package test;

import fieldformat.DisplayContentsBrokerageCommissions;
import flayer.RegistBrokerageCommissions;

public class TestRegistBrokerageCommissions {
	public static void main(String[] args) {
		// input
		DisplayContentsBrokerageCommissions displayContentsBrokerageCommissions = new DisplayContentsBrokerageCommissions();

		// test target class
		RegistBrokerageCommissions registBrokerageCommissions = new RegistBrokerageCommissions();

		// stock_companies table has two records that value are like bellow
		// id:9 company_name:ABC inc.
		// id:10 company_name:XYZ inc.
		// brokerage_commissions table has a record
		// company_id:10, brokerage_commission: 5000, start_day:2000/04/01, end_day:2001/03/31
		// company_id:10, brokerage_commission: 10000, start_day:2002/04/01, end_day:2003/03/31

		// START----------- comfirm execRegistration(displayContentsBrokerageCommissions) method -----------START
		// can register(company_id:11)
//		displayContentsBrokerageCommissions.setCompanyName("DEF corp.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2000/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2001/03/31");

		// can register(company_id:11)
//		displayContentsBrokerageCommissions.setCompanyName("DEF corp.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2001/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2002/03/31");

		// can register(company_id:10)
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2003/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2004/03/31");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2003/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2004/03/31");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("1999/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2000/04/01");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("1999/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2000/04/02");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("1999/04/01");
//		displayContentsBrokerageCommissions.setEndDate("2000/04/02");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2000/06/01");
//		displayContentsBrokerageCommissions.setEndDate("2000/06/30");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2004/03/30");
//		displayContentsBrokerageCommissions.setEndDate("2005/03/31");

		// can't register
//		displayContentsBrokerageCommissions.setCompanyName("XYZ inc.");
//		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
//		displayContentsBrokerageCommissions.setStartDate("2004/03/31");
//		displayContentsBrokerageCommissions.setEndDate("2005/03/31");

		// can register(company_id:9)
		displayContentsBrokerageCommissions.setCompanyName("ABC inc.");
		displayContentsBrokerageCommissions.setBraokerageCommission("5000");
		displayContentsBrokerageCommissions.setStartDate("2004/03/30");
		displayContentsBrokerageCommissions.setEndDate("2005/03/31");

		registBrokerageCommissions.execRegistration(displayContentsBrokerageCommissions);
		// END----------- comfirm execRegistration(displayContentsBrokerageCommissions) method -----------END
	}
}
