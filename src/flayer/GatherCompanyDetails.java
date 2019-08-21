package flayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fieldformat.CompanyDetails;
import fieldformat.CompanyStockBaseInfo;

public class GatherCompanyDetails {
	private ArrayList<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();

	public ArrayList<CompanyDetails> execGather(ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList) {
		SearchWebPage searchWebPage = new SearchWebPage();
		for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
			String url = createTargetWebUrl(companyStockBaseInfoList.get(i));

			String article = "";
			try {
				article = searchWebPage.search(url);
			} catch (MalformedURLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			CompanyDetails companyDetails = new CompanyDetails();
			companyDetails = extractElement(article);
			companyDetails.setCompanyName(companyStockBaseInfoList.get(i).getCompanyName());

			this.companyDetailsList.add(companyDetails);

		}

		return this.companyDetailsList;
	}

	public String createTargetWebUrl(CompanyStockBaseInfo companyStockBaseInfo) {
		String url = "https://jp.reuters.com/investing/quotes/profitLoss?symbol=";
		url = url + companyStockBaseInfo.getSecuritiesCode() + ".T";

		return url;
	}

	public CompanyDetails extractElement(String article) {
		CompanyDetails companyDetails = new CompanyDetails();

		String startMarkRegex = "<th>損益計算書</th>";
		int startIndex = 0;

		String endMarkRegex = "<td>支払配当金</td>";
		int endIndex = 0;

		String[] splitInputArg = article.split("\n");

		Pattern patternStart = Pattern.compile(startMarkRegex);
		Matcher mStart;

		Pattern patternEnd = Pattern.compile(endMarkRegex);
		Matcher mEnd;

		for (int i = 0; i < splitInputArg.length; i++) {
			mStart = patternStart.matcher(splitInputArg[i]);
			mEnd = patternEnd.matcher(splitInputArg[i]);

			if (mStart.find()) {
				startIndex = i;
			} else if (mEnd.find()) {
				endIndex = i;
			}
		}

		String regex1 = "<td>売上高</td>";
		int regex1Index = 0;
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1;

		String regex2 = "<td>売上総利益</td>";
		int regex2Index = 0;
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2;

		String regex3 = "<td>営業利益</td>";
		int regex3Index = 0;
		Pattern p3 = Pattern.compile(regex3);
		Matcher m3;

		String regex4 = "";
		int regex4Index = 0;
		Pattern p4 = Pattern.compile(regex4);
		Matcher m4;

		String regex5 = "<td>税引前利益</td>";
		int regex5Index = 0;
		Pattern p5 = Pattern.compile(regex5);
		Matcher m5;

		String regex6 = "<td>当期利益</td>";
		int regex6Index = 0;
		Pattern p6 = Pattern.compile(regex6);
		Matcher m6;

		for (int i = startIndex; i < endIndex; i++) {
			m1 = p1.matcher(splitInputArg[i]);
			if (m1.find()) {
				regex1Index = i + 4;
			}

			m2 = p2.matcher(splitInputArg[i]);
			if (m2.find()) {
				regex2Index = i + 4;
			}

			m3 = p3.matcher(splitInputArg[i]);
			if (m3.find()) {
				regex3Index = i + 4;
			}

			m4 = p4.matcher(splitInputArg[i]);
			if (m4.find()) {
				regex4Index = i + 4;
			}

			m5 = p5.matcher(splitInputArg[i]);
			if (m5.find()) {
				regex5Index = i + 4;
			}

			m6 = p6.matcher(splitInputArg[i]);
			if (m6.find()) {
				regex6Index = i + 4;
			}
		}

		if (regex1Index > 4) {
			companyDetails.setAmountOfSales(splitInputArg[regex1Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex1Index <= 4) {
			companyDetails.setAmountOfSales("NA");
		}

		if (regex2Index > 4) {
			companyDetails.setGrossProfit(splitInputArg[regex2Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex2Index <= 4) {
			companyDetails.setGrossProfit("NA");
		}

		if (regex3Index > 4) {
			companyDetails.setOperatingIncome(splitInputArg[regex3Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex3Index <= 4) {
			companyDetails.setOperatingIncome("NA");
		}

		if (regex4Index > 4) {
			companyDetails.setManagementProfit(splitInputArg[regex4Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex4Index <= 4) {
			companyDetails.setManagementProfit("NA");
		}

		if (regex5Index > 4) {
			companyDetails.setNetIncomeBeforeTax(splitInputArg[regex5Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex5Index <= 4) {
			companyDetails.setNetIncomeBeforeTax("NA");
		}

		if (regex6Index > 4) {
			companyDetails.setNetIncome(splitInputArg[regex6Index].replaceAll("<td class=\"data\">", "").replaceAll("</td>",""));
		} else if (regex6Index <= 4) {
			companyDetails.setNetIncome("NA");
		}

		return companyDetails;
	}
}
