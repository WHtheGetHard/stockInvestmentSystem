package flayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fieldformat.CompanyStockBaseInfo;

public class SecuritiesCode {
	private final String urlFirst = "https://m.finance.yahoo.co.jp/search?q=";
	private final String urlLast = "&type=all";

	public String accessTargetPage(String companyName) {
		String article = "";


		String url = urlFirst + companyName + urlLast;

		SearchWebPage searchWebPage = new SearchWebPage();

		try {
			article = searchWebPage.search(url);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return article;
	}

	private final String regex1 = "<dt class=\"title\">([\\d\\D\\w\\W]+)</dt>";
	private final String regex2 = "<dd class=\"subText\">([0-9]{4})([\\d\\D\\w\\W]+)</dd>";

	public ArrayList<CompanyStockBaseInfo> getResults(String article) {
		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList
			= new ArrayList<CompanyStockBaseInfo>();

		String[] splitArticle = article.split("\n");

		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1;
		int firstMatch = 0;

		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2;

		for (int i = 0; i < splitArticle.length - 1; i++) {
			matcher1 = pattern1.matcher(splitArticle[i]);
			if (matcher1.find()) {
				firstMatch = i;

				matcher2 = pattern2.matcher(splitArticle[firstMatch + 1]);

				if (matcher2.find()) {
					CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

					companyStockBaseInfo.setCompanyName(matcher1.group(1));
					companyStockBaseInfo.setSecuritiesCode(matcher2.group(1));
					companyStockBaseInfo.setMarket(matcher2.group(2).replaceAll("（", "").replaceAll("）", ""));

					companyStockBaseInfoList.add(companyStockBaseInfo);
				}
			}

		}

		return companyStockBaseInfoList;
	}
}