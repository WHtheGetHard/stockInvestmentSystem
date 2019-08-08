package flayer;

import java.sql.SQLException;

import dlayer.SelectUserInfo;
import fieldformat.InputUserInfo;
import fieldformat.UserInfoLoginCheckResult;
import fieldformat.UserInfoRegistCheckResult;
import fieldformat.UserInformation;

public class ConfirmUserInfo {
	public UserInfoLoginCheckResult execLogin(InputUserInfo inputUserInfo) {
		UserInfoLoginCheckResult userInfoLoginCheckResult = new UserInfoLoginCheckResult();

		SelectUserInfo selectUserInfo = new SelectUserInfo();

		UserInformation userInformation = new UserInformation();

		try {
			userInformation = selectUserInfo.selectFromUserNamePassword(inputUserInfo.getUserName(), inputUserInfo.getUserPassword());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (userInformation != null && userInformation.getUserId() > 0) {
			userInfoLoginCheckResult.setLoginSuccess(true);
			userInfoLoginCheckResult.setMessage("");
			userInfoLoginCheckResult.setUserInformation(userInformation);
		} else {
			userInfoLoginCheckResult.setLoginSuccess(false);
			userInfoLoginCheckResult.setMessage("登録された情報はありません。");
			userInfoLoginCheckResult.setUserInformation(userInformation);
		}

		return userInfoLoginCheckResult;
	}

	public UserInfoRegistCheckResult execRegist(InputUserInfo inputUserInfo) {
		UserInfoRegistCheckResult userInfoRegistCheckResult = new UserInfoRegistCheckResult();

		SelectUserInfo selectUserInfo = new SelectUserInfo();

		UserInformation userInformation = new UserInformation();


		return userInfoRegistCheckResult;
	}
}
