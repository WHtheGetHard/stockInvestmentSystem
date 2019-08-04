package fieldformat;

public class UserInformation {
	private int userId;

	private String userName;

	private String userMail;

	private String userPassword;

	private boolean isLoggingIn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isLoggingIn() {
		return isLoggingIn;
	}

	public void setLoggingIn(boolean isLoggingIn) {
		this.isLoggingIn = isLoggingIn;
	}
}
