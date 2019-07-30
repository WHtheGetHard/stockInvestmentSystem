package test;

import fieldformat.SimilarityOfWord;
import flayer.CalLevenshteinDistance;

public class TestCalLevenshteinDistance {
	public static void main(String[] args) {
		CalLevenshteinDistance calLevenshteinDistance = new CalLevenshteinDistance();

//		String base = "アイス";
//		String target = "ノート"; //3, 1.0

		String base = "ミルクチョコレート";
		String target = "チョコレート"; //3 ,0.33

		SimilarityOfWord similarityOfWord = new SimilarityOfWord();
		similarityOfWord = calLevenshteinDistance.calculate(base, target);

		System.out.println("編集距離  : " + similarityOfWord.getLevenshteinDistance());
		System.out.println("類似度 : " + similarityOfWord.getStandardizeLeven());
	}
}
