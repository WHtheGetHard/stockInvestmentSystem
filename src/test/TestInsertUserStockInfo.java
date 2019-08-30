package test;

import dlayer.InsertUserStockInfo;
import fieldformat.UserStockInfo;

public class TestInsertUserStockInfo {
	public static void main(String[] args) {
		InsertUserStockInfo insertUserStockInfo = new InsertUserStockInfo();

		UserStockInfo userStockInfo = new UserStockInfo();

		// START----------- comfirm execInsert(UserStockInfo userStockInfo) method -----------START
//		userStockInfo.setUserId(1);
//		userStockInfo.setCompId(2);
//		userStockInfo.setNumStock(300);
//		userStockInfo.setBuyingPrice(1000);
//		userStockInfo.setSellingPrice(0);


//		userStockInfo.setUserId(1);
//		userStockInfo.setCompId(1);
//		userStockInfo.setNumStock(300);
//		userStockInfo.setBuyingPrice(1000);
//		userStockInfo.setSellingPrice(0);

		// duplicate error
		userStockInfo.setUserId(1);
		userStockInfo.setCompId(2);
		userStockInfo.setNumStock(100);
		userStockInfo.setBuyingPrice(2000);
		userStockInfo.setSellingPrice(1);

		int insertNum = insertUserStockInfo.execInsert(userStockInfo);
		System.out.println(insertNum);
		// END----------- comfirm execInsert(UserStockInfo userStockInfo) method -----------END
	}
}
