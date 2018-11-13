package br.com.gastronomia.bo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import br.com.gastronomia.bo.UsuarioBO;
import br.com.gastronomia.dao.UsuarioDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
import junit.framework.Assert;

public class UsuarioBOTest {
	private UsuarioDAO usuarioDAO;
	private String validationException = "invalido";
	private UsuarioBO usuarioBO;
	private Usuario usuario;
	
	@Before
	public void setup() {
		usuarioDAO = mock(UsuarioDAO.class);
		usuarioBO = new UsuarioBO();
		usuarioBO.setUsuarioDAO(usuarioDAO);
		usuario = new Usuario("84876997071","user");
	}
	
	@Test
	public void TestvalidateCPF() throws ValidationException {
		assertTrue(usuarioBO.validateCPF(usuario));
	}
	@Test
	public void TestvalidateCPFFalse() throws ValidationException {
		try {
		Usuario usuarioFake = new Usuario("111","FakeUser");
		usuarioBO.validateCPF(usuarioFake);
		}catch (Exception e) {
			System.err.print(e);
			return;
		}
		fail();
	}	
	
	@Test
	public void TestCreate() throws NoSuchAlgorithmException, ValidationException {
		Usuario aux = new Usuario("84876997071","user");
		aux.setSenha("123");
		assertTrue(usuarioBO.createUser(aux));
	}
	
	@Test
	public void TestCreateFalse() throws NoSuchAlgorithmException, ValidationException {
		try {
			Usuario aux = new Usuario("111","user");
			aux.setSenha("");
			usuarioBO.createUser(aux);
			}catch (Exception e) {
				System.err.print(e);
				return;
			}
			fail();
	}
	
	@Test
	public void TestactivateUser() throws ValidationException, NoSuchAlgorithmException {
		Usuario aux = new Usuario("84876997071","user");
		aux.setSenha("123");
		usuarioBO.createUser(aux);
		Assert.assertEquals(0, usuarioBO.activateUser(aux.getId()));
	}
	
	

}
