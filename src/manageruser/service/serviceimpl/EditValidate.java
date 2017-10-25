package manageruser.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manageruser.model.User;
import manageruser.service.RegistrationService;
/**
 * Validate form edit
 * @author Chu lun Kute
 *
 */
public class EditValidate implements RegistrationService {
	private User user;
	private List<String> errors = new ArrayList<>();

	
	public EditValidate(User user) {
		super();
		this.user = user;
	}

	/* validate form edit
	 * @see manageruser.service.RegistrationService#validate()
	 */
	@Override
	public List<String> validate() {
		validateFullName();
		validateKana();
		validateEmail();
		validateTel();
		validateLinkImage();
		validateNameLevel();
		return errors;
	}
	
	/**
	 * Kiem tra truong fullName
	 * ko dc de trog
	 */
	private void validateFullName(){
		if ("".equals(user.getFullName())) {
			errors.add("Fullname khong duoc de trong");
		}
	}

	/**
	 * Kiem tra truong fullNameKana
	 * fullNameKana ko dc de trong
	 * phai la ki tu kana
	 */
	private void validateKana() {
		if ("".equals(user.getFullNameKana())){
			errors.add("Full Name Kana ko duoc de trong");
			return;
		}
	    Pattern pat = Pattern.compile("^\\p{InKatakana}+");
	    Matcher m = pat.matcher(user.getFullNameKana());
	    if(!m.matches()) {
	        errors.add("Full name kana sai dinh dang");
	    }
	}
	/**
	 * Kiem tra truong email 
	 * khong duoc de trong
	 * dung đinh dang
	 */
	private void validateEmail() {
		if ("".equals(user.getEmail())){
			errors.add("Email ko duoc de trong");
			return;
		}
		String validator= "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*"
		 		+ "@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	
		if (!user.getEmail().matches(validator)) {
			errors.add("Email sai dinh dang");
		}
	}
	/**
	 * Kiem tra truong tel
	 * ko de de trong
	 */
	private void validateTel(){
		if ("".equals(user.getTel())) {
			errors.add("Tel khong duoc de trong");
		}
	}
	/**
	 * Kiem tra truong linkImage
	 * ko de de trong
	 */
	private void validateLinkImage(){
		if ("".equals(user.getLinkImage())) {
			errors.add("Link Image khong duoc de trong");
		}
	}
	/**
	 * Ham kiem tra 2 truong name level va total
	 * 2 cai phai cung dien hoac cung de trong
	 */
	private void validateNameLevel() {
		if (("".equals(user.getNameLevel()) && (user.getTotal() == 0))) {
			return;
		}
		if (!("".equals(user.getNameLevel())) && (user.getTotal() > 0)){
			return;
		}
		errors.add("Name level vs total phai cung dien");
	}
	
	
}
