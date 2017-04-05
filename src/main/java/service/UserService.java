package service;

import model.UserRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public void RegisterUser(UserRegistration userRegistration)
	{
		userDao.registerUser(userRegistration);
	}

	
}
