package businessLayer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import database.AppointmentDatabaseConnector;
import domain.Appointment;

public class AppointmentService {

	private AppointmentDatabaseConnector connector = new AppointmentDatabaseConnector();
	public Appointment createNewAppointment(Appointment app) {
		return connector.createNewAppointment(app);
	}
	
	//public List<Appointment> = retrieveDoctorSchedule()
//	public List<Appointment> getAppointments() {
//		DatabaseConnector c = new DatabaseConnector();
//		return c.getResultSet();
//
//	}


	public List<Appointment> getAppointments(Integer doctorId) {
		Calendar cal = Calendar.getInstance();
		return connector.retrieveDoctorSchedule(doctorId,cal.getTime());
	}

	public List<Appointment> getAppointments(Integer doctorId, Date date) {
		Calendar cal = Calendar.getInstance();
		return connector.retrieveDoctorSchedule(doctorId,date);
	}
}
