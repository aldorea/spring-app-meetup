package com.uv.dbcds.meetup.web;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.uv.dbcds.meetup.domain.Reservation;
import com.uv.dbcds.meetup.domain.ReservationValidator;
import com.uv.dbcds.meetup.service.ReservationService;

@Controller
@RequestMapping("/new")
public class NewController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationValidator reservationValidator;
	
//	public NewController(ReservationService reservationService,
//			ReservationValidator reservationValidator) {
//		super();
//		this.reservationService = reservationService;
//		this.reservationValidator = reservationValidator;
//	}
//	
	@GetMapping
	public void setupForm(Model model) {
		Reservation r = new Reservation();
		model.addAttribute("reservation", r);
	}
	
	@PostMapping
	public String submmitForm(@ModelAttribute("reservation")
								@Valid
								Reservation reservation,
								BindingResult result,
								SessionStatus status) {
		
		reservationValidator.validate(reservation, result);
		
		if(result.hasErrors()) {
			return "new";
		}
		reservationService.make(reservation);
		return "redirect:/";
	}
	@RequestMapping(value="/delete/{email}", method = RequestMethod.GET)
	public String delete(@PathParam("email") String email, Model model) {
		List<Reservation> reservations = reservationService.deleteReservation(email);
		model.addAttribute("reservations", reservations);
		return "index";
	}
}
