package local.cms.web.dao;

import local.cms.web.models.UserRole;

/**
 * DAO layer for role management
 * 
 * @author shiyam
 *
 */
public interface RoleDAO {

	/***
	 * Saves the user role
	 * 
	 * @param role
	 * @return
	 */
	UserRole saveRole(UserRole role);

	/***
	 * check weather Admin user or not for given user name
	 * 
	 * @param user
	 * @return
	 */
	boolean isAdmin(String user);
}
