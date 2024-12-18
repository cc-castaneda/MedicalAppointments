package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.loggedPatient.getName());
            System.out.println("1. Book an appointments");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    showBookAppointmentMenu();
                    break;
                case 2:
                    System.out.println("::My appointments");
                    showPatientMyAppointmentsMenu();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::Book an appointment");
            System.out.println("1. Select a Date: [dd/mm/yyyy]");

            // Mostrar las fechas que los doctores dejaron disponibles
            // Integer(Objeto): Numeración de la lista
            // Segundo Integer: índice de la fecha que seleccione que seleccione el paciente
            // [Doctors]
            // 1. - doctor1
                // - fecha1
            // 2. - doctor2
                // - fecha2
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointments> availableAppointmentsArrayList
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointmentsArrayList.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointmentsArrayList.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointment);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment? \n1. Yes \n2. No, change date");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.loggedPatient.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                System.out.println("Appointment confirmed");
                showPatientMenu();
            }

        } while (response != 0);
    }

    private static void showPatientMyAppointmentsMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::My appointments");
            if (UIMenu.loggedPatient.getAppointmentDoctors().isEmpty()) {
                System.out.println("You don't have any appointments");
                break;
            }
            for (int i = 0; i < UIMenu.loggedPatient.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". Doctor:"
                        + UIMenu.loggedPatient.getAppointmentDoctors().get(i).getDoctor().getName()
                        + "\n. Date: " + UIMenu.loggedPatient.getAppointmentDoctors().get(i).getDate()
                        + "\n. Time: " + UIMenu.loggedPatient.getAppointmentDoctors().get(i).getTime()
                );
            }

            System.out.println("0. Return");
        } while (response != 0);
    }
}
