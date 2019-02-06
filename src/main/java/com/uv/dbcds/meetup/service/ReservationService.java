package com.uv.dbcds.meetup.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uv.dbcds.meetup.domain.Reservation;

@Service
public class ReservationService {

	private final List<Reservation> reservations = new ArrayList<>();
	
	public ReservationService() {
		reservations.add(new Reservation("Fran", "grimaldo@uv.es", 40));
		reservations.add(new Reservation("Jaun", "juan@uv.es", 42));
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void make(Reservation  reservation) {
		reservations.add(reservation);
	}
	
	public List<Reservation> deleteReservation(String email) {
		Reservation reservation = reservations.stream()
												.filter(r -> r.getEmail().equals(email))
												.findFirst()
												.get();
		reservations.remove(reservation);
		return reservations;
	}
	
}
