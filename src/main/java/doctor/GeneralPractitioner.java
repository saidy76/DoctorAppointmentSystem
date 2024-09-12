package doctor;

public class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(int doctorid, String name) {
        super(doctorid, name, "General Practitioner");
    }

    @Override
    public void displayAvailability() {
        System.out.println("Dr. " + getName() + " (General Practitioner) is available for walk-ins.");
    }
}
