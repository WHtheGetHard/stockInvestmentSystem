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

		ExecSelectUserStockInfo execSelectUserStockInfo = new ExecSelectUserStockInfo();

		boolean isDuplicated = false;

		isDuplicated = execSelectUserStockInfo.comfirmDuplicate(userStockInfo.getUserId(), userStockInfo.getCompId());

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

		if (userInfoIsExist && companyIsExist && !isDuplicated) {
			InsertUserStockInfo insertUserStockInfo = new InsertUserStockInfo();
			int insertNumber = insertUserStockInfo.execInsert(userStockInfo);

			if (insertNumber == 0) {
				messageAreaDisplayContents.setError(true);
				messageAreaDisplayContents.setMessage("インサートでエラーが発生しました。");
			} else {
				messageAreaDisplayContents.setError(false);
			}


		} else {
			if (isDuplicated) {
				messageAreaDisplayContents.setError(true);

				messageAreaDisplayContents.setMessage("既に登録済みの企業情報です。");
			} else {
				if (userInfoIsExist) {
					messageAreaDisplayContents.setError(true);

					messageAreaDisplayContents.setMessage("企業情報に誤りがあります。");

				} else if (companyIsExist) {
					messageAreaDisplayContents.setError(true);

					messageAreaDisplayContents.setMessage("ログイン状態に問題があります。");
				}
			}
		}

		return messageAreaDisplayContents;
	}
}
