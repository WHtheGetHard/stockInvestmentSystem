package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dlayer.SelectCompanies;
import fieldformat.Companies;

public class TestSelectCompanies {
	public static void main(String[] args) {
		// companies table has a record
		// id:1, name:XYZ
		// id:2, name:ABC
		// id:3, name:CATENT

		Companies companies = new Companies();
		ArrayList<Companies> companiesList = new ArrayList<Companies>();

		SelectCompanies selectCompanies = new SelectCompanies();

		// START----------- comfirm selectFromId(id) method -----------START
//		int id = 0; // null
//		int id = 1;
//		int id = 4; // null

//		try {
//			companies = selectCompanies.selectFromId(id);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println("id : " + companies.getId());
//		System.out.println("name : " + companies.getName());
		// END----------- comfirm selectFromId(id) method -----------END


		// START----------- comfirm selectFromName(name) method -----------START
//		String name = "AAA"; // null
//		String name = "ABC";
//		String name = "C"; // null

//		try {
//			companies = selectCompanies.selectFromName(name);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//
//		System.out.println("id : " + companies.getId());
//		System.out.println("name : " + companies.getName());
		// END----------- comfirm selectFromName(name) method -----------END

		// START----------- comfirm selectFromAmbiguous(name) method -----------START
//		String name = "X"; // 1
//		String name = "Y"; // 1
//		String name = "A"; // 2
//
//		try {
//			companiesList = selectCompanies.selectFromAmbiguous(name);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		for (int i = 0; i < companiesList.size(); i++) {
//			System.out.println("id : " + companiesList.get(i).getId());
//			System.out.println("name : " + companiesList.get(i).getName());
//		}
		// END----------- comfirm selectFromAmbiguous(name) method -----------END

		// START----------- comfirm selectCountName(name) method -----------START
		int countNumber = 0;

//		String name = "AAA"; //3
		String name = "BBB"; //0

		try {
			countNumber = selectCompanies.selectCountName(name);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(countNumber);
		// END----------- comfirm selectCountName(name) method -----------END
	}
}
