package local.cms.web.services;

import local.cms.web.models.UserRole;

/***
 * Web service to manage the user role
 * 
 * @author shiyam
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RoleService {

	/***
	 * Save the user role
	 * 
	 * @param userRole
	 */
	void saveRole(UserRole userRole);

	/***
	 * Checks if the user name is admin or not
	 * 
	 * @param userName
	 * @return
	 */
	boolean isAdmin(String userName);

}
