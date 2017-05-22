package local.cms.web.dao;

import java.util.List;

import local.cms.web.models.User;

/**
 * 
 * User Data Access Layer
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 *
 */
public interface UserDAO {

	/***
	 * Create a new user
	 * 
	 * @param user
	 * @return
	 */
	User createUser(User user);

	/***
	 * list all user
	 * 
	 * @return users list
	 */
	List<User> listUsers();

	/***
	 * Update user information
	 * 
	 * @param user
	 */
	void updateUser(User user);

	/***
	 * Authenticate for given user name and password
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	User authenticate(String userName, String passWord);

	/***
	 * change user status (active or Deactive status)
	 * 
	 * @param user
	 */
	void changeUserEnableStatus(User user);
}
