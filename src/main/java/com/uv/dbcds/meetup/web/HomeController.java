package com.uv.dbcds.meetup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uv.dbcds.meetup.domain.Reservation;
import com.uv.dbcds.meetup.service.ReservationService;

@Controller
public class HomeController {
	
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/")
	public String home (Model model) {
		
		List<Reservation> reservations = reservationService.getReservations();
		model.addAttribute("reservations", reservations);
		return "index";
		
	}
}
