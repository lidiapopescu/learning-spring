package com.training.spring.Learningspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.spring.Learningspring.business.ReservationService;

@Controller
@RequestMapping("/guests")
public class GuestsController {

	private final ReservationService reservationService;
	
	public GuestsController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
				
		model.addAttribute("guests",  this.reservationService.getHotelGuests());
		
		return "allGuests";
	}
}
