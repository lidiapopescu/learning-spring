package com.training.spring.Learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.spring.Learningspring.business.ReservationService;
import com.training.spring.Learningspring.business.RoomReservation;
import com.training.spring.Learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}
	
	/* 
	 * http://localhost:8081/reservations?date=2022-01-01
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		
		// The String is actually the name of the template that we want to return, but instead of saying the full name of the template
		// we actually use the template's name without the file extension.
		// Spring Boot Starter Thymeleaf is configured in such a way that this html tag at the end doesn't matter
		// We have resources/static/roomres.html file
		return "roomres";
	}
}
