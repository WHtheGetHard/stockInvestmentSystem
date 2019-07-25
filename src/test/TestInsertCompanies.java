package test;

import java.sql.SQLException;

import dlayer.InsertCompanies;
import fieldformat.Companies;

public class TestInsertCompanies {
	public static void main(String[] args) {
		// companies table has a record
		// id:1, name:XYZ
		// id:2, name:ABC
		// id:3, name:CATENT

		Companies companies = new Companies();
		int insertNumber = 0;
		InsertCompanies insertCompanies = new InsertCompanies();

		// START----------- comfirm execInsertOnlyName(name) method -----------START
//		String name = "AAA"; // 1
//		String name = "AAA"; // 1
//		String name = "XYZ"; // 1
//		try {
//			insertNumber = insertCompanies.execInsertOnlyName(name);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		System.out.println(insertNumber);
		// END----------- comfirm execInsertOnlyName(name) method -----------END


		// START----------- comfirm execInsert(companies) method -----------START
		// error
//		companies.setId(1);
//		companies.setName("AAA");

		// 1
		companies.setId(7);
		companies.setName("AAA");

		try {
			insertNumber = insertCompanies.execInsert(companies);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(insertNumber);
		// END----------- comfirm execInsert(companies) method -----------END
	}
}
