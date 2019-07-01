package fieldformat;

public class BrokerageCommissions {
	private int companyId;

	private String brokerageCommission;

	private String startDay;

	private String endDay;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getBrokerageCommission() {
		return brokerageCommission;
	}

	public void setBrokerageCommission(String brokerageCommission) {
		this.brokerageCommission = brokerageCommission;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
}
