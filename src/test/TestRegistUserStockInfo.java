package test;

import fieldformat.MessageAreaDisplayContents;
import fieldformat.UserStockInfo;
import flayer.RegistUserStockInfo;

public class TestRegistUserStockInfo {
	public static void main(String[] args) {
		// companies table has records like bellow.
		// id : 1 ～　19
		// user_info table has records like bellow.
		// id : 1 ～ 4

		// START----------- comfirm execRegist(userStockInfo) method -----------START

		UserStockInfo userStockInfo = new UserStockInfo();

		// success
//		userStockInfo.setCompId(10);
//		userStockInfo.setUserId(2);
//		userStockInfo.setNumStock(10);
//		userStockInfo.setBuyingPrice(100);
//		userStockInfo.setSellingPrice(111);

		// error because company id isn't exist
//		userStockInfo.setCompId(0);
//		userStockInfo.setUserId(2);
//		userStockInfo.setNumStock(10);
//		userStockInfo.setBuyingPrice(100);
//		userStockInfo.setSellingPrice(111);

		// error because user id isn't exist
//		userStockInfo.setCompId(10);
//		userStockInfo.setUserId(10);
//		userStockInfo.setNumStock(10);
//		userStockInfo.setBuyingPrice(100);
//		userStockInfo.setSellingPrice(111);

		// error because company id and user id aren't exist
		userStockInfo.setCompId(20);
		userStockInfo.setUserId(50);
		userStockInfo.setNumStock(10);
		userStockInfo.setBuyingPrice(100);
		userStockInfo.setSellingPrice(111);

		RegistUserStockInfo registUserStockInfo = new RegistUserStockInfo();

		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();
		messageAreaDisplayContents = registUserStockInfo.execRegist(userStockInfo);

		System.out.println("result : " + messageAreaDisplayContents.isError());
		System.out.println("error cause : " + messageAreaDisplayContents.getMessage());

		// END----------- comfirm execRegist(userStockInfo) method -----------END
	}
}
