package commonparts;


public class HalfNumberCheck {
	public boolean execCheck(String inputValue) {
		boolean isOnlyHalfNumber = false;

		final String REGEX = "^[0-9]+$";

		isOnlyHalfNumber = inputValue.matches(REGEX);

		return isOnlyHalfNumber;
	}
}
