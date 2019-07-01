package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.StockCompanies;

public class SelectStockCompanies {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM stock_companies ";

	public StockCompanies selectFromId(int id) throws SQLException {
		StockCompanies stockCompanies = new StockCompanies();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE id = ?";

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

	public ArrayList<StockCompanies> selecFromCompanyName(String companyName) throws SQLException {
		ArrayList<StockCompanies> stockCompanies = new ArrayList<StockCompanies>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE company_name = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, companyName);

		ResultSet rs = psttmt.executeQuery();

		while(rs.next()) {
			StockCompanies tempStockCompanies = new StockCompanies();
			tempStockCompanies.setId(rs.getInt("id"));
			tempStockCompanies.setComapnyName(rs.getString("company_name"));

			stockCompanies.add(tempStockCompanies);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockCompanies;
	}

	public int selectMaxIdFromCompanyName(String companyName) throws SQLException {
		int maxId = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT max(id) FROM stock_companies WHERE company_name = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, companyName);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			maxId = rs.getInt("max(id)");
		}

		rs.close();
		psttmt.close();
		conn.close();

		return maxId;
	}

	public int selectCountFromCompanyName(String companyName) throws SQLException {
		int count = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "SELECT count(company_name) FROM stock_companies WHERE company_name = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, companyName);

		ResultSet rs = psttmt.executeQuery();

		while(rs.next()) {
			count = rs.getInt("count(company_name)");
		}

		rs.close();
		psttmt.close();
		conn.close();

		return count;
	}
}
