package test;

import flayer.RegistBrokerageCommissions;

public class TestRegistBrokerageCommissions {
	public static void main(String[] args) {
		RegistBrokerageCommissions registBrokerageCommissions = new RegistBrokerageCommissions();

		// Result is true
//		String companyName = "NTTデータ" , startDay = "2018/04/01", endDay = "2019/03/31";

		// Result is true
//		String companyName = "NEC" , startDay = "2018/04/01", endDay = "2019/03/31";

		// Result is false
//		String companyName = "NTTデータ" , startDay = "2018/04/01", endDay = "2019/03/31";

		// Result is false
//		String companyName = "NTTデータ" , startDay = "2018/03/30", endDay = "2019/04/01";

		// Result is false
//		String companyName = "NTTデータ" , startDay = "2018/06/30", endDay = "2018/12/31";

		// Result is false
//		String companyName = "NTTデータ" , startDay = "2018/03/30", endDay = "2019/06/30";

		// Result is false
//		String companyName = "NTTデータ" , startDay = "2018/06/30", endDay = "2019/04/01";

		// Result is true
//		String companyName = "NTTデータ" , startDay = "2018/01/01", endDay = "2018/03/31";

		// Result is true
		String companyName = "NTTデータ" , startDay = "2019/04/01", endDay = "2019/06/01";

		System.out.println("登録結果 : " + registBrokerageCommissions.execRegist(companyName, startDay, endDay));
	}
}
