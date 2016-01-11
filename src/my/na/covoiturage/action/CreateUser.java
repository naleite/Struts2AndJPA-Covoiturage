package my.na.covoiturage.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import my.na.covoiturage.service.user.IUserService;
import my.na.covoiturage.service.user.UserServiceImpl;
import my.na.covoiturage.util.InformationErrorException;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUser extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	
	private String newUserName;
	
	private String newPassword;
	
	private String passwordConfimation;
	
	private static final String SUCCESS = "success";
	
	public CreateUser() {
		userService = new UserServiceImpl();
	}
	
	public String createCompte() throws InformationErrorException{
		
		try {
			
			byte[] passByte=newPassword.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			try{
				userService.createUser(newUserName, newPassword);
			}
			catch(InformationErrorException e){
				addActionError(e.getMsg());
			}
				
			
		} catch ( UnsupportedEncodingException | NoSuchAlgorithmException e) {
			
			return "input";
		}
		
		return "success";
	}

	public final IUserService getUserService() {
		return userService;
	}

	public final void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public final String getNewUserName() {
		return newUserName;
	}

	public final void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public final String getNewPassword() {
		return newPassword;
	}

	public final void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public final String getPasswordConfimation() {
		return passwordConfimation;
	}

	public final void setPasswordConfimation(String passwordConfimation) {
		this.passwordConfimation = passwordConfimation;
	}

	@Override
	public void validate() {
		if(newUserName==null || newUserName.isEmpty()||newPassword==null){
			addActionError("Username can not be empty");
		}
		if(!newPassword.equals(passwordConfimation)){
			addActionError("password not confirmed");
		}
		super.validate();
		
	}

	
	
	
}
