package flayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectBrokerageCommissions;
import dlayer.SelectStockCompanies;
import fieldformat.BrokerageCommissions;
import fieldformat.DisplayContentsBrokerageCommissions;
import fieldformat.StockCompanies;

public class DisplayAllRecordBrokerageCommissions {

	public ArrayList<DisplayContentsBrokerageCommissions> exec() {
		SelectBrokerageCommissions selectBrokerageCommissions = new SelectBrokerageCommissions();

		ArrayList<BrokerageCommissions> brokerageCommissionsList = new ArrayList<BrokerageCommissions>();

		try {
			brokerageCommissionsList = selectBrokerageCommissions.selectAllRecord();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		ArrayList<DisplayContentsBrokerageCommissions> displayContentsBrokerageCommissionsList =
				new ArrayList<DisplayContentsBrokerageCommissions>();

		if (brokerageCommissionsList != null) {
			for (int i = 0; i < brokerageCommissionsList.size(); i++) {
				DisplayContentsBrokerageCommissions displayContentsBrokerageCommissions = new DisplayContentsBrokerageCommissions();


				displayContentsBrokerageCommissions.setBraokerageCommission(
						brokerageCommissionsList.get(i).getBrokerageCommission());

				displayContentsBrokerageCommissions.setStartDate(
						brokerageCommissionsList.get(i).getStartDay());

				displayContentsBrokerageCommissions.setEndDate(
						brokerageCommissionsList.get(i).getEndDay());



				int id = brokerageCommissionsList.get(i).getCompanyId();

				SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

				StockCompanies stockCompanies = new StockCompanies();

				try {
					stockCompanies = selectStockCompanies.selectFromId(id);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				displayContentsBrokerageCommissions.setCompanyName(stockCompanies.getComapnyName());

				displayContentsBrokerageCommissionsList.add(displayContentsBrokerageCommissions);
			}
		}


		return displayContentsBrokerageCommissionsList;
	}
}
