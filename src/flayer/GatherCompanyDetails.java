package flayer;

import java.util.ArrayList;

import fieldformat.CompanyDetails;
import fieldformat.CompanyStockBaseInfo;

public class GatherCompanyDetails {
	private ArrayList<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();

	public ArrayList<CompanyDetails> execGather(ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList) {
		for (int i = 0; i < companyStockBaseInfoList.size(); i++) {
			CompanyDetails companyDetails = new CompanyDetails();
			companyDetails.setCompanyName(companyStockBaseInfoList.get(i).getCompanyName());
			companyDetails.setSales("" + i);

			this.companyDetailsList.add(companyDetails);
		}

		return this.companyDetailsList;
	}
}
