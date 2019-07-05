package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectBrokerageCommissions;
import fieldformat.BrokerageCommissions;

public class TestSelectBrokerageCommissions {
	public static void main(String[] args) {
		// brokerage_commissions table has a record
		// company_id:10, brokerage_commission: 5000, start_day:2000/04/01, end_day:2001/03/31
		// company_id:10, brokerage_commission: 10000, start_day:2002/04/01, end_day:2003/03/31


		SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();
		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();
		ArrayList<BrokerageCommissions> brokerageCommissionsList = new ArrayList<BrokerageCommissions>();

		// START----------- comfirm selectFromPrimaryKey(int companyId, String startDay, String endDay) method -----------START
		// brokerage_commission is 5000
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// brokerage_commission is null
//		int companyId = 11;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// brokerage_commission is null
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// brokerage_commission is null
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// brokerage_commission is null
//		int companyId = 9;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// brokerage_commission is null
//		int companyId = 8;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// brokerage_commission is null
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/04/01";

		// brokerage_commission is null
//		int companyId = 0;
//		String startDay = "";
//		String endDay = "";

		// brokerage_commission is null
//		int companyId = 0;
//		String startDay = null;
//		String endDay = null;

//		try {
//			brokerageCommissions = selectBrokerageCommissions.selectFromPrimaryKey(companyId, startDay, endDay);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("brokerage commission is :" + brokerageCommissions.getBrokerageCommission());
		// END----------- comfirm selectFromPrimaryKey(int companyId, String startDay, String endDay) method -----------END


		// START----------- comfirm selectCountFromPrimaryKey(int companyId, String startDay, String endDay) method -----------START
		// count number is 1
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 11;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 10;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// count number is 0
//		int companyId = 9;
//		String startDay = "2000/04/02";
//		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 8;
//		String startDay = "2000/04/01";
//		String endDay = "2001/04/01";

		// count number is 0
//		int companyId = 10;
//		String startDay = "2000/04/02";
//		String endDay = "2001/04/01";

		// count number is 0
//		int companyId = 0;
//		String startDay = "";
//		String endDay = "";

		// count number is 0
//		int companyId = 0;
//		String startDay = null;
//		String endDay = null;

//		int countNumber = 0;
//		try {
//			countNumber = selectBrokerageCommissions.selectCountFromPrimaryKey(companyId, startDay, endDay);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("count number is : " + countNumber);
		// END----------- comfirm selectCountFromPrimaryKey(int companyId, String startDay, String endDay) method -----------END


		// START----------- comfirm selectFromCompanyId(int companyId) method -----------START
//		int companyId = 10; // brokerage_commissions are 5000 and 10000
//		int companyId = 9; // brokerage_commissions are null(doesn't out put)
//		int companyId = 11; // brokerage_commissions are null(doesn't out put)
//		int companyId = 0; // brokerage_commissions are null(doesn't out put)

//		try {
//			brokerageCommissionsList = selectBrokerageCommissions.selectFromCompanyId(companyId);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		for (int i = 0; i < brokerageCommissionsList.size(); i++) {
//			System.out.println(" rokerage_commission is : " + brokerageCommissionsList.get(i).getBrokerageCommission());
//		}

		// END----------- comfirm selectFromCompanyId(int companyId) method -----------END


		// START----------- comfirm selectCountTermOverlapFromPrimaryKey(int companyId, String startDay, String endDay) method -----------START
		// count number is 1
		int companyId = 10;
		String startDay = "2000/04/01";
		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 9;
//		String startDay = "2000/04/01";
//		String endDay = "2001/03/31";

		// count number is 0
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/03/31";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/04/01";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2000/01/01";
//		String endDay = "2000/04/02";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2000/06/01";
//		String endDay = "2000/12/01";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2001/03/30";
//		String endDay = "2002/03/31";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2001/03/31";
//		String endDay = "2002/03/31";

		// count number is 0
//		int companyId = 10;
//		String startDay = "2001/04/01";
//		String endDay = "2002/03/31";

		// count number is 1
//		int companyId = 10;
//		String startDay = "2000/03/31";
//		String endDay = "2001/04/01";

		int countNumber = 0;
		try {
			countNumber = selectBrokerageCommissions.selectCountTermOverlapFromPrimaryKey(companyId, startDay, endDay);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("count number is : " + countNumber);
		// END----------- comfirm selectCountTermOverlapFromPrimaryKey(int companyId, String startDay, String endDay) method -----------END


		// START----------- comfirm selectFromValidTerm(int companyId, String day) method -----------START
		// END----------- comfirm selectFromValidTerm(int companyId, String day) method -----------END

	}
}
