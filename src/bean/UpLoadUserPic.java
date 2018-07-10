package bean;

import java.io.File;

public class UpLoadUserPic {
	private File UserPic;
	private String UserPicFileName;
	private String UserPicContentType;
	private String updateUserName;
	private String updateUserPassword;
	private String updateUserAddress;
	private String updateUserPhone;
	private String userAccount;
	public UpLoadUserPic(){
		this.UserPic=new File("D:\\08CB4D1EC4928B8C5174B6083B49CDF8.jpg");
		this.UserPicFileName="08CB4D1EC4928B8C5174B6083B49CDF8.jpg";
		this.UserPicContentType="image\\jpg";
		this.updateUserPassword="修改密码";
		this.updateUserName="修改用户名";
		this.updateUserAddress="修改地址";
		this.updateUserPhone="修改电话";
		this.userAccount="用户账号";//不可修改，作为更改寻找的依据
	}
	public File getUserPic() {
		return UserPic;
	}
	public void setUserPic(File userPic) {
		UserPic = userPic;
	}
	public String getUserPicFileName() {
		return UserPicFileName;
	}
	public void setUserPicFileName(String userPicFileName) {
		UserPicFileName = userPicFileName;
	}
	public String getUserPicContentType() {
		return UserPicContentType;
	}
	public void setUserPicContentType(String userPicContentType) {
		UserPicContentType = userPicContentType;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public String getUpdateUserPassword() {
		return updateUserPassword;
	}
	public void setUpdateUserPassword(String updateUserPassword) {
		this.updateUserPassword = updateUserPassword;
	}
	public String getUpdateUserAddress() {
		return updateUserAddress;
	}
	public void setUpdateUserAddress(String updateUserAddress) {
		this.updateUserAddress = updateUserAddress;
	}
	public String getUpdateUserPhone() {
		return updateUserPhone;
	}
	public void setUpdateUserPhone(String updateUserPhone) {
		this.updateUserPhone = updateUserPhone;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
}
