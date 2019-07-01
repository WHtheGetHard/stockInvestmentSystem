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

	final String selectAll = "SELECT * FROM brokerage_commissions ";
	final String selectCount = "SELECT count(company_id) FROM brokerage_commissions ";

	// Type1 : テーブルのカラム名のみで検索を実行

	// TODO : 主キー(company_id, start_day, end_day)
	public BrokerageCommissions selectFromPrimaryKey(int companyId, String startDay, String endDay) throws SQLException {
		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();


		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE company_id = ? AND start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, companyId);
		psttmt.setString(2, startDay);
		psttmt.setString(3, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			brokerageCommissions.setCompanyId(companyId);
			brokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			brokerageCommissions.setStartDay(startDay);
			brokerageCommissions.setEndDay(endDay);
		}

		rs.close();
		psttmt.close();
		conn.close();


		return brokerageCommissions;
	}

	public int selectCountFromPrimaryKey(int companyId, String startDay, String endDay) throws SQLException {
		int dataNumber = 0;


		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectCount + "WHERE company_id = ? AND start_day = ? AND end_day = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, companyId);
		psttmt.setString(2, startDay);
		psttmt.setString(3, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			dataNumber = rs.getInt("count(company_id)");
		}

		rs.close();
		psttmt.close();
		conn.close();


		return dataNumber;
	}


	// TODO : company_id
	public ArrayList<BrokerageCommissions> selectFromCompanyId(int companyId) throws SQLException {
		ArrayList<BrokerageCommissions> brokerageCommissionsList = new ArrayList<BrokerageCommissions>();


		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE company_id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, companyId);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			BrokerageCommissions tempBrokerageCommissions = new BrokerageCommissions();

			tempBrokerageCommissions.setCompanyId(companyId);
			tempBrokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			tempBrokerageCommissions.setStartDay(rs.getString("start_day"));
			tempBrokerageCommissions.setEndDay(rs.getString("end_day"));

			brokerageCommissionsList.add(tempBrokerageCommissions);
		}

		rs.close();
		psttmt.close();
		conn.close();


		return brokerageCommissionsList;
	}

	public int selectCountTermOverlapFromPrimaryKey(int companyId, String startDay, String endDay) throws SQLException {
		int duplicateNumber = 0;

		Connection conn = DriverManager.getConnection(url, user, password);

		String sqlInclose = selectCount + "WHERE campany_id = ? AND ? <= start_day AND end_day <= ?";

		PreparedStatement psttmt = conn.prepareStatement(sqlInclose);
		psttmt.setInt(1, companyId);
		psttmt.setString(2, startDay);
		psttmt.setString(3, endDay);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			duplicateNumber += rs.getInt("count(company_id)");
		}


		String sqlInclude = selectCount + "WHERE campany_id = ? AND ((? BETWEEN start_day AND end_day) OR (? BETWEEN start_day AND end_day))";

		psttmt = conn.prepareStatement(sqlInclude);
		psttmt.setInt(1, companyId);
		psttmt.setString(2, startDay);
		psttmt.setString(3, endDay);

		rs = psttmt.executeQuery();

		while (rs.next()) {
			duplicateNumber += rs.getInt("count(company_id)");
		}

		rs.close();
		psttmt.close();
		conn.close();


		return duplicateNumber;
	}


	// Type2: テーブルのカラム名以外で検索を実行
	public BrokerageCommissions selectFromValidTerm(int companyId, String day) throws SQLException {
		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();


		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE company_id = ? AND (? BETWEEN start_day AND end_day)";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, companyId);
		psttmt.setString(2, day);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			brokerageCommissions.setCompanyId(companyId);
			brokerageCommissions.setBrokerageCommission(rs.getString("brokerage_commission"));
			brokerageCommissions.setStartDay(rs.getString("start_day"));
			brokerageCommissions.setEndDay(rs.getString("end_day"));
		}

		rs.close();
		psttmt.close();
		conn.close();


		return brokerageCommissions;
	}
}
