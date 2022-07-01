package com.training.spring.Learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.training.spring.Learningspring.data.Guest;
import com.training.spring.Learningspring.data.GuestRepository;
import com.training.spring.Learningspring.data.Reservation;
import com.training.spring.Learningspring.data.ReservationRepository;
import com.training.spring.Learningspring.data.Room;
import com.training.spring.Learningspring.data.RoomRepository;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;

    private final GuestRepository guestRepository;

    private final ReservationRepository reservationRepository;
	
//	 You can use one constructor without @Autowired
//	 but if you have 2 or more, you have to specify @Autowired for constructor Spring has to pick, otherwise it will not compile
//	 The compiler error returned by some IDs is "Class doesn't contain matching constructor for autowiring", 
//	 The runtime Error: Error creating bean with name 'reservationService' , No default constructor found
	public ReservationService(RoomRepository roomRepository,
			GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	

	
    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
//        org.springframework.data.jpa.repository.support.SimpleJpaRepository@66d2885c
//        System.out.println(this.reservationRepository);
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservations;
    }
    
    public List<Guest> getHotelGuests() {
    	List<Guest> guests =  this.guestRepository.findAll();
		
    	guests.sort(new Comparator<Guest>() {
			
			@Override
			public int compare(Guest o1, Guest o2) {
				if (o1.getLastName().equals(o2.getLastName())) {
					return o1.getFirstName().compareTo( o2.getFirstName());
				}
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		return guests;
    }
    
    public void addGuest(Guest guest) {
    	if (null == guest) {
    		throw new RuntimeException("Guest cannot be null");
    	}
    	this.guestRepository.save(guest);
    }
    
    
    public List<Room> getRooms() {
    	Iterable<Room> rooms =  this.roomRepository.findAll();
		List<Room> roomList = new ArrayList<Room>();
		
		rooms.forEach(room -> roomList.add(room));
		roomList.sort(new Comparator<Room>() {
			
			@Override
			public int compare(Room o1, Room o2) {
				
				return o1.getRoomNumber().compareTo(o2.getRoomNumber());
			}
		});
		return roomList;
    }
}

