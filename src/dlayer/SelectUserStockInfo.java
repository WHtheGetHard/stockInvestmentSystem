package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.UserStockInfo;

public class SelectUserStockInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM user_stock_info ";


	public UserStockInfo selectFromPrimaryKey(int userId, int compId) throws SQLException {
		UserStockInfo userStockInfo = new UserStockInfo();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND comp_id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);
		psttmt.setInt(2, compId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			userStockInfo.setUserId(userId);
			userStockInfo.setCompId(compId);
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfo;
	}

	public ArrayList<UserStockInfo> selectFromUserId(int userId) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(userId);
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfoList;
	}

	public ArrayList<UserStockInfo> selectFromBuyingPriceRange(int userId, int rangeStart, int rangeEnd) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND buying_price  >= ? AND buying_price <= ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);
		psttmt.setInt(2, rangeStart);
		psttmt.setInt(3, rangeEnd);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(rs.getInt("user_id"));
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfoList;
	}

	public ArrayList<UserStockInfo> selectFromSellingPriceRange(int userId, int rangeStart, int rangeEnd) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND selling_price >= ? AND selling_price <= ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);
		psttmt.setInt(2, rangeStart);
		psttmt.setInt(3, rangeEnd);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(rs.getInt("user_id"));
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();


		return userStockInfoList;
	}

	public ArrayList<UserStockInfo> selectFromHoldingRange(int userId, int rangeStart, int rangeEnd) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND num_stock >= ? AND num_stock <= ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);
		psttmt.setInt(2, rangeStart);
		psttmt.setInt(3, rangeEnd);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(rs.getInt("user_id"));
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfoList;
	}

	public ArrayList<UserStockInfo> selectAllBuying(int userId) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND buying_price > 0";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(rs.getInt("user_id"));
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfoList;
	}


	public ArrayList<UserStockInfo> selectAllSelling(int userId) throws SQLException {
		ArrayList<UserStockInfo> userStockInfoList = new ArrayList<UserStockInfo>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE user_id = ? AND selling_price > 0";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, userId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			UserStockInfo userStockInfo = new UserStockInfo();

			userStockInfo.setUserId(rs.getInt("user_id"));
			userStockInfo.setCompId(rs.getInt("comp_id"));
			userStockInfo.setNumStock(rs.getInt("num_stock"));
			userStockInfo.setBuyingPrice(rs.getInt("buying_price"));
			userStockInfo.setSellingPrice(rs.getInt("selling_price"));

			userStockInfoList.add(userStockInfo);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return userStockInfoList;
	}
}
