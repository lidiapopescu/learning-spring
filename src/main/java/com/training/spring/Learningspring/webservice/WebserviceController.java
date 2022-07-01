package com.training.spring.Learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.Learningspring.business.ReservationService;
import com.training.spring.Learningspring.business.RoomReservation;
import com.training.spring.Learningspring.data.Guest;
import com.training.spring.Learningspring.data.Room;
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
	
//	Old version
//	@RequestMapping(path="/guests", method = RequestMethod.GET)
//	public List<Guest> getGuests() {
//		return this.reservationService.getHotelGuests();
//	}
	
	@GetMapping("/guests")
	public List<Guest> getGuests() {
		return this.reservationService.getHotelGuests();
	}
	
	@PostMapping("/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public void addGuest(@RequestBody Guest guest) {
		this.reservationService.addGuest(guest);
	}
	
	@GetMapping("/rooms")
	public List<Room> getRooms() {
		return this.reservationService.getRooms();
	}
}
