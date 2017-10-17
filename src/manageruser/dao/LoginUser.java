package manageruser.dao;
/**
 * Kiem tra username, password
 * @author Chu lun Kute
 *
 */
public interface LoginUser {
	/**
	 * Kiem tra username, password co trong db ko
	 * @param username
	 * @param password
	 * @return
	 */
	boolean checkUser(String username, String password);
}
