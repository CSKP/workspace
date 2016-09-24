package br.senai.informatica.todolist.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.todolist.modelo.ItemLista;
import br.senai.informatica.todolist.modelo.Lista;

@Repository
public class ItemDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Transactional
	public void marcarFeito(Long idItem, boolean valor){
		ItemLista item = manager.find(ItemLista.class, idItem);
		item.setFeito(valor);
		manager.merge(item);
	}
	
	@Transactional
	public void inserir(Long idLista, ItemLista item){
		item.setLista(manager.find(Lista.class, idLista));
		
		manager.persist(item);
	}
	
}
