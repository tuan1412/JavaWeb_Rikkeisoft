package manageruser.service.serviceimpl;

import java.util.List;

import manageruser.constant.Constant;
import manageruser.dao.ListUser;
import manageruser.dao.daoimpl.ListUserImpl;
import manageruser.model.User;
import manageruser.service.PaginationService;

/**
 * Class dua ra cac thuoc tinh can de phan trang
 * @author Chu lun Kute
 *
 */
public class PaginationServiceImpl implements PaginationService{
	private int page;
	private String fullName;
	private String email;
	private String groupName;
	private String sortType;
	private String direction;
	
	public PaginationServiceImpl(int page, String fullName, String email, String groupName, String sortType, String direction) {
		super();
		this.page = page;
		this.fullName = fullName;
		this.email = email;
		this.groupName = groupName;
		this.sortType = sortType;
		this.direction = direction;
	}
	/**
	 * Dua so tong so section
	 */
	@Override
	public int getNoOfSection() {
		return (int) Math.ceil(this.getNoOfPage()*1.0 / Constant.SECTION_SIZE);
		
	}
	/**
	 * Dua ra tong so trang
	 * @return
	 */
	private int getNoOfPage() {
		ListUser listUser = new ListUserImpl();
		int pages = (int) Math.ceil(listUser.getSizeOfUsers(fullName, email, groupName) * 1.0 / Constant.PAGE_SIZE);
		return pages == 0 ? 1 : pages;
	}
	/**
	 * Dua ra noi dung trang
	 */
	@Override
	public List<User> getContentPage() {
		ListUser  listUser = new ListUserImpl();
		return listUser.getUsers(fullName, email, groupName, (page-1)*Constant.PAGE_SIZE, Constant.PAGE_SIZE);
	}
	
	/** 
	 * Dua ra noi dung trang khi order
	 */
	@Override
	public List<User> getContentPageWithOrder() {
		ListUser listUser = new ListUserImpl();
		return listUser.getUsers(fullName, email, groupName, (page-1)*Constant.PAGE_SIZE,  Constant.PAGE_SIZE, sortType, direction);
	}
	/**
	 * Dua ra trang bat dau
	 */
	@Override
	public int getStartPage() {
		return (this.getCurrentSection() - 1) * Constant.SECTION_SIZE + 1;
	}

	/**
	 * Dua ra trang ket thuc
	 */
	@Override
	public int getEndPage() {
		int endPage = this.getStartPage() + Constant.SECTION_SIZE - 1;
		if (this.getCurrentSection() == this.getNoOfSection()) {
			endPage = this.getNoOfPage();
		}
		return endPage;
	}

	/**
	 * Dua ra section hien tai
	 */
	@Override
	public int getCurrentSection() {
		return (int)Math.ceil(page*1.0 / Constant.SECTION_SIZE);
	}
}
