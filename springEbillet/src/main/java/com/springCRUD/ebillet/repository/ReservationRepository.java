package com.springCRUD.ebillet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springCRUD.ebillet.model.Evenements;
import com.springCRUD.ebillet.model.Reservation;
import com.springCRUD.ebillet.model.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	

	


}
