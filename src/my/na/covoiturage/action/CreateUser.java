package my.na.covoiturage.action;

import com.opensymphony.xwork2.ActionSupport;

import my.na.covoiturage.service.user.IUserService;
import my.na.covoiturage.service.user.UserServiceImpl;
import my.na.covoiturage.util.InformationErrorException;

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
			
				userService.createUser(newUserName, newPassword);
			
		} catch (InformationErrorException e) {
			addActionError(e.getMsg());
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
		
		if(!newPassword.equals(passwordConfimation)){
			addActionError("password not confirmed");
		}
		super.validate();
		
	}

	
	
	
}
