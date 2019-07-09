package fieldformat;

public class TradingCostTypeSelectCheckResult {
	private boolean isValidValue = false;

	private String errorMessage;

	private String tradingCostType;

	public boolean isValidValue() {
		return isValidValue;
	}

	public void setValidValue(boolean isValidValue) {
		this.isValidValue = isValidValue;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getTradingCostType() {
		return tradingCostType;
	}

	public void setTradingCostType(String tradingCostType) {
		this.tradingCostType = tradingCostType;
	}
}
