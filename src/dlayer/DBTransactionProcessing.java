package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTransactionProcessing {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	public void setAutoCommitOff() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);

		conn.setAutoCommit(false);
	}

	public void doRollBack() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);

		conn.setAutoCommit(false);

		conn.rollback();
	}

	public void doCommit() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);

		conn.setAutoCommit(false);

		conn.commit();
	}
}
