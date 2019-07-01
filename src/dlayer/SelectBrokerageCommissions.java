package dlayer;

public class SelectBrokerageCommissions {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();

	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM brokerage_commissions ";
	final String selectCount = "SELECT count(company_id) FROM brokerage_commissions WHERE ";

	// TODO : 主キーでテーブルのデータを取得する
}
