package manageruser.service;

import java.util.List;
import manageruser.constant.Constant;
import manageruser.dao.ListUserSize;
import manageruser.dao.daoimpl.ListUserSizeImpl;
import manageruser.model.User;

public abstract class PagingService {
	protected int page;
	protected String fullName;
	protected String email;
	protected String groupName;
	
	public PagingService(int page, String fullName, String email, String groupName) {
		super();
		this.page = page;
		this.fullName = fullName;
		this.email = email;
		this.groupName = groupName;
	}
	/**
	 * 
	 * @return tong so section
	 */
	public int getNoOfSection() {
		return (int) Math.ceil(this.getNoOfPage() * 1.0 / Constant.SECTION_SIZE);

	}
	/**
	 * 
	 * @return tong so trang
	 */
	private int getNoOfPage() {
		ListUserSize listUserSize = new ListUserSizeImpl(fullName, email, groupName);
		int pages = (int) Math.ceil(listUserSize.getSizeOfUsers() * 1.0 / Constant.PAGE_SIZE);
		return pages == 0 ? 1 : pages;
	}
	/**
	 * 
	 * @return trang bat dau section
	 */
	public int getStartPage() {
		return (this.getCurrentSection() - 1) * Constant.SECTION_SIZE + 1;
	}
	/**
	 * 
	 * @return trang ket thuc section
	 */
	public int getEndPage() {
		int endPage = this.getStartPage() + Constant.SECTION_SIZE - 1;
		if (this.getCurrentSection() == this.getNoOfSection()) {
			endPage = this.getNoOfPage();
		}
		return endPage;
	}
	/**
	 * 
	 * @return section hien tai
	 */
	public int getCurrentSection() {
		return (int) Math.ceil(page * 1.0 / Constant.SECTION_SIZE);
	}
	/**
	 * 
	 * @return so user tren trang
	 */
	abstract public List<User> getContentPage();
}
