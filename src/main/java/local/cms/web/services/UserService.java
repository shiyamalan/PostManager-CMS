package local.cms.web.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import local.cms.web.models.User;

/***
 * User Management API
 * 
 * @author shiyam
 *
 */
public interface UserService {

	/***
	 * create the new user
	 * 
	 * @param user
	 * @return
	 */
	User createUser(User user);

	/***
	 * list the all user from database
	 * 
	 * @return
	 */
	List<User> listUsers();

	/***
	 * updates the user
	 * 
	 * @param user
	 */
	void UpdateUser(User user);

	/***
	 * Authenticate the user for given user details
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	User login(User user, HttpSession session);

	/***
	 * update the user status
	 * 
	 * @param user
	 */
	void updateUserEnableStatus(User user);

}
