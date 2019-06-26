package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fieldformat.StockCompanies;

public class InsertStockCompanies {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(StockCompanies stockCompanies) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO stock_companies (`company_name`) VALUE (?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, stockCompanies.getComapnyName());

		insertNumber = psttmt.executeUpdate();

		psttmt.close();
		conn.close();

		return insertNumber;
	}
}
