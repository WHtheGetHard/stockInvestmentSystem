package test;

import java.sql.SQLException;

import dlayer.InsertStcokBaseInfo;
import fieldformat.StockBaseInfo;

public class TestInsertStcokBaseInfo {
	public static void main(String[] args) {
		// stcok_base_info table has two records that value are like bellow
		// id:1 securities_code:0000 market:one
		// id:2 securities_code:0001 market:one
		// id:3 securities_code:0002 market:two

		InsertStcokBaseInfo insertStcokBaseInfo = new InsertStcokBaseInfo();
		StockBaseInfo stockBaseInfo = new StockBaseInfo();
		int insertNumber = 0;

		// START----------- comfirm execInsert(stockBaseInfo) method -----------START

		// success
//		stockBaseInfo.setId(4);
//		stockBaseInfo.setSecuritiesCode("0003");
//		stockBaseInfo.setMarket("three");

		// fail
//		stockBaseInfo.setId(4);
//		stockBaseInfo.setSecuritiesCode("0004");
//		stockBaseInfo.setMarket("four");

		// success
//		stockBaseInfo.setId(5);
//		stockBaseInfo.setSecuritiesCode("0003");
//		stockBaseInfo.setMarket("four");

		// success
		stockBaseInfo.setId(6);
		stockBaseInfo.setSecuritiesCode("0004");
		stockBaseInfo.setMarket("four");


		try {
			insertNumber = insertStcokBaseInfo.execInsert(stockBaseInfo);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (insertNumber == 1) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		// END----------- comfirm execInsert(stockBaseInfo) method -----------END
	}
}
