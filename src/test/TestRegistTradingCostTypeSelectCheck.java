package test;

import fieldformat.RegistTradingCostTypeSelectCheckResult;
import flayer.RegistTradingCostTypeSelectCheck;

public class TestRegistTradingCostTypeSelectCheck {
	public static void main(String[] args) {
		// follow the test case
		String testArgs = "１";

		RegistTradingCostTypeSelectCheck registTradingCostTypeSelectCheck
			= new RegistTradingCostTypeSelectCheck();

		RegistTradingCostTypeSelectCheckResult registTradingCostTypeSelectCheckResult
			 = new RegistTradingCostTypeSelectCheckResult();

		registTradingCostTypeSelectCheckResult
			 = registTradingCostTypeSelectCheck.selectedValueCheck(testArgs);

		System.out.println("確認結果：" + registTradingCostTypeSelectCheckResult.isValidValue());
		System.out.println("エラーメッセージ：" +registTradingCostTypeSelectCheckResult.getErrorMessage());
		System.out.println("選択値：" + registTradingCostTypeSelectCheckResult.getTradingCostType());
	}
}
