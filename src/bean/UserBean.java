package bean;

public class UserBean {
	private String userAccount;
	private String userPassword;
	private String userName;
	private String idUser;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public UserBean(){
		this.userAccount="初始化";
		this.userPassword="初始化";
		this.userName="alwjreogij";
		this.idUser="...";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
