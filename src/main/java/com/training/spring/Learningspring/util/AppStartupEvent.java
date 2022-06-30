package com.training.spring.Learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.training.spring.Learningspring.data.Guest;
import com.training.spring.Learningspring.data.GuestRepository;
import com.training.spring.Learningspring.data.Reservation;
import com.training.spring.Learningspring.data.ReservationRepository;
import com.training.spring.Learningspring.data.Room;
import com.training.spring.Learningspring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

	private final RoomRepository roomRepository;
	private final GuestRepository questRepository; 
	private final ReservationRepository reservationRepository;
	
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
	}
}
