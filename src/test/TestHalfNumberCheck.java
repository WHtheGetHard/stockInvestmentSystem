package test;

import commonparts.HalfNumberCheck;


public class TestHalfNumberCheck {
	public static void main(String[] args) {
		String testArgs = "１1";

		HalfNumberCheck halfNumberCheck = new HalfNumberCheck();

		System.out.println("結果：" + halfNumberCheck.execCheck(testArgs));
	}
}
