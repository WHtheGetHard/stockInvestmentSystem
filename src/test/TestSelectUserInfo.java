package test;

import java.util.ArrayList;

import dlayer.SelectUserInfo;
import fieldformat.UserInformation;

public class TestSelectUserInfo {
	// user_info table has a record
	// user_id:1, user_name:user1, user_mail:user1@gmail.com, user_password:1111
	// user_id:2, user_name:user2, user_mail:user2@gmail.com, user_password:1111
	// user_id:3, user_name:user3, user_mail:user3@gmail.com, user_password:3333
	// user_id:4, user_name:user4, user_mail:user4@gmail.com, user_password:4444

	public static void main(String[] args) {
		SelectUserInfo selectUserInfo = new SelectUserInfo();

		UserInformation userInformation = new UserInformation();
		ArrayList<UserInformation> userInformationList = new ArrayList<UserInformation>();

		// START----------- comfirm selectFromId(userId) method -----------START
//		int userId = 1; // success
//		int userId = 0; // null
//		int userId = 4;	// success
//		int userId = 5; // null
//
//		try {
//			userInformation = selectUserInfo.selectFromId(userId);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

//		System.out.println("userId : " + userInformation.getUserId() + ", userName : " + userInformation.getUserName());

		// END----------- comfirm selectFromId(userId) method -----------END


		// START----------- comfirm selectFromUserName(userName) method -----------START
//		String userName = "user1"; // success
//		String userName = "user0"; // null
//		String userName = "user3"; // success
//		String userName = null; // null
//
//		try {
//			userInformation = selectUserInfo.selectFromUserName(userName);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("userId : " + userInformation.getUserId() + ", userName : " + userInformation.getUserName());

		// END----------- comfirm selectFromUserName(userName) method -----------END


		// START----------- comfirm selectFromUserPassword(userPassword) method -----------START
//		String userPassword = ""; // null
//		String userPassword = "1111"; // success
//		String userPassword = "2222"; // null
//		String userPassword = "4444"; // success
//		String userPassword = "111"; // null
//
//		try {
//			userInformationList = selectUserInfo.selectFromUserPassword(userPassword);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		for (int i = 0; i < userInformationList.size(); i++ ) {
//			System.out.println("userId : " + userInformationList.get(i).getUserId() + ", userName : " + userInformationList.get(i).getUserName());
//		}

		// END----------- comfirm selectFromUserPassword(userPassword) method -----------END


		// START----------- comfirm selectFromUserMail(userMail) method -----------START
//		String userMail = "user1@gmail.com"; // success
//		String userMail = "user1@gmail"; // null
//		String userMail = "user2@gmail.com"; // success
//		String userMail = "user5@gmail.com"; // null
//
//		try {
//			userInformation = selectUserInfo.selectFromUserMail(userMail);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("userId : " + userInformation.getUserId() + ", userName : " + userInformation.getUserName());

		// END----------- comfirm selectFromUserMail(userMail) method -----------END

		// START----------- comfirm selectFromUserNamePassword(userName, userPassword) method -----------START
//		String userName = "user1"; String userPassword = "1111"; // success
//		String userName = "user1"; String userPassword = "111"; // null
//		String userName = "user"; String userPassword = "1111"; // null
//		String userName = "user2"; String userPassword = "1111"; // success
//
//		try {
//			userInformation = selectUserInfo.selectFromUserNamePassword(userName, userPassword);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("userId : " + userInformation.getUserId() + ", userName : " + userInformation.getUserName());

		// END----------- comfirm selectFromUserNamePassword(userName, userPassword) method -----------END
	}
}
