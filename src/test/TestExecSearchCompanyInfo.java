package test;

import java.util.ArrayList;

import fieldformat.CompanyStockBaseInfo;
import flayer.ExecSearchCompanyInfo;

public class TestExecSearchCompanyInfo {
	public static void main(String[] args) {
		// companies table has a record
		// id:8, name: あいうえおを
		// id:9, name: かきくけこを
		// id:10, name: さしすせそを
		// id:11, name: たちつてとを
		// id:12, name: なにぬねのを
		// id:13, name: ハマヤラワヲ
		// id:14, name: マミムメモヲ

		// stcok_base_info table has a record
		// id:8, securities_code:11111, market:東証1部
		// id:9, securities_code:22222, market:東証1部
		// id:10, securities_code:33333, market:東証1部
		// id:11, securities_code:44444, market:東証1部
		// id:12, securities_code:55555, market:東証1部
		// id:13, securities_code:66666, market:東証2部
		// id:14, securities_code:67777, market:東証1部


		ExecSearchCompanyInfo execSearchCompanyInfo = new ExecSearchCompanyInfo();
		// START----------- comfirm searchFromName(companyName) method -----------START
//		String companyName = "を";
//		String companyName = "かきくけこを";
//		String companyName = "ヤラ";
//		String companyName = "ｦ";

//		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList1 = new ArrayList<CompanyStockBaseInfo>();
//
//		companyStockBaseInfoList1 = execSearchCompanyInfo.searchFromName(companyName);
//
//		for (int i = 0; i < companyStockBaseInfoList1.size(); i++) {
//			System.out.println("name : " + companyStockBaseInfoList1.get(i).getCompanyName() +
//					"securities_code:" + companyStockBaseInfoList1.get(i).getSecuritiesCode() +
//					"market:" + companyStockBaseInfoList1.get(i).getMarket());
//		}
		// END----------- comfirm searchFromName(companyName) method -----------END


		// START----------- comfirm searchFromSecuritiesCode(securitiesCode) method -----------START
//		String securitiesCode = "33333";
//		String securitiesCode = "00000";
//
//		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
//
//		companyStockBaseInfo = execSearchCompanyInfo.searchFromSecuritiesCode(securitiesCode);
//
//		System.out.println("name : " + companyStockBaseInfo.getCompanyName() +
//				"securities_code:" + companyStockBaseInfo.getSecuritiesCode() +
//				"market:" + companyStockBaseInfo.getMarket());
		// END----------- comfirm searchFromSecuritiesCode(securitiesCode) method -----------END


		// START----------- comfirm searchFromMarket(market) method -----------START
//		String market = "東証1部";
//		String market = "東証2部";
		String market = "東証3部";

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList2 = new ArrayList<CompanyStockBaseInfo>();


		companyStockBaseInfoList2 = execSearchCompanyInfo.searchFromMarket(market);

		for (int i = 0; i < companyStockBaseInfoList2.size(); i++) {
			System.out.println("name : " + companyStockBaseInfoList2.get(i).getCompanyName() +
					"securities_code:" + companyStockBaseInfoList2.get(i).getSecuritiesCode() +
					"market:" + companyStockBaseInfoList2.get(i).getMarket());
		}
		// END----------- comfirm searchFromMarket(market) method -----------END
	}
}
