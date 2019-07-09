package flayer;

import commonparts.HalfNumberCheck;
import fieldformat.TradingCostTransition;
import fieldformat.TradingCostTypeSelectCheckResult;

public class TradingCostTypeSelectCheck {
	public TradingCostTypeSelectCheckResult selectedValueCheck(TradingCostTransition tradingCostTransition) {
		TradingCostTypeSelectCheckResult tradingCostTypeSelectCheckResult
			= new TradingCostTypeSelectCheckResult();

		boolean isOnlyHalfNumber = false;
		HalfNumberCheck halfNumberCheck = new HalfNumberCheck();

		isOnlyHalfNumber = halfNumberCheck.execCheck(tradingCostTransition.getTradingCostType());

		if (isOnlyHalfNumber) {
			int intedTradingCostType = Integer.parseInt(tradingCostTransition.getTradingCostType());
			if (1 <= intedTradingCostType && intedTradingCostType <= 3) {
				tradingCostTypeSelectCheckResult.setValidValue(true);
				tradingCostTypeSelectCheckResult.setTradingCostType(tradingCostTransition.getTradingCostType());

				tradingCostTypeSelectCheckResult.setErrorMessage("");
			} else {
				tradingCostTypeSelectCheckResult.setValidValue(false);
				tradingCostTypeSelectCheckResult.setTradingCostType("invalid value");

				tradingCostTypeSelectCheckResult.setErrorMessage(
						setErrorMessage(tradingCostTransition.getCaller()));
			}
		} else {
			tradingCostTypeSelectCheckResult.setValidValue(false);
			tradingCostTypeSelectCheckResult.setTradingCostType("invalid value");

			tradingCostTypeSelectCheckResult.setErrorMessage(
					setErrorMessage(tradingCostTransition.getCaller()));
		}

		return tradingCostTypeSelectCheckResult;
	}

	private String setErrorMessage(String caller) {
		String errorMessage = "";

		if ("regist".equals(caller)) {
			errorMessage = "売買関連費用(登録)の選択でエラーが発生しました。";
		} else if ("ref".equals(caller)) {
			errorMessage = "売買関連費用(参照)の選択でエラーが発生しました。";
		} else {
			errorMessage = "売買関連費用の選択でエラーが発生しました。";
		}

		return errorMessage;
	}
}
