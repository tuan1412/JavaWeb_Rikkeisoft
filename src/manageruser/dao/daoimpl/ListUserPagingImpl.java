package manageruser.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageruser.dao.ListUser;
import manageruser.model.User;
import manageruser.utils.ConnectionUtils;

/**
 * Class dua ra du lieu list user phan trang
 * co dieu kien full_name, email, group_name
 * @author Chu lun Kute
 *
 */
public class ListUserPagingImpl implements ListUser {
	private String fullName;
	private String email;
	private String groupName;
	private int offset;
	private int limit;
	
	public ListUserPagingImpl(String fullName, String email, String groupName, int offset, int limit) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.groupName = groupName;
		this.offset = offset;
		this.limit = limit;
	}

	/* Dua ra users theo trang
	 * @see manageruser.dao.ListUser#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		Connection connection = ConnectionUtils.getConnection();
		List<User> users = new ArrayList<>();
		fullName = "%" + fullName + "%";
		email = "%" + email + "%";
		groupName = "%" + groupName + "%";

		String sql = "select user_id, full_name, full_name_kana, " + 
				"case " + 
				"when gender = '0'  then 'Nam' " + 
				"else 'Nữ' " + 
				"end as gender, " + 
				"email, tel, birthday, " + 
				"link_image, group_name, name_level, start_date, end_date, total " + 
				"from tbl_user natural join mst_japan natural join detail_user_japan natural join mst_group "+
				"where full_name like ? and " +
                "email like ? and " +
                "group_name like ? and del_flag = '0'" + 
                "limit ?, ? ;"; 
		
		ResultSet resultSet = null;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, fullName);
			pstm.setString(2, email);
			pstm.setString(3, groupName);
			pstm.setInt(4, offset);
			pstm.setInt(5, limit);
			
			resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				User user = new User();
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

				users.add(user);
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
		return users;
	}
	public static void main(String[] args) {
		ListUser test = new ListUserPagingImpl("", "", "", 0, 5);
		test.getUsers().forEach(e->System.out.println(e.getFullName()));
	}
}
