package br.com.gastronomia.bo;

import br.com.gastronomia.bo.AtributoBO;
import br.com.gastronomia.bo.UsuarioBO;
import br.com.gastronomia.dao.AtributoDAO;
import br.com.gastronomia.dao.UsuarioDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Atributo;
import br.com.gastronomia.model.Usuario;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
public class AtributoBOTest {
	private AtributoBO atributoBO;
	private Atributo atributo;
	private AtributoDAO atributoDAO;
	
	@Before
	public void setup() {
		atributoDAO = mock(AtributoDAO.class);
		atributoBO = new AtributoBO();
		atributoBO.setAtributoDAO(atributoDAO);
		atributo = new Atributo("TesteAtributo",2);
	}
	
	@Test
	public void TestCreateAtributo() throws ValidationException {
		Assert.assertTrue(atributoBO.createAtributo(atributo));
	}
	@Test
	public void TestCreateAtributoFalse() throws ValidationException {
		try {
			Atributo atributoFalse = null;
			atributoBO.createAtributo(atributoFalse);
			}catch (Exception e) {
				System.err.print(e);
				return;
			}
			fail();
	}
}
