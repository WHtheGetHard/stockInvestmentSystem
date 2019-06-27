package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fieldformat.CapitalGainsTaxes;

public class SelectCapitalGainsTaxes {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM capital_gains_taxes ";

	public CapitalGainsTaxes selectFromPrimaryKey(String startDay, String endDay) throws SQLException {
		CapitalGainsTaxes capitalGainsTaxes =  new CapitalGainsTaxes();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, startDay);
		psttmt.setString(2, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			capitalGainsTaxes.setTaxRate(rs.getString("tax_rate"));
			capitalGainsTaxes.setStartDay(startDay);
			capitalGainsTaxes.setEndDay(endDay);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return capitalGainsTaxes;
	}

	public CapitalGainsTaxes selectFromBetween(String day) throws SQLException {
		CapitalGainsTaxes capitalGainsTaxes =  new CapitalGainsTaxes();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE start_day < ? AND end_day > ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, day);
		psttmt.setString(2, day);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			capitalGainsTaxes.setTaxRate(rs.getString("tax_rate"));
			capitalGainsTaxes.setStartDay(rs.getString("start_day"));
			capitalGainsTaxes.setEndDay(rs.getString("end_day"));

		}

		rs.close();
		psttmt.close();
		conn.close();

		return capitalGainsTaxes;
	}

	public int selectCountFromPrimaryKey(String startDay, String endDay) throws SQLException {
		int count = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT count(tax_rate) FROM capital_gains_taxes WHERE start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, startDay);
		psttmt.setString(2, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			count = rs.getInt("count(tax_rate)");
		}

		rs.close();
		psttmt.close();
		conn.close();

		return count;
	}
}
