/**
 * 
 */
package manageruser.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manageruser.model.RegForm;
import manageruser.service.RegistrationService;

/**
 * Class validate form dang ky
 * @author Chu lun Kute
 *
 */
public class RegistrationServiceImpl implements RegistrationService{
	private RegForm regForm;
	
	private List<String> errors = new ArrayList<>();
	
	
	public RegistrationServiceImpl(RegForm regForm) {
		this.regForm = regForm;
	}

	/* ham validate tong the
	 * @see manageruser.service.RegistrationService#validate()
	 */
	@Override
	public List<String> validate() {
		validateFullName();
		validateKana();
		validateEmail();
		validatePass();
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
		if ("".equals(regForm.getFullName())) {
			errors.add("Fullname khong duoc de trong");
		}
	}
	/**
	 * Kiem tra truong pass
	 * pass va confirm pass ko dc de trong
	 * pass va confirm pass phai giong nhau
	 */
	private void validatePass() {
		boolean flag = true;
		if ("".equals(regForm.getPassword())){
			errors.add("Password khong duoc de trong");
			flag = false;
		}
		if ("".equals(regForm.getConfirmPassword())){
			errors.add("Confirm Password khong duoc de trong");
			flag = false;
		}
		if (flag) {
			if (!regForm.getPassword().equals(regForm.getConfirmPassword())){
				errors.add("Password va Confirm password phai giong nhau");
			}
		}
	}
	/**
	 * Kiem tra truong fullNameKana
	 * fullNameKana ko dc de trong
	 * phai la ki tu kana
	 */
	private void validateKana() {
		if ("".equals(regForm.getFullNameKana())){
			errors.add("Full Name Kana ko duoc de trong");
			return;
		}
	    Pattern pat = Pattern.compile("^\\p{InKatakana}+");
	    Matcher m = pat.matcher(regForm.getFullNameKana());
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
		if ("".equals(regForm.getEmail())){
			errors.add("Email ko duoc de trong");
			return;
		}
		String validator= "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*"
		 		+ "@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	
		if (!regForm.getEmail().matches(validator)) {
			errors.add("Email sai dinh dang");
		}
	}
	/**
	 * Kiem tra truong tel
	 * ko de de trong
	 */
	private void validateTel(){
		if ("".equals(regForm.getTel())) {
			errors.add("Tel khong duoc de trong");
		}
	}
	/**
	 * Kiem tra truong linkImage
	 * ko de de trong
	 */
	private void validateLinkImage(){
		if ("".equals(regForm.getLinkImage())) {
			errors.add("Link Image khong duoc de trong");
		}
	}
	/**
	 * Ham kiem tra 2 truong name level va total
	 * 2 cai phai cung dien hoac cung de trong
	 */
	private void validateNameLevel() {
		if (("".equals(regForm.getNameLevel()) && (regForm.getTotal() == 0))) {
			return;
		}
		if (!("".equals(regForm.getNameLevel())) && (regForm.getTotal() > 0)){
			return;
		}
		errors.add("Name level vs total phai cung dien");
	}
}
