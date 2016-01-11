package my.na.covoiturage.action;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

import my.na.covoiturage.model.User;
import my.na.covoiturage.service.user.IUserService;
import my.na.covoiturage.service.user.UserServiceImpl;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private User user;
	private IUserService userService;
	SessionMap<String,Object> sessionmap; 
	
	private static final String SUCCESS = "success";
	
	public LoginAction() {
		userService = new UserServiceImpl();
	}
	
	public String execute() throws Exception{
		if(user!=null&&user.equals(sessionmap.get("user"))){
			return SUCCESS;
		}
		
		
		user = userService.checkUser(user.getUsername(), user.getPassword());
		if(user==null){
			addActionError("Username or password invalid");
		}
		else{
			sessionmap.put("user", user);
			return SUCCESS;
		}
		return "input";
	}
	
	public String logout(){
		user = (User)sessionmap.get("user");
		if(user!=null){
			sessionmap.invalidate();
			return SUCCESS;
		}
		else{
			return "input";
		}
		
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public final IUserService getUserService() {
		return userService;
	}

	public final void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	public void validateExecute() {
		if(user==null){
			
		}
		if(user.getUsername()==null || user.getUsername().trim().isEmpty()){
			addFieldError("username", "username can not be empty");
		}
		if(user.getPassword()==null || user.getPassword().trim().isEmpty()){
			addFieldError("password", "password can not be empty");
		}
		super.validate();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionmap=(SessionMap)arg0; 
		//sessionmap.put("user", user);
		
	}
	
	

	
}
