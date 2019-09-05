package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectCompanies;
import dlayer.SelectUserStockInfo;
import fieldformat.Companies;
import fieldformat.DisplayUserStockInfo;
import fieldformat.MessageAreaDisplayContents;
import fieldformat.UserStockInfo;

public class ExecSelectUserStockInfo {

	MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

	public ArrayList<DisplayUserStockInfo> getUsersAllStock(int userId) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectFromUserId(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("ユーザの保有株取得処理でエラーが発生しました。");
		}



		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies = selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}

		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}


		return displayUserStockInfoList;
	}

	public ArrayList<DisplayUserStockInfo> getFulfillBuyingPriceRange(int userId, int rangeStart, int rangeEnd) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectFromBuyingPriceRange(userId, rangeStart, rangeEnd);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("範囲内で買った株情報の取得でエラーが発生しました。");
		}


		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies = selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}


		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}

		return displayUserStockInfoList;
	}


	public ArrayList<DisplayUserStockInfo> getFulfillSellingPriceRange(int userId, int rangeStart, int rangeEnd) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectFromSellingPriceRange(userId, rangeStart, rangeEnd);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("範囲内で売った株情報の取得でエラーが発生しました。");
		}


		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies = selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}

		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}

		return displayUserStockInfoList;
	}

	public ArrayList<DisplayUserStockInfo> getFulfillHoldingRange(int userId, int rangeStart, int rangeEnd) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectFromHoldingRange(userId, rangeStart, rangeEnd);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("範囲内の数を保有している株情報の取得でエラーが発生しました。");
		}


		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies =  selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}

		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}

		return displayUserStockInfoList;
	}

	public ArrayList<DisplayUserStockInfo> getUsersAllBuying(int userId) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectAllBuying(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("すべての買った株情報の取得でエラーが発生しました。");
		}


		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies =  selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}

		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}


		return displayUserStockInfoList;
	}


	public ArrayList<DisplayUserStockInfo> getUsersAllSelling(int userId) {
		ArrayList<DisplayUserStockInfo> displayUserStockInfoList = new ArrayList<DisplayUserStockInfo>();


		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		try {
			userStockInfoList = selectUserStockInfo.selectAllSelling(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("すべての売った株情報の取得でエラーが発生しました。");
		}


		SelectCompanies selectCompanies = new SelectCompanies();

		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		for (int i = 0; i < userStockInfoList.size(); i++) {
			Companies companies = new Companies();

			try {
				companies =  selectCompanies.selectFromId(userStockInfoList.get(i).getCompId());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

				this.messageAreaDisplayContents.setError(true);
				this.messageAreaDisplayContents.setMessage("企業名の取得処理でエラーが発生しました。");
			}

			companiesList.add(companies);
		}

		for (int i = 0; i < userStockInfoList.size(); i++) {
			DisplayUserStockInfo displayUserStockInfo = new DisplayUserStockInfo();

			displayUserStockInfo.setUserId(userStockInfoList.get(i).getUserId());
			displayUserStockInfo.setCompId(userStockInfoList.get(i).getCompId());
			displayUserStockInfo.setCompName(companiesList.get(i).getName());
			displayUserStockInfo.setNumStock(userStockInfoList.get(i).getNumStock());
			displayUserStockInfo.setBuyingPrice(userStockInfoList.get(i).getBuyingPrice());
			displayUserStockInfo.setSellingPrice(userStockInfoList.get(i).getSellingPrice());

			displayUserStockInfoList.add(displayUserStockInfo);
		}


		return displayUserStockInfoList;
	}

	public boolean comfirmDuplicate(int userId, int compId) {
		boolean isDuplicated = false;

		SelectUserStockInfo selectUserStockInfo = new SelectUserStockInfo();

		UserStockInfo userStockInfo = new UserStockInfo();

		try {
			userStockInfo = selectUserStockInfo.selectFromPrimaryKey(userId, compId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			this.messageAreaDisplayContents.setError(true);
			this.messageAreaDisplayContents.setMessage("主キー選択でエラーが発生しました。");
		}

		if (userStockInfo.getNumStock() > 0) {
			isDuplicated = false;
		} else {
			isDuplicated = true;
		}

		return isDuplicated;
	}
}
