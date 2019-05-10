package service;

import java.io.Serializable;

import dao.PaisDAO;
import model.Pais;

public class PaisService implements Serializable{

	PaisDAO dao;
	
	public PaisService() {
		dao = new PaisDAO();
	}
	
	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	
	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}
	
	public void deletar(Pais pais) {
		dao.deletar(pais);
	}
	
	public Pais carregar(int id) {
		return dao.carregar(id);
	}
	
	/*
	public Pais carregar(Pais pais) {
		return dao.carregar(pais);
	}
	 */
	
}
