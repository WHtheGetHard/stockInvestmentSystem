package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fieldformat.CapitalGainsTaxes;

public class InsertCapitalGainsTaxes {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(CapitalGainsTaxes capitalGainsTaxes) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO capital_gains_taxes (`tax_rate`, `start_day`, `end_day`) VALUE (?, ?, ?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, capitalGainsTaxes.getTaxRate());
		psttmt.setString(2, capitalGainsTaxes.getStartDay());
		psttmt.setString(3, capitalGainsTaxes.getEndDay());

		insertNumber = psttmt.executeUpdate();

		psttmt.close();
		conn.close();

		return insertNumber;
	}
}
