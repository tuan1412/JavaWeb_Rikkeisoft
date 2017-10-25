package manageruser.service.serviceimpl;

import manageruser.dao.DeleteUser;
import manageruser.dao.daoimpl.DeleteUserImpl;
import manageruser.service.DeleteService;

public class DeleteUserServiceImpl implements DeleteService{
	int userId;

	public DeleteUserServiceImpl(int userId) {
		super();
		this.userId = userId;
	}

	/* goi toi dao, del user
	 * @see manageruser.service.DeleteService#deleteUser()
	 */
	@Override
	public void deleteUser() {
		DeleteUser deleteUser = new DeleteUserImpl(userId);
		deleteUser.delete();
	}	
}
