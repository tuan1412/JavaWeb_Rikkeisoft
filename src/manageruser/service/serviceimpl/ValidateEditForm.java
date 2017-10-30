package manageruser.service.serviceimpl;


import java.util.HashMap;
import java.util.Map;
import manageruser.model.User;

/**
 * Validate form edit
 * @author Chu lun Kute
 *
 */
public class ValidateEditForm extends ValidateServiceImpl {
	private User user;
	private Map<String, String> errors = new HashMap<>();

	
	public ValidateEditForm(User user) {
		super();
		this.user = user;
	}

	/* validate form edit
	 * @see manageruser.service.RegistrationService#validate()
	 */
	@Override
	public Map<String, String> validate() {
		validateFullName(user.getFullName());
		validateKana(user.getFullNameKana());
		validateEmail(user.getEmail());
		validateTel(user.getTel());
		validateLinkImage(user.getLinkImage());
		validateNameLevel(user.getNameLevel(), user.getTotal());
		return errors;
	}
}
