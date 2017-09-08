package br.com.gastronomia.dao;

import br.com.gastronomia.db.GenericHibernateDAO;
import br.com.gastronomia.db.HibernateUtil;
import br.com.gastronomia.model.Ingrediente;
import org.hibernate.Session;

import java.util.List;

public class IngredienteDAO extends GenericHibernateDAO<Ingrediente> {
	public List<Ingrediente> listForName(Object Ingrediente, String q) {
		Session session = HibernateUtil.getFactory();
		List<Ingrediente> ingredientes = session.getNamedQuery("findUserForName").setParameter("userName", q).list();
		return ingredientes;
	}

	public List<Ingrediente> listAllIngredientes(){
		List<Ingrediente> ingredientes = listAll(Ingrediente.class);
		return ingredientes;
	}

	public Ingrediente findIngredienteByName(String nome) {
		return (Ingrediente) findSingleObject("nome", Ingrediente.class, nome);
	}

	public Ingrediente findIngredienteById(long id) {
		return (Ingrediente) findId(id, Ingrediente.class);
	}

	public long updateIngrediente(Ingrediente ingrediente) {
		return merge(ingrediente);
	}

	public long alterStatus(long id, boolean statusBool) {
		Ingrediente ingrediente = findIngredienteById(id);
		String status = (statusBool) ? "Ativo" : "Inativo";
		ingrediente.setStatus(status);
		return merge(ingrediente);
	}
}
