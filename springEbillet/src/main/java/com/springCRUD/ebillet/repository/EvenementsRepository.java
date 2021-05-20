package com.springCRUD.ebillet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springCRUD.ebillet.model.Evenements;
import com.springCRUD.ebillet.model.Reservation;
import com.springCRUD.ebillet.model.User;

@Repository
public interface EvenementsRepository extends JpaRepository<Evenements, Long> {

	@Query("SELECT e FROM Evenements e WHERE CONCAT(e.id, ' ', e.date, ' ', e.localisation, ' ', e.titre, ' ', e.type ) LIKE %?1%")
	List<Evenements> filtre(String keyword);

	


}
