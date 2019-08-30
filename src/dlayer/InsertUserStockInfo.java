package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.UserStockInfo;

public class InsertUserStockInfo {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(UserStockInfo userStockInfo) {
		int insertNumber = 0;

		String sql = "INSERT INTO user_stock_info (`user_id`, `comp_id`, `num_stock`, `buying_price`, `selling_price`) VALUE (?,?,?,?,?)";


		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, password);

			conn.setAutoCommit(false);

			PreparedStatement psttmt = conn.prepareStatement(sql);

			psttmt.setInt(1, userStockInfo.getUserId());
			psttmt.setInt(2, userStockInfo.getCompId());
			psttmt.setInt(3, userStockInfo.getNumStock());
			psttmt.setInt(4, userStockInfo.getBuyingPrice());
			psttmt.setInt(5, userStockInfo.getSellingPrice());

			try {
				insertNumber = psttmt.executeUpdate();

				conn.commit();
			} catch (Exception e) {

				System.out.println("インサートでエラーが発生しました。");
				conn.rollback();
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return insertNumber;
	}
}
