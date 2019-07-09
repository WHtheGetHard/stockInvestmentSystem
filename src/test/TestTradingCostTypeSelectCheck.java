package test;

import fieldformat.TradingCostTransition;
import fieldformat.TradingCostTypeSelectCheckResult;
import flayer.TradingCostTypeSelectCheck;

public class TestTradingCostTypeSelectCheck {
	public static void main(String[] args) {
		TradingCostTypeSelectCheck tradingCostTypeSelectCheck = new TradingCostTypeSelectCheck();

		// START----------- comfirm selectedValueCheck(tradingCostTransition) method -----------START
		TradingCostTransition tradingCostTransition = new TradingCostTransition();

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("1");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("2");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("3");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("1");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("2");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is ""
//		tradingCostTransition.setTradingCostType("3");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is "売買関連費用(登録)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is "売買関連費用(登録)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("１");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is "売買関連費用(登録)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("0");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is "売買関連費用(登録)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("4");
//		tradingCostTransition.setCaller("regist");

		//ErrorMessage is "売買関連費用(参照)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is "売買関連費用(参照)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("あ");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is "売買関連費用(参照)の選択でエラーが発生しました。"
//		tradingCostTransition.setTradingCostType("10");
//		tradingCostTransition.setCaller("ref");

		//ErrorMessage is "売買関連費用の選択でエラーが発生しました。"
		tradingCostTransition.setTradingCostType("");
		tradingCostTransition.setCaller("a");

		TradingCostTypeSelectCheckResult tradingCostTypeSelectCheckResult  = new TradingCostTypeSelectCheckResult();

		tradingCostTypeSelectCheckResult = tradingCostTypeSelectCheck.selectedValueCheck(tradingCostTransition);

		System.out.print("ErrorMessage is " + tradingCostTypeSelectCheckResult.getErrorMessage());
		// END----------- comfirm selectedValueCheck(tradingCostTransition) method -----------END
	}
}
