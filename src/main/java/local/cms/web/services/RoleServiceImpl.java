package local.cms.web.services;

import local.cms.web.dao.RoleDAO;
import local.cms.web.models.UserRole;

public class RoleServiceImpl implements RoleService {

	RoleDAO roleDao;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public void saveRole(UserRole userRole) {
		roleDao.saveRole(userRole);

	}

	public boolean isAdmin(String userName) {
		return roleDao.isAdmin(userName);
	}

}
