package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    // El único atributo que hace especial a la clase model.Doctor es la especialidad
    private String speciality;

    public Doctor(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Coleciones // clase anidada
    ArrayList<AvailableAppointments> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(String date, String time){
        // Crear nueva cita
        availableAppointments.add(new AvailableAppointments(date, time));
    }
    // Siquiero devolver los elementos de las citas disponibles
    public ArrayList<AvailableAppointments> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        // Traer los datos de model.User y añadir especialidad
        return super.toString() + "\nSpeciality: " + speciality +
                "\nAvailable appointments: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Employed Hospital: Cruz Verde");
        System.out.println("Departament: Pediatric");
    }

    // Clase inner
    public static class AvailableAppointments {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointments(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
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

        @Override
        public String toString() {
            return "Available appointments: \nDate: " + date + "\nTime: " + time;
        }
    }

}

