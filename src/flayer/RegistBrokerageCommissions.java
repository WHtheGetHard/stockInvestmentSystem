package flayer;

import java.sql.SQLException;

import dlayer.InsertBrokerageCommissions;
import dlayer.InsertStockCompanies;
import dlayer.SelectStockCompanies;
import fieldformat.BrokerageCommissions;
import fieldformat.DisplayContentsBrokerageCommissions;
import fieldformat.StockCompanies;

public class RegistBrokerageCommissions {

	public void execRegistration(DisplayContentsBrokerageCommissions displayContentsBrokerageCommissions) {
		StockCompanies stockCompanies = new StockCompanies();
		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();

		SelectStockCompanies selectStockCompanies = new SelectStockCompanies();
		InsertStockCompanies insertStockCompanies = new InsertStockCompanies();

		InsertBrokerageCommissions insertBrokerageCommissions = new InsertBrokerageCommissions();

		// TODO : confirm stock company is already registered
		ConfirmStockCompaniesRegistered confirmStockCompaniesRegistered = new ConfirmStockCompaniesRegistered();
		ConfirmBrokerageCommissionsRegistered confirmSelectBrokerageCommissionsRegistered = new ConfirmBrokerageCommissionsRegistered();

		boolean companyIsExist = confirmStockCompaniesRegistered.isRegistered(displayContentsBrokerageCommissions.getCompanyName());

		// TODO : if already registered
		if (companyIsExist) {
			// TODO : get company id
			try {
				int companyId = selectStockCompanies.selectIdFromCompanyName(displayContentsBrokerageCommissions.getCompanyName());
				stockCompanies.setId(companyId);
				stockCompanies.setComapnyName(displayContentsBrokerageCommissions.getCompanyName());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// TODO : confirm term's overlap
			boolean isOverlaped = confirmSelectBrokerageCommissionsRegistered.isOverlap(
					stockCompanies.getId(), displayContentsBrokerageCommissions.getStartDate(), displayContentsBrokerageCommissions.getEndDate());

			// TODO : if term neveroverlaped
			if (isOverlaped) {
				// TODO : decide specification
			} else {
				// TODO : if term doesn't overlaped, insert to brokerage_commissions table
				brokerageCommissions.setCompanyId(stockCompanies.getId());
				brokerageCommissions.setBrokerageCommission(displayContentsBrokerageCommissions.getBraokerageCommission());
				brokerageCommissions.setStartDay(displayContentsBrokerageCommissions.getStartDate());
				brokerageCommissions.setEndDay(displayContentsBrokerageCommissions.getEndDate());

				try {
					insertBrokerageCommissions.execInsert(brokerageCommissions);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			}

		} else {
			// TODO : else stock_companies table doesn't have company's date

			// TODO : insert new company data
			stockCompanies.setComapnyName(displayContentsBrokerageCommissions.getCompanyName());

			try {
				insertStockCompanies.execInsert(stockCompanies);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// TODO : get new company id
			int companyId = 0;

			try {
				companyId = selectStockCompanies.selectIdFromCompanyName(displayContentsBrokerageCommissions.getCompanyName());
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			stockCompanies.setId(companyId);


			// TODO : insert to brokerage_commissions table
			brokerageCommissions.setCompanyId(stockCompanies.getId());
			brokerageCommissions.setBrokerageCommission(displayContentsBrokerageCommissions.getBraokerageCommission());
			brokerageCommissions.setStartDay(displayContentsBrokerageCommissions.getStartDate());
			brokerageCommissions.setEndDay(displayContentsBrokerageCommissions.getEndDate());

			try {
				insertBrokerageCommissions.execInsert(brokerageCommissions);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}
