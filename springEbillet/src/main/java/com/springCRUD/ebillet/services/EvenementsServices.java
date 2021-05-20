package com.springCRUD.ebillet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCRUD.ebillet.model.Evenements;
import com.springCRUD.ebillet.repository.EvenementsRepository;

@Service
public class EvenementsServices {

	@Autowired
	private EvenementsRepository repo;
	
	public List<Evenements> listAll(String keyword){
		if(keyword != null) {
		return repo.filtre(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Evenements e) {
		repo.save(e);
	}
	
	public Evenements get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
