/**
 * EFD (Economic Freedom Developers) 
 * (Lance Reid, Nash Naidoo, Flippie van Schalkwyk, Tohhier Allie)
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package za.ac.cput.mobile.scanner.repository.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.mobile.scanner.repository.model.Product;
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

		User userByName = getUserByUserName(user.getFirstName());
		if (userByName == null) {
			getCurrentSession().save(user);
		} else {
			user.setId(userByName.getId());
			updateUser(user);
		}
	}

	@Override
	public void deleteUser(Integer id) {
		User user = getUser(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}

	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setGender(user.getGender());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setUserName(user.getUserName());
		userToUpdate.setAge(user.getAge());

		getCurrentSession().update(userToUpdate);

	}

	@Override
	public User getUser(Integer id) {
		return (User) getCurrentSession().get(User.class, id);
	}

	@Override
	public User getUserByUserName(String userName) {
		return (User) getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", userName)).uniqueResult();
	}

}
