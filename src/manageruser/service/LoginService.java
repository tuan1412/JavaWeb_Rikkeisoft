package manageruser.service;

import java.util.List;

public interface LoginService {
	List<String> validate(String username, String password);
}
