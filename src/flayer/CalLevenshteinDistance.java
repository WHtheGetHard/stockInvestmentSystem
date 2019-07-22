package flayer;

public class CalLevenshteinDistance {
	public int calculate(String base, String target) {
		int distance = 0;

		char[] splitBase = base.toCharArray();
		int baseLength = splitBase.length;

		char[] splitTarget = target.toCharArray();
		int targetLength = splitTarget.length;

		int[][] toCalcuArray = new int[targetLength + 1][baseLength + 1];

		// TODO : Initialize
		for (int i = 1; i < baseLength + 1; i++) {
			toCalcuArray[0][i] = i;
		}

		for (int i = 1; i < targetLength + 1; i++) {
			toCalcuArray[i][0] = i;
		}

		int above = 0;
		int left = 0;
		int upperLeft = 0;
		boolean isUpperLeftSmallest = false;

		for (int i = 1; i < targetLength + 1; i++) {
			for (int j = 1; j < baseLength + 1; j++) {
				above = toCalcuArray[i - 1][j];
				left = toCalcuArray[i][j - 1];
				upperLeft = toCalcuArray[i - 1][j - 1];

				int[] toSort = {above, left, upperLeft};

				for (int x = 0; x < toSort.length - 1; x++) {
					for (int k = toSort.length - 1; k > x; k--) {
						if (toSort[k] < toSort[k-1]) {
							int temp = toSort[k];
							toSort[k] = toSort[k-1];
							toSort[k-1] = temp;
						}
					}
				}

				int minVal = toSort[0];

				if (minVal == upperLeft) {
					isUpperLeftSmallest = true;
				} else {
					isUpperLeftSmallest = false;
				}

				if (isUpperLeftSmallest) {
					if (splitBase[j - 1] == splitTarget[i - 1]) {
						toCalcuArray[i][j] = minVal;
					} else {
						toCalcuArray[i][j] = minVal + 1;
					}
				} else {
					toCalcuArray[i][j] = minVal + 1;
				}

			}
		}


		distance = toCalcuArray[targetLength][baseLength];

		return distance;
	}
}
