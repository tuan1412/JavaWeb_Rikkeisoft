package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageruser.dao.UpdateUser;
import manageruser.model.User;
import manageruser.utils.ConnectionUtils;

public class UpdateUserImpl implements UpdateUser{
	private User user;

	public UpdateUserImpl(User user) {
		super();
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see manageruser.dao.UpdateUser#update()
	 */
	@Override
	public void update() {
		Connection connection = ConnectionUtils.getConnection();
		int groupId = 0;
		int gender = 0;
		switch (user.getGroupName()) {
		case "Trung tâm phát triển chiến lược" :
			groupId = 1;
			break;
		case "Trung tâm phát triển mobile":
			groupId = 2;
			break;
		case "Trung tâm phát triển TMDT" :
			groupId = 3;
		case "Trung tâm phát triển Game" :
			groupId = 4;
		default:
			groupId = 5;
		}
		if (user.getGender().equals("Nữ")) {
			gender = 1;
		}
		String nameLevel = "";
		switch (user.getNameLevel()) {
		case "Trình độ tiếng Nhật cấp 1":
			nameLevel = "N1";
			break;
		case "Trình độ tiếng Nhật cấp 2":
			nameLevel = "N2";
			break;	
		case "Trình độ tiếng Nhật cấp 3":
			nameLevel = "N3";
			break;
		case "Trình độ tiếng Nhật cấp 4":
			nameLevel = "N4";
			break;
		case "Trình độ tiếng Nhật cấp 5":
			nameLevel = "N5";
			break;
		
		}
		String sqlUser = "update tbl_user set " +
					     "group_id = ?, " +
					     "full_name = ?, " +
					     "full_name_kana = ?, " + 
					     "gender = ?, " +
					     "email = ?, " + 
					     "tel = ?, " +
					     "birthday = ?, " + 
					     "link_image = ? " + 
					     "where user_id = ?;" ;
		
		String sqlDetail = "update detail_user_japan set " +
						   "code_level = ?, " +
						   "end_date = ?, " +
						   "total = ? " +
						   "where user_id = ?;" ;
		
		PreparedStatement pstm = null;
		PreparedStatement pStatement = null;
		
		try {
			pstm = connection.prepareStatement(sqlUser);
			pstm.setInt(1, groupId);
			pstm.setString(2, user.getFullName());
			pstm.setString(3, user.getFullNameKana());
			pstm.setInt(4, gender);
			pstm.setString(5, user.getEmail());
			pstm.setString(6, user.getTel());
			pstm.setString(7, user.getBirthday());
			pstm.setString(8, user.getLinkImage());
			pstm.setInt(9,  user.getUserId());
			pstm.executeUpdate();
			
			pStatement = connection.prepareStatement(sqlDetail);
			pStatement.setString(1, nameLevel);
			pStatement.setString(2, user.getEndDate());
			pStatement.setInt(3, user.getTotal());
			pStatement.setInt(4, user.getUserId());
			pStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtils.closeConnection();
		}
	}
	
	
}
