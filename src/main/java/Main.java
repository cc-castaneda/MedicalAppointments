import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        //showMenu();
        Doctor myDoctor = new Doctor("Dr. Camilo", "camilo@mail.com");
        myDoctor.addAvailableAppointment(new Date(), "12:00 pm");
        myDoctor.addAvailableAppointment(new Date(), "01:00 pm");
        myDoctor.addAvailableAppointment(new Date(), "02:00 pm");

        System.out.println(myDoctor);
        // for (Doctor.AvailableAppointments availableAppointment : myDoctor.getAvailableAppointments()) {
        //    System.out.println(availableAppointment.getDate() + " " + availableAppointment.getTime());
        //

        Patient patient = new Patient("Juan", "juan@mail.com");
        // patient.setWeight(70.0);
        // System.out.println(patient.getWeight());
        //
        // patient.setPhoneNumber("12345678");
        // System.out.println(patient.getPhoneNumber());

        // Es como si llamáramos patient.toString() / se llama implícitamente
        System.out.println(patient);

    }
}