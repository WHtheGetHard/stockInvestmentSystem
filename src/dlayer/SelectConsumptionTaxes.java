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

	final String targetTable = "SELECT * FROM consumption_taxes ";

	public ConsumptionTaxes selectFromPrimaryKey(String startDay, String endDay) throws SQLException {
		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = targetTable + "WHERE start_day = ? AND end_day = ?";

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

		String sql = targetTable + "WHERE start_day < ? AND end_day > ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, day);
		psttmt.setString(2, day);

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
}
