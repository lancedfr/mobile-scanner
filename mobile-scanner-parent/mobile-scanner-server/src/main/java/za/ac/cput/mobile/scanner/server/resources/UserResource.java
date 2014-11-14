package za.ac.cput.mobile.scanner.server.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import za.ac.cput.mobile.scanner.repository.model.User;
import za.ac.cput.mobile.scanner.service.product.UserService;

@Controller
public class UserResource {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/rest/user", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}

}
