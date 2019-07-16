package flayer;

import java.util.ArrayList;

public class CurrencyEdit {
	public String commaEdit(String beforeEdit) {
		String[] splitToChar;
		splitToChar = beforeEdit.split("");

		ArrayList<String> addComma = new ArrayList<String>();

		int counter = 0;
		for (int i = splitToChar.length - 1; i >= 0; i--) {
			if (counter != 0 && (counter % 3) == 0) {
				addComma.add(",");
			}
			addComma.add(splitToChar[i]);

			counter++;
		}

		StringBuilder concatAddComma = new StringBuilder();

		for (int i = addComma.size() - 1; i >= 0; i--) {
			concatAddComma.append(addComma.get(i));
		}


		String afterEdit = concatAddComma.toString();

		return afterEdit;
	}
}
