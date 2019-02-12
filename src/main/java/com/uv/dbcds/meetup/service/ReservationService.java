package com.uv.dbcds.meetup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uv.dbcds.meetup.domain.Reservation;

@Service
public class ReservationService {

	private final List<Reservation> reservations = new ArrayList<>();
	private boolean capacity;
	
	public ReservationService() {
		reservations.add(new Reservation("Fran", "grimaldo@uv.es", 40));
		reservations.add(new Reservation("Jaun", "juan@uv.es", 42));
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public boolean checkCapacity() {
		return capacity;
	}
	
	public void modifyCapacity(boolean capacity) {
		this.capacity = capacity;
	}
	
	public void make(Reservation reservation) {
		if (reservations.size() <= 20) {
			reservations.add(reservation);
		} else {
			this.capacity = false;
		}
	}
	
	public String deleteReservation(String email) {
		for (Reservation reservation : reservations) {
			if (reservation.getEmail().equals(email)) {
				reservations.remove(email);
			}
		}
		return "redirect:/";
	}
	
}
