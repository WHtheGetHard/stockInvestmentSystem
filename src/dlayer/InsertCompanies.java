package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fieldformat.Companies;

public class InsertCompanies {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsertOnlyName(String name) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO companies (`name`) VALUE (?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, name);

		insertNumber = psttmt.executeUpdate();

		psttmt.close();
		conn.close();

		return insertNumber;
	}

	public int execInsert(Companies companies) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO companies (`id`, `name`) VALUE (?, ?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, companies.getId());
		psttmt.setString(2, companies.getName());

		insertNumber = psttmt.executeUpdate();

		psttmt.close();
		conn.close();

		return insertNumber;
	}
}
