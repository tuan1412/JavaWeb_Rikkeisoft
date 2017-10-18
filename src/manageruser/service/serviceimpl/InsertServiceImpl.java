package manageruser.service.serviceimpl;

import manageruser.dao.ListUserInsert;
import manageruser.dao.daoimpl.ListUserInsertImpl;
import manageruser.model.RegForm;
import manageruser.service.InsertService;
/**
 * Insert user vao database
 * @author Chu lun Kute
 *
 */
public class InsertServiceImpl implements InsertService {
	private RegForm regForm;
	
	
	public InsertServiceImpl(RegForm regForm) {
		super();
		this.regForm = regForm;
	}


	/* goi class ket noi database ibssert du lieu
	 * @see manageruser.service.InsertService#insert()
	 */
	@Override
	public void insert() {
		ListUserInsert listUserInsert = new ListUserInsertImpl(regForm);
		listUserInsert.insert();
		
	}
	
}
