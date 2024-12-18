import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    // El único atributo que hace especial a la clase Doctor es la especialidad
    private String speciality;

    Doctor(String name, String email) {
        super(name, email);
        System.out.println("El nombre del doctor asignado es: " + name);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Coleciones // clase anidada
    ArrayList<AvailableAppointments> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        // Crear nueva cita
        availableAppointments.add(new AvailableAppointments(date, time));
    }
    // Siquiero devolver los elementos de las citas disponibles
    public ArrayList<AvailableAppointments> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        // Traer los datos de User y añadir especialidad
        return super.toString() + "\nSpeciality: " + speciality +
                "\nAvailable appointments: " + availableAppointments.toString();
    }

    // Clase inner
    public static class AvailableAppointments {
        private int id;
        private Date date;

        public AvailableAppointments(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private String time;

        @Override
        public String toString() {
            return "Available appointments: \nDate: " + date + "\nTime: " + time;
        }
    }

}

