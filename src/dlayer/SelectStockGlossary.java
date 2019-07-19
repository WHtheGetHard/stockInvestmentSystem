package dlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fieldformat.StockGlossary;

public class SelectStockGlossary {
	DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
	final String url = dbConnectionInfo.getUrl();
	final String user = dbConnectionInfo.getUser();
	final String password = dbConnectionInfo.getPassword();

	final String selectAll = "SELECT * FROM stock_glossary ";

	public StockGlossary selectFromPrimaryKey(int id) throws SQLException {
		StockGlossary stockGlossary = new StockGlossary();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE id = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, id);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			stockGlossary.setId(id);
			stockGlossary.setSection(rs.getInt("section"));
			stockGlossary.setWord(rs.getString("word"));
			stockGlossary.setDescription(rs.getString("Description"));
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockGlossary;
	}

	public ArrayList<StockGlossary> selectFromSection(int section) throws SQLException {
		ArrayList<StockGlossary> stockGlossaryList = new ArrayList<StockGlossary>();

		Connection conn = DriverManager.getConnection(url, user, password);

		String sql = selectAll + "WHERE section = ?";

		PreparedStatement psttmt = conn.prepareStatement(sql);
		psttmt.setInt(1, section);

		ResultSet rs = psttmt.executeQuery();

		while (rs.next()) {
			StockGlossary stockGlossary = new StockGlossary();

			stockGlossary.setId(rs.getInt("id"));
			stockGlossary.setSection(section);
			stockGlossary.setWord(rs.getString("word"));
			stockGlossary.setDescription(rs.getString("Description"));

			stockGlossaryList.add(stockGlossary);
		}

		rs.close();
		psttmt.close();
		conn.close();

		return stockGlossaryList;
	}
}
