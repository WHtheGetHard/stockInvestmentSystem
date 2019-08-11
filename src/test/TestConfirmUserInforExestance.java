package test;

import flayer.ConfirmUserInforExestance;

public class TestConfirmUserInforExestance {
	// user_info table has a record
	// user_id:1, user_name:user1, user_mail:user1@gmail.com, user_password:1111
	// user_id:2, user_name:user2, user_mail:user2@gmail.com, user_password:1111
	// user_id:3, user_name:user3, user_mail:user3@gmail.com, user_password:3333
	// user_id:4, user_name:user4, user_mail:user4@gmail.com, user_password:4444

	public static void main(String[] args) {
		ConfirmUserInforExestance confirmUserInforExestance = new ConfirmUserInforExestance();

		// START----------- comfirm confirmByUserId(userId) method -----------START
//		int userId = 1; // true
//		int userId = 0; // false
//		int userId = 4;	// true
//		int userId = 5; // false
//
//		boolean isExist = confirmUserInforExestance.confirmByUserId(userId);
//		System.out.println(isExist);

		// END----------- comfirm confirmByUserId(userId) method -----------END


		// START----------- comfirm confirmByUserMail(userMail) method -----------START
//		String userMail = "user1@gmail.com"; // true
//		String userMail = "user1@gmail"; // false
//		String userMail = "user2@gmail.com"; // true
//		String userMail = "user5@gmail.com"; // false

//		boolean isExist = confirmUserInforExestance.confirmByUserMail(userMail);
//		System.out.println(isExist);

		// END----------- comfirm confirmByUserMail(userMail) method -----------END


		// START----------- comfirm confirmByUserName(userName) method -----------START
//		String userName = "user1"; // true
//		String userName = "user0"; // false
//		String userName = "user3"; // true
//		String userName = null; // false

//		boolean isExist = confirmUserInforExestance.confirmByUserName(userName);
//		System.out.println(isExist);

		// END----------- comfirm confirmByUserName(userName) method -----------END


		// START----------- comfirm confirmByUserNamePassword(userName, userPassword) method -----------START
//		String userName = "user1"; String userPassword = "1111"; // true
//		String userName = "user1"; String userPassword = "111"; // false
//		String userName = "user"; String userPassword = "1111"; // true
		String userName = "user2"; String userPassword = "1111"; // true

		boolean isExist = confirmUserInforExestance.confirmByUserNamePassword(userName, userPassword);
		System.out.println(isExist);
		// END----------- comfirm confirmByUserNamePassword(userName, userPassword) method -----------END


	}
}
