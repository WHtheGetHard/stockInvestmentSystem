package fieldformat;

public class CompanyStockBaseInfoWithDistance {
	private String companyName;

	private String securitiesCode;

	private String market;

	private int levenshteinDistance;

	private double standardizeLeven;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSecuritiesCode() {
		return securitiesCode;
	}

	public void setSecuritiesCode(String securitiesCode) {
		this.securitiesCode = securitiesCode;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public int getLevenshteinDistance() {
		return levenshteinDistance;
	}

	public void setLevenshteinDistance(int levenshteinDistance) {
		this.levenshteinDistance = levenshteinDistance;
	}

	public double getStandardizeLeven() {
		return standardizeLeven;
	}

	public void setStandardizeLeven(double standardizeLeven) {
		this.standardizeLeven = standardizeLeven;
	}
}
