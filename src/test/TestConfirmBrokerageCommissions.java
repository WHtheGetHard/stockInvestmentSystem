package test;

import flayer.ConfirmBrokerageCommissions;

public class TestConfirmBrokerageCommissions {
	public static void main(String[] args) {

		ConfirmBrokerageCommissions confirmBrokerageCommissions = new ConfirmBrokerageCommissions();

		// ---------------confirmExists()の確認---------------
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/31";

//		int campanyId = 5;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/31";
//
//		int campanyId = 1;
//		String startDay = "2018/04/02";
//		String endDay = "2019/03/31";

//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/30";
//
//		System.out.println("存在有無　：" + confirmBrokerageCommissions.confirmExists(campanyId, startDay, endDay)) ;

		// ---------------confirmExists()の確認---------------


		// ---------------confirmOverlap()の確認---------------
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/31";

//		int campanyId = 1;
//		String startDay = "2018/04/02";
//		String endDay = "2019/03/31";
//
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/30";
//
//		int campanyId = 1;
//		String startDay = "2018/04/01";
//		String endDay = "2019/03/32";
//
		int campanyId = 1;
		String startDay = "2017/04/01";
		String endDay = "2018/03/30";

		System.out.println("重複有無 : " + confirmBrokerageCommissions.confirmOverlap(campanyId, startDay, endDay));
		// ---------------confirmOverlap()の確認---------------
	}
}
