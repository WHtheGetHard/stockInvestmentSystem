package fieldformat;

public class UserInfoRegistCheckResult {
	private boolean isRegistSuccess = false;

	private String message;

	private UserInformation userInformation = new UserInformation();

	public boolean isRegistSuccess() {
		return isRegistSuccess;
	}

	public void setRegistSuccess(boolean isRegistSuccess) {
		this.isRegistSuccess = isRegistSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
}
