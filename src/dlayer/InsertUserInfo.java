package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.UserInformation;

public class InsertUserInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(UserInformation userInformation) {
		int insertNumber = 0;

		String sql = "INSERT INTO user_info (`user_name`, `user_mail`, `user_password`) VALUE (?, ?, ?)";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			conn.setAutoCommit(false);

			PreparedStatement psttmt = conn.prepareStatement(sql);
			psttmt.setString(1, userInformation.getUserName());
			psttmt.setString(2, userInformation.getUserMail());
			psttmt.setString(3, userInformation.getUserPassword());

			try {
				insertNumber = psttmt.executeUpdate();

				conn.commit();
			} catch (Exception e) {

				System.out.println("インサートでエラーが発生しました。");
				conn.rollback();
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		return insertNumber;
	}
}
