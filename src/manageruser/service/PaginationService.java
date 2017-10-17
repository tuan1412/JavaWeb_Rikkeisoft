package manageruser.service;

import java.util.List;

import manageruser.model.User;

public interface PaginationService {
	int getNoOfSection();
	int getStartPage();
	int getEndPage();
	int getCurrentSection();
	List<User> getContentPage();
	List<User> getContentPageWithOrder();
	
	
}
