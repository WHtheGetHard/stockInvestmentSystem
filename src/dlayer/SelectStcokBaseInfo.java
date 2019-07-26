package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.StockBaseInfo;

public class SelectStcokBaseInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM stcok_base_info ";

	public StockBaseInfo selectFromId(int id) throws SQLException {
		StockBaseInfo stockBaseInfo = new StockBaseInfo();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			stockBaseInfo.setId(id);
			stockBaseInfo.setSecuritiesCode(rs.getString("securities_code"));
			stockBaseInfo.setMarket(rs.getString("market"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockBaseInfo;
	}

	public StockBaseInfo selectFromSecuritiesCode(String securitiesCode) throws SQLException {
		StockBaseInfo stockBaseInfo = new StockBaseInfo();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE securities_code = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, securitiesCode);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			stockBaseInfo.setId(rs.getInt("id"));
			stockBaseInfo.setSecuritiesCode(securitiesCode);
			stockBaseInfo.setMarket(rs.getString("market"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockBaseInfo;
	}

	public ArrayList<StockBaseInfo> selectFromMarket(String market) throws SQLException {
		ArrayList<StockBaseInfo> stockBaseInfoList = new ArrayList<StockBaseInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE market = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, market);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			StockBaseInfo stockBaseInfo = new StockBaseInfo();

			stockBaseInfo.setId(rs.getInt("id"));
			stockBaseInfo.setSecuritiesCode(rs.getString("securities_code"));
			stockBaseInfo.setMarket(rs.getString("market"));

			stockBaseInfoList.add(stockBaseInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockBaseInfoList;
	}
}
