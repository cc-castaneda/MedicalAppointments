package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        // Lógica de opcions para el doctor
        int response = 0;
        // Do While para menus
        do {
            System.out.println("\n \n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.loggedDoctor.getName());
            System.out.println("1. add available appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Add available appointment");
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    System.out.println("::My Scheduled appointments");
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    UIMenu.showMenu();
                    break;
            }

        } while (response != 0);
    }

    private static void showAddAvailableAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("\n \n");
            System.out.println("Add available appointment");
            System.out.println("Select a month");
            System.out.println("0. Return");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response > 1 && response < 4) {
                // Options 1, 2, 3
                int monthSelected = response;
                System.out.println(monthSelected + " selected " + UIMenu.MONTHS[monthSelected-1]);

                System.out.println("Insert the date available: [dd/mm/yyyy]:");
                String date = sc.nextLine();
                System.out.println("Your date is: " + date + "\n1. Correct \n2. Incorrect. Change Date" );
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Incorrect. Change Time" );
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime == 2);

                UIMenu.loggedDoctor.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.loggedDoctor);

            } else if (response == 0) {
                showDoctorMenu();
            }

        } while (response != 0);
    }

    // Otro método para modularizar | delegar responsabilidades
    private static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (!doctor.getAvailableAppointments().isEmpty()
                && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
