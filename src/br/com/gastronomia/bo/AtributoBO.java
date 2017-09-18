package br.com.gastronomia.bo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.gastronomia.dao.AtributoDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Atributo;
import br.com.gastronomia.util.Constantes;
import br.com.gastronomia.util.EncryptUtil;
import br.com.gastronomia.util.MensagemContantes;
import br.com.gastronomia.util.Validator;

public class AtributoBO {
	private AtributoDAO atributoDAO;

	public AtributoBO() {
		atributoDAO = new AtributoDAO();
	}

	public void setAtributoDAO(AtributoDAO atributoDAO) {
		this.atributoDAO = atributoDAO;
	}

	public boolean createAtributo(Atributo atributo) throws ValidationException, NoSuchAlgorithmException {
		if (atributo != null) {
			atributo.setStatus("ativo");
			atributoDAO.save(atributo);
			return true;
		}
		throw new ValidationException("invalido");

	}

	public long inactiveAtributo(long id) {
		return atributoDAO.alterStatus(id, "inativo");
	}

	public long activateUser(long id) {
		return atributoDAO.alterStatus(id, "ativo");
	}

	public long updateAtributo(Atributo atributo) throws ValidationException {
		if (atributo != null) {
			return atributoDAO.updateAtributo(atributo);
		}
		throw new ValidationException("invalido");

	}
	
	//Mantive este método, mas não vejo qual a utilidade dele
	public Atributo validate(Atributo newAtributo) {
		return newAtributo;
	}

	public HashMap<String, List<Atributo>> listAtributos() {
		ArrayList<Atributo> atributos = null;
		HashMap<String, List<Atributo>> listAtributos = new HashMap<String, List<Atributo>>();
		atributos = (ArrayList<Atributo>) atributoDAO.listAll(Atributo.class);
		listAtributos.put("Atributos", atributos);
		return listAtributos;
	}

	public Atributo getAtributoById(long id) throws ValidationException {
		if (id > 0) {
			return atributoDAO.findAtributoByID(id);
		}
		throw new ValidationException("invalido");

	}

}
