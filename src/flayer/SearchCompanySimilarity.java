package flayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fieldformat.CompanyStockBaseInfo;
import fieldformat.CompanyStockBaseInfoWithDistance;
import fieldformat.SimilarityOfWord;

public class SearchCompanySimilarity {
	public ArrayList<CompanyStockBaseInfoWithDistance> calcSimilarity(String searchCompanyName,ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList) {
		ArrayList<CompanyStockBaseInfoWithDistance> companyStockBaseInfoWithDistanceList
			= new ArrayList<CompanyStockBaseInfoWithDistance>();

		CalLevenshteinDistance calLevenshteinDistance = new CalLevenshteinDistance();

		for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
			SimilarityOfWord similarityOfWord = new SimilarityOfWord();

			similarityOfWord = calLevenshteinDistance.calculate(searchCompanyName, companyStockBaseInfoList.get(i).getCompanyName());

			CompanyStockBaseInfoWithDistance companyStockBaseInfoWithDistance = new CompanyStockBaseInfoWithDistance();

			companyStockBaseInfoWithDistance.setCompanyName(companyStockBaseInfoList.get(i).getCompanyName());
			companyStockBaseInfoWithDistance.setMarket(companyStockBaseInfoList.get(i).getMarket());
			companyStockBaseInfoWithDistance.setSecuritiesCode(companyStockBaseInfoList.get(i).getSecuritiesCode());
			companyStockBaseInfoWithDistance.setLevenshteinDistance(similarityOfWord.getLevenshteinDistance());
			companyStockBaseInfoWithDistance.setStandardizeLeven(similarityOfWord.getStandardizeLeven());

			companyStockBaseInfoWithDistanceList.add(companyStockBaseInfoWithDistance);
		}

		return companyStockBaseInfoWithDistanceList;
	}

	public ArrayList<CompanyStockBaseInfoWithDistance> sortByStandardizeLeven(ArrayList<CompanyStockBaseInfoWithDistance> companyStockBaseInfoWithDistanceList) {
		ToSortComparator toSortComparator = new ToSortComparator();
		Collections.sort(companyStockBaseInfoWithDistanceList, toSortComparator);

		return companyStockBaseInfoWithDistanceList;
	}
}

class ToSortComparator implements Comparator<CompanyStockBaseInfoWithDistance> {
	public int compare(CompanyStockBaseInfoWithDistance c1, CompanyStockBaseInfoWithDistance c2) {
		return Double.compare(c1.getStandardizeLeven(), c2.getStandardizeLeven());
	}


}