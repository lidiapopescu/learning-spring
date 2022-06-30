package com.training.spring.Learningspring.data;


import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

	/* Automatically implemented business logic based on method names Reservation.getResDate*/
	Iterable<Reservation> findReservationByResDate(Date date);
}
