package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fieldformat.ConsumptionTaxes;

public class InsertConsumptionTaxes {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(ConsumptionTaxes consumptionTaxes) {
		int insertNumber = 0;

		Connection conn;

		String sql = "INSERT INTO consumption_taxes (`tax_rate`, `start_day`, `end_day`) VALUE (?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, user, password);

			PreparedStatement psttmt = conn.prepareStatement(sql);
			psttmt.setString(1, consumptionTaxes.getTaxRate());
			psttmt.setString(2, consumptionTaxes.getStartDay());
			psttmt.setString(3, consumptionTaxes.getEndDay());

			try {
				insertNumber = psttmt.executeUpdate();

			} catch (Exception e) {
				// TODO:executeUpdate()でのエラー処理を共通化する。
				System.out.println("executeUpdate()でエラーが発生しました。");

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
