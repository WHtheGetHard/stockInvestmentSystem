package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.UserInformation;

public class SelectUserInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	private String selectAll = "SELECT * FROM user_info ";

	public UserInformation selectFromId(int userId) throws SQLException {
		UserInformation userInformation = new UserInformation();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + " WHERE user_id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);

		ResultSet rs= psttmt.executeQuery();

		while (rs.next()) {
			userInformation.setUserId(userId);
			userInformation.setUserName(rs.getString("user_name"));
			userInformation.setUserMail(rs.getString("user_mail"));
			userInformation.setUserPassword(rs.getString("user_password"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userInformation;
	}

	public UserInformation selectFromUserName(String userName) throws SQLException {
		UserInformation userInformation = new UserInformation();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + " WHERE user_name = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, userName);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			userInformation.setUserId(rs.getInt("user_id"));
			userInformation.setUserName(rs.getString("user_name"));
			userInformation.setUserMail(rs.getString("user_mail"));
			userInformation.setUserPassword(rs.getString("user_password"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userInformation;
	}

	public ArrayList<UserInformation> selectFromUserPassword(String userPassword) throws SQLException {
		ArrayList<UserInformation> userInformationList = new ArrayList<UserInformation>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + " WHERE user_password = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, userPassword);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserInformation userInformation = new UserInformation();

			userInformation.setUserId(rs.getInt("user_id"));
			userInformation.setUserName(rs.getString("user_name"));
			userInformation.setUserMail(rs.getString("user_mail"));
			userInformation.setUserPassword(rs.getString("user_password"));

			userInformationList.add(userInformation);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userInformationList;
	}

	public UserInformation selectFromUserMail(String userMail) throws SQLException {
		UserInformation userInformation = new UserInformation();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + " WHERE user_mail = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, userMail);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			userInformation.setUserId(rs.getInt("user_id"));
			userInformation.setUserName(rs.getString("user_name"));
			userInformation.setUserMail(rs.getString("user_mail"));
			userInformation.setUserPassword(rs.getString("user_password"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userInformation;
	}

	public UserInformation selectFromUserNamePassword(String userName, String userPassword) throws SQLException {
		UserInformation userInformation = new UserInformation();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + " WHERE user_name = ? AND user_password = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, userName);
		psttmt.setString(2, userPassword);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			userInformation.setUserId(rs.getInt("user_id"));
			userInformation.setUserName(rs.getString("user_name"));
			userInformation.setUserMail(rs.getString("user_mail"));
			userInformation.setUserPassword(rs.getString("user_password"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userInformation;
	}
}
