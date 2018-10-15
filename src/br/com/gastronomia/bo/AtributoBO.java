package br.com.gastronomia.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gastronomia.dao.AtributoDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Atributo;

public class AtributoBO {
	private AtributoDAO atributoDAO;
	private String invalid = "Invalido";
	
	public AtributoBO() {
		atributoDAO = new AtributoDAO();
	}

	public void setAtributoDAO(AtributoDAO atributoDAO) {
		this.atributoDAO = atributoDAO;
	}

	public boolean createAtributo(Atributo atributo) throws ValidationException{
		if (atributo != null) {
			atributoDAO.save(atributo);
			return true;
		}
		throw new ValidationException(invalid);

	}

	public long inactiveAtributo(long id) throws ValidationException {
		return atributoDAO.alterStatus(id, false);
	}

	public long activateUser(long id) throws ValidationException {
		return atributoDAO.alterStatus(id, true);
	}

	public long updateAtributo(Atributo atributo) throws ValidationException {
		if (atributo != null) {
			return atributoDAO.updateAtributo(atributo);
		}
		throw new ValidationException(invalid);

	}

	public Atributo validate(Atributo newAtributo) {
		return newAtributo;
	}

	public Map<String, List<Atributo>> listAtributos() {
		ArrayList<Atributo> atributos = null;
		HashMap<String, List<Atributo>> listAtributos = new HashMap<String, List<Atributo>>();
		atributos = (ArrayList<Atributo>) atributoDAO.listAllOrder(Atributo.class, "Ordem");
		listAtributos.put("Atributos", atributos);
		return listAtributos;
	}

	public Atributo getAtributoById(long id) throws ValidationException {
		if (id > 0) {
			return atributoDAO.findAtributoByID(id);
		}
		throw new ValidationException(invalid);

	}

}
