package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import domain.Appointment;
import domain.User;

public class AppointmentDatabaseConnector {


	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASS);
		return conn;
	}

	private Statement prepareStatement(Connection conn) throws SQLException {
		return conn.createStatement();
	}

	public Appointment createNewAppointment(Appointment app) {
		try {

			Connection conn  = getConnection();
			Statement  stmt = conn.createStatement();
			String sql = createSqlQuery(app);

			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private String createSqlQuery(Appointment app) {

		String sql = "INSERT INTO Appointment Values("
				+ app.getDoctorId() + ","
				+ app.getUser().getUserId() + ","
				+ app.getDateAndTime() + ","
				+ app.getClinicId() + ","
				+ app.isAppointmentStatus() + ")";
		System.out.println(sql);
		return sql;
	}

	public List<Appointment> retrieveDoctorSchedule(int docId,Date date) {
		
		List<Appointment> appointments = new ArrayList<Appointment>();
		try {

			Connection conn  = getConnection();
			Statement  stmt = conn.createStatement();
			String sql = "SELECT * from Appointment A, User U where A.doctorId = " + docId + " and U.userId = A.userId where A.date = " + date;
			ResultSet rs = stmt.executeQuery(sql);
			
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name

				Appointment app = new Appointment();
				app.setAppointmentId(rs.getInt("appointmentId"));
				app.setDoctorId(rs.getInt("doctorId"));
				User u = new User();
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				app.setUser(u);
				app.setDateAndTime(rs.getDate("dateAndTime"));
				app.setClinicId(rs.getInt("clinicId"));
				app.setAppointmentStatus(rs.getBoolean("appointmentStatus"));

			}
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return appointments;
	}

}// end FirstExample
