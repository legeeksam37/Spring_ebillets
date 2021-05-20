package com.springCRUD.ebillet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCRUD.ebillet.model.Reservation;
import com.springCRUD.ebillet.repository.ReservationRepository;

@Service
public class ReservationServices {

	@Autowired
	private ReservationRepository repo1;
	
	public List<Reservation> listAll(){
		return repo1.findAll();
	}
	
	public void save(Reservation r) {
		repo1.save(r);
	}
	
	public Reservation get(Long id) {
		return repo1.findById(id).get();
	}
	
	public void delete(Long id) {
		repo1.deleteById(id);
	}

	public Long findByLogin(String id1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
