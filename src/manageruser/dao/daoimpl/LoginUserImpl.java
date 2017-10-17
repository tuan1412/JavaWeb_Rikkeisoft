package manageruser.dao.daoimpl;

import java.sql.*;
import manageruser.dao.LoginUser;
import manageruser.utils.ConnectionUtils;

/**
 * Class kêt no voi database
 * 
 * @author Chu lun Kute
 *
 */
public class LoginUserImpl implements LoginUser {

	/*
	 * Ham kiem tra su ton tai user
	 * 
	 * @see manageruser.dao.LoginUser#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkUser(String username, String password) {
		Connection connection = ConnectionUtils.getConnection();
		boolean flag = false;
		String sql = "select * from tbl_user where login_name=? and password=?";
		ResultSet resultSet = null;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			resultSet = pstm.executeQuery();

			if (resultSet.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtils.closeConnection();
		}
		return flag;
	}
}
