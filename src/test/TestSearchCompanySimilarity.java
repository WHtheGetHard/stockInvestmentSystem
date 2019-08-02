package test;

import java.util.ArrayList;

import fieldformat.CompanyStockBaseInfo;
import fieldformat.CompanyStockBaseInfoWithDistance;
import flayer.SearchCompanySimilarity;

public class TestSearchCompanySimilarity {
	public static void main(String[] args) {

		// START-------------- confirm calcSimilarity(searchCompanyName, companyStockBaseInfoList)method --------------START
		String searchCompanyName = "gest";
		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();

		CompanyStockBaseInfo companyStockBaseInfo1 = new CompanyStockBaseInfo(); companyStockBaseInfo1.setCompanyName("rest");
		CompanyStockBaseInfo companyStockBaseInfo2 = new CompanyStockBaseInfo(); companyStockBaseInfo2.setCompanyName("gest account");
		CompanyStockBaseInfo companyStockBaseInfo3 = new CompanyStockBaseInfo(); companyStockBaseInfo3.setCompanyName("test");
		CompanyStockBaseInfo companyStockBaseInfo4 = new CompanyStockBaseInfo(); companyStockBaseInfo4.setCompanyName("just");
		companyStockBaseInfoList.add(companyStockBaseInfo1);
		companyStockBaseInfoList.add(companyStockBaseInfo2);
		companyStockBaseInfoList.add(companyStockBaseInfo3);
		companyStockBaseInfoList.add(companyStockBaseInfo4);


		ArrayList<CompanyStockBaseInfoWithDistance> companyStockBaseInfoWithDistanceList = new ArrayList<CompanyStockBaseInfoWithDistance>();

		SearchCompanySimilarity searchCompanySimilarity = new SearchCompanySimilarity();
		companyStockBaseInfoWithDistanceList = searchCompanySimilarity.calcSimilarity(searchCompanyName, companyStockBaseInfoList);

		for (int i = 0; i < companyStockBaseInfoWithDistanceList.size(); i++) {
			System.out.print("名前 : " + companyStockBaseInfoWithDistanceList.get(i).getCompanyName() + " ");
			System.out.print("レーベンシュタイン距離 : " + companyStockBaseInfoWithDistanceList.get(i).getLevenshteinDistance() + " ");
			System.out.println("標準化レーベンシュタイン距離 : " + companyStockBaseInfoWithDistanceList.get(i).getStandardizeLeven() + " ");
		}
		// END-------------- confirm calcSimilarity(searchCompanyName, companyStockBaseInfoList)method --------------END
	}
}
