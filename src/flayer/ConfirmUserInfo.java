package flayer;

import java.sql.SQLException;

import dlayer.InsertUserInfo;
import dlayer.SelectUserInfo;
import fieldformat.InputUserInfo;
import fieldformat.UserInfoLoginCheckResult;
import fieldformat.UserInfoRegistCheckResult;
import fieldformat.UserInformation;

public class ConfirmUserInfo {
	public UserInfoLoginCheckResult execLogin(InputUserInfo inputUserInfo) {
		ConfirmUserInforExestance confirmUserInforExestance = new ConfirmUserInforExestance();

		boolean isExist = false;

		isExist = confirmUserInforExestance.confirmByUserNamePassword(
				inputUserInfo.getUserName(), inputUserInfo.getUserPassword());


		UserInfoLoginCheckResult userInfoLoginCheckResult = new UserInfoLoginCheckResult();

		SelectUserInfo selectUserInfo = new SelectUserInfo();

		if (isExist) {
			UserInformation userInformation = new UserInformation();

			try {
				userInformation = selectUserInfo.selectFromUserNamePassword(
						inputUserInfo.getUserName(), inputUserInfo.getUserPassword());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			userInfoLoginCheckResult.setLoginSuccess(true);
			userInfoLoginCheckResult.setMessage("");
			userInfoLoginCheckResult.setUserInformation(userInformation);

		} else {
			userInfoLoginCheckResult.setLoginSuccess(false);
			userInfoLoginCheckResult.setMessage("登録されたユーザ情報はありません。");

			boolean userIsExist = false;
			userIsExist = confirmUserInforExestance.confirmByUserName(inputUserInfo.getUserName());

			if (userIsExist) {

			} else {
				// TODO : ログファイルに記録するようにする。
				System.out.println("ユーザ名が存在しない。");
			}
		}

		return userInfoLoginCheckResult;
	}

	public UserInfoRegistCheckResult execRegist(InputUserInfo inputUserInfo) {
		ConfirmUserInforExestance confirmUserInforExestance = new ConfirmUserInforExestance();

		boolean isAlreayRegisted = false;

		isAlreayRegisted = confirmUserInforExestance.confirmByUserNamePassword(
				inputUserInfo.getUserName(), inputUserInfo.getUserPassword());

		UserInfoRegistCheckResult userInfoRegistCheckResult = new UserInfoRegistCheckResult();

		if (isAlreayRegisted) {
			userInfoRegistCheckResult.setRegistSuccess(false);
			userInfoRegistCheckResult.setMessage("既に登録済みです。");

			// TODO : ログファイルに記録するようにする。
			System.out.println("ユーザ名とパスワードが既に存在");

			return userInfoRegistCheckResult;
		}

		boolean isAlreadyRegistedMail = false;

		isAlreadyRegistedMail = confirmUserInforExestance.confirmByUserMail(
				inputUserInfo.getUserMail());

		if (isAlreadyRegistedMail) {
			userInfoRegistCheckResult.setRegistSuccess(false);
			userInfoRegistCheckResult.setMessage("既に登録済みです。");

			// TODO : ログファイルに記録するようにする。
			System.out.println("メールアドレスが既に登録済み");

			return userInfoRegistCheckResult;
		}

		boolean isAlreadyUsedName = false;

		isAlreadyUsedName = confirmUserInforExestance.confirmByUserName(
				inputUserInfo.getUserName());

		if (isAlreadyUsedName) {
			userInfoRegistCheckResult.setRegistSuccess(false);
			userInfoRegistCheckResult.setMessage("既に使用されているユーザ名です。");

			// TODO : ログファイルに記録するようにする。
			System.out.println("既に登録済みのユーザ名");

			return userInfoRegistCheckResult;
		}



		InsertUserInfo insertUserInfo = new InsertUserInfo();

		UserInformation userInformation = new UserInformation();
		userInformation.setUserName(inputUserInfo.getUserName());
		userInformation.setUserMail(inputUserInfo.getUserMail());
		userInformation.setUserPassword(inputUserInfo.getUserPassword());

		int insertNumber = insertUserInfo.execInsert(userInformation);

		if (insertNumber == 1) {
			userInfoRegistCheckResult.setRegistSuccess(true);
			userInfoRegistCheckResult.setMessage("");
			userInfoRegistCheckResult.setUserInformation(userInformation);
		} else {
			userInfoRegistCheckResult.setRegistSuccess(false);
			userInfoRegistCheckResult.setMessage("ユーザ登録でエラーが発生しました。");

			// TODO : ログファイルに記録するようにする。
			System.out.println("ユーザ登録エラー");
		}

		return userInfoRegistCheckResult;
	}
}
