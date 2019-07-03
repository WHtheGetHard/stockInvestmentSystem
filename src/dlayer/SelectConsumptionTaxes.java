package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fieldformat.ConsumptionTaxes;

public class SelectConsumptionTaxes {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM consumption_taxes ";
	final String selectCount = "SELECT count(tax_rate) FROM consumption_taxes ";

	public ConsumptionTaxes selectFromPrimaryKey(String startDay, String endDay) throws SQLException {
		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, startDay);
		psttmt.setString(2, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			consumptionTaxes.setTaxRate(rs.getString("tax_rate"));
			consumptionTaxes.setStartDay(rs.getString("start_day"));
			consumptionTaxes.setEndDay(rs.getString("end_day"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return consumptionTaxes;
	}

	public ConsumptionTaxes selectFromBetween(String day) throws SQLException {
		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE ? BETWEEN start_day AND end_day";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, day);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			consumptionTaxes.setTaxRate(rs.getString("tax_rate"));
			consumptionTaxes.setStartDay(rs.getString("start_day"));
			consumptionTaxes.setEndDay(rs.getString("end_day"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return consumptionTaxes;
	}

	public int selectCountFromPrimaryKey(String startDay, String endDay) throws SQLException {
		int count = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectCount + "WHERE start_day = ? AND end_day = ?";

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

	public int selectCountTermOverLap(String startDay, String endDay) throws SQLException {
		int count = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		int countInclose = 0;
		String sqlInclose = selectCount + "WHERE ? <= start_day AND end_day <= ?";

		PreparedStatement psttmt = conn.prepareStatement(sqlInclose);
		psttmt.setString(1, startDay);
		psttmt.setString(2, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			countInclose = rs.getInt("count(tax_rate)");
		}

		int countInclude = 0;
		String sqlInclude = selectCount + "WHERE (? BETWEEN start_day AND end_day) OR (? BETWEEN start_day AND end_day)";

		psttmt = conn.prepareStatement(sqlInclude);
		psttmt.setString(1, startDay);
		psttmt.setString(2, endDay);

		rs = psttmt.executeQuery();

		while (rs.next()) {
			countInclude = rs.getInt("count(tax_rate)");
		}

		rs.close();
		psttmt.close();
		conn.close();

		count = countInclose + countInclude;
		return count;
	}
}
