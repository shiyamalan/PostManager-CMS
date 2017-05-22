package local.cms.web.services;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import local.cms.web.dao.RoleDAO;
import local.cms.web.dao.UserDAO;
import local.cms.web.models.User;
/***
 * User Service API implementation
 * 
 * @author shiyam
 *
 */
public class UserServiceImpl implements UserService {

	UserDAO userDao;

	RoleDAO roleDao;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/***
	 * @see local.cms.web.services.UserService#createUser(local.cms.web.models.User)
	 */
	@Transactional
	public User createUser(User user) {

		return userDao.createUser(user);
	}

	/***
	 * @see local.cms.web.services.UserService#listUsers()
	 */
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	/***
	 * @see local.cms.web.services.UserService#UpdateUser(local.cms.web.models.User)
	 */
	public void UpdateUser(User user) {
		userDao.updateUser(user);

	}

	/****
	 * @see local.cms.web.services.UserService#login(local.cms.web.models.User,
	 *      javax.servlet.http.HttpSession)
	 */
	public User login(User user, HttpSession session) {

		User authUser = new User();
		authUser = userDao.authenticate(user.getUsername(), user.getPassword());

		if (authUser != null) {
			session.setAttribute("USER_SESSION", authUser);
		}
		return authUser;

	}

	/****
	 * @see local.cms.web.services.UserService#updateUserEnableStatus(local.cms.web.models.User)
	 */
	public void updateUserEnableStatus(User user) {
		userDao.changeUserEnableStatus(user);
	}

}
