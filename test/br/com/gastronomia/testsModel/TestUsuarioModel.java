package test.br.com.gastronomia.testsModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.gastronomia.model.Usuario;

public class TestUsuarioModel {
	Usuario testUser = new Usuario();
	
	@Test
	public void testUserCpf() {
		testUser.setCpf("61642096091");
		assertEquals("61642096091", testUser.getCpf());
	}
	
	@Test
	public void testUserEmail() {
		testUser.setEmail("Test@mailinator.com");
		assertEquals("Test@mailinator.com", testUser.getEmail());
	}
	
	@Test
	public void testUserMatricula() {
		testUser.setMatricula("61642096091");
		assertEquals("61642096091", testUser.getMatricula());
	}
	
	@Test
	public void testUserName() {
		testUser.setNome("Marcus");
		assertEquals("Marcus", testUser.getNome());
	}
	
	@Test
	public void testUserSenha() {
		testUser.setSenha("12345678");
		assertEquals("12345678", testUser.getSenha());
	}
	
	@Test
	public void testUserStatusTrue() {
		testUser.setStatus(true);
		assertEquals(true, testUser.isStatus());
	}
	
	@Test
	public void testUserStatusFalse() {
		testUser.setStatus(false);
		assertEquals(false, testUser.isStatus());
	}
}
