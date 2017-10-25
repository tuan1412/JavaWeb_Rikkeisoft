package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manageruser.dao.UserInfo;
import manageruser.model.User;
import manageruser.utils.ConnectionUtils;

/**
 * Lay thong tin user dua vao Id
 * @author Chu lun Kute
 *
 */
public class UserInfoImpl implements UserInfo {
	private int userId;

	public UserInfoImpl(int userId) {
		super();
		this.userId = userId;
	}

	/* Lay thong tin user dua vao userId
	 * @see manageruser.dao.UserInfo#getUserInfo()
	 */
	@Override
	public User getUserInfo() {
		User user = new User();
		Connection connection = ConnectionUtils.getConnection();
		String sql = "select user_id, full_name, full_name_kana, " +
					  "case when gender = '0'  then 'Nam' else 'Nữ' end as gender, " +
					  "email, tel, birthday, " +
					  "link_image, group_name, name_level, start_date, end_date, total " +
					  "from tbl_user natural join mst_japan natural join detail_user_japan natural join mst_group " +
					  "where user_id = ?; ";
		
		ResultSet resultSet = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, userId);
			resultSet = pstm.executeQuery();
			while (resultSet.next()) {		
				user.setUserId(resultSet.getInt("user_id"));
				user.setFullName(resultSet.getString("full_name"));
				user.setFullNameKana(resultSet.getString("full_name_kana"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				user.setTel(resultSet.getString("tel"));
				user.setBirthday(resultSet.getString("birthday"));
				user.setLinkImage(resultSet.getString("link_image"));
				user.setGroupName(resultSet.getString("group_name"));
				user.setNameLevel(resultSet.getString("name_level"));
				user.setEndDate(resultSet.getString("end_date"));
				user.setTotal(resultSet.getInt("total"));			
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtils.closeConnection();
		}			
		return user;
	}	
}
