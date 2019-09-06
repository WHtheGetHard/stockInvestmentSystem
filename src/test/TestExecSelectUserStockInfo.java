package test;

import java.util.ArrayList;

import fieldformat.DisplayUserStockInfo;
import flayer.ExecSelectUserStockInfo;

public class TestExecSelectUserStockInfo {
	// user_stock_info table has a record
	// user_id:1, comp_id:1(XYZ), num_stock:300, buying_price:1000, selling_price:0
	// user_id:1, comp_id:2(ABC), num_stock:300, buying_price:1000, selling_price:0
	// user_id:1, comp_id:9(日立キャピタル(株)), num_stock:10000, buying_price:1000, selling_price:0
	// user_id:1, comp_id:11(日立建機(株)), num_stock:10000, buying_price:11111, selling_price:0
	// user_id:1, comp_id:15(日立化成(株)), num_stock:1111, buying_price:0, selling_price:1111
	// user_id:2, comp_id:10(伊藤忠テクノソリューションズ(株)), num_stock:10, buying_price:100, selling_price:111//error

	public static void main(String[] args) {
		ExecSelectUserStockInfo execSelectUserStockInfo = new ExecSelectUserStockInfo();

		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();

		// START----------- comfirm getUsersAllStock(int userId) method -----------START
//		int userId = 1;
//		int userId = 2;
//		int userId = 3;

//		displayUserStockInfoList = execSelectUserStockInfo.getUsersAllStock(userId);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getUsersAllStock(int userId) method -----------END


		// START----------- comfirm getFulfillBuyingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1; int rangeStart = 999; int rangeEnd = 1001;
//		int userId = 1; int rangeStart = 1000; int rangeEnd = 1000;
//		int userId = 1; int rangeStart = 1001; int rangeEnd = 1001;
//		int userId = 2; int rangeStart = 100; int rangeEnd = 100;


//		displayUserStockInfoList = execSelectUserStockInfo.getFulfillBuyingPriceRange(userId, rangeStart, rangeEnd);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getFulfillBuyingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm getFulfillSellingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1; int rangeStart = 1110; int rangeEnd = 1111;
//		int userId = 1; int rangeStart = 1111; int rangeEnd = 1111;
//		int userId = 1; int rangeStart = 1112; int rangeEnd = 1112;
//		int userId = 2; int rangeStart = 111; int rangeEnd = 111;


//		displayUserStockInfoList = execSelectUserStockInfo.getFulfillSellingPriceRange(userId, rangeStart, rangeEnd);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getFulfillSellingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm getFulfillHoldingRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1; int rangeStart = 299; int rangeEnd = 301;
//		int userId = 1; int rangeStart = 300; int rangeEnd = 300;
//		int userId = 1; int rangeStart = 301; int rangeEnd = 301;
//		int userId = 2; int rangeStart = 10; int rangeEnd = 10;


//		displayUserStockInfoList = execSelectUserStockInfo.getFulfillHoldingRange(userId, rangeStart, rangeEnd);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getFulfillHoldingRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm getUsersAllBuying(int userId) method -----------START
//		int userId = 1;
//		int userId = 2;
//		int userId = 3;


//		displayUserStockInfoList = execSelectUserStockInfo.getUsersAllBuying(userId);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getUsersAllBuying(int userId) method -----------END


		// START----------- comfirm getUsersAllSelling(int userId) method -----------START
//		int userId = 1;
//		int userId = 2;
//		int userId = 3;


//		displayUserStockInfoList = execSelectUserStockInfo.getUsersAllSelling(userId);
//
//		if (displayUserStockInfoList.size() == 0 ) {
//			System.out.println("該当データなし");
//		} else {
//			for (int i = 0; i < displayUserStockInfoList.size(); i++) {
//				System.out.print("user_id : " + displayUserStockInfoList.get(i).getUserId() + ", ");
//				System.out.print("comp_id : " + displayUserStockInfoList.get(i).getCompId() + ", ");
//				System.out.print("comp_name : " + displayUserStockInfoList.get(i).getCompName() + ", ");
//				System.out.print("num_stock : " + displayUserStockInfoList.get(i).getNumStock() + ", ");
//				System.out.print("buying_price : " + displayUserStockInfoList.get(i).getBuyingPrice() + ", ");
//				System.out.println("selling_price : " + displayUserStockInfoList.get(i).getSellingPrice());
//			}
//		}
		// END----------- comfirm getUsersAllSelling(int userId) method -----------END


		// START----------- comfirm comfirmDuplicate(int userId, int compId) method -----------START
//		int userId = 1; int compId = 9;
//		int userId = 1; int compId = 10;
//		int userId = 2; int compId = 10;
		int userId = 3; int compId = 10;

		boolean isDuplicated = false;
		isDuplicated = execSelectUserStockInfo.comfirmDuplicate(userId, compId);

		if (isDuplicated) {
			System.out.println("すでに登録済みのデータ");
		} else {
			System.out.println("未登録のデータ");
		}
		// END----------- comfirm comfirmDuplicate(int userId, int compId) method -----------END
	}
}
