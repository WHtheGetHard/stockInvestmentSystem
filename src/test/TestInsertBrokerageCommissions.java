package test;

import java.sql.SQLException;

import dlayer.InsertBrokerageCommissions;
import fieldformat.BrokerageCommissions;

public class TestInsertBrokerageCommissions {
	public static void main(String[] args) {
		InsertBrokerageCommissions insertBrokerageCommissions = new InsertBrokerageCommissions();

		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();

		// ------------execInsert()の確認------------
//		brokerageCommissions.setCampanyId(4);
//		brokerageCommissions.setBrokerageCommission("5000");
//		brokerageCommissions.setStartDay("2019/06/26");
//		brokerageCommissions.setEndDay("2019/06/30");
//
//		brokerageCommissions.setCampanyId(5);
//		brokerageCommissions.setBrokerageCommission("5000");
//		brokerageCommissions.setStartDay("2019/06/26");
//		brokerageCommissions.setEndDay("2019/06/30");
//
//		brokerageCommissions.setCampanyId(4);
//		brokerageCommissions.setBrokerageCommission("5000");
//		brokerageCommissions.setStartDay("2019/06/25");
//		brokerageCommissions.setEndDay("2019/06/30");
//
//		brokerageCommissions.setCampanyId(4);
//		brokerageCommissions.setBrokerageCommission("5000");
//		brokerageCommissions.setStartDay("2019/06/26");
//		brokerageCommissions.setEndDay("2019/06/31");
//
		brokerageCommissions.setCampanyId(4);
		brokerageCommissions.setBrokerageCommission("5000");
		brokerageCommissions.setStartDay("2019/06/26");
		brokerageCommissions.setEndDay("2019/06/30");

		try {
			System.out.println(insertBrokerageCommissions.execInsert(brokerageCommissions));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		// ------------execInsert()の確認------------
	}
}
