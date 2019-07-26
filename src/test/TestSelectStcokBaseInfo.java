package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectStcokBaseInfo;
import fieldformat.StockBaseInfo;

public class TestSelectStcokBaseInfo {
	public static void main(String[] args) {
		// stcok_base_info table has two records that value are like bellow
		// id:1 securities_code:0000 market:one
		// id:2 securities_code:0001 market:one
		// id:3 securities_code:0002 market:two

		SelectStcokBaseInfo selectStcokBaseInfo = new SelectStcokBaseInfo();
		StockBaseInfo stockBaseInfo = new StockBaseInfo();
		ArrayList<StockBaseInfo> stockBaseInfoList = new ArrayList<StockBaseInfo>();

		// START----------- comfirm selectFromId(id) method -----------START
//		int id = 0; // null
//		int id = 1; // 0000
//		int id = 2; // 0001
//		int id = 4; // null

//		try {
//			stockBaseInfo = selectStcokBaseInfo.selectFromId(id);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(stockBaseInfo.getSecuritiesCode() + " : " + stockBaseInfo.getMarket());
		// END----------- comfirm selectFromId(id) method -----------END

		// START----------- comfirm selectFromSecuritiesCode(securitiesCode) method -----------START
//		String securitiesCode = "aaaa"; // null
//		String securitiesCode = "0000"; // one
//		String securitiesCode = "000"; // null
//		String securitiesCode = "0002"; // two
//
//		try {
//			stockBaseInfo = selectStcokBaseInfo.selectFromSecuritiesCode(securitiesCode);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(stockBaseInfo.getSecuritiesCode() + " : " + stockBaseInfo.getMarket());
		// END----------- comfirm selectFromSecuritiesCode(securitiesCode) method -----------END

		// START----------- comfirm selectFromMarket(market) method -----------START
//		String market = "zero"; // null
//		String market = "one"; // 2
		String market = "two"; // 1

		try {
			stockBaseInfoList = selectStcokBaseInfo.selectFromMarket(market);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for (int i = 0; i < stockBaseInfoList.size(); i++) {
			System.out.println(stockBaseInfoList.get(i).getSecuritiesCode());
		}

		// END----------- comfirm selectFromMarket(market) method -----------END
	}
}
