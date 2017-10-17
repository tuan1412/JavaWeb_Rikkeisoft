package manageruser.service.serviceimpl;

import java.util.List;

import manageruser.constant.Constant;
import manageruser.dao.ListUser;
import manageruser.dao.daoimpl.ListUserPagingOrderImpl;
import manageruser.model.User;
import manageruser.service.PagingService;

public class PagingServiceOrderImpl extends PagingService {
	private String sortType;
	private String direction;

	public PagingServiceOrderImpl(int page, String fullName, String email, String groupName, String sortType,
			String direction) {
		super(page, fullName, email, groupName);
		this.sortType = sortType;
		this.direction = direction;
	}

	/*
	 * Lay noi dung trang co sap xep
	 * 
	 * @see manageruser.service.PaginationService#getContentPage()
	 */
	@Override
	public List<User> getContentPage() {
		ListUser listUser = new ListUserPagingOrderImpl(fullName, email, groupName, sortType, direction,
				(page - 1) * Constant.PAGE_SIZE, Constant.PAGE_SIZE);
		return listUser.getUsers();
	}

}
