package com.uv.dbcds.meetup.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Reservation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Reservation reservation = (Reservation) target;
		
		if(reservation.getEmail().endsWith("uv.es") && reservation.getAge() > 24)
			errors.rejectValue("age", "age.uv.old", new Object[] {reservation.getAge()}, "Too old for the UV domain");
	}

}
