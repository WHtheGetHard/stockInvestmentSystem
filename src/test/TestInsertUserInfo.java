package test;

import dlayer.InsertUserInfo;
import fieldformat.UserInformation;

public class TestInsertUserInfo {
	public static void main(String[] args) {
		InsertUserInfo insertUserInfo = new InsertUserInfo();

		UserInformation userInformation = new UserInformation();

		// START----------- comfirm insertUserInfo.execInsert(userInformation) method -----------START
		// success
//		userInformation.setUserId(1);
//		userInformation.setUserName("takeshi");
//		userInformation.setUserMail("abc@gmail.com");
//		userInformation.setUserPassword("111111");

		// success
//		userInformation.setUserId(2);
//		userInformation.setUserName("takeshi");
//		userInformation.setUserMail("abc@gmail.com");
//		userInformation.setUserPassword("111111");

		// success
		userInformation.setUserId(1);
		userInformation.setUserName("takeshi");
		userInformation.setUserMail("abc@gmail.com");
		userInformation.setUserPassword("111111");

		int insertNumber = 0;

		insertNumber = insertUserInfo.execInsert(userInformation);

		System.out.println("インサート : " + insertNumber);
		// END----------- comfirm insertUserInfo.execInsert(userInformation) method -----------END
	}
}
