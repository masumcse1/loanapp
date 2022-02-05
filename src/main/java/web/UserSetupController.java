package web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.UserInfo;


/**
 * @author Rajib Kumer Ghosh
 *
 */

@Named
@ViewScoped
public class UserSetupController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserInfo userInfo;

		
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@PostConstruct
	public void init() {
		System.out.println("===============User Details===============");
	}
	
	public void saveData() {		
		System.out.println("data " + userInfo);		
	}

	public void update() {		
		System.out.println("data " + userInfo);		
	}

	public void delete() {		
		System.out.println("data " + userInfo);			
	}

}
