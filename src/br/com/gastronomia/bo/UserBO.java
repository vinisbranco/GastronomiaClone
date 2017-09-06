package br.com.gastronomia.bo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.gastronomia.dao.UserDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.User;
import br.com.gastronomia.util.Constantes;
import br.com.gastronomia.util.EncryptUtil;
import br.com.gastronomia.util.MensagemContantes;
import br.com.gastronomia.util.Validator;

public class UserBO {
	private UserDAO userDAO;

	public UserBO() {
		userDAO = new UserDAO();
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean validateCPF(User user) throws ValidationException {
		if (Validator.validaCpf.fazConta(user.getCpf()))
			return true;
		throw new ValidationException("invalido");

	}

	public boolean createUser(User user) throws ValidationException, NoSuchAlgorithmException {
		if (user != null) {
			user.setRole(Constantes.USER_ROLE);
			user.setActive(true);
			String encryptedPassword = EncryptUtil.encrypt2(user.getPassword());
			user.setPassword(encryptedPassword);
			validateCPF(user);
			userDAO.save(user);
			return true;
		}
		throw new ValidationException("invalido");

	}

	public long deactivateUser(long id) {
		return userDAO.alterStatus(id, false);
	}

	public long activateUser(long id) {
		return userDAO.alterStatus(id, true);
	}

	public long updateUser(User user) throws ValidationException {
		if (user != null) {
			return userDAO.updateUser(user);
		}
		throw new ValidationException("invalido");

	}

	public User validate(User newUser) {
		return newUser;
	}

	public User userExists(User userLogin) throws NoSuchAlgorithmException, ValidationException {
		userLogin.setPassword(EncryptUtil.encrypt2(userLogin.getPassword()));
		User returnedUser = userDAO.findUserByEmail(userLogin.getEmail());
		if (!userLogin.getPassword().equals(returnedUser.getPassword()))
			throw new ValidationException(MensagemContantes.MSG_ERR_USUARIO_SENHA_INVALIDOS);
		return returnedUser;
	}

	public HashMap<String, List<User>> listUser() {
		ArrayList<User> users = null;
		HashMap<String, List<User>> listUsers = new HashMap<String, List<User>>();
		users = (ArrayList<User>) userDAO.listAll(User.class);
		listUsers.put("Users", users);
		return listUsers;
	}

	public User getUserByCpf(User userLogin) throws ValidationException {
		if (userLogin != null) {
			return userDAO.findUserByCPF(userLogin.getCpf());
		}
		throw new ValidationException("CPF Invalido");
	}
	
	public User getUserByEmail(User userLogin) throws ValidationException {
		if (userLogin != null) {
			return userDAO.findUserByEmail(userLogin.getEmail());
		}
		throw new ValidationException("Email Invalido");
	}
	
	public User getUserByMatricula(User userLogin) throws ValidationException {
		if (userLogin != null) {
			return userDAO.findUserByMatricula(userLogin.getMatricula());
		}
		throw new ValidationException("Email Invalido");
	}
	
	public User getUserById(long id) throws ValidationException {
		if (id > 0) {
			return userDAO.findUserByID(id);
		}
		throw new ValidationException("invalido");

	}

}
