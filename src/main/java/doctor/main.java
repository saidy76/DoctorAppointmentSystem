
package doctor;
import doctor.Doctor;
import doctor.GeneralPractitioner;
import doctor.Specialist;
import doctor.Patient;
import doctor.Appointment;
import doctor.Clinic;

public class main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.loadDoctors();

        // Sample interaction
        clinic.displayDoctors();
        clinic.registerPatient(101, "Alice Johnson", "555-1234");
        clinic.bookAppointment(101, 1, "2024-09-15 10:00 AM");

        // Show doctor's availability (demonstrating method overriding)
        for (Doctor doctor : clinic.getDoctors()) {
            doctor.displayAvailability();
        }
    }
}
