package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectBrokerageCommissions;
import fieldformat.BrokerageCommissions;

public class TestSelectBrokerageCommissions {
	public static void main(String[] args) {
		SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();


		// -----------------selectFromPrimaryKey()の確認-----------------
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/31";

//		int campanyId = 1;
//		String startDay = "2019/04/01";
//		String endDay = "2020/03/31";
//
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2018/02/01";
//
//		int campanyId = 2;
//		String startDay = "2017/04/01";
//		String endDay = "2017/05/01";
//
//		int campanyId = 1;
//		String startDay = null;
//		String endDay = "2019/03/31";
//
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = null;
//
//		int campanyId = 1;
//		String startDay = null;
//		String endDay = null;
//		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();
//
//		try {
//			brokerageCommissions = selectBrokerageCommissions.selectFromPrimaryKey(campanyId, startDay, endDay);
//
//			System.out.println("campany_id : " + brokerageCommissions.getCampanyId());
//			System.out.println("brokerage_commission : " + brokerageCommissions.getBrokerageCommission());
//			System.out.println("start_day : " + brokerageCommissions.getStartDay());
//			System.out.println("end_day : " + brokerageCommissions.getEndDay());
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}


		// -----------------selectFromPrimaryKey()の確認-----------------


		// -----------------selectBetweenStartEnd()の確認-----------------
//		String day = "2019/04/02";
//		String day = "2019/04/01";
//		String day = "2019/04/00";
//		String day = "2020/03/30";
//		String day = "2020/03/31";
//		String day = "2020/03/32";
//		String day = "";
//		String day = null;
//
//		ArrayList<BrokerageCommissions> brokerageCommissions = new ArrayList<BrokerageCommissions>();
//
//		try {
//			brokerageCommissions = selectBrokerageCommissions.selectBetweenStartEnd(day);
//
//			int resultNumber = brokerageCommissions.size();
//
//			for (int i = 0; i < resultNumber; i++) {
//				System.out.println("campany_id : " + brokerageCommissions.get(i).getCampanyId());
//				System.out.println("brokerage_commission : " + brokerageCommissions.get(i).getBrokerageCommission());
//				System.out.println("start_day : " + brokerageCommissions.get(i).getStartDay());
//				System.out.println("end_day : " + brokerageCommissions.get(i).getEndDay());
//			}
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
		// -----------------selectBetweenStartEnd()の確認-----------------


		// -----------------selectValidRecord()の確認-----------------
//		int campanyId = 1;
//		String day = "2018/04/00";

//		int campanyId = 1;
//		String day = "2018/04/01";
//
//		int campanyId = 1;
//		String day = "2018/04/02";
//
//		int campanyId = 1;
//		String day = "2018/04/03";
//
//		int campanyId = 1;
//		String day = "2019/03/30";
//
//		int campanyId = 1;
//		String day = "2019/03/31";
//
		int campanyId = 1;
		String day = "2019/03/32";

		ArrayList<BrokerageCommissions> brokerageCommissions = new ArrayList<BrokerageCommissions>();

		try {
			brokerageCommissions = selectBrokerageCommissions.selectValidRecord(campanyId, day);

			int resultNumber = brokerageCommissions.size();

			for (int i = 0; i < resultNumber; i++) {
				System.out.println("campany_id : " + brokerageCommissions.get(i).getCampanyId());
				System.out.println("brokerage_commission : " + brokerageCommissions.get(i).getBrokerageCommission());
				System.out.println("start_day : " + brokerageCommissions.get(i).getStartDay());
				System.out.println("end_day : " + brokerageCommissions.get(i).getEndDay());
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// -----------------selectValidRecord()の確認-----------------
	}
}
