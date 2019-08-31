package flayer;

import java.sql.SQLException;

import dlayer.InsertUserStockInfo;
import dlayer.SelectCompanies;
import dlayer.SelectUserInfo;
import fieldformat.Companies;
import fieldformat.MessageAreaDisplayContents;
import fieldformat.UserInformation;
import fieldformat.UserStockInfo;


public class RegistUserStockInfo {
	public MessageAreaDisplayContents execRegist(UserStockInfo userStockInfo) {
		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

		SelectUserInfo selectUserInfo = new SelectUserInfo();
		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromId(userStockInfo.getUserId());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		boolean userInfoIsExist = false;

		if (userInformation.getUserName() != null) {
			userInfoIsExist = true;
		} else {
			userInfoIsExist = false;
		}


		SelectCompanies selectCompanies = new SelectCompanies();
		Companies companies = new Companies();

		try {
			companies = selectCompanies.selectFromId(userStockInfo.getCompId());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		boolean companyIsExist = false;

		if (companies.getName() != null) {
			companyIsExist = true;
		} else {
			companyIsExist = false;
		}

		if (userInfoIsExist && companyIsExist) {
			InsertUserStockInfo insertUserStockInfo = new InsertUserStockInfo();
			insertUserStockInfo.execInsert(userStockInfo);

			messageAreaDisplayContents.setError(false);

		} else {
			if (userInfoIsExist) {
				messageAreaDisplayContents.setError(true);

				messageAreaDisplayContents.setMessage("企業情報に誤りがあります。");

			} else if (companyIsExist) {
				messageAreaDisplayContents.setError(true);

				messageAreaDisplayContents.setMessage("ログイン状態に問題があります。");
			} else {
				messageAreaDisplayContents.setError(true);

				messageAreaDisplayContents.setMessage("エラーが発生しました。");
			}
		}

		return messageAreaDisplayContents;
	}
}
