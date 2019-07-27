package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dlayer.DBConnectionInfo;
import dlayer.DBTransactionProcessing;

public class TestDBTransactionProcessing {
	public static void main(String[] args) throws SQLException {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		String url = dbConnectionInfo.getUrl();
		String user = dbConnectionInfo.getUser();
		String password = dbConnectionInfo.getPassword();

		DBTransactionProcessing dbTransactionProcessing = new DBTransactionProcessing();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql1 = "INSERT INTO test1 (`tag1`) VALUE ('insert1_1')";
		String sql2 = "INSERT INTO test1 (`tag1`) VALUE ('insert1_2')";
		String sql3 = "INSERT INTO test1 (`tag1`) VALUE ('insert1_3')";

		PreparedStatement psttmt;

		//sql1～sql3まで実行してコミット
		dbTransactionProcessing.setAutoCommitOff();

		psttmt = conn.prepareStatement(sql1);
		psttmt.executeUpdate();

		psttmt = conn.prepareStatement(sql2);
		psttmt.executeUpdate();

		psttmt = conn.prepareStatement(sql3);
		psttmt.executeUpdate();


		dbTransactionProcessing.doCommit();


		//sql1～sql3まで実行後、ロールバック
		 sql1 = "INSERT INTO test1 (`tag1`) VALUE ('insert2_1')";
		 sql2 = "INSERT INTO test1 (`tag1`) VALUE ('insert2_2')";
		 sql3 = "INSERT INTO test1 (`tag1`) VALUE ('insert2_3')";

		 dbTransactionProcessing.setAutoCommitOff();

		psttmt = conn.prepareStatement(sql1);
		psttmt.executeUpdate();

		psttmt = conn.prepareStatement(sql2);
		psttmt.executeUpdate();

		psttmt = conn.prepareStatement(sql3);
		psttmt.executeUpdate();

		dbTransactionProcessing.doRollBack();

		// test1テーブルには、insert1_xまでがインサートされており、insert2_xがインサートされていないこと。
	}
}
