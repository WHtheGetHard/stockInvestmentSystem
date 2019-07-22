package test;

import flayer.CalLevenshteinDistance;

public class TestCalLevenshteinDistance {
	public static void main(String[] args) {
		CalLevenshteinDistance calLevenshteinDistance = new CalLevenshteinDistance();

		String base = "すうがく";
//		String target = "すうがく"; //0
//		String target = "すがた"; //2
		String target = "春日部";//4

		int distance = calLevenshteinDistance.calculate(base, target);

		System.out.println(distance);
	}
}
