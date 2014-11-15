package za.ac.cput.mobile.scanner.repository.dao;

import za.ac.cput.mobile.scanner.repository.model.User;

public interface UserDao {

	public void addUser (User user);
	
	public void deleteUser(Integer id);

	public void updateUser(User user);

	public User getUser(Integer id);
	
	public User getUserByUserName(String userName);

}
