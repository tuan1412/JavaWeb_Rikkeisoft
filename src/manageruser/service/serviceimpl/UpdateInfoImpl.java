package manageruser.service.serviceimpl;

import manageruser.dao.UpdateUser;
import manageruser.dao.daoimpl.UpdateUserImpl;
import manageruser.model.User;
import manageruser.service.UpdateInfoService;

public class UpdateInfoImpl implements UpdateInfoService {
	private User user;

	public UpdateInfoImpl(User user) {
		super();
		this.user = user;
	}

	/* update thong tin user
	 * @see manageruser.service.UpdateInfoService#updateInfo()
	 */
	@Override
	public void updateInfo() {
		UpdateUser updateUser = new UpdateUserImpl(user);
		updateUser.update();	
	}
}
