package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manageruser.dao.ListUserSize;
import manageruser.utils.ConnectionUtils;

/**
 * Dua ra so user 
 * dua vao thuoc tinh full_name, gmail, group_name
 * @author Chu lun Kute
 *
 */
public class ListUserSizeImpl implements ListUserSize {
	private String fullName;
	private String email;
	private String groupName;

	public ListUserSizeImpl(String fullName, String email, String groupName) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.groupName = groupName;
	}

	@Override
	public int getSizeOfUsers() {
		Connection connection = ConnectionUtils.getConnection();
		fullName = "%" + fullName + "%";
		email = "%" + email + "%";
		groupName = "%" + groupName + "%";

		String sql = "select count(user_id) "
				+ "from tbl_user natural join mst_japan natural join detail_user_japan natural join mst_group "
				+ "where full_name like ? and " + "email like ? and " + "group_name like ? and del_flag = 0;";
		ResultSet resultSet = null;
		PreparedStatement pstm = null;
		int size = 0;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, fullName);
			pstm.setString(2, email);
			pstm.setString(3, groupName);

			resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				size = resultSet.getInt(1);
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
		return size;
	}
}
