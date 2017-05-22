package local.cms.web.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import local.cms.web.models.UserRole;

/***
 * Role DAO layer management for managing the user role
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 */
public class RoleDAOImpl implements RoleDAO {

	SessionFactory sessionFactory;

	/***
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/***
	 * Saves the user role
	 * @param role, User role manages the role information
	 */
	@Transactional
	public UserRole saveRole(UserRole role) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(role);
		tx.commit();
		session.close();
		return role;
	}

	
	/* (non-Javadoc)
	 * @see local.cms.web.dao.RoleDAO#isAdmin(java.lang.String)
	 */
	public boolean isAdmin(String user) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(
				"select r.role from UserRole r where r.username = :username and r.role = 'ROLE_ADMIN'");
		query.setParameter("username", user);
		String role = (String) query.uniqueResult();
		session.close();
		System.out.println(
				role != null && role.equals("ROLE_ADMIN") ? true : false);
		return role != null && role.equals("ROLE_ADMIN") ? true : false;
	}

}
