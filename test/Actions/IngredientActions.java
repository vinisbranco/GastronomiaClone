package Actions;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import br.com.gastronomia.model.Ingrediente;
import br.com.gastronomia.bo.IngredienteBO;
import br.com.gastronomia.exception.ValidationException;

public class IngredientActions {
	
	Ingrediente testIngredient = new Ingrediente();
	IngredienteBO bo = new IngredienteBO();
	
	private void buildIngredient() {
		testIngredient.setId(99);
		testIngredient.setNome("testing");
		testIngredient.setOrigem("test");
	}
	
	@Test
	public void createTest() throws NoSuchAlgorithmException, ValidationException {
		buildIngredient();
		boolean result = bo.createIngrediente(testIngredient);
		assertEquals(true, result);
	}
	
	@Test
	public void getIngredientById() throws ValidationException {
		Ingrediente newIngredient = bo.getIngredienteById(testIngredient.getId());		
		assertEquals(testIngredient, newIngredient);
	}
}
