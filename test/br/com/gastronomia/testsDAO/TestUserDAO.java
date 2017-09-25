package br.com.gastronomia.testsDAO;

import br.com.gastronomia.dao.UserDAO;
import br.com.gastronomia.model.User;

/**
 * 
 * @author cassio.trindade
 * Classe para teste do DAO Hibernate
 */
public class TestUserDAO {
	public static void main(String[] args) {
		
		User user = new User();
		user.setCpf("99000090909");
		
		UserDAO userDAO = new UserDAO();
		
		System.out.println(userDAO.save(user));
	}
}
