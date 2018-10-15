package br.com.gastronomia.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gastronomia.dao.GrupoReceitasDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.GrupoReceitas;

public class GrupoReceitasBO {
	private GrupoReceitasDAO grupoReceitasDAO;
	private String invalid = "Invalido";

	public GrupoReceitasBO() {
		grupoReceitasDAO = new GrupoReceitasDAO();
	}

	public void setGrupoReceitasDAO(GrupoReceitasDAO grupoReceitasDAO) {
		this.grupoReceitasDAO = grupoReceitasDAO;
	}

	public boolean createGroup(GrupoReceitas grupo) throws ValidationException {
		if (grupo != null) {
			grupoReceitasDAO.save(grupo);
			return true;
		}

		throw new ValidationException(invalid);

	}

	public long deactivateGroup(long id) throws ValidationException  {
		return grupoReceitasDAO.alterStatus(id, false);
	}

	public long activateGroup(long id) throws ValidationException  {
		return grupoReceitasDAO.alterStatus(id, true);
	}

	public long updateGroup(GrupoReceitas grupoReceitas) throws ValidationException {
		if (grupoReceitas != null) {
			return grupoReceitasDAO.updateGroup(grupoReceitas);
		}
		throw new ValidationException(invalid);

	}

	public GrupoReceitas validate(GrupoReceitas grupoReceitas) {
		return grupoReceitas;
	}

	public Map<String, List<GrupoReceitas>> listGroups() {
		ArrayList<GrupoReceitas> grupoReceitas = null;
		HashMap<String, List<GrupoReceitas>> listGrupoReceitas = new HashMap<String, List<GrupoReceitas>>();
		grupoReceitas = (ArrayList<GrupoReceitas>) grupoReceitasDAO.listAll(GrupoReceitas.class);
		listGrupoReceitas.put("Grupos", grupoReceitas);
		return listGrupoReceitas;
	}

	public GrupoReceitas getGroupByCod(long id) throws ValidationException {
		if (id != 0) {
			return grupoReceitasDAO.findGroupByID(id);
		}
		throw new ValidationException(invalid);

	}


}
