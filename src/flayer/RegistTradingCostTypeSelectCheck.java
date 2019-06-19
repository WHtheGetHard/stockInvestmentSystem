package flayer;

import commonparts.HalfNumberCheck;
import fieldformat.RegistTradingCostTypeSelectCheckResult;

public class RegistTradingCostTypeSelectCheck {
	public RegistTradingCostTypeSelectCheckResult selectedValueCheck(String tradingCostType) {
		RegistTradingCostTypeSelectCheckResult registTradingCostTypeSelectCheckResult
			= new RegistTradingCostTypeSelectCheckResult();

		boolean isOnlyHalfNumber = false;
		HalfNumberCheck halfNumberCheck = new HalfNumberCheck();
		isOnlyHalfNumber = halfNumberCheck.execCheck(tradingCostType);

		if (isOnlyHalfNumber) {
			int intedTradingCostType = Integer.parseInt(tradingCostType);
			if (1 <= intedTradingCostType && intedTradingCostType <= 3) {
				registTradingCostTypeSelectCheckResult.setValidValue(true);
				registTradingCostTypeSelectCheckResult.setErrorMessage("");
				registTradingCostTypeSelectCheckResult.setTradingCostType(tradingCostType);
			} else {
				registTradingCostTypeSelectCheckResult.setValidValue(false);
				registTradingCostTypeSelectCheckResult.setErrorMessage("売買関連費用の選択でエラーが発生しました。");
				registTradingCostTypeSelectCheckResult.setTradingCostType("invalid value");
			}
		} else {
			registTradingCostTypeSelectCheckResult.setValidValue(false);
			registTradingCostTypeSelectCheckResult.setErrorMessage("売買関連費用の選択でエラーが発生しました。");
			registTradingCostTypeSelectCheckResult.setTradingCostType("invalid value");
		}

		return registTradingCostTypeSelectCheckResult;
	}
}
