package bean;

public class user {
	private String idUser;
	private String userAccount;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String userPictureUrl;
	public String getUserPictureUrl() {
		return userPictureUrl;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	//private String userName;
	public user(){
		this.userAccount="账号名";
		this.userPassword="登录密码";
		this.userAddress="收货地址";
		this.userName="用户名";
		this.userPhone="手机号";
		this.userPictureUrl="用户图片路径";
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName ){
		this.userName=userName;
	}
	public String getUserAddress(){
		return userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}
	public String getUserPhone(){
		return userPhone;
	}
	public void setUserPhone(String userPhone){
		this.userPhone=userPhone;
	}
}
