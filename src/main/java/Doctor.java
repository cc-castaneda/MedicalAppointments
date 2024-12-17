public class Doctor {
    static int id = 0; // autoincrement
    String name;
    String speciality;

    Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        id++;
    }

    // Comportamiento
    public void showName() {
        System.out.println("Nombre: " + name);
    }

    public void showId() {
        System.out.println("ID: " + id);
    }
}
