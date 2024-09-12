package doctor;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Doctor {
    private int doctorid;
    private String name;
    private String specialization;
    private List<Appointment> appointments;

    public Doctor(int doctorid, String name, String specialization) {
        this.doctorid = doctorid;
        this.name = name;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public int getDoctorId() {
        return doctorid;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        saveAppointmentsToFile();
    }

    public void displayAvailability() {
       
    }

    public void saveAppointmentsToFile() {
        String filename = doctorid + "_appointments.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing appointments to file: " + e.getMessage());
        }
    }
}
