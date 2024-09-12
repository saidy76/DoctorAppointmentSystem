package doctor;

import java.io.FileWriter;
import java.io.IOException;

public class Patient {
    private int patientId;
    private String name;
    private String contact;

    public Patient(int patientId, String name, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.contact = contact;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void savePatientToFile() {
        String filename = "patients.txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("ID: " + patientId + ", Name: " + name + ", Contact: " + contact + "\n");
        } catch (IOException e) {
            System.out.println("Error saving patient to file: " + e.getMessage());
        }
    }
}
