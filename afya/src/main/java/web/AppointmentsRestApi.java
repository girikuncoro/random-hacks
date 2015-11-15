package web;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Path;

import domain.Appointment;

@Path("/appointments")
public class AppointmentsRestApi {
	
	
	public List<Appointment> getAppointments() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
	}
	
	public List<Appointment> getAppointmentsForDate() {
		Calendar
	}

}
