package com.training.spring.Learningspring.util;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.training.spring.Learningspring.business.ReservationService;
import com.training.spring.Learningspring.business.RoomReservation;
import com.training.spring.Learningspring.data.Guest;
import com.training.spring.Learningspring.data.GuestRepository;
import com.training.spring.Learningspring.data.Reservation;
import com.training.spring.Learningspring.data.ReservationRepository;
import com.training.spring.Learningspring.data.Room;
import com.training.spring.Learningspring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private final RoomRepository roomRepository;
	@Autowired
	private final GuestRepository questRepository; 
	@Autowired
	private final ReservationRepository reservationRepository;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private DateUtils dateUtils;
	
	
	public AppStartupEvent(RoomRepository roomRepository, GuestRepository questRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.questRepository = questRepository;
		this.reservationRepository = reservationRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
		
		Iterable<Guest> guests = this.questRepository.findAll();
		guests.forEach(System.out::println);
		
		Iterable<Reservation> reservations = this.reservationRepository.findAll();
		reservations.forEach(System.out::println);
		
		Date date = this.dateUtils.createDateFromDateString("2022-01-01");
		List<RoomReservation> rReservations =  this.reservationService.getRoomReservationsForDate(date);
		rReservations.forEach(System.out::println);
	}
}
