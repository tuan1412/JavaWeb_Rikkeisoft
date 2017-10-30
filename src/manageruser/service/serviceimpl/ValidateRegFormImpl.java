/**
 * 
 */
package manageruser.service.serviceimpl;

import java.util.Map;

import manageruser.model.RegForm;


/**
 * Class validate form dang ky
 * @author Chu lun Kute
 *
 */
public class ValidateRegFormImpl extends ValidateServiceImpl{
	private RegForm regForm;
		
	public ValidateRegFormImpl(RegForm regForm) {
		this.regForm = regForm;
	}

	/* ham validate tong the
	 * @see manageruser.service.RegistrationService#validate()
	 */
	@Override
	public Map<String, String> validate() {
		validateFullName(regForm.getFullName());
		validateKana(regForm.getFullNameKana());
		validateEmail(regForm.getEmail());
		validateLoginName(regForm.getLoginName());
		validatePass(regForm.getPassword(), regForm.getConfirmPassword());
		validateTel(regForm.getTel());
		validateLinkImage(regForm.getLinkImage());
		validateNameLevel(regForm.getNameLevel(), regForm.getTotal());
		return errors;
	}
}
