package doctor;

public class Specialist extends Doctor {
    public Specialist(int doctorid, String name, String field) {
        super(doctorid, name, "Specialist in " + field);
    }

    @Override
    public void displayAvailability() {
        System.out.println("Dr. " + getName() + " (Specialist) requires appointment confirmation.");
    }
}
