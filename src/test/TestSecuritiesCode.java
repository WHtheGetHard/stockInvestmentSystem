package test;

import java.util.ArrayList;

import fieldformat.CompanyStockBaseInfo;
import flayer.SecuritiesCode;


public class TestSecuritiesCode {
	public static void main(String[] args) {
		String companyName = "";

		SecuritiesCode securitiesCode = new SecuritiesCode();

		String article = securitiesCode.accessTargetPage(companyName);

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
		companyStockBaseInfoList = securitiesCode.getResults(article);

		for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
			System.out.println("会社名 ： " + companyStockBaseInfoList.get(i).getCompanyName());
			System.out.println("証券コード : " + companyStockBaseInfoList.get(i).getSecuritiesCode());
			System.out.println("市場 : " + companyStockBaseInfoList.get(i).getMarket());
		}
	}
}
