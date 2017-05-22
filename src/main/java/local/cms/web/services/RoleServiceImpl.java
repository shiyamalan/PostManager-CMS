package local.cms.web.services;

import local.cms.web.dao.RoleDAO;
import local.cms.web.models.UserRole;

/***
 * Role Management API implementation
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 * 
 *
 */
public class RoleServiceImpl implements RoleService {

	RoleDAO roleDao;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	/***
	 * @see local.cms.web.services.RoleService#saveRole(local.cms.web.models.UserRole)
	 */
	public void saveRole(UserRole userRole) {
		roleDao.saveRole(userRole);

	}

	/***
	 * @see local.cms.web.services.RoleService#isAdmin(java.lang.String)
	 */
	public boolean isAdmin(String userName) {
		return roleDao.isAdmin(userName);
	}

}
