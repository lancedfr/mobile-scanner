package za.ac.cput.mobile.scanner.repository.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.mobile.scanner.repository.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
	}

}
