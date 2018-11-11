package br.com.gastronomia.testIngredientBO;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import br.com.gastronomia.bo.IngredienteBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Ingrediente;

public class IngredientBOTest {
	
	private Ingrediente testIngredient;
	private IngredienteBO bo;
	
	@Before
	public void setUp() {
		testIngredient = new Ingrediente();
		bo = new IngredienteBO();
		testIngredient.setId(99);
		testIngredient.setNome("testing");
		testIngredient.setOrigem("test");
	}
	
	@Test
	public void createTest() throws NoSuchAlgorithmException, ValidationException {
		boolean result = bo.createIngrediente(testIngredient);
		assertEquals(true, result);
	}
	
	@Test
	public void getIngredientById() throws ValidationException {
		Ingrediente newIngredient = bo.getIngredienteById(testIngredient.getId());		
		assertEquals(testIngredient, newIngredient);
	}
}
