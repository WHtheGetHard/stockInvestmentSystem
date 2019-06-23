package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fieldformat.StockCompanies;

public class SelectStockCompanies {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	String url = dbConnectionInfo.getUrl();
	String user = dbConnectionInfo.getUser();
	String password = dbConnectionInfo.getPassword();

	public StockCompanies selectFromId(int id) throws SQLException {
		StockCompanies stockCompanies = new StockCompanies();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT * FROM stock_companies WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();

		while(rs.next()) {
			stockCompanies.setId(id);
			stockCompanies.setComapnyName(rs.getString("company_name"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockCompanies;
	}
}
