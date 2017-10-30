package manageruser.service.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manageruser.service.ValidateService;

public abstract class ValidateServiceImpl implements ValidateService {
	
	protected Map<String, String> errors = new HashMap<>();
	
	/* (non-Javadoc)
	 * @see manageruser.service.ValidateService#validate()
	 */
	/**
	 * Kiem tra truong fullName
	 * ko dc de trog
	 */
	protected void validateFullName(String fullName){
		if ("".equals(fullName)){
			errors.put("fullName", "Fullname khong duoc de trong");
		}
	}
	/**
	 * Kiem tra truong pass
	 * pass va confirm pass ko dc de trong
	 * pass va confirm pass phai giong nhau
	 */
	protected void validatePass(String password, String confirmPassword) {
		boolean flag = true;
		if ("".equals(password)){
			errors.put("password", "Password khong duoc de trong");
			flag = false;
		}
		if ("".equals(confirmPassword)){
			errors.put("repassword","Confirm Password khong duoc de trong");
			flag = false;
		}
		if (flag) {
			if (!password.equals(confirmPassword)){
				errors.put("password","Password va Confirm password phai giong nhau");
			}
		}
	}
	/**
	 * Kiem tra truong fullNameKana
	 * fullNameKana ko dc de trong
	 * phai la ki tu kana
	 */
	protected void validateKana(String fullNameKana) {
		if ("".equals(fullNameKana)){
			errors.put("kana","Full Name Kana ko duoc de trong");
			return;
		}
	    Pattern pat = Pattern.compile("^\\p{InKatakana}+");
	    Matcher m = pat.matcher(fullNameKana);
	    if(!m.matches()) {
	        errors.put("kana","Full name kana sai dinh dang");
	    }
	}
	/**
	 * Kiem tra truong email 
	 * khong duoc de trong
	 * dung đinh dang
	 */
	protected void validateEmail(String email) {
		if ("".equals(email)){
			errors.put("email", "Email ko duoc de trong");
			return;
		}
		String validator= "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*"
		 		+ "@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	
		if (!email.matches(validator)) {
			errors.put("email","Email sai dinh dang");
		}
	}
	/**
	 * Kiem tra truong tel
	 * ko de de trong
	 */
	protected void validateTel(String tel){
		if ("".equals(tel)){
			errors.put("tel","Tel khong duoc de trong");
		}
	}
	/**
	 * Kiem tra truong linkImage
	 * ko de de trong
	 */
	protected void validateLinkImage(String linkImage){
		if ("".equals(linkImage)) {
			errors.put("linkImage","Link Image khong duoc de trong");
		}
	}
	/**
	 * Ham kiem tra 2 truong name level va total
	 * 2 cai phai cung dien hoac cung de trong
	 */
	protected void validateNameLevel(String nameLevel, int total) {
		if (("".equals(nameLevel) && (total == 0))) {
			return;
		}
		if (!("".equals(nameLevel) && (total > 0))){
			return;
		}
		errors.put("nameLevel","Name level vs total phai cung dien");
	}
	/**
	 *  Ham kiem tra truong loginName
	 *  ko de de trong
	 */
	protected void validateLoginName(String loginName){
		if ("".equals(loginName)) {
			errors.put("loginName","Login Name khong duoc de trong");
		}
	}
	
}
