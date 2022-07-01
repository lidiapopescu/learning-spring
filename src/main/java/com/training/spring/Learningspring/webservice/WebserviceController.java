package com.training.spring.Learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.Learningspring.business.ReservationService;
import com.training.spring.Learningspring.business.RoomReservation;
import com.training.spring.Learningspring.util.DateUtils;

/*
 * This is going to tell Spring to put an app response body on each of our methods,
 * and that response body will take the data object that we return converted into a JSON payload
 * and return that JSON payload out through our web interface
 * */
@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}
	
	/*
	 * http://localhost:8081/api/reservations
	 * http://localhost:8081/api/reservations?date=2022-01-01
	 * */
	@RequestMapping(path="/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getReservations(@RequestParam(value="date", required = false)String dateString) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
	}
}
