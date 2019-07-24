package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.Companies;

public class SelectCompanies {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM companies ";

	public Companies selectFromId(int id) throws SQLException {
		Companies companies = new Companies();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			companies.setId(id);
			companies.setName(rs.getString("name"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return companies;
	}

	public Companies selectFromName(String name) throws SQLException {
		Companies companies = new Companies();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE name = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, name);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			companies.setId(rs.getInt("id"));
			companies.setName(name);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return companies;
	}

	public ArrayList<Companies> selectFromAmbiguous(String name) throws SQLException {
		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE name LIKE %?%";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, name);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			Companies companies = new Companies();

			companies.setId(rs.getInt("id"));
			companies.setName(rs.getString("name"));

			companiesList.add(companies);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return companiesList;
	}
}
