package manageruser.dao;

import java.util.List;

import manageruser.model.User;

public interface ListUser {
	
	List<User> getUsers(String fullName, String email, String groupName, int offset, int limit, String sortType, String direction);
	List<User> getUsers(String fullName, String email, String groupName, int offset, int limit);

	int getSizeOfUsers(String fullName, String email, String groupName);
}
