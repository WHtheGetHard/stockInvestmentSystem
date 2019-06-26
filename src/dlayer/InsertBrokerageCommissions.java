package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fieldformat.BrokerageCommissions;

public class InsertBrokerageCommissions {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public int execInsert(BrokerageCommissions brokerageCommissions) throws SQLException {
		int insertNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = "INSERT INTO brokerage_commissions (`campany_id`, `brokerage_commission`, `start_day`, `end_day`) VALUE (?, ?, ?, ?)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, brokerageCommissions.getCampanyId());
		psttmt.setString(2, brokerageCommissions.getBrokerageCommission());
		psttmt.setString(3, brokerageCommissions.getStartDay());
		psttmt.setString(4, brokerageCommissions.getEndDay());

		insertNumber = psttmt.executeUpdate();

		psttmt.close();
		conn.close();

		return insertNumber;
	}
}
