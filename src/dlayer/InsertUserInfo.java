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

		String sql = "INSERT INTO user_info (`user_id`, `user_name`, `user_mail`, `user_password`) VALUE (?, ?, ?, ?)";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			conn.setAutoCommit(false);

			PreparedStatement psttmt = conn.prepareStatement(sql);
			psttmt.setInt(1, userInformation.getUserId());
			psttmt.setString(2, userInformation.getUserName());
			psttmt.setString(3, userInformation.getUserMail());
			psttmt.setString(4, userInformation.getUserPassword());

			try {
				insertNumber = psttmt.executeUpdate();

				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		return insertNumber;
	}
}
