package test;

import flayer.ConfirmCompaniesRegistered;

public class TestConfirmCompaniesRegistered {
	public static void main(String[] args) {
		ConfirmCompaniesRegistered confirmCompaniesRegistered = new ConfirmCompaniesRegistered();

//		String name = "AAA"; // 3⇒true
//		String name = "XYZ"; // 1⇒true
		String name = "ZZZ"; // 0⇒false

		boolean isRegistered = confirmCompaniesRegistered.isRegistered(name);
		System.out.println("登録済み : " + isRegistered);

	}
}
