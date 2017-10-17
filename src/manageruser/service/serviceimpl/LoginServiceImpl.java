package manageruser.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import manageruser.constant.Constant;
import manageruser.dao.daoimpl.LoginUserImpl;
import manageruser.service.LoginService;
/**
 * Class tao service kiem tra dang nhap
 * @author Chu lun Kute
 * 
 */
public class LoginServiceImpl implements LoginService{
	/**
	 * Dua ra list error khi ng dung nhap thong tin
	 */
	@Override
	public List<String> validate(String username, String password) {
		List<String> errors = new ArrayList<>();
		boolean flag = true;;
		
		if ("".equals(username)) {
			errors.add(Constant.USERNAME_ERROR);
			flag = false;
		}
		
		if ("".equals(password)) {
			errors.add(Constant.PASSWORD_ERROR);
			flag = false;
		}
		
		if (flag) {
			LoginUserImpl loginUser = new LoginUserImpl();
			if(!loginUser.checkUser(username, password)){
				errors.add(Constant.BOTH_ERROR);
			}
		}
		
		return errors;
	}
}
