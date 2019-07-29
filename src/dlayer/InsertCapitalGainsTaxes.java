package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.CapitalGainsTaxes;

public class InsertCapitalGainsTaxes {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(CapitalGainsTaxes capitalGainsTaxes) {
		int insertNumber = 0;

		String sql = "INSERT INTO capital_gains_taxes (`tax_rate`, `start_day`, `end_day`) VALUE (?, ?, ?)";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			conn.setAutoCommit(false);
			PreparedStatement psttmt = conn.prepareStatement(sql);

			psttmt.setString(1, capitalGainsTaxes.getTaxRate());
			psttmt.setString(2, capitalGainsTaxes.getStartDay());
			psttmt.setString(3, capitalGainsTaxes.getEndDay());

			try {
				insertNumber = psttmt.executeUpdate();


				conn.commit();

			} catch (Exception e) {
				// TODO:executeUpdate()でのエラー処理を共通化する。
				System.out.println("executeUpdate()でエラーが発生しました。");
				conn.rollback();
			}

			psttmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO:データベースアクセスエラーが発生した場合に起こるエラーを共通化する。
			System.out.println("データベースアクセスエラーが発生しました。");
		}

		return insertNumber;
	}
}
