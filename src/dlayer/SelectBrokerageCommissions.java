package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.BrokerageCommissions;

public class SelectBrokerageCommissions {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String targetTable = "SELECT * FROM brokerage_commissions ";

	public BrokerageCommissions selectFromPrimaryKey(int campanyId, String startDay, String endDay) throws SQLException {
		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = targetTable + "WHERE campany_id = ? AND start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, campanyId);
		psttmt.setString(2, startDay);
		psttmt.setString(3, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			brokerageCommissions.setCampanyId(campanyId);
			brokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			brokerageCommissions.setStartDay(startDay);
			brokerageCommissions.setEndDay(endDay);
		}

		rs.close();
		psttmt.close();
		conn.close();


		return brokerageCommissions;
	}

	public ArrayList<BrokerageCommissions> selectFromCampanyId(int campanyId) throws SQLException{
		ArrayList<BrokerageCommissions> brokerageCommissions = new ArrayList<BrokerageCommissions>();


		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = targetTable + "WHERE campany_id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, campanyId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			BrokerageCommissions tempBrokerageCommissions = new BrokerageCommissions();

			tempBrokerageCommissions.setCampanyId(campanyId);
			tempBrokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			tempBrokerageCommissions.setStartDay(rs.getString("start_day"));
			tempBrokerageCommissions.setEndDay(rs.getString("end_day"));

			brokerageCommissions.add(tempBrokerageCommissions);
		}

		rs.close();
		psttmt.close();
		conn.close();


		return brokerageCommissions;
	}


	public ArrayList<BrokerageCommissions> selectBetweenStartEnd(String day) throws SQLException {
		ArrayList<BrokerageCommissions> brokerageCommissions = new ArrayList<BrokerageCommissions>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = targetTable + "WHERE start_day < ? AND end_day > ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setString(1, day);
		psttmt.setString(2, day);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			BrokerageCommissions tempBrokerageCommissions = new BrokerageCommissions();

			tempBrokerageCommissions.setCampanyId(rs.getInt("campany_id"));
			tempBrokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			tempBrokerageCommissions.setStartDay(rs.getString("start_day"));
			tempBrokerageCommissions.setEndDay(rs.getString("end_day"));

			brokerageCommissions.add(tempBrokerageCommissions);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return brokerageCommissions;
	}

	public ArrayList<BrokerageCommissions> selectValidRecord(int campanyId, String day) throws SQLException {
		ArrayList<BrokerageCommissions> brokerageCommissions = new ArrayList<BrokerageCommissions>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = targetTable + "WHERE campany_id = ? AND start_day < ? AND end_day > ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, campanyId);
		psttmt.setString(2, day);
		psttmt.setString(3, day);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			BrokerageCommissions tempBrokerageCommissions = new BrokerageCommissions();

			tempBrokerageCommissions.setCampanyId(rs.getInt("campany_id"));
			tempBrokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			tempBrokerageCommissions.setStartDay(rs.getString("start_day"));
			tempBrokerageCommissions.setEndDay(rs.getString("end_day"));

			brokerageCommissions.add(tempBrokerageCommissions);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return brokerageCommissions;
	}
}
