package study;

import java.util.ArrayList;
import java.util.Collections;

public class StudyAboutSort2 {
	public static void main(String[] args) {
		// sort by increase order
		ArrayList<Integer> sortTarget1 = new ArrayList<Integer>();

		sortTarget1.add(5);sortTarget1.add(1);sortTarget1.add(0); sortTarget1.add(10);

		for (int i = 0; i < sortTarget1.size(); i++) { if (i == sortTarget1.size() - 1) { System.out.print(sortTarget1.get(i) + " : "); } else { System.out.print(sortTarget1.get(i) + " ,"); } }

		// Collectionsクラスのsortメソッドを使う
		Collections.sort(sortTarget1);

		for (int i = 0; i < sortTarget1.size(); i++) { if (i == sortTarget1.size() - 1) { System.out.println(sortTarget1.get(i)); } else { System.out.print(sortTarget1.get(i) + " ,"); } }

		// sort by decrease order
		ArrayList<Integer> sortTarget2 = new ArrayList<Integer>();

		sortTarget2.add(0); sortTarget2.add(50); sortTarget2.add(60); sortTarget2.add(2);

		for (int i = 0; i < sortTarget2.size(); i++) { if (i == sortTarget2.size() - 1) { System.out.print(sortTarget2.get(i) + " : "); } else { System.out.print(sortTarget2.get(i) + " ,"); } }

		// Collectionsクラスのsortメソッドで第二引数にreverseOrderメソッドを指定
		Collections.sort(sortTarget2, Collections.reverseOrder());

		for (int i = 0; i < sortTarget2.size(); i++) { if (i == sortTarget2.size() - 1) { System.out.println(sortTarget2.get(i)); } else { System.out.print(sortTarget2.get(i) + " ,"); } }
	}
}
