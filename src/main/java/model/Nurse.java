package model;

public class Nurse extends User{
    private String specialty;

    public Nurse(String name, String email) {
        super(name, email);
    }

    // Clases abstractas
    @Override
    public void showDataUser() {
        System.out.println("Employed Hospital: Cruz Verde");
        System.out.println("Departament: Clinical, Nutritional, Pediatric");
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
