package web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import businessLayer.AppointmentService;
import domain.Appointment;

@Path("/appointments")
public class AppointmentsRestApi {
	
	private AppointmentService service = new AppointmentService();
	
	@GET
	@Path("{doctorId}")
	public List<Appointment> getAppointments(@PathParam("doctorId") Integer doctorId) {
		return service.getAppointments(doctorId);
	}
	
	@GET
	@Path("/{doctorId}/{date}")
	public List<Appointment> getAppointmentsForDate(@PathParam("doctorId") Integer doctorId, @PathParam("date") Date date) {
		return service.getAppointments(doctorId,date);
	}
	
	
//	public List<Appointment> getAppointmentsForDate() {
//		Calendar
//	}
//	
//	@GET
//	@Path("/newApppointment")
//	public void getNewAppointment(userId) {
//		Insert into Appointment
//	}
	
	@POST
	@Path("/newApppointment")
	public Appointment createNewAppointment(Appointment app) {
		return service.createNewAppointment(app);
		
	}
	
	

}
