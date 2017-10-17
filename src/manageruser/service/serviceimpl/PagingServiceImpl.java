package manageruser.service.serviceimpl;

import java.util.List;

import manageruser.constant.Constant;
import manageruser.dao.ListUser;
import manageruser.dao.daoimpl.ListUserPagingImpl;
import manageruser.model.User;
import manageruser.service.PagingService;

/**
 * Class dua ra noi dung trang ko sap xep
 * 
 * @author Chu lun Kute
 *
 */
public class PagingServiceImpl extends PagingService {

	public PagingServiceImpl(int page, String fullName, String email, String groupName) {
		super(page, fullName, email, groupName);
	}

	/*
	 * Dua ra noi dung trang
	 * 
	 * @see manageruser.service.PaginationService#getContentPage()
	 */
	@Override
	public List<User> getContentPage() {
		ListUser listUser = new ListUserPagingImpl(fullName, email, groupName, (page - 1) * Constant.PAGE_SIZE,
				Constant.PAGE_SIZE);
		return listUser.getUsers();
	}
}
