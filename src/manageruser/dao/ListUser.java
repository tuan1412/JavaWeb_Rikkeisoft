package manageruser.dao;

import java.util.List;

import manageruser.model.User;
/**
 * Dua ra danh sach user
 * @author Chu lun Kute
 *
 */
public interface ListUser {
	/**
	 * 
	 * @return list cac user
	 */
	List<User> getUsers();	
}
