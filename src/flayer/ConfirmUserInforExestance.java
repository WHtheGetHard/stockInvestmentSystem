package flayer;

import java.sql.SQLException;

import dlayer.SelectUserInfo;
import fieldformat.UserInformation;

public class ConfirmUserInforExestance {
	public boolean confirmByUserId(int userId) {
		boolean isExist = false;

		SelectUserInfo selectUserInfo = new SelectUserInfo();
		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromId(userId);

			isExist = confirm(userInformation);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return isExist;
	}


	public boolean confirmByUserName(String userName) {
		boolean isExist = false;

		SelectUserInfo selectUserInfo = new SelectUserInfo();
		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromUserName(userName);
			isExist = confirm(userInformation);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return isExist;
	}

	public boolean confirmByUserNamePassword(String userName, String userPassword) {
		boolean isExist = false;

		SelectUserInfo selectUserInfo = new SelectUserInfo();
		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromUserNamePassword(userName, userPassword);
			isExist = confirm(userInformation);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return isExist;
	}

	public boolean confirmByUserMail(String userMail) {
		boolean isExist = false;

		SelectUserInfo selectUserInfo = new SelectUserInfo();
		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromUserMail(userMail);
			isExist = confirm(userInformation);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return isExist;
	}

	private boolean confirm(UserInformation userInformation) {
		boolean result = false;

		if (userInformation != null) {
			if (userInformation.getUserId() > 0) {
				result = true;
			} else {
				result = false;
			}
		}

		return result;
	}
}