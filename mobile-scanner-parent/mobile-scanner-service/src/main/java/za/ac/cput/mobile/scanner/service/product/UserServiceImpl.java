package za.ac.cput.mobile.scanner.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.mobile.scanner.repository.dao.UserDao;
import za.ac.cput.mobile.scanner.repository.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

}
