package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fieldformat.StockBaseInfo;

public class InsertStcokBaseInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(StockBaseInfo stockBaseInfo) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO stcok_base_info (`id`, `securities_code`, `market`)"
				+ " VALUE (?,?,?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, stockBaseInfo.getId());
		psttmt.setString(2, stockBaseInfo.getSecuritiesCode());
		psttmt.setString(3, stockBaseInfo.getMarket());

		insertNumber = psttmt.executeUpdate();

		return insertNumber;
	}
}
