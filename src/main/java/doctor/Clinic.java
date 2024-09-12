package doctor;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Clinic() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void loadDoctors() {
        doctors.add(new GeneralPractitioner(1, "John Smith"));
        doctors.add(new Specialist(2, "Emily Brown", "Cardiology"));
    }

    public void displayDoctors() {
        System.out.println("Available Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor ID: " + doctor.getDoctorId() + ", Name: " + doctor.getName() +
                    ", Specialization: " + doctor.getSpecialization());
        }
    }

    public void registerPatient(int patientId, String name, String contact) {
        Patient patient = new Patient(patientId, name, contact);
        patient.savePatientToFile();
        patients.add(patient);
        System.out.println("Patient " + name + " registered successfully.");
    }

    public void bookAppointment(int patientId, int doctorId, String time) {
        Patient patient = patients.stream()
                .filter(p -> p.getPatientId() == patientId)
                .findFirst()
                .orElse(null);
        Doctor doctor = doctors.stream()
                .filter(d -> d.getDoctorId() == doctorId)
                .findFirst()
                .orElse(null);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, time);
            doctor.addAppointment(appointment);
            appointment.saveAppointmentToFile();
            System.out.println("Appointment booked for " + patient.getName() +
                    " with Dr. " + doctor.getName() + " at " + time + ".");
        } else {
            System.out.println("Invalid patient ID or doctor ID.");
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
