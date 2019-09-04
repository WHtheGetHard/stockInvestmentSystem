package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectUserStockInfo;
import fieldformat.UserStockInfo;

public class TestSelectUserStockInfo {
	public static void main(String[] args) {
		// user_stock_info table has a record
		// user_id:1, comp_id:1, num_stock:300, buying_price:1000, selling_price:0
		// user_id:1, comp_id:2, num_stock:300, buying_price:1000, selling_price:0
		// user_id:1, comp_id:9, num_stock:10000, buying_price:1000, selling_price:0
		// user_id:1, comp_id:11, num_stock:10000, buying_price:11111, selling_price:0
		// user_id:1, comp_id:15, num_stock:1111, buying_price:0, selling_price:1111
		// user_id:2, comp_id:10, num_stock:10, buying_price:100, selling_price:111//error

		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		UserStockInfo userStockInfo = new UserStockInfo();
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		// START----------- comfirm selectFromPrimaryKey(int userId, int compId) method -----------START
//		int userId = 1; int compId = 1; // has record
//		int userId = 1; int compId = 2; // has record
//		int userId = 1; int compId = 3; // hasn't record
//		int userId = 2; int compId = 10; // has record
//		int userId = 3; int compId = 1; // hasn't record

//		try {
//			userStockInfo = selectUserStockInfo.selectFromPrimaryKey(userId, compId);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("comp_id : " + userStockInfo.getCompId() + " ,num_stock: " + userStockInfo.getNumStock());

		// END----------- comfirm selectFromPrimaryKey(int userId, int compId) method -----------END


		// START----------- comfirm selectFromUserId(int userId) method -----------START
//		int userId = 1; // has 5 records
//		int userId = 2; // has one record
//		int userId = 3; // hasn't record
//
//		try {
//			userStockInfoList = selectUserStockInfo.selectFromUserId(userId);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(userStockInfoList.size());
		// END----------- comfirm selectFromUserId(int userId) method -----------END


		// START----------- comfirm selectFromBuyingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1;int rangeStart = 999;int rangeEnd = 1001; // has 3 records
//		int userId = 1;int rangeStart = 1000;int rangeEnd = 1000; // has 3 records
//		int userId = 1;int rangeStart = 1001;int rangeEnd = 1001; // hasn't record
//		int userId = 2;int rangeStart = 999;int rangeEnd = 1001; // hasn't record

//		try {
//			userStockInfoList = selectUserStockInfo.selectFromBuyingPriceRange(userId, rangeStart, rangeEnd);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(userStockInfoList.size());

		// END----------- comfirm selectFromBuyingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm selectFromSellingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1;int rangeStart = 1110;int rangeEnd = 1112; // has record
//		int userId = 1;int rangeStart = 1111;int rangeEnd = 1111; // has record
//		int userId = 1;int rangeStart = 1112;int rangeEnd = 1112; // hasn't record
//		int userId = 2;int rangeStart = 1110;int rangeEnd = 1112; // hasn't record

//		try {
//			userStockInfoList = selectUserStockInfo.selectFromSellingPriceRange(userId, rangeStart, rangeEnd);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(userStockInfoList.size());
		// END----------- comfirm selectFromSellingPriceRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm selectFromHoldingRange(int userId, int rangeStart, int rangeEnd) method -----------START
//		int userId = 1;int rangeStart = 299;int rangeEnd = 301; // has 2 records
//		int userId = 1;int rangeStart = 300;int rangeEnd = 300; // has 2 records
//		int userId = 1;int rangeStart = 301;int rangeEnd = 301; // hasn't record
//		int userId = 2;int rangeStart = 299;int rangeEnd = 301; // hasn't record

//		try {
//			userStockInfoList = selectUserStockInfo.selectFromHoldingRange(userId, rangeStart, rangeEnd);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(userStockInfoList.size());
		// END----------- comfirm selectFromHoldingRange(int userId, int rangeStart, int rangeEnd) method -----------END


		// START----------- comfirm selectAllBuying(int userId) method -----------START
//		int userId = 1; // has 4 records
//		int userId = 2; // has record
//		int userId = 3; // hasn't record

//		try {
//			userStockInfoList = selectUserStockInfo.selectAllBuying(userId);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(userStockInfoList.size());
		// END----------- comfirm selectAllBuying(int userId) method -----------END


		// START----------- comfirm selectAllSelling(int userId) method -----------START
//		int userId = 1; // has record
//		int userId = 2; // has record
		int userId = 3; // hasn't record

		try {
			userStockInfoList = selectUserStockInfo.selectAllSelling(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(userStockInfoList.size());
		// END----------- comfirm selectAllSelling(int userId) method -----------END
	}
}
