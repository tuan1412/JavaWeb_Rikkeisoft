package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import manageruser.dao.ListUserInsert;

import manageruser.model.RegForm;
import manageruser.utils.ConnectionUtils;

/**
 * Class ket noi database insert du lieu
 * 
 * @author Chu lun Kute
 *
 */
public class ListUserInsertImpl implements ListUserInsert {

	private RegForm regForm;

	public ListUserInsertImpl(RegForm regForm) {
		super();
		this.regForm = regForm;
	}
	
	/* ket noi database
	 * insert du lieu
	 * @see manageruser.dao.ListUserInsert#insert()
	 */

	@Override
	public void insert() {
		Connection connection = ConnectionUtils.getConnection();
		int groupId = 0;
		int gender = 0;
		switch (regForm.getGroupName()) {
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
		if (regForm.getGender().equals("Nữ")) {
			gender = 1;
		}
		String nameLevel = "";
		switch (regForm.getNameLevel()) {
		case "Trình độ tiếng nhật cấp 1":
			nameLevel = "N1";
			break;
		case "Trình độ tiếng nhật cấp 2":
			nameLevel = "N2";
			break;	
		case "Trình độ tiếng nhật cấp 3":
			nameLevel = "N3";
			break;
		case "Trình độ tiếng nhật cấp 4":
			nameLevel = "N4";
			break;
		case "Trình độ tiếng nhật cấp 5":
			nameLevel = "N5";
			break;
		
		}
		String sql = "insert into tbl_user(group_id, login_name, password, "
					+ "full_name, full_name_kana, gender, "
					+ "email, tel, birthday, link_image) "
					+ " values(?,?,?,?,?,?,?,?,?,?); ";
		
		String otherSql = "insert into detail_user_japan (user_id, code_level, start_date, end_date, total)" + 
				" values(?, ?, ?, ?, ?);";

		PreparedStatement pstm = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		
		int userId = 0;
		
		try {
			pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, groupId);
			pstm.setString(2, regForm.getLoginName());
			pstm.setString(3, regForm.getPassword());
			pstm.setString(4, regForm.getFullName());
			pstm.setString(5, regForm.getFullNameKana());
			pstm.setInt(6, gender);
			pstm.setString(7, regForm.getEmail());
			pstm.setString(8, regForm.getTel());
			pstm.setString(9, regForm.getBirthday());
			pstm.setString(10, regForm.getLinkImage());

			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();
		    if (rs.next()){
		            userId=rs.getInt(1);
		        }
		   ;
		   
		   pStatement = connection.prepareStatement(otherSql);
		   pStatement.setInt(1, userId);
		   pStatement.setString(2, nameLevel);
		   pStatement.setString(3, regForm.getStartDate());
		   pStatement.setString(4, regForm.getEndDate());
		   pStatement.setInt(5, regForm.getTotal());
		    
		   pStatement.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtils.closeConnection();
		}
	}
	
	
	
}
