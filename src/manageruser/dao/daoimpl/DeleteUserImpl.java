package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageruser.dao.DeleteUser;
import manageruser.utils.ConnectionUtils;

/**
 * Ket noi database, dat delflag user
 * @author Chu lun Kute
 *
 */
public class DeleteUserImpl implements DeleteUser{
	int userId;

	public DeleteUserImpl(int userId) {
		super();
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see manageruser.dao.DeleteUser#delete()
	 */
	@Override
	public void delete() {
		Connection connection = ConnectionUtils.getConnection();
		String sql = "update tbl_user set " + 
					 "del_flag = '1'" +
					 "where user_id = ?; ";
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, userId);
			
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtils.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		DeleteUserImpl test = new DeleteUserImpl(14);
		test.delete();
	}
}
