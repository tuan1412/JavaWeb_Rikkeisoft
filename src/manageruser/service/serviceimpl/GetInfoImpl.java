package manageruser.service.serviceimpl;

import manageruser.dao.UserInfo;
import manageruser.dao.daoimpl.UserInfoImpl;
import manageruser.model.User;
import manageruser.service.GetInfoService;

/**
 * Lay thong tin user dua vao id
 * @author Chu lun Kute
 *
 */
public class GetInfoImpl implements GetInfoService{
	private int userId;

	public GetInfoImpl(int userId) {
		super();
		this.userId = userId;
	}
	
	/* lay thong tin user dua vao Id
	 * @see manageruser.service.GetInfo#getInfoUser()
	 */
	@Override
	public User getInfoUser() {
		UserInfo userInfo = new UserInfoImpl(userId);
		return userInfo.getUserInfo();
	}

}
