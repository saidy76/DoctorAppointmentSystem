package doctor;

import java.io.FileWriter;
import java.io.IOException;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment: " + patient.getName() + " with Dr. " + doctor.getName() + " at " + time;
    }

    public void saveAppointmentToFile() {
        String filename = "appointments.txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(this.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving appointment to file: " + e.getMessage());
        }
    }
}
