package flayer;

import java.sql.SQLException;

import dlayer.InsertBrokerageCommissions;
import dlayer.InsertStockCompanies;
import dlayer.SelectStockCompanies;
import fieldformat.BrokerageCommissions;
import fieldformat.StockCompanies;

public class RegistBrokerageCommissions {
	public boolean execRegist(String companyName, String startDay, String endDay) {
		boolean isRegisted = false;

		StockCompanies stockCompanies = new StockCompanies();
		stockCompanies.setComapnyName(companyName);


		BrokerageCommissions brokerageCommissions = new BrokerageCommissions();
		brokerageCommissions.setStartDay(startDay);
		brokerageCommissions.setEndDay(endDay);


		// DO : 証券会社テーブルに会社名が登録されているかを確認する。
		ConfirmStockCompanies confirmStockCompanies = new ConfirmStockCompanies();

		boolean isCompanyAlreadyRegisted = false;

		isCompanyAlreadyRegisted = confirmStockCompanies.confirmExists(companyName);

		// DO : 証券会社テーブルに会社名が登録されていない場合は、証券会社テーブルと委託手数料テーブルに新規にデータを登録する
		if (!isCompanyAlreadyRegisted) {
			// DO : 証券会社テーブルにデータを登録する
			InsertStockCompanies insertStockCompanies = new InsertStockCompanies();
			int insertCompanyNumber = 0;

			try {
				insertCompanyNumber = insertStockCompanies.execInsert(stockCompanies);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// DO : 登録時に自動採番される会社id(主キー)を取得する
			SelectStockCompanies selectStockCompanies = new SelectStockCompanies();
			int campanyId = 0;
			try {
				campanyId = selectStockCompanies.selectMaxIdFromCompanyName(companyName);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// TODO : 委託手数料テーブルに新規データを登録する
			brokerageCommissions.setCampanyId(campanyId);

			InsertBrokerageCommissions insertBrokerageCommissions = new InsertBrokerageCommissions();
			int insertBrokerageCommissionsNumber = 0;

			try {
				insertBrokerageCommissionsNumber = insertBrokerageCommissions.execInsert(brokerageCommissions);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			int insertNumber = insertCompanyNumber + insertBrokerageCommissionsNumber;

			if (insertNumber == 2) {
				isRegisted = true;
			} else {
				isRegisted =false;
			}
		} else {
		// DO : 証券会社テーブルに会社名が既に登録されている場合は、登録済みの会社名のidをもとに、適用開始日と適用終了日の期間の重複を考慮して委託手数料テーブルにデータを追加する
			SelectStockCompanies selectStockCompanies = new SelectStockCompanies();

			int campanyId = 0;

			try {
				campanyId = selectStockCompanies.selectMaxIdFromCompanyName(companyName);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


			// DO : 適用開始日と適用終了日が重複していないか
			ConfirmBrokerageCommissions confirmBrokerageCommissions = new ConfirmBrokerageCommissions();

			boolean isDuplicated = false;
			isDuplicated = confirmBrokerageCommissions.confirmExists(campanyId, startDay, endDay);

			boolean isOverlaped = false;
			isOverlaped = confirmBrokerageCommissions.confirmOverlap(campanyId, startDay, endDay);

			if (!isDuplicated && !isOverlaped) {
				brokerageCommissions.setCampanyId(campanyId);

				int insertBrokerageCommissionsNumber = 0;

				InsertBrokerageCommissions insertBrokerageCommissions = new InsertBrokerageCommissions();

				try {
					insertBrokerageCommissionsNumber = insertBrokerageCommissions.execInsert(brokerageCommissions);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				if (insertBrokerageCommissionsNumber == 1) {
					isRegisted = true;
				} else {
					isRegisted = false;
				}
			} else {
				// TODO : 重複時の仕様を考えた後実装
				isRegisted = false;
			}

		}

		return isRegisted;
	}
}
