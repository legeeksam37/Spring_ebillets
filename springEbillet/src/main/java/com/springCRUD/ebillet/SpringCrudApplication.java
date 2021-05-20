package com.springCRUD.ebillet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springCRUD.ebillet.model.Evenements;
import com.springCRUD.ebillet.model.Reservation;
import com.springCRUD.ebillet.model.User;
import com.springCRUD.ebillet.repository.ReservationRepository;

@SpringBootApplication
public class SpringCrudApplication {
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
		
		
		
	}

}
