package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class UIMenu {

    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    // Declarar variable global estática Doctor logeado
    public static Doctor loggedDoctor;
    public static Patient loggedPatient;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void authUser(int userType) {
        // userType == 1 Doctor
        // userType == 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dra. Maria", "maria@email.com"));
        doctors.add(new Doctor("Dra. Juana", "juana@email.com"));
        doctors.add(new Doctor("Dra. Pepa", "pepa@email.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Saul", "saul@email.com"));
        patients.add(new Patient("Jimena", "jimena@email.com"));
        patients.add(new Patient("Sanda", "sandra@email.com"));

        boolean emailIsCorrect = false;
        do {
            System.out.println("::Authentication");
            System.out.println("Instert your email: [a@b.c]");
            Scanner sc = new Scanner(System.in);
            String emailInput = sc.nextLine();
            if (userType == 1){
                for (Doctor doctor : doctors) {
                    if (doctor.getEmail().equals(emailInput)){
                        emailIsCorrect = true;
                        loggedDoctor = doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2){
                for (Patient patient : patients) {
                    if (patient.getEmail().equals(emailInput)){
                        emailIsCorrect = true;
                        loggedPatient = patient;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!emailIsCorrect);
    }
}
