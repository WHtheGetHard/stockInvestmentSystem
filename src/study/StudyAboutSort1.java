package study;

import java.util.Arrays;
import java.util.Collections;

public class StudyAboutSort1 {
	public static void main(String[] args) {
		//　配列のソート（昇順）を行う。
		int[] toSort1 = {4, 1, 5, 6};

		for (int i = 0; i < toSort1.length; i++) { if (i == toSort1.length - 1) { System.out.print(toSort1[i] + " : "); } else { System.out.print(toSort1[i] + " ,"); } }
		// Arraysクラスのsortメソッドを使用して昇順にソートする
		Arrays.sort(toSort1);

		for (int i = 0; i < toSort1.length; i++) {
			if (i == toSort1.length - 1) {
				System.out.println(toSort1[i]);
			} else {
				System.out.print(toSort1[i] + " ,");
			}
		}

		//　配列のソート（降順）を行う。
		// Collectionsクラスを追加場合は参照型でなければならないのでコンパイルエラー
        // int[] toSort2 = {1, 0, 9, 8};
		Integer[] toSort2 = {1, 0, 9, 8};

		for (int i = 0; i < toSort2.length; i++) { if (i == toSort2.length - 1) { System.out.print(toSort2[i] + " : "); } else { System.out.print(toSort2[i] + " ,"); } }
		// CollectionクラスのreverseOrderメソッドを第二引数に指定して降順にソートする
		Arrays.sort(toSort2, Collections.reverseOrder());

		for (int i = 0; i < toSort2.length; i++) {
			if (i == toSort2.length - 1) {
				System.out.println(toSort2[i]);
			} else {
				System.out.print(toSort2[i] + " ,");
			}
		}
	}
}
