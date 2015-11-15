package domain;

import java.util.Date;

public class Appointment {
	
	private Integer AppointmentId;
	private Integer patientId;
	private Integer doctorId;
	private User user;
	private Date dateAndTime;
	private int clinicId;
	private boolean appointmentStatus;
	
	public Integer getAppointmentId() {
		return AppointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		AppointmentId = appointmentId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public int getClinicId() {
		return clinicId;
	}
	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}
	public boolean isAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(boolean appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
